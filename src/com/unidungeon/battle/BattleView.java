package com.unidungeon.battle;

import com.unidungeon.entity.mob.Mobs;
import com.unidungeon.entity.player.Player;
import com.unidungeon.game.GameView;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.Item;
import com.unidungeon.skill.Skill;
import com.unidungeon.utils.TextAlignment;
import com.unidungeon.utils.TextFormat;
import com.unidungeon.utils.TextRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;

public class BattleView extends GameView {
  private BattleController mediator;

  private BufferedImage sfondo, fdx, fsx;
  private Font font;

  private int currentAction;
  private int target = -1;
  private int itemIndex = 0;
  private int currentPlayerIndex = -1;
  private int playerTurn;
  private boolean attaccaSelected;
  private boolean guardiaSelected;
  private boolean itemSelected;
  private boolean fuggiSelected;

  private int animTick = 0;
  private int animSpeed = 12;
  private int[] yPoints = {340, 368, 340}; // Index player turn
  private int[] yPoints2 = {140, 168, 140}; // Index enemy target
  boolean viewReady;
  private BattleState battleState;

  String[] playerName, currPlayerHP, currPlayerSP, maxPlayerHP, maxPlayerSP, playerLv;
  boolean[] playerKO;
  String[] skillNames;
  String[] skillSP;
  BufferedImage[] playerIcons;
  BufferedImage[] mobImages;
  String[] mobName, currMobHp, maxMobHP, mobLv;

  public BattleView(BattleController mediator) {
    super();
    this.mediator = mediator;
    try {
      sfondo =
          ImageIO.read(
              Objects.requireNonNull(
                  getClass().getResourceAsStream("/battleIcons/definitivo.png")));
      fsx = ImageIO.read(Objects.requireNonNull(getClass().getResource("/items/frecciasx.png")));
      fdx = ImageIO.read(Objects.requireNonNull(getClass().getResource("/items/frecciadx.png")));

      font =
          Font.createFont(
                  Font.TRUETYPE_FONT,
                  Objects.requireNonNull(getClass().getResource("/fonts/AGOBLINAPPEARS.TTF"))
                      .openStream())
              .deriveFont(12f);
      battleState = BattleState.EMPTY;
    } catch (IOException e) {
      e.printStackTrace();
    } catch (FontFormatException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    int numberOfEnemies = 0;

    if (viewReady) {
      g2.setColor(Color.RED);
      g2.drawImage(sfondo, 0, 0, 768, 576, null);

      if (mobName != null) {
        numberOfEnemies = mobName.length;
        drawEnemies(g2, numberOfEnemies);
      }

      if (playerIcons != null) {
        drawPlayerRect(
            g2,
            playerIcons[0],
            playerName[0],
            20,
            currPlayerHP[0],
            maxPlayerHP[0],
            currPlayerSP[0],
            maxPlayerSP[0],
            playerLv[0]);
        drawPlayerRect(
            g2,
            playerIcons[1],
            playerName[1],
            163,
            currPlayerHP[1],
            maxPlayerHP[1],
            currPlayerSP[1],
            maxPlayerSP[1],
            playerLv[1]);
        drawPlayerRect(
            g2,
            playerIcons[2],
            playerName[2],
            306,
            currPlayerHP[2],
            maxPlayerHP[2],
            currPlayerSP[2],
            maxPlayerSP[2],
            playerLv[2]);
      }

      switch (battleState) {
        case EMPTY -> {
          Rectangle action = new Rectangle(449, 349, 300, 212);
          g2.setColor(new Color(0x83CE3E3E, true));
          g2.fill(action);
        }
        case ACTION_SELECTION -> {
          drawActionSelection(g2);
        }
        case SKILL_SELECTION -> {
          if (skillNames != null) drawSkillSelection(g2);
          if (target >= 0) drawEnemyTarget(g2, numberOfEnemies);
        }
        case ITEM_SELECTION -> {
          drawItemSelection(g2);
          if (currentPlayerIndex >= 0) {
            drawTargetItemSelection(g2);
          }
        }
      }
    }
  }

  public void drawItemSelection(Graphics2D g2) {
    Rectangle action = new Rectangle(449, 349, 300, 212);
    g2.setColor(new Color(0x83CE3E3E, true));
    g2.fill(action);
    g2.setStroke(new BasicStroke(2));
    g2.setColor(Color.WHITE);
    g2.drawLine(448, 446, 749, 446);
    g2.setColor(Color.RED);

    int size = 36;
    List<Item> items = Backpack.getInstance().getBackpack();

    int x, y;
    for (int i = 0; i < 10; i++) {
      switch (i) {
        case 0 -> {
          x = 487;
          y = 361;
        }
        case 1 -> {
          x = 534;
          y = 361;
        }
        case 2 -> {
          x = 581;
          y = 361;
        }
        case 3 -> {
          x = 628;
          y = 361;
        }
        case 4 -> {
          x = 675;
          y = 361;
        }
        case 5 -> {
          x = 487;
          y = 400;
        }
        case 6 -> {
          x = 534;
          y = 400;
        }
        case 7 -> {
          x = 581;
          y = 400;
        }
        case 8 -> {
          x = 628;
          y = 400;
        }
        case 9 -> {
          x = 675;
          y = 400;
        }
        default -> {
          x = 0;
          y = 0;
        }
      }
      g2.setColor((itemIndex == i) ? new Color(0xE20000) : Color.WHITE);
      g2.drawRect(x, y, size, size);
      if (items.size() > i) {
        g2.drawImage(items.get(i).getImage(), x, y, size, size, null);
      }
    }

    Rectangle itemName = new Rectangle(520, 449, 220, 22);
    Rectangle itemDescription = new Rectangle(528, 480, 208, 91);
    Rectangle itemEffect = new Rectangle(520, 454, 220, 22);

    Rectangle useRect = new Rectangle(449, 510, 79, 22);
    TextRenderer.drawString(
        g2,
        "USA (Z)",
        font.deriveFont(9f),
        new Color(0x00E5FF),
        useRect,
        TextAlignment.MIDDLE,
        TextFormat.NONE);

    if (items.size() > 0) {
      g2.drawImage(items.get(itemIndex).getImage(), 463, 457, 48, 48, null);
      TextRenderer.drawString(
          g2,
          items.get(itemIndex).getName(),
          font.deriveFont(11f),
          Color.BLACK,
          itemName,
          TextAlignment.TOP,
          TextFormat.NONE);
      TextRenderer.drawString(
          g2,
          items.get(itemIndex).getDescription(),
          new Font(Font.SANS_SERIF, Font.BOLD, Font.TYPE1_FONT).deriveFont(13f),
          new Color(0xFFFFFF),
          itemDescription,
          TextAlignment.TOP_LEFT,
          TextFormat.NONE);
      TextRenderer.drawString(
          g2,
          "(" + items.get(itemIndex).getEffect() + ")",
          font.deriveFont(10f),
          new Color(0x1EE80E),
          itemEffect,
          TextAlignment.BOTTOM,
          TextFormat.NONE);
    }
  }

  public void drawTargetItemSelection(Graphics2D g2) {
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

    g2.drawImage(fsx, 216, 193, null);
    g2.drawImage(fdx, 522, 193, null);

    if (currentPlayerIndex >= 0 && currentPlayerIndex < 3) {
      g2.drawImage(playerIcons[currentPlayerIndex], 294, 173, 64, 64, null);

      TextRenderer.drawString(
          g2,
          (playerKO[currentPlayerIndex]) ? "KO" : "Alive",
          font.deriveFont(13f),
          (playerKO[currentPlayerIndex]) ? new Color(0xE80E0E) : new Color(0x1EE80E),
          isOk,
          TextAlignment.MIDDLE,
          TextFormat.NONE);

      TextRenderer.drawString(
          g2,
          playerName[currentPlayerIndex],
          font.deriveFont(13f),
          Color.WHITE,
          name,
          TextAlignment.MIDDLE,
          TextFormat.NONE);
      TextRenderer.drawString(
          g2,
          currPlayerHP[currentPlayerIndex] + "/" + maxPlayerHP[currentPlayerIndex] + " HP",
          font.deriveFont(13f),
          Color.WHITE,
          hp,
          TextAlignment.MIDDLE,
          TextFormat.NONE);
      TextRenderer.drawString(
          g2,
          currPlayerSP[currentPlayerIndex] + "/" + maxPlayerSP[currentPlayerIndex] + " SP",
          font.deriveFont(13f),
          Color.WHITE,
          sp,
          TextAlignment.MIDDLE,
          TextFormat.NONE);
    }

    TextRenderer.drawString(
        g2,
        "USA (Z)",
        font.deriveFont(13f),
        new Color(0x00E5FF),
        zKey,
        TextAlignment.MIDDLE,
        TextFormat.NONE);
  }

  private void drawEnemies(Graphics2D g2, int numberOfEnemies) {
    Rectangle[] TextHPpos = enemyHpPosition(numberOfEnemies);
    Rectangle[] TextInfoPos = enemyInfoPosition(numberOfEnemies);
    int[] ImageXpos = enemyImageXPosition(numberOfEnemies);

    for (int i = 0; i < numberOfEnemies; i++) {
      g2.drawImage(mobImages[i], ImageXpos[i], 112, 150, 150, null);
      g2.setColor(Color.RED);
      g2.fill(TextHPpos[i]);
      g2.setColor(Color.WHITE);
      g2.fill(TextInfoPos[i]);
      TextRenderer.drawString(
          g2,
          mobName[i],
          font,
          Color.BLACK,
          TextInfoPos[i],
          TextAlignment.MIDDLE_LEFT,
          TextFormat.NONE);
      TextRenderer.drawString(
          g2,
          "LV " + mobLv[i],
          font,
          Color.BLACK,
          TextInfoPos[i],
          TextAlignment.MIDDLE_RIGHT,
          TextFormat.NONE);
      TextRenderer.drawString(
          g2, "HP ", font, Color.BLACK, TextHPpos[i], TextAlignment.MIDDLE_LEFT, TextFormat.NONE);
      TextRenderer.drawString(
          g2,
          currMobHp[i] + "/" + maxMobHP[i],
          font,
          Color.BLACK,
          TextHPpos[i],
          TextAlignment.MIDDLE_RIGHT,
          TextFormat.NONE);
    }
  }

  private int[] enemyImageXPosition(int numberOfEnemies) {
    int[] xPos = new int[numberOfEnemies];
    switch (numberOfEnemies) {
      case 1 -> {
        xPos[0] = 309;
      }
      case 2 -> {
        xPos[0] = 231;
        xPos[1] = 388;
      }
      case 3 -> {
        xPos[0] = 129;
        xPos[1] = 312;
        xPos[2] = 482;
      }
    }
    return xPos;
  }

  private Rectangle[] enemyHpPosition(int numberOfEnemies) {
    Rectangle[] rectangles = new Rectangle[numberOfEnemies];
    switch (numberOfEnemies) {
      case 1 -> {
        rectangles[0] = new Rectangle(316, 294, 136, 28);
      }
      case 2 -> {
        rectangles[0] = new Rectangle(238, 294, 136, 28);
        rectangles[1] = new Rectangle(392, 294, 136, 28);
      }
      case 3 -> {
        rectangles[0] = new Rectangle(142, 294, 136, 28);
        rectangles[1] = new Rectangle(316, 294, 136, 28);
        rectangles[2] = new Rectangle(490, 294, 136, 28);
      }
    }
    return rectangles;
  }

  private Rectangle[] enemyInfoPosition(int numberOfEnemies) {
    Rectangle[] rectangles = new Rectangle[numberOfEnemies];
    switch (numberOfEnemies) {
      case 1 -> {
        rectangles[0] = new Rectangle(316, 266, 136, 28);
      }
      case 2 -> {
        rectangles[0] = new Rectangle(238, 266, 136, 28);
        rectangles[1] = new Rectangle(392, 266, 136, 28);
      }
      case 3 -> {
        rectangles[0] = new Rectangle(142, 266, 136, 28);
        rectangles[1] = new Rectangle(316, 266, 136, 28);
        rectangles[2] = new Rectangle(490, 266, 136, 28);
      }
    }
    return rectangles;
  }

  void drawActionSelection(Graphics2D g2) {
    Rectangle action = new Rectangle(449, 349, 300, 212);
    g2.setColor(new Color(0x83CE3E3E, true));
    g2.fill(action);
    g2.setColor(Color.WHITE);

    switch (currentAction) {
      case 0 -> {
        attaccaSelected = true;
        guardiaSelected = false;
        itemSelected = false;
        fuggiSelected = false;
      }
      case 1 -> {
        attaccaSelected = false;
        guardiaSelected = true;
        itemSelected = false;
        fuggiSelected = false;
      }
      case 2 -> {
        attaccaSelected = false;
        guardiaSelected = false;
        itemSelected = true;
        fuggiSelected = false;
      }
      case 3 -> {
        attaccaSelected = false;
        guardiaSelected = false;
        itemSelected = false;
        fuggiSelected = true;
      }
    }

    // Disegna i quattro rettangoli bianchi
    drawButton(g2, "Attacca", 474, 373, 250, 32, attaccaSelected);
    drawButton(g2, "Guardia", 474, 417, 250, 32, guardiaSelected);
    drawButton(g2, "Item", 474, 461, 250, 32, itemSelected);
    drawButton(g2, "Fuggi", 474, 505, 250, 32, fuggiSelected);

    drawPlayerTurn(g2, playerTurn);
  }

  void drawSkillSelection(Graphics2D g2) {
    Rectangle action = new Rectangle(449, 349, 300, 212);
    g2.setColor(new Color(0x83CE3E3E, true));
    g2.fill(action);
    g2.setColor(Color.WHITE);

    switch (currentAction) {
      case 0 -> {
        attaccaSelected = true;
        guardiaSelected = false;
        itemSelected = false;
        fuggiSelected = false;
      }
      case 1 -> {
        attaccaSelected = false;
        guardiaSelected = true;
        itemSelected = false;
        fuggiSelected = false;
      }
      case 2 -> {
        attaccaSelected = false;
        guardiaSelected = false;
        itemSelected = true;
        fuggiSelected = false;
      }
      case 3 -> {
        attaccaSelected = false;
        guardiaSelected = false;
        itemSelected = false;
        fuggiSelected = true;
      }
    }

    // if(skills[0]!= null)
    drawButton(
        g2,
        (skillNames[0] != null) ? skillNames[0] + " (" + skillSP[0] + " sp)" : "Vuoto",
        474,
        373,
        250,
        32,
        attaccaSelected);
    // if(skills[1]!= null)
    drawButton(
        g2,
        (skillNames[1] != null) ? skillNames[1] + " (" + skillSP[1] + " sp)" : "Vuoto",
        474,
        417,
        250,
        32,
        guardiaSelected);
    // if(skills[2]!= null)
    drawButton(
        g2,
        (skillNames[2] != null) ? skillNames[2] + " (" + skillSP[2] + " sp)" : "Vuoto",
        474,
        461,
        250,
        32,
        itemSelected);
    // if(skills[3]!= null)
    drawButton(
        g2,
        (skillNames[3] != null) ? skillNames[3] + " (" + skillSP[3] + " sp)" : "Vuoto",
        474,
        505,
        250,
        32,
        fuggiSelected);

    // Disegna i quattro rettangoli bianchi

    drawPlayerTurn(g2, playerTurn);
  }

  void drawPlayerTurn(Graphics2D g, int turn) {

    int[] xPoints;
    int nPoints = 3;

    animTick++;
    if (animTick >= animSpeed) {
      animTick = 0;
      yPoints[0] += 1;
      yPoints[1] += 1;
      yPoints[2] += 1;
      if (yPoints[1] >= 372) {
        yPoints[0] = 340;
        yPoints[1] = 368;
        yPoints[2] = 340;
      }
    }

    if (turn == 0) {
      xPoints = new int[] {68, 84, 100}; // 68, (68+100/2), 68 + 32
    } else if (turn == 1) {
      xPoints = new int[] {211, 227, 243};
    } else {
      xPoints = new int[] {354, 370, 386};
    }

    g.setColor(Color.ORANGE);
    g.fillPolygon(xPoints, yPoints, nPoints);

    g.setColor(new Color(0xC73919));
    g.setStroke(new BasicStroke(4));
    g.drawPolygon(xPoints, yPoints, nPoints);
  }

  void drawEnemyTarget(Graphics2D g, int numberOfEnemies) {

    int[] xPoints2 = {0, 0, 0};

    // int[] yPoints = {340, 368, 340};
    int nPoints2 = 3;

    animTick++;
    if (animTick >= animSpeed) {
      animTick = 0;
      yPoints2[0] += 1;
      yPoints2[1] += 1;
      yPoints2[2] += 1;
      if (yPoints2[1] >= 172) {
        yPoints2[0] = 140;
        yPoints2[1] = 168;
        yPoints2[2] = 140;
      }
    }

    switch (numberOfEnemies) {
      case 1 -> {
        if (target == 0) {
          xPoints2 = new int[] {368, 384, 400}; // 368, (368+100/2), 368 + 32
        }
      }
      case 2 -> {
        if (target == 0) {
          xPoints2 = new int[] {289, 305, 321}; // 289, (68+100/2), 321
        } else if (target == 1) {
          xPoints2 = new int[] {447, 463, 479};
        }
      }
      case 3 -> {
        if (target == 0) {
          xPoints2 = new int[] {194, 210, 226}; // 68, (68+100/2), 68 + 32
        } else if (target == 1) {
          xPoints2 = new int[] {368, 384, 400};
        } else if (target == 2) {
          xPoints2 = new int[] {541, 557, 573};
        }
      }
    }

    g.setColor(Color.ORANGE);
    g.fillPolygon(xPoints2, yPoints2, nPoints2);

    g.setColor(new Color(0xC73919));
    g.setStroke(new BasicStroke(4));
    g.drawPolygon(xPoints2, yPoints2, nPoints2);
  }

  void drawButton(
      Graphics2D g, String buttonText, int x, int y, int width, int height, boolean active) {
    if (active) {
      g.setColor(new Color(0xc8a2c8));
    } else {
      g.setColor(Color.WHITE);
    }
    Rectangle actionBtn = new Rectangle(x, y, width, height);
    g.fill(actionBtn);

    TextRenderer.drawString(
        g, buttonText, font, Color.BLACK, actionBtn, TextAlignment.MIDDLE, TextFormat.NONE);

    g.setColor(Color.WHITE);
  }

  void drawPlayerRect(
      Graphics2D g2,
      BufferedImage image,
      String nome,
      int xOffset,
      String currHP,
      String maxHP,
      String currSP,
      String maxSP,
      String liv) {
    int x2 = xOffset;
    int width = 128;
    g2.drawImage(image, x2, 349, 128, 128, null);

    Rectangle rect4 = new Rectangle(x2, 477, width, 28);
    Rectangle rect5 = new Rectangle(x2, 505, width, 28);
    Rectangle rect6 = new Rectangle(x2, 533, width, 28);

    int padding = 2;
    Rectangle rect7 = new Rectangle(x2 + padding, 477, width - 2 * padding, 28);
    Rectangle rect8 = new Rectangle(x2 + padding, 505, width - 2 * padding, 28);
    Rectangle rect9 = new Rectangle(x2 + padding, 533, width - 2 * padding, 28);

    Font font = this.font;

    Color startColor = Color.red;
    Color endColor = Color.blue;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Crea il gradiente per rect4
    GradientPaint gp4 = new GradientPaint(x2, 477, startColor, x2 + width, 477 + 28, endColor);
    // Crea il gradiente per rect5
    GradientPaint gp5 =
        new GradientPaint(x2, 505, new Color(0xCC4115), x2 + width, 505 + 28, new Color(0xE01182));
    // Crea il gradiente per rect6
    GradientPaint gp6 =
        new GradientPaint(x2, 533, new Color(0x4141D2), x2 + width, 533 + 28, new Color(0x0089DE));

    // Disegna i rettangoli con il gradiente
    g2.setPaint(gp4);
    g2.fill(rect4);
    g2.setPaint(gp5);
    g2.fill(rect5);
    g2.setPaint(gp6);
    g2.fill(rect6);

    g2.setColor(Color.WHITE);
    g2.setFont(font);

    TextRenderer.drawString(
        g2, nome, font, Color.WHITE, rect7, TextAlignment.MIDDLE_LEFT, TextFormat.NONE);

    TextRenderer.drawString(
        g2, "LV " + liv, font, Color.WHITE, rect7, TextAlignment.MIDDLE_RIGHT, TextFormat.NONE);

    TextRenderer.drawString(
        g2, "HP", font, Color.WHITE, rect8, TextAlignment.MIDDLE_LEFT, TextFormat.NONE);

    TextRenderer.drawString(
        g2,
        currHP + "/" + maxHP,
        font,
        Color.WHITE,
        rect8,
        TextAlignment.MIDDLE_RIGHT,
        TextFormat.NONE);

    TextRenderer.drawString(
        g2, "SP", font, Color.WHITE, rect9, TextAlignment.MIDDLE_LEFT, TextFormat.NONE);

    TextRenderer.drawString(
        g2,
        currSP + "/" + maxSP,
        font,
        Color.WHITE,
        rect9,
        TextAlignment.MIDDLE_RIGHT,
        TextFormat.NONE);
  }

  // Set players init info
  public void setPlayerInitValueView(Player[] player) {
    // Upgrade player info for the view.
    this.playerName = new String[3];
    this.playerName[0] = player[0].getName();
    this.playerName[1] = player[1].getName();
    this.playerName[2] = player[2].getName();
    this.playerIcons = new BufferedImage[3];
    this.playerIcons[0] = player[0].getIcon();
    this.playerIcons[1] = player[1].getIcon();
    this.playerIcons[2] = player[2].getIcon();
  }

  // Selecting action
  public boolean selectActionView(
      Player[] player, Mobs[] mobs, int[] choice, Skill[] chosenSkill, int[] target) {
    this.updateDataView(player, mobs);
    this.setViewReady(true);
    for (int i = 0; i < 3; i++) {
      if (player[i].isAwake()) {
        boolean correct_choice = false;
        do {
          this.battleState = BattleState.ACTION_SELECTION;
          this.playerTurn = i;
          choice[i] = this.mediator.selectPlayerAction();
          switch (choice[i]) {
            case 0 -> {
              Skill[] slot_skill = player[i].getSlotSkill();
              int l = (int) Arrays.stream(slot_skill).filter(Objects::nonNull).count();
              this.skillNames = new String[4];
              this.skillSP = new String[4];
              for (int s = 0; s < l; s++) {
                this.skillNames[s] = slot_skill[s].getName();
                this.skillSP[s] = String.valueOf(slot_skill[s].getCostSp());
              }
              this.battleState = BattleState.SKILL_SELECTION;

              chosenSkill[i] = player[i].getSlotSkill()[this.mediator.selectSkill(l - 1)];
              if (chosenSkill[i].getCostSp() <= player[i].getSp()) {
                correct_choice = true;
                target[i] = this.mediator.selectTarget();
              }
            }
            case 1 -> {
              correct_choice = true;
            }
            case 2 -> {
              this.battleState = BattleState.ITEM_SELECTION;
              this.mediator.selectItem();
              this.updateDataView(player, mobs);
              correct_choice = true;
            }
            case 3 -> {
              return true;
            }
          }
        } while (!correct_choice);
      } else {
        choice[i] = 4;
      }
    }
    return false;
  }

  // Updating data info
  private void updateDataView(Player[] player, Mobs[] mobs) {
    // Player
    this.currPlayerHP = new String[3];
    this.currPlayerSP = new String[3];
    this.maxPlayerHP = new String[3];
    this.maxPlayerSP = new String[3];
    this.playerLv = new String[3];
    this.playerKO = new boolean[3];

    this.currPlayerHP[0] = String.valueOf(player[0].getHp());
    this.currPlayerHP[1] = String.valueOf(player[1].getHp());
    this.currPlayerHP[2] = String.valueOf(player[2].getHp());

    this.currPlayerSP[0] = String.valueOf(player[0].getSp());
    this.currPlayerSP[1] = String.valueOf(player[1].getSp());
    this.currPlayerSP[2] = String.valueOf(player[2].getSp());

    this.maxPlayerHP[0] = String.valueOf(player[0].getMaxHp());
    this.maxPlayerHP[1] = String.valueOf(player[1].getMaxHp());
    this.maxPlayerHP[2] = String.valueOf(player[2].getMaxHp());

    this.maxPlayerSP[0] = String.valueOf(player[0].getMaxSp());
    this.maxPlayerSP[1] = String.valueOf(player[1].getMaxSp());
    this.maxPlayerSP[2] = String.valueOf(player[2].getMaxSp());

    this.playerLv[0] = String.valueOf(player[0].getLv());
    this.playerLv[1] = String.valueOf(player[1].getLv());
    this.playerLv[2] = String.valueOf(player[2].getLv());

    this.playerKO[0] = player[0].isKO();
    this.playerKO[1] = player[1].isKO();
    this.playerKO[2] = player[2].isKO();

    // Mob
    int numberOfEnemies = mobs.length;

    this.mobImages = new BufferedImage[3];
    this.mobName = new String[numberOfEnemies];
    this.currMobHp = new String[numberOfEnemies];
    this.maxMobHP = new String[numberOfEnemies];
    this.mobLv = new String[numberOfEnemies];

    for (int j = 0; j < numberOfEnemies; j++) {
      this.mobImages[j] = mobs[j].getImage();
      this.mobName[j] = mobs[j].getName();
      this.currMobHp[j] = String.valueOf(mobs[j].getHp());
      this.maxMobHP[j] = String.valueOf(mobs[j].getMaxHp());
      this.mobLv[j] = String.valueOf(mobs[j].getLv());
    }
  }

  public void setCurrentAction(int currentAction) {
    this.currentAction = currentAction;
  }

  public void setViewReady(boolean viewReady) {
    this.viewReady = viewReady;
  }

  public void setEnemyTarget(int enemyTarget) {
    this.target = enemyTarget;
  }

  public void setItemIndex(int itemIndex) {
    this.itemIndex = itemIndex;
  }

  public void setCurrentPlayerIndex(int currentPlayerIndex) {
    this.currentPlayerIndex = currentPlayerIndex;
  }
}
