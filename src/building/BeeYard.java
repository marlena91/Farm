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

    public Bee getBees() {
        return bees;
    }
    public void setBees(Bee bees) {
        this.bees = bees;
    }

    @Override
    public String toString() {
        return "\n*Pasieka";
    }
}
