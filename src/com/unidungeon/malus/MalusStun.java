package com.unidungeon.malus;

import com.unidungeon.entity.Entity;

import java.awt.image.BufferedImage;

public class MalusStun extends Malus{
    private static MalusStun instance;
    final private int turn;

    private MalusStun(){
        this.name="Scoraggiamento";
        this.icone= null;       //Load up the icone
        this.turn=3;
    }

    public static Malus getInstance(){
        if(instance == null){
            instance = new MalusStun();
            return instance;
        }
        return instance;
    }

    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public BufferedImage getIcone(){
        return this.icone;
    }

    public void executeMalusStun(Entity entity){
        entity.setStun();
    }

    public void removeMalusStun(Entity entity){
        entity.setAwake();
    }

    public int getTurn(){
        return this.turn;
    }
}