package building;

import crops.interfaces.Seedable;

import java.util.List;

public class Barn extends Outbuilding{

    private List<Seedable> plants;

    public Barn(Double value) {
        super(value);
    }
    @Override
    public String toString() {
        return "\t~Stodola,\n";
    }

}
