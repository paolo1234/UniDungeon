package com.unidungeon.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScaleImage {
  public static BufferedImage scaleImage(BufferedImage original, int width, int height) {

    BufferedImage resized = new BufferedImage(width, height, original.getType());
    Graphics2D g = resized.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    g.drawImage(
        original, 0, 0, width, height, 0, 0, original.getWidth(), original.getHeight(), null);
    g.dispose();

    return resized;
  }
}
