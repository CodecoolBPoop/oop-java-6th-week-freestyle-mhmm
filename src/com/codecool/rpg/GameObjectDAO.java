package com.codecool.rpg;

import com.codecool.rpg.GameObjects.GameObject;
import com.codecool.rpg.GameObjects.GameObjectType;

import java.util.List;

public interface GameObjectDAO {

    void remove(int id);

    GameObject getRandom();
    List<GameObject> getBy(GameObjectType type);
    List<GameObject> getAll();

}
