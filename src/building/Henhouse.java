package building;

import animals.Animal;

import java.util.List;

public class Henhouse extends Outbuilding{

    public Henhouse(Double value){
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
    public String toString() {
        return "\n\t~Kurnik";
    }
}
