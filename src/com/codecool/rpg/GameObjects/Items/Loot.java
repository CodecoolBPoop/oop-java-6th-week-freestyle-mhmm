package com.codecool.rpg.GameObjects.Items;

import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.ItemsDataDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loot {

    private List<Item> loot = new ArrayList<>();
    private ItemsDataDao itemsList = ItemsDataDao.getInstance();
    private int gold;
    private Random random = new Random();

    public Loot() {
        this.gold = random.nextInt(10) + 1;
        add();
    }

    public void add() {
        int numberOfLoots = random.nextInt(3) + 1;
        fillUpLoot(numberOfLoots);
    }

    private void fillUpLoot(int numberOfLoots) {
        for (int i = 0; i < numberOfLoots; i++) {
            GameObject item = itemsList.getRandom();
            if (item instanceof Item) {
                loot.add((Item) item);
            }
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(loot);
    }

    public int getGold() {
        return gold;
    }
}
