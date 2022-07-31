package building;

import animals.Animal;
import animals.Dog;
import building.interfaces.HouseForPets;

import java.time.LocalDate;
import java.util.List;

public class Doghouse extends Outbuilding implements HouseForPets {
    public Doghouse(Double value) {
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
        Dog dog = new Dog(date);
        animals.add(dog);
    }

    @Override
    public String toString() {
        return "\t~Zagroda dla psow, ";
    }
}
