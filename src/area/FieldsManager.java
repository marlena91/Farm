package area;

import actions.Action;
import actions.TimeManager;
import farmer.Farmer;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FieldsManager {

    private final Farmer myFarmer;
    private Scanner scanner;
    private Action action;
    private Time time;
    private List<Ground> randomFarms;


    public FieldsManager(Farmer myFarmer, TimeManager time, Action action) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
        this.action = action;
    }
    public void generateRandomFarms() {
        this.randomFarms = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            randomFarms.add(new RandomFarm().generateRandomFarm());
        }
    }
    public List<Ground> getRandomFarms() {
        return randomFarms;
    }

    public void buyFarm() {
        System.out.println("");
        System.out.println("Wybierz nr farmy do zakupu. Jesli chcesz zrezygnowac wcisnij '0'");
        System.out.println("Twoja dostepna gotowka: " + myFarmer.getCash() + " PLN");

        String farmNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (Objects.equals(farmNumber, "0") || !pattern.matcher(farmNumber).matches()) {
            this.action.mainChoices();
        } else {
            int farmIntNumber = Integer.parseInt(farmNumber);
            this.checkingChosenFarm(farmIntNumber);
        }
    }
    public void checkingChosenFarm(Integer farmIntNumber){
        if (!checkFarmNumberForSell(farmIntNumber)) {
            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
            this.buyFarm();
        } else {
            Ground chosenFarm = this.getSingleFarm(farmIntNumber - 1);
            this.finalPurchaseFarm(chosenFarm);
        }
    }

    public void finalPurchaseFarm(Ground chosenFarm){
        if (myFarmer.getCash() <= chosenFarm.getValue()) {
            System.out.println("Za mało pieniędzy na zakup tej działki");
        } else {
            myFarmer.addFarm(chosenFarm);
            this.randomFarms.remove(chosenFarm);
            myFarmer.subtractCash(chosenFarm.getValue());
            System.out.println("Pomyślnie zakupiono ziemię.");
        }
    }

    public Boolean checkFarmNumberForSell(Integer farmNumber) {
        return farmNumber <= this.randomFarms.size();
    }


    public Ground getSingleFarm(Integer nr) {
        return this.randomFarms.get(nr);
    }


    public Integer getFarmArea(){
        Integer totalFarmArea = 0;
        for(Ground field : myFarmer.getFarms()){
            totalFarmArea += field.getArea();
        }
        return totalFarmArea;
    }

    public void buyAdditionalFertileField(){
        System.out.println("");
        System.out.println("1. Tak, chce dokupic 1ha pola za 600tys");
        if(this.myFarmer.getAdditionalArea().size()>=1){
            System.out.println("2. Chce sprzedac moje pola uprawne");
        }
        System.out.println("0. Nie, dziekuje. Wroc do menu glownego");
        String select = scanner.nextLine();

        if(Objects.equals(select, "1")){
            this.finalPurchaseAddField();
        } else if(this.myFarmer.getAdditionalArea().size()>=1 & Objects.equals(select, "2")){
           this.finalyBuyOrNo();
        } else if (Objects.equals(select, "0")){
            this.action.mainChoices();
        } else {
            System.out.println("Zly wybor");
            this.buyAdditionalFertileField();
        }
        this.action.next();
        this.action.mainChoices();
    }

    public void finalyBuyOrNo(){
        System.out.println("Sprzedasz 1ha swojej dodatkowej ziemi uprawnej, stracisz uprawy, jeśli jakies na niej są");
        System.out.println("Na 1ha zarobisz 400tys");
        System.out.println("1.TAK");
        System.out.println("0.NIE");
        String select2 = scanner.nextLine();
        if (Objects.equals(select2, "1")) {
            this.myFarmer.subtractAdditionalFertileField();
        } else if (Objects.equals(select2, "0")) {
            this.buyAdditionalFertileField();
        } else {
            System.out.println("Zly wybor");
            this.finalyBuyOrNo();
        }
    }

    public void finalPurchaseAddField(){
        if(this.myFarmer.getCash() >=600000.00){
            this.myFarmer.addField(new FertileField());
            this.myFarmer.subtractCash(600000.00);
            System.out.println("Pomyslnie zakupiono ziemie");
        } else {
            System.out.println("Za malo pieniedzy na zakup tej ziemi ");
        }
    }

    public Integer checkingIsFreeArea(){
        Integer freeArea = 0;
        for(Field field : myFarmer.getFields()){
            freeArea += field.getFreeArea();
        }
        return freeArea;
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


//
//    public void sellWheat() {
//
//        int i = 1;
//        for(Ground field : myFarmer.getField()){
//            System.out.println(i+". "+field);
//            i++;
//        }
//        System.out.println("Wybierz nr pola");
//        int fieldNumber = Integer.parseInt(scanner.nextLine()) - 1;
//
//        if(checkFieldNumber(fieldNumber)){
//            System.out.println("Nie ma takiego pola. Wybierz jeszcze raz.");
//            sellWheat();
//        } else {
//            Ground chosenField = myFarmer.getSingleField(fieldNumber);
//            if (Objects.equals(chosenField.getState(), "Rośnie zboże")) {
////                chosenField.changeState();
//                myFarmer.addCash(7200.00);
//                System.out.println("Z pola zebrano 4,5 tony zboża. Cena zboża to 1 600.00 PLN za 1 tonę.");
//                System.out.println("Na konto przelano 7 200.00 PLN");
//                System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
//            } else {
//                System.out.println("Nie ma zboża na tym polu, wybierz inne pole lub zasiej zboże na tym.");
//            }
//            Action.next();
//        }
//    }
//
////    public void buySeeder() {
////        System.out.println("Nie posiadasz siewnika. Czy chcesz zakupić za jedyne 20 000.00 PLN?");
////        Action.yesNo();
////        System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
////        int buySeederActionSelection = Integer.parseInt(scanner.nextLine());
////
////        if (buySeederActionSelection == 1) {
////            Barn barn = null;
////            for (Outbuilding building : myFarmer.getBuild()) {
////                if (building.getClass().getSimpleName().equals("Barn")) {
////                    barn = (Barn) building;
////                }
////            }
////            assert barn != null;
////            barn.addSeeder();
////            myFarmer.subtractCash(20000.00);
////            System.out.println("Pomyślnie zakupiono siewnik.");
////            start();
////        } else if (buySeederActionSelection == 2) {
////            start();
////        } else {
////            System.out.println("Wybierz 1-2");
////            buySeeder();
////        }
////    }
//
//    public Boolean isSeederInBarn() {
//        Barn barn = null;
//        for (Outbuilding building : myFarmer.getBuild()) {
//            if (building.getClass().getSimpleName().equals("Barn")) {
//                barn = (Barn) building;
//                break;
//            }
//        }
//        assert barn != null;
//        return barn.getSeeder() != null;
//    }
//
//

}
