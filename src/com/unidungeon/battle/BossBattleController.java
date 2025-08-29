package com.unidungeon.battle;

import com.unidungeon.entity.mob.*;
import com.unidungeon.game.GameModel;
import com.unidungeon.game.GameState;
import com.unidungeon.game.GameStateMachine;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.ItemIterator;
import com.unidungeon.playing.gamemap.GameMapManager;
import com.unidungeon.playing.gameobject.interagibili.EndGameTrigger;
import com.unidungeon.skill.Skill;

import java.awt.*;
import java.util.NoSuchElementException;

public class BossBattleController extends BattleController{

    //Mediator Component
    private BossBattleModel model;
    private BossBattleView view;

    public BossBattleController(){
        this.gameStateMachine = GameStateMachine.getGameStateMachine();
        this.model= new BossBattleModel(this);
        this.view = new BossBattleView(this);
        this.game = GameModel.getGameModel();
        this.mobs = new Mobs[]{game.getBoss1()};

        if (this.view != null){
            gameFrame.setView(this.view);
            this.view.setViewReady(true);
            this.inputManager = new BattleInputManager();
            this.view.addKeyListener(this.inputManager);
            this.view.requestFocus();
            if(soundOn){
                this.gameFrame.changeBackgroundMusic("bossBattleMusic");
            }else {
                this.gameFrame.stopMusic();
            }
        }
    }

    @Override
    public void battleLoop() {
        //Tell View to draw init info for the players.
        this.view.setPlayerInitValueView(this.game.getPlayers());
        //Initiate battle
        if (this.battle()){
            //Win boss
            this.game.getPlayers()[0].increaseExp(100);
            this.game.getPlayers()[1].increaseExp(150);
            this.game.getPlayers()[2].increaseExp(200);
            this.game.getWallet().addBadge(((Boss)(this.mobs[0])).getBadge());
            GameMapManager.getInstance().getCurrentGameMap().getInteragibili().remove(1);
            for (int i = 0; i < 10; i++){
                GameMapManager.getInstance().getGameMaps().get("Lobby").getDecoration().remove(i);
            }
            GameMapManager.getInstance().getGameMaps().get("Lobby").getInteragibili().add(new EndGameTrigger(2241, 912, true, new Rectangle(0,0,231,204), GameState.VICTORY, "/declobby/porta1.png",231,204));
            System.out.println(this.game.getWallet().getBadges());
            gameStateMachine.setGameState(GameState.PLAYING);
        }else{
            //Lose
            gameStateMachine.setGameState(GameState.GAMEOVER);
        }
    }
    @Override
    public void selectItem(){
        System.out.println("Item");
        ItemIterator itemIterator = new ItemIterator(Backpack.getInstance().getBackpack());
        int currentAction = 0;
        this.view.setItemIndex(0);
        double drawInterval = 1000000000f / 60;
        double deltaTime = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        while (true) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (deltaTime >= 1) {
                if(inputManager.isRightPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setRightPressed(false);
                    currentAction = itemIterator.next();
                    this.view.setItemIndex(currentAction);
                }

                if(inputManager.isLeftPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setLeftPressed(false);
                    if(itemIterator.hasNext()) {
                        currentAction = itemIterator.previous();
                        this.view.setItemIndex(currentAction);
                    }
                }

                if(inputManager.isConfirmPressed()){
                    if(soundOn) {
                        soundManager.playSE("confirmSE");
                    }
                    inputManager.setConfirmPressed(false);
                    this.view.setItemIndex(0);
                    if(!Backpack.getInstance().isEmpty()) {
                    int target = selectItemTarget();
                    if(Backpack.getInstance().getBackpack().size() > 0)
                        Backpack.getInstance().getBackpack()
                                .get(currentAction)
                                .useItem(GameModel.getGameModel().getPlayers()[target]);
                    this.view.setItemIndex(itemIterator.removeItem());
                    }
                    return;
                }
                this.view.repaint();
                deltaTime--;
            }
        }
    }

    @Override
    public int selectItemTarget() {
        int currentAction = 0;
        this.view.setCurrentPlayerIndex(currentAction);
        double drawInterval = 1000000000f / 60;
        double deltaTime = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        while (true) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (deltaTime >= 1) {
                if(inputManager.isLeftPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setLeftPressed(false);
                    if (currentAction == 0){
                        currentAction = 2;
                    }else{
                        currentAction--;
                    }
                    this.view.setCurrentPlayerIndex(currentAction);
                }

                if(inputManager.isRightPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setRightPressed(false);
                    if (currentAction == 2){
                        currentAction = 0;
                    }else{
                        currentAction++;
                    }
                    this.view.setCurrentPlayerIndex(currentAction);
                }

                if(inputManager.isConfirmPressed()){
                    if(soundOn){
                        soundManager.playSE("confirmSE");
                    }
                    inputManager.setConfirmPressed(false);
                    this.view.setCurrentPlayerIndex(-1);
                    return currentAction;
                }

                this.view.repaint();
                deltaTime--;
            }
        }
    }


    public int selectSkill(int length){
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
                if(inputManager.isUpPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setUpPressed(false);
                    if (currentAction == 0){
                        currentAction = length;
                    }else{
                        currentAction--;
                    }
                    this.view.setCurrentAction(currentAction);
                }

                if(inputManager.isDownPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setDownPressed(false);
                    if (currentAction == length){
                        currentAction = 0;
                    }else{
                        currentAction++;
                    }
                    this.view.setCurrentAction(currentAction);

                }

                if(inputManager.isConfirmPressed()){
                    if(soundOn){
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

    @Override
    //Mediator for view and listener
    public int selectPlayerAction(){
        int currentAction = 0;
        this.view.setCurrentAction(currentAction);
        double drawInterval = 1000000000f / 60;
        double deltaTime = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        while ((gameStateMachine.getGameState() == GameState.BOSSBATTLE) && (!(this.game.getPlayers()[0].isKO() && this.game.getPlayers()[1].isKO() && this.game.getPlayers()[2].isKO()) && enemiesAlive)) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (deltaTime >= 1) {
                if(inputManager.isUpPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setUpPressed(false);
                    if (currentAction == 0){
                        currentAction = 3;
                    }else{
                        currentAction--;
                    }
                    this.view.setCurrentAction(currentAction);
                }

                if(inputManager.isDownPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setDownPressed(false);
                    if (currentAction == 3){
                        currentAction = 0;
                    }else{
                        currentAction++;
                    }
                    this.view.setCurrentAction(currentAction);

                }

                if(inputManager.isConfirmPressed()){
                    if(soundOn) {
                        if(currentAction == 1){
                            soundManager.playSE("guardiaSE");
                        }else{
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

    //Mediator for view and listener
    @Override
    public int selectTarget(){
        return 0;
    }

    @Override
    public void update() {
        battleLoop();
    }

    @Override
    //Manage the battle, returns true if win and false if lose
    public boolean battle(){
        enemiesAlive= true;
        while ((gameStateMachine.getGameState() == GameState.BOSSBATTLE) && (!(this.game.getPlayers()[0].isKO() && this.game.getPlayers()[1].isKO() && this.game.getPlayers()[2].isKO()) && enemiesAlive)){
            int[] choice = new int[3];
            Skill[] chosenSkill = new Skill[3];
            int[] target = new int[3];
            //Ask view for the select action.
            if(this.view.selectActionView(this.game.getPlayers(),mobs,choice,chosenSkill,target)){
                this.model.moneyNervous(mobs[0],choice);
            }else {
                //Ask model to execute the action
                this.model.executeBattle(this.game.getPlayers(), this.mobs, Backpack.getInstance(), choice, target, chosenSkill);
            }
            //Check if enemies are still alive
            enemiesAlive=false;
            for(Mobs enemy : this.mobs)
                if(!enemy.isKO()){
                    enemiesAlive=true;
                }
        }
        if(enemiesAlive)
            return false; //Lose
        else
            return true;  //Win
    }

    //Mediator from BossBattleModel to BossBattleView
    public boolean executeQuestion(int questionTurn){
        this.view.setBattleState(BattleState.FASECRITICA);
        AnswerIterator answerIterator = new AnswerIterator(game.getPlayers(), ((Boss)mobs[0]).getQuestions()[questionTurn].getAnswers());
        this.view.setQuestion(((Boss)mobs[0]).getQuestions()[questionTurn]);
        int currentAction = 0;
        try {
            currentAction = answerIterator.first();
        }catch (NoSuchElementException e){
            ((Boss)mobs[0]).wrongRage();
            ((Boss)mobs[0]).wrongRage();
            this.model.examFailed(game.getPlayers(), mobs[0]);
            return false;
        }
        this.view.setQuestionIndex(currentAction);
        double drawInterval = 1000000000f / 60;
        double deltaTime = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        while (true) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (deltaTime >= 1) {
                if(inputManager.isUpPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setUpPressed(false);
                    currentAction = answerIterator.previous();
                    this.view.setQuestionIndex(currentAction);
                }

                if(inputManager.isDownPressed()){
                    if(soundOn){
                        soundManager.playSE("selectSE");
                    }
                    inputManager.setDownPressed(false);
                    currentAction = answerIterator.next();
                    this.view.setQuestionIndex(currentAction);
                }

                if(inputManager.isConfirmPressed()){
                    if(soundOn){
                        soundManager.playSE("confirmSE");
                    }
                    inputManager.setConfirmPressed(false);
                    return this.model.questionPhase(mobs, currentAction);
                }
                this.view.repaint();
                deltaTime--;
            }
        }
    }

}
