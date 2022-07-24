package building;

import crops.Seedable;

import java.util.List;

public interface PlantStorage {
    List<Seedable> getPlants();

    void addPlant(Seedable plant);

    void deletePlant(Seedable plant);
}
