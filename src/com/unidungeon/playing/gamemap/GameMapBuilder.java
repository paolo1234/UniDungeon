package com.unidungeon.playing.gamemap;

import com.unidungeon.playing.GameMap;
import com.unidungeon.playing.gameobject.decorazioni.Decorazioni;
import com.unidungeon.playing.gameobject.interagibili.Interagibili;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class GameMapBuilder {
    public String name;
    private int worldCol;
    private int worldRow;
    private int[][] levelTileNumbers;
    private int playerStartX;
    private int playerStartY;
    private List<Interagibili> interagibili;
    private List<Decorazioni> decoration;
    private String soundKey;

    public GameMapBuilder setName(String name){
        this.name = name;
        return this;
    }

    public GameMapBuilder setWorldCol(int worldCol){
        this.worldCol = worldCol;
        return this;
    }

    public GameMapBuilder setWorldRow(int worldRow){
        this.worldRow = worldRow;
        return this;
    }

    public GameMapBuilder setPlayerStartX(int playerStartX){
        this.playerStartX = playerStartX;
        return this;
    }

    public GameMapBuilder setPlayerStartY(int playerStartY){
        this.playerStartY = playerStartY;
        return this;
    }

    public GameMapBuilder setSoundIndex(String soundKey){
        this.soundKey = soundKey;
        return this;
    }

    public GameMapBuilder makeTilesLayer(String mapPath, String separator) {
        if(worldCol != 0 && worldRow != 0){
            levelTileNumbers = new int[worldCol][worldRow];
            try {
                InputStream is = getClass().getResourceAsStream(mapPath);
                assert is != null;
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                int col = 0, row = 0;
                while (col < this.worldCol && row < this.worldRow) {
                    String line = br.readLine();
                    while (col < this.worldCol) {
                        String[] numbers = line.split(separator);
                        int num = Integer.parseInt(numbers[col]);
                        this.levelTileNumbers[col][row] = num;
                        col++;
                    }
                    if (col == worldCol) {
                        col = 0;
                        row++;
                    }
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public GameMapBuilder makeDecorationLayer(List<Decorazioni> decoration){
        this.decoration = decoration;
        return this;
    }

    public GameMapBuilder makeTriggerLayer(List<Interagibili> interagibili){
        this.interagibili = interagibili;
        return this;
    }

    public GameMap build(){
        return new GameMap(name, worldCol, worldRow, playerStartX, playerStartY, levelTileNumbers, decoration, interagibili, soundKey);
    }
}
