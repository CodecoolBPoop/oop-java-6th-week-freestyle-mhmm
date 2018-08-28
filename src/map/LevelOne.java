package map;

import GameObjects.GameObject;

public class LevelOne extends Level{

    public LevelOne(){
        HEIGHT = 8;
        WIDTH = 8;
        this.map = new GameObject[HEIGHT][WIDTH];
    }
}
