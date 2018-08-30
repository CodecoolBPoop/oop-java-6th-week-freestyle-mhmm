package com.codecool.rpg.GameObjects.Characters.enemy;

public class Slime extends com.codecool.rpg.GameObjects.Characters.enemy.Enemy {
    public int level;

    public Slime(int X, int Y, int level) {
        super(X,Y,5*level + 10, Math.round(1*level/2) + 1);
        this.level = level;
    }

}
