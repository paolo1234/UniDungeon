package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.game.Role;
import com.unidungeon.item.Backpack;
import junit.framework.TestCase;

public class ItemTest extends TestCase {
  Backpack inventario;
  Player player;

  public void setUp() throws Exception {
    super.setUp();
    inventario = Backpack.getInstance();
    resetPlayerValue();
  }

  void resetPlayerValue() {
    player =
        new Player(
            "Giada",
            Role.LOGIC,
            null,
            75,
            60,
            15,
            10,
            1,
            0,
            6,
            3,
            0,
            0,
            "/battleIcons/Portraits1.png");
  }

  public void testHPitem() {
    // small item expected, actual   +10
    resetPlayerValue(); // 15 HP
    // item.use(player);
    assertEquals(25, player.getHp());
    // regular item                  +25
    resetPlayerValue(); // 15 HP
    // item.use(player);
    assertEquals(40, player.getHp());
    // big item                      +50
    resetPlayerValue(); // 15 HP
    // item.use(player);
    assertEquals(65, player.getHp());
  }

  public void testSPitem() {
    // small item expected, actual   +10
    resetPlayerValue(); // 10 SP
    // item.use(player);
    assertEquals(20, player.getSp());
    // regular item                  +25
    resetPlayerValue(); // 10 SP
    // item.use(player);
    assertEquals(35, player.getSp());
    // big item                      +50
    resetPlayerValue(); // 10 SP
    // item.use(player);
    assertEquals(60, player.getSp());
  }

  public void testReviveitem() {
    // small item expected, actual   +10
    resetPlayerValue(); // 10 SP
    player.setKO();
    // item.use(player);
    assertFalse(player.isKO());
  }

  public void testCombineditem() {
    // small item expected, actual   +10
    resetPlayerValue(); // 10 SP
    player.setKO();
    // HP: 15
    // SP: 10
    // compositeItem.addItem(Revive, HP (small), SP (small))
    // item.use(player);
    assertFalse(player.isKO());
    assertEquals(25, player.getHp());
    assertEquals(20, player.getSp());
  }

  public void tearDown() throws Exception {
    super.tearDown();
  }
}
