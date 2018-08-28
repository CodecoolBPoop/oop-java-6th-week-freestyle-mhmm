package GameObjects.Characters;

import GameObjects.GameObject;

public abstract class Character extends GameObject {
    int hitPoint;
    int damage;
    int X;
    int Y;

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
