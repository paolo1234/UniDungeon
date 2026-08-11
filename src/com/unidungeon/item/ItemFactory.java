package com.unidungeon.item;

import java.util.Random;

public class ItemFactory implements ItemFactoryIF {
  @Override
  public Item getItemType(String itemtype) {
    if (itemtype == null) {
      return null;
    }
    // Small HP value 20?
    if (itemtype.equalsIgnoreCase("smallitemhp")) {
      Random random = new Random();
      int r = random.nextInt(0, 2);
      switch (r) {
        case 0 -> {
          return new ItemHp(
              "Ciambella", "Ti fa sentire come un vero poliziotto", "/items/tile022.png", 10);
        }
        case 1 -> {
          return new ItemHp(
              "Gelato", "Ti fa gelare i denti, ma ne vale la pena", "/items/gelatino.png", 10);
        }
      }
    } // Regular HP value 30?
    if (itemtype.equalsIgnoreCase("regularitemhp")) {
      Random random = new Random();
      int r = random.nextInt(0, 3);
      switch (r) {
        case 0 -> {
          return new ItemHp(
              "Melanzana",
              "L’unico motivo per cui stai anche solo considerando di mangiartelo crudo è perché"
                  + " hai disperatamente bisogno di recuperare salute.",
              "/items/tile055.png",
              25);
        }
        case 1 -> {
          return new ItemHp(
              "Bacon",
              "Il desiderio di un bel brunch ti fa scordare che probabilmente ti verrà un forte mal"
                  + " di pancia",
              "/items/tile035.png",
              25);
        }
        case 2 -> {
          return new ItemHp(
              "???",
              "è dolce? È salato? Non ne hai idea ma sembra delizioso",
              "/items/tile032.png",
              25);
        }
      }
    }
    // Big HP value 40?
    if (itemtype.equalsIgnoreCase("bigitemhp")) {
      return new ItemHp(
          "Carne all'osso", "*slurp**gnam**chomp*…delizioso", "/items/tile015.png", 40);
    }

    // Small SP value 10?
    if (itemtype.equalsIgnoreCase("smallitemsp")) {
      Random random = new Random();
      int r = random.nextInt(0, 2);
      switch (r) {
        case 0 -> {
          return new ItemSp("Bibita gassata", "Ha un sapore pungente", "/items/succo.png", 10);
        }
        case 1 -> {
          return new ItemSp(
              "Ketchup", "Stai davvero pensando di berti del ketchup?? ", "/items/tile043.png", 10);
        }
      }
    }

    // Regular SP value 20?
    if (itemtype.equalsIgnoreCase("regularitemsp"))
      return new ItemSp(
          "Vodka",
          "Di tanto in tanto non fa male allentare un po’ la tensione",
          "/items/tile009.png",
          25);
    // Big SP value 30?
    if (itemtype.equalsIgnoreCase("bigitemsp"))
      return new ItemSp("Java", "Un caro amico che non ti tradirà mai", "/items/caffe.png", 40);

    // Small revive value hp 35%?
    if (itemtype.equalsIgnoreCase("smallitemrevive"))
      return new ItemRevive(
          "Frutto della passione",
          "Fa ritornare la passione per la vita",
          "/items/tile008.png",
          35);
    // Regular revive value hp 60%?
    if (itemtype.equalsIgnoreCase("regularitemrevive"))
      return new ItemRevive(
          "Pozione",
          "è un’ampolla molto pretenziosa, ma all’interno contiene del semplice succo di pomodoro.",
          "/items/tile012.png",
          100);
    // Big revive value hp 100%?
    if (itemtype.equalsIgnoreCase("bigitemrevive"))
      return new ItemRevive(
          "Cucchiaio di legno",
          "Un bel colpo di questi fa risorgere non solo amici caduti ma anche i loro traumi"
              + " infantili. 9/10 mamme lo consigliano.",
          "/items/tile027.png",
          60);

    return null;
  }
}
