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

        itemsData.addItem(armor1);
        itemsData.addItem(armor2);
        itemsData.addItem(armor3);
        itemsData.addItem(armor4);

        Weapon weapon1 = new Weapon("Mythical Sword", 1000, 120, 1);
        Weapon weapon2 = new Weapon("Colossus Blade", 120, 30, 12);
        Weapon weapon3 = new Weapon("Hydra Bow", 42, 3, 1);

        itemsData.addItem(weapon1);
        itemsData.addItem(weapon2);
        itemsData.addItem(weapon3);

        Potion healingPotion = new Potion("Healing Potion", 10, GameObjectType.HEALTHPOTION);
        Potion majorHealingPotion = new Potion("Major Healing Potion", 20, GameObjectType.HEALTHPOTION);
        Potion superHealingPotion = new Potion("Super Healing Potion", 40, GameObjectType.HEALTHPOTION);
        Potion agilityPotion = new Potion("Agility Potion", 5, GameObjectType.AGILITYPOTION);
        Potion strenghtPotion = new Potion("Strenght Potion", 5, GameObjectType.STRENGHTPOTION);
        Potion intelligencePotion = new Potion("Intelligence Potion", 5, GameObjectType.INTELLIGENCEPOTION);

        itemsData.addItem(healingPotion);
        itemsData.addItem(majorHealingPotion);
        itemsData.addItem(superHealingPotion);
        itemsData.addItem(agilityPotion);
        itemsData.addItem(strenghtPotion);
        itemsData.addItem(intelligencePotion);
    }
}
