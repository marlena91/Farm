package animals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Sheep extends Animal implements Collectible, Feedable, Salable {

    private static final Double COST = 250.00;
    private static final Double PRICE = 200.00;
    private static final String HOUSE = "Farm";
    private static final String FOOD = "Carrot";

    private static final Double WEIGHT_GAIN_PER_WEEK = 1.50;
    private static final Integer TIME_TO_MATURITY = 10;
    private static final Integer WEIGHT_OF_FOOD = 28;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 5;
    private LocalDate dateOfBuy;
    private String name;
    private Double cost;
    private Double weight;

    public Sheep(){
        this.cost = COST;
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("OWCA");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Owca zywi sie np sianem, zbozem, marchewka, burakami");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Owca";
    }

    @Override
    public void collect() {
        System.out.println("Owce zostały obstrzyżone");
    }

    @Override
    public void feed() {
        System.out.println("Karmię owce");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheep)) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(name, sheep.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
        System.out.println("\t wiek: "+ this.getAgeInWeeks(today)+ " tygodni" );
        if(getWeeksToMaturity(today)>=0){
            System.out.println("\t do osiagniecia dojrzalosci pozostalo: "+ this.getWeeksToMaturity(today)+" tygodni");
        } else {
            System.out.println("\t dorosle zwierze gotowe do rozmnazania");
        }
        System.out.println("\t zjada "+ WEIGHT_OF_FOOD+"kg na tydzien, z zapasow glownie marchew");
        System.out.println("\t aktualna waga: "+ getWeight() +"kg");
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

    public void setWeight(Double weight){
        this.weight = weight;
    }

    @Override
    public String getTypeOfFood() {
        return FOOD;
    }
}
