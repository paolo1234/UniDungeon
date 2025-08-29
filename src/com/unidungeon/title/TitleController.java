package com.unidungeon.title;

import com.unidungeon.battle.BattleInputManager;
import com.unidungeon.game.*;

public class TitleController implements Controller {
  // Components Mediator
  private TitleModel model;
  private TitleView view;
  private BattleInputManager inputManager;

  // Strategy
  private GameStateMachine gameStateMachine;
  private int currentAction = 0;
  private SoundManager soundManager;
  private boolean soundOn = true;
  private GameModel gameModel;

  public TitleController() {
    this.model = new TitleModel(this);
    this.view = new TitleView(this);
    this.inputManager = new BattleInputManager();

    this.soundManager = new SoundManager();
    GameFrame gameFrame = GameFrame.getGameFrame();
    gameFrame.setView(this.view);
    this.gameStateMachine = GameStateMachine.getGameStateMachine();
    this.view.addKeyListener(this.inputManager);
    gameFrame.changeBackgroundMusic("titleMusic");
    this.view.requestFocus();
  }

  @Override
  public void update() {
    while (gameStateMachine.getGameState() == GameState.TITLE) {
      int action = selectAction();
      switch (action) {
        case 0 -> {
          this.gameModel = GameModel.getGameModel(false);
          gameStateMachine.setGameState(GameState.PLAYING);
        }
        case 1 -> {
          this.gameModel = GameModel.getGameModel(true);
          gameStateMachine.setGameState(GameState.PLAYING);
        }
        case 2 -> {
          System.exit(0);
        }
      }
    }
    view.setCurrentAction(0);
  }

  public int selectAction() {
    view.setCurrentAction(currentAction);
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while ((gameStateMachine.getGameState() == GameState.TITLE)) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        view.animTick++;
        if (view.animTick >= view.animSpeed) {
          view.animTick = 0;
          view.index++;
          if (view.index > 33) {
            view.index = 0;
          }
        }
        if (inputManager.isUpPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setUpPressed(false);
          if (currentAction == 0) {
            currentAction = 2;
          } else {
            currentAction--;
          }
          view.setCurrentAction(currentAction);
        }

        if (inputManager.isDownPressed()) {
          if (soundOn) {
            soundManager.playSE("selectSE");
          }
          inputManager.setDownPressed(false);
          if (currentAction == 2) {
            currentAction = 0;
          } else {
            currentAction++;
          }
          view.setCurrentAction(currentAction);
        }

        if (inputManager.isConfirmPressed()) {
          if (soundOn) {
            soundManager.playSE("confirmSE");
          }
          inputManager.setConfirmPressed(false);
          return currentAction;
        }
        view.repaint();
        deltaTime--;
      }
    }
    return currentAction;
  }
}
