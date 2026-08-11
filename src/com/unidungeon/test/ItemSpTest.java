package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.game.Role;
import com.unidungeon.item.ItemSp;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import junit.framework.TestCase;

public class ItemSpTest extends TestCase {
  private ItemSp itemsp;
  private Player player;

  public void setUp() throws Exception {
    super.setUp();
    this.itemsp = new ItemSp("PozzaSp", "Rigenera 20 sp", null, 20);
    this.player = this.initPlayer();
  }

  public void tearDown() throws Exception {
    super.tearDown();
    this.itemsp = null;
    this.player = null;
  }

  public void testUseItem() {
    this.itemsp.useItem(player);
    assertEquals(55, player.getSp());
    this.itemsp.useItem(player);
    assertEquals(60, player.getSp());
    // Check if KO
    player.decreaseSp(50);
    player.setKO();
    this.itemsp.useItem(player);
    assertEquals(10, player.getSp());
  }

  public void testUseItem2() {
    Malus malus[] = new Malus[3];
    malus[0] = MalusHp.getInstance();
    this.itemsp.useItem(player, malus, 0);
    assertEquals(55, player.getSp());
    this.itemsp.useItem(player, malus, 0);
    assertEquals(60, player.getSp());
    // Check if KO
    player.decreaseSp(50);
    player.setKO();
    this.itemsp.useItem(player, malus, 0);
    assertEquals(10, player.getSp());
  }

  public void testGetName() {
    assertEquals("PozzaSp", this.itemsp.getName());
  }

  public void testGetDescription() {
    assertEquals("Rigenera 20 sp", this.itemsp.getDescription());
  }

  public void testGetImage() {
    assertEquals(null, this.itemsp.getImage());
  }

  public void testGetSp() {
    assertEquals(20, this.itemsp.getSp());
  }

  public Player initPlayer() {
    return new PlayerBuilder()
        .setName("Giada")
        .setIconPath("/battleIcons/Portraits12.png")
        .setCurrentLevel(1)
        .setCurrentEXP(0)
        .setStatus(0)
        .setRole(Role.LOGIC)
        .setCurrentHP(50)
        .setMaxHP(75)
        .setCurrentSP(35)
        .setMaxSP(60)
        .setDmg(6)
        .setDef(3)
        .setProbCrit(30)
        .setSkillSlot(null)
        .build();
  }
}
