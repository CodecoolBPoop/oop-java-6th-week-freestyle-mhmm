package GameObjects.Characters.Enemy;

import GameObjects.GameObject;
import GameObjects.GameObjectType;
import GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Character extends GameObject {
    GameObjectType type;

    int hitPoint;
    int damage;
    private List<Item> items = new ArrayList<>();

    public void takeDamage(int damageAmount){
        this.hitPoint -= damageAmount;
    }

    public GameObjectType getType(){
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public Item getItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
}
