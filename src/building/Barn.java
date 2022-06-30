package building;

import animals.Animal;
import equipment.Plow;
import equipment.Seeder;
import equipment.Tractor;

import java.util.List;

public class Barn extends Outbuilding{
    private Tractor tractor;
    private Seeder seeder;
    private Plow plow;

    public Barn(Double value) {
        super(value);
        this.tractor = new Tractor("Ursus", "C360", 1980, 3.2, 52);
    }

    @Override
    public List<Animal> getAnimals() {
        return null;
    }

    @Override
    public void addAnimal(Animal animal) {
        //
    }

    @Override
    public void deleteAnimal(Animal animal) {
        //
    }

    public Seeder getSeeder() {
        return this.seeder;
    }
    public Tractor getTractor() {
        return this.tractor;
    }
    public Plow getPlow() {
        return this.plow;
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
