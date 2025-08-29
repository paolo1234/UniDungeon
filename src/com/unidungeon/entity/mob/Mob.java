package com.unidungeon.entity.mob;

import com.unidungeon.game.Role;
import com.unidungeon.entity.Entity;
import com.unidungeon.skill.Skill;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Mob extends Mobs{

    private BufferedImage image;    //Contains the image of the mob
    private int[] prob_skill;       //Contains the probability of the skills contained in slot_skill

    public Mob(String name, Role role, Skill[] slot_skill, int maxHp, int currHp, int lv, int exp, float dmg, float def, int prob_crit, int status,int[] prob_skill, String imagePath){
        this.name = name;
        this.role = role;
        this.slot_skill=slot_skill;
        this.maxHp = maxHp;
        this.currHp = currHp;
        this.lv = lv;
        this.exp = exp;
        this.dmg=dmg;
        this.def=def;
        this.prob_crit=prob_crit;
        this.status=status;
        this.prob_skill=prob_skill;
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Mob(Mob mob){
        if (mob != null){
            this.name = mob.name;
            this.role = mob.role;
            this.slot_skill=mob.slot_skill;
            this.maxHp = mob.maxHp;
            this.currHp = mob.currHp;
            this.lv = mob.lv;
            this.exp = mob.exp;
            this.dmg=mob.dmg;
            this.def=mob.def;
            this.prob_crit=mob.prob_crit;
            this.status=mob.status;
            this.prob_skill=mob.prob_skill;
            this.image = mob.image;
        }
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public Skill[] getSlotSkill(){
        return this.slot_skill;
    }

    @Override
    public int getMaxHp(){
        return this.maxHp;
    }

    @Override
    public int getHp(){
        return this.currHp;
    }

    @Override
    public void increaseHp(int hp){
        this.currHp+=hp;
        //Normalize Hp to maxHP.
        if(this.currHp>this.maxHp)
            this.currHp=this.maxHp;
    }

    @Override
    public void decreaseHp(int hp){
        this.currHp-=hp;
        //Normalize Hp if death.
        if(this.currHp<=0){
            this.currHp=0;
            this.setKO();
        }
    }

    @Override
    public int getLv(){
        return this.lv;
    }

    @Override
    public int getExp(){
        return this.exp;
    }

    @Override
    public boolean isAwake(){
        return this.status == 0;
    }

    @Override
    public boolean isKO(){
        return this.status == (-1);
    }

    @Override
    public boolean isStunned() {
        return this.status == 1;
    }

    @Override
    public void setKO(){
        this.status=(-1);
    }

    @Override
    public void setAwake(){
        this.status=0;
    }

    @Override
    public void setStun(){
        this.status=1;
    }

    @Override
    public float getDmg(){
        return this.dmg;
    }

    @Override
    public float getDef(){
        return this.def;
    }

    @Override
    public int getProbCrit(){
        return this.prob_crit;
    }

    @Override
    public boolean hasCrit(){
        Random random = new Random();
        return random.nextInt(100) <= this.prob_crit;
    }

    public Skill skillOne(){
        return slot_skill[0];
    }

    public Skill skillTwo(){
        return slot_skill[1];
    }

    public Skill randomSkill(){
        Random random = new Random();
        int probability = random.nextInt(100);
        int i=0;
        int prev=prob_skill[i];
        while(probability>=prev) prev+=prob_skill[++i];
        return slot_skill[i];
    }

    public Mob clone(){
        return new Mob(this);
    }

    public BufferedImage getImage() {
        return this.image;
    }
}