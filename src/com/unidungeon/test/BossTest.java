package com.unidungeon.test;

import com.unidungeon.entity.mob.*;
import com.unidungeon.game.Badge;
import com.unidungeon.game.Role;
import junit.framework.TestCase;

// test
public class BossTest extends TestCase {
  private Boss boss;

  public void setUp() throws Exception {
    super.setUp();
    Answer answers[] = new Answer[4];
    answers[0] = new Answer("Risp1", new Role[] {Role.LOGIC});
    answers[1] = new Answer("Risp2", new Role[] {Role.MEMORY});
    answers[2] = new Answer("Risp3", new Role[] {Role.LOGIC, Role.CREATIVITY});
    answers[3] = new Answer("Risp4", new Role[] {Role.LOGIC, Role.MEMORY});
    Question questions[] = new Question[4];
    questions[0] = new Question("Domanda1", answers, 0);
    questions[1] = new Question("Domanda1", answers, 1);
    questions[2] = new Question("Domanda1", answers, 2);
    questions[3] = new Question("Domanda1", answers, 3);
    this.boss = new Boss(initMob(), questions, Badge.SOFTWARE);
  }

  public void tearDown() throws Exception {
    super.tearDown();
    this.boss = null;
  }

  public void testGetNervous() {
    assertEquals(0, this.boss.getNervous());
  }

  public void testGuardNervous() {
    this.boss.guardNervous();
    assertEquals(5, this.boss.getNervous());
  }

  public void testIncreaseNervous() {
    this.boss.increaseNervous(20);
    assertEquals(20, this.boss.getNervous());
  }

  public void testDecreaseNervous() {
    this.boss.increaseNervous(35);
    assertEquals(35, this.boss.getNervous());
    this.boss.decreaseNervous(); // -20
    assertEquals(15, this.boss.getNervous());
  }

  public void testGetGrade() {
    assertEquals(30.0f, this.boss.getGrade());
  }

  public void testHasFailed() {
    assertFalse(this.boss.hasFailed());
    for (int i = 0; i < 2; i++) this.boss.wrongRage();
    assertTrue(this.boss.hasFailed());
  }

  public void testWrongAnswer() {
    this.boss.wrongAnswer();
    assertEquals(26.0f, this.boss.getGrade());
  }

  public void testWrongRage() {
    this.boss.wrongRage();
    assertEquals(23.5f, this.boss.getGrade());
  }

  public void testCorrectRage() {
    this.boss.correctRage();
    assertEquals(28.5f, this.boss.getGrade());
  }

  public void testIsRage() {
    assertFalse(this.boss.isRage());
    this.boss.increaseNervous(60);
    assertTrue(this.boss.isRage());
  }

  public void testGetQuestion() {
    assertNotNull(this.boss.getQuestions());
  }

  public void testGetBadge() {
    assertEquals(Badge.SOFTWARE, this.boss.getBadge());
  }

  public Mob initMob() {
    return new MobBuilder()
        .setName("Boss")
        .setIconPath("/battleIcons/Portraits1.png")
        .setRole(null)
        .setSkillSlot(null)
        .setMaxHp(75)
        .setLv(2)
        .setExp(5)
        .setDmg(6)
        .setDef(3.5f)
        .setProbCrit(0)
        .build();
  }
}
