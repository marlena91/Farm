package building;

import animals.Animal;
import animals.Pig;

import java.util.List;

public class Pigsty extends Outbuilding {

    public Pigsty(Double value){
        super(value);
    }

    public void addPig(){
        Pig pig = new Pig();
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
        if(animals.size() > 0){
            return "\t~chlew. Zwierzeta w chlewie: "+animals +"\n";
        } else {
            return "\t~chlew,\n";
        }
    }
}
