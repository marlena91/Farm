package actions;

import building.Cowshed;
import building.Outbuilding;
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
        switch (buildingSelection){
            case 1:
                System.out.println("1. Zagroda");

                break;
            case 2:
                System.out.println("2. Pasieka");
                break;
            case 3:
                System.out.println("3. Obora");
                for(Outbuilding building: myFarmer.getBuild()){
                    if(building instanceof Cowshed){
                        System.out.println("Masz już w swoim gospodarstwie oborę");
                    } else {System.out.println("Nie");}
                }
                break;
            case 4:
                System.out.println("4. Stodoła");
                break;
            case 5:
                System.out.println("5. Kurnik");
                break;
            case 6:
                System.out.println("6. Chlew");
                break;
            case 7:
                break;
            default:
                System.out.println("Wybierz 1-7");
                break;
        }
    }
}
