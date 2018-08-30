package com.codecool.rpg;

import com.codecool.rpg.GameObjects.GameObjectType;
import com.codecool.rpg.GameObjects.Items.Armor;
import com.codecool.rpg.GameObjects.Items.Weapon;
import com.codecool.rpg.GameObjects.Items.Potion;

import java.awt.geom.Point2D;

public class Config {

    public static void initialize() {

        ItemsDataDao itemsData = ItemsDataDao.getInstance();

        Armor armor1 = new Armor("Sacred Armor", 14030, 40);
        Armor armor2 = new Armor("Shadow Plate", 100, 30);
        Armor armor3 = new Armor("Kraken Shell", 10, 100);
        Armor armor4 = new Armor("Diamond Mail", 80, 20);
        Armor armor5 = new Armor("Shining Armor", 1300, 50);

        itemsData.addItem(armor1);
        itemsData.addItem(armor2);
        itemsData.addItem(armor3);
        itemsData.addItem(armor4);
        itemsData.addItem(armor5);

        Weapon weapon1 = new Weapon("Mythical Sword", 1000, 120, 1);
        Weapon weapon2 = new Weapon("Colossus Blade", 120, 30, 12);
        Weapon weapon3 = new Weapon("Hydra Bow", 42, 3, 1);
        Weapon weapon4 = new Weapon("Healing Wand",100, -10, -100);
        Weapon weapon5 = new Weapon("Flaming Flamingo", 5, 41, 40);
        Weapon weapon6 = new Weapon("Ice Shard", 0, 2,0);
        Weapon weapon7 = new Weapon("Cthulhu's book of Insanity", 600, 600, -600);
        Weapon weapon8 = new Weapon("Forged Sword", 15, 30, 22);
        Weapon weapon9 = new Weapon("Mamga Mace", 3010, 55,17);
        Weapon weapon10 = new Weapon("Melted Mace", 10, 15,7);
        Weapon weapon11 = new Weapon("Melted ice", 0, 0,0);
        Weapon weapon12 = new Weapon("RNG sword(not like the mythical)", 15,100,20);
        Weapon weapon13 = new Weapon("Basic Bow", 10, 3,0);
        Weapon weapon14 = new Weapon("Basic Sword", 10, 5,3);
        Weapon weapon15 = new Weapon("Cruel Crude Candle", 14, 8, 3);
        Weapon weapon16 = new Weapon("Phoenix Pike", 14, 62, 33);
        Weapon weapon17 = new Weapon("Gandalf's lost and found staff", 2000, 1,1);
        Weapon weapon18 = new Weapon("Purging Pebble", 1, 40,39 );

        itemsData.addItem(weapon1);
        itemsData.addItem(weapon2);
        itemsData.addItem(weapon3);
        itemsData.addItem(weapon4);
        itemsData.addItem(weapon5);
        itemsData.addItem(weapon6);
        itemsData.addItem(weapon7);
        itemsData.addItem(weapon8);
        itemsData.addItem(weapon9);
        itemsData.addItem(weapon10);
        itemsData.addItem(weapon11);
        itemsData.addItem(weapon12);
        itemsData.addItem(weapon13);
        itemsData.addItem(weapon14);
        itemsData.addItem(weapon15);
        itemsData.addItem(weapon16);
        itemsData.addItem(weapon17);
        itemsData.addItem(weapon18);

        Potion healingPotion = new Potion("Healing Potion", 10, 10, GameObjectType.HEALTHPOTION);
        Potion majorHealingPotion = new Potion("Major Healing Potion", 15, 20, GameObjectType.HEALTHPOTION);
        Potion superHealingPotion = new Potion("Super Healing Potion", 20, 40, GameObjectType.HEALTHPOTION);
        Potion agilityPotion = new Potion("Agility Potion", 20, 5, GameObjectType.AGILITYPOTION);
        Potion strenghtPotion = new Potion("Strenght Potion", 20, 5, GameObjectType.STRENGHTPOTION);
        Potion intelligencePotion = new Potion("Intelligence Potion", 25, 5, GameObjectType.INTELLIGENCEPOTION);

        itemsData.addItem(healingPotion);
        itemsData.addItem(majorHealingPotion);
        itemsData.addItem(superHealingPotion);
        itemsData.addItem(agilityPotion);
        itemsData.addItem(strenghtPotion);
        itemsData.addItem(intelligencePotion);
    }
}
