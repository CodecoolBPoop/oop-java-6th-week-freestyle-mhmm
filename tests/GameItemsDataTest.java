import com.codecool.rpg.GameObjects.GameObjectType;
import com.codecool.rpg.GameObjects.Items.Armor;
import com.codecool.rpg.GameObjects.Items.Item;
import com.codecool.rpg.GameObjects.Items.Weapon;
import com.codecool.rpg.ItemsDataDao;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameItemsDataTest {

    @Test
    void testGetInstanceIsNotNull() {
        assertNotNull(ItemsDataDao.getInstance());
    }

    @Test
    void testAddItem() {
        Armor armor = new Armor("Sacred Armor", 80, 40);
        ItemsDataDao.getInstance().addItem(armor);
        assertNotNull(ItemsDataDao.getInstance().findById(armor.getId()));
    }

    @RepeatedTest(20)
    void testGetRandomItem() {
        Armor armor1 = new Armor("Sacred Armor", 80, 40);
        Armor armor2 = new Armor("Shadow Plate", 80, 40);
        Armor armor3 = new Armor("Kraken Shell", 80, 40);
        Armor armor4 = new Armor("Diamond Mail", 80, 40);
        Weapon weapon1 = new Weapon("Mythical Sword", 40, 40, 30);
        Weapon weapon2 = new Weapon("Colossus Blade", 40, 40, 30);
        Weapon weapon3 = new Weapon("Hydra Bow", 40, 40, 30);

        ItemsDataDao itemsData = ItemsDataDao.getInstance();
        itemsData.addItem(armor1);
        itemsData.addItem(armor2);
        itemsData.addItem(armor3);
        itemsData.addItem(armor4);
        itemsData.addItem(weapon1);
        itemsData.addItem(weapon2);
        itemsData.addItem(weapon3);

        Item randomItem = (itemsData.getRandom() instanceof Item) ? (Item) itemsData.getRandom() : null;
        assertNotNull(randomItem);
        System.out.println(randomItem.getName());
    }

    @Test
    void testRemove() {
        List<Item> expected = new ArrayList<>();
        Armor armor = new Armor("Sacred Armor", 80, 40);
        ItemsDataDao items = ItemsDataDao.getInstance();
        items.addItem(armor);
        items.remove(armor.getId());
        assertEquals(expected, items.getAll());
    }

    @Test
    void testGetBy() {
        List<Item> expected = new ArrayList<>();

        Armor armor1 = new Armor("Sacred Armor", 80, 40);
        Armor armor2 = new Armor("Shadow Plate", 80, 40);
        Armor armor3 = new Armor("Kraken Shell", 80, 40);
        Armor armor4 = new Armor("Diamond Mail", 80, 40);
        Weapon weapon1 = new Weapon("Mythical Sword", 40, 40, 30);
        Weapon weapon2 = new Weapon("Colossus Blade", 40, 40, 30);
        Weapon weapon3 = new Weapon("Hydra Bow", 40, 40, 30);

        ItemsDataDao itemsData = ItemsDataDao.getInstance();
        itemsData.addItem(armor1);
        itemsData.addItem(armor2);
        itemsData.addItem(armor3);
        itemsData.addItem(armor4);
        itemsData.addItem(weapon1);
        itemsData.addItem(weapon2);
        itemsData.addItem(weapon3);

        expected.add(weapon1);
        expected.add(weapon2);
        expected.add(weapon3);

        assertEquals(expected, itemsData.getBy(GameObjectType.WEAPON));
    }
}