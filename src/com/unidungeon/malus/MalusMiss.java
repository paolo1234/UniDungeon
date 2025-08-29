package com.unidungeon.malus;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MalusMiss extends Malus{
    private static MalusMiss instance;
    final private int prob_miss;

    private MalusMiss(){
        this.name="Confusione";
        this.icone= null;       //Load up the icone
        this.prob_miss=60;
    }

    public static Malus getInstance(){
        if(instance == null){
            instance = new MalusMiss();
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
    
    //Returns true if the player has missed the attack, otherwise false
    public boolean hasMiss(){
        Random random = new Random();
        if(random.nextInt(100)<this.prob_miss)
            return true;
        else
            return false;
    }
    
    public int getProbMiss(){
        return this.prob_miss;
    }
}