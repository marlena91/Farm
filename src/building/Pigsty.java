package building;

import animals.Animal;
import animals.Pig;
import building.interfaces.HouseForPets;

import java.time.LocalDate;
import java.util.List;

public class Pigsty extends Outbuilding implements HouseForPets {

    public Pigsty(Double value) {
        super(value);
    }

    public void newAnimal(LocalDate date) {
        Pig pig = new Pig(date);
        animals.add(pig);
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

    @Override
    public String toString() {

        return "\t~chlew, ";

    }
}
