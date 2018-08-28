package map;
import Characters.Character;

public abstract class Level {
    Character[][] map;
    int WIDTH;
    int HEIGHT;

    void move(int toX, int toY, Character movingCharacter){

        map[movingCharacter.getX()][movingCharacter.getY()] = null;
        map[toX][toY] = movingCharacter;

    }
}
