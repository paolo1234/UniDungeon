package com.unidungeon.test;

import com.unidungeon.playing.Direction;
import com.unidungeon.playing.PlayerMoving;
import junit.framework.TestCase;

public class PlayerMovingTest extends TestCase {
    PlayerMoving playerMoving;

    public void setUp() throws Exception {
        super.setUp();
        playerMoving=new PlayerMoving();
        playerMoving.setStartPosition(10,20);
    }

    public void testGetWorldX() {
        assertEquals(10*48,playerMoving.getWorldX());
    }
    public void testGetWorldY() {
        assertEquals(20*48, playerMoving.getWorldY());
    }

    public void testGetScreenX() {
        assertEquals(768/2 - 48/2,playerMoving.getScreenX());
    }
    public void testGetScreenY() {
        assertEquals(576/2 - 48/2,playerMoving.getScreenY());
    }

    public void testSetDirection() {
        playerMoving.setDirection(Direction.UP);
        assertEquals(Direction.UP, playerMoving.getDirection());
        playerMoving.setDirection(Direction.DOWN);
        assertEquals(Direction.DOWN, playerMoving.getDirection());
        playerMoving.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, playerMoving.getDirection());
        playerMoving.setDirection(Direction.RIGHT);
        assertEquals(Direction.RIGHT, playerMoving.getDirection());
    }

    public void testMoveLeft() {
        playerMoving.moveLeft();
        assertEquals(10*48-4, playerMoving.getWorldX());
    }
    public void testMoveRight() {
        playerMoving.moveRight();
        assertEquals(10*48+4, playerMoving.getWorldX());
    }
    public void testMoveUp() {
        playerMoving.moveUp();
        assertEquals(20*48-4, playerMoving.getWorldY());
    }
    public void testMoveDown() {
        playerMoving.moveDown();
        assertEquals(20*48+4, playerMoving.getWorldY());
    }

    public void testGetSpeed() {
        assertEquals(4,playerMoving.getSpeed());
    }

    public void testGetDirection() {
        playerMoving.setDirection(Direction.UP);
        assertEquals(Direction.UP,playerMoving.getDirection());
    }

    public void testUpdatePosition() {
        int y = playerMoving.getWorldY();
        int x = playerMoving.getWorldX();
        playerMoving.collisionOn = true;
        playerMoving.setDirection(Direction.DOWN);
        playerMoving.updatePosition();
        playerMoving.setDirection(Direction.UP);
        playerMoving.updatePosition();
        playerMoving.setDirection(Direction.LEFT);
        playerMoving.updatePosition();
        playerMoving.setDirection(Direction.RIGHT);
        playerMoving.updatePosition();
        assertTrue( y == playerMoving.getWorldY());

        playerMoving.collisionOn = false;
        y = playerMoving.getWorldY() + 4;
        playerMoving.setDirection(Direction.DOWN);
        playerMoving.updatePosition();
        assertTrue(y == playerMoving.getWorldY());

        y = playerMoving.getWorldY() - 4;
        playerMoving.setDirection(Direction.UP);
        playerMoving.updatePosition();
        assertTrue(y == playerMoving.getWorldY());

        x = playerMoving.getWorldX() - 4;
        playerMoving.setDirection(Direction.LEFT);
        playerMoving.updatePosition();
        assertTrue(x == playerMoving.getWorldX());

        x = playerMoving.getWorldX() + 4;
        playerMoving.setDirection(Direction.RIGHT);
        playerMoving.updatePosition();
        assertTrue(x == playerMoving.getWorldX());
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }
}
