package building;

import animals.Animal;
import animals.Cow;
import animals.Pig;

import java.util.List;

public class Pigsty extends Outbuilding{

    public Pigsty(Double value){
        super(value);
    }

    public void addPig(String name){
        Pig pig = new Pig(name);
        animals.add(pig);
    }
    @Override
    public List<Animal> getAnimals() {
        return animals;
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
        return "\n*Chlew";
    }
}
