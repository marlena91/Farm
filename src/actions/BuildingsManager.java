package actions;

import area.FertileField;
import area.FloodedField;
import area.Forest;
import building.*;
import farmer.Farmer;

import java.util.Scanner;

public class BuildingsManager {

    private final Farmer myFarmer;
    private Scanner scanner;


    public BuildingsManager(Farmer myFarmer) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Budynki w Twoim gospodarstwie");
        System.out.println(myFarmer.getBuild());
        Action.myBuildings();
        int buildingActionSelection = Integer.parseInt(scanner.nextLine());
        switch (buildingActionSelection) {
            case 1:
                buyBuilding();
                break;
            case 2:
                System.out.println("Sprzedaj budynek");
                break;
            case 3:
                break;
            default:
                System.out.println("Wybierz 1-3");
                break;
        }
    }

    public void buyBuilding() {

        Action.allAvailableBuildings();
        int buildingSelection = Integer.parseInt(scanner.nextLine());
        switch (buildingSelection) {
            case 1:
                System.out.println("1. Zagroda");
                if(checkBuildingInFarm("Farm")){
                    System.out.println("Posiadasz juz Zagrodę");
                    Action.farmAction();
                } else {
                    System.out.println("Nie posiadasz Zagrody. W zagrodzie możesz mieć kozy i owce, ktore bedziesz mógł/mogla rozmanazac. Chcesz kupić?");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(1, 60000.00);
                }
                break;
            case 2:
                System.out.println("2. Pasieka");
                if(checkBuildingInFarm("BeeYard")){
                    System.out.println("Posiadasz już Pasiekę");
                    Action.beeYardAction();
                } else {
                    System.out.println("Nie posiadasz Pasieki. W pasiece możesz mieć pszczoły, ktore dadzą Ci miód. Chcesz wybudować?");
                    Action.yesNo();
                    buyOrNoChosenBuilding(2, 30000.00);
                }
                break;
            case 3:
                System.out.println("3. Obora");
                if(checkBuildingInFarm("Cowshed")){
                    System.out.println("Posiadasz już Oborę");
                    Action.cowshedAction();
                } else {
                    System.out.println("Nie posiadasz Obory. W oborze możesz mieć krowy, ktore dadzą Ci mleko. Chcesz wybudować?");
                    Action.yesNo();
                    buyOrNoChosenBuilding(3, 100000.00);
                }
                break;
            case 4:
                System.out.println("4. Stodoła");
                if(checkBuildingInFarm("Barn")){
                    System.out.println("Posiadasz już Stodołę");
                    Action.barnAction();
                } else {
                    System.out.println("Nie posiadasz Stodoły. W stodole możesz mieć sprzęt, ktory przyda Ci się do pracy w polu. Chcesz wybudować?");
                    Action.yesNo();
                    buyOrNoChosenBuilding(4, 200000.00);
                }
                break;
            case 5:
                System.out.println("5. Kurnik");
                if(checkBuildingInFarm("Henhouse")){
                    System.out.println("Posiadasz już Kurnik");
                    Action.henhouseAction();
                } else {
                    System.out.println("Nie posiadasz Kurnika. W kurniku możesz mieć kury, ktore dadzą Ci jajka. Chcesz wybudować?");
                    Action.yesNo();
                    buyOrNoChosenBuilding(5, 20000.00);
                }
                break;
            case 6:
                System.out.println("6. Chlew");
                if(checkBuildingInFarm("Pighouse")){
                    System.out.println("Posiadasz już Chlew");
                    Action.pighouseAction();
                } else {
                    System.out.println("Nie posiadasz Chlewu. W chlewie możesz mieć świnie, ktore możesz karmić i sprzedawac ich mieso. Chcesz wybudować?");
                    Action.yesNo();
                    buyOrNoChosenBuilding(6, 70000.00);
                }
                break;
            case 7:
                break;
            default:
                System.out.println("Wybierz 1-7");
                break;
        }
    }

    public Boolean checkBuildingInFarm(String className) {
        boolean found = false;
        for (Outbuilding building : myFarmer.getBuild()) {
            if (building.getClass().getSimpleName().equals(className)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public void buyOrNoChosenBuilding(Integer building, Double price){
        int buildingSelection = Integer.parseInt(scanner.nextLine());

        if(buildingSelection == 1 & myFarmer.getCash() >= price){
            buyBuilding(building, price);
        } else if (buildingSelection == 2) {
            Action.start();
        } else {
            System.out.println("Wybierz 1-2");
            buyOrNoChosenBuilding(building, price);
        }
    }

    public void buyBuilding(Integer type, Double price) {
        if (type == 1) {
            myFarmer.addBuilding(new Farm(price), price);
        } else if (type == 2) {
            myFarmer.addBuilding(new BeeYard(price), price);
        } else if (type == 3) {
            myFarmer.addBuilding(new Cowshed(price), price);
        } else if (type == 4) {
            myFarmer.addBuilding(new Barn(price), price);
        } else if (type == 5) {
            myFarmer.addBuilding(new Henhouse(price), price);
        }  else if (type == 6) {
            myFarmer.addBuilding(new Pigsty(price), price);
        }
        System.out.println(myFarmer.getBuild());
        Action.next();
    }
}
