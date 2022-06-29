package animals;

public class Goat extends Animal implements Collectible, Feedable, Selable, Reproducible {
    @Override
    public void collect() {
        System.out.println("Doje kozy");
    }

    @Override
    public void feed() {
        System.out.println("Karmie kozy");
    }

    @Override
    public void sell() {
        System.out.println("Sprzedaje kozy");
    }

    @Override
    public void reproduce() {
        System.out.println("Rozmnażam kozy");

    }
}
