package actions;

import area.FertileField;
import area.FloodedField;
import area.Forest;
import area.Ground;
import farmer.Farmer;

import java.util.Objects;
import java.util.Scanner;

public class FieldsManager {

    private final Farmer myFarmer;
    private Scanner scanner;

    public FieldsManager(Farmer myFarmer) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println(myFarmer.getField());
        Action.myFields();
        int fieldActionSelection = Integer.parseInt(scanner.nextLine());
        switch (fieldActionSelection) {
            case 1:
                this.buyField();
                break;
            case 2:
                this.sowWheat();
                break;
            case 3:
                this.sellWheat();
                break;
            case 4:
                break;
            default:
                System.out.println("Wybierz 1-3");
                break;
        }
    }

    public void buyField() {
        if (myFarmer.getCash() >= 30000.00) {
            Action.buyField();

            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");

            int buyFieldActionSelection = Integer.parseInt(scanner.nextLine());

            switch (buyFieldActionSelection) {
                case 1:
                    buyField(1, 60000.00);
                    break;
                case 2:
                    buyField(2, 30000.00);
                    break;
                case 3:
                    buyField(3, 90000.00);
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
    }

    public void buyField(Integer type, Double price) {
        if (type == 1) {
            myFarmer.addField(new FertileField(), price);
        } else if (type == 2) {
            myFarmer.addField(new FloodedField(), price);
        } else if (type == 3) {
            myFarmer.addField(new Forest(), price);
        }
        System.out.println(myFarmer.getField());
        Action.next();
    }

    public void sowWheat() {
        if (!myFarmer.isSeederInBarn()) {
            System.out.println("Aby zasiac zboże na swoim polu potrzebujesz zespołu maszyn Traktor + Siewnik.");
            System.out.println("Czy posiadasz w swojej stodole powyższy ekwipunek? Sprawdź to. Wcisnij enter.");
            Action.next();
            buySeeder();
        }

        System.out.println(myFarmer.getField());
        System.out.println("Wybierz nr pola");
        int fieldNumber = Integer.parseInt(scanner.nextLine()) - 1;
        if(checkFieldNumber(fieldNumber)){
            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
            sowWheat();
        } else {
            Ground chosenField = myFarmer.getSingleField(fieldNumber);
            if (Objects.equals(chosenField.getState(), "Gotowe do wysiewu")) {
                chosenField.changeState();
                System.out.println(myFarmer.getSingleField(fieldNumber));
            } else {
                System.out.println("Nie można zasiać na: " + chosenField.getState());
            }
            Action.next();
        }
    }

    public Boolean checkFieldNumber(Integer fieldNumber){
        return fieldNumber >= myFarmer.getField().size();
    }

    public void sellWheat() {

        System.out.println(myFarmer.getField());

        System.out.println("Wybierz nr pola");
        int fieldNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if(checkFieldNumber(fieldNumber)){
            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
            sellWheat();
        } else {
            Ground chosenField = myFarmer.getSingleField(fieldNumber);
            if (Objects.equals(chosenField.getState(), "Rośnie zboże")) {
                chosenField.changeState();
                myFarmer.addCash(7200.00);
                System.out.println("Z pola zebrano 4,5 tony zboża. Cena zboża to 1 600.00 PLN za 1 tonę.");
                System.out.println("Na konto przelano 7 200.00 PLN");
                System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
            } else {
                System.out.println("Nie ma zboża na tym polu, wybierz inne pole lub zasiej zboże na tym.");
            }
            Action.next();
        }
    }

    public void buySeeder() {
        System.out.println("Nie posiadasz siewnika. Czy chcesz zakupić za jedyne 20 000.00 PLN?");
        Action.yesNo();
        System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
        int buySeederActionSelection = Integer.parseInt(scanner.nextLine());

        if (buySeederActionSelection == 1) {
            myFarmer.buySeeder();
            System.out.println("Pomyślnie zakupiono siewnik.");
            Action.next();
        } else if (buySeederActionSelection == 2) {
            Action.start();
        } else {
            System.out.println("Wybierz 1-2");
            buySeeder();
        }

    }

}
