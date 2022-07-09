package farmer;

import animals.Animal;
import area.Ground;
import building.Outbuilding;
import crops.Plant;

import java.util.ArrayList;
import java.util.List;

public class Farmer {

    private String name;
    private Double cash;
    private Integer additionalArea;

    private List<Ground> fields = new ArrayList<>();
    private List<Outbuilding> buildings = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> crops = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    private static final Double DEFAULT_CASH_FOR_START = 6000000.00;

    public Farmer(String name) {
        this.name = name;
        this.cash = DEFAULT_CASH_FOR_START;
        this.additionalArea = 0;
    }

    public Double getCash() {
        return this.cash;
    }

    public void addCash(Double cash) {
        this.cash += cash;
    }

    public void subtractCash(Double cash) {
        this.cash -= cash;
    }

    public Integer getAdditionalArea() {
        return additionalArea;
    }

    public List<Ground> getField() {
        return fields;
    }

    public List<Outbuilding> getBuild() {
        return buildings;
    }

    public List<Plant> getCrops() {
        return crops;
    }
    public List<Plant> getPlants() {
        return plants;
    }

    public void addField(Ground field) {
        this.fields.add(field);
    }

    public void addPlant(Plant plant) {
        if(this.cash >= plant.getCost()){
            this.plants.add(plant);
            this.subtractCash(plant.getCost());
        } else {
            System.out.println("Brak pieniedzy na ten produkt");
        }
    }

    public void addAdditionalFertileField() {
        this.additionalArea += 1;
    }

    public void substractAdditionalFertileField(Integer area) {
        if (area <= this.getAdditionalArea()) {
            this.additionalArea -= area;
            System.out.println("Pomyslnie sprzedano ziemie");
        } else {
            System.out.println("Zla wartosc. Nie udalo sie sprzedac ziemi");
        }
    }

    public Integer sumOfAllFields() {
        Integer totalFarmArea = 0;
        for (Ground field : this.getField()) {
            totalFarmArea += field.getArea();
        }
        totalFarmArea += this.additionalArea;
        return totalFarmArea;
    }

    public List<Animal> getAllAnimals() {
        for (Outbuilding building : this.getBuild()) {
            if (!building.getClass().getSimpleName().equals("Barn")) {
                this.animals = building.getAnimals();
            }
        }
        return this.animals;
    }


//    public void getAnimals() {
//        for (Outbuilding building : this.getBuild()) {
//            if (!building.getClass().getSimpleName().equals("Barn")) {
//                System.out.println(building.getAnimals());
//            }
//        }
//    }
//

//
//    public List<Animal> getAnimals(String farmBuilding) {
//        List<Animal> animals = null;
//        for (Outbuilding building : this.getBuild()) {
//            if (building.getClass().getSimpleName().equals(farmBuilding)) {
//                animals = building.getAnimals();
//                break;
//            }
//        }
//        return animals;
//    }

    public Ground getSingleField(Integer nr) {
        return this.fields.get(nr);
    }


    public void addBuilding(Outbuilding building, Double price) {
        if (this.cash <= price) {
            System.out.println("Za mało pieniędzy na zakup tego budynku");
        } else {
            this.buildings.add(building);
            this.cash -= price;
            System.out.println("Kupiono budynek");
        }
    }

    public void removeBuilding(Outbuilding building) {
        if (!building.getClass().getSimpleName().equals("Barn")) {
            buildings.remove(building);
            System.out.println("Budynek został zburzony ");

        } else {
            System.out.println("Nie mozna zburzyc stodoły ");
        }
    }

    public void addAnimal(Animal animal, Double price, String className) {
        if (this.cash <= price) {
            System.out.println("Za mało pieniędzy na zakup tego zwierzęcia");
        } else {
            for (Outbuilding building : getBuild()) {
                if (building.getClass().getSimpleName().equals(className)) {
                    building.addAnimal(animal);
                }
            }
            this.cash -= price;
            System.out.println("Kupiono zwierze");
        }
    }

    public void deleteAnimal(Animal animal, String className) {
        for (Outbuilding building : getBuild()) {
            if (building.getClass().getSimpleName().equals(className)) {
                building.deleteAnimal(animal);
            }
        }
    }

    public void sellGoods(String className) {
        for (Outbuilding building : getBuild()) {
            if (building.getClass().getSimpleName().equals(className)) {
                Double profit = 1000.00 * (building.getAnimals().size());
                addCash(profit);
                System.out.println("Zarobiłeś " + profit + "PLN ");
                System.out.println("Aktualny stan konta: " + getCash());
            }
        }
    }

    @Override
    public String toString() {

        return "\n\tFarmer " + name + ",\n\n" +
                "\tDostępna gotówka: " + cash + " PLN" + "\n" +
                "\tPosiadane pola: " + sumOfAllFields() + "ha\n" +
                "\tPosiadane budynki: " + (long) buildings.size() + "\n" +
                "\tPosiadane zwierzeta: " + (long) getAllAnimals().size() + "\n" +
                "\tPosiadane uprawy: " + (long) crops.size() + "\n";

    }
}
