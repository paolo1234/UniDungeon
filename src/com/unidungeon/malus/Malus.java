package com.unidungeon.malus;

import java.awt.image.BufferedImage;

public abstract class Malus{
    protected String name;
    protected BufferedImage icone;

    public abstract String getName();
    public abstract BufferedImage getIcone();
}