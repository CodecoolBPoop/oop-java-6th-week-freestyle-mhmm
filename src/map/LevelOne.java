package map;
import static GameObjects.GameObjectType.FLOOR;
import static GameObjects.GameObjectType.FOREST;

import GameObjects.Characters.Player;
import GameObjects.Characters.enemy.Slime;
import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;
import GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 12;
        WIDTH = 8;
        this.map = new GameObject[WIDTH][HEIGHT];


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
        this.map[1][1] = player;
        player.place(1,1);

        this.map[4][4] = new Slime(4,4);
        this.map[3][4] = new Slime(3,4);
        this.map[2][4] = new Slime(2,4);
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}
