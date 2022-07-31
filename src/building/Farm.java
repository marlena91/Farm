package building;

import actions.RandomInteger;
import animals.Animal;
import animals.Goat;
import animals.Sheep;
import building.interfaces.HouseForPets;

import java.time.LocalDate;
import java.util.List;

public class Farm extends Outbuilding implements HouseForPets {
    public Farm(Double value) {
        super(value);
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void deleteAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void newAnimal(LocalDate date) {
        RandomInteger random = new RandomInteger(1, 2);
        if (random.getRandom() == 1) {
            animals.add(new Goat(date));
        } else {
            animals.add(new Sheep(date));
        }

    }

    @Override
    public String toString() {

        return "\t~Zagroda, ";

    }
}
