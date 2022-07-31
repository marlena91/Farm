package building.actions;

import area.Ground;
import building.*;
import farmer.Farmer;

import java.util.Objects;
import java.util.Scanner;

public class BuildingsManager {

    private final Farmer myFarmer;
    static Scanner scanner = new Scanner(System.in);

    public BuildingsManager(Farmer myFarmer) {
        this.myFarmer = myFarmer;
    }

    public Integer availablePlacesForBuildings() {
        Integer availablePlaces = 0;
        for (Ground field : myFarmer.getFarms()) {
            availablePlaces += field.getNumberOfBuildings();
        }
        return availablePlaces;
    }

    public void takePlaceForBuilding() {
        for (Ground field : myFarmer.getFarms()) {
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
        System.out.println("1. Zagroda dla owiec i koz - 80.000,00 PLN");
        System.out.println("2. Pasieka - 20.000,00 PLN");
        System.out.println("3. Obora - 180.000,00 PLN");
        System.out.println("4. Stodoła - 400.000,00 PLN");
        System.out.println("5. Kurnik - 15.000,00 PLN");
        System.out.println("6. Chlew - 90.000,00 PLN");
        System.out.println("7. Stajnia - 180.000,00 PLN");
        System.out.println("8. Zagroda dla psow - 15.000,00 PLN");
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
            System.out.println("Koszt to 80.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(1, 80000.00);
        }
    }

    public void buyBeeYard() {
        if (this.checkBuildingInFarm("BeeYard")) {
            System.out.println("Posiadasz juz Pasieke");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Pasieki. Chcesz kupić?");
            System.out.println("Koszt to 20.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(2, 20000.00);
        }
    }

    public void buyCowshed() {
        if (this.checkBuildingInFarm("Cowshed")) {
            System.out.println("Posiadasz juz Obore");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Obory. W oborze możesz hodowac krowy. Chcesz kupić?");
            System.out.println("Koszt to 180.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(3, 180000.00);
        }
    }

    public void buyBarn() {
        if (this.checkBuildingInFarm("Barn")) {
            System.out.println("Posiadasz juz Stodole");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Stodoly. Chcesz kupić?");
            System.out.println("Koszt to 400.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(4, 400000.00);
        }
    }

    public void buyHenhouse() {
        if (this.checkBuildingInFarm("Henhouse")) {
            System.out.println("Posiadasz juz Kurnik");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Kurnika. Chcesz kupić?");
            System.out.println("Koszt to 15.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(5, 15000.00);
        }
    }

    public void buyPigsty() {
        if (this.checkBuildingInFarm("Pigsty")) {
            System.out.println("Posiadasz juz Chlew");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Chlewu. Chcesz kupić?");
            System.out.println("Koszt to 90.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(6, 90000.00);
        }
    }

    public void buyStable() {
        if (this.checkBuildingInFarm("Stable")) {
            System.out.println("Posiadasz juz Stajnie");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Stajni. Chcesz kupić?");
            System.out.println("Koszt to 180.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(7, 180000.00);
        }
    }

    public void buyDoghouse() {
        if (this.checkBuildingInFarm("Doghouse")) {
            System.out.println("Posiadasz juz Zagrodę dla psow");
            this.getBuildings();
        } else {
            System.out.println("Nie posiadasz Zagrody dla psow. Chcesz kupić?");
            System.out.println("Koszt to 15.000,00 PLN");
            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            System.out.println("1.Tak, chce kupic ten budynek");
            System.out.println("0. Nie chce kupowac, wroc do wyboru budynkow");
            buyOrNoChosenBuilding(8, 15000.00);
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
        } else if (type == 7) {
            myFarmer.addBuilding(new Stable(price), price);
        } else if (type == 8) {
            myFarmer.addBuilding(new Doghouse(price), price);
        }
        System.out.println("Pomyslnie zakupiono budynek");
    }
}




