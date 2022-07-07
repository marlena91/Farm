package area;

import actions.RandomInteger;

import java.util.List;
import java.util.Random;

public class Ground {

    private Integer area;
    private Integer numberOfBuildings;
    private Double value;
    private String state;

    private static final Double COST_OF_ONE_HECTARE = 400000.00;

    public Ground(Integer area, Integer numberOfBuildings) {
        this.area = area;
        this.value = area * COST_OF_ONE_HECTARE;
        this.numberOfBuildings = numberOfBuildings;
    }

    public String getState() {
        return this.state;
    }

    public Integer getArea() {
        return area;
    }

    public Double getValue() { return value;}

    @Override
    public String toString() {
        return "\t~Pole: " +
                "powierzchnia: " + area + "ha, maksymalna liczba budynkow: " + numberOfBuildings +", wartosc: "+value;
    }

    //    String[] typesOfGround = {"A", "B", "C"};
//    getRandom(typesOfGround);
//
//    public static String getRandom(String[] array) {
//        int rnd = new Random().nextInt(array.length);
//        return array[rnd];
//    }
}
