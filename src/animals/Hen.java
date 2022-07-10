package animals;

import building.Outbuilding;

import java.util.List;

public class Hen extends Animal implements Collectible, Feedable {

    private static final Double COST = 5.00;
    private static final Double WEIGHT_GAIN_PER_WEEK = 0.1;
    private static final Integer TIME_TO_MATURITY = 21;
    private static final Integer WEIGHT_OF_FOOD = 3;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;



    private String name;
    private Double cost;

    public Hen(){
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("KURA");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Kura zywi sie np pokrzywa, koniczyna, mniszkiem lekarskim, ziemniakami, marchewka");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Kura";
    }

    @Override
    public void collect() {
        System.out.println("Zbieram jajka");
    }

    @Override
    public void feed() {
        System.out.println("Karmie kury");
    }

}
