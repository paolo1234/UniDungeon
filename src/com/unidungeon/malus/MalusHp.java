package com.unidungeon.malus;

import com.unidungeon.entity.Entity;
import java.awt.image.BufferedImage;

public class MalusHp extends Malus {
  private static MalusHp instance;
  private final int hp;

  private MalusHp() {
    this.name = "Stress";
    this.icone = null; // Load up the icone
    this.hp = 15; // 25
  }

  public static Malus getInstance() {
    if (instance == null) {
      instance = new MalusHp();
      return instance;
    }
    return instance;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public BufferedImage getIcone() {
    return this.icone;
  }

  public void executeMalusHp(Entity entity) {
    entity.decreaseHp(this.hp);
  }

  public int getHp() {
    return this.hp;
  }
}
