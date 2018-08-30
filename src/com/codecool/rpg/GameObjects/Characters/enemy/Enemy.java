package com.codecool.rpg.GameObjects.Characters.enemy;
import com.codecool.rpg.GameObjects.Characters.Character;
import static com.codecool.rpg.GameObjects.GameObjectType.ENEMY;

public abstract class Enemy extends Character {
    public Enemy(int X, int Y, int hitPoints, int damage){
        super(X,Y,hitPoints,damage);
        this.type = ENEMY;
    }

    public int attack(){
        return this.damage;
    }

}
