package animals;

public class Pig extends Animal implements Feedable, Selable {

    private String name;

    public Pig(String name) {
        this.name = name;
    }

    @Override
    public void feed() {
        System.out.println("Karmie świnie");
    }

    @Override
    public void sell() {
        System.out.println("Sprzedaje swinie");
    }

    @Override
    public String toString() {
        return "Świnia" +
                name + '\'';
    }
}
