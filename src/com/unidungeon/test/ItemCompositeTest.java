package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.entity.player.PlayerBuilder;
import com.unidungeon.game.Role;
import com.unidungeon.item.CompositeItem;
import com.unidungeon.item.ItemHp;
import com.unidungeon.item.ItemSp;
import junit.framework.TestCase;

public class ItemCompositeTest extends TestCase {
    private Player player;

    public void setUp() throws Exception {
        super.setUp();
        this.player = this.initPlayer();
    }

    public void testUseToPlayer() {
        CompositeItem itemHPSP =
                new CompositeItem(
                        new ItemHp("PozzaHp", "Rigenera 20 hp", null, 20),
                        new ItemSp("PozzaSp", "Rigenera 10 sp", null, 20)
                );
        itemHPSP.useItem(player);
        assertEquals(40, player.getHp());
        assertEquals(40, player.getSp());
    }

    public Player initPlayer() {
        return new PlayerBuilder()
                .setName("Giada")
                .setIconPath("/battleIcons/Portraits12.png")
                .setCurrentLevel(1)
                .setCurrentEXP(0)
                .setStatus(0)
                .setRole(Role.LOGIC)
                .setCurrentHP(20)
                .setMaxHP(75)
                .setCurrentSP(20)
                .setMaxSP(60)
                .setDmg(6)
                .setDef(3)
                .setProbCrit(30)
                .setSkillSlot(null)
                .build();
    }

    public void tearDown() throws Exception {
        super.tearDown();
        this.player = null;
    }
}
