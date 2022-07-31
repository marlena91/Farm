package building;

import animals.Animal;
import animals.Horse;
import building.interfaces.HouseForPets;

import java.time.LocalDate;
import java.util.List;

public class Stable extends Outbuilding implements HouseForPets {
    public Stable(Double value) {
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
        Horse horse = new Horse(date);
        animals.add(horse);
    }

    @Override
    public String toString() {

        return "\t~Stajnia, ";

    }
}
