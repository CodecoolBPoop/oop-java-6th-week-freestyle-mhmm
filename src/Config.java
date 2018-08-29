import GameObjects.Items.Armor;
import GameObjects.Items.Weapon;

public class Config {

    public static void initialize() {

        GameItemsData itemsData = GameItemsData.getInstance();

        Armor armor1 = new Armor("Sacred Armor", 80, 40);
        Armor armor2 = new Armor("Shadow Plate", 80, 40);
        Armor armor3 = new Armor("Kraken Shell", 80, 40);
        Armor armor4 = new Armor("Diamond Mail", 80, 40);

        itemsData.addItem(armor1);
        itemsData.addItem(armor2);
        itemsData.addItem(armor3);
        itemsData.addItem(armor4);

        Weapon weapon1 = new Weapon("Mythical Sword", 40, 40, 30);
        Weapon weapon2 = new Weapon("Colossus Blade", 40, 40, 30);
        Weapon weapon3 = new Weapon("Hydra Bow", 40, 40, 30);

        itemsData.addItem(weapon1);
        itemsData.addItem(weapon2);
        itemsData.addItem(weapon3);

    }
}
