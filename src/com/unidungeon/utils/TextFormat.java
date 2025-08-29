package com.unidungeon.utils;

public final class TextFormat {

  public static final int NONE = 0;

  public static final int NO_ANTI_ALIASING = 1;

  public static final int FIRST_LINE_VISIBLE = 2;

  private TextFormat() {}

  public static boolean isEnabled(int format, int flag) {
    return (format & flag) == flag;
  }
}
