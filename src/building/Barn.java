package building;

import equipment.Plow;
import equipment.Seeder;
import equipment.Tractor;

public class Barn extends Outbuilding{
    private Tractor tractor;
    private Seeder seeder;
    private Plow plow;

    public Barn(Double value) {
        super(value);
        this.tractor = new Tractor("Ursus", "C360", 1980, 3.2, 52);
    }

    public Seeder getSeeder() {
        return this.seeder;
    }

    public void addSeeder() {
        this.seeder = new Seeder(3, 250);
    }

    @Override
    public String toString() {
        return "\n* Stodoła. " +
                "W stodole znajduje się: " + "\n" +
                "- traktor: " + tractor + "\n" +
                "- pług: " + plow + "\n" +
                "- siewnik: " + seeder;
    }
}
