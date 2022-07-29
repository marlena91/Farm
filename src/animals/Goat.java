package animals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Goat extends Animal implements Salable {

    private static final Double COST = 150.00;
    private static final Double PRICE = 100.00;
    private static final String HOUSE = "Farm";
    private static final String FOOD = "Carrot";


    private static final Double WEIGHT_GAIN_PER_WEEK = 0.5;
    private static final Integer TIME_TO_MATURITY = 15;
    private static final Integer WEIGHT_OF_FOOD = 12;
    private static final Integer CHANCE_OF_REPRODUCTION = 5;

    private static final Integer AGE_IN_WEEKS = 5;
    private LocalDate dateOfBuy;

    private String name;
    private Double cost;
    private Double weight;

    public Goat() {
        this.cost = COST;
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("KOZA");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Koza zywi sie np sianem, jablkami, marchewka, burakami");
        System.out.println("Szanse na rozmnozenie: " + CHANCE_OF_REPRODUCTION + "%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Koza";
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
        System.out.println("\t wiek: " + this.getAgeInWeeks(today) + " tygodni");
        if (getWeeksToMaturity(today) >= 0) {
            System.out.println("\t do osiagniecia dojrzalosci pozostalo: " + this.getWeeksToMaturity(today) + " tygodni");
        } else {
            System.out.println("\t dorosle zwierze gotowe do rozmnazania");
        }
        System.out.println("\t zjada " + WEIGHT_OF_FOOD + "kg na tydzien, z zapasow glownie marchew");
        System.out.println("\t aktualna waga: " + getWeight() + "kg");
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
        return Math.toIntExact(TIME_TO_MATURITY - howManyWeeksAfterBuying(today));
    }

    @Override
    public Double getWeight() {
        return this.weight;
    }

    @Override
    public void addWeight(Double weight) {
        this.weight += weight;
    }

    @Override
    public void subtractWeight(Double weight) {
        this.weight -= weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    @Override
    public String getTypeOfFood() {
        return FOOD;
    }
}
