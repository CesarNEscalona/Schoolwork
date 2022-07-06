package abstract_factory_pattern.animals.animals.driver;

import abstract_factory_pattern.animals.animals.caretakers.ICaretakers;
import abstract_factory_pattern.animals.animals.entities.Animal;
import abstract_factory_pattern.animals.animals.entities.Caretaker;
import abstract_factory_pattern.animals.animals.factories.AquaProgramFactory;
import abstract_factory_pattern.animals.animals.factories.IProgramFactory;
import abstract_factory_pattern.animals.animals.factories.PokemonProgramFactory;
import abstract_factory_pattern.animals.animals.factories.ZooProgramFactory;

import java.util.Map;

public class TestAnimalProgram {

    public static void main(String[] args) {

        // store a factory with the objects we need for an
        // animals program
        IProgramFactory factory = new AquaProgramFactory();

        // then use our program

        // print out the animals that our users can collect
        System.out.println("Here are the animals you can collect");
        for (Animal animal:
             factory.getAnimalProvider().getAnimals()) {
            System.out.println(animal);
        }

        System.out.println("Here are the caretakers");
        ICaretakers caretakerProvider = factory.getCaretakerProvider();
        Map<String, Caretaker> caretakers = caretakerProvider.getAllCharacters();

        for (String name:
                caretakers.keySet()) {
            System.out.println("Meet " + name + " the caretaker!");
        }



    }
}
