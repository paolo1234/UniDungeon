package com.unidungeon.entity.mob;

import com.unidungeon.game.Role;

public class Answer{
    private String answer;
    private Role[] role;

    public Answer(String answer,Role[] role){
        this.answer=answer;
        this.role=role;
    }

    public String getAnswer(){
        return this.answer;
    }

    public Role[] getRole(){
        return this.role;
    }
}
