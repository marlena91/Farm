package actions;

import animals.*;
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
                destroyBuilding();
                break;
            case 3:
                break;
            default:
                System.out.println("Wybierz 1-3");
                break;
        }
    }

    public void buyBuilding() {

        Action.allAvailableBuildingsWithPrices();
        int buildingSelection = Integer.parseInt(scanner.nextLine());
        switch (buildingSelection) {
            case 1:
                if(checkBuildingInFarm("Farm")){
                    System.out.println("Posiadasz juz Zagrodę");
                    Action.farmAction();
                    int farmActionSelection = Integer.parseInt(scanner.nextLine());
                    buildingAction(farmActionSelection, 1);
                } else {
                    System.out.println("Nie posiadasz Zagrody. W zagrodzie możesz mieć kozy i owce, ktore bedziesz mógł/mogla rozmanazac. Chcesz kupić?");
                    System.out.println("Koszt to 60.000,00 PLN");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(1, 60000.00);
                }
                break;
            case 2:
                if(checkBuildingInFarm("BeeYard")){
                    System.out.println("Posiadasz już Pasiekę");
                    Action.beeYardAction();
                    int beeYardActionSelection = Integer.parseInt(scanner.nextLine());
                    buildingAction(beeYardActionSelection, 2);
                } else {
                    System.out.println("Nie posiadasz Pasieki. W pasiece możesz mieć pszczoły, ktore dadzą Ci miód. Chcesz wybudować?");
                    System.out.println("Koszt to 30.000,00 PLN");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(2, 30000.00);
                }
                break;
            case 3:
                if(checkBuildingInFarm("Cowshed")){
                    System.out.println("Posiadasz już Oborę");
                    Action.cowshedAction();
                    int cowsheddActionSelection = Integer.parseInt(scanner.nextLine());
                    buildingAction(cowsheddActionSelection, 3);
                } else {
                    System.out.println("Nie posiadasz Obory. W oborze możesz mieć krowy, ktore dadzą Ci mleko. Chcesz wybudować?");
                    System.out.println("Koszt to 100.000,00 PLN");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(3, 100000.00);
                }
                break;
            case 4:
                if(checkBuildingInFarm("Barn")){
                    System.out.println("Posiadasz już Stodołę");
                    start();
                } else {
                    System.out.println("Nie posiadasz Stodoły. W stodole możesz mieć sprzęt, ktory przyda Ci się do pracy w polu. Chcesz wybudować?");
                    System.out.println("Koszt to 200.000,00 PLN");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(4, 200000.00);
                }
                break;
            case 5:
                if(checkBuildingInFarm("Henhouse")){
                    System.out.println("Posiadasz już Kurnik");
                    Action.henhouseAction();
                    int henhouseActionSelection = Integer.parseInt(scanner.nextLine());
                    buildingAction(henhouseActionSelection, 5);
                } else {
                    System.out.println("Nie posiadasz Kurnika. W kurniku możesz mieć kury, ktore dadzą Ci jajka. Chcesz wybudować?");
                    System.out.println("Koszt to 20.000,00 PLN");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(5, 20000.00);
                }
                break;
            case 6:
                if(checkBuildingInFarm("Pigsty")){
                    System.out.println("Posiadasz już Chlew");
                    Action.pighouseAction();
                    int pighouseActionSelection = Integer.parseInt(scanner.nextLine());
                    buildingAction(pighouseActionSelection, 6);
                } else {
                    System.out.println("Nie posiadasz Chlewu. W chlewie możesz mieć świnie, ktore możesz karmić i sprzedawac ich mieso. Chcesz wybudować?");
                    System.out.println("Koszt to 70.000,00 PLN");
                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                    Action.yesNo();
                    buyOrNoChosenBuilding(6, 70000.00);
                }
                break;
            case 7:
                Action.totalStart(myFarmer);
            default:
                System.out.println("Wybierz 1-7");
                break;
        }
    }

    public void buyOrNoChosenBuilding(Integer building, Double price){
        int buildingSelection = Integer.parseInt(scanner.nextLine());
        if(buildingSelection == 1){
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



    public void buildingAction(Integer numberOfAction, Integer buildingType){
        if(numberOfAction == 1 & buildingType == 1){
            buySheepToFarm();
        }

        if(numberOfAction == 2 & buildingType == 1){
            sellAnimalFromFarm("Farm");
        }

        if(numberOfAction == 3 & buildingType == 1){
            myFarmer.sellGoods("Farm");
        }

        if(numberOfAction == 1 & buildingType == 2){
            buyBeeToFarm();
        }

        if(numberOfAction == 2 & buildingType == 2){
            myFarmer.sellGoods("BeeYard");
        }
        if(numberOfAction == 1 & buildingType == 3){
            buyCowToCowshed();
        }

        if(numberOfAction == 2 & buildingType == 3){
            sellAnimalFromFarm("Cowshed");
        }

        if(numberOfAction == 3 & buildingType == 3){
            myFarmer.sellGoods("Cowshed");
        }
        if(numberOfAction == 1 & buildingType == 5){
            buyHenToHenhouse();
        }

        if(numberOfAction == 2 & buildingType == 5){
            myFarmer.sellGoods("Henhouse");
        }

        if(numberOfAction == 1 & buildingType == 6){
            buyPigToPigsty();
        }

        if(numberOfAction == 2 & buildingType == 6){
            sellAnimalFromFarm("Pigsty");
        }

    }

    public void buySheepToFarm(){
        System.out.println("Jakie imie wybierasz dla swojej nowej owcy?");
        String animalName = scanner.nextLine();
        myFarmer.addAnimal(new Sheep(animalName), 1000.00, "Farm");
        start();
    }

    public void sellAnimalFromFarm(String className){
        if(myFarmer.getAnimals(className).isEmpty()){
            System.out.println("Nie masz żadnych zwierząt, które mógłbyś sprzedać.");
            start();
        }
        System.out.println("Ktore zwierze chcesz sprzedac?");
        int i = 1;
        for(Animal animal : myFarmer.getAnimals(className)){
            System.out.println(i+". "+animal);
            i++;
        }
        int animalToDeleteSelection = Integer.parseInt(scanner.nextLine());
        i=1;
        for(Animal animal : myFarmer.getAnimals(className)){
            if(animalToDeleteSelection == i){
                myFarmer.deleteAnimal(animal, className);
                System.out.println("Pomyslnie sprzedano "+animal);
                break;
            }
            i++;
        }
    }

    public void buyBeeToFarm(){
        if(myFarmer.getAnimals("BeeYard").isEmpty()){
            myFarmer.addAnimal(new Bee(), 1000.00, "BeeYard");
            Action.next();
            start();
        } else {
            System.out.println("Posiadasz już pszczoły w pasiece. NIe mozesz wiecej kupić.");
            start();
        }
    }

    public void buyCowToCowshed(){
        System.out.println("Jakie imie wybierasz dla swojej nowej krowy?");
        String animalName = scanner.nextLine();
        myFarmer.addAnimal(new Cow(animalName), 1000.00, "Cowshed");
        start();
    }

    public void buyPigToPigsty(){
        System.out.println("Jakie imie wybierasz dla swojej nowej świni?");
        String animalName = scanner.nextLine();
        myFarmer.addAnimal(new Pig(animalName), 1000.00, "Pigsty");
        start();
    }

    public void buyHenToHenhouse(){
        myFarmer.addAnimal(new Hen(), 500.00, "Henhouse");
        Action.next();
        start();
    }

    public void destroyBuilding(){
        if(myFarmer.getBuild().isEmpty()){
            System.out.println("Nie masz żadnych budynków, które mógłbyś sprzedać.");
            start();
        }
        System.out.println("Ktory budynek chcesz sprzedac?");
        int i = 1;
        for(Outbuilding building : myFarmer.getBuild()){
            System.out.println(i+". "+building);
            i++;
        }
        int buildingToDestroySelection = Integer.parseInt(scanner.nextLine());
        i=1;
        for(Outbuilding building : myFarmer.getBuild()){
            if(buildingToDestroySelection == i){
                myFarmer.removeBuilding(building);
                break;
            }
            i++;
        }

    }

}
