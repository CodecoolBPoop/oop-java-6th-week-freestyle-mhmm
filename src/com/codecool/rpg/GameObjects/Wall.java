package com.codecool.rpg.GameObjects;

public class Wall extends GameObject {

    public Wall(int X, int Y, GameObjectType type){
        super(X,Y);
        this.type = type;
    }
}
