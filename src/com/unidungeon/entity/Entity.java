package com.unidungeon.entity;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;

public abstract class Entity{
    protected String name;        //Entity name.
    protected Skill slot_skill[]; //Chosen slot skill of a certain player.
    protected int maxHp;          //Entity max hp.
    protected int currHp;         //Entity current hp.
    protected int lv;             //Entity current lv.
    protected int exp;            //Entity current exp amount.
    protected float dmg;          //Entity damage statistic.
    protected float def;          //Entity defence statistic.
    protected int prob_crit;      //Entity critical hit probability statistic.
    protected int status;         //Valuse -1 when an entity is KO, 0 when an entity is alive, 1 the entity is stunned
    protected Role role;          //Entity role


    public abstract String getName();
    public abstract Skill[] getSlotSkill();
    public abstract int getMaxHp();
    public abstract int getHp();
    public abstract void increaseHp(int hp);
    public abstract void decreaseHp(int hp);
    public abstract int getLv();
    public abstract int getExp();
    public abstract boolean isAwake();
    public abstract boolean isKO();
    public abstract boolean isStunned();
    public abstract void setKO();
    public abstract void setAwake();
    public abstract void setStun();
    public abstract float getDmg();
    public abstract float getDef();
    public abstract int getProbCrit();
    public abstract boolean hasCrit();
    public abstract Role getRole();
}
