package com.codecool.rpg.GameObjects.Characters;
import com.codecool.rpg.GameObjects.GameObjectType;
import com.codecool.rpg.GameObjects.Items.*;

import java.util.List;

public class Player extends Character {
    private int strength;
    private int agility;
    private int intelligence;
    private int gold;
    private Armor fullBody;
    private Weapon weapon;
    public static int X;
    public static int Y;



    public Player(int X, int Y) {
        super(X, Y, 30, 0);
        this.type = GameObjectType.PLAYER;
        strength = 3;
        agility = 3;
        intelligence = 3;
        gold = 10;
        this.X = X;
        this.Y = Y;
    }

    public void setFullBody(Armor fullBody) {
        if (this.fullBody != null)
        this.hitPoint -= this.fullBody.getHealthIncrease();
        this.hitPoint += fullBody.getHealthIncrease();
        this.fullBody = fullBody;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        if (this.weapon == null)
            return strength;
        return this.weapon.dealDamage() + strength;
    }

    public void changeStrength (int changeAmount){
        this.strength += changeAmount;
    }

    public boolean strengthTest(int testValue){
        return testValue<strength;
    }

    public void changeAgility (int changeAmount){
        this.agility += changeAmount;
    }

    public boolean agilityTest(int testValue){
        return testValue<agility;
    }

    public void changeIntelligence (int changeAmount){
        this.intelligence += changeAmount;
    }

    public boolean intelligenceTest(int testValue){
        return testValue<intelligence;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }
    public int getStrength() {
        return strength;
    }

    public void removeGold(int gold) {
        this.gold -= gold;
    }

    public void loot(Loot loot) {
        List<Item> lootItems = loot.getItems();
        for (Item item : lootItems) {
            items.add(item);
        }
        gold += loot.getGold();
    }
    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void equipItem(Item item) {
        if (item.getType() == GameObjectType.ARMOR) {
            setFullBody((Armor) item);
        } else if (item.getType() == GameObjectType.WEAPON) {
            setWeapon((Weapon) item);
        }
    }

    public int getGold() {
        return gold;
    }

    public String damageToString() {
        if (weapon == null) {
            return Integer.toString(strength);
        }
        return (weapon.getMinDamage() + strength) + " - " + (weapon.getMaxDamage() + strength);
    }
}
