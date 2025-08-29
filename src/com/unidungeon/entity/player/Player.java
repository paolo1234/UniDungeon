package com.unidungeon.entity.player;

import com.unidungeon.entity.Entity;
import com.unidungeon.game.Role;
import com.unidungeon.skill.Skill;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Random;
import javax.imageio.ImageIO;

public class Player extends Entity {
  private int maxSp; // Player max sp.
  private int currSp; // Player current sp.
  private BufferedImage icon;

  private final int THRESHOLD_LV = 50; // Levelling up thershold increments
  private final int MAX_LV = 30; // Max level reachable
  private final int HP_LV = 10;
  private final int SP_LV = 2;

  public Player(
      String name,
      Role role,
      Skill[] slot_skill,
      int maxHp,
      int maxSp,
      int currHp,
      int currSp,
      int lv,
      int exp,
      float dmg,
      float def,
      int prob_crit,
      int status,
      String iconPath) {
    this.name = name;
    this.role = role;
    this.slot_skill = slot_skill;
    this.maxHp = maxHp;
    this.maxSp = maxSp;
    this.currHp = currHp;
    this.currSp = currSp;
    this.lv = lv;
    this.exp = exp;
    this.dmg = dmg;
    this.def = def;
    this.prob_crit = prob_crit;
    this.status = status;
    try {
      if (iconPath != null) {
        this.icon = ImageIO.read(Objects.requireNonNull(getClass().getResource(iconPath)));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Role getRole() {
    return this.role;
  }

  @Override
  public Skill[] getSlotSkill() {
    return this.slot_skill;
  }

  // Returns boolean true if there's an avaiable slot otherwise false if slots are full.
  public boolean addSkill(Skill skill) {
    int i = 0;
    while (i < 4 && this.slot_skill[i] != null) i++;
    if (i < 4) {
      this.slot_skill[i] = skill;
      return true;
    } else return false;
  }

  public void removeSkill(int index) {
    this.slot_skill[index] = null;
  }

  @Override
  public int getMaxHp() {
    return this.maxHp;
  }

  @Override
  public int getHp() {
    return this.currHp;
  }

  @Override
  public void increaseHp(int hp) {
    this.currHp += hp;
    /*if(this.currHp > 0 && this.isKO())
    this.setAwake();*/
    // Normalize Hp to maxHP.
    if (this.currHp > this.maxHp) this.currHp = this.maxHp;
  }

  @Override
  public void decreaseHp(int hp) {
    this.currHp -= hp;
    // Normalize Hp if death.
    if (this.currHp <= 0) {
      this.currHp = 0;
      this.setKO();
    }
  }

  public int getMaxSp() {
    return this.maxSp;
  }

  public int getSp() {
    return this.currSp;
  }

  public void increaseSp(int sp) {
    this.currSp += sp;
    // Normalize Sp to maxSP.
    if (this.currSp > this.maxSp) this.currSp = this.maxSp;
  }

  public void decreaseSp(int sp) {
    this.currSp -= sp;
  }

  @Override
  public int getLv() {
    return super.lv;
  }

  public void increaseLv() {
    this.exp -= lv * THRESHOLD_LV - 1;
    this.lv++;
    this.maxHp += ((lv - 1) * HP_LV);
    this.maxSp += ((lv - 1) * SP_LV);
    // if((super.lv%5)>0){
    // futura gestione
    // }
  }

  @Override
  public int getExp() {
    return super.exp;
  }

  public void increaseExp(int exp) {
    if (this.lv != MAX_LV) { // Player doesn't earn exp if the level is at its max.
      this.exp += exp;
      if (this.exp > (lv * THRESHOLD_LV)) // Player levels up when exp peeks at level*THRESHOLD_LV.
      this.increaseLv();
    }
  }

  @Override
  public boolean isAwake() {
    return this.status == 0;
  }

  public boolean isStunned() {
    return this.status == 1;
  }

  @Override
  public boolean isKO() {
    return this.status == (-1);
  }

  @Override
  public void setKO() {
    this.status = (-1);
  }

  @Override
  public void setAwake() {
    this.status = 0;
  }

  @Override
  public void setStun() {
    this.status = 1;
  }

  @Override
  public float getDmg() {
    return this.dmg;
  }

  @Override
  public float getDef() {
    return this.def;
  }

  public void setGuard() {
    BigDecimal bd = new BigDecimal(this.def * 1.42).setScale(2, RoundingMode.HALF_DOWN);
    this.def = (float) bd.doubleValue();
  }

  public void removeGuard() {
    BigDecimal bd = new BigDecimal(this.def / 1.42).setScale(2, RoundingMode.HALF_DOWN);
    this.def = (float) bd.doubleValue();
  }

  @Override
  public int getProbCrit() {
    return this.prob_crit;
  }

  @Override
  public boolean hasCrit() {
    Random random = new Random();
    return random.nextInt(100) <= this.prob_crit;
  }

  public BufferedImage getIcon() {
    return icon;
  }
}
