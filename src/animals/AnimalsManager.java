package animals;

import actions.Action;
import area.Ground;
import building.BuildingsManager;
import actions.TimeManager;
import farmer.Farmer;
import animals.Salable;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AnimalsManager {

    private final Farmer myFarmer;
    private final TimeManager time;
    private final Action action;
    private final BuildingsManager buildingsManager;
    private Scanner scanner;


    public AnimalsManager(Farmer myFarmer, TimeManager time, Action action, BuildingsManager buildingsManager) {
        this.myFarmer = myFarmer;
        this.time = time;
        this.action = action;
        this.buildingsManager = buildingsManager;
        this.scanner = new Scanner(System.in);
    }

    public void buyAnimal(){
        System.out.println("");
        System.out.println("Jakie zwierze chcesz dokupic do swojej farmy: ");
        System.out.println("1. Krowy ");
        System.out.println("2. Pszczoly");
        System.out.println("3. Psy");
        System.out.println("4. Kozy");
        System.out.println("5. Kury");
        System.out.println("6. Konie");
        System.out.println("7. Swinie");
        System.out.println("8. Owce");
        System.out.println("0. Cofnij");

        String select = scanner.nextLine();

        if (Objects.equals(select, "1")) {
            System.out.println("");
            Cow cow = new Cow();
            this.checkIsBuildingAvailable(cow, "Cowshed", "Obora");
        } else if (Objects.equals(select, "2")) {
            System.out.println("");
            Bee bee = new Bee();
            this.checkIsBuildingAvailable(bee, "BeeYard", "Pasieka");
        } else if (Objects.equals(select, "3")) {
            System.out.println("");
            Dog dog = new Dog();
            this.checkIsBuildingAvailable(dog, "Doghouse", "Zagroda dla psow");
        } else if (Objects.equals(select, "4")) {
            System.out.println("");
            Goat goat = new Goat();
            this.checkIsBuildingAvailable(goat, "Farm", "Zagroda");
        } else if (Objects.equals(select, "5")) {
            System.out.println("");
            Hen hen = new Hen();
            this.checkIsBuildingAvailable(hen, "Henhouse", "Kurnik");
        } else if (Objects.equals(select, "6")) {
            System.out.println("");
            Horse horse = new Horse();
            this.checkIsBuildingAvailable(horse, "Stable", "Stajnia");
        } else if (Objects.equals(select, "7")) {
            System.out.println("");
            Pig pig = new Pig();
            this.checkIsBuildingAvailable(pig, "Pigsty", "Chlew");
        } else if (Objects.equals(select, "8")) {
            System.out.println("");
            Sheep sheep = new Sheep();
            this.checkIsBuildingAvailable(sheep, "Farm", "Zagroda");
        } else if (Objects.equals(select, "0")) {
            System.out.println("");
        } else {
            System.out.println("Wybierz 1-8");
            this.buyAnimal();
        }
    }

    public void checkIsBuildingAvailable(Animal animal, String className, String buildingName ){
        if(this.buildingsManager.checkBuildingInFarm(className)){
            animal.info();
            this.buyAnimal(animal, className);
        } else {
            System.out.println("Nie posiadasz wymaganego budynku do przechowywania tych zwierzat. Wroc do punktu 3 i kup budynek: "+buildingName);
        }
    }

    public void buyAnimal(Animal animal, String className){
        System.out.println("");
        System.out.println("Kupic za " + animal.getCost() + "PLN?");
        System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
        System.out.println("1.TAK");
        System.out.println("0.NIE");
        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            myFarmer.addAnimal(animal, animal.getCost(), className);
            animal.setDateOfBuy(this.time.getToday());
        } else if (Objects.equals(select, "0")) {
            System.out.println("");
        } else {
            System.out.println("Zly wybor");
            this.buyAnimal(animal, className);
        }
    }

    public void chooseItemForSale(){
        String number = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (Objects.equals(number, "0") || !pattern.matcher(number).matches()) {
            this.action.sale();
        } else {
            int intNumber = Integer.parseInt(number);
            this.checkingChosenItem(intNumber);
        }
    }

    public void checkingChosenItem(Integer number){
        if (!checkAnimalNumberForSell(number)) {
            System.out.println("Zly numer zwierzecia. Wybierz jeszcze raz.");
            this.action.saleAnimals();
        } else {
            Salable chosenAnimal = (Salable) this.getSingleAnimal(number - 1);
            this.myFarmer.deleteAnimal((Animal) chosenAnimal, chosenAnimal.getHouse());
            this.myFarmer.addCash(chosenAnimal.getPrice());
            System.out.println("Pomyślnie sprzedano zwierzę");
        }
    }

    public Boolean checkAnimalNumberForSell(Integer number) {
        return number <= this.myFarmer.getAllAnimals().size();
    }

    public Animal getSingleAnimal(Integer nr) {
        return this.myFarmer.getAllAnimals().get(nr);
    }


}

