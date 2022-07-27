package crops;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Wheat extends Plant implements Seedable, Harvestable {

    private static final Double COST_OF_PREPARATION_AND_PLANTING = 1800.00;
    private static final Double COST_OF_PROTECTION_AGAINST_PESTS = 900.00;
    private static final Double COST_OF_HARVEST = 1000.00;
    private static final Double CROP_YIELDS = 7.00;
    private static final Double PRICE_OF_A_KILOGRAM = 0.68;
    private static final Integer NUMBER_OF_WEEKS_TO_HARVEST = 21;
    private static final Integer SEEDING_START = 12;
    private static final Integer SEEDING_END = 14;
    private static final Double COST = 400.00;
    private static final String SEEDING_TIME = "pod koniec marca lub na poczatku kwietnia";


    private Double cost;
    private LocalDate dateOfSeed;

    private Double currentAmount;


    public Wheat() {
        this.cost = COST;
    }

    public void info() {
        System.out.println("");
        System.out.println("Koszt przygotowania ziemi i sadzenia: " + COST_OF_PREPARATION_AND_PLANTING + "PLN/ha");
        System.out.println("Koszt ochrony przed szkodnikami: " + COST_OF_PROTECTION_AGAINST_PESTS + "PLN/ha");
        System.out.println("Wydajnosc upraw: " + CROP_YIELDS + "t/ha");
        System.out.println("Dlugosc okresu od posadzenia do zbiorow: " + NUMBER_OF_WEEKS_TO_HARVEST + " tygodni");
        System.out.println("Pszenice sadzi sie: " + SEEDING_TIME);
        System.out.println("Koszt zbioru: " + COST_OF_HARVEST + "PLN/ha");
        System.out.println("Cena skupu kilograma: " + PRICE_OF_A_KILOGRAM + "PLN");
    }

    @Override
    public Double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return "Pszenica";
    }

    @Override
    public Double costOfPlanting() {
        return COST_OF_PREPARATION_AND_PLANTING + COST_OF_PROTECTION_AGAINST_PESTS;
    }
    @Override
    public Double getCostOfHarvest() {
        return COST_OF_HARVEST;
    }

    @Override
    public Integer getSeedingStart() {
        return SEEDING_START;
    }

    @Override
    public Integer getSeedingEnd() {
        return SEEDING_END;
    }

    @Override
    public String getSeedingPeriod() {
        return SEEDING_TIME;
    }

    @Override
    public Integer getNumberOfWeekToHarvest() {
        return NUMBER_OF_WEEKS_TO_HARVEST;
    }

    @Override
    public long howManyWeeksAfterPlanting(LocalDate today) {
        return this.dateOfSeed.until(today, ChronoUnit.WEEKS);
    }

    public LocalDate getDateOfSeed() {
        return dateOfSeed;
    }

    public void setDateOfSeed(LocalDate dateOfSeed) {
        this.dateOfSeed = dateOfSeed;
    }

    @Override
    public void setCurrentAmount(Double amount) {
        this.currentAmount = amount;
    }

    @Override
    public Double getCurrentAmount() {
        return currentAmount;
    }

    @Override
    public Double getPricePerKilo() {
        return PRICE_OF_A_KILOGRAM;
    }

    @Override
    public Double getCropYields() {
        return CROP_YIELDS;
    }

    public String getStatus(LocalDate today) {
        long weeks = this.dateOfSeed.until(today, ChronoUnit.WEEKS);

        if (weeks >= NUMBER_OF_WEEKS_TO_HARVEST) {
            return "GOTOWE DO ZBIORU";
        } else {
            return "ROŚNIE";
        }
    }

}
