package com.unidungeon.game;

public class GameStateMachine {
    private static GameStateMachine gameStateMachine;
    private GameState gameState;

    private GameStateMachine(){}

    public static GameStateMachine getGameStateMachine(GameState defaultGameState){
        if (gameStateMachine == null){
            gameStateMachine = new GameStateMachine();
            gameStateMachine.setGameState(defaultGameState);
        }
        return gameStateMachine;
    }

    public static GameStateMachine getGameStateMachine(){
        if (gameStateMachine == null){
            gameStateMachine = new GameStateMachine();
        }
        return gameStateMachine;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

}