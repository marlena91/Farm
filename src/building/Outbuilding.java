package building;

import animals.Animal;
import animals.Cow;
import equipment.Seeder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Outbuilding implements AnimalRemovable {

    protected Double value;
    protected List<Animal> animals = new ArrayList<Animal>();


    public Outbuilding(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outbuilding that = (Outbuilding) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public abstract List<Animal> getAnimals();

    public abstract void addAnimal(Animal animal);
}

