package animals;

import java.time.LocalDate;

public abstract class Animal {

    public abstract Double getCost();

    public abstract void info();

    public abstract void animalInfoDetailed(LocalDate today);

    public abstract long howManyWeeksAfterBuying(LocalDate today);

    public abstract Integer getAgeInWeeks(LocalDate today);

    public abstract void setDateOfBuy(LocalDate date);

    public abstract Integer getWeeksToMaturity(LocalDate date);

    public abstract Double getWeight();
    public abstract void addWeight(Double weight);
    public abstract void subtractWeight(Double weight);
}
