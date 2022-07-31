package building;

import animals.Animal;
import building.interfaces.HouseForPets;

import java.time.LocalDate;
import java.util.List;

public class BeeYard extends Outbuilding implements HouseForPets {

    public BeeYard(Double value) {
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

    @Override
    public void newAnimal(LocalDate date) {
        //
    }

    @Override
    public String toString() {
        return "\t~Pasieka, ";
    }
}
