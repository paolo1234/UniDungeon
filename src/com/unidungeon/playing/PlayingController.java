package com.unidungeon.playing;

import com.unidungeon.game.*;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.ItemIterator;
import com.unidungeon.playing.gamemap.GameMapManager;
import com.unidungeon.playing.gameobject.decorazioni.Decorazioni;
import com.unidungeon.playing.gameobject.interagibili.Interagibili;
import com.unidungeon.playing.playingstrategy.PlayingState;
import com.unidungeon.playing.tiles.TileManager;
import java.util.List;

public class PlayingController implements Controller {
  private PlayingModel model;
  PlayerMoving playerMoving;
  private PlayingView view;
  private PlayingInputManager inputManager;
  private GameStateMachine gameStateMachine;
  private int currentAction = 0;
  private boolean pause;
  SoundManager soundManager = new SoundManager();
  GameModel gameModel;
  ItemIterator itemIterator;

  boolean soundOn = true;

  public PlayingController() {
    GameFrame gameFrame = GameFrame.getGameFrame();
    gameModel = GameModel.getGameModel();
    this.view =
        new PlayingView(gameModel.getPlayingModel().getPlayerMoving(), gameModel.getWallet());
    gameFrame.setView(view);
    this.model = gameModel.getPlayingModel();
    this.playerMoving = model.getPlayerMoving();
    this.view.setPlayerMoving(playerMoving);
    this.gameStateMachine = GameStateMachine.getGameStateMachine();
    this.inputManager = new PlayingInputManager();
    this.view.setPlayersInfo(model.players);
    this.view.setViewReady(true);
    this.view.addKeyListener(this.inputManager);
    this.view.requestFocus();
    this.itemIterator = new ItemIterator(Backpack.getInstance().getBackpack());
    if (soundOn) {
      gameFrame.changeBackgroundMusic(model.getCurrentGameMap().getSoundKey());
    }
  }

  public void checkTile(PlayerMoving entity) {
    int entityLeftWorldX = entity.getWorldX() + entity.boxCollider.x;
    int entityRightWorldX = entity.getWorldX() + entity.boxCollider.x + entity.boxCollider.width;
    int entityTopWorldY = entity.getWorldY() + entity.boxCollider.y;
    int entityBottomWorldY = entity.getWorldY() + entity.boxCollider.y + entity.boxCollider.height;

    int entityLeftCol = entityLeftWorldX / 48;
    int entityRightCol = entityRightWorldX / 48;
    int entityTopRow = entityTopWorldY / 48;
    int entityBottomRow = entityBottomWorldY / 48;

    int tileNum1, tileNum2; // caselle con cui sto collidendo (possono essere due)

    try {
      switch (entity.getDirection()) {
        case UP -> {
          entityTopRow =
              (entityTopWorldY - entity.getSpeed())
                  / 48; // prediciamo dove sarà il player in che tile
          tileNum1 = this.model.currentGameMap.levelTileNumbers[entityLeftCol][entityTopRow];
          tileNum2 = this.model.currentGameMap.levelTileNumbers[entityRightCol][entityTopRow];
          if (TileManager.getTile(tileNum1).isSolid() || TileManager.getTile(tileNum2).isSolid()) {
            entity.collisionOn = true;
          }
        }
        case DOWN -> {
          entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / 48;
          tileNum1 = this.model.currentGameMap.levelTileNumbers[entityLeftCol][entityBottomRow];
          tileNum2 = this.model.currentGameMap.levelTileNumbers[entityRightCol][entityBottomRow];
          if (TileManager.getTile(tileNum1).isSolid() || TileManager.getTile(tileNum2).isSolid()) {
            entity.collisionOn = true;
          }
        }
        case LEFT -> {
          entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / 48;
          tileNum1 = this.model.currentGameMap.levelTileNumbers[entityLeftCol][entityTopRow];
          tileNum2 = this.model.currentGameMap.levelTileNumbers[entityLeftCol][entityBottomRow];
          if (TileManager.getTile(tileNum1).isSolid() || TileManager.getTile(tileNum2).isSolid()) {
            entity.collisionOn = true;
          }
        }
        case RIGHT -> {
          entityRightCol = (entityRightWorldX + entity.getSpeed()) / 48;
          tileNum1 = this.model.currentGameMap.levelTileNumbers[entityRightCol][entityTopRow];
          tileNum2 = this.model.currentGameMap.levelTileNumbers[entityRightCol][entityBottomRow];
          if (TileManager.getTile(tileNum1).isSolid() || TileManager.getTile(tileNum2).isSolid()) {
            entity.collisionOn = true;
          }
        }
      }
    } catch (IndexOutOfBoundsException e) {
      entity.collisionOn = false;
    }
  }

  public int checkObject(PlayerMoving entity, boolean player) {
    int index = 999;
    List<Interagibili> items = model.getCurrentGameMap().getInteragibili();
    if (items != null) {
      for (int i = 0; i < model.getCurrentGameMap().getInteragibili().size(); i++) {
        if (items.get(i) != null && items.get(i).isSolid()) {
          // collider area entity
          entity.boxCollider.x = entity.getWorldX() + entity.boxCollider.x;
          entity.boxCollider.y = entity.getWorldY() + entity.boxCollider.y;
          // collider area item
          items.get(i).getBoxCollider().x = items.get(i).worldX + items.get(i).getBoxCollider().x;
          items.get(i).getBoxCollider().y = items.get(i).worldY + items.get(i).getBoxCollider().y;
          switch (entity.getDirection()) {
            case UP -> {
              entity.boxCollider.y -= entity.getSpeed();
              if (entity.boxCollider.intersects(items.get(i).getBoxCollider())) {
                if (items.get(i).isSolid()) {
                  entity.collisionOn = true;
                }
                if (player) {
                  index = i;
                }
              }
            }
            case DOWN -> {
              entity.boxCollider.y += entity.getSpeed();
              if (entity.boxCollider.intersects(items.get(i).getBoxCollider())) {
                if (items.get(i).isSolid()) {
                  entity.collisionOn = true;
                }
                if (player) {
                  index = i;
                }
              }
            }
            case LEFT -> {
              entity.boxCollider.x -= entity.getSpeed();
              if (entity.boxCollider.intersects(items.get(i).getBoxCollider())) {
                if (items.get(i).isSolid()) {
                  entity.collisionOn = true;
                }
                if (player) {
                  index = i;
                }
              }
            }
            case RIGHT -> {
              entity.boxCollider.x += entity.getSpeed();
              if (entity.boxCollider.intersects(items.get(i).getBoxCollider())) {
                if (items.get(i).isSolid()) {
                  entity.collisionOn = true;
                }
                if (player) {
                  index = i;
                }
              }
            }
          }
          entity.boxCollider.x = entity.solidAreaDefaultX;
          entity.boxCollider.y = entity.solidAreaDefaultY;
          items.get(i).getBoxCollider().x = items.get(i).solidAreaDefaultX;
          items.get(i).getBoxCollider().y = items.get(i).solidAreaDefaultY;
        }
      }
    }
    return index;
  }

  public int checkDecorationObject(PlayerMoving entity, boolean player) {
    int index = 999;
    List<Decorazioni> items = model.getCurrentGameMap().getDecoration();
    for (int i = 0; i < model.getCurrentGameMap().getDecoration().size(); i++) {
      if (items.get(i) != null) {
        // collider area entity
        entity.boxCollider.x = entity.getWorldX() + entity.boxCollider.x;
        entity.boxCollider.y = entity.getWorldY() + entity.boxCollider.y;
        // collider area item
        items.get(i).boxCollider.x = items.get(i).worldX + items.get(i).boxCollider.x;
        items.get(i).boxCollider.y = items.get(i).worldY + items.get(i).boxCollider.y;
        switch (entity.getDirection()) {
          case UP -> {
            entity.boxCollider.y -= entity.getSpeed();
            if (entity.boxCollider.intersects(items.get(i).boxCollider)) {
              if (items.get(i).collision) {
                entity.collisionOn = true;
              }
              if (player) {
                index = i;
              }
            }
          }
          case DOWN -> {
            entity.boxCollider.y += entity.getSpeed();
            if (entity.boxCollider.intersects(items.get(i).boxCollider)) {
              if (items.get(i).collision) {
                entity.collisionOn = true;
              }
              if (player) {
                index = i;
              }
            }
          }
          case LEFT -> {
            entity.boxCollider.x -= entity.getSpeed();
            if (entity.boxCollider.intersects(items.get(i).boxCollider)) {
              if (items.get(i).collision) {
                entity.collisionOn = true;
              }
              if (player) {
                index = i;
              }
            }
          }
          case RIGHT -> {
            entity.boxCollider.x += entity.getSpeed();
            if (entity.boxCollider.intersects(items.get(i).boxCollider)) {
              if (items.get(i).collision) {
                entity.collisionOn = true;
              }
              if (player) {
                index = i;
              }
            }
          }
        }
        entity.boxCollider.x = entity.solidAreaDefaultX;
        entity.boxCollider.y = entity.solidAreaDefaultY;
        items.get(i).boxCollider.x = items.get(i).solidAreaDefaultX;
        items.get(i).boxCollider.y = items.get(i).solidAreaDefaultY;
      }
    }

    return index;
  }

  @Override
  public void update() {
    while (gameStateMachine.getGameState() == GameState.PLAYING) {
      double drawInterval = 1000000000f / 60;
      double deltaTime = 0;
      // long timer = 0L;
      // int drawCount = 0;
      long lastTime = System.nanoTime();
      long currentTime;
      while (gameStateMachine.getGameState() == GameState.PLAYING) {
        view.setGameMap(GameMapManager.getInstance().getCurrentGameMap());
        currentTime = System.nanoTime();
        deltaTime += (currentTime - lastTime) / drawInterval;
        // timer+=(currentTime - lastTime);
        lastTime = currentTime;
        if (deltaTime >= 1) {
          if (!pause) {
            if (inputManager.anyMovingKeyIsPressed() && !pause) {
              if (inputManager.isUpKeyPressed()) {
                playerMoving.setDirection(Direction.UP);
              }
              if (inputManager.isLeftKeyPressed()) {
                playerMoving.setDirection(Direction.LEFT);
              }
              if (inputManager.isRightKeyPressed()) {
                playerMoving.setDirection(Direction.RIGHT);
              }
              if (inputManager.isDownKeyPressed()) {
                playerMoving.setDirection(Direction.DOWN);
              }
              playerMoving.collisionOn = false;
              checkTile(playerMoving);
              int obj = checkObject(playerMoving, true);
              if (obj < 999) {
                Interagibili interagibili = model.getCurrentGameMap().getInteragibili().get(obj);
                interagibili.action();
              }

              int decorationObject = checkDecorationObject(playerMoving, true);

              playerMoving.updatePosition();
              playerMoving.setMovingAnim();
            } else {
              playerMoving.setIdleAnim();
            }
            if (inputManager.isConfirmKeyPressed()) {
              inputManager.setConfirmKeyPressed(false);
            }
          } else {
            if (inputManager.isLeftKeyPressed()) {
              if (soundOn) {
                soundManager.playSE("selectSE");
              }
              inputManager.setLeftKeyPressed(false);
              if (itemIterator.hasNext()) {
                currentAction = itemIterator.previous();
                view.setCurrentPauseIndex(currentAction);
              }
            }

            if (inputManager.isRightKeyPressed()) {
              if (soundOn) {
                soundManager.playSE("selectSE");
              }
              inputManager.setRightKeyPressed(false);
              if (itemIterator.hasNext()) {
                currentAction = itemIterator.next();
                view.setCurrentPauseIndex(currentAction);
              }
            }

            if (inputManager.isConfirmKeyPressed() && pause) {
              if (soundOn) {
                soundManager.playSE("confirmSE");
              }
              inputManager.setConfirmKeyPressed(false);
              view.setCurrentPlayerIndex(-1);
              if (!Backpack.getInstance().isEmpty()) {
                int target = selectItemTarget();
                if (pause) {
                  Backpack.getInstance()
                      .getBackpack()
                      .get(currentAction)
                      .useItem(GameModel.getGameModel().getPlayers()[target]);
                  view.setCurrentPauseIndex(itemIterator.removeItem());
                }
              }
            }
          }

          checkPauseState();

          view.repaint();
          deltaTime--;
          // ++drawCount;
        }
        /*
        if (timer >= 1000000000L) {
            System.out.printf(String.valueOf(drawCount) + " FPS");
            drawCount = 0;
            timer = 0L;
        }
        */

      }
    }
  }

  private boolean checkPauseState() {
    if (inputManager.isMenuKeyPressed() && !pause) {
      inputManager.setMenuKeyPressed(false);
      if (soundOn) {
        soundManager.playSE("menuInSE");
      }
      view.setPlayingState(PlayingState.PAUSE);
      pause = true;
      currentAction = 0;
      view.setCurrentPauseIndex(currentAction);
      view.setCurrentPlayerIndex(-1);
      itemIterator.resetIterator();
    } else if (inputManager.isMenuKeyPressed() && pause) {
      inputManager.setMenuKeyPressed(false);
      if (soundOn) {
        soundManager.playSE("menuOutSE");
      }
      view.setPlayingState(PlayingState.GAME_MAP);
      pause = false;
      currentAction = 0;
      view.setCurrentPlayerIndex(-1);
      view.setCurrentPauseIndex(currentAction);
    }
    return pause;
  }

  private int selectItemTarget() {
    int currentAction = 0;
    view.setCurrentPlayerIndex(currentAction);
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while (true) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        if (inputManager.isLeftKeyPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setLeftKeyPressed(false);
          if (currentAction == 0) {
            currentAction = 2;
          } else {
            currentAction--;
          }
          view.setCurrentPlayerIndex(currentAction);
        }

        if (inputManager.isRightKeyPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setRightKeyPressed(false);
          if (currentAction == 2) {
            currentAction = 0;
          } else {
            currentAction++;
          }
          view.setCurrentPlayerIndex(currentAction);
        }

        if (!checkPauseState()) {
          return currentAction;
        }

        if (inputManager.isConfirmKeyPressed()) {
          if (soundOn) {
            soundManager.playSE("confirmSE");
          }
          inputManager.setConfirmKeyPressed(false);
          view.setCurrentPlayerIndex(-1);
          return currentAction;
        }

        view.repaint();
        deltaTime--;
      }
    }
  }
}
