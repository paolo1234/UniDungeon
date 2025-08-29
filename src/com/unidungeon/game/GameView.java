package com.unidungeon.game;

import javax.swing.*;
import java.awt.*;

public abstract class GameView extends JPanel {
    public GameView(){
        super();
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
