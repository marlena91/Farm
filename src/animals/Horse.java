package animals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Horse extends Animal{

    private static final Double COST = 8500.00;
    private static final Double PRICE = 7000.00;
    private static final String HOUSE = "Stable";
    private static final String FOOD = "Apple";
    private static final String NAME = "Kon";
    private static final String EDIBLES = "Kon zywi sie np sianem, zbozem, jablkami, burakami";

    private static final Double WEIGHT_GAIN_PER_WEEK = 16.00;
    private static final Integer TIME_TO_MATURITY = 15;
    private static final Double WEIGHT_OF_FOOD = 56.00;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 5;

    public Horse(){
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }

    public Horse(LocalDate date){
        this.dateOfBuy = date;
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }

    private void setAll(){
        this.cost = COST;
        this.price = PRICE;
        this.house = HOUSE;
        this.food = FOOD;
        this.weightGainPerWeek = WEIGHT_GAIN_PER_WEEK;
        this.timeToMaturity = TIME_TO_MATURITY;
        this.weightOfFood = WEIGHT_OF_FOOD;
        this.chanceOfReproduction = CHANCE_OF_REPRODUCTION;
        this.name = NAME;
        this.edibles = EDIBLES;
        this.ageInWeeks = AGE_IN_WEEKS;
    }

    @Override
    public String collect() {
        return "";
    }
}
