package com.unidungeon.entity.mob;

public class Question {
  private String question;
  private Answer[] answers;
  private int correct;

  public Question(String question, Answer[] answers, int correct) {
    this.question = question;
    this.answers = answers;
    this.correct = correct;
  }

  public String getQuestion() {
    return this.question;
  }

  public Answer[] getAnswers() {
    return this.answers;
  }

  public boolean isCorrect(int index) {
    if (index == this.correct) return true;
    return false;
  }
}
