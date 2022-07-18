package area;

import actions.RandomInteger;

public class RandomFarm {

    private Integer minArea = 1;
    private Integer maxArea = 4;
    private Integer minBuilding = 1;
    private Integer maxBuilding = 2;


    public Ground generateRandomFarms() {
        RandomInteger size = new RandomInteger(minArea, maxArea);
        RandomInteger numberOfBuildings = new RandomInteger(minBuilding, maxBuilding);
        return new Ground(size.getRandom(), numberOfBuildings.getRandom());
    }
}
