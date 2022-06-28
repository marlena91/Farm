package animals;

public class Cow extends Animal implements Collectible, Feedable, Selable{
    private String name;

    public Cow(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nKrowa " + name;
    }

    @Override
    public void collect() {
        System.out.println("Doję krowy");
    }

    @Override
    public void feed() {
        System.out.println("Karmię krowy");
    }

    @Override
    public void sell() {
        System.out.println("Sprzedaję krowy");
    }
}
