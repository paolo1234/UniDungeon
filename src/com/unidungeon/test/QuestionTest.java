package com.unidungeon.test;

import com.unidungeon.entity.mob.Answer;
import com.unidungeon.entity.mob.Question;
import com.unidungeon.game.Role;
import junit.framework.TestCase;

//test
public class QuestionTest extends TestCase {
    private Question question;

    public void setUp() throws Exception {
        super.setUp();
        Answer answers[] = new Answer[4];
        answers[0] = new Answer("Risp1", new Role[]{Role.LOGIC});
        answers[1] = new Answer("Risp2", new Role[]{Role.MEMORY});
        answers[2] = new Answer("Risp3", new Role[]{Role.LOGIC, Role.CREATIVITY});
        answers[3] = new Answer("Risp4", new Role[]{Role.LOGIC, Role.MEMORY});
        this.question = new Question("Domanda1", answers, 0);
    }

    public void tearDown() throws Exception {
        super.tearDown();
        this.question = null;
    }

    public void testGetQuestion() {
        assertEquals("Domanda1", this.question.getQuestion());
    }

    public void testGetAnswers() {
        assertNotNull(this.question.getAnswers());
    }

    public void testIsCorrect() {
        assertTrue(this.question.isCorrect(0));
        assertFalse(this.question.isCorrect(1));
        assertFalse(this.question.isCorrect(2));
        assertFalse(this.question.isCorrect(3));
    }
}
