package com.codecool.rpg.map;
import static com.codecool.rpg.GameObjects.GameObjectType.FLOOR;
import static com.codecool.rpg.GameObjects.GameObjectType.FOREST;

import com.codecool.rpg.GameObjects.Characters.Player;
import com.codecool.rpg.GameObjects.Characters.Enemy.Slime;
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

        this.map[4][4] = new Slime(4,4);
        this.map[3][4] = new Slime(3,4);
        this.map[2][4] = new Slime(2,4);
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}