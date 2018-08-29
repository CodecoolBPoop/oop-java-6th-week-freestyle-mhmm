package GameObjects.Items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    @Test
    void testArmorConstructor() {
        Armor armor = new Armor("Sacred Armor", 75, 50);
        assertNotNull(armor);
    }
}