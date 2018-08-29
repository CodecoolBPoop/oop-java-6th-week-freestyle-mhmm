import GameObjects.Characters.Character;
import GameObjects.Characters.Player;
import GameObjects.GameObject;
import GameObjects.GameObjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CharactersDataDao implements GameObjectDAO {

    private static List<Character> charactersList = new ArrayList<>();

    private static CharactersDataDao instance = null;

    private CharactersDataDao() {}

    public static CharactersDataDao getInstance() {
        if (instance == null) {
            instance = new CharactersDataDao();
        }
        return instance;
    }

    public void addItem(Character character) {
        charactersList.add(character);
    }
    @Override
    public void remove(int id) {
        charactersList.remove(id);
    }

    @Override
    public GameObject getRandom() {
        Random random = new Random();
        int randomIndex;

        do {
            randomIndex = random.nextInt(charactersList.size());
        } while (charactersList.get(randomIndex) instanceof Player);

        return charactersList.get(randomIndex);
    }

    @Override
    public List<GameObject> getBy(GameObjectType type) {
        return charactersList.stream()
                .filter(character -> character.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObject> getAll() {
        return new ArrayList<>(charactersList);
    }
}
