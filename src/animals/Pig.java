package animals;

public class Pig extends Animal implements Feedable, Reproducible, Selable {

    @Override
    public void feed() {
        System.out.println("Karmie świnie");
    }

    @Override
    public void reproduce() {
        System.out.println("Rzomanżam świnie");
    }

    @Override
    public void sell() {
        System.out.println("Sprzedaje swinie");
    }
}
