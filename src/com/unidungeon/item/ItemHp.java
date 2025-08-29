package com.unidungeon.item;

import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.Malus;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ItemHp extends Item{
    private int hp;

    public ItemHp(String name, String description, String imagePath,int hp){
        this.name=name;
        this.description=description;
        try {
            if (imagePath != null) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.hp=hp;
    }

    @Override
    public void useItem(Player player){
        if(!player.isKO())
            player.increaseHp(this.hp);
    }

    @Override
    public void useItem(Player player, Malus[] malus, int taget){
        if(!player.isKO())
        player.increaseHp(this.hp);
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
        return "HP +" +this.hp;
    }

    @Override
    public BufferedImage getImage(){
        return this.image;
    }

    public int getHp(){
        return this.hp;
    }
}

