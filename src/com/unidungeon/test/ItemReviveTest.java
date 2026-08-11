package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.game.Role;
import com.unidungeon.item.ItemRevive;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import junit.framework.TestCase;

public class ItemReviveTest extends TestCase {
  private ItemRevive itemrevive;
  private Player player;

  public void setUp() throws Exception {
    super.setUp();
    player = this.initPlayer();
    this.itemrevive = new ItemRevive("AmuletoRevive", "Resuscita e rigenera 30% hp", null, 30);
  }

  public void tearDown() throws Exception {
    super.tearDown();
    this.itemrevive = null;
    this.player = null;
  }

  public void testUseItem() {
    // Check revive
    assertTrue(player.isKO());
    this.itemrevive.useItem(player);
    assertTrue(player.isAwake());
    assertEquals(22, player.getHp());
    // Check alive increased hp
    this.itemrevive.useItem(player);
    assertEquals(44, player.getHp());
    // Check stun stays stun
    player.setStun();
    this.itemrevive.useItem(player);
    // assertTrue(!player.isKO() && !player.isAwake());
    assertTrue(player.isStunned());
    assertEquals(66, player.getHp());
  }

  public void testUseItem2() {
    Malus malus[] = new Malus[3];
    malus[0] = MalusHp.getInstance();
    // Check revive
    assertTrue(player.isKO());
    this.itemrevive.useItem(player, malus, 0);
    assertTrue(player.isAwake());
    assertEquals(22, player.getHp());
    // Check alive increased hp
    this.itemrevive.useItem(player, malus, 0);
    assertEquals(44, player.getHp());
    // Check stun stays stun
    player.setStun();
    this.itemrevive.useItem(player, malus, 0);
    System.out.println(player.isKO());
    System.out.println(player.isStunned());
    System.out.println(player.isAwake());
    assertTrue(player.isStunned());
    assertEquals(66, player.getHp());
  }

  public void testGetName() {
    assertEquals("AmuletoRevive", this.itemrevive.getName());
  }

  public void testGetDescription() {
    assertEquals("Resuscita e rigenera 30% hp", this.itemrevive.getDescription());
  }

  public void testGetImage() {
    assertEquals(null, this.itemrevive.getImage());
  }

  public void testGetHpP() {
    assertEquals(30, this.itemrevive.getHpP());
  }

  public Player initPlayer() {
    return new PlayerBuilder()
        .setName("Giada")
        .setIconPath("/battleIcons/Portraits12.png")
        .setCurrentLevel(1)
        .setCurrentEXP(0)
        .setStatus(-1)
        .setRole(Role.LOGIC)
        .setCurrentHP(0)
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
