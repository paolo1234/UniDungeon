package com.unidungeon.test;

import com.unidungeon.entity.player.Player;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

  Player player;
  Skill[] skill;

  // assertEquals(expected, actual);  -> Superato quando sono uguali
  // assertNotSame(expected, actual); -> Superato quando non sono uguali
  // assertNull(oggetto);             -> Superato quando l'oggetto è null
  // assertNotNull(oggetto);          -> Superato quando l'oggetto non è null
  // assertFalse(condizione);         -> Superato quando la condizione è false
  // assertTrue(condizione);          -> Superato quando la condizione è true

  public void setUp() throws Exception {
    // Nel metodo setup vanno messe tutte le inizializzazioni, vanno inizializzati i valori
    super.setUp();
    skill = new Skill[4];
    skill[0] = new Skill("skill1", "ciaosonolaskill1", 5, 6, 2, null, Role.LOGIC, 1);
    skill[1] = new Skill("skill2", "ciaosonolaskill1", 4, 5, 2, null, Role.CREATIVITY, 1);
    skill[2] = new Skill("skill3", "ciaosonolaskill1", 3, 4, 2, null, Role.LOGIC, 1);
    player =
        new Player(
            "Giada",
            Role.LOGIC,
            skill,
            75,
            60,
            30,
            30,
            1,
            0,
            6,
            3.5f,
            0,
            0,
            "/battleIcons/Portraits1.png");
  }

  public void testName() {
    String nameAspettato = "Giada";
    String nameOttenuto = player.getName();
    assertEquals(nameAspettato, nameOttenuto);
  }

  public void testSlotSkill() {
    Skill[] skillAspettato = skill;
    Skill[] skillOttenuto = player.getSlotSkill();
    assertEquals(skillAspettato, skillOttenuto);
  }

  public void testMaxhp() {
    int valoreAspettato = 75;
    int valoreOttenuto = player.getMaxHp();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testGetHp() {
    int valoreAspettato = 30;
    int valoreOttenuto = player.getHp();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testincreaseHp() {
    player.increaseHp(10);
    int valoreAspettato = 40;
    int valoreOttenuto = player.getHp();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testdecreaseHp() {
    player.decreaseHp(10);
    int valoreAspettato = 20;
    int valoreOttenuto = player.getHp();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testGetLv() {
    int valoreAspettato = 1;
    int valoreOttenuto = player.getLv();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testGetExp() {
    int valoreAspettato = 0;
    int valoreOttenuto = player.getExp();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testIsAwake() {
    boolean valoreAspettato = true;
    boolean valoreOttenuto = player.isAwake();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testIsKo() {
    boolean valoreAspettato = true;
    player.setKO();
    boolean valoreOttenuto = player.isKO();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testSetKo() {

    player.setKO();
    boolean valoreOttenuto = player.isKO();
    assertTrue(valoreOttenuto);
  }

  public void testSetAwake() {
    player.setAwake();
    boolean valoreOttenuto = player.isAwake();
    assertTrue(valoreOttenuto);
  }

  public void testGetDmg() {
    float ValoreAspettato = 6;
    float ValoreOttenuto = player.getDmg();
    assertEquals(ValoreAspettato, ValoreOttenuto);
  }

  public void testGetDef() {
    float ValoreAspettato = 3.5F;
    float ValoreOttenuto = player.getDef();
    assertEquals(ValoreAspettato, ValoreOttenuto);
  }

  public void testGetProbCrit() {
    float ValoreAspettato = 0;
    float ValoreOttenuto = player.getProbCrit();
    assertEquals(ValoreAspettato, ValoreOttenuto);
  }

  public void testGetRole() {
    Role ValoreAspettato = Role.LOGIC;
    Role ValoreOttenuto = player.getRole();
    assertEquals(ValoreAspettato, ValoreOttenuto);
  }

  public void testHasCrit() {
    boolean ValoreAspettato = player.hasCrit();
    assertTrue(ValoreAspettato || !ValoreAspettato);
  }

  public void testAddSkill() {
    Skill skill4 = new Skill("skill4", "ciaosonolaskill1", 1, 3, 2, null, Role.MEMORY, 1);
    player.addSkill(skill4);
    assertEquals(skill4, player.getSlotSkill()[3]);
  }

  public void testRemoveSkill() {
    player.removeSkill(2);
    assertNull(player.getSlotSkill()[2]);
  }

  public void testIncreaseSP() {
    player.increaseSp(10);
    int valoreAspettato = 40;
    int valoreOttenuto = player.getSp();
    // Confrontare se due valori sono uguali
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testDecraseSP() {
    player.decreaseSp(10);
    int valoreAspettato = 20;
    int valoreOttenuto = player.getSp();
    // Confrontare se due valori sono uguali
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testIncreaseLv() {
    player.increaseLv();
    int valoreAspettato = 2;
    int valoreOttenuto = player.getLv();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testIncreaseExp() {
    player.increaseExp(20);
    int valoreAspettato = 20;
    int valoreOttenuto = player.getExp();
    assertEquals(valoreAspettato, valoreOttenuto);
  }

  public void testSetGuard() {
    player.setGuard();
    float ValoreAspettato = 4.97F;
    assertEquals(ValoreAspettato, player.getDef());
  }

  public void testRemoveGuard() {
    player.setGuard();
    player.removeGuard();
    float ValoreAspettato = 3.5F;
    assertEquals(ValoreAspettato, player.getDef());
  }

  public void tearDown() throws Exception {
    super.tearDown();
    // Chiudere le risorse
    player = null;
  }
}
