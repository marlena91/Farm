package building;

import animals.Animal;

import java.time.LocalDate;
import java.util.List;

public interface HouseForPets {
    List<Animal> getAnimals();

    void addAnimal(Animal animal);

    void deleteAnimal(Animal animal);

    void newAnimal(LocalDate date);
}
