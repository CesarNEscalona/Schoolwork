package abstract_factory_pattern.animals.animals.animals;

import abstract_factory_pattern.animals.animals.entities.Animal;

import java.util.Arrays;
import java.util.List;

public class AquaAnimals implements IAnimals{
    @Override
    public List<Animal> getAnimals() {
        Animal[] fish = {
                new Animal("RedFish",
                        new String[] {"breathes bubbles", "looks red"}),
                new Animal("Beta",
                        new String[] {"Fights others"}),
                new Animal("GoldFish",
                        new String[] {"Acts as a pet", "Has no feelings"}),
                new Animal("BlueFish",
                        new String[] {"Hates the RedFish", "CripWalks"})};

        return Arrays.asList(fish);
    }
}
