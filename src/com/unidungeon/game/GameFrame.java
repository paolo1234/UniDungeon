package com.unidungeon.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class GameFrame extends JFrame {

    private static GameFrame gameFrame;
    private SoundManager backgroundMusicManager;

    private GameFrame(String title) {
        super();
        this.backgroundMusicManager = new SoundManager();
        this.setTitle(title);
        try {
            this.setIconImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Matita_Sagoma.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static GameFrame getGameFrame(){
        if (gameFrame == null){
            gameFrame = new GameFrame("UniDungeon");
        }
        return gameFrame;
    }

    public void setView(GameView view){
        this.setContentPane(view);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void changeBackgroundMusic(String key){
        this.backgroundMusicManager.stopMusic();
        this.backgroundMusicManager.playMusic(key);
    }

    public void stopMusic(){
        this.backgroundMusicManager.stopMusic();
    }
}
