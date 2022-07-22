package crops;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Potato extends Plant implements Seedable {

    private static final Double COST_OF_PREPARATION_AND_PLANTING = 2600.00;
    private static final Double COST_OF_PROTECTION_AGAINST_PESTS = 800.00;
    private static final Double COST_OF_HARVEST = 2300.00;
    private static final Double CROP_YIELDS = 25.00;
    private static final Double PRICE_OF_A_KILOGRAM = 0.53;
    private static final Integer NUMBER_OF_WEEKS_TO_HARVEST = 22;
    private static final Integer SEEDING_START = 12;
    private static final Integer SEEDING_END = 14;
    private static final Double COST = 1800.00;

    private static final String SEEDING_TIME = "pod koniec marca lub na poczatku kwietnia";

    private Double cost;
    private LocalDate dateOfSeed;

    public Potato() {
        this.cost = COST;
    }

    public void info() {
        System.out.println("");
        System.out.println("Koszt przygotowania ziemi i sadzenia: " + COST_OF_PREPARATION_AND_PLANTING + "PLN/ha");
        System.out.println("Koszt ochrony przed szkodnikami: " + COST_OF_PROTECTION_AGAINST_PESTS + "PLN/ha");
        System.out.println("Wydajnosc upraw: " + CROP_YIELDS + "t/ha");
        System.out.println("Dlugosc okresu od posadzenia do zbiorow: " + NUMBER_OF_WEEKS_TO_HARVEST + " tygodni");
        System.out.println("Bulwy ziemniakow sadzi sie: "+SEEDING_TIME);
        System.out.println("Koszt zbioru: " + COST_OF_HARVEST + "PLN/ha");
        System.out.println("Cena skupu kilograma: " + PRICE_OF_A_KILOGRAM + "PLN");
    }

    @Override
    public Double getCost() {
        return this.cost;
    }

    public Integer getSeedingStart(){
        return SEEDING_START;
    }

    public Integer getSeedingEnd(){
        return SEEDING_END;
    }

    @Override
    public String getSeedingPeriod() {
        return SEEDING_TIME;
    }

    @Override
    public String toString() {
        return "Ziemniak";
    }

    @Override
    public Double costOfPlanting() {
        return COST_OF_PREPARATION_AND_PLANTING+COST_OF_PROTECTION_AGAINST_PESTS;
    }

    public LocalDate getDateOfSeed() {
        return dateOfSeed;
    }

    public void setDateOfSeed(LocalDate dateOfSeed) {
        this.dateOfSeed = dateOfSeed;
    }

    public String getStatus(LocalDate today){
        long weeks = this.dateOfSeed.until(today, ChronoUnit.WEEKS);

        if(weeks >= NUMBER_OF_WEEKS_TO_HARVEST){
            return "GOTOWE DO ZBIORU";
        }
        else{
            return "ROŚNIE";
        }
    }
}
