package crops;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lettuce extends Plant implements Seedable{

    private static final Double COST_OF_PREPARATION_AND_PLANTING = 5000.00;
    private static final Double COST_OF_PROTECTION_AGAINST_PESTS = 1200.00;
    private static final Double COST_OF_HARVEST = 13300.00;
    private static final Double CROP_YIELDS = 85.00;
    private static final Double PRICE_OF_A_KILOGRAM = 0.7;
    private static final Integer NUMBER_OF_WEEKS_TO_HARVEST = 6;
    private static final Integer SEEDING_START = 11;
    private static final Integer SEEDING_END = 31;
    private static final Double COST = 5900.00;
    private static final String SEEDING_TIME = "od polowy marca do poczatku sierpnia";

    private Double cost;
    private LocalDate dateOfSeed;

    public Lettuce(){
        this.cost = COST;
    }

    public void info(){
        System.out.println("");
        System.out.println("Koszt przygotowania ziemi i sadzenia: " + COST_OF_PREPARATION_AND_PLANTING+ "PLN/ha");
        System.out.println("Koszt ochrony przed szkodnikami: " + COST_OF_PROTECTION_AGAINST_PESTS+"PLN/ha");
        System.out.println("Wydajnosc upraw: "+ CROP_YIELDS + "t/ha");
        System.out.println("Dlugosc okresu od posadzenia do zbiorow: "+ NUMBER_OF_WEEKS_TO_HARVEST+ " tygodni");
        System.out.println("Nasiona salaty wysiewa sie: " + SEEDING_TIME);
        System.out.println("Koszt zbioru: "+ COST_OF_HARVEST+ "PLN/ha");
        System.out.println("Cena skupu kilograma: "+PRICE_OF_A_KILOGRAM+"PLN");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Salata";
    }

    @Override
    public Double costOfPlanting() {
        return COST_OF_PREPARATION_AND_PLANTING+COST_OF_PROTECTION_AGAINST_PESTS;
    }

    @Override
    public Integer getSeedingStart(){
        return SEEDING_START;
    }


    @Override
    public Integer getSeedingEnd(){
        return SEEDING_END;
    }
    @Override
    public String getSeedingPeriod() {
        return SEEDING_TIME;
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
