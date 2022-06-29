package animals;

public class Sheep extends Animal implements Collectible, Feedable, Selable {

    private String name;

    public Sheep(String name) {
        this.name = name;
    }

    @Override
    public void collect() {
        System.out.println("Golę owce");
    }

    @Override
    public void feed() {
        System.out.println("Karmię owce");
    }

    @Override
    public void sell() {
        System.out.println("Sprzedaje owce");
    }

    @Override
    public String toString() {
        return "Owca: " +
                name + '\'';
    }
}
