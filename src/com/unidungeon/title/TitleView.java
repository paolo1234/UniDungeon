package com.unidungeon.title;

import com.unidungeon.game.GameView;
import com.unidungeon.utils.TextAlignment;
import com.unidungeon.utils.TextFormat;
import com.unidungeon.utils.TextRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class TitleView extends GameView {
  TitleController mediator;

  int animTick = 0;
  int animSpeed = 8;

  BufferedImage[] menu;
  BufferedImage logo;
  int index = 0;
  private Font font;

  private int currentAction = 0;

  public TitleView(TitleController mediator) {
    super();
    this.mediator = mediator;
    menu = new BufferedImage[34];
    try {
      menu[0] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/1.png")));
      menu[1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/2.png")));
      menu[2] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/3.png")));
      menu[3] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/4.png")));
      menu[4] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/5.png")));
      menu[5] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/6.png")));
      menu[6] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/7.png")));
      menu[7] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/8.png")));
      menu[8] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/9.png")));
      menu[9] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/10.png")));
      menu[10] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/11.png")));
      menu[11] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/12.png")));
      menu[12] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/13.png")));
      menu[13] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/14.png")));
      menu[14] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/15.png")));
      menu[15] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/16.png")));
      menu[16] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/17.png")));
      menu[17] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/18.png")));
      menu[18] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/19.png")));
      menu[19] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/20.png")));
      menu[20] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/21.png")));
      menu[21] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/22.png")));
      menu[22] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/23.png")));
      menu[23] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/24.png")));
      menu[24] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/25.png")));
      menu[25] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/26.png")));
      menu[26] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/27.png")));
      menu[27] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/28.png")));
      menu[28] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/29.png")));
      menu[29] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/30.png")));
      menu[30] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/31.png")));
      menu[31] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/32.png")));
      menu[32] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/33.png")));
      menu[33] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/menu/34.png")));
      logo = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Uni.png")));
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

    g2.drawImage(menu[index], 134, 0, null);

    g2.setColor(new Color(0xAB000000, true));
    g2.fillRoundRect(259, 385, 250, 158, 30, 30);

    g2.setColor(Color.WHITE);

    g2.drawImage(logo, 219, 67, null);

    Rectangle nuova = new Rectangle(259, 416, 250, 32);
    Rectangle carica = new Rectangle(259, 449, 250, 32);
    Rectangle exit = new Rectangle(259, 481, 250, 32);

    TextRenderer.drawString(
        g,
        "Nuova Partita",
        font,
        (currentAction == 0) ? Color.RED : Color.WHITE,
        nuova,
        TextAlignment.MIDDLE,
        TextFormat.NONE);

    TextRenderer.drawString(
        g,
        "Carica Partita",
        font,
        (currentAction == 1) ? Color.RED : Color.WHITE,
        carica,
        TextAlignment.MIDDLE,
        TextFormat.NONE);

    TextRenderer.drawString(
        g,
        "Esci",
        font,
        (currentAction == 2) ? Color.RED : Color.WHITE,
        exit,
        TextAlignment.MIDDLE,
        TextFormat.NONE);
  }

  public void setCurrentAction(int currentAction) {
    this.currentAction = currentAction;
  }
}
