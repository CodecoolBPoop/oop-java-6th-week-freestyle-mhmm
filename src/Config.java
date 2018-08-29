import GameObjects.Items.Armor;
import GameObjects.Items.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    public static void initialize() {

        ItemsDataDao itemsData = ItemsDataDao.getInstance();

        Armor armor1 = new Armor("Sacred Armor", 80, 40);
        Armor armor2 = new Armor("Shadow Plate", 80, 40);
        Armor armor3 = new Armor("Kraken Shell", 80, 40);
        Armor armor4 = new Armor("Diamond Mail", 80, 40);

        itemsData.addItem(armor1);
        logger.info("'{}' added to items database", armor1.getName());
        itemsData.addItem(armor2);
        logger.info("'{}' added to items database", armor2.getName());
        itemsData.addItem(armor3);
        logger.info("'{}' added to items database", armor3.getName());
        itemsData.addItem(armor4);
        logger.info("'{}' added to items database", armor4.getName());

        Weapon weapon1 = new Weapon("Mythical Sword", 40, 40, 30);
        Weapon weapon2 = new Weapon("Colossus Blade", 40, 40, 30);
        Weapon weapon3 = new Weapon("Hydra Bow", 40, 40, 30);

        itemsData.addItem(weapon1);
        logger.info("'{}' added to characters database", weapon1.getName());
        itemsData.addItem(weapon2);
        logger.info("'{}' added to characters database", weapon2.getName());
        itemsData.addItem(weapon3);
        logger.info("'{}' added to characters database", weapon3.getName());
    }

}
