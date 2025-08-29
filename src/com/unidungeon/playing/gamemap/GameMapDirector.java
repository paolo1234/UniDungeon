package com.unidungeon.playing.gamemap;

import com.unidungeon.game.GameState;
import com.unidungeon.playing.GameMap;
import com.unidungeon.playing.gameobject.decorazioni.Decorazioni;
import com.unidungeon.playing.gameobject.interagibili.GameStateTrigger;
import com.unidungeon.playing.gameobject.interagibili.Interagibili;
import com.unidungeon.playing.gameobject.interagibili.MapChangeTrigger;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class GameMapDirector {
  private GameMapBuilder builder;

  public GameMapDirector() {
    this.builder = new GameMapBuilder();
  }

  public void makeMaps() {
    this.makeLobby();
    this.makeAulaBoss1();
    this.makeD1_5();
  }

  public void makeLobby() {
    List<Decorazioni> decoration = new ArrayList<>();
    List<Interagibili> interagibili = new ArrayList<>();

    // interagibili.add(new GameStateTrigger(702,213,true, new Rectangle(0,0, 114,75),
    // GameState.BATTLE, "/declobby/PORTA.png", 114, 75));
    interagibili.add(
        new MapChangeTrigger(
            702, 213, true, new Rectangle(0, 0, 114, 75), "D1.5", "/declobby/PORTA.png", 114, 75));
    // decoration.add(new Decorazioni("/declobby/PORTA.png", 702,213, true, new Rectangle(0,0,
    // 114,75), 114, 75));
    // interagibili.add(new GameStateTrigger(28*48, 35*48, true, new Rectangle(0,0,48,48),
    // GameState.BATTLE));

    decoration.add(
        new Decorazioni(
            "/declobby/porta1.png", 2241, 912, true, new Rectangle(0, 0, 231, 204), 231, 204));
    decoration.add(
        new Decorazioni(
            "/declobby/laser1.png", 2238, 1056, true, new Rectangle(0, 0, 28, 24), 28, 24));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2265, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2294, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2323, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2352, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2383, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2412, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser2.png", 2433, 1059, true, new Rectangle(0, 0, 33, 20), 33, 20));
    decoration.add(
        new Decorazioni(
            "/declobby/laser3.png", 2458, 1059, true, new Rectangle(0, 0, 25, 19), 25, 19));

    decoration.add(
        new Decorazioni(
            "/declobby/orologio.png", 1298, 30, false, new Rectangle(0, 0, 142, 146), 142, 146));
    decoration.add(
        new Decorazioni("/declobby/cam.png", 240, 158, false, new Rectangle(0, 0, 39, 34), 39, 34));
    decoration.add(
        new Decorazioni(
            "/declobby/quadro2.png", 633, 166, false, new Rectangle(0, 0, 39, 45), 39, 45));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 864, 172, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 1200, 172, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 1541, 172, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 1893, 172, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/orol.png", 2256, 159, false, new Rectangle(0, 0, 39, 33), 39, 33));
    decoration.add(
        new Decorazioni(
            "/declobby/cam2.png", 2496, 158, false, new Rectangle(0, 0, 46, 32), 46, 32));
    decoration.add(
        new Decorazioni(
            "/declobby/libreria2.png", 270, 192, true, new Rectangle(0, 0, 144, 121), 144, 121));
    decoration.add(
        new Decorazioni(
            "/declobby/libreria2.png", 456, 192, true, new Rectangle(0, 0, 144, 121), 144, 121));
    decoration.add(
        new Decorazioni(
            "/declobby/libreria2.png", 2335, 192, true, new Rectangle(0, 0, 144, 121), 144, 121));
    decoration.add(
        new Decorazioni(
            "/declobby/scala.png", 480, 275, true, new Rectangle(0, 0, 36, 61), 36, 61));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello.png", 649, 251, true, new Rectangle(0, 0, 42, 54), 42, 54));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello.png", 987, 251, true, new Rectangle(0, 0, 42, 54), 42, 54));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello.png", 1262, 251, true, new Rectangle(0, 0, 42, 54), 42, 54));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello.png", 1632, 251, true, new Rectangle(0, 0, 42, 54), 42, 54));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello.png", 1968, 251, true, new Rectangle(0, 0, 42, 54), 42, 54));
    // decoration.add(new Decorazioni("/declobby/PORTA.png", 702,213, true, new Rectangle(0,0,
    // 114,75), 114, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/PORTA.png", 1038, 213, true, new Rectangle(0, 0, 114, 75), 114, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/PORTA.png", 1311, 213, true, new Rectangle(0, 0, 114, 75), 114, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/PORTA.png", 1680, 213, true, new Rectangle(0, 0, 114, 75), 114, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/PORTA.png", 2016, 213, true, new Rectangle(0, 0, 114, 75), 114, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/interruttore.png", 824, 249, false, new Rectangle(0, 0, 24, 21), 24, 21));
    decoration.add(
        new Decorazioni(
            "/declobby/interruttore.png", 1157, 249, false, new Rectangle(0, 0, 24, 21), 24, 21));
    decoration.add(
        new Decorazioni(
            "/declobby/interruttore.png", 1430, 249, false, new Rectangle(0, 0, 24, 21), 24, 21));
    decoration.add(
        new Decorazioni(
            "/declobby/interruttore.png", 1800, 249, false, new Rectangle(0, 0, 24, 21), 24, 21));
    decoration.add(
        new Decorazioni(
            "/declobby/interruttore.png", 2136, 249, false, new Rectangle(0, 0, 24, 21), 24, 21));
    decoration.add(
        new Decorazioni(
            "/declobby/pianta.png", 912, 240, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/pianta.png", 1203, 240, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/pianta.png", 1568, 240, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/pianta.png", 1891, 240, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/macc.png", 1481, 220, true, new Rectangle(0, 0, 63, 100), 63, 100));
    decoration.add(
        new Decorazioni(
            "/declobby/chiavi.png", 2184, 219, false, new Rectangle(0, 0, 45, 42), 45, 42));
    decoration.add(
        new Decorazioni(
            "/declobby/cest.png", 2496, 276, true, new Rectangle(0, 0, 36, 60), 36, 60));
    decoration.add(
        new Decorazioni(
            "/declobby/num1.png", 752, 192, false, new Rectangle(0, 0, 16, 19), 16, 19));
    decoration.add(
        new Decorazioni(
            "/declobby/num2.png", 1088, 192, false, new Rectangle(0, 0, 16, 19), 16, 19));
    decoration.add(
        new Decorazioni(
            "/declobby/num3.png", 1361, 192, false, new Rectangle(0, 0, 16, 19), 16, 19));
    decoration.add(
        new Decorazioni(
            "/declobby/num4.png", 1728, 192, false, new Rectangle(0, 0, 16, 19), 16, 19));
    decoration.add(
        new Decorazioni(
            "/declobby/num5.png", 2064, 192, false, new Rectangle(0, 0, 16, 19), 16, 19));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp4.png", 1296, 504, false, new Rectangle(0, 0, 144, 144), 144, 144));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp5.png", 1296, 432, false, new Rectangle(0, 0, 144, 72), 144, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp3.png", 1296, 648, false, new Rectangle(0, 0, 144, 72), 144, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tavolo2.png", 1320, 522, true, new Rectangle(0, 0, 96, 73), 96, 73));
    decoration.add(
        new Decorazioni(
            "/declobby/fazzoletti.png", 1332, 517, true, new Rectangle(0, 0, 33, 24), 33, 24));
    decoration.add(
        new Decorazioni(
            "/declobby/fiori.png", 1372, 517, true, new Rectangle(0, 0, 38, 42), 38, 42));
    decoration.add(
        new Decorazioni(
            "/declobby/libri5.png", 264, 417, false, new Rectangle(0, 0, 72, 63), 72, 63));
    decoration.add(
        new Decorazioni(
            "/declobby/sedietavolo.png", 528, 461, true, new Rectangle(0, 0, 127, 67), 127, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/sedietavolo.png", 528, 605, true, new Rectangle(0, 0, 127, 67), 127, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/sedietavolo.png", 864, 528, true, new Rectangle(0, 0, 127, 67), 127, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/sedietavolo.png", 1841, 528, true, new Rectangle(0, 0, 127, 67), 127, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/sedietavolo.png", 2160, 461, true, new Rectangle(0, 0, 127, 67), 127, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/sedietavolo.png", 2160, 605, true, new Rectangle(0, 0, 127, 67), 127, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/fogli.png", 570, 473, true, new Rectangle(0, 0, 43, 31), 43, 31));
    decoration.add(
        new Decorazioni("/declobby/cibo.png", 926, 540, true, new Rectangle(0, 0, 21, 32), 21, 32));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp2.png", 1892, 528, true, new Rectangle(0, 0, 28, 34), 28, 34));
    decoration.add(
        new Decorazioni(
            "/declobby/libri4.png", 2203, 617, true, new Rectangle(0, 0, 22, 35), 22, 35));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 30, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 67, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 115, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 163, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 211, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 259, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 307, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 355, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 403, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 451, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 451, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 499, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 547, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 595, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 643, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 691, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 739, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 787, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 835, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 883, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 931, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1171, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1219, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1267, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1315, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1363, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1411, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1459, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1507, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1747, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1795, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1843, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1891, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1939, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 1987, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2035, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2083, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2131, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2179, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2227, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2275, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2323, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2371, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2419, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2467, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2515, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2563, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2611, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale5.png", 2659, 789, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/scale4.png", 979, 780, false, new Rectangle(0, 0, 192, 57), 192, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/scale4.png", 1555, 780, false, new Rectangle(0, 0, 192, 57), 192, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/scale3.png", 979, 837, false, new Rectangle(0, 0, 192, 48), 192, 48));
    decoration.add(
        new Decorazioni(
            "/declobby/scale3.png", 1555, 837, false, new Rectangle(0, 0, 192, 48), 192, 48));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1003, 858, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1003, 894, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1003, 930, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1003, 966, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1003, 1002, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1003, 1038, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1579, 858, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1579, 894, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1579, 930, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1579, 966, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1579, 1002, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale2.png", 1579, 1038, false, new Rectangle(0, 0, 144, 36), 144, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/scale1.png", 1000, 1074, false, new Rectangle(0, 0, 150, 69), 150, 69));
    decoration.add(
        new Decorazioni(
            "/declobby/scale1.png", 1576, 1074, false, new Rectangle(0, 0, 150, 69), 150, 69));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp7.png", 1028, 780, false, new Rectangle(0, 0, 95, 90), 95, 90));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp7.png", 1603, 780, false, new Rectangle(0, 0, 95, 90), 95, 90));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp8.png", 1028, 870, false, new Rectangle(0, 0, 95, 63), 95, 63));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp8.png", 1603, 870, false, new Rectangle(0, 0, 95, 63), 95, 63));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp6.png", 1028, 933, false, new Rectangle(0, 0, 95, 217), 95, 217));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp6.png", 1603, 933, false, new Rectangle(0, 0, 95, 217), 95, 217));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello1.png", 276, 888, false, new Rectangle(0, 0, 204, 105), 204, 105));
    decoration.add(
        new Decorazioni("/declobby/cam.png", 48, 1008, false, new Rectangle(0, 0, 39, 34), 39, 34));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 184, 991, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 693, 991, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/shop.png", 307, 1007, true, new Rectangle(0, 0, 129, 100), 129, 100));
    decoration.add(
        new Decorazioni(
            "/declobby/foglio.png", 463, 1023, false, new Rectangle(0, 0, 30, 33), 30, 33));
    decoration.add(
        new Decorazioni(
            "/declobby/foglio.png", 517, 999, false, new Rectangle(0, 0, 30, 33), 30, 33));
    decoration.add(
        new Decorazioni(
            "/declobby/quadro.png", 756, 1008, false, new Rectangle(0, 0, 84, 39), 84, 39));
    decoration.add(
        new Decorazioni(
            "/declobby/foglio1.png", 924, 984, false, new Rectangle(0, 0, 36, 27), 36, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia.png", 66, 1071, true, new Rectangle(0, 0, 126, 66), 126, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia.png", 672, 1071, true, new Rectangle(0, 0, 126, 66), 126, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia.png", 801, 1071, true, new Rectangle(0, 0, 126, 66), 126, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia.png", 1986, 1071, true, new Rectangle(0, 0, 126, 66), 126, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/cest.png", 204, 1084, true, new Rectangle(0, 0, 36, 60), 36, 60));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello2.png", 259, 1059, true, new Rectangle(0, 0, 43, 69), 43, 69));
    decoration.add(
        new Decorazioni(
            "/declobby/font.png", 559, 1008, true, new Rectangle(0, 0, 65, 129), 65, 129));
    decoration.add(
        new Decorazioni(
            "/declobby/piatti.png", 683, 1086, true, new Rectangle(0, 0, 37, 36), 37, 36));
    decoration.add(
        new Decorazioni(
            "/declobby/sporco2.png", 192, 1152, true, new Rectangle(0, 0, 26, 35), 26, 35));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 201, 1287, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 672, 1287, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 195, 1287, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 432, 1383, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 195, 1383, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 672, 1383, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 195, 1488, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa4.png", 432, 1488, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa8.png", 239, 1377, true, new Rectangle(0, 0, 47, 63), 47, 63));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 240, 1287, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 716, 1383, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 239, 1488, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 477, 1287, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 477, 1383, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 716, 1287, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa9.png", 716, 1488, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa10.png", 477, 1465, true, new Rectangle(0, 0, 46, 80), 46, 80));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa2.png", 672, 1488, true, new Rectangle(0, 0, 45, 57), 45, 57));
    decoration.add(
        new Decorazioni(
            "/declobby/sporco.png", 720, 1309, true, new Rectangle(0, 0, 37, 32), 37, 32));
    decoration.add(
        new Decorazioni(
            "/declobby/mensa1.png", 432, 1277, true, new Rectangle(0, 0, 46, 67), 46, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/sporco3.png", 288, 1542, false, new Rectangle(0, 0, 48, 42), 48, 42));
    decoration.add(
        new Decorazioni(
            "/declobby/estin.png", 60, 1626, true, new Rectangle(0, 0, 36, 54), 36, 54));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 57, 1248, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 57, 1303, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 293, 1296, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 729, 1236, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 624, 1296, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 384, 1392, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 624, 1392, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 176, 1536, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 288, 1495, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 480, 1543, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 537, 1495, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 384, 1632, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 624, 1504, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 768, 1504, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/board.png", 1169, 1007, false, new Rectangle(0, 0, 98, 49), 98, 49));
    decoration.add(
        new Decorazioni(
            "/declobby/Mr._Jawsum_Portrait.png",
            1300,
            904,
            false,
            new Rectangle(0, 0, 136, 160),
            136,
            160));
    decoration.add(
        new Decorazioni(
            "/declobby/allarme.png", 1524, 1047, false, new Rectangle(0, 0, 33, 27), 33, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/pianta.png", 1224, 1077, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/pianta.png", 1464, 1077, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello4.png", 1161, 1131, true, new Rectangle(0, 0, 63, 100), 63, 100));
    decoration.add(
        new Decorazioni(
            "/declobby/sec.png", 1281, 1085, true, new Rectangle(0, 0, 175, 115), 175, 115));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp5.png", 1296, 1248, false, new Rectangle(0, 0, 144, 72), 144, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp1.png", 1296, 1320, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp1.png", 1296, 1392, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp2.png", 1368, 1320, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp2.png", 1368, 1392, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp1.png", 1296, 1536, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp1.png", 1296, 1608, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp1.png", 1296, 1680, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp1.png", 1296, 1752, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp2.png", 1368, 1536, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp2.png", 1368, 1608, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp2.png", 1368, 1680, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp2.png", 1368, 1752, false, new Rectangle(0, 0, 72, 72), 72, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp4.png", 1296, 1440, false, new Rectangle(0, 0, 144, 144), 144, 144));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp3.png", 1296, 1824, false, new Rectangle(0, 0, 144, 72), 144, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp.png", 1325, 2016, false, new Rectangle(0, 0, 87, 45), 87, 45));
    decoration.add(
        new Decorazioni(
            "/declobby/foglio2.png", 1776, 981, false, new Rectangle(0, 0, 36, 27), 36, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/fogli2.png", 1903, 988, false, new Rectangle(0, 0, 48, 95), 48, 95));
    decoration.add(
        new Decorazioni(
            "/declobby/quadro3.png", 2001, 1008, false, new Rectangle(0, 0, 63, 39), 63, 39));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp.png", 2112, 988, false, new Rectangle(0, 0, 27, 41), 27, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/cam.png", 2208, 984, false, new Rectangle(0, 0, 39, 34), 39, 34));
    decoration.add(
        new Decorazioni(
            "/declobby/cam2.png", 2483, 984, false, new Rectangle(0, 0, 46, 32), 46, 32));
    decoration.add(
        new Decorazioni(
            "/declobby/foglio4.png", 2592, 992, false, new Rectangle(0, 0, 33, 33), 33, 33));
    decoration.add(
        new Decorazioni(
            "/declobby/cest.png", 1788, 1092, true, new Rectangle(0, 0, 36, 60), 36, 60));
    decoration.add(
        new Decorazioni(
            "/declobby/cest.png", 1836, 1092, true, new Rectangle(0, 0, 36, 60), 36, 60));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia.png", 1986, 1071, true, new Rectangle(0, 0, 126, 66), 126, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/cartello3.png", 2190, 1056, true, new Rectangle(0, 0, 36, 72), 36, 72));

    decoration.add(
        new Decorazioni(
            "/declobby/libreria1.png", 2529, 1043, true, new Rectangle(0, 0, 82, 93), 82, 93));
    decoration.add(
        new Decorazioni(
            "/declobby/trofeo.png", 2539, 1008, true, new Rectangle(0, 0, 44, 63), 44, 63));
    decoration.add(
        new Decorazioni(
            "/declobby/piantina.png", 2622, 1038, true, new Rectangle(0, 0, 66, 90), 66, 90));
    decoration.add(
        new Decorazioni(
            "/declobby/tapp10.png", 2280, 1122, false, new Rectangle(0, 0, 168, 174), 168, 174));
    decoration.add(
        new Decorazioni(
            "/declobby/tavolo.png", 1739, 1330, true, new Rectangle(0, 0, 115, 112), 115, 112));
    decoration.add(
        new Decorazioni(
            "/declobby/tavolo.png", 1877, 1330, true, new Rectangle(0, 0, 115, 112), 115, 112));
    decoration.add(
        new Decorazioni(
            "/declobby/tavolo.png", 2016, 1330, true, new Rectangle(0, 0, 115, 112), 115, 112));
    decoration.add(
        new Decorazioni(
            "/declobby/libro.png", 1748, 1375, true, new Rectangle(0, 0, 30, 43), 30, 43));
    decoration.add(
        new Decorazioni(
            "/declobby/libri2.png", 1816, 1338, true, new Rectangle(0, 0, 23, 34), 23, 34));
    decoration.add(
        new Decorazioni(
            "/declobby/sangue3.png", 1948, 1399, true, new Rectangle(0, 0, 41, 41), 41, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/lamp2.png", 2056, 1358, true, new Rectangle(0, 0, 28, 34), 28, 34));
    decoration.add(
        new Decorazioni(
            "/declobby/cestino2.png", 2652, 1536, true, new Rectangle(0, 0, 36, 43), 36, 43));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 1785, 1287, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 1920, 1287, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 2025, 1440, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 2141, 1392, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia3.png", 2141, 1331, true, new Rectangle(0, 0, 39, 41), 39, 41));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 1680, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 1728, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 1968, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2016, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2064, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2256, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2304, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2352, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2544, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2592, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/sedia2.png", 2640, 1653, true, new Rectangle(0, 0, 48, 27), 48, 27));
    decoration.add(
        new Decorazioni(
            "/declobby/foglio3.png", 1986, 1152, false, new Rectangle(0, 0, 30, 28), 30, 28));

    // NPC

    decoration.add(
        new Decorazioni("/declobby/npc8.png", 243, 366, true, new Rectangle(0, 0, 45, 66), 45, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc10.png", 618, 443, true, new Rectangle(0, 0, 43, 66), 43, 66));
    decoration.add(
        new Decorazioni("/declobby/npc6.png", 864, 318, true, new Rectangle(0, 0, 48, 66), 48, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc7.png", 2021, 402, true, new Rectangle(0, 0, 46, 72), 46, 72));
    decoration.add(
        new Decorazioni(
            "/declobby/npc2.png", 450, 1086, true, new Rectangle(0, 0, 49, 66), 49, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc14.png", 288, 1368, true, new Rectangle(0, 0, 43, 65), 43, 65));
    decoration.add(
        new Decorazioni(
            "/declobby/npc11.png", 398, 1270, true, new Rectangle(0, 0, 44, 69), 44, 69));
    decoration.add(
        new Decorazioni(
            "/declobby/npc12.png", 624, 1459, true, new Rectangle(0, 48, 32, 20), 42, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc13.png", 764, 1459, true, new Rectangle(0, 48, 32, 20), 48, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc16.png", 816, 1085, true, new Rectangle(0, 0, 48, 75), 48, 75));
    decoration.add(
        new Decorazioni(
            "/declobby/npc5.png", 1538, 1152, true, new Rectangle(0, 0, 46, 66), 46, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc1.png", 1776, 1613, true, new Rectangle(0, 0, 48, 67), 48, 67));
    decoration.add(
        new Decorazioni(
            "/declobby/npc4.png", 1796, 1394, true, new Rectangle(0, 0, 48, 84), 48, 84));
    decoration.add(
        new Decorazioni(
            "/declobby/npc3.png", 1992, 1080, true, new Rectangle(0, 0, 72, 47), 72, 47));
    decoration.add(
        new Decorazioni(
            "/declobby/npc15.png", 2316, 1374, true, new Rectangle(0, 0, 42, 66), 42, 66));
    decoration.add(
        new Decorazioni(
            "/declobby/npc9.png", 2640, 1134, true, new Rectangle(0, 0, 44, 66), 44, 66));

    GameMap map =
        this.builder
            .setName("Lobby")
            .setWorldCol(57)
            .setWorldRow(43)
            .setPlayerStartX(28)
            .setPlayerStartY(41)
            .setSoundIndex("lobbyMusic")
            .makeTilesLayer("/maps/Lobby.csv", ",")
            .makeDecorationLayer(decoration)
            .makeTriggerLayer(interagibili)
            .build();

    GameMapManager gameMapManager = GameMapManager.getInstance();
    gameMapManager.addGameMap(map);
  }

  public void makeAulaBoss1() {
    List<Decorazioni> decoration = new ArrayList<>();
    List<Interagibili> interagibili = new ArrayList<>();

    // decoration.add(new Decorazioni("/decBoss/scaledown.png",336,820, false, new Rectangle(0,0,
    // 192, 116), 192, 116));

    interagibili.add(
        new MapChangeTrigger(
            336,
            850,
            true,
            new Rectangle(0, 0, 192, 116),
            "D1.5",
            "/decBoss/scaledown.png",
            192,
            116));

    decoration.add(
        new Decorazioni(
            "/decBoss/ragnatela.png", 23, 21, false, new Rectangle(0, 0, 49, 54), 49, 54));
    decoration.add(
        new Decorazioni("/decBoss/tv.png", 96, 50, false, new Rectangle(0, 0, 66, 46), 66, 46));
    decoration.add(
        new Decorazioni(
            "/decBoss/orologio.png", 225, 39, false, new Rectangle(0, 0, 39, 33), 39, 33));
    decoration.add(
        new Decorazioni("/decBoss/lim.png", 301, 25, false, new Rectangle(0, 0, 83, 81), 83, 81));
    decoration.add(
        new Decorazioni("/decBoss/lim2.png", 384, 25, false, new Rectangle(0, 0, 48, 81), 48, 81));
    decoration.add(
        new Decorazioni("/decBoss/lim2.png", 432, 25, false, new Rectangle(0, 0, 48, 81), 48, 81));
    decoration.add(
        new Decorazioni("/decBoss/lim2.png", 480, 25, false, new Rectangle(0, 0, 48, 81), 48, 81));
    decoration.add(
        new Decorazioni("/decBoss/lim3.png", 528, 25, false, new Rectangle(0, 0, 41, 81), 41, 81));
    decoration.add(
        new Decorazioni(
            "/decBoss/poster2.png", 672, 34, false, new Rectangle(0, 0, 39, 48), 39, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/poster.png", 745, 58, false, new Rectangle(0, 0, 39, 48), 39, 48));
    decoration.add(
        new Decorazioni("/decBoss/estin.png", 48, 666, true, new Rectangle(0, 0, 36, 54), 36, 54));
    decoration.add(
        new Decorazioni(
            "/decBoss/scheletro.png", 559, 672, true, new Rectangle(0, 0, 65, 48), 65, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/sangue1.png", 144, 384, false, new Rectangle(0, 0, 42, 27), 42, 27));
    decoration.add(
        new Decorazioni(
            "/decBoss/fogli.png", 764, 336, false, new Rectangle(0, 0, 52, 37), 52, 37));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp4.png", 384, 432, false, new Rectangle(0, 0, 96, 48), 96, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 480, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 528, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 576, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 624, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 672, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 720, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 768, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 816, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp1.png", 384, 864, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 480, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 528, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 576, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 624, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 672, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 720, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 768, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 816, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/tapp3.png", 432, 864, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni("/decBoss/banco.png", 96, 417, true, new Rectangle(0, 32, 39, 63), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 192, 417, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 288, 417, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni("/decBoss/banco.png", 96, 513, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 192, 513, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 288, 513, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni("/decBoss/banco.png", 96, 609, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 192, 609, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 288, 609, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 528, 417, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 624, 417, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 720, 417, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 528, 513, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 624, 513, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 720, 513, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 528, 609, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 624, 609, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/banco.png", 720, 609, true, new Rectangle(0, 32, 39, 32), 39, 63));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio3.png", 144, 144, false, new Rectangle(0, 0, 48, 96), 48, 96));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio6.png", 177, 240, true, new Rectangle(0, 0, 15, 48), 15, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio6.png", 177, 288, true, new Rectangle(0, 0, 15, 48), 15, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio8.png", 144, 336, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 192, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 240, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 288, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 336, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 384, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 432, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 480, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 528, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 576, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio2.png", 624, 336, true, new Rectangle(0, 0, 48, 39), 48, 39));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio7.png", 672, 336, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio5.png", 672, 288, true, new Rectangle(0, 0, 21, 48), 21, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio5.png", 672, 240, true, new Rectangle(0, 0, 21, 48), 21, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio4.png", 672, 144, false, new Rectangle(0, 0, 45, 96), 45, 96));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 192, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 240, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 288, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 336, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 384, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 432, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 480, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 528, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 576, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 624, 144, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 192, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 240, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 288, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 336, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 384, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 432, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 480, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 528, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 576, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 624, 192, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 192, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 240, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 288, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 336, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 384, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 432, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 480, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 528, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 576, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 624, 240, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 192, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 240, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 288, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 336, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 384, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 432, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 480, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 528, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 576, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/podio1.png", 624, 288, false, new Rectangle(0, 0, 48, 48), 48, 48));
    decoration.add(
        new Decorazioni(
            "/decBoss/libri3.png", 192, 288, false, new Rectangle(0, 0, 72, 37), 72, 37));
    decoration.add(
        new Decorazioni("/decBoss/desk1.png", 279, 282, true, new Rectangle(0, 0, 57, 54), 57, 54));
    decoration.add(
        new Decorazioni("/decBoss/desk2.png", 336, 282, true, new Rectangle(0, 0, 48, 54), 48, 54));
    decoration.add(
        new Decorazioni("/decBoss/desk2.png", 384, 282, true, new Rectangle(0, 0, 48, 54), 48, 54));
    decoration.add(
        new Decorazioni("/decBoss/desk3.png", 432, 249, true, new Rectangle(0, 0, 48, 87), 48, 87));
    decoration.add(
        new Decorazioni("/decBoss/desk2.png", 480, 282, true, new Rectangle(0, 0, 48, 54), 48, 54));
    decoration.add(
        new Decorazioni("/decBoss/desk4.png", 528, 282, true, new Rectangle(0, 0, 57, 54), 57, 54));
    decoration.add(
        new Decorazioni(
            "/decBoss/budello.png", 555, 240, false, new Rectangle(0, 0, 42, 18), 42, 18));

    interagibili.add(
        new GameStateTrigger(
            370,
            103,
            true,
            new Rectangle(0, 0, 134, 134),
            GameState.BOSSBATTLE,
            "/decBoss/BOSSISS.png",
            134,
            134));

    GameMap map =
        this.builder
            .setName("Boss1")
            .setWorldCol(18)
            .setWorldRow(18)
            .setPlayerStartX(9)
            .setPlayerStartY(14)
            .makeTilesLayer("/maps/mappaBossD1.csv", ",")
            .setSoundIndex("salaBoss1Music")
            .makeDecorationLayer(decoration)
            .makeTriggerLayer(interagibili)
            .build();

    GameMapManager gameMapManager = GameMapManager.getInstance();
    gameMapManager.addGameMap(map);
  }

  public void makeD1_5() {
    List<Decorazioni> decoration = new ArrayList<>();
    List<Interagibili> interagibili = new ArrayList<>();

    // decoration.add(new Decorazioni("/decorations/scaleup.png", 2592,9, false, new Rectangle(0,0,
    // 38,42), 144,183));
    interagibili.add(
        new MapChangeTrigger(
            2592,
            9,
            true,
            new Rectangle(0, 0, 144, 183),
            "Boss1",
            "/decorations/scaleup.png",
            144,
            183));
    // decoration.add(new Decorazioni("/decorations/scaledown.png", 336,2432, true, new
    // Rectangle(0,0, 144,87), 144,87));
    interagibili.add(
        new GameStateTrigger(240, 2688, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(432, 2064, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(192, 1584, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(1056, 1577, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(482, 1152, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(624, 624, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(190, 144, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(874, 144, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(1488, 1872, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(1776, 2592, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(2304, 1968, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(2400, 1248, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(1872, 624, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));
    interagibili.add(
        new GameStateTrigger(2640, 384, true, new Rectangle(0, 0, 48, 48), GameState.BATTLE));

    decoration.add(
        new Decorazioni(
            "/decorations/piantina.png", 1824, 1536, true, new Rectangle(0, 0, 54, 74), 54, 74));
    decoration.add(
        new Decorazioni(
            "/decorations/libri.png", 1440, 1593, false, new Rectangle(0, 0, 50, 41), 69, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/libri.png", 384, 126, false, new Rectangle(0, 0, 84, 69), 69, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/libri.png", 144, 912, false, new Rectangle(0, 0, 84, 69), 69, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/libri.png", 645, 2430, false, new Rectangle(0, 0, 84, 69), 69, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/piantina.png", 522, 875, true, new Rectangle(0, 0, 54, 74), 54, 74));
    decoration.add(
        new Decorazioni(
            "/decorations/piantina.png", 2680, 2635, true, new Rectangle(0, 0, 54, 74), 54, 74));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 144, 2002, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 447, 864, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 1791, 240, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 1310, 672, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 1349, 641, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 1840, 1152, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 2256, 2256, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/foglio.png", 2228, 2265, false, new Rectangle(0, 0, 18, 20), 27, 30));
    decoration.add(
        new Decorazioni(
            "/decorations/orologio.png", 773, 2288, false, new Rectangle(0, 0, 18, 20), 30, 25));
    decoration.add(
        new Decorazioni(
            "/decorations/orologio.png", 559, 7, false, new Rectangle(0, 0, 18, 20), 30, 25));
    decoration.add(
        new Decorazioni(
            "/decorations/chiavi.png", 249, 850, false, new Rectangle(0, 0, 18, 20), 45, 42));
    decoration.add(
        new Decorazioni(
            "/decorations/scheletro.png", 720, 1015, true, new Rectangle(0, 0, 56, 41), 66, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/scheletro.png", 2670, 288, true, new Rectangle(0, 0, 56, 41), 66, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/scheletro.png", 1635, 2430, true, new Rectangle(0, 0, 56, 41), 66, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/schel.png", 1832, 245, true, new Rectangle(0, 0, 33, 78), 38, 89));
    decoration.add(
        new Decorazioni(
            "/decorations/fontana.png", 1680, 1368, true, new Rectangle(0, 0, 56, 41), 48, 54));
    decoration.add(
        new Decorazioni(
            "/decorations/sangue3.png", 928, 96, false, new Rectangle(0, 0, 56, 41), 41, 41));
    decoration.add(
        new Decorazioni(
            "/decorations/sangue3.png", 1024, 1104, false, new Rectangle(0, 0, 56, 41), 41, 41));
    decoration.add(
        new Decorazioni(
            "/decorations/sangue1.png", 432, 2160, false, new Rectangle(0, 0, 56, 41), 42, 27));
    decoration.add(
        new Decorazioni(
            "/decorations/sangue1.png", 1200, 816, false, new Rectangle(0, 0, 56, 41), 42, 27));
    decoration.add(
        new Decorazioni(
            "/decorations/sangue1.png", 1536, 2112, false, new Rectangle(0, 0, 56, 41), 42, 27));
    decoration.add(
        new Decorazioni(
            "/decorations/sangue1.png", 2400, 1071, false, new Rectangle(0, 0, 56, 41), 42, 27));
    decoration.add(
        new Decorazioni(
            "/decorations/cervella.png", 2400, 2592, true, new Rectangle(0, 0, 48, 42), 48, 42));
    decoration.add(
        new Decorazioni(
            "/decorations/tipomorto.png", 226, 460, true, new Rectangle(0, 0, 72, 79), 72, 79));
    decoration.add(
        new Decorazioni(
            "/decorations/gabbia.png", 1513, 96, true, new Rectangle(0, 0, 71, 79), 71, 79));
    decoration.add(
        new Decorazioni(
            "/decorations/libri2.png", 2693, 2592, false, new Rectangle(0, 0, 71, 79), 25, 37));
    decoration.add(
        new Decorazioni(
            "/decorations/libri2.png", 2600, 768, false, new Rectangle(0, 0, 71, 79), 25, 37));
    decoration.add(
        new Decorazioni(
            "/decorations/libri2.png", 794, 1280, false, new Rectangle(0, 0, 71, 79), 25, 37));
    decoration.add(
        new Decorazioni(
            "/decorations/libri3.png", 1064, 1924, false, new Rectangle(0, 0, 71, 79), 73, 38));
    decoration.add(
        new Decorazioni(
            "/decorations/libri3.png", 912, 288, false, new Rectangle(0, 0, 71, 79), 73, 38));
    decoration.add(
        new Decorazioni(
            "/decorations/libri3.png", 1200, 1152, false, new Rectangle(0, 0, 71, 79), 73, 38));
    decoration.add(
        new Decorazioni(
            "/decorations/libri3.png", 2016, 2291, false, new Rectangle(0, 0, 71, 79), 73, 38));
    decoration.add(
        new Decorazioni(
            "/decorations/libri3.png", 2171, 1968, false, new Rectangle(0, 0, 71, 79), 73, 38));
    decoration.add(
        new Decorazioni(
            "/decorations/libri4.png", 1440, 1536, false, new Rectangle(0, 0, 71, 79), 30, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/libri4.png", 672, 1198, false, new Rectangle(0, 0, 71, 79), 30, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/libri4.png", 960, 192, false, new Rectangle(0, 0, 71, 79), 30, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/libri5.png", 1430, 185, false, new Rectangle(0, 0, 71, 79), 79, 70));
    decoration.add(
        new Decorazioni(
            "/decorations/libri5.png", 2669, 1296, false, new Rectangle(0, 0, 71, 79), 79, 70));
    decoration.add(
        new Decorazioni(
            "/decorations/mele.png", 1790, 795, true, new Rectangle(0, 0, 67, 56), 78, 66));
    decoration.add(
        new Decorazioni(
            "/decorations/panni.png", 2160, 1405, true, new Rectangle(0, 0, 52, 31), 52, 31));
    decoration.add(
        new Decorazioni(
            "/decorations/portalibro.png", 2352, 979, true, new Rectangle(0, 0, 48, 84), 48, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/portalibro.png", 586, 1170, true, new Rectangle(0, 0, 48, 84), 48, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/portalibro.png", 1824, 2178, true, new Rectangle(0, 0, 48, 84), 48, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/ragnatela.png", 1210, 2622, true, new Rectangle(0, 0, 38, 42), 38, 42));
    decoration.add(
        new Decorazioni(
            "/decorations/ragnatela.png", 966, 17, true, new Rectangle(0, 0, 38, 42), 38, 42));
    decoration.add(
        new Decorazioni(
            "/decorations/ragnatela.png", 630, 1462, true, new Rectangle(0, 0, 38, 42), 38, 42));
    // decoration.add(new Decorazioni("/decorations/scaleup.png", 2592,9, false, new Rectangle(0,0,
    // 38,42), 144,183));
    interagibili.add(
        new MapChangeTrigger(
            336,
            2432,
            true,
            new Rectangle(0, 0, 144, 87),
            "Lobby",
            "/decorations/scaledown.png",
            144,
            87));
    decoration.add(
        new Decorazioni(
            "/decorations/specchio.png", 2256, 518, false, new Rectangle(0, 0, 38, 42), 26, 37));
    decoration.add(
        new Decorazioni(
            "/decorations/budello.png", 604, 1605, false, new Rectangle(0, 0, 38, 42), 41, 18));
    decoration.add(
        new Decorazioni(
            "/decorations/armadiorotto.png",
            576,
            2290,
            true,
            new Rectangle(0, 0, 82, 109),
            82,
            109));
    decoration.add(
        new Decorazioni(
            "/decorations/armadiorotto.png",
            1728,
            1138,
            true,
            new Rectangle(0, 0, 82, 109),
            82,
            109));
    decoration.add(
        new Decorazioni(
            "/decorations/caffe.png", 1639, 1132, true, new Rectangle(0, 0, 76, 110), 76, 110));
    decoration.add(
        new Decorazioni(
            "/decorations/comodinorotto.png",
            1296,
            2176,
            true,
            new Rectangle(0, 0, 83, 80),
            83,
            80));
    decoration.add(
        new Decorazioni(
            "/decorations/comodinorotto.png",
            1183,
            547,
            true,
            new Rectangle(0, 0, 83, 80),
            83,
            80));
    decoration.add(
        new Decorazioni(
            "/decorations/comodinorotto2.png", 673, 27, true, new Rectangle(0, 0, 49, 79), 49, 79));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 220, 1998, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 288, 1998, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 288, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 336, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 384, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 432, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 480, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 672, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 720, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 768, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 816, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 864, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 912, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 960, 1436, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 742, 573, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 800, 573, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 1968, 526, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2037, 526, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2112, 526, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2184, 526, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 1165, 2590, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 1248, 2590, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2352, 2254, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2160, 2254, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2112, 2254, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2400, 2254, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 2448, 2254, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 1462, 1294, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/armadietto.png", 1510, 1294, true, new Rectangle(0, 0, 41, 84), 41, 84));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria.png", 164, 0, true, new Rectangle(0, 0, 88, 96), 88, 96));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria.png", 288, 0, true, new Rectangle(0, 0, 88, 96), 88, 96));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria.png", 407, 0, true, new Rectangle(0, 0, 88, 96), 88, 96));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria3.png", 1056, 992, true, new Rectangle(0, 0, 88, 96), 88, 96));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria2.png",
            1601,
            384,
            true,
            new Rectangle(0, 0, 127, 107),
            127,
            107));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria2.png",
            1601,
            528,
            true,
            new Rectangle(0, 0, 127, 107),
            127,
            107));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria2.png",
            1601,
            688,
            true,
            new Rectangle(0, 0, 127, 107),
            127,
            107));
    decoration.add(
        new Decorazioni(
            "/decorations/libreria4.png",
            2338,
            1779,
            true,
            new Rectangle(0, 0, 163, 135),
            163,
            135));
    decoration.add(
        new Decorazioni(
            "/decorations/lavagna2.png", 858, 17, true, new Rectangle(0, 0, 96, 75), 96, 75));
    decoration.add(
        new Decorazioni(
            "/decorations/lavagna.png", 1611, 211, true, new Rectangle(0, 0, 84, 69), 84, 69));
    decoration.add(
        new Decorazioni(
            "/decorations/lavagnaside.png", 1440, 264, true, new Rectangle(0, 0, 16, 91), 16, 91));
    decoration.add(
        new Decorazioni(
            "/decorations/globo.png", 624, 29, true, new Rectangle(0, 0, 30, 49), 35, 58));
    decoration.add(
        new Decorazioni(
            "/decorations/globo.png", 2078, 2625, true, new Rectangle(0, 0, 30, 49), 35, 58));
    decoration.add(
        new Decorazioni("/decorations/pc.png", 504, 20, true, new Rectangle(0, 0, 47, 81), 47, 81));
    decoration.add(
        new Decorazioni(
            "/decorations/pc.png", 1176, 996, true, new Rectangle(0, 0, 47, 81), 47, 81));
    decoration.add(
        new Decorazioni(
            "/decorations/board.png", 1680, 2134, true, new Rectangle(0, 0, 93, 63), 93, 63));
    decoration.add(
        new Decorazioni(
            "/decorations/board2.png", 2458, 1088, true, new Rectangle(0, 0, 95, 47), 95, 47));
    decoration.add(
        new Decorazioni(
            "/decorations/board2.png", 538, 1430, true, new Rectangle(0, 0, 95, 47), 95, 47));
    decoration.add(
        new Decorazioni(
            "/decorations/geo.png", 667, 2280, true, new Rectangle(0, 0, 96, 57), 96, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/banco.png", 254, 183, true, new Rectangle(0, 0, 34, 57), 34, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/banco.png", 545, 182, true, new Rectangle(0, 0, 34, 57), 34, 57));
    decoration.add(
        new Decorazioni(
            "/decorations/banco4.png", 302, 182, true, new Rectangle(0, 0, 34, 58), 34, 58));
    decoration.add(
        new Decorazioni(
            "/decorations/banco4.png", 549, 342, true, new Rectangle(0, 0, 34, 58), 34, 58));
    decoration.add(
        new Decorazioni(
            "/decorations/banco2.png", 590, 187, true, new Rectangle(0, 0, 34, 58), 34, 58));
    decoration.add(
        new Decorazioni(
            "/decorations/banco2.png", 268, 326, true, new Rectangle(0, 0, 34, 58), 34, 58));
    decoration.add(
        new Decorazioni(
            "/decorations/banco5.png", 369, 531, true, new Rectangle(0, 0, 41, 54), 41, 54));
    decoration.add(
        new Decorazioni(
            "/decorations/banco5.png", 1344, 714, true, new Rectangle(0, 0, 41, 54), 41, 54));
    decoration.add(
        new Decorazioni(
            "/decorations/banco5.png", 2242, 1696, true, new Rectangle(0, 0, 41, 54), 41, 54));
    decoration.add(
        new Decorazioni(
            "/decorations/banco7.png", 1452, 487, true, new Rectangle(0, 0, 60, 89), 60, 89));
    decoration.add(
        new Decorazioni(
            "/decorations/banco8.png", 1452, 367, true, new Rectangle(0, 0, 60, 89), 60, 89));
    decoration.add(
        new Decorazioni(
            "/decorations/banco10.png", 1728, 283, true, new Rectangle(0, 0, 66, 59), 66, 59));
    decoration.add(
        new Decorazioni(
            "/decorations/banco10.png", 1990, 2626, true, new Rectangle(0, 0, 66, 59), 66, 59));
    decoration.add(
        new Decorazioni(
            "/decorations/sedia.png", 480, 192, true, new Rectangle(0, 0, 29, 51), 29, 51));
    decoration.add(
        new Decorazioni(
            "/decorations/sedia.png", 2190, 1704, true, new Rectangle(0, 0, 29, 51), 29, 51));
    decoration.add(
        new Decorazioni(
            "/decorations/sedia.png", 211, 326, true, new Rectangle(0, 0, 29, 51), 29, 51));
    decoration.add(
        new Decorazioni(
            "/decorations/sedia2.png", 816, 48, true, new Rectangle(0, 0, 29, 48), 29, 48));
    decoration.add(
        new Decorazioni(
            "/decorations/sedia10.png", 632, 192, true, new Rectangle(0, 0, 29, 51), 29, 51));
    decoration.add(
        new Decorazioni(
            "/decorations/sedia3.png", 553, 405, true, new Rectangle(0, 0, 30, 34), 30, 34));
    decoration.add(
        new Decorazioni(
            "/decorations/bancosedia10.png", 310, 328, true, new Rectangle(0, 0, 66, 55), 66, 55));
    decoration.add(
        new Decorazioni(
            "/decorations/bancosedia10.png", 549, 288, true, new Rectangle(0, 0, 66, 55), 66, 55));
    decoration.add(
        new Decorazioni(
            "/decorations/bancosedia10.png", 423, 528, true, new Rectangle(0, 0, 66, 55), 66, 55));
    decoration.add(
        new Decorazioni(
            "/decorations/bancosedia4.png", 1589, 1182, true, new Rectangle(0, 0, 38, 66), 38, 66));
    decoration.add(
        new Decorazioni(
            "/decorations/bancosedia1.png", 1968, 2286, true, new Rectangle(0, 0, 38, 66), 38, 66));
    decoration.add(
        new Decorazioni(
            "/decorations/bancosedia4.png", 1589, 1182, true, new Rectangle(0, 0, 38, 66), 38, 66));

    GameMap map =
        this.builder
            .setName("D1.5")
            .setWorldCol(60)
            .setWorldRow(60)
            .setPlayerStartX(8)
            .setPlayerStartY(52)
            .setSoundIndex("D1Music")
            .makeTilesLayer("/maps/mappa_n.csv", ",")
            .makeDecorationLayer(decoration)
            .makeTriggerLayer(interagibili)
            .build();

    GameMapManager gameMapManager = GameMapManager.getInstance();
    gameMapManager.addGameMap(map);
  }
}
