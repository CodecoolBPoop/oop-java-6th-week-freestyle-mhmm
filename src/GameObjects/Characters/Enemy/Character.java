package GameObjects.Characters.Enemy;

import GameObjects.GameObject;
import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Character extends GameObject {

    int hitPoint;
    int damage;
    int X;
    int Y;
    List<Item> items = new ArrayList<>();

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
