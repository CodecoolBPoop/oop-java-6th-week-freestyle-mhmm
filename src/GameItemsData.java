import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameItemsData {

    private static List<Item> itemList = new ArrayList<>();

    private static GameItemsData instance;

    private GameItemsData() {}

    public static GameItemsData getInstance() {
        if (instance == null) {
            instance = new GameItemsData();
        }
        return instance;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public Item getItemById(int id) {
        return itemList.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }

    public Item getRandomItem() {
        Random random = new Random();
        return itemList.get(random.nextInt(itemList.size()));
    }
}
