package com.codecool.rpg.GameObjects.Characters;

import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.GameObjectType;
import com.codecool.rpg.GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends GameObject {
    protected int hitPoint;
    protected int damage;
    List<Item> items = new ArrayList<>();
    protected GameObjectType type;

    public Character(int X, int Y, int hitPoint, int damage) {
        super(X, Y);
        this.hitPoint = hitPoint;
        this.damage = damage;
    }

    public void takeDamage(int damageAmount){
        this.hitPoint -= damageAmount;
    }

    public GameObjectType getType(){
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public Item getItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


}
