package building;

import animals.Animal;
import animals.Hen;
import animals.Pig;

import java.time.LocalDate;
import java.util.List;

public class Henhouse extends Outbuilding implements HouseForPets {

    public Henhouse(Double value) {
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
        Hen hen = new Hen(date);
        animals.add(hen);
    }

    @Override
    public String toString() {

        return "\t~Kurnik, ";

    }
}
