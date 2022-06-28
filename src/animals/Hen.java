package animals;

import building.Outbuilding;

public class Hen extends Outbuilding implements Collectible, Feedable {

    public Hen(Double value){
        super(value);
    }

    @Override
    public void collect() {
        System.out.println("Zbieram jajka");
    }

    @Override
    public void feed() {
        System.out.println("Karmie kury");
    }
}
