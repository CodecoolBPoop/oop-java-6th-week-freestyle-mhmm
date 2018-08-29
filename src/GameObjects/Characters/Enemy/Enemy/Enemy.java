package GameObjects.Characters.Enemy;

import GameObjects.Characters.Character;
import GameObjects.GameObjectType;

public abstract class Enemy extends Character {
    public Enemy(int hitPoints, int damage){
        this.type = ENEMY;
        this.hitPoint = hitPoints;
        this.damage = damage;
    }

    public int attack(){
        return this.damage;
    }


}
