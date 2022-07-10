package animals;

public class Pig extends Animal implements Feedable {

    private static final Double COST = 1500.00;

    private String name;
    private Double cost;

    public Pig() {
        this.cost = COST;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void info() {
//
    }

    public Double getCost(){
        return this.cost;
    }

    @Override
    public void feed() {
        System.out.println("Karmie świnie");
    }

    @Override
    public String toString() {
        return "Świnia: " +
                name+ ".";
    }
}
