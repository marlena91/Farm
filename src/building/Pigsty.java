package building;

import animals.Animal;
import animals.Pig;

import java.util.List;

public class Pigsty extends Outbuilding {

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
    animals.add(animal);
    }

    @Override
    public void deleteAnimal(Animal animal) {
    animals.remove(animal);
    }

    @Override
    public String toString() {
        return "\n\t~Chlew. W chlewie znajduje sie: "+animals;
    }
}
