package animals;

import java.time.LocalDate;

public class Bee extends Animal {

    private static final Double COST = 300.00;
    private static final Double PRICE = 300.00;
    private static final Double WEIGHT_OF_FOOD = 0.00;
    private static final String NAME = "Pszczoly";

    private static final String HOUSE = "BeeYard";
    private static final String FOOD = "";

    private static final Integer AGE_IN_WEEKS = 5;

    public Bee() {
        setAll();
    }

    private void setAll() {
        this.cost = COST;
        this.price = PRICE;
        this.house = HOUSE;
        this.food = FOOD;
        this.weightOfFood = WEIGHT_OF_FOOD;
        this.name = NAME;
        this.ageInWeeks = AGE_IN_WEEKS;
    }

    @Override
    public void info() {
        System.out.println("");
        System.out.println(name);
        System.out.println("Koszt zakupu: " + cost + "PLN");
    }

    @Override
    public String toString() {
        return "Pszczoly";
    }

    @Override
    public void animalInfoDetailed(LocalDate today) {
        System.out.println("\t wiek roju: " + this.getAgeInWeeks(today) + " tygodni");
    }

    @Override
    public Integer getWeeksToMaturity(LocalDate today) {
        return null;
    }

    @Override
    public Double getWeight() {
        return null;
    }

    @Override
    public void gainingWeight(LocalDate today) {
    }

    @Override
    public void losingWeight() {
    }

    @Override
    public Boolean isAdult(LocalDate today) {
        return true;
    }

    @Override
    public String collect() {
        return "miod";
    }
}
