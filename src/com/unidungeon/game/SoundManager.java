package com.unidungeon.game;

import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
  private Clip clip;
  // private URL soundURL[] = new URL[30];
  private static HashMap<String, URL> soundURL;

  public SoundManager() {
    soundURL = new HashMap<>();
    initClips();
  }

  private void initClips() {
    soundURL.put(
        "battleMusic", Objects.requireNonNull(getClass().getResource("/sounds/Battle.wav")));
    soundURL.put("D1Music", Objects.requireNonNull(getClass().getResource("/sounds/Playing.wav")));
    soundURL.put(
        "salaBoss1Music", Objects.requireNonNull(getClass().getResource("/sounds/salaBoss.wav")));
    soundURL.put(
        "lobbyMusic", Objects.requireNonNull(getClass().getResource("/sounds/lobbymusic.wav")));
    soundURL.put(
        "titleMusic", Objects.requireNonNull(getClass().getResource("/sounds/menumusic.wav")));
    soundURL.put(
        "bossBattleMusic",
        Objects.requireNonNull(getClass().getResource("/sounds/bossbattle.wav")));
    soundURL.put(
        "gameOverMusic",
        Objects.requireNonNull(getClass().getResource("/sounds/gameovermusic.wav")));
    soundURL.put(
        "victoryMusic", Objects.requireNonNull(getClass().getResource("/sounds/goodend.wav")));

    soundURL.put(
        "selectSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/Select.wav")));
    soundURL.put(
        "confirmSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/Confirm.wav")));
    soundURL.put("fugaSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/Fuga.wav")));
    soundURL.put(
        "menuInSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/Menu_In.wav")));
    soundURL.put(
        "menuOutSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/Menu_Out.wav")));
    soundURL.put("hitMobSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/hit.wav")));
    soundURL.put(
        "guardiaSE", Objects.requireNonNull(getClass().getResource("/sounds/SE/guardia.wav")));
  }

  public void addClip(String key, URL url) {
    soundURL.put(key, url);
  }

  private void setFile(String key) {
    try {
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL.get(key));
      clip = AudioSystem.getClip();
      clip.open(ais);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void play() {
    clip.start();
  }

  private void loop() {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void playMusic(String key) {
    this.setFile(key);
    this.play();
    this.loop();
  }

  public void stopMusic() {
    if (this.clip != null) clip.stop();
  }

  public void playSE(String key) {
    this.setFile(key);
    this.play();
  }
}
