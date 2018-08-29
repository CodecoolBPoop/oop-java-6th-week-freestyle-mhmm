package map;
import static GameObjects.GameObjectType.FOREST;

import GameObjects.Characters.Enemy.Slime;
import GameObjects.Characters.Player;
import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 8;
        WIDTH = 8;
        this.map = new GameObject[HEIGHT][WIDTH];

        this.map[0][0] = new Wall(0,0,FOREST);
        for(int i = 1; i< HEIGHT; i++){
            this.map[0][i] = new Wall(0,i,FOREST);
            this.map[i][0] = new Wall(i,0,FOREST);
        }
        this.map[4][4] = new Slime();
        this.map[1][1] = player;
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}
