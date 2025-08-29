package com.unidungeon.entity.mob;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MobIterator implements Iterator<Integer> {
  private final Mobs[] mobs;
  private int currentIndex;

  public MobIterator(Mobs[] mobs) {
    this.mobs = mobs;
    this.currentIndex = -1;
  }

  @Override
  public boolean hasNext() {
    return findNextIndex() != -1 || findPreviousIndex() != -1;
  }

  @Override
  public Integer next() {
    currentIndex = findNextIndex();
    if (currentIndex == -1) {
      currentIndex = findFirstIndex();
      if (currentIndex == -1) {
        throw new NoSuchElementException();
      }
    }
    System.out.println("Next: " + currentIndex);
    return currentIndex;
  }

  public Integer previous() {
    currentIndex = findPreviousIndex();
    if (currentIndex == -1) {
      currentIndex = findLastIndex();
      if (currentIndex == -1) {
        throw new NoSuchElementException();
      }
    }
    System.out.println("Previous" + currentIndex);
    return currentIndex;
  }

  public Integer first() {
    currentIndex = findFirstIndex();
    if (currentIndex == -1) {
      throw new NoSuchElementException();
    }
    System.out.println("First: " + currentIndex);

    return currentIndex;
  }

  public Integer last() {
    currentIndex = findLastIndex();
    if (currentIndex == -1) {
      throw new NoSuchElementException();
    }
    System.out.println("Last: " + currentIndex);
    return currentIndex;
  }

  private int findNextIndex() {
    for (int i = currentIndex + 1; i < mobs.length; i++) {
      if (!mobs[i].isKO()) {
        return i;
      }
    }
    return -1;
  }

  private int findPreviousIndex() {
    for (int i = currentIndex - 1; i >= 0; i--) {
      if (!mobs[i].isKO()) {
        return i;
      }
    }
    return -1;
  }

  private int findFirstIndex() {
    for (int i = 0; i < mobs.length; i++) {
      if (!mobs[i].isKO()) {
        return i;
      }
    }
    return -1;
  }

  private int findLastIndex() {
    for (int i = mobs.length - 1; i >= 0; i--) {
      if (!mobs[i].isKO()) {
        return i;
      }
    }
    return -1;
  }
}
