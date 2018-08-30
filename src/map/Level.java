package map;
import GameObjects.Characters.Character;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.GameObjectType;

public abstract class Level {
    static GameObject[][] map;
    int WIDTH;
    int HEIGHT;

    public void move(int toX, int toY, Character movingCharacter){
        int fromX = movingCharacter.getX();
        int fromY = movingCharacter.getY();
        GameObject destination = map[toX][toY];

        switch (map[toX][toY].getType()) {
            case FOREST: break;
            case FLOOR: {
                map[toX][toY] = movingCharacter;
                map[fromX][fromY] = destination;
            }
            case LOOT: {
                map[toX][toY] = movingCharacter;
                map[fromX][fromY] = new Floor(fromX, fromY, GameObjectType.FLOOR);
            }
            movingCharacter.place(toX, toY);
        }


    }
}
