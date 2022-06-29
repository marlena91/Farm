package farmer;

import area.FertileField;
import area.Ground;
import building.Barn;
import building.Cowshed;
import building.Outbuilding;
import equipment.Seeder;

import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private String name;
    private Double cash;
    private List<Ground> field;
    private List<Outbuilding> buildings;

    public Farmer(String name) {
        this.name = name;
        this.cash = 60000.00;

        this.field = new ArrayList<Ground>();
        field.add(new FertileField());
        field.add(new FertileField());

        this.buildings = new ArrayList<Outbuilding>();
        buildings.add(new Cowshed(100000.00));
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

    @Override
    public String toString() {
        return "Farmer " + name + ",\n" +
                "dostępna gotówka: " + cash + " PLN" + "\n" +
                "Posiadane pola: " + field + "\n" +
                "Posiadane budynki: " + buildings + "\n";
    }
}
