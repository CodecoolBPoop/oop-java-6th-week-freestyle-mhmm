package com.codecool.rpg.map;
import com.codecool.rpg.GameObjects.Characters.Character;
import com.codecool.rpg.GameObjects.Characters.Player;
import com.codecool.rpg.GameObjects.Characters.enemy.Enemy;
import com.codecool.rpg.GameObjects.Floor;
import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.GameObjectType;
import com.codecool.rpg.GameObjects.Items.Loot;
import com.codecool.rpg.GameObjects.Wall;

import static com.codecool.rpg.GameObjects.GameObjectType.FLOOR;
import static com.codecool.rpg.GameObjects.GameObjectType.FOREST;

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
                Loot loot = (Loot) map[toX][toY];
                ((Player) movingCharacter).loot(loot);
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
                        map[toX][toY] = new Loot(toX,toY);
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
