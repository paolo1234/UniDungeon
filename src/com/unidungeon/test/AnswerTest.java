package com.unidungeon.test;

import com.unidungeon.entity.mob.Answer;
import com.unidungeon.game.Role;
import junit.framework.TestCase;

// test
public class AnswerTest extends TestCase {
  private Answer answer;

  public void setUp() throws Exception {
    super.setUp();
    this.answer = new Answer("Risp1", new Role[] {Role.LOGIC});
  }

  public void tearDown() throws Exception {
    super.tearDown();
    this.answer = null;
  }

  public void testGetAnswer() {
    assertEquals("Risp1", this.answer.getAnswer());
  }

  public void testGetRole() {
    assertNotNull(this.answer.getRole());
  }
}
