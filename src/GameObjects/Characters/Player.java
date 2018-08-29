package GameObjects.Characters;
import GameObjects.Items.*;

public class Player extends Character {
    private int strength;
    private int agility;
    private int intelligence;
    private Armor fullBody;
    private Weapon weapon;

    public Player(int X, int Y, int hitPoint, int damage) {
        super(X, Y, 30, 0);
        strength = 3;
        agility = 3;
        intelligence = 3;
    }

    public void setFullBody(Armor fullBody) {
        if (this.fullBody != null)
            this.hitPoint -= this.fullBody.getHealthIncrease();
        this.hitPoint += fullBody.getHealthIncrease();
        this.fullBody = fullBody;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        if (this.weapon == null)
            return strength;
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
