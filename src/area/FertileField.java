package area;

import area.interfaces.Field;

public class FertileField implements Field {

    private static final Integer AREA = 1;

    private final Integer area;
    private Integer freeArea;

    public FertileField(){
        this.area = AREA;
        this.freeArea = this.area;
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

    @Override
    public void giveFreeArea() {
        this.freeArea += 1;
    }

    @Override
    public String toString() {
        return "\n\t~ Pole uprawne 1ha";
    }
}
