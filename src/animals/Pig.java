package animals;

public class Pig extends Animal implements Feedable {

    private static final Double COST = 8500.00;
    private static final Double WEIGHT_GAIN_PER_WEEK = 16.00;
    private static final Integer TIME_TO_MATURITY = 25;
    private static final Integer WEIGHT_OF_FOOD = 8;
    private static final Integer CHANCE_OF_REPRODUCTION = 5;

    private String name;
    private Double cost;

    public Pig(){
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("SWINIA");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Swinia zywi sie np sianem, zbozem, jablkami, burakami");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Swinia";
    }

    @Override
    public void feed() {
        System.out.println("Karmie świnie");
    }

}
