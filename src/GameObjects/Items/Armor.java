package GameObjects.Items;

public class Armor extends Item {

    private int healthIncrease;

    Armor(String name, int value, int healthIncrease) {
        super(name, value);
        this.healthIncrease = healthIncrease;
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }

    @Override
    void assignToCharacter(GameObjects.Characters.Enemy.Character character) {
        character.addItemToInventory(this);
    }
}
