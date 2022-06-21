package building;

import animals.Cow;

public class Cowshed extends Outbuilding {

    private Cow cow;

    public Cowshed(Double value){
        super(value);
        this.cow = new Cow("Bettina");
    }


    @Override
    public String toString() {
        return "\n* Obora. W oborze znajduje się: " + cow;
    }
}