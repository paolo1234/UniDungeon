package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.game.Role;
import com.unidungeon.item.ItemHp;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import junit.framework.TestCase;

public class ItemHpTest extends TestCase {
    private ItemHp itemhp;
    private Player player;

    public void setUp() throws Exception {
        super.setUp();
        player = this.initPlayer();
        this.itemhp = new ItemHp("PozzaHp", "Rigenera 20 hp", null, 20);
    }

    public void tearDown() throws Exception {
        super.tearDown();
        this.itemhp = null;
        this.player = null;
    }

    public void testUseItem() {
        this.itemhp.useItem(player);
        assertEquals(70, player.getHp());
        this.itemhp.useItem(player);
        assertEquals(75, player.getHp());
        //Check if KO
        player.decreaseHp(75);
        assertTrue(player.isKO());
        this.itemhp.useItem(player);
        assertEquals(0, player.getHp());
    }

    public void testUseItem2() {
        Malus malus[] = new Malus[3];
        malus[0] = MalusHp.getInstance();
        this.itemhp.useItem(player, malus, 0);
        assertEquals(70, player.getHp());
        this.itemhp.useItem(player, malus, 0);
        assertEquals(75, player.getHp());
        //Check if KO
        player.decreaseHp(75);
        assertTrue(player.isKO());
        this.itemhp.useItem(player, malus, 0);
        assertEquals(0, player.getHp());
    }

    public void testGetName() {
        assertEquals("PozzaHp", this.itemhp.getName());
    }

    public void testGetDescription() {
        assertEquals("Rigenera 20 hp", this.itemhp.getDescription());
    }

    public void testGetImage() {
        assertNull(this.itemhp.getImage());
    }

    public void testGetHp() {
        assertEquals(20, this.itemhp.getHp());
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
