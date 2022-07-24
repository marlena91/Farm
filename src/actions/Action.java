package actions;

import animals.Animal;
import animals.AnimalsManager;
import area.FieldsManager;
import area.Ground;
import building.BuildingsManager;
import crops.Plant;
import crops.PlantsManager;
import crops.Seedable;
import farmer.Farmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Action {

    private Farmer myFarmer;
    private TimeManager time;
    private BuildingsManager buildingsManager;
    private FieldsManager fieldsManager;
    private PlantsManager plantsManager;
    private AnimalsManager animalsManager;

    static Scanner scanner = new Scanner(System.in);

    public Action(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
        this.buildingsManager = new BuildingsManager(this.myFarmer);
        this.fieldsManager = new FieldsManager(this.myFarmer, this.time, this);
        this.plantsManager = new PlantsManager(this.myFarmer, this.time, this, this.buildingsManager);
        this.animalsManager = new AnimalsManager(this.myFarmer, this.time, this, this.buildingsManager);
    }

    public void newWeek() {
        System.out.println("");
        this.time.start();
        System.out.println(this.myFarmer);
        this.fieldsManager.generateRandomFarms();
        this.mainChoices();
    }

    public void startText() {
        System.out.println("");
        System.out.println("Wybierz akcję: ");
        System.out.println("1. Zakup farmy");
        System.out.println("2. Zakup/sprzedaz ziemi uprawnej");
        System.out.println("3. Zakup nowych budynkow");
        System.out.println("4. Zakup zwierzat lub roslin");
        System.out.println("5. Posadzenie roslin");
        System.out.println("6. Zbiory roslin");
        System.out.println("7. Sprzedaz roslin lub zwierzat");
        System.out.println("8. Sprawdzenie stanu zapasow");
        System.out.println("9. Przejrzenie informacji o posiadanych zwierzetach");
        System.out.println("10. Przejrzenie informacji o posiadanych sadzonkach i asadzonych roslinach");
        System.out.println("11. Podsumowanie tygodnia - przejdz do nastepnej rundy");
    }

    public void mainChoices() {
        this.startText();

        System.out.println("test: " + myFarmer.getFields());
        String selectAction = scanner.nextLine();

        if (Objects.equals(selectAction, "1")) {
            this.buyNewFarm();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "2")) {
            this.buyOrSellNewField();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "3")) {
            this.buyNewBuilding();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "4")) {
            this.buyAnimalsOrPlants();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "5")) {
            this.plantingPlants();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "6")) {
            this.plantHarvesting();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "7")) {
            this.sale();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "8")) {
            System.out.println("Sprawdzenie stanu zapasow");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "9")) {
            System.out.println("Przejrzenie informacji o posiadanych zwierzetach");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "10")) {
            System.out.println("Przejrzenie informacji o posiadanych sadzonkach i zasadzonych roslinach");
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "11")) {
            System.out.println("Koniec tygodnia");
            this.endWeek();
        } else {
            System.out.println("Wybierz od 1-10");
            this.mainChoices();
        }
    }

    public void endWeek() {
        System.out.println("Dzieja sie rozne rzeczy");
        System.out.println("Robaki zjadaja plony");
        if (myFarmer.getCash() <= 0) {
            System.out.println("Zwierzeta chudna ");
        }
        this.time.addWeek();
        this.next();
        this.newWeek();
    }

    public void next() {
        System.out.println("");
        System.out.println("Dalej? Wciśnij enter.");
        scanner.nextLine();
    }

    public void buyNewFarm() {
        System.out.println("");
        System.out.println("Farmy dostepne w tym tygodniu: ");
        int i = 1;
        for (Ground field : fieldsManager.getRandomFarms()) {
            System.out.println(i + ". " + field);
            i++;
        }
        this.fieldsManager.buyFarm();
        this.next();
        this.mainChoices();
    }

    public void buyOrSellNewField() {
        System.out.println("");
        this.checkingIfFarmerHasFarm();
        System.out.println("Aktualnie posiadasz " + this.fieldsManager.getFarmArea() + "ha pola uprawnego na swoich farmach " +
                "oraz " + this.myFarmer.getAdditionalArea().size() + "ha pola uprawnego, poza Twoimi farmami");
        System.out.println("Czy chcesz dokupic pola uprawne?");
        this.fieldsManager.buyAdditionalFertileField();
    }

    public void checkingIfFarmerHasFarm() {
        if (this.fieldsManager.getFarmArea() == 0) {
            System.out.println("Nie masz jeszcze farmy. Udaj sie do punktu 1 i zakup swoja pierwsza farme");
            this.next();
            this.mainChoices();
        }
    }

    public void buyNewBuilding() {
        System.out.println("");
        if (this.buildingsManager.avalaiblePlacesForBuildings() == 0) {
            System.out.println("Nie masz dostepnego miejsca na nowe budynki. Udaj sie do punktu 1 i dokup farme z wolnym miejscem");
            this.next();
            this.mainChoices();
        }
        this.buildingsManager.getBuildings();
    }

    public void buyAnimalsOrPlants() {
        System.out.println("");
        System.out.println("1. Kup nasiona/sadzonki");
        System.out.println("2. Kup male zwierze");
        System.out.println("0. Cofnij");
        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            this.plantsManager.buySeeds();
        } else if (Objects.equals(select, "2")) {
            this.animalsManager.buyAnimal();
        } else if (Objects.equals(select, "0")) {
            this.mainChoices();
        } else {
            System.out.println("Wybierz 1-2");
            this.buyAnimalsOrPlants();
        }
    }

    public void plantingPlants() {
        System.out.println("");
        this.checkingIfFarmerHasFarm();
        if (this.fieldsManager.checkingIsFreeArea() > 0) {
            this.checkingHasFarmerSeeds();
        } else {
            System.out.println("Nie masz wolnych hektarów do zasadzenia roślin. W celu zakupienia nowej ziemi idź do punktu 1 lub 2.");
        }
    }

    public void checkingHasFarmerSeeds() {
        if (this.myFarmer.getPlants() == null) {
            System.out.println("Nie masz roslin. Wroc i zakup jakies rosliny.");
            this.next();
        } else {
            this.plantsManager.choosePlantList();
        }
    }

    public void plantHarvesting() {
        System.out.println("Wybierz:");
        int i = 1;
        for (Seedable crop : this.myFarmer.getCrops()) {
            System.out.println(i + ". " + crop + ", status: \"" + crop.getStatus(this.time.getToday()) + "\"");
            i++;
        }
        this.plantsManager.harvestCrop();
        System.out.println("test: " + this.myFarmer.getCrops());
    }

    public void sale(){
        System.out.println("");
        System.out.println("1. Sprzedaz roslin");
        System.out.println("2. Sprzedaz zwierzat");
        System.out.println("0. Cofnij");
        String select = scanner.nextLine();

        if (Objects.equals(select, "1")) {
            this.salePlants();
        } else if(Objects.equals(select, "2")) {
            this.saleAnimals();
        } else if(Objects.equals(select, "0")) {
            System.out.println("");
        } else {
            System.out.println("Wybierz 1 lub 2");
            this.sale();
        }

        //wypisac wszystkie rosliny z barnu i zwierzeta z dopiskiem za
        //po wybraniu
        //usun rosline/zwierze
        //dodaj kase
    }

    public void salePlants(){
        if(this.myFarmer.getPlantStock().size()>0){
            for(Plant plant : this.myFarmer.getPlantStock()){
                System.out.println(plant);
            }
            this.plantsManager.chooseItemForSale();
        } else {
            System.out.println("BRAK");
            this.next();
        }
    }

    public void saleAnimals(){
        if(this.myFarmer.getAllAnimals().size()>0){
            for(Animal animal : this.myFarmer.getAllAnimals()){
                System.out.println(animal);
            }
            this.animalsManager.chooseItemForSale();
        } else {
            System.out.println("BRAK");
            this.next();
        }
    }





}
