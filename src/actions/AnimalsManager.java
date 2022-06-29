package actions;

import farmer.Farmer;

import java.util.Scanner;

public class AnimalsManager {

    private final Farmer myFarmer;
    private Scanner scanner;

    public AnimalsManager(Farmer myFarmer) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Zwierzęta w Twoim gospodarstwie:");
        myFarmer.getAnimals();
        Action.myAnimals();
        int animalsActionSelection = Integer.parseInt(scanner.nextLine());
        switch (animalsActionSelection) {
            case 1:
                System.out.println("1. Dokup zwierzę");
                break;
            case 2:
                System.out.println("2. Sprzedaj zwierzę");
                break;
            case 3:
                System.out.println("3. Nakarm zwierzę");
                break;
            case 4:
                System.out.println("5. Zbierz");
                break;
            case 5:
                System.out.println("6. Cofnij");
                break;
            default:
                System.out.println("Wybierz 1-6");

                break;
        }
    }

}

