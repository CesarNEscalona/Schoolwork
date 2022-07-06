package abstract_factory_pattern.animals.animals.caretakers;

import abstract_factory_pattern.animals.animals.entities.Caretaker;

import java.util.Map;

public interface ICaretakers
{
    public Map<String, Caretaker> getAllCharacters();
    public Caretaker getCharacterByName(String fullName);
}

