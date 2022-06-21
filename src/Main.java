import actions.Action;
import actions.FieldsManager;
import area.FertileField;
import area.FloodedField;
import area.Ground;
import farmer.Farmer;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        String farmerName = scanner.nextLine();
        Farmer myFarmer = new Farmer(farmerName);

        System.out.println(myFarmer);

        first:
        while(true){
            Action.start();
            int userSelection = Integer.parseInt(scanner.nextLine());
            switch (userSelection) {

                case 1:
                    FieldsManager fieldsManager = new FieldsManager(myFarmer);
                    fieldsManager.start();
                    break;

                case 2: // Buildings
                    System.out.println("budynki");
                    break;
                case 3:
                    System.out.println("zwierzeta");
                    break;
                case 4:
                    System.out.println("sprzet");
                    break;
                case 5:
                    System.out.println(myFarmer);
                    Action.next();
                    break;
                case 6:
                    break first;
                default:
                    System.out.println("Wybierz 1-6");
                    break;
            }
        }

    }
}
