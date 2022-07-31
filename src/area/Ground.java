package area;

import area.interfaces.Field;

public class Ground implements Field {

    private Integer area;
    private Integer freeArea;

    private Integer numberOfBuildings;
    private Double value;

    private static final Double COST_OF_ONE_HECTARE = 400000.00;

    public Ground(Integer area, Integer numberOfBuildings) {
        this.area = area;
        this.freeArea = this.area;
        this.value = area * COST_OF_ONE_HECTARE;
        this.numberOfBuildings = numberOfBuildings;
    }

    public Integer getArea() {
        return area;
    }

    public Integer getFreeArea() {
        return freeArea;
    }

    @Override
    public void subtractFreeArea() {
        this.freeArea -= 1;
    }

    public Double getValue() { return value;}

    public Integer getNumberOfBuildings(){
        return numberOfBuildings;
    }
    public void subtractNumberOfBuilding(){
        this.numberOfBuildings -= 1;
    }

    @Override
    public String toString() {
        return "\t~Pole: " +
                "powierzchnia: " + area + "ha, maksymalna liczba budynkow: " + numberOfBuildings +", wartosc: "+value + ", freearea: "+getFreeArea();
    }

    @Override
    public void giveFreeArea() {
        this.freeArea += 1;
    }

}
