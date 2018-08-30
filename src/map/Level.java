package map;
import GameObjects.Characters.Character;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.Wall;

import static GameObjects.GameObjectType.FLOOR;
import static GameObjects.GameObjectType.FOREST;

public abstract class Level {
    GameObject[][] map;
    int WIDTH;
    int HEIGHT;

    void move(int toX, int toY, Character movingCharacter){

        map[movingCharacter.getX()][movingCharacter.getY()] = null;
        map[toX][toY] = movingCharacter;

    }

    void generateBase(){
        for(int i = 0; i< WIDTH-1; i++){
            for (int j = 1; j<HEIGHT-1; j++) {
                this.map[i][j] = new Floor(i, j, FLOOR);
            }
            this.map[i][0] = new Wall(i,0,FOREST);
            this.map[i][HEIGHT-1] = new Wall(i,HEIGHT-1,FOREST);
        }
        for(int i = 0; i< HEIGHT-1; i++){
            this.map[0][i] = new Wall(0,i,FOREST);
            this.map[WIDTH-1][i] = new Wall(WIDTH-1,i,FOREST);
        }
        this.map[WIDTH-1][HEIGHT-1] = new Wall(WIDTH-1,HEIGHT-1,FOREST);
    }
}
