package GameObjects.Characters.enemy;
import GameObjects.Characters.Character;
import static GameObjects.GameObjectType.ENEMY;

public abstract class Enemy extends Character {
    public Enemy(int X, int Y, int hitPoints, int damage){
        super(X,Y,hitPoints,damage);
        this.type = ENEMY;
    }

    public int attack(){
        return this.damage;
    }


}
