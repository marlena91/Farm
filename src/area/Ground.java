package area;

import actions.RandomInteger;

import java.util.List;
import java.util.Random;

public class Ground {

    private Integer area;
    private String state;

    public Ground(Integer area) {
        this.area = area;
    }

    public String getState() {
        return this.state;
    }

    public Integer getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "\n\t~Pole: " +
                "powierzchnia: " + area + "ha";
    }

    //    String[] typesOfGround = {"A", "B", "C"};
//    getRandom(typesOfGround);
//
//    public static String getRandom(String[] array) {
//        int rnd = new Random().nextInt(array.length);
//        return array[rnd];
//    }
}
