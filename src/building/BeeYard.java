package building;

import animals.Bee;

public class BeeYard extends Outbuilding{

    private Bee bees;

    public BeeYard(Double value){
        super(value);
    }

    public Bee getBees() {
        return bees;
    }
    public void setBees(Bee bees) {
        this.bees = bees;
    }

    @Override
    public String toString() {
        return "\n*Pasieka";
    }
}
