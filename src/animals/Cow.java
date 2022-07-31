package animals;

import animals.interfaces.Collectible;

import java.time.LocalDate;

public class Cow extends Animal{

    private static final Double COST = 1500.00;
    private static final Double PRICE = 800.00;
    private static final String HOUSE = "Cowshed";
    private static final String FOOD = "Beetroot";
    private static final String FOOD_PL = "Buraki";
    private static final String NAME = "Krowa";
    private static final String EDIBLES = "Krowa zywi sie np sruta zbozowa, sianem, burakami, kiszonka traw";

    private static final Double WEIGHT_GAIN_PER_WEEK = 5.5;
    private static final Integer TIME_TO_MATURITY = 20;
    private static final Double WEIGHT_OF_FOOD = 140.00;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 5;

    public Cow() {
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }

    public Cow(LocalDate date){
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
        return "mleko";
    }


}
