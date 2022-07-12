package animals;

import java.util.Objects;

public class Sheep extends Animal implements Collectible, Feedable {

    private static final Double COST = 250.00;
    private static final Double PRICE = 200.00;
    private static final Double WEIGHT_GAIN_PER_WEEK = 1.50;
    private static final Integer TIME_TO_MATURITY = 4;
    private static final Integer WEIGHT_OF_FOOD = 28;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;

    private String name;
    private Double cost;

    public Sheep(){
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("OWCA");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Owca zywi sie np sianem, zbozem, marchewka, burakami");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Owca";
    }

    @Override
    public void collect() {
        System.out.println("Owce zostały obstrzyżone");
    }

    @Override
    public void feed() {
        System.out.println("Karmię owce");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheep)) return false;
        Sheep sheep = (Sheep) o;
        return Objects.equals(name, sheep.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
