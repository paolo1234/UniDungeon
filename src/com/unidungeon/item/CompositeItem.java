package com.unidungeon.item;

import com.unidungeon.entity.player.Player;
import com.unidungeon.malus.Malus;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class CompositeItem extends Item {

  private List<Item> items;

  public CompositeItem(Item... item) {
    items = Arrays.asList(item);
  }

  public CompositeItem(List<Item> items) {
    this.items = items;
  }

  @Override
  public void useItem(Player player) {
    for (Item item : items) {
      item.useItem(player);
    }
  }

  @Override
  public void useItem(Player player, Malus[] malus, int target) {
    for (Item item : items) {
      item.useItem(player, malus, target);
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getEffect() {
    return "Vari effettti";
  }

  @Override
  public BufferedImage getImage() {
    return this.image;
  }
}
