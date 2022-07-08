package building;

import animals.Animal;
import animals.Cow;

import java.util.List;

public class Cowshed extends Outbuilding {


    public Cowshed(Double value){
        super(value);
    }

    public void addCow(String name){
        Cow cow = new Cow(name);
        animals.add(cow);
    }

    @Override
    public List<Animal> getAnimals(){
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
            return "\t~Obora. Zwierzeta w Oborze: "+animals +"\n";
        } else {
            return "\t~Obora,\n";
        }
    }
}