import actions.Action;
import area.FertileField;
import area.FloodedField;
import area.Ground;

import java.io.IOException;
import java.sql.SQLOutput;
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

                case 1: // Field
                    System.out.println(myFarmer.getField());
                    Action.myFields();
                    int fieldActionSelection = Integer.parseInt(scanner.nextLine());
                    switch (fieldActionSelection) {

                        case 1: // Buy field
                            if(myFarmer.getCash() >= 30000.00){
                                Action.buyField();
                                System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                                int buyFieldActionSelection = Integer.parseInt(scanner.nextLine());
                                switch (buyFieldActionSelection) {

                                    case 1: // Buy fertile field
                                        myFarmer.addField(new FertileField(), 60000.00);
                                        System.out.println(myFarmer.getField());
                                        Action.next();
                                        break;

                                    case 2: // Buy flooded field
                                        myFarmer.addField(new FloodedField(), 30000.00);
                                        System.out.println(myFarmer.getField());
                                        Action.next();
                                        break;

                                    case 3: // Buy forest
                                        myFarmer.addField(new FloodedField(), 90000.00);
                                        System.out.println(myFarmer.getField());
                                        Action.next();
                                        break;


                                    case 4:
                                        break;

                                    default:
                                        System.out.println("Wybierz 1-4");
                                        break;
                                    }

                            } else {
                                System.out.println("Nie masz odpowiedniej kwoty, wróć gdy status Twojego konta będzie wynosił conajmniej 30 000.00 PLN");
                                System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                                Action.next();
                            }
                            continue;

                        case 2: // Sow the wheat
                            if(myFarmer.isSeederInBarn()) {
                                System.out.println("Wybierz nr pola");
                                int fieldNumber = Integer.parseInt(scanner.nextLine())-1;
                                if(fieldNumber >= myFarmer.getField().size()){
                                    System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
                                    continue;
                                }
                                Ground chosenField = myFarmer.getSingleField(fieldNumber);
                                if(Objects.equals(chosenField.getState(), "Gotowe do wysiewu")){
                                    chosenField.changeState();
                                    System.out.println(myFarmer.getSingleField(fieldNumber));
                                } else {
                                    System.out.println("Nie można zasiać na: " + chosenField.getState());
                                }
                                Action.next();
                            } else {
                                System.out.println("Aby zasiac zboże na swoim polu potrzebujesz zespołu maszyn Traktor + Siewnik.");
                                System.out.println("Czy posiadasz w swojej stodole powyższy ekwipunek? Sprawdź to. Wcisnij enter.");
                                Action.next();
                                Action.buySeeder();
                                System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                                int buySeederActionSelection = Integer.parseInt(scanner.nextLine());
                                switch (buySeederActionSelection) {

                                    case 1: // Buy a seeder
                                        myFarmer.buySeeder();
                                        System.out.println("Pomyślnie zakupiono siewnik.");
                                        Action.next();
                                        continue;
                                    case 2: // Don't buy a seeder
                                        break;
                                    default:
                                        System.out.println("Wybierz 1-2");
                                        break;
                                }
                            }
                            continue;
                        case 3: // Sell wheat
                            System.out.println("Wybierz nr pola");
                            int fieldNumber = Integer.parseInt(scanner.nextLine())-1;
                            if(fieldNumber >= myFarmer.getField().size()){
                                System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
                                continue;
                            }
                            Ground chosenField = myFarmer.getSingleField(fieldNumber);
                            if(Objects.equals(chosenField.getState(), "Rośnie zboże")){
                                chosenField.changeState();
                                myFarmer.addCash(7200.00);
                                System.out.println("Z pola zebrano 4,5 tony zboża. Cena zboża to 1 600.00 PLN za 1 tonę.");
                                System.out.println("Na konto przelano 7 200.00 PLN");
                                System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
                            } else {
                                System.out.println("Nie ma zboża na tym polu, wybierz inne pole lub zasiej zboże na tym.");
                            }
                            Action.next();
                            continue;
                        case 4: // Close program
                            break first;
                        default:
                            System.out.println("Wybierz 1-3");
                            break;
                    }
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
