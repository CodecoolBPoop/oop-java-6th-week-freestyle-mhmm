import GameObjects.GameObject;
import GameObjects.GameObjectType;

import java.util.List;

public interface GameObjectDAO {

    void remove(int id);

    GameObject findById(int id);
    GameObject getRandom();

    List<GameObject> getBy(GameObjectType type);
    List<GameObject> getAll();

}
