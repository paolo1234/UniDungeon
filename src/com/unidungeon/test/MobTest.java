package com.unidungeon.test;

import com.unidungeon.entity.mob.Mob;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;
import java.awt.image.BufferedImage;
import junit.framework.TestCase;

public class MobTest extends TestCase {
  Mob mob;
  Skill[] skill;

  public void setUp() throws Exception {
    super.setUp();
    skill = new Skill[3];
    skill[0] = new Skill("skill1", "ciaosonolaskill1", 5, 6, 2, null, Role.LOGIC, 1);
    skill[1] = new Skill("skill2", "ciaosonolaskill1", 4, 5, 2, null, Role.CREATIVITY, 1);
    skill[2] = new Skill("skill3", "ciaosonolaskill1", 3, 4, 2, null, Role.LOGIC, 1);
    mob =
        new Mob(
            "Alumnus",
            Role.LOGIC,
            skill,
            500,
            500,
            1,
            10,
            1f,
            1f,
            5,
            0,
            new int[] {20, 35, 45},
            "/battleIcons/07b.png");
  }

  public void testRandomSkill() {
    Skill skillOttenuta = mob.randomSkill();
    assertNotNull(skillOttenuta);
    assertTrue(
        "skill1".equals(skillOttenuta.getName())
            || "skill2".equals(skillOttenuta.getName())
            || "skill3".equals(skillOttenuta.getName()));
  }

  public void testGetImage() {
    BufferedImage IconaOttenuta = mob.getImage();
    assertNotNull(IconaOttenuta);
  }

  public void testClone() {
    Mob mob2 = mob.clone();
    assertNotNull(mob2);
    assertNotSame(mob, mob2);
    assertEquals(mob.getName(), mob2.getName());
    assertEquals(mob.getRole(), mob2.getRole());
    assertEquals(mob.getSlotSkill(), mob2.getSlotSkill());
    assertEquals(mob.getMaxHp(), mob2.getMaxHp());
    assertEquals(mob.getHp(), mob2.getHp());
    assertEquals(mob.getLv(), mob.getLv());
    assertEquals(mob.getExp(), mob.getExp());
    assertEquals(mob.getDmg(), mob.getDmg());
    assertEquals(mob.getDef(), mob.getDef());
    assertEquals(mob.getProbCrit(), mob.getProbCrit());
    assertEquals(mob.getImage(), mob.getImage());
  }

  public void tearDown() throws Exception {
    super.tearDown();
    skill = null;
    mob = null;
  }
}
