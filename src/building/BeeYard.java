package building;

import animals.Animal;
import animals.Bee;

import java.util.List;

public class BeeYard extends Outbuilding{

    private Bee bees;

    public BeeYard(Double value){
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

    public Bee getBees() {
        return bees;
    }

    public void setBees(Bee bees) {
        this.bees = bees;
    }

    @Override
    public String toString() {
        return "\n\t~Pasieka W pasiece znajduje się: "+animals;
    }
}
