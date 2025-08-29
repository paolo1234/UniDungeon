package com.unidungeon.playing.gamemap;

import com.unidungeon.playing.GameMap;
import java.util.HashMap;
import java.util.Map;

public class GameMapManager {
  private static GameMapManager instance;
  private Map<String, GameMap> gameMaps;
  private GameMap currentGameMap;
  private GameMapDirector gameMapDirector;

  private GameMapManager() {
    gameMaps = new HashMap<>();
  }

  public static GameMapManager getInstance() {
    if (instance == null) {
      instance = new GameMapManager();
    }
    return instance;
  }

  public GameMap getCurrentGameMap() {
    return currentGameMap;
  }

  public void setCurrentGameMap(String mapKey) {
    this.currentGameMap = gameMaps.get(mapKey);
  }

  public void addGameMap(GameMap gameMap) {
    this.gameMaps.put(gameMap.name, gameMap);
  }

  public Map<String, GameMap> getGameMaps() {
    return gameMaps;
  }
}
