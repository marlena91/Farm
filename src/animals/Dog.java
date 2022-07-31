package animals;

import animals.interfaces.Salable;

import java.time.LocalDate;

public class Dog extends Animal {

    private static final Double COST = 6500.00;
    private static final Double PRICE = 5000.00;
    private static final String HOUSE = "Doghouse";
    private static final String FOOD = "";
    private static final String FOOD_PL = "Specjalistyczna karma dla psow";

    private static final String NAME = "Pies";
    private static final String EDIBLES = "Pies zywi sie np specjalistyczna karma, miesem, zbozem, jajkami, nabialem czy rosolem";

    private static final Double WEIGHT_GAIN_PER_WEEK = 1.60;
    private static final Integer TIME_TO_MATURITY = 19;
    private static final Double WEIGHT_OF_FOOD = 10.00;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 12;

    public Dog(){
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }

    public Dog(LocalDate date){
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
        this.foodPl = FOOD_PL;
    }

    @Override
    public String collect() {
        return "";
    }
}
