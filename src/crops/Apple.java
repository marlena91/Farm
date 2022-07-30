package crops;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Apple extends Plant implements Seedable, Harvestable {
    private static final Double COST_OF_PREPARATION_AND_PLANTING = 5400.00;
    private static final Double COST_OF_PROTECTION_AGAINST_PESTS = 4600.00;
    private static final Double COST_OF_HARVEST = 11500.00;
    private static final Double CROP_YIELDS = 25.00;
    private static final Double PRICE_OF_A_KILOGRAM = 1.6;
    private static final Integer NUMBER_OF_WEEKS_TO_HARVEST = 100;
    private static final Integer SEEDING_START = 40;
    private static final Integer SEEDING_END = 45;
    private static final Double COST = 3300.00;
    private static final String SEEDING_TIME = "od pazdziernika do listopada";


    private Double cost;
    private Double currentAmount;
    private LocalDate dateOfSeed;

    public Apple() {
        this.cost = COST;
        this.currentAmount = 0.00;
    }

    public void info() {
        System.out.println("");
        System.out.println("Koszt przygotowania ziemi i sadzenia: " + COST_OF_PREPARATION_AND_PLANTING + "PLN/ha");
        System.out.println("Koszt ochrony przed szkodnikami: " + COST_OF_PROTECTION_AGAINST_PESTS + "PLN/ha");
        System.out.println("Wydajnosc upraw: " + CROP_YIELDS + "t/ha");
        System.out.println("Dlugosc okresu od posadzenia do zbiorow: " + NUMBER_OF_WEEKS_TO_HARVEST + " tygodni");
        System.out.println("Jablonie sadzi sie: " + SEEDING_TIME);
        System.out.println("Koszt zbioru: " + COST_OF_HARVEST + "PLN/ha");
        System.out.println("Cena skupu kilograma: " + PRICE_OF_A_KILOGRAM + "PLN");
    }

    @Override
    public Double getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return "Jablon";
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
    public Double getCropYields() {
        return CROP_YIELDS;
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
    public LocalDate getDateOfSeed() {
        return dateOfSeed;
    }


    @Override
    public Integer getNumberOfWeekToHarvest() {
        return NUMBER_OF_WEEKS_TO_HARVEST;
    }

    @Override
    public long howManyWeeksAfterPlanting(LocalDate today) {
        return this.dateOfSeed.until(today, ChronoUnit.WEEKS);
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
    public void removingKilos(Double amount) {
        double newAmount = this.currentAmount - amount;
        this.setCurrentAmount(newAmount);
    }

    public String getStatus(LocalDate today) {
        long weeks = this.dateOfSeed.until(today, ChronoUnit.WEEKS);

        if (weeks >= NUMBER_OF_WEEKS_TO_HARVEST) {
            return "GOTOWE DO ZBIORU";
        }
        {
            return "ROŚNIE";
        }
    }
}
