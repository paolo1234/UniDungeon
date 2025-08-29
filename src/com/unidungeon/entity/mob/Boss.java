package com.unidungeon.entity.mob;

import com.unidungeon.game.Badge;

public class Boss extends MobDecorator {
    private int nervous;                //Boss nervousness
    private float grade;                //Actual grade during fight
    private Question[] questions;       //Questions of the boss, 4 questions for each critical phase.
    private Badge badge;

    public Boss(Mob mob, Question[] questions, Badge badge){
        super(mob);
        this.nervous=0;
        this.grade=30.0f;
        this.questions=questions;
        this.badge=badge;
    }

    public int getNervous(){
        return this.nervous;
    }

    public void guardNervous(){
        this.nervous+=5;
    }

    public void decreaseNervous(){
        this.nervous-=20;
        if(this.nervous<0)
            nervous=0;
    }

    public void increaseNervous(int nervous){
        this.nervous+=nervous;
        if(this.nervous>100)
            this.nervous=100;
    }

    public float getGrade(){
        return this.grade;
    }

    public boolean hasFailed(){
        return grade < 18;
    }

    public void wrongAnswer(){
        this.grade-=4;
    }

    public void wrongRage(){
        this.grade-=6.5;
    }

    public void correctRage(){
        this.grade-=1.5;
    }

    public boolean isRage(){
        return this.nervous >= 60;
    }

    public Question[] getQuestions(){
        return this.questions;
    }

    public Badge getBadge(){
        return this.badge;
    }

}

