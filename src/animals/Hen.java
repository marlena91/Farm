package animals;

import building.Outbuilding;

import java.util.List;

public class Hen extends Outbuilding implements Collectible, Feedable {

    public Hen(Double value){
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
    public void collect() {
        System.out.println("Zbieram jajka");
    }

    @Override
    public void feed() {
        System.out.println("Karmie kury");
    }
}
