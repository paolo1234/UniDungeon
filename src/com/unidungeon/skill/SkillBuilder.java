package com.unidungeon.skill;

import com.unidungeon.game.Role;
import com.unidungeon.malus.Malus;
import com.unidungeon.malus.MalusHp;
import com.unidungeon.malus.MalusMiss;
import com.unidungeon.malus.MalusStun;

public class SkillBuilder{
    private String name;
    private String description;
    private int cost_sp;
    private int dmg;
    private int prob_malus;
    private Malus malus;
    private Role role;
    private int lv_unlock;

    public SkillBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SkillBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public SkillBuilder setCostSp(int cost_sp) {
        this.cost_sp = cost_sp;
        return this;
    }

    public SkillBuilder setDmg(int dmg) {
        this.dmg = dmg;
        return this;
    }
    

    public SkillBuilder setProbMalus(int prob_malus) {
        this.prob_malus = prob_malus;
        return this;
    }

    //Wants a string with the name of the malus
    public SkillBuilder setMalus(String malus) {
        if(!malus.isBlank())
            if(malus.equalsIgnoreCase("confusione")){
                //Confusione
                this.malus = MalusHp.getInstance();
            }else{
                if(malus.equalsIgnoreCase("stress")){
                    //Stress
                    this.malus = MalusStun.getInstance();
                }else{
                    //Scoraggiamento
                    this.malus = MalusMiss.getInstance();
                }
            }
        return this;
    }

    public SkillBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public SkillBuilder setLvUnlock(int lv_unlock) {
        this.lv_unlock = lv_unlock;
        return this;
    }

    public Skill build(){
        return new Skill(this.name,this.description,this.cost_sp,this.dmg,this.prob_malus,this.malus,this.role,this.lv_unlock);
    }
}
