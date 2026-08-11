package com.unidungeon.gameover;

import com.unidungeon.game.*;
import com.unidungeon.playing.PlayingInputManager;
import java.awt.*;

public class GameOverController implements Controller {

  GameStateMachine gameStateMachine;
  GameOverView view;
  PlayingInputManager inputManager;
  SoundManager soundManager;

  public GameOverController() {
    this.soundManager = new SoundManager();
    gameStateMachine = GameStateMachine.getGameStateMachine();
    view = new GameOverView();
    GameFrame gameFrame = GameFrame.getGameFrame();
    gameFrame.changeBackgroundMusic("gameOverMusic");
    gameFrame.setView(view);
    this.inputManager = new PlayingInputManager();
    this.view.addKeyListener(this.inputManager);
    this.view.requestFocus();
  }

  @Override
  public void update() {
    // soundManager.playSE("gameOverMusic");
    double drawInterval = 1000000000f / 60;
    double deltaTime = 0;
    long currentTime;
    long lastTime = System.nanoTime();
    while (gameStateMachine.getGameState() == GameState.GAMEOVER) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (deltaTime >= 1) {
        view.animTick++;
        if (view.animTick >= view.animSpeed) {
          view.animTick = 0;
          view.index++;
          if (view.index > 3) {
            view.index = 0;
          }
        }
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
          GameStateMachine.getGameStateMachine().setGameState(GameState.PLAYING);
          inputManager.setConfirmKeyPressed(false);
        }
        view.repaint();
        deltaTime--;
      }
    }
  }
}
