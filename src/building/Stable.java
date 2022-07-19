package building;

import animals.Animal;

import java.util.List;

public class Stable extends Outbuilding implements HouseForPets{
    public Stable(Double value) {
        super(value);
    }

    @Override
    public List<Animal> getAnimals() {
        return null;
    }

    @Override
    public void addAnimal(Animal animal) {

    }

    @Override
    public void deleteAnimal(Animal animal) {

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
