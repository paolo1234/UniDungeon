package com.unidungeon.entity.mob;

import com.unidungeon.entity.Entity;
import com.unidungeon.skill.Skill;
import java.awt.image.BufferedImage;

public abstract class Mobs extends Entity {
  public abstract Skill randomSkill();

  public abstract BufferedImage getImage();
}
