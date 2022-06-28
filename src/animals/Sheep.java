package animals;

public class Sheep extends Animal implements Collectible, Feedable, Reproducible, Selable {
    @Override
    public void collect() {
        System.out.println("Golę owce");
    }

    @Override
    public void feed() {
        System.out.println("Karmię owce");
    }

    @Override
    public void reproduce() {
        System.out.println("Rozmnażam owce");
    }

    @Override
    public void sell() {
        System.out.println("Sprzedaje owce");
    }
}
