package com.unidungeon.playing;

import com.unidungeon.entity.player.Player;
import com.unidungeon.game.GameView;
import com.unidungeon.game.Wallet;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.Item;
import com.unidungeon.playing.gamemap.GameMapManager;
import com.unidungeon.playing.gameobject.decorazioni.Decorazioni;
import com.unidungeon.playing.gameobject.interagibili.Interagibili;
import com.unidungeon.playing.playingstrategy.PlayingState;
import com.unidungeon.playing.playingstrategy.PlayingStrategy;
import com.unidungeon.playing.tiles.Tile;
import com.unidungeon.utils.TextAlignment;
import com.unidungeon.utils.TextFormat;
import com.unidungeon.utils.TextRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;

public class PlayingView extends GameView {
  // View
  private final int tileSize = 48;
  private final Tile defaultTile = new Tile("/tiles/", "defaultTile.png", false);
  private boolean debug = false;

  private PlayingState playingState;
  private PlayingStrategy playingStrategy;
  private boolean viewReady;
  private Font font;
  private int currentPauseIndex = 0;
  private int currentPlayerIndex = -1;

  // View Data
  private int[][] mapTileNum;
  private Player[] players;
  private Wallet portafoglio;
  private PlayerMoving player;
  private GameMap gameMap;

  public PlayingView(PlayerMoving playerMoving, Wallet portafoglio) {
    super();
    this.portafoglio = portafoglio;
    this.player = playerMoving;
    this.setGameMap(GameMapManager.getInstance().getCurrentGameMap());
    try {
      font =
          Font.createFont(
                  Font.TRUETYPE_FONT,
                  Objects.requireNonNull(getClass().getResource("/fonts/AGOBLINAPPEARS.TTF"))
                      .openStream())
              .deriveFont(12f);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (FontFormatException e) {
      throw new RuntimeException(e);
    }
    setPlayingState(PlayingState.GAME_MAP);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(
        RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    draw(g2);
    g2.setFont(font);
    if (playingStrategy != null) playingStrategy.draw(g2);
  }

  public void draw(Graphics2D g2) {
    drawMapTiles(g2);
    drawDecorations(g2);
    drawInteractables(g2);
    drawPlayer(g2);
  }

  private void drawMapTiles(Graphics2D g2) {
    int worldCol = 0, worldRow = 0;

    while (worldCol < gameMap.getWorldCol() && worldRow < gameMap.getWorldRow()) {
      int tileIndex = mapTileNum[worldCol][worldRow];
      int worldX = worldCol * tileSize;
      int worldY = worldRow * tileSize;
      int screenX = worldX - player.getWorldX() + player.getScreenX();
      int screenY = worldY - player.getWorldY() + player.getScreenY();

      if (worldX + tileSize > player.getWorldX() - player.getScreenX()
          && worldX - tileSize < player.getWorldX() + player.getScreenX()
          && worldY + tileSize > player.getWorldY() - player.getScreenY()
          && worldY - tileSize < player.getWorldY() + player.getScreenY()) {
        Image i;
        try {
          i = gameMap.getTileImage(tileIndex);
        } catch (IndexOutOfBoundsException e) {
          i = defaultTile.image;
        }
        if (tileIndex != 0) g2.drawImage(i, screenX, screenY, null);
      }
      worldCol++;

      if (worldCol == gameMap.getWorldCol()) {
        worldCol = 0;
        worldRow++;
      }
    }
  }

  private void drawDecorations(Graphics2D g2) {
    for (Decorazioni obj : gameMap.getDecoration()) {
      int screenX = obj.worldX - player.getWorldX() + player.getScreenX();
      int screenY = obj.worldY - player.getWorldY() + player.getScreenY();
      if (obj.worldX + 5 * tileSize > player.getWorldX() - player.getScreenX()
          && obj.worldX - tileSize < player.getWorldX() + player.getScreenX()
          && obj.worldY + 5 * tileSize > player.getWorldY() - player.getScreenY()
          && obj.worldY - tileSize < player.getWorldY() + player.getScreenY()) {
        g2.drawImage(obj.image, screenX, screenY, null);
      }
    }
  }

  private void drawInteractables(Graphics2D g2) {
    for (Interagibili obj : gameMap.getInteragibili()) {
      if (obj.getImage() != null) {
        int screenX = obj.worldX - player.getWorldX() + player.getScreenX();
        int screenY = obj.worldY - player.getWorldY() + player.getScreenY();
        if (obj.worldX + 4 * tileSize > player.getWorldX() - player.getScreenX()
            && obj.worldX - tileSize < player.getWorldX() + player.getScreenX()
            && obj.worldY + 4 * tileSize > player.getWorldY() - player.getScreenY()
            && obj.worldY - tileSize < player.getWorldY() + player.getScreenY()) {
          g2.drawImage(obj.getImage(), screenX, screenY, null);
        }
      }
    }
  }

  public void drawPlayer(Graphics2D g2) {
    if (debug) {
      g2.setColor(new Color(0x85FFFFFF, true));
      g2.fillRoundRect(32, 440, 175, 2 * 48, 50, 50);
      g2.setColor(Color.BLACK);
      g2.drawString("(x: " + player.getWorldX() + ", y: " + player.getWorldY() + ")", 38, 10 * 48);
      g2.drawString(
          "col: " + player.getWorldX() / tileSize + " row: " + player.getWorldY() / tileSize,
          38,
          11 * 48 - 24);
    }
    g2.drawImage(player.getImage(), player.getScreenX(), player.getScreenY(), null);
  }

  public void setGameMap(GameMap gameMap) {
    this.gameMap = gameMap;
    this.mapTileNum = gameMap.getLevelTileNumbers();
  }

  public PlayingState getPlayingState() {
    return playingState;
  }

  public void setPlayingState(PlayingState playingState) {
    this.playingState = playingState;
    updatePlayingStrategy();
  }

  public void setPlayerMoving(PlayerMoving playerMoving) {
    this.player = playerMoving;
  }

  public void setPlayersInfo(Player[] players) {
    this.players = players;
  }

  public void setViewReady(boolean viewReady) {
    this.viewReady = viewReady;
  }

  public void setCurrentPauseIndex(int currentPauseIndex) {
    this.currentPauseIndex = currentPauseIndex;
  }

  public void setCurrentPlayerIndex(int currentPlayerIndex) {
    this.currentPlayerIndex = currentPlayerIndex;
  }

  // Strategy
  public void updatePlayingStrategy() {
    this.playingStrategy = new PlayingRoute().buildPlayingStrategy(playingState);
  }

  class PlayingRoute {
    public PlayingStrategy buildPlayingStrategy(PlayingState playingState) {
      switch (playingState) {
        case GAME_MAP -> {
          return new DrawGameMap();
        }
        case PAUSE -> {
          return new PauseStrategy();
        }
      }
      return null;
    }
  }

  class DrawGameMap implements PlayingStrategy {
    BufferedImage moneyImg, menuImg, cKeyImg;

    public DrawGameMap() {
      try {
        moneyImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/money.png")));
        menuImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/UI/menu.png")));
        cKeyImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/UI/C.png")));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void draw(Graphics2D g2) {
      drawUI(g2);
    }

    public void drawUI(Graphics2D g2) {
      drawPlayerInfo(g2);

      g2.setColor(new Color(0x85FFFFFF, true));
      Rectangle mapName = new Rectangle(24, 24, 100, 48);
      g2.fillRoundRect(mapName.x, mapName.y, mapName.width, mapName.height, 50, 50);
      TextRenderer.drawString(
          g2, gameMap.getName(), font, Color.BLACK, mapName, TextAlignment.MIDDLE, TextFormat.NONE);

      g2.setColor(new Color(0x85FFFFFF, true));
      Rectangle money = new Rectangle(647, 24, 80, 48);
      g2.fillRoundRect(money.x, money.y, money.width + 20, money.height, 50, 50);
      TextRenderer.drawString(
          g2,
          String.valueOf(portafoglio.getMoney()),
          font,
          Color.BLACK,
          money,
          TextAlignment.MIDDLE_RIGHT,
          TextFormat.NONE);

      g2.drawImage(moneyImg, money.x, money.y, 48, 48, null);
      Rectangle menu = new Rectangle(667, 488, 80 - 48, 48);
      g2.fillRoundRect(menu.x, menu.y, menu.width + 20, menu.height, 50, 50);
      g2.drawImage(menuImg, menu.x, 488, 48, 48, null);
      g2.drawImage(cKeyImg, menu.x + 30, 514, 16, 16, null);
    }

    private void drawPlayerInfo(Graphics2D g2) {
      if (viewReady && players != null) {
        int offset = 0;
        for (Player p : players) {
          if (p != null) {
            g2.setColor(new Color(0x85FFFFFF, true));
            g2.fillRect(150 + offset, 24, 150, 48);
            g2.setColor(Color.BLACK);
            g2.drawString("HP " + p.getHp() + "/" + p.getMaxHp(), 205 + offset, 42);
            g2.drawString("SP " + p.getSp() + "/" + p.getMaxSp(), 205 + offset, 64);
            if (p.getIcon() != null) {
              g2.drawImage(p.getIcon(), 150 + offset, 24, 48, 48, null);
            }
            offset += 150;
          }
        }
      }
    }
  }

  class PauseStrategy implements PlayingStrategy {
    private Font pauseFont;
    private BufferedImage image, fsx, fdx;

    public PauseStrategy() {
      try {
        fsx = ImageIO.read(Objects.requireNonNull(getClass().getResource("/items/frecciasx.png")));
        fdx = ImageIO.read(Objects.requireNonNull(getClass().getResource("/items/frecciadx.png")));
        image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/lavagna.png")));
        pauseFont =
            Font.createFont(
                    Font.TRUETYPE_FONT,
                    Objects.requireNonNull(getClass().getResource("/fonts/AGOBLINAPPEARS.TTF"))
                        .openStream())
                .deriveFont(12f);
      } catch (IOException | FontFormatException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void draw(Graphics2D g2) {
      List<Item> items = Backpack.getInstance().getBackpack();

      if (image != null) {
        g2.drawImage(image, 4, 0, 768, 576, null);
      }
      g2.setColor(Color.WHITE);
      g2.setStroke(new BasicStroke(3));
      g2.drawRect(132, 23, 90, 90);
      if (items.size() > 0
          && items.get(currentPauseIndex) != null
          && items.get(currentPauseIndex).getImage() != null)
        g2.drawImage(items.get(currentPauseIndex).getImage(), 132, 23, 90, 90, null);
      Rectangle useRect = new Rectangle(132, 112, 90, 32);
      g2.draw(useRect);
      TextRenderer.drawString(
          g2,
          "USA (Z)",
          pauseFont != null ? pauseFont : font,
          new Color(0x00E5FF),
          useRect,
          TextAlignment.MIDDLE,
          TextFormat.NONE);
      Rectangle itemsRect = new Rectangle(104, 163, 465, 261);
      Rectangle descriptionRect = new Rectangle(247, 23, 298, 121);

      Rectangle itemName = new Rectangle(260, 30, 283, 20);
      Rectangle itemDescription = new Rectangle(260, 48, 283, 45);
      Rectangle itemEffect = new Rectangle(260, 102, 283, 30);

      g2.setColor(new Color(0x2E2E2E));
      g2.fill(itemsRect);
      g2.fill(descriptionRect);
      g2.setColor(Color.WHITE);
      g2.draw(itemsRect);
      g2.draw(descriptionRect);

      int x, y, size = 75;
      for (int i = 0; i < Math.min(items.size(), 10); i++) {
        switch (i) {
          case 0 -> {
            x = 133;
            y = 171;
          }
          case 1 -> {
            x = 243;
            y = 171;
          }
          case 2 -> {
            x = 353;
            y = 171;
          }
          case 3 -> {
            x = 463;
            y = 171;
          }
          case 4 -> {
            x = 133;
            y = 256;
          }
          case 5 -> {
            x = 243;
            y = 256;
          }
          case 6 -> {
            x = 353;
            y = 256;
          }
          case 7 -> {
            x = 463;
            y = 256;
          }
          case 8 -> {
            x = 243;
            y = 341;
          }
          case 9 -> {
            x = 353;
            y = 341;
          }
          default -> {
            x = 0;
            y = 0;
          }
        }
        if (items.size() > i && items.get(i) != null && items.get(i).getImage() != null) {
          g2.drawImage(items.get(i).getImage(), x, y, size, size, null);
        }
      }

      g2.setColor((currentPauseIndex == 0) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(133, 171, 75, 75);
      g2.setColor((currentPauseIndex == 1) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(243, 171, 75, 75);
      g2.setColor((currentPauseIndex == 2) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(353, 171, 75, 75);
      g2.setColor((currentPauseIndex == 3) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(463, 171, 75, 75);
      g2.setColor((currentPauseIndex == 4) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(133, 256, 75, 75);
      g2.setColor((currentPauseIndex == 5) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(243, 256, 75, 75);
      g2.setColor((currentPauseIndex == 6) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(353, 256, 75, 75);
      g2.setColor((currentPauseIndex == 7) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(463, 256, 75, 75);
      g2.setColor((currentPauseIndex == 8) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(243, 341, 75, 75);
      g2.setColor((currentPauseIndex == 9) ? new Color(0x00E5FF) : Color.WHITE);
      g2.drawRect(353, 341, 75, 75);

      if (items.size() > 0
          && currentPauseIndex >= 0
          && currentPauseIndex < items.size()
          && items.get(currentPauseIndex) != null) {
        TextRenderer.drawString(
            g2,
            items.get(currentPauseIndex).getName(),
            pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
            new Color(0x00E5FF),
            itemName,
            TextAlignment.MIDDLE,
            TextFormat.NONE);
        TextRenderer.drawString(
            g2,
            items.get(currentPauseIndex).getDescription(),
            new Font(Font.SANS_SERIF, Font.PLAIN, 14),
            new Color(0xFFFFFF),
            itemDescription,
            TextAlignment.TOP_LEFT,
            TextFormat.NONE);
        TextRenderer.drawString(
            g2,
            items.get(currentPauseIndex).getEffect(),
            pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
            new Color(0x1EE80E),
            itemEffect,
            TextAlignment.BOTTOM_LEFT,
            TextFormat.NONE);
      }

      if (currentPlayerIndex != -1
          && players != null
          && currentPlayerIndex >= 0
          && currentPlayerIndex < players.length
          && players[currentPlayerIndex] != null) {
        Rectangle isOk = new Rectangle(333, 130, 103, 23);
        Rectangle name = new Rectangle(371, 172, 103, 23);
        Rectangle hp = new Rectangle(371, 194, 103, 23);
        Rectangle sp = new Rectangle(371, 217, 103, 23);
        Rectangle zKey = new Rectangle(470, 256, 100, 30);

        g2.setColor(Color.BLACK);
        g2.fillRoundRect(198, 115, 373, 185, 20, 20);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(198, 115, 373, 185, 20, 20);

        if (fsx != null) g2.drawImage(fsx, 216, 193, null);
        if (fdx != null) g2.drawImage(fdx, 522, 193, null);

        if (currentPlayerIndex >= 0
            && currentPlayerIndex < 3
            && players[currentPlayerIndex].getIcon() != null) {
          g2.drawImage(players[currentPlayerIndex].getIcon(), 294, 173, 64, 64, null);

          TextRenderer.drawString(
              g2,
              (players[currentPlayerIndex].isKO()) ? "KO" : "Alive",
              pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
              (players[currentPlayerIndex].isKO()) ? new Color(0xE80E0E) : new Color(0x1EE80E),
              isOk,
              TextAlignment.MIDDLE,
              TextFormat.NONE);

          TextRenderer.drawString(
              g2,
              players[currentPlayerIndex].getName(),
              pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
              Color.WHITE,
              name,
              TextAlignment.MIDDLE,
              TextFormat.NONE);
          TextRenderer.drawString(
              g2,
              players[currentPlayerIndex].getHp()
                  + "/"
                  + players[currentPlayerIndex].getMaxHp()
                  + " HP",
              pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
              Color.WHITE,
              hp,
              TextAlignment.MIDDLE,
              TextFormat.NONE);
          TextRenderer.drawString(
              g2,
              players[currentPlayerIndex].getSp()
                  + "/"
                  + players[currentPlayerIndex].getMaxSp()
                  + " SP",
              pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
              Color.WHITE,
              sp,
              TextAlignment.MIDDLE,
              TextFormat.NONE);
        }

        TextRenderer.drawString(
            g2,
            "USA (Z)",
            pauseFont != null ? pauseFont.deriveFont(13f) : font.deriveFont(13f),
            new Color(0x00E5FF),
            zKey,
            TextAlignment.MIDDLE,
            TextFormat.NONE);
      }
    }
  }
}
