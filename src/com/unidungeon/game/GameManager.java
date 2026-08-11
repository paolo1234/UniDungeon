package com.unidungeon.game;

public class GameManager implements Runnable {
  private GameStateMachine gameStateMachine;
  private Thread gameThread;
  private GameRoute gameRoute;
  private final GameFrame gameFrame;
  private Controller controller;
  private final GameModel gameModel;

  public GameManager() {
    this.gameModel = GameModel.getGameModel();
    this.gameFrame = GameFrame.getGameFrame();
    this.gameStateMachine = GameStateMachine.getGameStateMachine(GameState.TITLE);
    this.gameRoute = new GameRoute();
    this.gameThread = new Thread(this);
  }

  @Override
  public void run() {
    while (gameThread != null) {
      controller = gameRoute.buildController(gameStateMachine.getGameState());
      controller.update();
    }
  }

  public void start() {
    gameThread.start();
  }
}
