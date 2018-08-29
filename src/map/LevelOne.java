package map;
import static GameObjects.GameObjectType.FLOOR;
import static GameObjects.GameObjectType.FOREST;

import GameObjects.Characters.enemy.Slime;
import GameObjects.Characters.Player;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 8;
        WIDTH = 8;
        this.map = new GameObject[HEIGHT][WIDTH];

        for(int x = 0; x < WIDTH; x++){
            for( int y = 0; y < HEIGHT; y++){
                map[x][y] = new Floor(x,y,FLOOR);
            }
        }

        this.map[0][0] = new Wall(0,0,FOREST);
        for(int i = 1; i< HEIGHT; i++){
            this.map[0][i] = new Wall(0,i,FOREST);
            this.map[i][0] = new Wall(i,0,FOREST);
        }
        this.map[4][4] = new Slime(4,4);
        this.map[1][1] = player;
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}
