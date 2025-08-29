package com.unidungeon.entity.mob;

public class QuestionBuilder{
    private String question;
    private Answer[] answers;
    private int correct;

    public QuestionBuilder setQuestion(String question){
         this.question=question;
         return this;
    }

    public QuestionBuilder setAnswers(Answer[] answers){
         this.answers=answers;
         return this;
    }

    public QuestionBuilder setCorrect(int correct){
         this.correct=correct;
         return this;
    }

    public Question build(){
        return new Question(this.question,this.answers,this.correct);
    }
}


