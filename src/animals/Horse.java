package animals;

public class Horse extends Animal implements Salable{

    private static final Double COST = 8500.00;
    private static final Double PRICE = 7000.00;
    private static final String HOUSE = "Stable";

    private static final Double WEIGHT_GAIN_PER_WEEK = 16.00;
    private static final Integer TIME_TO_MATURITY = 25;
    private static final Integer WEIGHT_OF_FOOD = 56;
    private static final Integer CHANCE_OF_REPRODUCTION = 5;

    private String name;
    private Double cost;

    public Horse(){
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("KON");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Kon zywi sie np sianem, zbozem, jablkami, burakami");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Kon";
    }

    @Override
    public String getHouse() {
        return HOUSE;
    }

    @Override
    public Double getPrice() {
        return PRICE;
    }
}
