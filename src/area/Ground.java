package area;

import java.util.Random;

public abstract class Ground {

    protected Double area;
    protected String type;
    protected String state;

    String[] typesOfGround = {"A", "B", "C"};


    public Ground(){
        this.area = 1.00;
        this.type = getRandom(typesOfGround);
    }

    @Override
    public String toString() {
        return "\n\t~Pole: " +
                "powierzchnia: " + area + "ha" +
                ", typ: " + type +
                ", status: '" + state;
    }

    public void changeState() {
    }
    public String getState() {
        return this.state;
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
