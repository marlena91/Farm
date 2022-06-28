package building;

import equipment.Seeder;

import java.util.Objects;

public abstract class Outbuilding {

    protected Double value;

    public Outbuilding(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outbuilding that = (Outbuilding) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
