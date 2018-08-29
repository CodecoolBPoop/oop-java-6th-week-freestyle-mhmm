package GameObjects.Characters.Enemy;

import GameObjects.GameObject;
import GameObjects.GameObjectType;

public abstract class Character extends GameObject {
    GameObjectType type;
    int hitPoint;
    int damage;
    int X;
    int Y;

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
