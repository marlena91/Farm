package animals;

public class Cow extends Animal{
    private String name;

    public Cow(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nKrowa " + name;
    }
}
