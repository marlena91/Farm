package animals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hen extends Animal {

    private static final Double COST = 5.00;
    private static final Double PRICE = 1.00;
    private static final String HOUSE = "Henhouse";
    private static final String FOOD = "Potato";
    private static final String NAME = "Kura";
    private static final String EDIBLES = "Kura zywi sie np pokrzywa, koniczyna, mniszkiem lekarskim, ziemniakami, marchewka";

    private static final Double WEIGHT_GAIN_PER_WEEK = 0.1;
    private static final Integer TIME_TO_MATURITY = 21;
    private static final Double WEIGHT_OF_FOOD = 3.00;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;
    private static final Integer AGE_IN_WEEKS = 2;

    public Hen(){
        setAll();
        this.setWeight(AGE_IN_WEEKS*WEIGHT_GAIN_PER_WEEK);
    }

    public Hen(LocalDate date){
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
        return "jajka, ";
    }
}
