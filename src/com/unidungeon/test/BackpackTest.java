package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.game.Role;
import com.unidungeon.item.Backpack;
import com.unidungeon.item.Item;
import com.unidungeon.item.ItemHp;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import junit.framework.TestCase;

// Test
public class BackpackTest extends TestCase {
  private Backpack knackpack;
  private Player player;

  public void setUp() throws Exception {
    super.setUp();
    this.player = this.initPlayer();
    this.knackpack = Backpack.getInstance();
    this.knackpack.clearBackpack();
  }

  public void tearDown() throws Exception {
    super.tearDown();
    this.knackpack.clearBackpack();
    this.knackpack = null;
    this.player = null;
  }

  public void testIsEmpty() {
    assertTrue(this.knackpack.isEmpty());
    this.knackpack.addItem(anItem());
    assertFalse(this.knackpack.isEmpty());
  }

  public void testIsFull() {
    assertFalse(this.knackpack.isFull());
    for (int i = 0; i < 10; i++) this.knackpack.addItem(this.anItem());
    assertTrue(this.knackpack.isFull());
  }

  public void testGetWeight() {
    assertEquals(0, this.knackpack.getWeight());
    this.knackpack.addItem(this.anItem());
    assertEquals(1, this.knackpack.getWeight());
  }

  public void testGetAddItem() {
    assertTrue(this.knackpack.isEmpty());
    assertTrue(this.knackpack.addItem(this.anItem()));
    assertFalse(this.knackpack.isEmpty());
    for (int i = 1; i < 10; i++) this.knackpack.addItem(this.anItem());
    assertTrue(this.knackpack.isFull());
    assertFalse(this.knackpack.addItem(this.anItem()));
  }

  public void testRemoveItem() {
    this.knackpack.addItem(this.anItem());
    assertFalse(this.knackpack.isEmpty());
    this.knackpack.removeItem(0);
    assertTrue(this.knackpack.isEmpty());
  }

  public void testGetBackpack() {
    assertNotNull(this.knackpack.getBackpack());
  }

  public void testUseItem() {
    this.knackpack.addItem(this.anItem());
    assertTrue(this.knackpack.useItem(0, player));
    assertTrue(this.knackpack.isEmpty());
    // Check if KO
    player.setKO();
    this.knackpack.addItem(this.anItem());
    assertFalse(this.knackpack.useItem(0, player));
    assertFalse(this.knackpack.isEmpty());
  }

  public void testUseItem2() {
    Malus malus[] = new Malus[3];
    malus[0] = MalusHp.getInstance();
    this.knackpack.addItem(this.anItem());
    assertTrue(this.knackpack.useItem(0, player, malus, 0));
    assertTrue(this.knackpack.isEmpty());
    // Check if KO
    player.setKO();
    this.knackpack.addItem(this.anItem());
    assertFalse(this.knackpack.useItem(0, player, malus, 0));
    assertFalse(this.knackpack.isEmpty());
  }

  public Item anItem() {
    return new ItemHp("PozzaHp", "Rigenera 20 hp", null, 20);
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
        .setCurrentSP(60)
        .setMaxSP(60)
        .setDmg(6)
        .setDef(3)
        .setProbCrit(30)
        .setSkillSlot(null)
        .build();
  }
}
