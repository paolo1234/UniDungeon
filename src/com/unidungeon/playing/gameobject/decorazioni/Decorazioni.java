package com.unidungeon.playing.gameobject.decorazioni;

import com.unidungeon.utils.ScaleImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Decorazioni {
  public BufferedImage image;
  public boolean collision;
  public int worldX, worldY;
  public Rectangle boxCollider;
  public int solidAreaDefaultX = 0;
  public int solidAreaDefaultY = 0;

  public Decorazioni(
      String imagePath,
      int worldX,
      int worldY,
      boolean collision,
      Rectangle boxCollider,
      int w,
      int h) {
    try {
      this.image =
          ScaleImage.scaleImage(
              ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))),
              w,
              h);
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.worldX = worldX;
    this.worldY = worldY;
    this.collision = collision;
    this.boxCollider = boxCollider;
  }
}
