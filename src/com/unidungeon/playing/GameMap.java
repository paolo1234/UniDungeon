package com.unidungeon.playing;

import com.unidungeon.playing.gameobject.decorazioni.Decorazioni;
import com.unidungeon.playing.gameobject.interagibili.Interagibili;
import com.unidungeon.playing.tiles.TileManager;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class GameMap {
  public static int lastLevelNumber = 0;
  public int number;
  public String name;
  public String mapPath;
  private int worldCol;
  private int worldRow;
  int[][] levelTileNumbers;
  private List<Interagibili> interagibili;
  private List<Decorazioni> decoration;
  private int playerStartX;
  private int playerStartY;
  private String soundKey;

  public GameMap(
      String name,
      int worldCol,
      int worldRow,
      int playerStartX,
      int playerStartY,
      int[][] levelTileNumbers,
      List<Decorazioni> decoration,
      List<Interagibili> interagibili,
      String soundKey) {
    this.name = name;
    this.worldCol = worldCol;
    this.worldRow = worldRow;
    this.playerStartX = playerStartX;
    this.playerStartY = playerStartY;
    this.levelTileNumbers = levelTileNumbers;
    this.decoration = decoration;
    this.interagibili = interagibili;
    this.soundKey = soundKey;
  }

  public String getSoundKey() {
    return soundKey;
  }

  List<int[]> randomTriggers() {
    List<int[]> coords = new ArrayList<>();
    for (int i = 0; i < levelTileNumbers.length; i++) {
      for (int j = 0; j < levelTileNumbers[i].length; j++) {
        if (levelTileNumbers[i][j] == 1
            || levelTileNumbers[i][j] == 2
            || levelTileNumbers[i][j] == 8) {
          coords.add(new int[] {i, j});
        }
      }
    }
    return coords;
  }

  public int getWorldCol() {
    return worldCol;
  }

  public void setWorldCol(int worldCol) {
    this.worldCol = worldCol;
  }

  public int getWorldRow() {
    return worldRow;
  }

  public void setWorldRow(int worldRow) {
    this.worldRow = worldRow;
  }

  public BufferedImage getTileImage(int tileIndex) {
    return TileManager.getTileImage(tileIndex);
  }

  public String getName() {
    return name;
  }

  public List<Decorazioni> getDecoration() {
    return decoration;
  }

  public int getPlayerStartX() {
    return playerStartX;
  }

  public int getPlayerStartY() {
    return playerStartY;
  }

  public static int getLastLevelNumber() {
    return lastLevelNumber;
  }

  public int getNumber() {
    return number;
  }

  public String getMapPath() {
    return mapPath;
  }

  public int[][] getLevelTileNumbers() {
    return levelTileNumbers;
  }

  public List<Interagibili> getInteragibili() {
    return interagibili;
  }
}
