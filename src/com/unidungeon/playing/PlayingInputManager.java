package com.unidungeon.playing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayingInputManager implements KeyListener {

  public int upKey;
  public boolean upKeyPressed;

  public int leftKey;
  public boolean leftKeyPressed;

  public int rightKey;
  public boolean rightKeyPressed;

  public int downKey;
  public boolean downKeyPressed;

  public int menuKey;
  public boolean menuKeyPressed;

  public int confirmKey;
  public boolean confirmKeyPressed;

  public PlayingInputManager() {
    setKeyLayout();
    // setKeyWASDLayout();
  }

  public void setKeyLayout() {
    this.upKey = KeyEvent.VK_UP;
    this.leftKey = KeyEvent.VK_LEFT;
    this.rightKey = KeyEvent.VK_RIGHT;
    this.downKey = KeyEvent.VK_DOWN;
    this.menuKey = KeyEvent.VK_C;
    this.confirmKey = KeyEvent.VK_Z;
  }

  public void setKeyWASDLayout() {
    this.upKey = KeyEvent.VK_W;
    this.leftKey = KeyEvent.VK_A;
    this.rightKey = KeyEvent.VK_D;
    this.downKey = KeyEvent.VK_S;
    this.menuKey = KeyEvent.VK_I;
    this.confirmKey = KeyEvent.VK_Z;
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == upKey) {
      upKeyPressed = true;
    }
    if (code == rightKey) {
      rightKeyPressed = true;
    }
    if (code == leftKey) {
      leftKeyPressed = true;
    }
    if (code == downKey) {
      downKeyPressed = true;
    }
    if (code == menuKey) {
      menuKeyPressed = true;
    }
    if (code == confirmKey) {
      confirmKeyPressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == upKey) {
      upKeyPressed = false;
    }
    if (code == rightKey) {
      rightKeyPressed = false;
    }
    if (code == leftKey) {
      leftKeyPressed = false;
    }
    if (code == downKey) {
      downKeyPressed = false;
    }
  }

  public void setMenuKeyPressed(boolean menuKeyPressed) {
    this.menuKeyPressed = menuKeyPressed;
  }

  public boolean isUpKeyPressed() {
    return upKeyPressed;
  }

  public boolean isLeftKeyPressed() {
    return leftKeyPressed;
  }

  public boolean isRightKeyPressed() {
    return rightKeyPressed;
  }

  public boolean isDownKeyPressed() {
    return downKeyPressed;
  }

  public boolean isMenuKeyPressed() {
    return menuKeyPressed;
  }

  public void setUpKeyPressed(boolean upKeyPressed) {
    this.upKeyPressed = upKeyPressed;
  }

  public void setLeftKeyPressed(boolean leftKeyPressed) {
    this.leftKeyPressed = leftKeyPressed;
  }

  public void setRightKeyPressed(boolean rightKeyPressed) {
    this.rightKeyPressed = rightKeyPressed;
  }

  public void setDownKeyPressed(boolean downKeyPressed) {
    this.downKeyPressed = downKeyPressed;
  }

  public void setConfirmKeyPressed(boolean confirmKeyPressed) {
    this.confirmKeyPressed = confirmKeyPressed;
  }

  public boolean isConfirmKeyPressed() {
    return confirmKeyPressed;
  }

  public boolean anyMovingKeyIsPressed() {
    return (isUpKeyPressed() || isLeftKeyPressed() || isRightKeyPressed() || isDownKeyPressed());
  }
}
