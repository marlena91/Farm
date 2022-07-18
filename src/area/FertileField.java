package area;

public class FertileField implements Field{

    private static final Integer AREA = 1;

    private Integer area;
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
        this.freeArea -= area;
    }

    @Override
    public String toString() {
        return "FertileField, freearea: "+ getFreeArea();
    }
}
