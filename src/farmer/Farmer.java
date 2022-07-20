package farmer;

import animals.Animal;
import area.FertileField;
import area.Field;
import area.Ground;
import building.HouseForPets;
import building.Outbuilding;
import crops.Plant;
import crops.Seedable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Farmer {

    private String name;
    private Double cash;

    private List<Ground> farms = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private List<Outbuilding> buildings = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Seedable> crops = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    private static final Double DEFAULT_CASH_FOR_START = 6000000.00;

    public Farmer(String name) {
        this.name = name;
        this.cash = DEFAULT_CASH_FOR_START;
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

    public List<FertileField> getAdditionalArea() {
        List<FertileField> farms = new ArrayList<>();
        for(Field field : this.fields){
            if(field.getClass().getSimpleName().equals("FertileField")){
                farms.add((FertileField) field);
            }
        }
        return farms;
    }

    public List<Ground> getFarms() {
        List<Ground> farms = new ArrayList<>();
        for(Field field : this.fields){
            if(field.getClass().getSimpleName().equals("Ground")){
                farms.add((Ground)field);
            }
        }
        return farms;
    }
    public List<Field> getFields() {
        return fields;
    }

    public void addFarm(Ground field) {
        this.farms.add(field);
        this.addField(field);
    }

    public void addField(Field field){
        this.fields.add(field);
    }

    public Integer sumOfAllFields() {
        Integer totalFarmArea = 0;
        for (Field field : this.getFields()) {
            totalFarmArea += field.getArea();
        }
        return totalFarmArea;
    }


    public List<Outbuilding> getBuild() {
        return buildings;
    }

    public List<HouseForPets> getHousesForPets() {
        List<HouseForPets> buildings = new ArrayList<>();
        for (Outbuilding building : this.getBuild()) {
            if (!building.getClass().getSimpleName().equals("Barn")) {
                buildings.add((HouseForPets) building);
            }
        }
        return buildings;
    }

    public List<Seedable> getCrops() {
        return crops;
    }
    public List<Plant> getPlants() {
        return plants;
    }

    public void addCrop(Seedable crop){
        this.crops.add(crop);

    }

    public void addPlant(Plant plant) {
        if(this.cash >= plant.getCost()){
            this.plants.add(plant);
            this.subtractCash(plant.getCost());
        } else {
            System.out.println("Brak pieniedzy na ten produkt");
        }
    }

    public void subtractAdditionalFertileField() {
        for(Field field : this.getAdditionalArea()){
            this.fields.remove(field);
            break;
        }
        System.out.println("Pomyslnie sprzedano ziemie");
    }

    public void subtractPlant(Plant plant){
        this.plants.remove(plant);
    }



    public List<Animal> getAllAnimals(){
        this.animals.clear();
        for(HouseForPets building : this.getHousesForPets()){
            this.animals.addAll(building.getAnimals());
        }
        return this.animals;
    }


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
        return this.farms.get(nr);
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
            for (HouseForPets building : getHousesForPets()) {
                if (building.getClass().getSimpleName().equals(className)) {
                    building.addAnimal(animal);
                }
            }
            this.cash -= price;
            System.out.println("Kupiono zwierze");
        }
    }

    public void deleteAnimal(Animal animal, String className) {
        for (HouseForPets building : getHousesForPets()) {
            if (building.getClass().getSimpleName().equals(className)) {
                building.deleteAnimal(animal);
            }
        }
    }

    public void sellGoods(String className) {
        for (HouseForPets building : getHousesForPets()) {
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
