package GameObjects.Characters.Enemy;

import java.util.Random;

public class Player extends Character {
    int strength;
    int agility;
    int intelligence;
    Armor fullBody;
    Weapon weapon;

    public void attack(){
        return this.weapon.dealDamage();
    }

    public boolean strengthTest(int testValue){
        return testValue<strength;
    }

    public boolean agilityTest(int testValue){
        return testValue<agility;
    }

    public boolean intelligenceTest(int testValue){
        return testValue<intelligence;
    }

    public void equip(Armor armor){
        this.fullBody = armor;
    }

    public void equip(Weapon weapon){
        this.weapon = weapon;
    }


}
