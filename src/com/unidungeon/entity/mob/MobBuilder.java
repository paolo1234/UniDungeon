package com.unidungeon.entity.mob;

import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;

public class MobBuilder{
    private String name;         //Mob name.
    private Role role;           //Mob role.
    private Skill slot_skill[];  //Chosen slot skill of a certain Mob.
    private int maxHp;           //Mob max hp.
    private int lv;              //Mob current lv.
    private int exp;             //Mob current exp amount.
    private float dmg;           //Mob damage statistic.
    private float def;           //Mob defence statistic.
    private int prob_crit;       //Mob critical hit probability statistic.
    private int[] prob_skill;    //Contains the probability of the skills contained in slot_skill
    private String iconPath;
    private int currHP;
    private int status;

    public MobBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MobBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public MobBuilder setSkillSlot(Skill[] skillSlot) {
        this.slot_skill = skillSlot;
        return this;
    }

    public MobBuilder setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public MobBuilder setLv(int lv) {
        this.lv = lv;
        return this;
    }

    public MobBuilder setExp(int exp) {
        this.exp = exp;
        return this;
    }

    public MobBuilder setDmg(float dmg) {
        this.dmg = dmg;
        return this;
    }

    public MobBuilder setDef(float def) {
        this.def = def;
        return this;
    }

    public MobBuilder setProbCrit(int prob_crit) {
        this.prob_crit = prob_crit;
        return this;
    }

    public MobBuilder setProbSkill(int[] prob_skill) {
        this.prob_skill = prob_skill;
        return this;
    }

    public MobBuilder setIconPath(String iconPath) {
        this.iconPath = iconPath;
        return this;
    }

    public MobBuilder setHp(int hp) {
        this.currHP = hp;
        return this;
    }
    public MobBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public Mob build(){
        return new Mob(name,role,slot_skill,maxHp, currHP, lv,exp,dmg,def, prob_crit, status, prob_skill,iconPath);
    }
}