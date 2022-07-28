package building;

import animals.Animal;

import java.util.List;

public class Stable extends Outbuilding implements HouseForPets{
    public Stable(Double value) {
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
        if(animals.size() > 0){
            return "\t~Stajnia. Zwierzeta w Stajni: "+animals +"\n";
        } else {
            return "\t~Stajnia,\n";
        }
    }
}
