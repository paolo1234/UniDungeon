package com.unidungeon.test;

import com.unidungeon.entity.mob.Answer;
import com.unidungeon.entity.mob.Question;
import com.unidungeon.entity.mob.QuestionBuilder;
import com.unidungeon.game.Role;
import junit.framework.TestCase;

public class QuestionBuilderTest extends TestCase {
  private QuestionBuilder builder;

  public void setUp() throws Exception {
    super.setUp();
    builder = new QuestionBuilder();
  }

  public void tearDown() throws Exception {
    super.tearDown();
    this.builder = null;
  }

  public void testSetQuestion() {
    assertNotNull(this.builder.setQuestion("Domanda1"));
  }

  public void testSetAnswers() {
    Answer answers[] = new Answer[4];
    answers[0] = new Answer("Risp1", new Role[] {Role.LOGIC});
    answers[1] = new Answer("Risp2", new Role[] {Role.MEMORY});
    answers[2] = new Answer("Risp3", new Role[] {Role.LOGIC, Role.CREATIVITY});
    answers[3] = new Answer("Risp4", new Role[] {Role.LOGIC, Role.MEMORY});
    assertNotNull(this.builder.setAnswers(answers));
  }

  public void testSetCorrect(int correct) {
    assertNotNull(this.builder.setCorrect(0));
  }

  public void testBuild() {
    Question question = this.builder.setQuestion("").setAnswers(null).setCorrect(0).build();
    assertNotNull(question);
  }
}
