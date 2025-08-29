package com.unidungeon.playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

public class PlayerMoving {

  private static final int SCREEN_WIDTH = 768;
  private static final int SCREEN_HEIGHT = 576;
  private static final int PLAYER_SIZE = 48;
  private static final int ANIM_WALK_SPEED = 6;
  private static final int ANIM_IDLE_SPEED = 12;
  private static final int SPRITES_PER_DIRECTION = 6;

  // Indici di inizio per ogni direzione nei sprites
  private static final int UP_MOVING_START = 0;
  private static final int LEFT_MOVING_START = 6;
  private static final int RIGHT_MOVING_START = 12;
  private static final int DOWN_MOVING_START = 18;
  private static final int UP_IDLE_START = 24;
  private static final int LEFT_IDLE_START = 30;
  private static final int RIGHT_IDLE_START = 36;
  private static final int DOWN_IDLE_START = 42;

  private int worldX;
  private int worldY;
  private final int screenX;
  private final int screenY;
  private Direction direction;
  private final int speed = 4;
  public final Rectangle boxCollider;
  public final int solidAreaDefaultX;
  public final int solidAreaDefaultY;
  public boolean collisionOn = false;
  private final BufferedImage[] sprites = new BufferedImage[48];
  private BufferedImage image;
  private int animTick = 0;

  // Indici di animazione per movimento e idle
  private int movingIndex = 0;
  private int idleIndex = 0;

  public PlayerMoving() {
    screenX = SCREEN_WIDTH / 2 - PLAYER_SIZE / 2;
    screenY = SCREEN_HEIGHT / 2 - PLAYER_SIZE / 2;
    boxCollider = new Rectangle(8, 43, 32, 32);
    solidAreaDefaultX = boxCollider.x;
    solidAreaDefaultY = boxCollider.y;
    direction = Direction.DOWN;
    loadSprites();
  }

  private void loadSprites() {
    try {
      // Movimento verso l'alto (0-5)
      loadSpriteRange(UP_MOVING_START, "/player/giada/walkup", 1, 6);

      // Movimento verso sinistra (6-11)
      loadSpriteRange(LEFT_MOVING_START, "/player/giada/walksx", 1, 6);

      // Movimento verso destra (12-17)
      loadSpriteRange(RIGHT_MOVING_START, "/player/giada/walkdx", 1, 6);

      // Movimento verso il basso (18-23)
      loadSpriteRange(DOWN_MOVING_START, "/player/giada/walkdown", 1, 6);

      // Idle verso l'alto (24-29)
      loadSpriteRange(UP_IDLE_START, "/player/giada/idleup", 1, 6);

      // Idle verso sinistra (30-35)
      loadSpriteRange(LEFT_IDLE_START, "/player/giada/idlesx", 1, 6);

      // Idle verso destra (36-41)
      loadSpriteRange(RIGHT_IDLE_START, "/player/giada/idledx", 1, 6);

      // Idle verso il basso (42-47)
      loadSpriteRange(DOWN_IDLE_START, "/player/giada/down", 1, 6);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadSpriteRange(int startIndex, String basePath, int startNum, int count)
      throws IOException {
    for (int i = 0; i < count; i++) {
      String path = basePath + (startNum + i) + ".png";
      sprites[startIndex + i] =
          ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
  }

  public int getWorldX() {
    return worldX;
  }

  public int getWorldY() {
    return worldY;
  }

  public int getScreenX() {
    return screenX;
  }

  public int getScreenY() {
    return screenY;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void moveLeft() {
    this.worldX -= this.speed;
  }

  public void moveRight() {
    this.worldX += this.speed;
  }

  public void moveUp() {
    this.worldY -= this.speed;
  }

  public void moveDown() {
    this.worldY += this.speed;
  }

  public int getSpeed() {
    return speed;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setMovingAnim() {
    animTick++;
    if (animTick >= ANIM_WALK_SPEED) {
      animTick = 0;
      movingIndex = (movingIndex + 1) % SPRITES_PER_DIRECTION;

      int startIndex = getMovingStartIndex();
      setImage(sprites[startIndex + movingIndex]);
    }
  }

  public void setIdleAnim() {
    animTick++;
    if (animTick >= ANIM_IDLE_SPEED) {
      animTick = 0;
      idleIndex = (idleIndex + 1) % SPRITES_PER_DIRECTION;

      int startIndex = getIdleStartIndex();
      setImage(sprites[startIndex + idleIndex]);
    }
  }

  private int getMovingStartIndex() {
    return switch (direction) {
      case UP -> UP_MOVING_START;
      case LEFT -> LEFT_MOVING_START;
      case RIGHT -> RIGHT_MOVING_START;
      case DOWN -> DOWN_MOVING_START;
    };
  }

  private int getIdleStartIndex() {
    return switch (direction) {
      case UP -> UP_IDLE_START;
      case LEFT -> LEFT_IDLE_START;
      case RIGHT -> RIGHT_IDLE_START;
      case DOWN -> DOWN_IDLE_START;
    };
  }

  public void updatePosition() {
    if (!collisionOn) {
      switch (direction) {
        case UP -> moveUp();
        case LEFT -> moveLeft();
        case RIGHT -> moveRight();
        case DOWN -> moveDown();
      }
    }
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public void setStartPosition(int worldX, int worldY) {
    this.worldX = worldX * PLAYER_SIZE;
    this.worldY = worldY * PLAYER_SIZE;
  }

  // Getter pubblico per l'immagine
  public BufferedImage getImage() {
    return image;
  }
}
