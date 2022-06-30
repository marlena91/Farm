package animals;

public class Bee extends Animal implements Collectible{

    @Override
    public void collect() {
        System.out.println("Zbieram miód");
    }

    @Override
    public String toString() {
            return "Rój pszczół ";
    }
}
