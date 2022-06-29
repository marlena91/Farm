package actions;

import java.util.Scanner;

public class Action {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Wybierz akcję: ");
        System.out.println("1. Pole");
        System.out.println("2. Budynki");
        System.out.println("3. Zwierzęta");
        System.out.println("4. Sprzęt");
        System.out.println("5. Podsumowanie");
        System.out.println("6. Zakończ program");
    }

    public static void next() {
        System.out.println("Dalej?");
        scanner.nextLine();
    }

    public static void myFields() {
        System.out.println("1. Kup nowe pole");
        System.out.println("2. Wysiej zboże");
        System.out.println("3. Sprzedaj zboże");
        System.out.println("4. Cofnij");
    }

    public static void buyField() {
        System.out.println("Pola w naszej ofercie: ");
        System.out.println("1. Gotowe do uprawy 60 000.00 PLN");
        System.out.println("2. Zalane, potrzebujące osuszenia oraz budowy grobli 30 000.00 PLN");
        System.out.println("3. Mamy w ofercie również Las (wytnij i sprzedaj drewno) 90 000.00 PLN");
        System.out.println("4. \"Dziękuje, nie skorzystam\"");
    }

    public static void yesNo() {
        System.out.println("1. TAK");
        System.out.println("2. NIE");
    }

    public static void myBuildings() {
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Wybierz budynek");
        System.out.println("2. Sprzedaj budynek");
        System.out.println("3. Cofnij");
    }

    public static void allAvailableBuildingsWithPrices(){
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
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup zwierzę");
        System.out.println("2. Sprzedaj zwierzę");
        System.out.println("4. Ostrzyż owce i sprzedaj wełnę");
        System.out.println("5. Nakarm zwierzęta");
        System.out.println("6. Cofnij");
    }
    public static void cowshedAction(){
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup krowę");
        System.out.println("2. Sprzedaj krowę");
        System.out.println("3. Zbierz i sprzedaj mleko od krów");
        System.out.println("4. Nakarm krowy");
        System.out.println("5. Cofnij");
    }
    public static void beeYardAction(){
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup rój pszczół");
        System.out.println("2. Zbierz i sprzedaj miód");
        System.out.println("3. Cofnij");
    }
    public static void barnAction(){
        System.out.println("Tu beda opcje do stodoły");
    }
    public static void henhouseAction(){
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup kurę");
        System.out.println("2. Zbierz i sprzedaj jajka");
        System.out.println("3. Nakarm kury");
        System.out.println("4. Cofnij");
    }
    public static void pighouseAction(){
        System.out.println("Dostępne akcje: ");
        System.out.println("1. Kup świnię");
        System.out.println("2. Sprzedaj świnię");
        System.out.println("3. Nakarm zwierzęta");
        System.out.println("4. Cofnij");
    }

    public static void myAnimals(){
        System.out.println("1. Dokup zwierzę");
        System.out.println("2. Sprzedaj zwierzę");
        System.out.println("3. Nakarm zwierzę");
        System.out.println("4. Rozmnażaj zwierzęta");
        System.out.println("5. Zbierz");
        System.out.println("6. Cofnij");
    }


}
