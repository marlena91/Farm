package building;

import animals.Animal;
import animals.Cow;

import java.time.LocalDate;
import java.util.List;

public class Cowshed extends Outbuilding implements HouseForPets {

    public Cowshed(Double value) {
        super(value);
    }

    public void newAnimal(LocalDate date) {
        Cow cow = new Cow(date);
        animals.add(cow);
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

        return "\t~Obora, ";

    }
}