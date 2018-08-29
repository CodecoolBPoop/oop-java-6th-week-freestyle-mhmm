package GameObjects.Characters;

import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends GameObject {
    protected int hitPoint;
    protected int damage;
    List<Item> items = new ArrayList<>();

    public void takeDamage(int damageAmount){
        this.hitPoint -= damageAmount;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }
}
