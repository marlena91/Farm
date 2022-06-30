package building;

import animals.Animal;
import equipment.Seeder;
import equipment.Tractor;

import java.util.List;

public class Barn extends Outbuilding{
    private Tractor tractor;
    private Seeder seeder;

    public Barn(Double value) {
        super(value);
        this.tractor = new Tractor("Ursus", "C360", 1980, 3.2, 52);
    }
    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void addAnimal(Animal animal) {
        System.out.println("Dochodzą kolejne pająki");
    }

    @Override
    public void deleteAnimal(Animal animal) {
        System.out.println("Wyganiasz pająki miotłą");
    }

    public Seeder getSeeder() {
        return this.seeder;
    }

    public void addSeeder() {
        this.seeder = new Seeder(3, 250);
    }

    public Tractor getTractor() {
        return this.tractor;
    }

    @Override
    public String toString() {
        if(seeder!=null){
            return "\n\t~Stodoła. " +
                    "W stodole znajduje się: " + "\n" +
                    tractor + "\n" +
                    seeder;
        } else return "\n\t~Stodoła. " +
                "W stodole znajduje się: " + "\n" +
                tractor;

    }
}
