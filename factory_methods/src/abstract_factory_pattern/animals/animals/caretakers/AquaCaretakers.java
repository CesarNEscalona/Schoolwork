package abstract_factory_pattern.animals.animals.caretakers;

import abstract_factory_pattern.animals.animals.entities.Caretaker;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AquaCaretakers implements ICaretakers{

    private Map<String, Caretaker> characters;

    public AquaCaretakers() {
        characters = new HashMap<String, Caretaker>();

        //load our map
        characters.put("Madison", new Caretaker(
                "Madison", "trainer"));
        characters.put("Tristan", new Caretaker(
                "Tristan", "trainer"));
    }

    @Override
    public Map<String, Caretaker> getAllCharacters() {
        return Collections.unmodifiableMap(characters);
    }

    @Override
    public Caretaker getCharacterByName(String fullName) {
        if (!characters.containsKey(fullName))
        {
            throw new IllegalArgumentException(
                    "No name of that type exists!");
        }
        return characters.get(fullName);
    }
}
