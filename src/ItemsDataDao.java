import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemsDataDao implements GameObjectDAO {

    private static List<Item> itemList = new ArrayList<>();

    private static ItemsDataDao instance = null;

    private ItemsDataDao() {}

    public static ItemsDataDao getInstance() {
        if (instance == null) {
            instance = new ItemsDataDao();
        }
        return instance;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    @Override
    public void remove(int id) {
        itemList.remove(id);

    }

    public Item findById(int id) {
        return itemList.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public GameObject getRandom() {
        Random random = new Random();
        return itemList.get(random.nextInt(itemList.size()));
    }

    @Override
    public List<GameObject> getBy(GameObjectType type) {
        return itemList.stream()
                .filter(item -> item.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObject> getAll() {
        return new ArrayList<>(itemList);
    }
}
