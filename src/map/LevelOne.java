package map;
import static GameObjects.GameObjectType.FLOOR;
import static GameObjects.GameObjectType.FOREST;

import GameObjects.Characters.Player;
import GameObjects.Characters.Enemy.Slime;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;
import GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 7;
        WIDTH = 7;
        map = new GameObject[HEIGHT][WIDTH];


        for(int i = 0; i< HEIGHT; i++){
            for (int j = 1; j<WIDTH-1; j++) {
                map[i][j] = new Floor(i, j, FLOOR);
            }
            map[0][i] = new Wall(0,i,FOREST);
            map[i][0] = new Wall(i,0,FOREST);
            map[WIDTH-1][i] = new Wall(WIDTH-1,i,FOREST);
            map[i][HEIGHT-1] = new Wall(i,HEIGHT-1,FOREST);
        }
        map[1][1] = player;
        player.place(1,1);

        map[4][4] = new Slime(4,4);
        map[3][4] = new Slime(3,4);
        map[2][4] = new Slime(2,4);
    }

    public GameObject[][] getLevel(){
        return map;
    }


}