package com.unidungeon.playing.gameobject.interagibili;

import com.unidungeon.game.Badge;
import com.unidungeon.game.GameModel;
import com.unidungeon.game.GameState;
import com.unidungeon.game.GameStateMachine;
import com.unidungeon.playing.gamemap.GameMapManager;
import com.unidungeon.utils.ScaleImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class EndGameTrigger extends Interagibili{
    private GameState gameState;
    private BufferedImage image;
    private Rectangle boxCollider;

    public EndGameTrigger(int worldX, int worldY, boolean solid, Rectangle boxCollider,GameState gameState){
        this.worldX = worldX;
        this.worldY = worldY;
        this.solid = solid;
        this.gameState = gameState;
        this.boxCollider = boxCollider;
    }

    public EndGameTrigger(int worldX, int worldY, boolean solid, Rectangle boxCollider, GameState gameState, String imagePath, int width, int height){
        this.worldX = worldX;
        this.worldY = worldY;
        this.solid = solid;
        this.gameState = gameState;
        this.boxCollider = boxCollider;
        try {
            this.image = ScaleImage.scaleImage(ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath))), width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
    public int getWorldX() {
        return this.worldX;
    }

    @Override
    public int getWorldY() {
        return this.worldY;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public Rectangle getBoxCollider() {
        return boxCollider;
    }

    @Override
    public boolean isSolid() {
        return this.solid;
    }

    @Override
    public void action(){
        if(GameModel.getGameModel().getWallet().getBadges().contains(Badge.SOFTWARE)){
            GameStateMachine gameStateMachine = GameStateMachine.getGameStateMachine();
            //if(gameState == GameState.BATTLE) GameMapManager.getInstance().getCurrentGameMap().getInteragibili().remove(this);
            gameStateMachine.setGameState(GameState.VICTORY);
        }else{
            System.out.println("Non hai ancora ottenuto tutti i badges");
        }
    }
}
