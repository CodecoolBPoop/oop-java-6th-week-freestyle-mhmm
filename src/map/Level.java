package map;
import GameObjects.Characters.Character;
import GameObjects.Characters.Player;
import GameObjects.Characters.enemy.Enemy;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Wall;

import static GameObjects.GameObjectType.FLOOR;
import static GameObjects.GameObjectType.FOREST;
import static GameObjects.GameObjectType.PLAYER;

public abstract class Level {
    GameObject[][] map;
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
                movingCharacter.place(toX, toY);
                break;
            }
            case LOOT: {
                map[toX][toY] = movingCharacter;
                map[fromX][fromY] = new Floor(fromX, fromY, GameObjectType.FLOOR);
                movingCharacter.place(toX, toY);
                break;
            }
            case ENEMY: {
                if (movingCharacter instanceof Player) {
                    Player player = (Player) movingCharacter;
                    Enemy enemy = (Enemy) destination;
                    player.takeDamage(enemy.attack());
                    enemy.takeDamage(player.attack());
                    if (enemy.getHitPoint() <= 0) {
                        map[toX][toY] = movingCharacter;
                        map[fromX][fromY] = new Floor(fromX, fromY, FLOOR);
                        movingCharacter.place(toX, toY);
                    }
                    break;
                }
            }
        }

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
