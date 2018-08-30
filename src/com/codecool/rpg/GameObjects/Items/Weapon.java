package com.codecool.rpg.GameObjects.Items;

import com.codecool.rpg.GameObjects.GameObjectType;

import java.util.Random;

public class Weapon extends Item {

    private int maxDamage;
    private int minDamage;

    public Weapon(String name, int value, int maxDamage, int minDamage) {
        super(name, value);
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        type = GameObjectType.WEAPON;
    }

    public int dealDamage() {
        Random random = new Random();
        return random.nextInt(this.maxDamage - this.minDamage) + this.minDamage;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }
}
