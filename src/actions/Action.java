package actions;

import farmer.Farmer;

import java.io.IOException;
import java.util.Scanner;

public class Action {

    private Farmer myFarmer;
    private TimeManager time;
    private BuildingsManager buildingsManager;
    private FieldsManager fieldsManager;

    static Scanner scanner = new Scanner(System.in);

    public Action(Farmer myFarmer, TimeManager time){
        this.myFarmer = myFarmer;
        this.time = time;
        this.buildingsManager = new BuildingsManager(this.myFarmer);
        this.fieldsManager = new FieldsManager(this.myFarmer);
    }

    public void start(){
        this.time.start();
        System.out.println(this.myFarmer);
        this.fieldsManager.generateRandomFarms();
        this.fieldsManager.generateRandomFarms();



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
        }

    public static void startText() {
        System.out.println("");
        System.out.println("Wybierz akcję: ");
        System.out.println("1. Pole");
        System.out.println("2. Budynki");
        System.out.println("3. Zwierzęta");
        System.out.println("4. Podsumowanie");
        System.out.println("5. Zakończ program");
    }

    public static void next() {
        System.out.println("");
        System.out.println("Dalej? Wciśnij enter.");
        scanner.nextLine();
    }

    public static void myFields() {
        System.out.println("");
        System.out.println("1. Kup nowe pole");
        System.out.println("2. Wysiej zboże");
        System.out.println("3. Sprzedaj zboże");
        System.out.println("4. Cofnij");
    }

    public static void buyField() {
        System.out.println("");
        System.out.println("Pola w naszej ofercie: ");
        System.out.println("1. Gotowe do uprawy 60 000.00 PLN");
        System.out.println("2. Zalane, potrzebujące osuszenia oraz budowy grobli 30 000.00 PLN");
        System.out.println("3. Mamy w ofercie również Las 90 000.00 PLN");
        System.out.println("4. \"Dziękuje, nie skorzystam\"");
    }

    public static void yesNo() {
        System.out.println("");
        System.out.println("1. TAK");
        System.out.println("2. NIE");
    }

    public static void myBuildings() {
        System.out.println("");
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Wybierz budynek");
        System.out.println("2. Zburz budynek");
        System.out.println("3. Cofnij");
    }

    public static void allAvailableBuildingsWithPrices(){
        System.out.println("");
        System.out.println("Wybierz budynek: ");
        System.out.println("1. Zagroda - 60.000,00 PLN");
        System.out.println("2. Pasieka - 30.000,00 PLN");
        System.out.println("3. Obora - 100.000,00 PLN");
        System.out.println("4. Stodoła - 200.000,00 PLN");
        System.out.println("5. Kurnik - 20.000,00 PLN");
        System.out.println("6. Chlew - 70.000,00 PLN");
        System.out.println("7. Cofnij");
    }



    public static void farmAction(){
        System.out.println("");
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup owce");
        System.out.println("2. Sprzedaj owce");
        System.out.println("3. Ostrzyż owce i sprzedaj wełnę");
        System.out.println("4. Cofnij");
    }

    public static void beeYardAction(){
        System.out.println("");
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup rój pszczół");
        System.out.println("2. Zbierz i sprzedaj miód");
        System.out.println("3. Cofnij");
    }
    public static void cowshedAction(){
        System.out.println("");
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup krowę");
        System.out.println("2. Sprzedaj krowę");
        System.out.println("3. Zbierz i sprzedaj mleko od krów");
        System.out.println("4. Cofnij");
    }

    public static void henhouseAction(){
        System.out.println("");
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup kurę");
        System.out.println("2. Zbierz i sprzedaj jajka");
        System.out.println("3. Cofnij");
    }
    public static void pighouseAction(){
        System.out.println("");
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup świnię");
        System.out.println("2. Sprzedaj świnię");
        System.out.println("4. Cofnij");
    }


}
