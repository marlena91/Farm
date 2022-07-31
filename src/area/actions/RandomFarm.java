package area.actions;

import actions.RandomInteger;
import area.Ground;

public class RandomFarm {

    public Ground generateRandomFarm() {
        int maxArea = 4;
        int minArea = 1;
        int minBuilding = 1;
        int maxBuilding = 2;
        RandomInteger size = new RandomInteger(minArea, maxArea);
        RandomInteger numberOfBuildings = new RandomInteger(minBuilding, maxBuilding);
        return new Ground(size.getRandom(), numberOfBuildings.getRandom());
    }
}
