package com.codecool.rpg.map;
import static com.codecool.rpg.GameObjects.GameObjectType.FLOOR;
import static com.codecool.rpg.GameObjects.GameObjectType.FOREST;

import com.codecool.rpg.GameObjects.Characters.Player;
import com.codecool.rpg.GameObjects.Characters.enemy.Slime;
import com.codecool.rpg.GameObjects.Floor;
import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.GameObjectType;
import com.codecool.rpg.GameObjects.Items.Item;
import com.codecool.rpg.GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 12;
        WIDTH = 8;
        this.map = new GameObject[WIDTH][HEIGHT];


        generateBase();

        this.map[1][1] = player;
        player.place(1,1);

        placeWall(1,2,FOREST);
        placeWall(2,2,FOREST);
        placeWall(3,2,FOREST);
        placeWall(3,3,FOREST);
        placeWall(4,3,FOREST);
        placeWall(6,3,FOREST);

        this.map[5][3] = new Slime(5,3, 1);
        this.map[3][4] = new Slime(3,4, 2);
        this.map[2][4] = new Slime(2,4, 4);
        this.map[1][3] = new Slime(1,3, 2);
        this.map[2][3] = new Slime(2,3, 15);
        this.map[1][9] = new Slime(1,9, 20);
        this.map[6][9] = new Slime(6,9, 40);

        placeWall(5,7,FOREST);
        placeWall(4,7,FOREST);
        placeWall(3,7,FOREST);
        placeWall(2,7,FOREST);
        placeWall(3,8,FOREST);
        placeWall(3,9,FOREST);
        placeWall(3,10,FOREST);
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}