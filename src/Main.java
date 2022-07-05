import actions.*;
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
        TimeManager time = new TimeManager();

        time.start();


//        System.out.println(myFarmer);

        Action.start(myFarmer);

    }
}
