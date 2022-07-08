package actions;

import animals.*;
import area.Ground;
import building.*;
import farmer.Farmer;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class BuildingsManager {

    private final Farmer myFarmer;
    static Scanner scanner = new Scanner(System.in);

    public BuildingsManager(Farmer myFarmer) {
        this.myFarmer = myFarmer;
    }

    public Integer avalaiblePlacesForBuildings() {
        Integer avalaiblePlaces = 0;
        for (Ground field : myFarmer.getField()) {
            avalaiblePlaces += field.getNumberOfBuildings();
        }
        return avalaiblePlaces;
    }

    public void takePlaceForBuilding() {
        for (Ground field : myFarmer.getField()) {
            if (field.getNumberOfBuildings() > 0) {
                field.subtractNumberOfBuilding();
                break;
            }
        }
    }

    public void getBuildings() {
        System.out.println("");
        if (myFarmer.getBuild().size() == 0) {
            System.out.println("Nie masz jeszcze budynkow.");
        } else {
            System.out.println("Budynki, ktore aktualnie posiadasz: ");
            System.out.println(myFarmer.getBuild());
        }
        System.out.println("");
        System.out.println("Dostepne budynki oraz koszt ich wybudowania: ");
        System.out.println("");
        System.out.println("Wybierz budynek: ");
        System.out.println("1. Zagroda dla owiec i koz - 100.000,00 PLN");
        System.out.println("2. Pasieka - 40.000,00 PLN");
        System.out.println("3. Obora - 200.000,00 PLN");
        System.out.println("4. Stodoła - 500.000,00 PLN");
        System.out.println("5. Kurnik - 30.000,00 PLN");
        System.out.println("6. Chlew - 100.000,00 PLN");
        System.out.println("7. Stajnia - 200.000,00 PLN");
        System.out.println("8. Zagroda dla psow - 30.000,00 PLN");
        System.out.println("0. Cofnij");

        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            this.buyFarm();
        } else if (Objects.equals(select, "2")) {
            this.buyBeeYard();
        } else if (Objects.equals(select, "3")) {
            this.buyCowshed();
        } else if (Objects.equals(select, "4")) {
            this.buyBarn();
        } else if (Objects.equals(select, "5")) {
            this.buyHenhouse();
        } else if (Objects.equals(select, "6")) {
            this.buyPigsty();
        } else if (Objects.equals(select, "7")) {
            this.buyStable();
        } else if (Objects.equals(select, "8")) {
            this.buyDoghouse();
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

    public void buyFarm() {
        if (this.checkBuildingInFarm("Farm")) {
            System.out.println("Posiadasz juz Zagrodę");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Zagrody. W zagrodzie możesz mieć kozy i owce. Chcesz kupić?");
            System.out.println("Koszt to 100.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(1, 100000.00);
        }
    }

    public void buyBeeYard() {
        if (this.checkBuildingInFarm("BeeYard")) {
            System.out.println("Posiadasz juz Pasieke");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Pasieki. Chcesz kupić?");
            System.out.println("Koszt to 40.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(2, 40000.00);
        }
    }

    public void buyCowshed() {
        if (this.checkBuildingInFarm("Cowshed")) {
            System.out.println("Posiadasz juz Obore");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Obory. W oborze możesz hodowac krowy. Chcesz kupić?");
            System.out.println("Koszt to 200.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(3, 200000.00);
        }
    }

    public void buyBarn() {
        if (this.checkBuildingInFarm("Barn")) {
            System.out.println("Posiadasz juz Stodole");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Stodoly. Chcesz kupić?");
            System.out.println("Koszt to 500.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(4, 500000.00);
        }
    }

    public void buyHenhouse() {
        if (this.checkBuildingInFarm("Henhouse")) {
            System.out.println("Posiadasz juz Kurnik");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Kurnika. Chcesz kupić?");
            System.out.println("Koszt to 30.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(5, 30000.00);
        }
    }

    public void buyPigsty() {
        if (this.checkBuildingInFarm("Pigsty")) {
            System.out.println("Posiadasz juz Chlew");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Chlewu. Chcesz kupić?");
            System.out.println("Koszt to 100.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(6, 100000.00);
        }
    }

    public void buyStable() {
        if (this.checkBuildingInFarm("Stajnia")) {
            System.out.println("Posiadasz juz Stajnie");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Stajni. Chcesz kupić?");
            System.out.println("Koszt to 200.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(7, 200000.00);
        }
    }

    public void buyDoghouse() {
        if (this.checkBuildingInFarm("Doghouse")) {
            System.out.println("Posiadasz juz Zagrodę dla psow");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Zagrody dla psow. Chcesz kupić?");
            System.out.println("Koszt to 30.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(8, 30000.00);
        }
    }

    public void buyOrNoChosenBuilding(Integer building, Double price) {
        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            this.buyBuilding(building, price);
            this.takePlaceForBuilding();
        } else if (Objects.equals(select, "0")) {
            this.getBuildings();
        } else {
            System.out.println("Wybierz 1 lub 0");

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
        } else if (type == 6) {
            myFarmer.addBuilding(new Pigsty(price), price);
        }
        System.out.println("Pomyslnie zakupiono budynek");
    }

}


//
//    public void buyBuilding() {
//
//        Action.allAvailableBuildingsWithPrices();
//        int buildingSelection = Integer.parseInt(scanner.nextLine());
//        switch (buildingSelection) {
//            case 1:
//                if(checkBuildingInFarm("Farm")){
//                    System.out.println("Posiadasz juz Zagrodę");
//                    Action.farmAction();
//                    int farmActionSelection = Integer.parseInt(scanner.nextLine());
//                    buildingAction(farmActionSelection, 1);
//                } else {
//                    System.out.println("Nie posiadasz Zagrody. W zagrodzie możesz mieć kozy i owce, ktore bedziesz mógł/mogla rozmanazac. Chcesz kupić?");
//                    System.out.println("Koszt to 60.000,00 PLN");
//                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//                    Action.yesNo();
//                    buyOrNoChosenBuilding(1, 60000.00);
//                }
//                break;
//            case 2:
//                if(checkBuildingInFarm("BeeYard")){
//                    System.out.println("Posiadasz już Pasiekę");
//                    Action.beeYardAction();
//                    int beeYardActionSelection = Integer.parseInt(scanner.nextLine());
//                    buildingAction(beeYardActionSelection, 2);
//                } else {
//                    System.out.println("Nie posiadasz Pasieki. W pasiece możesz mieć pszczoły, ktore dadzą Ci miód. Chcesz wybudować?");
//                    System.out.println("Koszt to 30.000,00 PLN");
//                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//                    Action.yesNo();
//                    buyOrNoChosenBuilding(2, 30000.00);
//                }
//                break;
//            case 3:
//                if(checkBuildingInFarm("Cowshed")){
//                    System.out.println("Posiadasz już Oborę");
//                    Action.cowshedAction();
//                    int cowsheddActionSelection = Integer.parseInt(scanner.nextLine());
//                    buildingAction(cowsheddActionSelection, 3);
//                } else {
//                    System.out.println("Nie posiadasz Obory. W oborze możesz mieć krowy, ktore dadzą Ci mleko. Chcesz wybudować?");
//                    System.out.println("Koszt to 100.000,00 PLN");
//                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//                    Action.yesNo();
//                    buyOrNoChosenBuilding(3, 100000.00);
//                }
//                break;
//            case 4:
//                if(checkBuildingInFarm("Barn")){
//                    System.out.println("Posiadasz już Stodołę");
//                    start();
//                } else {
//                    System.out.println("Nie posiadasz Stodoły. W stodole możesz mieć sprzęt, ktory przyda Ci się do pracy w polu. Chcesz wybudować?");
//                    System.out.println("Koszt to 200.000,00 PLN");
//                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//                    Action.yesNo();
//                    buyOrNoChosenBuilding(4, 200000.00);
//                }
//                break;
//            case 5:
//                if(checkBuildingInFarm("Henhouse")){
//                    System.out.println("Posiadasz już Kurnik");
//                    Action.henhouseAction();
//                    int henhouseActionSelection = Integer.parseInt(scanner.nextLine());
//                    buildingAction(henhouseActionSelection, 5);
//                } else {
//                    System.out.println("Nie posiadasz Kurnika. W kurniku możesz mieć kury, ktore dadzą Ci jajka. Chcesz wybudować?");
//                    System.out.println("Koszt to 20.000,00 PLN");
//                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//                    Action.yesNo();
//                    buyOrNoChosenBuilding(5, 20000.00);
//                }
//                break;
//            case 6:
//                if(checkBuildingInFarm("Pigsty")){
//                    System.out.println("Posiadasz już Chlew");
//                    Action.pighouseAction();
//                    int pighouseActionSelection = Integer.parseInt(scanner.nextLine());
//                    buildingAction(pighouseActionSelection, 6);
//                } else {
//                    System.out.println("Nie posiadasz Chlewu. W chlewie możesz mieć świnie, ktore możesz karmić i sprzedawac ich mieso. Chcesz wybudować?");
//                    System.out.println("Koszt to 70.000,00 PLN");
//                    System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//                    Action.yesNo();
//                    buyOrNoChosenBuilding(6, 70000.00);
//                }
//                break;
//            case 7:
////                Action.start(myFarmer);
//            default:
//                System.out.println("Wybierz 1-7");
//                break;
//        }
//    }
//


//
//    public Boolean checkBuildingInFarm(String className) {
//        boolean found = false;
//        for (Outbuilding building : myFarmer.getBuild()) {
//            if (building.getClass().getSimpleName().equals(className)) {
//                found = true;
//                break;
//            }
//        }
//        return found;
//    }
//
//
//
//    public void buildingAction(Integer numberOfAction, Integer buildingType){
//        if(numberOfAction == 1 & buildingType == 1){
//            buySheepToFarm();
//        }
//
//        if(numberOfAction == 2 & buildingType == 1){
//            sellAnimalFromFarm("Farm");
//        }
//
//        if(numberOfAction == 3 & buildingType == 1){
//            myFarmer.sellGoods("Farm");
//        }
//
//        if(numberOfAction == 1 & buildingType == 2){
//            buyBeeToFarm();
//        }
//
//        if(numberOfAction == 2 & buildingType == 2){
//            myFarmer.sellGoods("BeeYard");
//        }
//        if(numberOfAction == 1 & buildingType == 3){
//            buyCowToCowshed();
//        }
//
//        if(numberOfAction == 2 & buildingType == 3){
//            sellAnimalFromFarm("Cowshed");
//        }
//
//        if(numberOfAction == 3 & buildingType == 3){
//            myFarmer.sellGoods("Cowshed");
//        }
//        if(numberOfAction == 1 & buildingType == 5){
//            buyHenToHenhouse();
//        }
//
//        if(numberOfAction == 2 & buildingType == 5){
//            myFarmer.sellGoods("Henhouse");
//        }
//
//        if(numberOfAction == 1 & buildingType == 6){
//            buyPigToPigsty();
//        }
//
//        if(numberOfAction == 2 & buildingType == 6){
//            sellAnimalFromFarm("Pigsty");
//        }
//
//    }
//
//    public void buySheepToFarm(){
//        System.out.println("Jakie imie wybierasz dla swojej nowej owcy?");
//        String animalName = scanner.nextLine();
//        myFarmer.addAnimal(new Sheep(animalName), 1000.00, "Farm");
//        start();
//    }
//
//    public void sellAnimalFromFarm(String className){
//        if(myFarmer.getAnimals(className).isEmpty()){
//            System.out.println("Nie masz żadnych zwierząt, które mógłbyś sprzedać.");
//            start();
//        }
//        System.out.println("Ktore zwierze chcesz sprzedac?");
//        int i = 1;
//        for(Animal animal : myFarmer.getAnimals(className)){
//            System.out.println(i+". "+animal);
//            i++;
//        }
//        int animalToDeleteSelection = Integer.parseInt(scanner.nextLine());
//        i=1;
//        for(Animal animal : myFarmer.getAnimals(className)){
//            if(animalToDeleteSelection == i){
//                myFarmer.deleteAnimal(animal, className);
//                System.out.println("Pomyslnie sprzedano "+animal);
//                break;
//            }
//            i++;
//        }
//    }
//
//    public void buyBeeToFarm(){
//        if(myFarmer.getAnimals("BeeYard").isEmpty()){
//            myFarmer.addAnimal(new Bee(), 1000.00, "BeeYard");
//            Action.next();
//            start();
//        } else {
//            System.out.println("Posiadasz już pszczoły w pasiece. NIe mozesz wiecej kupić.");
//            start();
//        }
//    }
//
//    public void buyCowToCowshed(){
//        System.out.println("Jakie imie wybierasz dla swojej nowej krowy?");
//        String animalName = scanner.nextLine();
//        myFarmer.addAnimal(new Cow(animalName), 1000.00, "Cowshed");
//        start();
//    }
//
//    public void buyPigToPigsty(){
//        System.out.println("Jakie imie wybierasz dla swojej nowej świni?");
//        String animalName = scanner.nextLine();
//        myFarmer.addAnimal(new Pig(animalName), 1000.00, "Pigsty");
//        start();
//    }
//
//    public void buyHenToHenhouse(){
//        myFarmer.addAnimal(new Hen(), 500.00, "Henhouse");
//        Action.next();
//        start();
//    }
//
//    public void destroyBuilding(){
//        if(myFarmer.getBuild().isEmpty()){
//            System.out.println("Nie masz żadnych budynków, które mógłbyś sprzedać.");
//            start();
//        }
//        System.out.println("Ktory budynek chcesz sprzedac?");
//        int i = 1;
//        for(Outbuilding building : myFarmer.getBuild()){
//            System.out.println(i+". "+building);
//            i++;
//        }
//        int buildingToDestroySelection = Integer.parseInt(scanner.nextLine());
//        i=1;
//        for(Outbuilding building : myFarmer.getBuild()){
//            if(buildingToDestroySelection == i){
//                myFarmer.removeBuilding(building);
//                break;
//            }
//            i++;
//        }
//
//    }



