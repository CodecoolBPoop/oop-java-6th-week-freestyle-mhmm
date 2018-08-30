package com.codecool.rpg.GameObjects.Items;

import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.GameObjectType;

public class Potion extends Item {

    private int buffValue;

    public Potion(String name, int value, GameObjectType type) {
        super(name, value);
        this.type = type;
    }

    public int getBuffValue() {
        return buffValue;
    }

    public GameObjectType getBuffType() {
        return type;
    }
}
