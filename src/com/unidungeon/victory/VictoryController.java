package com.unidungeon.victory;

import com.unidungeon.game.*;
import com.unidungeon.playing.PlayingInputManager;

public class VictoryController implements Controller {

  GameStateMachine gameStateMachine;
  VictoryView view;
  PlayingInputManager inputManager;
  SoundManager soundManager;

  public VictoryController() {
    this.soundManager = new SoundManager();
    gameStateMachine = GameStateMachine.getGameStateMachine();
    view = new VictoryView();
    GameFrame gameFrame = GameFrame.getGameFrame();
    gameFrame.changeBackgroundMusic("victoryMusic");
    gameFrame.setView(view);
    this.inputManager = new PlayingInputManager();
    this.view.addKeyListener(this.inputManager);
    this.view.requestFocus();
  }

  @Override
  public void update() {
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while (gameStateMachine.getGameState() == GameState.VICTORY) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        if (inputManager.isConfirmKeyPressed()) {
          System.out.println("PREMUTO");
          soundManager.playSE("confirmSE");
          GameModel.getGameModel().getPlayers()[0].increaseHp(10);
          GameModel.getGameModel().getPlayers()[1].increaseHp(10);
          GameModel.getGameModel().getPlayers()[2].increaseHp(10);
          GameModel.getGameModel().getPlayers()[0].setAwake();
          GameModel.getGameModel().getPlayers()[1].setAwake();
          GameModel.getGameModel().getPlayers()[2].setAwake();
          GameModel.getGameModel().getPlayingModel().setCurrentGameMap("Lobby");
          GameStateMachine.getGameStateMachine().setGameState(GameState.TITLE);
          inputManager.setConfirmKeyPressed(false);
        }
        view.repaint();
        deltaTime--;
      }
    }
  }
}
