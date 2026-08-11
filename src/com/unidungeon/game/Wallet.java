package com.unidungeon.game;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
  int money;
  // Badges
  List<Badge> badges;

  public Wallet() {
    badges = new ArrayList<>();
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public void encreaseMoney(int i) {
    this.money += i;
  }

  public boolean decreaseMoney(int i) {
    if ((money - i) >= 0) {
      this.money -= i;
      return true;
    } else {
      return false;
    }
  }

  public int getMoney() {
    return money;
  }

  public void addBadge(Badge b) {
    this.badges.add(b);
  }

  public List<Badge> getBadges() {
    return badges;
  }
}
