package animals;

public class Cow extends Animal implements Collectible, Feedable{
    private String name;

    public Cow(String name){
        this.name = name;
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
    public String toString() {
        return "Krowa: " +
                name + ". ";
    }
}
