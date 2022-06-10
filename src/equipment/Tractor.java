package equipment;

public class Tractor {

    static final Double DEFAULT_VALUE_FOR_SALE = 30000.00;
    private String producer;
    private String model;
    private Integer yearOfProduction;
    private Double engineCapacity;
    private Integer enginePower;
    private Double value;

    public Tractor(String producer, String model, Integer yearOfProduction, Double engineCapacity,Integer enginePower){
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.value = DEFAULT_VALUE_FOR_SALE;
    }

    @Override
    public String toString() {
        return "\n" + producer + " " + model + ", " +
                ", rok produkcji: " + yearOfProduction +
                ", pojemność silnika: " + engineCapacity + "l" +
                ", moc silnika: " + enginePower + "KM"
                ;
    }
}
