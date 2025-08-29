package com.unidungeon.test;

import com.unidungeon.entity.mob.Mob;
import com.unidungeon.entity.mob.MobBuilder;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;
import junit.framework.TestCase;

public class MobBuilderTest extends TestCase {
  MobBuilder mob;
  Skill[] skill;

  public void setUp() throws Exception {
    super.setUp();
    mob = new MobBuilder();
    skill = new Skill[4];
    skill[0] = new Skill("skill1", "ciaosonolaskill1", 5, 6, 2, null, Role.LOGIC, 1);
    skill[1] = new Skill("skill2", "ciaosonolaskill1", 4, 5, 2, null, Role.CREATIVITY, 1);
    skill[2] = new Skill("skill3", "ciaosonolaskill1", 3, 4, 2, null, Role.LOGIC, 1);
  }

  public void testMobBuilder() {
    Mob MobOttenuto =
        mob.setName("Alumnus")
            .setIconPath("/battleIcons/Portraits1.png")
            .setRole(Role.LOGIC)
            .setSkillSlot(skill)
            .setMaxHp(75)
            .setLv(2)
            .setExp(5)
            .setDmg(6)
            .setDef(3.5f)
            .setProbCrit(0)
            .build();
    assertEquals("Alumnus", MobOttenuto.getName());
    assertEquals(Role.LOGIC, MobOttenuto.getRole());
    assertEquals(skill, MobOttenuto.getSlotSkill());
    assertEquals(75, MobOttenuto.getMaxHp());
    assertEquals(2, MobOttenuto.getLv());
    assertEquals(5, MobOttenuto.getExp());
    assertEquals(6f, MobOttenuto.getDmg());
    assertEquals(3.5f, MobOttenuto.getDef());
    assertEquals(0, MobOttenuto.getProbCrit());
    assertTrue(MobOttenuto.isAwake());
  }

  public void tearDown() throws Exception {
    super.tearDown();
    mob = null;
    skill = null;
  }
}
