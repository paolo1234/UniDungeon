package com.unidungeon.intro;

import com.unidungeon.game.Controller;
import com.unidungeon.game.GameFrame;
import com.unidungeon.game.GameStateMachine;
import com.unidungeon.battle.BattleInputManager;

public class IntroController implements Controller{
    private IntroModel model;
    private IntroView view;
    private BattleInputManager inputManager;
    private GameStateMachine gameStateMachine;

    public IntroController() {
        GameFrame gameFrame = GameFrame.getGameFrame();
        this.model = new IntroModel();
        this.view = new IntroView();
        gameFrame.setView(this.view);
        this.gameStateMachine = GameStateMachine.getGameStateMachine();
        this.inputManager = new BattleInputManager();
        this.view.addKeyListener(this.inputManager);
        this.view.requestFocus();
    }

    @Override
    public void update() {

    }
}
