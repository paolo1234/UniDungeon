package com.unidungeon.item;

import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.Malus;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ItemRevive extends Item{
    private int hp_p;                 //Percentual of Hp regenerated

    public ItemRevive(String name, String description, String imagePath,int hp_p){
        this.name=name;
        this.description=description;
        try {
            if (imagePath != null) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.hp_p=hp_p;
    }

    @Override
    public void useItem(Player player){
        if(player.isKO()){
            player.setAwake();
        }
        player.increaseHp((int)((player.getMaxHp())*this.hp_p)/100);
        //player.increaseHp((int)((player.getMaxHp())*this.hp_p));
    }

    @Override
    public void useItem(Player player, Malus[] malus, int taget){
        if(player.isKO()){
            player.setAwake();
        }
        player.increaseHp((int)((player.getMaxHp())*this.hp_p)/100);
    }


    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public String getEffect() {
        return "Rivive con " +this.hp_p + " HP";
    }

    @Override
    public BufferedImage getImage(){
        return this.image;
    }

    public int getHpP(){
        return this.hp_p;
    }
}

