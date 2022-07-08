package building;

import animals.Animal;

import java.util.List;

public class Doghouse extends Outbuilding{
    public Doghouse(Double value) {
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
            return "\t~Zagroda dla psow. Zwierzeta w zagrodzie: "+animals +"\n";
        } else {
            return "\t~Zagroda dla psow,\n";
        }
    }
}
