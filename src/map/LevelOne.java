package map;
import static GameObjects.GameObjectType.FLOOR;
import static GameObjects.GameObjectType.FOREST;

import GameObjects.Characters.Player;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;
import GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 8;
        WIDTH = 8;
        this.map = new GameObject[HEIGHT][WIDTH];


        for(int i = 0; i< HEIGHT; i++){
            for (int j = 0; j<WIDTH; j++) {
                this.map[i][j] = new Wall(i, j, FOREST);
            }

        }

        this.map[1][1] = player;
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}
