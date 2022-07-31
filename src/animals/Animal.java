package animals;

import animals.interfaces.Collectible;
import animals.interfaces.Salable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Animal implements Salable, Collectible {

    protected Double cost;
    protected Double price;
    protected Double weight;
    protected Double weightGainPerWeek;
    protected Double weightOfFood;

    protected Integer timeToMaturity;
    protected Integer chanceOfReproduction;
    protected Integer ageInWeeks;

    protected String house;
    protected String food;
    protected String name;
    protected String edibles;

    protected LocalDate dateOfBuy;

    public Double getCost(){
        return cost;
    }

    public void setWeight(Double weight){
        this.weight = weight;
    }

    public String getHouse() {
        return house;
    }

    public Double getPrice() {
        return price;
    }

    public String getTypeOfFood() {
        return food;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void animalInfoDetailed(LocalDate today) {
        System.out.println("\t wiek: "+ this.getAgeInWeeks(today)+ " tygodni" );
        if(getWeeksToMaturity(today)>=0){
            System.out.println("\t do osiagniecia dojrzalosci pozostalo: "+ this.getWeeksToMaturity(today)+" tygodni");
        } else {
            System.out.println("\t dorosle zwierze gotowe do rozmnazania");
        }
        System.out.println("\t zjada "+ weightOfFood+"kg na tydzien");
        System.out.println("\t aktualna waga: "+ getWeight() +"kg");
    }

    public void info() {
        System.out.println("");
        System.out.println(name);
        System.out.println("Koszt zakupu: " + cost + "PLN");
        System.out.println("Tempo przybierania na wadze: " + weightGainPerWeek + "kg/tydzien");
        System.out.println("Czas wzrostu do dojrzalosci: " + timeToMaturity + " tygodni");
        System.out.println("Ilosc jedzenia na tydzien: " + weightOfFood + "kg");
        System.out.println(edibles);
        System.out.println("Szanse na rozmnozenie: "+chanceOfReproduction+"%");
    }

    public long howManyWeeksAfterBuying(LocalDate today) {
        return this.dateOfBuy.until(today, ChronoUnit.WEEKS);
    }

    public Integer getAgeInWeeks(LocalDate today) {
        return Math.toIntExact(ageInWeeks + howManyWeeksAfterBuying(today));
    }

    public void setDateOfBuy(LocalDate date) {
        this.dateOfBuy = date;
    }

    public Integer getWeeksToMaturity(LocalDate today) {
        return Math.toIntExact(timeToMaturity - howManyWeeksAfterBuying(today));
    }

    public String toString() {
        return name;
    }

    public Double getKilosOfFood() {
        return weightOfFood;
    }

    public void gainingWeight(LocalDate today) {
        boolean maxWeight = this.weight >= getAgeInWeeks(today)*weightGainPerWeek;
        if(!maxWeight){
            this.weight += weightGainPerWeek;
        }
    }

    public void losingWeight() {
        this.weight -= weightGainPerWeek;
    }

    public Boolean isAdult(LocalDate today) {
        return getAgeInWeeks(today)>=timeToMaturity;
    }

    public abstract String collect();

}
