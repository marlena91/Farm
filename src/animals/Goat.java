package animals;

import java.time.LocalDate;

public class Goat extends Animal {

    private static final Double COST = 150.00;
    private static final Double PRICE = 100.00;
    private static final String HOUSE = "Farm";
    private static final String FOOD = "Carrot";
    private static final String NAME = "Koza";
    private static final String EDIBLES = "Koza zywi sie np sianem, jablkami, marchewka, burakami";

    private static final Double WEIGHT_GAIN_PER_WEEK = 0.5;
    private static final Integer TIME_TO_MATURITY = 15;
    private static final Double WEIGHT_OF_FOOD = 12.00;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 5;

    public Goat() {
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);

    }
    public Goat(LocalDate date){
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
        return "mleko, ";
    }
}
