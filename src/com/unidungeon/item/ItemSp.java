package com.unidungeon.item;

import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.Malus;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ItemSp extends Item{
    private int sp;

    public ItemSp(String name, String description, String imagePath,int sp){
        this.name=name;
        this.description=description;
        try {
            if (imagePath != null) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sp=sp;
    }

    @Override
    public void useItem(Player player){
        if(!player.isKO()){
            player.increaseSp(this.sp);
        }
    }

    @Override
    public void useItem(Player player, Malus[] malus, int taget){
        if(!player.isKO())
            player.increaseSp(this.sp);
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
        return "SP +" +this.sp;
    }

    @Override
    public BufferedImage getImage(){
        return this.image;
    }
    public int getSp(){
        return this.sp;
    }
}

