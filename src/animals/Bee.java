package animals;

public class Bee extends Animal implements Collectible{

    private static final Double COST = 300.00;

    private String name;
    private Double cost;

    public Bee(){
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    public void info() {
        System.out.println("");
        System.out.println("PSZCZOLY");
        System.out.println("Koszt zakupu: " + COST + "PLN");
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Pszczoly";
    }

    @Override
    public void collect() {
        System.out.println("Zbieram miód");
    }


}
