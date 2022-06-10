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
        this.cash = 30000.00;
        this.field = new ArrayList<Ground>();
        field.add(new FertileField());
        field.add(new FertileField());
        this.buildings = new ArrayList<Outbuilding>();
        buildings.add(new Barn());
        buildings.add(new Cowshed());
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Double getCash(){
        return this.cash;
    }

    public void addCash(Double cash){
        this.cash += cash;
    }

    public List<Ground> getField(){
        return field;
    }

    public List<Ground> getBuild(){
        return field;
    }

    public Ground getSingleField(Integer nr) {
        return this.field.get(nr);
    }

    public Boolean isSeederInBarn() {
        Barn barn = (Barn) this.buildings.get(0);
        return barn.getSeeder() != null;
    }

    public void buySeeder(){
        Barn barn = (Barn) this.buildings.get(0);
        barn.addSeeder();
        this.cash -= 20000.00;
    }

    public void addField(Ground field, Double price){
        if(this.cash < price){
            System.out.println("Za mało pieniędzy na zakup tej działki");
        } else {
            this.field.add(field);
            this.cash -=price;
            System.out.println("Pomyślnie zakupiono ziemię.");
        }

    }

    @Override
    public String toString() {
        return "Farmer " + name + ",\n" +
                "dostępna gotówka: " + cash + " PLN" + "\n" +
                "Posiadane pola: " + field + "\n" +
                "Posiadane budynki: " + buildings + "\n"
        ;
    }
}
