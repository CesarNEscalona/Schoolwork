package abstract_factory_pattern.animals.animals.factories;

import abstract_factory_pattern.animals.animals.animals.AquaAnimals;
import abstract_factory_pattern.animals.animals.animals.IAnimals;
import abstract_factory_pattern.animals.animals.caretakers.AquaCaretakers;
import abstract_factory_pattern.animals.animals.caretakers.ICaretakers;

public class AquaProgramFactory implements IProgramFactory {
    @Override
    public IAnimals getAnimalProvider() {
        return new AquaAnimals();
    }

    @Override
    public ICaretakers getCaretakerProvider() {
        return new AquaCaretakers();
    }
}
