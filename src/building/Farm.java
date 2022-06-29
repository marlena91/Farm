package building;

import animals.Animal;

import java.util.List;

public class Farm extends Outbuilding {
    public Farm(Double value){
        super(value);
    }

    @Override
    public List<Animal> getAnimals() {
        return null;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public String toString() {
        return "\n*Zagroda";
    }
}
