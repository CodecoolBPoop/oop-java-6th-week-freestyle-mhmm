package map;
import static GameObjects.GameObjectType.FOREST;

import GameObjects.Characters.Enemy.Slime;
import GameObjects.Characters.Player;
import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;
import GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 8;
        WIDTH = 8;
        this.map = new GameObject[HEIGHT][WIDTH];

        this.map[0][0] = new Wall(0,0,FOREST);
        for(int i = 0; i< HEIGHT; i++){
            for (int j = 0; j<WIDTH; j++) {
                this.map[i][j] = new Wall(i, j, FOREST);
            }

        }
        this.map[4][4] = new Slime();
        this.map[1][1] = player;
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}
