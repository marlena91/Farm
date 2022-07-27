package building;

import animals.Animal;
import crops.Seedable;

import java.util.List;

public class Barn extends Outbuilding implements PlantStorage{

    private List<Seedable> plants;

    public Barn(Double value) {
        super(value);
    }
    @Override
    public String toString() {
        return "\t~Stodola,\n";
    }

    @Override
    public List<Seedable> getPlants() {
        return plants;
    }

    @Override
    public void addPlant(Seedable plant) {
        plants.add(plant);
    }

    @Override
    public void deletePlant(Seedable plant) {
        plants.remove(plant);
    }
}
