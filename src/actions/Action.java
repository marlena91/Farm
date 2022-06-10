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
        System.out.println("4. Zakończ program");
    }

    public static void buyField() {
        System.out.println("Pola w naszej ofercie: ");
        System.out.println("1. Gotowe do uprawy 60 000.00 PLN");
        System.out.println("2. Zalane, potrzebujące osuszenia oraz budowy grobli 30 000.00 PLN");
        System.out.println("3. Mamy w ofercie również Las (wytnij i sprzedaj drewno) 90 000.00 PLN");
        System.out.println("4. \"Dziękuje, nie skorzystam\"");
    }

    public static void buySeeder() {
        System.out.println("Nie posiadasz siewnika. Czy chcesz zakupić za jedyne 20 000.00 PLN?");
        System.out.println("1. TAK");
        System.out.println("2. NIE");
    }

}
