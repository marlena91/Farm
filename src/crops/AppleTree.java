package crops;

public class AppleTree extends Plant {
    private static final Double COST_OF_PREPARATION_AND_PLANTING = 5400.00;
    private static final Double COST_OF_PROTECTION_AGAINST_PESTS = 4600.00;
    private static final Double COST_OF_HARVEST = 11500.00;
    private static final Double CROP_YELDS = 25.00;
    private static final Double PRICE_OF_A_KILOGRAM = 1.6;
    private static final Integer NUMBER_OF_WEEKS_TO_HARVEST = 100;
    private static final Integer SEEDING_START = 40;
    private static final Integer SEEDING_END = 45;
    private static final Double COST = 3300.00;

    private Double cost;

    public AppleTree() {
        this.cost = COST;
    }

    public void info() {
        System.out.println("");
        System.out.println("Koszt przygotowania ziemi i sadzenia: " + COST_OF_PREPARATION_AND_PLANTING + "PLN/ha");
        System.out.println("Koszt ochrony przed szkodnikami: " + COST_OF_PROTECTION_AGAINST_PESTS + "PLN/ha");
        System.out.println("Wydajnosc upraw: " + CROP_YELDS + "t/ha");
        System.out.println("Dlugosc okresu od posadzenia do zbiorow: " + NUMBER_OF_WEEKS_TO_HARVEST + " tygodni");
        System.out.println("Jabonie sadzi sie: pod od pazdziernika do listopada");
        System.out.println("Koszt zbioru: " + COST_OF_HARVEST + "PLN/ha");
        System.out.println("Cena skupu kilograma: " + PRICE_OF_A_KILOGRAM + "PLN");
    }

    @Override
    public Double getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return "Jablon";
    }
}
