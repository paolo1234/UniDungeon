package com.unidungeon.entity.mob;

import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;
import java.awt.image.BufferedImage;

public class MobDecorator extends Mobs {
  private Mob wrappee;

  public MobDecorator(Mob mob) {
    this.wrappee = mob;
  }

  public String getName() {
    return this.wrappee.getName();
  }

  public Role getRole() {
    return this.wrappee.getRole();
  }

  public Skill[] getSlotSkill() {
    return this.wrappee.getSlotSkill();
  }

  public int getMaxHp() {
    return this.wrappee.getMaxHp();
  }

  public int getHp() {
    return this.wrappee.getHp();
  }

  public void increaseHp(int hp) {
    this.wrappee.increaseHp(hp);
  }

  public void decreaseHp(int hp) {
    this.wrappee.decreaseHp(hp);
  }

  public int getLv() {
    return this.wrappee.getLv();
  }

  public int getExp() {
    return this.wrappee.getExp();
  }

  public boolean isAwake() {
    return this.wrappee.isAwake();
  }

  public boolean isKO() {
    return this.wrappee.isKO();
  }

  public void setKO() {
    this.wrappee.setKO();
  }

  public void setAwake() {
    this.wrappee.setAwake();
  }

  public void setStun() {
    this.wrappee.setStun();
  }

  @Override
  public boolean isStunned() {
    return this.wrappee.isStunned();
  }

  public float getDmg() {
    return this.wrappee.getDmg();
  }

  public float getDef() {
    return this.wrappee.getDef();
  }

  public int getProbCrit() {
    return this.wrappee.getProbCrit();
  }

  public boolean hasCrit() {
    return this.wrappee.hasCrit();
  }

  @Override
  public Skill randomSkill() {
    return this.wrappee.randomSkill();
  }

  @Override
  public BufferedImage getImage() {
    return this.wrappee.getImage();
  }
}
