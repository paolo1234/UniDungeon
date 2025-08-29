package com.unidungeon.game;

import com.unidungeon.battle.BattleController;
import com.unidungeon.battle.BossBattleController;
import com.unidungeon.gameover.GameOverController;
import com.unidungeon.intro.IntroController;
import com.unidungeon.playing.PlayingController;
import com.unidungeon.title.TitleController;
import com.unidungeon.victory.VictoryController;

// Strategy pattern per il controller
public class GameRoute {
  GameModel gameModel;

  public GameRoute() {
    gameModel = GameModel.getGameModel();
  }

  public Controller buildController(GameState state) {
    switch (state) {
      case TITLE -> {
        return new TitleController();
      }
      case INTRO -> {
        return new IntroController();
      }
      case PLAYING -> {
        return new PlayingController();
      }
      case BATTLE -> {
        return new BattleController();
      }
      case GAMEOVER -> {
        return new GameOverController();
      }
      case BOSSBATTLE -> {
        return new BossBattleController();
      }
      case VICTORY -> {
        return new VictoryController();
      }
    }
    return null;
  }
}
