package map;
import GameObjects.Characters.Enemy.Character;
import GameObjects.GameObject;

public abstract class Level {
    GameObject[][] map;
    int WIDTH;
    int HEIGHT;

    void move(int toX, int toY, Character movingCharacter){

        map[movingCharacter.getX()][movingCharacter.getY()] = null;
        map[toX][toY] = movingCharacter;

    }
}
