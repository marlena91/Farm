package area;

import actions.RandomInteger;

import java.util.List;
import java.util.Random;

public class Ground implements Field{

    private Integer area;
    private Integer freeArea;

    private Integer numberOfBuildings;
    private Double value;

    private static final Double COST_OF_ONE_HECTARE = 400000.00;

    public Ground(Integer area, Integer numberOfBuildings) {
        this.area = area;
        this.freeArea = this.area;
        this.value = area * COST_OF_ONE_HECTARE;
        this.numberOfBuildings = numberOfBuildings;
    }

    public Integer getArea() {
        return area;
    }

    public Integer getFreeArea() {
        return freeArea;
    }

    public Double getValue() { return value;}

    public Integer getNumberOfBuildings(){
        return numberOfBuildings;
    }
    public void subtractNumberOfBuilding(){
        this.numberOfBuildings -= 1;
    }

    @Override
    public String toString() {
        return "\t~Pole: " +
                "powierzchnia: " + area + "ha, maksymalna liczba budynkow: " + numberOfBuildings +", wartosc: "+value + ", freearea: "+getFreeArea();
    }

    //    String[] typesOfGround = {"A", "B", "C"};
//    getRandom(typesOfGround);
//
//    public static String getRandom(String[] array) {
//        int rnd = new Random().nextInt(array.length);
//        return array[rnd];
//    }
}
