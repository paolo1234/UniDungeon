package com.unidungeon.playing.gameobject.interagibili;

import com.unidungeon.game.GameModel;
import com.unidungeon.utils.ScaleImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class MapChangeTrigger extends Interagibili {
  private String mapName;

  public MapChangeTrigger(
      int worldX, int worldY, boolean solid, Rectangle boxCollider, String mapName) {
    this.worldX = worldX;
    this.worldY = worldY;
    this.solid = solid;
    this.boxCollider = boxCollider;
    this.mapName = mapName;
  }

  public MapChangeTrigger(
      int worldX,
      int worldY,
      boolean solid,
      Rectangle boxCollider,
      String mapName,
      String imagePath,
      int width,
      int height) {
    this.worldX = worldX;
    this.worldY = worldY;
    this.solid = solid;
    this.boxCollider = boxCollider;
    this.mapName = mapName;
    try {
      this.image =
          ScaleImage.scaleImage(
              ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath))),
              width,
              height);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void action() {
    GameModel.getGameModel().getPlayingModel().setCurrentGameMap(this.mapName);
  }

  @Override
  public int getWorldX() {
    return this.worldX;
  }

  @Override
  public int getWorldY() {
    return this.worldY;
  }

  @Override
  public BufferedImage getImage() {
    return this.image;
  }

  @Override
  public Rectangle getBoxCollider() {
    return this.boxCollider;
  }

  @Override
  public boolean isSolid() {
    return this.solid;
  }
}
