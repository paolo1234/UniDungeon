package com.unidungeon.playing.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Tile {
  public BufferedImage image;
  public int tileIndex;
  public boolean solid;

  public Tile(String tilesFolder, String imageSrc, boolean isSolid) {
    String pathImage = tilesFolder + imageSrc;
    try {
      BufferedImage img = ImageIO.read(Objects.requireNonNull(getClass().getResource(pathImage)));
      System.out.println(getClass().getResource(pathImage));
      this.image = scaleImage(img, 48, 48);
      this.solid = isSolid;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private BufferedImage scaleImage(BufferedImage original, int width, int height) {
    BufferedImage resized = new BufferedImage(width, height, original.getType());
    Graphics2D g = resized.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    g.drawImage(
        original, 0, 0, width, height, 0, 0, original.getWidth(), original.getHeight(), null);
    g.dispose();
    return resized;
  }

  public boolean isSolid() {
    return solid;
  }
}
