package building;

import animals.Cow;

public class Cowshed extends Outbuilding {

    private Cow cow;

    public Cowshed() {
        this.cow = new Cow("Bettina");
    }

    @Override
    public String toString() {
        return "\n* Obora. W oborze znajduje się: " +
                cow;
    }
}