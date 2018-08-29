package GameObjects.Items;

public abstract class Item {

    private int value;
    private int id;
    private static int nextId;
    private String name;

    Item(String name, int value) {
        this.value = value;
        this.name = name;
        this.id = nextId++;
    }

    abstract void assignToCharacter(Character character);

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
