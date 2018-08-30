package com.codecool.rpg.GameObjects.Items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    private Weapon weapon;

    @BeforeEach
    void createWeapon() {
        weapon = new Weapon("Mythical Sword", 20, 50, 40);
    }

    @Test
    void testWeaponNameIsNotNull() {
        assertNotNull(weapon.getName());
    }

    @Test
    void testWeaponMinDamageIsCorrect() {
        assertEquals(40, weapon.getMinDamage());
    }

    @Test
    void testWeaponMaxDamageIsCorrect() {
        assertEquals(50, weapon.getMaxDamage());
    }

    @RepeatedTest(10)
    void testWeaponDealsDamage() {
        int damage = weapon.dealDamage();
        assertTrue(damage > 39 && damage < 51);
    }

}