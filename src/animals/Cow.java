package animals;

public class Cow extends Animal implements Collectible, Feedable {

    private static final Double COST = 1500.00;
    private static final Double PRICE = 800.00;
    private static final Double WEIGHT_GAIN_PER_WEEK = 5.5;
    private static final Integer TIME_TO_MATURITY = 84;
    private static final Integer WEIGHT_OF_FOOD = 140;
    private static final Integer CHANCE_OF_REPRODUCTION = 5;

    private String name;
    private Double cost;

    public Cow() {
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("KROWA");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Krowa zywi sie np sruta zbozowa, sianem, burakami, kiszonka traw");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }


    @Override
    public void collect() {
        System.out.println("Doję krowy");
    }

    @Override
    public void feed() {
        System.out.println("Karmię krowy");
    }

    @Override
    public String toString() {
        return "Krowa";
    }
}
