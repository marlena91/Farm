package animals;

public class Goat extends Animal implements Collectible, Feedable, Selable {
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
}
