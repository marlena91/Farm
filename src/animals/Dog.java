package animals;

public class Dog extends Animal implements Salable{

    private static final Double COST = 6500.00;
    private static final Double PRICE = 5000.00;
    private static final String HOUSE = "Doghouse";

    private static final Double WEIGHT_GAIN_PER_WEEK = 1.60;
    private static final Integer TIME_TO_MATURITY = 32;
    private static final Integer WEIGHT_OF_FOOD = 10;
    private static final Integer CHANCE_OF_REPRODUCTION = 10;

    private String name;
    private Double cost;

    public Dog(){
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("PIES");
        System.out.println("Koszt zakupu: " + COST + "PLN");
        System.out.println("Tempo przybierania na wadze: " + WEIGHT_GAIN_PER_WEEK + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + TIME_TO_MATURITY + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + WEIGHT_OF_FOOD + "kg");
        System.out.println("Pies zywi sie np specjalistyczna karma, miesem, zbozem, jajkami, nabialem czy rosolem");
        System.out.println("Szanse na rozmnozenie: "+CHANCE_OF_REPRODUCTION+"%");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Pies";
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
