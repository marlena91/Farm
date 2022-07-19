package building;

import animals.Animal;
import animals.Bee;

import java.util.List;

public class BeeYard extends Outbuilding implements HouseForPets{

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
        if(animals.size() > 0){
            return "\t~Pasieka. Zwierzeta w Pasiece: "+animals +"\n";
        } else {
            return "\t~Pasieka,\n";
        }
    }
}
