package GameObjects.Items;

import GameObjects.GameObject;

public abstract class Item extends GameObject {

    private int value;
    private int id;
    private static int nextId;
    private String name;

    Item(String name, int value) {
        this.value = value;
        this.name = name;
        this.id = nextId++;
    }

    abstract void assignToCharacter(GameObjects.Characters.Enemy.Character character);

    int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}
