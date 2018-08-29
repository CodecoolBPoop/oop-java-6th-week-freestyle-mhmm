package map;

import GameObjects.Characters.Player;
import GameObjects.GameObject;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 8;
        WIDTH = 8;
        this.map = new GameObject[HEIGHT][WIDTH];

        this.map[1][1] = player;
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}
