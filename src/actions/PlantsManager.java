package actions;

import crops.*;
import farmer.Farmer;

import java.util.Objects;
import java.util.Scanner;

public class PlantsManager {

    private final Farmer myFarmer;
    private Scanner scanner;
    private Action action;
    private TimeManager time;

    public PlantsManager(Farmer myFarmer, TimeManager time, Action action) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
        this.action = action;
        this.time = time;
    }

    public void buySeeds() {
        System.out.println("");
        System.out.println("W naszej ofercie mamy dostepne nastepujace produkty: ");
        System.out.println("1. Nasiona buraka");
        System.out.println("2. Nasiona marchewki");
        System.out.println("3. Nasiona salaty");
        System.out.println("4. Bulwy ziemniakow");
        System.out.println("5. Sadzonki jabloni");
        System.out.println("6. Ziarna pszenicy");
        System.out.println("0. Cofnij");

        String select = scanner.nextLine();

        if (Objects.equals(select, "1")) {
            System.out.println("");
            Beetroot beetroot = new Beetroot();
            beetroot.info();
            this.buySeeds(beetroot);
        } else if (Objects.equals(select, "2")) {
            System.out.println("");
            Carrot carrot = new Carrot();
            carrot.info();
            this.buySeeds(carrot);
        } else if (Objects.equals(select, "3")) {
            System.out.println("");
            Lettuce lettuce = new Lettuce();
            lettuce.info();
            this.buySeeds(lettuce);
        } else if (Objects.equals(select, "4")) {
            System.out.println("");
            Potato potato = new Potato();
            potato.info();
            this.buySeeds(potato);
        } else if (Objects.equals(select, "5")) {
            System.out.println("");
            AppleTree appleTree = new AppleTree();
            appleTree.info();
            this.buySeeds(appleTree);
        } else if (Objects.equals(select, "6")) {
            System.out.println("");
            Wheat wheat = new Wheat();
            wheat.info();
            this.buySeeds(wheat);
        } else if (Objects.equals(select, "0")) {
            System.out.println("");
        } else {
            System.out.println("Wybierz 1-6");
            this.buySeeds();
        }
    }

    public void buySeeds(Plant plant) {
        System.out.println("");
        System.out.println("Kupic za " + plant.getCost() + "PLN?");
        System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
        System.out.println("1.TAK");
        System.out.println("0.NIE");
        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            myFarmer.addPlant(plant);
        } else if (Objects.equals(select, "0")) {
            System.out.println("");
        } else {
            System.out.println("Zly wybor");
        }
    }
}

