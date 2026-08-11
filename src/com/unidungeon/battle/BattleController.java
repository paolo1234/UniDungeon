package com.unidungeon.battle;

import com.unidungeon.entity.mob.Mob;
import com.unidungeon.entity.mob.MobIterator;
import com.unidungeon.entity.mob.Mobs;
import com.unidungeon.game.*;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.ItemIterator;
import com.unidungeon.skill.Skill;
import java.util.List;
import java.util.Random;

public class BattleController implements Controller {

  // Mediator Component
  private BattleModel model;
  private BattleView view;
  protected GameModel game;
  protected BattleInputManager inputManager;

  // Strategy
  protected GameStateMachine gameStateMachine;
  SoundManager soundManager = new SoundManager();
  GameFrame gameFrame = GameFrame.getGameFrame();
  boolean soundOn = true;

  // PrototypeMob
  protected Mobs[] mobs;

  protected boolean enemiesAlive;

  public BattleController() {
    this.gameStateMachine = GameStateMachine.getGameStateMachine();
    this.model = new BattleModel(this);
    this.view = new BattleView(this);
    this.game = GameModel.getGameModel();
    this.mobs = prototypeMob(this.game.getMobs());
    if (this.view != null) {
      gameFrame.setView(this.view);
      this.view.setViewReady(true);
      this.inputManager = new BattleInputManager();
      this.view.addKeyListener(this.inputManager);
      this.view.requestFocus();
      if (soundOn) {
        this.gameFrame.changeBackgroundMusic("battleMusic");
      } else {
        this.gameFrame.stopMusic();
      }
    }
  }

  public void battleLoop() {
    // Tell View to draw init info for the players.
    this.view.setPlayerInitValueView(this.game.getPlayers());
    // Ricompense
    if (this.battle()) {
      if (!this.enemiesAlive) {
        // Win
        if (!this.game.getPlayers()[0].isKO()) {
          this.game.getPlayers()[0].increaseExp(50);
          this.game.getPlayers()[0].increaseHp(30);
          this.game.getPlayers()[0].increaseSp(10);
        }
        if (!this.game.getPlayers()[1].isKO()) {
          this.game.getPlayers()[1].increaseExp(50);
          this.game.getPlayers()[1].increaseHp(30);
          this.game.getPlayers()[1].increaseSp(10);
        }
        if (!this.game.getPlayers()[2].isKO()) {
          this.game.getPlayers()[2].increaseExp(50);
          this.game.getPlayers()[2].increaseHp(30);
          this.game.getPlayers()[2].increaseSp(10);
        }
        this.game.getWallet().encreaseMoney(20);
        if (!Backpack.getInstance().isFull()) {
          Backpack.getInstance().getBackpack().add(this.model.getRandomItem());
        }
      }
      gameStateMachine.setGameState(GameState.PLAYING);
    } else {
      // Lose
      this.game.getWallet().decreaseMoney(50);
      gameStateMachine.setGameState(GameState.GAMEOVER);
    }
  }

  // Mediator for view and listener
  public int selectPlayerAction() {
    int currentAction = 0;
    this.view.setCurrentAction(currentAction);
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while ((gameStateMachine.getGameState() == GameState.BATTLE)
        && (!(this.game.getPlayers()[0].isKO()
                && this.game.getPlayers()[1].isKO()
                && this.game.getPlayers()[2].isKO())
            && enemiesAlive)) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        if (inputManager.isUpPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setUpPressed(false);
          if (currentAction == 0) {
            currentAction = 3;
          } else {
            currentAction--;
          }
          this.view.setCurrentAction(currentAction);
        }

        if (inputManager.isDownPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setDownPressed(false);
          if (currentAction == 3) {
            currentAction = 0;
          } else {
            currentAction++;
          }
          this.view.setCurrentAction(currentAction);
        }

        if (inputManager.isConfirmPressed()) {
          if (soundOn) {
            if (currentAction == 1) {
              soundManager.playSE("guardiaSE");
            } else {
              soundManager.playSE("confirmSE");
            }
          }
          inputManager.setConfirmPressed(false);
          return currentAction;
        }
        this.view.repaint();
        deltaTime--;
      }
    }
    return currentAction;
  }

  // Mediator for view and listener
  public int selectSkill(int length) {
    int currentAction = 0;
    this.view.setCurrentAction(currentAction);
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while (true) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        if (inputManager.isUpPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setUpPressed(false);
          if (currentAction == 0) {
            currentAction = length;
          } else {
            currentAction--;
          }
          this.view.setCurrentAction(currentAction);
        }

        if (inputManager.isDownPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setDownPressed(false);
          if (currentAction == length) {
            currentAction = 0;
          } else {
            currentAction++;
          }
          this.view.setCurrentAction(currentAction);
        }

        if (inputManager.isConfirmPressed()) {
          if (soundOn) {
            soundManager.playSE("confirmSE");
          }
          inputManager.setConfirmPressed(false);
          return currentAction;
        }
        this.view.repaint();
        deltaTime--;
      }
    }
  }

  // Mediator for view and listener
  public int selectTarget() {
    MobIterator mobIterator = new MobIterator(this.mobs);
    int currentAction = mobIterator.first();

    this.view.setEnemyTarget(currentAction);
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while (true) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        if (inputManager.isRightPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setRightPressed(false);
          currentAction = mobIterator.next();
          this.view.setEnemyTarget(currentAction);
        }

        if (inputManager.isLeftPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setLeftPressed(false);
          currentAction = mobIterator.previous();
          this.view.setEnemyTarget(currentAction);
          // long endTime = System.currentTimeMillis() - BattleInputManager.startTime;
          // System.out.println(endTime + "ms");
        }

        if (inputManager.isConfirmPressed()) {
          if (soundOn) {
            soundManager.playSE("confirmSE");
          }
          inputManager.setConfirmPressed(false);
          this.view.setEnemyTarget(-1);
          return currentAction;
        }
        this.view.repaint();
        deltaTime--;
      }
    }
  }

  public void selectItem() {
    ItemIterator itemIterator = new ItemIterator(Backpack.getInstance().getBackpack());
    int currentAction = 0;
    view.setItemIndex(0);
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while (true) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        if (inputManager.isRightPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setRightPressed(false);
          currentAction = itemIterator.next();
          this.view.setItemIndex(currentAction);
        }

        if (inputManager.isLeftPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setLeftPressed(false);
          if (itemIterator.hasNext()) {
            currentAction = itemIterator.previous();
            view.setItemIndex(currentAction);
          }
        }

        if (inputManager.isConfirmPressed()) {
          if (soundOn) {
            soundManager.playSE("confirmSE");
          }
          inputManager.setConfirmPressed(false);
          view.setItemIndex(0);
          if (!Backpack.getInstance().isEmpty()) {
            int target = selectItemTarget();
            if (Backpack.getInstance().getBackpack().size() > 0)
              Backpack.getInstance()
                  .getBackpack()
                  .get(currentAction)
                  .useItem(GameModel.getGameModel().getPlayers()[target]);
            view.setItemIndex(itemIterator.removeItem());
          }
          return;
        }
        this.view.repaint();
        deltaTime--;
      }
    }
  }

  public int selectItemTarget() {
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
        if (inputManager.isLeftPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setLeftPressed(false);
          if (currentAction == 0) {
            currentAction = 2;
          } else {
            currentAction--;
          }
          view.setCurrentPlayerIndex(currentAction);
        }

        if (inputManager.isRightPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setRightPressed(false);
          if (currentAction == 2) {
            currentAction = 0;
          } else {
            currentAction++;
          }
          view.setCurrentPlayerIndex(currentAction);
        }

        if (inputManager.isConfirmPressed()) {
          if (soundOn) {
            soundManager.playSE("confirmSE");
          }
          inputManager.setConfirmPressed(false);
          view.setCurrentPlayerIndex(-1);
          return currentAction;
        }

        view.repaint();
        deltaTime--;
      }
    }
  }

  @Override
  public void update() {
    battleLoop();
  }

  // Manage the battle, returns true if win and false if lose
  public boolean battle() {
    enemiesAlive = true;
    while ((gameStateMachine.getGameState() == GameState.BATTLE)
        && (!(this.game.getPlayers()[0].isKO()
                && this.game.getPlayers()[1].isKO()
                && this.game.getPlayers()[2].isKO())
            && enemiesAlive)) {
      int[] choice = new int[3];
      Skill[] chosenSkill = new Skill[3];
      int[] target = new int[3];
      // Ask view for the select action.
      if (this.view.selectActionView(this.game.getPlayers(), mobs, choice, chosenSkill, target)) {
        this.escape(); // non deve fuggire piu ma soldi
        return true;
      }
      // Ask model to execute the action
      this.model.executeBattle(
          this.game.getPlayers(), this.mobs, Backpack.getInstance(), choice, target, chosenSkill);
      // Check if enemies are still alive
      enemiesAlive = false;
      for (Mobs enemy : this.mobs)
        if (!enemy.isKO()) {
          enemiesAlive = true;
        }
    }
    if (enemiesAlive) return false;
    else return true;
  }

  // Escaping action
  public void escape() {
    if (soundOn) {
      soundManager.stopMusic();
      soundManager.playSE("fugaSE");
    }
    System.out.println("Sei fuggito");
    this.game.getWallet().decreaseMoney(1);
    gameStateMachine.setGameState(GameState.PLAYING);
  }

  private Mob[] prototypeMob(List<Mob> mobs) {
    Random r = new Random(System.nanoTime());
    int numberOfEnemies = r.nextInt(3) + 1;
    Mob[] mob = new Mob[numberOfEnemies];
    switch (numberOfEnemies) {
      case 1 -> {
        mob[0] = mobs.get(r.nextInt(mobs.size())).clone();
      }
      case 2 -> {
        mob[0] = mobs.get(r.nextInt(mobs.size())).clone();
        mob[1] = mobs.get(r.nextInt(mobs.size())).clone();
      }
      case 3 -> {
        mob[0] = mobs.get(r.nextInt(mobs.size())).clone();
        mob[1] = mobs.get(r.nextInt(mobs.size())).clone();
        mob[2] = mobs.get(r.nextInt(mobs.size())).clone();
      }
    }
    return mob;
  }
}
