package building;

import animals.Animal;

import java.util.List;

public class Henhouse extends Outbuilding{

    public Henhouse(Double value){
        super(value);
    }

    @Override
    public List<Animal> getAnimals() {
        return null;
    }

    @Override
    public void addAnimal(Animal animal) {
    //
    }

    @Override
    public void deleteAnimal(Animal animal) {
    //
    }

    @Override
    public String toString() {
        return "\n*Kurnik";
    }
}
