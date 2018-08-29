package GameObjects.Characters;

import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends GameObject {
    GameObjectType type;

    int hitPoint;
    int damage;
    List<Item> items = new ArrayList<>();

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
}
