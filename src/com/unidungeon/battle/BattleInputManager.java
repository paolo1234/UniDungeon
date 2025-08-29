package com.unidungeon.battle;

import static java.awt.event.KeyEvent.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BattleInputManager implements KeyListener {

  boolean upPressed;
  boolean leftPressed;
  boolean rightPressed;
  boolean downPressed;
  boolean confirmPressed;
  boolean backPressed;

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code) {
      case VK_UP -> upPressed = true;
      case VK_LEFT -> leftPressed = true;
      case VK_RIGHT -> rightPressed = true;
      case VK_DOWN -> downPressed = true;
      case VK_Z -> confirmPressed = true;
      case VK_C -> backPressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  public boolean isUpPressed() {
    return upPressed;
  }

  public void setUpPressed(boolean upPressed) {
    this.upPressed = upPressed;
  }

  public boolean isLeftPressed() {
    return leftPressed;
  }

  public void setLeftPressed(boolean leftPressed) {
    this.leftPressed = leftPressed;
  }

  public boolean isRightPressed() {
    return rightPressed;
  }

  public void setRightPressed(boolean rightPressed) {
    this.rightPressed = rightPressed;
  }

  public boolean isDownPressed() {
    return downPressed;
  }

  public void setDownPressed(boolean downPressed) {
    // startTime  = System.currentTimeMillis();
    this.downPressed = downPressed;
  }

  public boolean isConfirmPressed() {
    return confirmPressed;
  }

  public void setConfirmPressed(boolean confirmPressed) {
    this.confirmPressed = confirmPressed;
  }
}
