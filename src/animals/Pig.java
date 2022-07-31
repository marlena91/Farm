package animals;

import java.time.LocalDate;

public class Pig extends Animal{

    private static final Double COST = 800.00;
    private static final Double PRICE = 700.00;
    private static final String HOUSE = "Pighouse";
    private static final String FOOD = "Beetroot";
    private static final String NAME = "Swinia";
    private static final String EDIBLES = "Swinia zywi sie np sianem, zbozem, jablkami, burakami";

    private static final Double WEIGHT_GAIN_PER_WEEK = 2.00;
    private static final Integer TIME_TO_MATURITY = 8;
    private static final Double WEIGHT_OF_FOOD = 28.00;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 5;

    public Pig() {
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }
    public Pig(LocalDate date){
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
}
