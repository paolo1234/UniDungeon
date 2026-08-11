package com.unidungeon.playing;

import com.unidungeon.entity.player.Player;
import com.unidungeon.game.GameFrame;
import com.unidungeon.game.Wallet;
import com.unidungeon.playing.gamemap.GameMapManager;
import com.unidungeon.playing.tiles.TileManager;

public class PlayingModel {
  GameMap currentGameMap;
  PlayerMoving playerMoving;
  GameMapManager gameMapManager;
  Player[] players;
  Wallet portafoglio;

  public PlayingModel(Player[] players, Wallet portafoglio) {
    this.portafoglio = portafoglio;
    this.players = players;
    this.gameMapManager = GameMapManager.getInstance();
    this.playerMoving = new PlayerMoving();
    TileManager.tilesInit();
  }

  public PlayerMoving getPlayerMoving() {
    return playerMoving;
  }

  public GameMap getCurrentGameMap() {
    return currentGameMap;
  }

  public Wallet getPortafoglio() {
    return this.portafoglio;
  }

  public void setCurrentGameMap(String mappa) {
    gameMapManager.setCurrentGameMap(mappa);
    currentGameMap = gameMapManager.getCurrentGameMap();
    playerMoving.setStartPosition(
        currentGameMap.getPlayerStartX(), currentGameMap.getPlayerStartY());
    GameFrame.getGameFrame().changeBackgroundMusic(getCurrentGameMap().getSoundKey());
  }
}
