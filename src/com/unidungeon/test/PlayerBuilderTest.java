package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.game.Role;
import junit.framework.TestCase;

public class PlayerBuilderTest extends TestCase {
  PlayerBuilder playerBuilder;

  public void setUp() throws Exception {
    super.setUp();

    playerBuilder = new PlayerBuilder();
  }

  public void testPlayerBuilder() {
    Player PlayerOttenuto =
        playerBuilder
            .setName("Giada")
            .setCurrentLevel(1)
            .setCurrentEXP(0)
            .setStatus(0)
            .setRole(Role.LOGIC)
            .setCurrentHP(30)
            .setMaxHP(75)
            .setCurrentSP(30)
            .setMaxSP(60)
            .setDmg(6)
            .setDef(3.5f)
            .setProbCrit(0)
            .build();
    assertNotNull(PlayerOttenuto);
    assertEquals("Giada", PlayerOttenuto.getName());
    assertEquals(1, PlayerOttenuto.getLv());
    assertEquals(0, PlayerOttenuto.getExp());
    assertEquals(Role.LOGIC, PlayerOttenuto.getRole());
    assertEquals(30, PlayerOttenuto.getHp());
    assertEquals(75, PlayerOttenuto.getMaxHp());
    assertEquals(30, PlayerOttenuto.getSp());
    assertEquals(60, PlayerOttenuto.getMaxSp());
    assertEquals(6f, PlayerOttenuto.getDmg());
    assertEquals(3.5f, PlayerOttenuto.getDef());
    assertEquals(0, PlayerOttenuto.getProbCrit());
    assertTrue(PlayerOttenuto.isAwake());
  }

  public void tearDown() throws Exception {
    super.tearDown();
    playerBuilder = null;
  }
}
