package com.codecool.rpg.GameObjects.Items;

import com.codecool.rpg.GameObjects.GameObjectType;

public class Armor extends Item {

    private int healthIncrease;

    public Armor(String name, int value, int healthIncrease) {
        super(name, value);
        this.healthIncrease = healthIncrease;
        type = GameObjectType.ARMOR;
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }

    @Override
    public String toString() {
        return this.getName() + "| Increase hp by " + this.healthIncrease;
    }
}
