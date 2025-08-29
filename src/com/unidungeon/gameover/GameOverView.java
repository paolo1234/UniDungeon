package com.unidungeon.gameover;

import com.unidungeon.game.GameView;
import com.unidungeon.utils.TextAlignment;
import com.unidungeon.utils.TextFormat;
import com.unidungeon.utils.TextRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameOverView extends GameView {
    BufferedImage[] rettore;
    Font font;
    int animTick = 0;
    int animSpeed = 8;
    int index = 0;
    public GameOverView(){
        super();
        rettore = new BufferedImage[4];
        try {
             rettore[0] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/gameover/rettoreride1.png")));
             rettore[1] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/gameover/rettoreride2.png")));
             rettore[2] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/gameover/rettoreride3.png")));
             rettore[3] = ImageIO.read(Objects.requireNonNull(getClass().getResource("/gameover/rettoreride4.png")));
             font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResource("/fonts/AGOBLINAPPEARS.TTF")).openStream()).deriveFont(12f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(font);

        Rectangle gameOver = new Rectangle(0, 70, 768,80);
        Rectangle gameOverMess = new Rectangle(0, 170, 768,40);
        Rectangle gameOverZ = new Rectangle(0, 235, 768,32);

        TextRenderer.drawString(
                g,
                "GAME OVER",
                font.deriveFont(50f),
                Color.RED,
                gameOver,
                TextAlignment.MIDDLE,
                TextFormat.NONE
        );

        TextRenderer.drawString(
                g,
                "Oh, ci dispiace, sei stato sconfitto, le consigliamo\n" +
                        "di tornare al prossimo appello...",
                font.deriveFont(14f),
                Color.WHITE,
                gameOverMess,
                TextAlignment.MIDDLE,
                TextFormat.NONE
        );

        TextRenderer.drawString(
                g,
                "Premi [z] per ricominciare",
                font.deriveFont(18f),
                Color.WHITE,
                gameOverZ,
                TextAlignment.MIDDLE,
                TextFormat.NONE
        );

        g2.drawImage(rettore[index], 266,300,236,256, null);
    }
}
