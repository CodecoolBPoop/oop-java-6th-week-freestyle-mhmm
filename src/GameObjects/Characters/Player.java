package GameObjects.Characters;
import GameObjects.Items.*;

import java.util.Random;

public class Player extends Character {
    private int strength;
    private int agility;
    private int intelligence;
    private Armor fullBody;
    private Weapon weapon;

    public void setFullBody(Armor fullBody) {
        this.fullBody = fullBody;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        return this.weapon.dealDamage() + strength;
    }

    public void changeStrength (int changeAmount){
        this.strength += changeAmount;
    }

    public boolean strengthTest(int testValue){
        return testValue<strength;
    }

    public void changeAgility (int changeAmount){
        this.agility += changeAmount;
    }

    public boolean agilityTest(int testValue){
        return testValue<agility;
    }

    public void changeIntelligence (int changeAmount){
        this.intelligence += changeAmount;
    }

    public boolean intelligenceTest(int testValue){
        return testValue<intelligence;
    }

}
