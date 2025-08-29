package com.unidungeon.entity.player;

import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;

public class PlayerBuilder{
    private String name;        //Player name.
    private Role role;    //Player role.
    private Skill slot_skill[]; //Chosen slot skill of a certain player.
    private int maxHp;          //Player max hp.
    private int maxSp;          //Player max sp.
    private int currHp;         //Player current sp.
    private int currSp;         //Player current sp.
    private int lv;             //PLayer current lv.
    private int exp;            //Player current exp amount.
    private float dmg;          //Player damage statistic.
    private float def;          //Player defence statistic.
    private int prob_crit;    //Player critical hit probability statistic.
    private int status;         //Valuse -1 when an entity is KO, 0 when an entity is alive, 1 the entity is stunned
    private String iconPath;

    public PlayerBuilder(){
        this.slot_skill = new Skill[4];
    }

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setIconPath(String iconPath) {
        this.iconPath = iconPath;
        return this;
    }

    public PlayerBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public PlayerBuilder setCurrentLevel(int currentLevel) {
        this.lv = currentLevel;
        return this;
    }

    public PlayerBuilder setDmg(float dmg) {
        this.dmg = dmg;
        return this;
    }

    public PlayerBuilder setDef(float def) {
        this.def = def;
        return this;
    }

    public PlayerBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public PlayerBuilder setProbCrit(int prob_crit) {
        this.prob_crit = prob_crit;
        return this;
    }

    public PlayerBuilder setCurrentHP(int currentHP) {
        this.currHp = currentHP;
        return this;
    }

    public PlayerBuilder setCurrentSP(int currentSP) {
        this.currSp = currentSP;
        return this;
    }

    public PlayerBuilder setCurrentEXP(int currentEXP) {
        this.exp = currentEXP;
        return this;
    }

    public PlayerBuilder setMaxHP(int maxHP) {
        this.maxHp = maxHP;
        return this;
    }

    public PlayerBuilder setMaxSP(int maxSP) {
        this.maxSp = maxSP;
        return this;
    }

    public PlayerBuilder setSkillSlot(Skill[] skillSlot) {
        this.slot_skill = skillSlot;
        return this;
    }

    public Player build(){
        return new Player(name,role,slot_skill,maxHp,maxSp,currHp,currSp,lv,exp,dmg,def,prob_crit,status,iconPath);
    }
}
