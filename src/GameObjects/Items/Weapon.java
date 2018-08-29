package GameObjects.Items;


import GameObjects.Characters.Enemy.Character;

import java.util.Random;

public class Weapon extends Item {

    private int maxDamage;
    private int minDamage;

    public Weapon(String name, int value, int maxDamage, int minDamage) {
        super(name, value);
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
    }

    public int dealDamage() {
        Random random = new Random();
        return random.nextInt((this.maxDamage - this.minDamage) + this.minDamage);
    }

    @Override
    void assignToCharacter(Character character) {

    }
}
