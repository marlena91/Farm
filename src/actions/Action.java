package actions;

import animals.*;
import animals.actions.AnimalsManager;
import area.actions.FieldsManager;
import area.Ground;
import building.actions.BuildingsManager;
import crops.interfaces.Harvestable;
import crops.Plant;
import crops.actions.PlantsManager;
import crops.interfaces.Seedable;
import farmer.Farmer;

import java.util.Objects;
import java.util.Scanner;

public class Action {

    private final Farmer myFarmer;
    private final TimeManager time;
    private final BuildingsManager buildingsManager;
    private final FieldsManager fieldsManager;
    private final PlantsManager plantsManager;
    private final AnimalsManager animalsManager;

    static Scanner scanner = new Scanner(System.in);

    public Action(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
        this.buildingsManager = new BuildingsManager(this.myFarmer);
        this.fieldsManager = new FieldsManager(this.myFarmer, this);
        this.plantsManager = new PlantsManager(this.myFarmer, this.time, this, this.buildingsManager);
        this.animalsManager = new AnimalsManager(this.myFarmer, this.time, this, this.buildingsManager);
    }

    public void firstDay(){
        System.out.println("\n");
        System.out.println("Witaj, "+this.myFarmer.getName()+"!");
        System.out.println("\n");
        System.out.println("Dzisiaj otrzymales odpowiedz na swoje podanie dotyczace dotacji z Unii Europejskiej");
        System.out.println("Przydzielono Ci 2 miliony zlotych. Zarzadzaj nimi odpowiednio i uzyskaj status rolnika doskonalego. Powodzenia!");
        System.out.println("\n");
        System.out.println("Gre wygrywasz w momencie:");
        System.out.println("\t~ posiadania minimum 20 hektarow ziemi,");
        System.out.println("\t~ minimum 5 roznych gatunkow upraw przechowywanych w Twojej stodole");
        System.out.println("\t~ oraz minimum 5 roznych gatunkow zwierzat.");
        System.out.println("Powodzenia!");
        System.out.println("\n");
        System.out.println("P.S. W pierwszej kolejnosci pomysl o stodole, bez niej nie bedziesz mial gdzie przechowywac swoich upraw.");
        System.out.println("\n");
        this.next();
        this.newWeek();
    }

    public void newWeek() {
        System.out.println("\n");
        this.time.start();
        System.out.println(this.myFarmer);
        this.fieldsManager.generateRandomFarms();
        this.mainChoices();
    }

    public void startText() {
        System.out.println("\n");
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
        System.out.println("11. Przejrzenie informacji o posiadanej ziemi");
        System.out.println("12. Data, gotowka");
        System.out.println("13. Podsumowanie tygodnia - przejdz do nastepnej rundy");
    }

    public void mainChoices() {
        this.startText();
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
            this.stockCheck();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "9")) {
            this.animalInfo();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "10")) {
            this.plantsInfo();
            this.next();
            this.mainChoices();
        }else if (Objects.equals(selectAction, "11")) {
            this.fieldsInfo();
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "12")) {
            System.out.println("Dzisiejsza data: "+this.time.getToday());
            System.out.println("Twoja dostepna gotowka: "+this.myFarmer.getCash());
            this.next();
            this.mainChoices();
        } else if (Objects.equals(selectAction, "13")) {
            System.out.println("Koniec tygodnia");
            this.endWeek();
        } else {
            System.out.println("Wybierz od 1-10");
            this.mainChoices();
        }
    }

    public void endWeek() {
        EndWeek endWeek = new EndWeek(this.myFarmer, this.time, this.plantsManager);
        endWeek.feedAnimals();
        endWeek.reproductionAnimals();
        endWeek.randomEvent();
        endWeek.collectGoods();
        endWeek.protectionAgainstPests();

        endWeek.checkIfWon();

        this.time.addWeek();
        this.next();
        this.newWeek();
    }

    public void next() {
        System.out.println("\n");
        System.out.println("Dalej? Wciśnij enter.");
        scanner.nextLine();
    }

    public void buyNewFarm() {
        System.out.println("\n");
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
        System.out.println("\n");
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
        System.out.println("\n");
        if (this.buildingsManager.availablePlacesForBuildings() == 0) {
            System.out.println("Nie masz dostepnego miejsca na nowe budynki. Udaj sie do punktu 1 i dokup farme z wolnym miejscem");
            this.next();
            this.mainChoices();
        }
        this.buildingsManager.getBuildings();
    }

    public void buyAnimalsOrPlants() {
        System.out.println("\n");
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
        System.out.println("\n");
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
        this.listCrops();
        this.plantsManager.harvestCrop();
    }

    public void listCrops() {
        if (this.myFarmer.getCrops().size() <= 0) {
            System.out.println("Brak upraw");
        } else {
            int i = 1;
            for (Seedable crop : this.myFarmer.getCrops()) {
                System.out.println(i + ". " + crop + ", status: \"" + crop.getStatus(this.time.getToday()) + "\"");
                i++;
            }
        }
    }

    public void sale() {
        System.out.println("\n");
        System.out.println("1. Sprzedaz roslin");
        System.out.println("2. Sprzedaz zwierzat");
        System.out.println("0. Cofnij");
        String select = scanner.nextLine();

        if (Objects.equals(select, "1")) {
            this.salePlants();
        } else if (Objects.equals(select, "2")) {
            this.saleAnimals();
        } else if (Objects.equals(select, "0")) {
            System.out.println("\n");
        } else {
            System.out.println("Wybierz 1 lub 2");
            this.sale();
        }
    }

    public void salePlants() {
        System.out.println("\n");
        System.out.println("Wybierz: ");
        if (this.myFarmer.getPlantStock().size() > 0) {
            int i = 1;
            for (Plant plant : this.myFarmer.getPlantStock()) {
                Harvestable plantToSell = (Harvestable) plant;
                System.out.format(i + ". " + plant + " cena za 1kg to " + plantToSell.getPricePerKilo() + "PLN dostępne tony: %.1f%n", plantToSell.getCurrentAmount());
                i++;
            }
            this.plantsManager.chooseItemForSale();
        } else {
            System.out.println("BRAK");
            this.next();
        }
    }

    public void saleAnimals() {
        if (this.myFarmer.getAllAnimals().size() > 0) {
            int i = 1;
            for (Animal animal : this.myFarmer.getAllAnimals()) {
                System.out.println(i + ". " + animal + " - sprzedaj za " + animal.getPrice() + "PLN");
                i++;
            }
            this.animalsManager.chooseItemForSale();
        } else {
            System.out.println("BRAK");
            this.next();
        }
    }

    public void stockCheck() {
        System.out.println("\n");
        if (myFarmer.getPlantStock().size() > 0) {
            System.out.println("Twoje zapasy (w tonach): ");
            int i = 1;
            for (Plant plant : myFarmer.getPlantStock()) {
                Harvestable plantTons = (Harvestable) plant;
                System.out.format(i + ". " + plant + " " + "%.1f%n", plantTons.getCurrentAmount());
                i++;
            }
        } else {
            System.out.println("Brak zapasow");
        }
    }

    public void animalInfo() {
        System.out.println("\n");
        if (myFarmer.getAllAnimals().size() > 0) {
            System.out.println("Twoje zwierzeta - przeglad: ");
            int i = 1;
            for (Animal animal : myFarmer.getAllAnimals()) {
                System.out.println(i + ". " + animal);
                animal.animalInfoDetailed(this.time.getToday());
                i++;
            }
        } else {
            System.out.println("Brak zwierzat");
        }
    }

    public void plantsInfo() {
        System.out.println("\n");
        System.out.println("Twoje aktualne uprawy: ");
        listCrops();

        System.out.println("\n");
        if (this.myFarmer.getPlants().size() <= 0) {
            System.out.println("Brak nasion i sadzonek");
        } else {
            int i = 1;
            System.out.println("Twoje nasiona i sadzonki:");
            for (Plant plant : this.myFarmer.getPlants()) {
                System.out.println(i + " ." + plant);
                i++;
            }
        }
    }

    public void fieldsInfo(){
        System.out.println("\n");
        System.out.println("Twoja ziemia: ");
        System.out.println(this.myFarmer.getFields());
    }
}
