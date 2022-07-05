package animals;

public class Pig extends Animal implements Feedable {

    private String name;

    public Pig(String name) {
        this.name = name;
    }

    @Override
    public void feed() {
        System.out.println("Karmie świnie");
    }

    @Override
    public String toString() {
        return "Świnia: " +
                name+ ".";
    }
}
