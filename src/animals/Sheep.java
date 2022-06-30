package animals;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheep)) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(name, sheep.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
