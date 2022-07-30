package animals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bee extends Animal implements Collectible, Salable {

    private static final Double COST = 300.00;
    private static final Double PRICE = 300.00;
    private static final Double WEIGHT_OF_FOOD = 0.00;


    private static final String HOUSE = "BeeYard";
    private static final String FOOD = "";

    private static final Integer AGE_IN_WEEKS = 5;
    private LocalDate dateOfBuy;
    private String name;
    private Double cost;

    public Bee() {
        this.cost = COST;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("PSZCZOLY");
        System.out.println("Koszt zakupu: " + COST + "PLN");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Pszczoly";
    }

    @Override
    public void collect() {
        System.out.println("Zbieram miód");
    }

    @Override
    public String getHouse() {
        return HOUSE;
    }

    @Override
    public Double getPrice() {
        return PRICE;
    }

    @Override
    public void animalInfoDetailed(LocalDate today) {
        System.out.println("\t wiek roju: " + this.getAgeInWeeks(today) + " tygodni");
    }

    @Override
    public long howManyWeeksAfterBuying(LocalDate today) {
        return this.dateOfBuy.until(today, ChronoUnit.WEEKS);
    }

    @Override
    public Integer getAgeInWeeks(LocalDate today) {
        return Math.toIntExact(AGE_IN_WEEKS + howManyWeeksAfterBuying(today));
    }

    @Override
    public void setDateOfBuy(LocalDate date) {
        this.dateOfBuy = date;
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
    public void addWeight(Double weight) {

    }

    @Override
    public void subtractWeight(Double weight) {

    }

    @Override
    public String getTypeOfFood() {
        return FOOD;
    }

    @Override
    public Double getKilosOfFood() {
        return WEIGHT_OF_FOOD;
    }

    @Override
    public void gainingWeight(LocalDate today) {
//
    }

    @Override
    public void losingWeight() {
        //
    }
}
