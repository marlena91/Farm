package animals;

import building.Outbuilding;

import java.util.List;

public class Hen extends Animal implements Collectible, Feedable {

    @Override
    public void collect() {
        System.out.println("Zbieram jajka");
    }

    @Override
    public void feed() {
        System.out.println("Karmie kury");
    }
}
