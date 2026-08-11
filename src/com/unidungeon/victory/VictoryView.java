package com.unidungeon.victory;

import com.unidungeon.game.GameView;
import com.unidungeon.utils.TextAlignment;
import com.unidungeon.utils.TextFormat;
import com.unidungeon.utils.TextRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class VictoryView extends GameView {
  BufferedImage laurea;
  Font font;

  public VictoryView() {
    super();
    try {
      laurea = ImageIO.read(Objects.requireNonNull(getClass().getResource("/diploma.png")));
      font =
          Font.createFont(
                  Font.TRUETYPE_FONT,
                  Objects.requireNonNull(getClass().getResource("/fonts/AGOBLINAPPEARS.TTF"))
                      .openStream())
              .deriveFont(12f);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setFont(font);

    Rectangle gameOver = new Rectangle(0, 70, 768, 80);
    Rectangle gameOverMess = new Rectangle(0, 170, 768, 40);
    Rectangle gameOverZ = new Rectangle(0, 235, 768, 32);

    TextRenderer.drawString(
        g,
        "CONGRATULAZIONI",
        font.deriveFont(45f),
        Color.GREEN,
        gameOver,
        TextAlignment.MIDDLE,
        TextFormat.NONE);

    TextRenderer.drawString(
        g,
        "Hai sconfitto il malvagio rettore e hai finalmente ottenuto la tua meritata laurea!",
        font.deriveFont(14f),
        Color.WHITE,
        gameOverMess,
        TextAlignment.MIDDLE,
        TextFormat.NONE);

    TextRenderer.drawString(
        g,
        "Chiudi il gioco per ricominciare",
        font.deriveFont(18f),
        Color.WHITE,
        gameOverZ,
        TextAlignment.MIDDLE,
        TextFormat.NONE);

    g2.drawImage(laurea, 141, 300, null);
  }
}
