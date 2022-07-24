package area;

import actions.Action;
import actions.TimeManager;
import farmer.Farmer;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FieldsManager {

    private final Farmer myFarmer;
    private Scanner scanner;
    private Action action;
    private Time time;
    private List<Ground> randomFarms;


    public FieldsManager(Farmer myFarmer, TimeManager time, Action action) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
        this.action = action;
    }

    public void generateRandomFarms() {
        this.randomFarms = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            randomFarms.add(new RandomFarm().generateRandomFarm());
        }
    }

    public List<Ground> getRandomFarms() {
        return randomFarms;
    }

    public void buyFarm() {
        System.out.println("");
        System.out.println("Wybierz nr farmy do zakupu. Jesli chcesz zrezygnowac wcisnij '0'");
        System.out.println("Twoja dostepna gotowka: " + myFarmer.getCash() + " PLN");

        String farmNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (Objects.equals(farmNumber, "0") || !pattern.matcher(farmNumber).matches()) {
            this.action.mainChoices();
        } else {
            int farmIntNumber = Integer.parseInt(farmNumber);
            this.checkingChosenFarm(farmIntNumber);
        }
    }

    public void checkingChosenFarm(Integer farmIntNumber) {
        if (!checkFarmNumberForSell(farmIntNumber)) {
            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
            this.buyFarm();
        } else {
            Ground chosenFarm = this.getSingleFarm(farmIntNumber - 1);
            this.finalPurchaseFarm(chosenFarm);
        }
    }

    public void finalPurchaseFarm(Ground chosenFarm) {
        if (myFarmer.getCash() <= chosenFarm.getValue()) {
            System.out.println("Za mało pieniędzy na zakup tej działki");
        } else {
            myFarmer.addFarm(chosenFarm);
            this.randomFarms.remove(chosenFarm);
            myFarmer.subtractCash(chosenFarm.getValue());
            System.out.println("Pomyślnie zakupiono ziemię.");
        }
    }

    public Boolean checkFarmNumberForSell(Integer farmNumber) {
        return farmNumber <= this.randomFarms.size();
    }


    public Ground getSingleFarm(Integer nr) {
        return this.randomFarms.get(nr);
    }


    public Integer getFarmArea() {
        Integer totalFarmArea = 0;
        for (Ground field : myFarmer.getFarms()) {
            totalFarmArea += field.getArea();
        }
        return totalFarmArea;
    }

    public void buyAdditionalFertileField() {
        System.out.println("");
        System.out.println("1. Tak, chce dokupic 1ha pola za 600tys");
        if (this.myFarmer.getAdditionalArea().size() >= 1) {
            System.out.println("2. Chce sprzedac moje pola uprawne");
        }
        System.out.println("0. Nie, dziekuje. Wroc do menu glownego");
        String select = scanner.nextLine();

        if (Objects.equals(select, "1")) {
            this.finalPurchaseAddField();
        } else if (this.myFarmer.getAdditionalArea().size() >= 1 & Objects.equals(select, "2")) {
            this.finallyBuyOrNo();
        } else if (Objects.equals(select, "0")) {
            this.action.mainChoices();
        } else {
            System.out.println("Zly wybor");
            this.buyAdditionalFertileField();
        }
        this.action.next();
        this.action.mainChoices();
    }

    public void finallyBuyOrNo() {
        System.out.println("Sprzedasz 1ha swojej dodatkowej ziemi uprawnej, stracisz uprawy, jeśli jakies na niej są");
        System.out.println("Na 1ha zarobisz 400tys");
        System.out.println("1.TAK");
        System.out.println("0.NIE");
        String select2 = scanner.nextLine();
        if (Objects.equals(select2, "1")) {
            this.myFarmer.subtractAdditionalFertileField();
        } else if (Objects.equals(select2, "0")) {
            this.buyAdditionalFertileField();
        } else {
            System.out.println("Zly wybor");
            this.finallyBuyOrNo();
        }
    }

    public void finalPurchaseAddField() {
        if (this.myFarmer.getCash() >= 600000.00) {
            this.myFarmer.addField(new FertileField());
            this.myFarmer.subtractCash(600000.00);
            System.out.println("Pomyslnie zakupiono ziemie");
        } else {
            System.out.println("Za malo pieniedzy na zakup tej ziemi ");
        }
    }

    public Integer checkingIsFreeArea() {
        Integer freeArea = 0;
        for (Field field : myFarmer.getFields()) {
            freeArea += field.getFreeArea();
        }
        return freeArea;
    }

}
