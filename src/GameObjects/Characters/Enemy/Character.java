package GameObjects.Characters.Enemy;

import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends GameObject {
    GameObjectType type;

    int hitPoint;
    int damage;
    int X;
    int Y;
    List<Item> items = new ArrayList<>();

    public void takeDamage(int damageAmount){
        this.hitPoint -= damageAmount;
    }

    public GameObjectType getType(){
        return type;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }
}
