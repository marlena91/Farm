package actions;

import area.Ground;
import farmer.Farmer;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Action {

    private Farmer myFarmer;
    private TimeManager time;
    private BuildingsManager buildingsManager;
    private FieldsManager fieldsManager;

    static Scanner scanner = new Scanner(System.in);

    public Action(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
        this.buildingsManager = new BuildingsManager(this.myFarmer);
        this.fieldsManager = new FieldsManager(this.myFarmer, this.time, this);
    }

    public void newWeek() {
        System.out.println("");
        this.time.start();
        System.out.println(this.myFarmer);
        this.fieldsManager.generateRandomFarms();
        this.mainChoices();
    }

    public void startText() {
        System.out.println("");
        System.out.println("Wybierz akcję: ");
        System.out.println("1. Zakup farmy");
        System.out.println("2. Zakup/sprzedaz ziemi uprawnej");
        System.out.println("3. Zakup nowych budynkow");
        System.out.println("4. Zakup zwierzat lub roslin");
        System.out.println("5. Posadzenie roslin");
        System.out.println("6. Zbiory roslin");
        System.out.println("7. Sprzedaz roslin lub zwierzat");
        System.out.println("8. Sprawdzenie stanu zapasow");
        System.out.println("9. Przejrzenie informacji o posiadanych zwierzetach");
        System.out.println("10. Przejrzenie informacji o posiadanych sadzonkach i asadzonych roslinach");
        System.out.println("11. Podsumowanie tygodnia - przejdz do nastepnej rundy");
    }

    public void mainChoices() {
        this.startText();

        String selectAction = scanner.nextLine();

        if (Objects.equals(selectAction, "1")) {
            this.buyNewFarm();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "2")) {
            this.buyOrSellNewField();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "3")) {
            System.out.println("Zakup nowych budynkow");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "4")) {
            System.out.println("Zakup zwierzat lub roslin");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "5")) {
            System.out.println("Posadzenie roslin");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "6")) {
            System.out.println("Zbiory roslin");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "7")) {
            System.out.println("Sprzedaz roslin lub zwierzat");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "8")) {
            System.out.println("Sprawdzenie stanu zapasow");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "9")) {
            System.out.println("Przejrzenie informacji o posiadanych zwierzetach");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "10")) {
            System.out.println("Przejrzenie informacji o posiadanych sadzonkach i asadzonych roslinach");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "11")) {
            System.out.println("Koniec tygodnia");
            this.endWeek();
        } else {
            System.out.println("Wybierz od 1-10");
            this.mainChoices();
        }
    }

    public void endWeek() {
        System.out.println("Dzieja sie rozne rzeczy");
        System.out.println("Robaki zjadaja plony");
        if (myFarmer.getCash() <= 0) {
            System.out.println("Zwierzeta chudna ");
        }
        this.time.addWeek();
        this.next();
        this.newWeek();
    }

    public void next() {
        System.out.println("");
        System.out.println("Dalej? Wciśnij enter.");
        scanner.nextLine();
    }

    public void buyNewFarm(){
        System.out.println("");
        System.out.println("Farmy dostepne w tym tygodniu: ");
        int i = 1;
        for(Ground field : fieldsManager.getRandomFarms()){
            System.out.println(i+". "+field);
            i++;
        }
        this.fieldsManager.buyFarm();
        this.next();
        this.mainChoices();
    }

    public void buyOrSellNewField(){
        System.out.println("");
        if(this.fieldsManager.getFarmArea() == 0){
            System.out.println("Nie masz jeszcze farmy. Udaj sie do punktu 1 i zakup swoja pierwsza farme");
            this.next();
            this.mainChoices();
        }
        System.out.println("Aktualnie posiadasz "+ this.fieldsManager.getFarmArea()+ "ha pola uprawnego na swoich farmach " +
                "oraz "+ this.myFarmer.getAdditionalArea() + "ha pola uprawnego, poza Twoimi farmami");
        System.out.println("Czy chcesz dokupic pola uprawne?");
        this.fieldsManager.buyAdditionalFertileField();
    }


//            Action.startText();
//            int userSelection = Integer.parseInt(scanner.nextLine());
//            switch (userSelection) {
//                case 1 -> {
//                    FieldsManager fieldsManager = new FieldsManager(myFarmer);
//                    fieldsManager.start();
//                }
//                case 2 -> {
//                    BuildingsManager buildingsManager = new BuildingsManager(myFarmer);
//                    buildingsManager.start();
//                }
//                case 3 -> {
//                    System.out.println("Zwierzęta w Twoim gospodarstwie:");
//                    myFarmer.getAnimals();
//                    System.out.println("Poszczegolne akcje dotyczace zwierzat w odpowiadajacym ich budynkach.");
//                }
//                case 4 -> {
//                    System.out.println(myFarmer);
//                    Action.next();
//                }
//                case 5 -> System.exit(0);
//                default -> System.out.println("Wybierz 1-6");
//            }


    //

//
//    public static void myFields() {
//        System.out.println("");
//        System.out.println("1. Kup nowe pole");
//        System.out.println("2. Wysiej zboże");
//        System.out.println("3. Sprzedaj zboże");
//        System.out.println("4. Cofnij");
//    }
//

//
//    public static void yesNo() {
//        System.out.println("");
//        System.out.println("1. TAK");
//        System.out.println("2. NIE");
//    }
//
//    public static void myBuildings() {
//        System.out.println("");
//        System.out.println("Dostępne akcje: ");
//        System.out.println("1. Wybierz budynek");
//        System.out.println("2. Zburz budynek");
//        System.out.println("3. Cofnij");
//    }
//
//    public static void allAvailableBuildingsWithPrices(){
//        System.out.println("");
//        System.out.println("Wybierz budynek: ");
//        System.out.println("1. Zagroda - 60.000,00 PLN");
//        System.out.println("2. Pasieka - 30.000,00 PLN");
//        System.out.println("3. Obora - 100.000,00 PLN");
//        System.out.println("4. Stodoła - 200.000,00 PLN");
//        System.out.println("5. Kurnik - 20.000,00 PLN");
//        System.out.println("6. Chlew - 70.000,00 PLN");
//        System.out.println("7. Cofnij");
//    }
//
//
//
//    public static void farmAction(){
//        System.out.println("");
//        System.out.println("Dostępne akcje: ");
//        System.out.println("1. Kup owce");
//        System.out.println("2. Sprzedaj owce");
//        System.out.println("3. Ostrzyż owce i sprzedaj wełnę");
//        System.out.println("4. Cofnij");
//    }
//
//    public static void beeYardAction(){
//        System.out.println("");
//        System.out.println("Dostępne akcje: ");
//        System.out.println("1. Kup rój pszczół");
//        System.out.println("2. Zbierz i sprzedaj miód");
//        System.out.println("3. Cofnij");
//    }
//    public static void cowshedAction(){
//        System.out.println("");
//        System.out.println("Dostępne akcje: ");
//        System.out.println("1. Kup krowę");
//        System.out.println("2. Sprzedaj krowę");
//        System.out.println("3. Zbierz i sprzedaj mleko od krów");
//        System.out.println("4. Cofnij");
//    }
//
//    public static void henhouseAction(){
//        System.out.println("");
//        System.out.println("Dostępne akcje: ");
//        System.out.println("1. Kup kurę");
//        System.out.println("2. Zbierz i sprzedaj jajka");
//        System.out.println("3. Cofnij");
//    }
//    public static void pighouseAction(){
//        System.out.println("");
//        System.out.println("Dostępne akcje: ");
//        System.out.println("1. Kup świnię");
//        System.out.println("2. Sprzedaj świnię");
//        System.out.println("4. Cofnij");
//    }


}
