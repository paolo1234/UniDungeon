package com.unidungeon.playing.gameobject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    public int worldX;
    public int worldY;
    public boolean solid;
    public Rectangle boxCollider;
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public BufferedImage image;

    public abstract int getWorldX();
    public abstract int getWorldY();
    public abstract BufferedImage getImage();
    public abstract Rectangle getBoxCollider();
    public abstract boolean isSolid();
}


