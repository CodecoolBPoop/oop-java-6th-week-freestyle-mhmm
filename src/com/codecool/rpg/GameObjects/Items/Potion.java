package com.codecool.rpg.GameObjects.Items;

import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.GameObjectType;

public class Potion extends Item {

    private int buffValue;

    public Potion(String name, int value, int buffValue, GameObjectType type) {
        super(name, value);
        this.buffValue = buffValue;
        this.type = type;
    }

    public int getBuffValue() {
        return buffValue;
    }

    public GameObjectType getBuffType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getName() + "| Increases stat by " + this.buffValue;
    }
}
