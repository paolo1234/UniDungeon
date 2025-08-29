package com.unidungeon.item;

import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.Malus;

import java.awt.image.BufferedImage;

public abstract class Item{
    protected String name;
    protected String description;
    protected BufferedImage image;

    public abstract void useItem(Player player);
    public abstract void useItem(Player player, Malus[] malus, int target);
    public abstract String getName();
    public abstract String getDescription();
    public abstract String getEffect();
    public abstract BufferedImage getImage();
}