package com.codecool.rpg.GameObjects.Items;

import com.codecool.rpg.GameObjects.Characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    private Armor armor;

    @BeforeEach
    void createArmor() {
        armor = new Armor("Sacred Armor", 75, 50);
    }

    @Test
    void testArmorNameIsNotNull() {
        assertNotNull(armor.getName());
    }

    @Test
    void testArmorValueIsCorrect() {
        assertEquals(armor.getValue(), 75);
    }

    @Test
    void testArmorHealthIncreaseIsCorrect() {
        assertEquals(armor.getHealthIncrease(), 50);
    }

    @Test
    void testArmorAssignToCharacter() {
        Player player = new Player(0,0);
        armor.assignToCharacter(player);
        assertNotNull(player.getItemById(armor.getId()));
    }
}