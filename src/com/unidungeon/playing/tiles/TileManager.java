package com.unidungeon.playing.tiles;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TileManager {
    private static List<Tile> tiles = new ArrayList<>();

    public static void tilesInit(){
        tiles.add(new Tile("/tiles/","black.png", false));
        tiles.add(new Tile("/tiles/","tile1.png", false));
        tiles.add(new Tile("/tiles/","tilealt.png", false));
        tiles.add(new Tile("/tiles/","tilealtshadowsx.png", false));
        tiles.add(new Tile("/tiles/","tilealtshadowup.png", false));
        tiles.add(new Tile("/tiles/","tilealtshadowupsx.png", false));
        tiles.add(new Tile("/tiles/","tileshadowcornersx.png", false));
        tiles.add(new Tile("/tiles/","tileshadowlilcorner.png", false));
        tiles.add(new Tile("/tiles/","tileshadowsx.png", false));
        tiles.add(new Tile("/tiles/","tileshadowup.png", false));
        tiles.add(new Tile("/tiles/","tile2.png", true));
        tiles.add(new Tile("/tiles/","tile3.png", true));
        tiles.add(new Tile("/tiles/","tile4.png", true));
        tiles.add(new Tile("/tiles/","cornerdowndx.png", true));
        tiles.add(new Tile("/tiles/","cornerdownsx.png", true));
        tiles.add(new Tile("/tiles/","cornerupdx.png", true));
        tiles.add(new Tile("/tiles/","cornerupsx.png", true));
        tiles.add(new Tile("/tiles/","edgedx.png", true));
        tiles.add(new Tile("/tiles/","edgesx.png", true));
        tiles.add(new Tile("/tiles/","edgeupdx.png", true));
        tiles.add(new Tile("/tiles/","edgleupsx.png", true));
        tiles.add(new Tile("/tiles/","tiledown.png", true));
        tiles.add(new Tile("/tiles/","tiledx.png", true));
        tiles.add(new Tile("/tiles/","tileenddx.png", true));
        tiles.add(new Tile("/tiles/","TILESOPRA.png", true));
        tiles.add(new Tile("/tiles/","TILESOTTO.png", true));
        tiles.add(new Tile("/tiles/","tilesx.png", true));
        tiles.add(new Tile("/tiles/boss1/","1.png", true));  //27
        tiles.add(new Tile("/tiles/boss1/","2.png", true));  //28
        tiles.add(new Tile("/tiles/boss1/","3.png", true));  //29
        tiles.add(new Tile("/tiles/boss1/","4.png", true));  //30
        tiles.add(new Tile("/tiles/boss1/","5.png", true));  //31
        tiles.add(new Tile("/tiles/boss1/","6.png", true));  //32
        tiles.add(new Tile("/tiles/boss1/","7.png", true));  //33
        tiles.add(new Tile("/tiles/boss1/","8.png", true));  //34
        tiles.add(new Tile("/tiles/boss1/","9.png", true));  //35
        tiles.add(new Tile("/tiles/boss1/","10.png", true)); //36
        tiles.add(new Tile("/tiles/boss1/","11.png", true)); //37
        tiles.add(new Tile("/tiles/boss1/","12.png", true)); //38
        tiles.add(new Tile("/tiles/boss1/","13.png", true)); //39
        tiles.add(new Tile("/tiles/boss1/","14.png", true)); //40
        tiles.add(new Tile("/tiles/boss1/","15.png", true)); //41
        tiles.add(new Tile("/tiles/boss1/","16.png", true)); //42
        tiles.add(new Tile("/tiles/boss1/","17.png", true)); //43
        tiles.add(new Tile("/tiles/boss1/","18.png", true)); //44
        tiles.add(new Tile("/tiles/boss1/","19.png", false)); //45
        tiles.add(new Tile("/tiles/boss1/","20.png", false)); //46
        tiles.add(new Tile("/tiles/boss1/","21.png", false)); //47
        tiles.add(new Tile("/tiles/boss1/","22.png", false)); //48
        tiles.add(new Tile("/tiles/boss1/","23.png", true)); //49
        tiles.add(new Tile("/tiles/lobby/","50.png", true));
        tiles.add(new Tile("/tiles/lobby/","51.png", true));
        tiles.add(new Tile("/tiles/lobby/","52.png", true));
        tiles.add(new Tile("/tiles/lobby/","53.png", true));
        tiles.add(new Tile("/tiles/lobby/","54.png", true));
        tiles.add(new Tile("/tiles/lobby/","55.png", true));
        tiles.add(new Tile("/tiles/lobby/","56.png", true));
        tiles.add(new Tile("/tiles/lobby/","57.png", true));
        tiles.add(new Tile("/tiles/lobby/","58.png", true));
        tiles.add(new Tile("/tiles/lobby/","59.png", true));
        tiles.add(new Tile("/tiles/lobby/","60.png", true));
        tiles.add(new Tile("/tiles/lobby/","61.png", true));
        tiles.add(new Tile("/tiles/lobby/","62.png", false));
        tiles.add(new Tile("/tiles/lobby/","63.png", false));
        tiles.add(new Tile("/tiles/lobby/","64.png", false));
        tiles.add(new Tile("/tiles/lobby/","65.png", false));
        tiles.add(new Tile("/tiles/lobby/","66.png", true));
        tiles.add(new Tile("/tiles/lobby/","67.png", true));
        tiles.add(new Tile("/tiles/lobby/","68.png", true));
        tiles.add(new Tile("/tiles/lobby/","69.png", true));
    }

    /*
    public static void bossTilesInit(){
        tiles.add(new Tile("/tiles/","black.png", false));
        tiles.add(new Tile("/tiles/boss1/","1.png", true));
        tiles.add(new Tile("/tiles/boss1/","2.png", true));
        tiles.add(new Tile("/tiles/boss1/","3.png", true));
        tiles.add(new Tile("/tiles/boss1/","4.png", true));
        tiles.add(new Tile("/tiles/boss1/","5.png", true));
        tiles.add(new Tile("/tiles/boss1/","6.png", true));
        tiles.add(new Tile("/tiles/boss1/","7.png", true));
        tiles.add(new Tile("/tiles/boss1/","8.png", true));
        tiles.add(new Tile("/tiles/boss1/","9.png", true));
        tiles.add(new Tile("/tiles/boss1/","10.png", true));
        tiles.add(new Tile("/tiles/boss1/","11.png", true));
        tiles.add(new Tile("/tiles/boss1/","12.png", true));
        tiles.add(new Tile("/tiles/boss1/","13.png", true));
        tiles.add(new Tile("/tiles/boss1/","14.png", true));
        tiles.add(new Tile("/tiles/boss1/","15.png", true));
        tiles.add(new Tile("/tiles/boss1/","16.png", true));
        tiles.add(new Tile("/tiles/boss1/","17.png", true));
        tiles.add(new Tile("/tiles/boss1/","18.png", true));
        tiles.add(new Tile("/tiles/boss1/","19.png", false));
        tiles.add(new Tile("/tiles/boss1/","20.png", false));
        tiles.add(new Tile("/tiles/boss1/","21.png", false));
        tiles.add(new Tile("/tiles/boss1/","22.png", false));
        tiles.add(new Tile("/tiles/boss1/","23.png", true));

    }*/

    public static Tile getTile(int tileIndex) {
        return tiles.get(tileIndex);
    }

    public static BufferedImage getTileImage(int tileIndex) {
        return tiles.get(tileIndex).image;
    }
}
