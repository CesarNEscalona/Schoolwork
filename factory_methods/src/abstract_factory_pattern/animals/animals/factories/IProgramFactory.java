package abstract_factory_pattern.animals.animals.factories;

import abstract_factory_pattern.animals.animals.animals.IAnimals;
import abstract_factory_pattern.animals.animals.caretakers.ICaretakers;

public interface IProgramFactory {

    // define a few factory methods for a 'family' or objects in an animal collecting program
    IAnimals getAnimalProvider();
    ICaretakers getCaretakerProvider();
}
