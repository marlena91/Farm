package building;

import animals.Animal;

import java.util.List;

public class Farm extends Outbuilding  {
    public Farm(Double value){
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
        return "\n\t~Zagroda. W zagrodzie znajdują się: "+animals;
    }
}
