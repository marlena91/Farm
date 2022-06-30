package farmer;

import animals.Animal;
import area.FertileField;
import area.Ground;
import building.Barn;
import building.Cowshed;
import building.Outbuilding;
import building.Pigsty;
import equipment.Seeder;

import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private String name;
    private Double cash;
    private List<Ground> field = new ArrayList<Ground>();
    private List<Outbuilding> buildings = new ArrayList<Outbuilding>();


    public Farmer(String name) {
        this.name = name;
        this.cash = 600000.00;

        field.add(new FertileField());
        field.add(new FertileField());

        Cowshed cowshed = new Cowshed(100000.00);
        buildings.add(cowshed);
        cowshed.addCow("Bettina");
        buildings.add(new Barn(200000.00));
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Ground> getField() {
        return field;
    }

    public List<Outbuilding> getBuild() {
        return buildings;
    }

    public void getAnimals(){
        for (Outbuilding building : this.getBuild()) {
            if (!building.getClass().getSimpleName().equals("Barn")) {
                System.out.println(building.getAnimals());
            }
        }
    }

    public List<Animal> getAnimals(String farmBuilding){
        List<Animal> animals = null;
        for (Outbuilding building : this.getBuild()) {
            if (building.getClass().getSimpleName().equals(farmBuilding)) {
                animals = building.getAnimals();
                break;
            }
        }
        return animals;
    }

    public Ground getSingleField(Integer nr) {
        return this.field.get(nr);
    }

    public void addField(Ground field, Double price) {
        if (this.cash <= price) {
            System.out.println("Za mało pieniędzy na zakup tej działki");
        } else {
            this.field.add(field);
            this.cash -= price;
            System.out.println("Pomyślnie zakupiono ziemię.");
        }
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

    public void addAnimal(Animal animal, Double price, String className){
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

    public void deleteAnimal(Animal animal, String className){
        for (Outbuilding building : getBuild()) {
            if (building.getClass().getSimpleName().equals(className)) {
                building.deleteAnimal(animal);
            }
        }
    }

    public void sellGoods(String className){
        for (Outbuilding building : getBuild()) {
            if (building.getClass().getSimpleName().equals(className)) {
                Double profit = 1000.00*(building.getAnimals().size());
                addCash(profit);
                System.out.println("Zarobiłeś "+profit+"PLN ");
                System.out.println("Aktualny stan konta: "+getCash());
            }
        }
    }

    @Override
    public String toString() {
        return "\tFarmer " + name + ",\n\n" +
                "\tDostępna gotówka: " + cash + " PLN" + "\n\n" +
                "\tPosiadane pola: " + field + "\n\n" +
                "\tPosiadane budynki: " + buildings + "\n\n";
    }
}
