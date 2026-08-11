package com.unidungeon.item;

import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.Malus;
import java.util.ArrayList;

public class Backpack {

  private static Backpack instance;
  private ArrayList<Item> backpack;
  private final int CAPACITY = 10;

  private Backpack() {
    this.backpack = new ArrayList<>(10);
  }

  public static Backpack getInstance() {
    if (instance == null) {
      instance = new Backpack();
      return instance;
    }
    return instance;
  }

  public boolean isEmpty() {
    if (this.backpack.size() == 0) return true;
    return false;
  }

  public boolean isFull() {
    if (this.backpack.size() == CAPACITY) return true;
    return false;
  }

  public int getWeight() {
    return this.backpack.size();
  }

  public boolean addItem(Item item) {
    if (this.isFull()) return false;
    this.backpack.add(item);
    return true;
  }

  public void removeItem(int index) {
    this.backpack.remove(index);
  }

  public ArrayList<Item> getBackpack() {
    return this.backpack;
  }

  // Returns false if player is trying to use other than ItemRevive if target is KO, true if
  // succeded
  public boolean useItem(int index, Player player) {
    if ((!(this.backpack.get(index) instanceof ItemRevive) && player.isKO())) return false;
    this.backpack.get(index).useItem(player);
    this.backpack.remove(index);
    return true;
  }

  // Returns false if player is trying to use other than ItemRevive if target is KO, true if
  // succeded
  public boolean useItem(int index, Player player, Malus[] malusP, int target) {
    if ((!(this.backpack.get(index) instanceof ItemRevive) && player.isKO())) return false;
    this.backpack.get(index).useItem(player, malusP, target);
    this.backpack.remove(index);
    return true;
  }

  public void clearBackpack() {
    this.backpack = new ArrayList<>();
  }
}
