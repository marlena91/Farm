package actions;

import animals.Animal;
import area.Ground;
import building.Barn;
import building.Outbuilding;
import farmer.Farmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FieldsManager {

    private Integer minArea = 2;
    private Integer maxArea = 10;
    private List<Ground> randomFarms;

    private final Farmer myFarmer;
    private Scanner scanner;

    public FieldsManager(Farmer myFarmer) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
    }

    public List<Ground> getRandomFarms() {
        return randomFarms;
    }

    public void generateRandomFarms(){
        this.randomFarms = new ArrayList<>();
        RandomInteger size = new RandomInteger(minArea, maxArea);

        for(int i=1; i<=5; i++){
            randomFarms.add(new Ground(size.getRandom()));
        }
    }

//    public void start() {
//        Action.myFields();
//        int fieldActionSelection = Integer.parseInt(scanner.nextLine());
//
//        switch (fieldActionSelection) {
//            case 1:
//                this.buyField();
//                break;
//            case 2:
//                this.sowWheat();
//                break;
//            case 3:
//                this.sellWheat();
//                break;
//            case 4:
////                Action.start(myFarmer);
//                break;
//            default:
//                System.out.println("Wybierz 1-3");
//                break;
//        }
//    }

//    public void buyField() {
//        if (myFarmer.getCash() >= 30000.00) {
//            Action.buyField();
//
//            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//
//            int buyFieldActionSelection = Integer.parseInt(scanner.nextLine());
//
//            switch (buyFieldActionSelection) {
//                case 1:
//                    buyField(1, 60000.00);
//                    break;
//                case 2:
//                    buyField(2, 30000.00);
//                    break;
//                case 3:
//                    buyField(3, 90000.00);
//                    break;
//                case 4:
//                    break;
//                default:
//                    System.out.println("Wybierz 1-4");
//                    break;
//            }
//        } else {
//            System.out.println("Nie masz odpowiedniej kwoty, wróć gdy status Twojego konta będzie wynosił conajmniej 30 000.00 PLN");
//            System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//            Action.next();
//            start();
//        }
//    }

//    public void buyField(Integer type, Double price) {
//        if (type == 1) {
//            myFarmer.addField(new FertileField(), price);
//        } else if (type == 2) {
//            myFarmer.addField(new FloodedField(), price);
//        } else if (type == 3) {
//            myFarmer.addField(new Forest(), price);
//        }
//        System.out.println(myFarmer.getField());
//        Action.next();
//        start();
//    }

//    public void sowWheat() {
//        if (!isSeederInBarn()) {
//            System.out.println("Aby zasiac zboże na swoim polu potrzebujesz zespołu maszyn Traktor + Siewnik.");
//            System.out.println("Czy posiadasz w swojej stodole powyższy ekwipunek? Sprawdź to. Wcisnij enter.");
//            Action.next();
//            buySeeder();
//        }
//
//        int i = 1;
//        for(Ground field : myFarmer.getField()){
//            System.out.println(i+". "+field);
//            i++;
//        }
//        System.out.println("Wybierz nr pola");
//        int fieldNumber = Integer.parseInt(scanner.nextLine()) - 1;
//        if(checkFieldNumber(fieldNumber)){
//            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
//            sowWheat();
//        } else {
//            Ground chosenField = myFarmer.getSingleField(fieldNumber);
//            if (Objects.equals(chosenField.getState(), "Gotowe do wysiewu")) {
////                chosenField.changeState();
//                start();
//            } else {
//                System.out.println("Nie można zasiać na: " + chosenField.getState());
//            }
//            start();
//        }
//    }

    public Boolean checkFieldNumber(Integer fieldNumber){
        return fieldNumber >= myFarmer.getField().size();
    }

    public void sellWheat() {

        int i = 1;
        for(Ground field : myFarmer.getField()){
            System.out.println(i+". "+field);
            i++;
        }
        System.out.println("Wybierz nr pola");
        int fieldNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if(checkFieldNumber(fieldNumber)){
            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
            sellWheat();
        } else {
            Ground chosenField = myFarmer.getSingleField(fieldNumber);
            if (Objects.equals(chosenField.getState(), "Rośnie zboże")) {
//                chosenField.changeState();
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

//    public void buySeeder() {
//        System.out.println("Nie posiadasz siewnika. Czy chcesz zakupić za jedyne 20 000.00 PLN?");
//        Action.yesNo();
//        System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//        int buySeederActionSelection = Integer.parseInt(scanner.nextLine());
//
//        if (buySeederActionSelection == 1) {
//            Barn barn = null;
//            for (Outbuilding building : myFarmer.getBuild()) {
//                if (building.getClass().getSimpleName().equals("Barn")) {
//                    barn = (Barn) building;
//                }
//            }
//            assert barn != null;
//            barn.addSeeder();
//            myFarmer.subtractCash(20000.00);
//            System.out.println("Pomyślnie zakupiono siewnik.");
//            start();
//        } else if (buySeederActionSelection == 2) {
//            start();
//        } else {
//            System.out.println("Wybierz 1-2");
//            buySeeder();
//        }
//    }

    public Boolean isSeederInBarn() {
        Barn barn = null;
        for (Outbuilding building : myFarmer.getBuild()) {
            if (building.getClass().getSimpleName().equals("Barn")) {
                barn = (Barn) building;
                break;
            }
        }
        assert barn != null;
        return barn.getSeeder() != null;
    }



}
