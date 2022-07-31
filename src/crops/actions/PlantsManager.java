package crops.actions;

import actions.Action;
import actions.TimeManager;
import area.interfaces.Field;
import building.actions.BuildingsManager;
import crops.*;
import crops.interfaces.Harvestable;
import crops.interfaces.Seedable;
import farmer.Farmer;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PlantsManager {

    private final Farmer myFarmer;
    private final Scanner scanner;
    private final Action action;
    private final TimeManager time;
    private final BuildingsManager buildingsManager;

    public PlantsManager(Farmer myFarmer, TimeManager time, Action action, BuildingsManager buildingsManager) {
        this.myFarmer = myFarmer;
        this.scanner = new Scanner(System.in);
        this.action = action;
        this.time = time;
        this.buildingsManager = buildingsManager;
    }


    public void buySeeds() {
        System.out.println("\n");
        System.out.println("W naszej ofercie mamy dostepne nastepujace produkty: ");
        System.out.println("1. Nasiona buraka");
        System.out.println("2. Nasiona marchewki");
        System.out.println("3. Nasiona salaty");
        System.out.println("4. Bulwy ziemniakow");
        System.out.println("5. Sadzonki jabloni");
        System.out.println("6. Ziarna pszenicy");
        System.out.println("0. Cofnij");

        String select = scanner.nextLine();
        System.out.println("\n");

        if (Objects.equals(select, "1")) {
            Beetroot beetroot = new Beetroot();
            beetroot.info();
            this.buySeeds(beetroot);
        } else if (Objects.equals(select, "2")) {
            Carrot carrot = new Carrot();
            carrot.info();
            this.buySeeds(carrot);
        } else if (Objects.equals(select, "3")) {
            Lettuce lettuce = new Lettuce();
            lettuce.info();
            this.buySeeds(lettuce);
        } else if (Objects.equals(select, "4")) {
            Potato potato = new Potato();
            potato.info();
            this.buySeeds(potato);
        } else if (Objects.equals(select, "5")) {
            Apple apple = new Apple();
            apple.info();
            this.buySeeds(apple);
        } else if (Objects.equals(select, "6")) {
            Wheat wheat = new Wheat();
            wheat.info();
            this.buySeeds(wheat);
        } else if (Objects.equals(select, "0")) {
            this.action.buyAnimalsOrPlants();
        } else {
            System.out.println("Wybierz 1-6");
            this.buySeeds();
        }
    }

    public void buySeeds(Plant plant) {
        System.out.println("\n");
        System.out.println("Kupic za " + plant.getCost() + "PLN?");
        System.out.println("Aktualny stan konta: " + myFarmer.getCash() + " PLN");
        System.out.println("1.TAK");
        System.out.println("0.NIE");
        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            myFarmer.addPlant(plant);
        } else if (Objects.equals(select, "0")) {
            System.out.println("\n");
        } else {
            System.out.println("Zly wybor");
        }
    }

    public void choosePlantList() {
        if (myFarmer.getPlants().isEmpty()) {
            System.out.println("Brak zakupionych nasion lub sadzonek. Wróc do punktu 4");
            this.action.mainChoices();
        }
        System.out.println("Wybierz rosline z dostepnych zakupionych jaka chcesz zasadzic: ");
        int i = 1;
        for (Plant plant : myFarmer.getPlants()) {
            System.out.println(i + ". " + plant + " - " + plant.costOfPlanting() + "PLN");
            i++;
        }
        System.out.println("Twoja dostepna gotowka: " + myFarmer.getCash() + " PLN");

        String plantNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (Objects.equals(plantNumber, "0") || !pattern.matcher(plantNumber).matches()) {
            this.action.mainChoices();
        } else {
            this.choosePlant(Integer.parseInt(plantNumber));
        }
    }

    public void choosePlant(Integer plantNumber) {
        if (!checkPlantNumberForSow(plantNumber)) {
            System.out.println("Nie ma rosliny o tym numerze. Wybierz jeszcze raz.");
            this.choosePlantList();
        } else {
            Plant chosenPlant = this.getSinglePlant(plantNumber - 1);
            Boolean seedTime = new SowingTime(this.time.getToday(), chosenPlant.getSeedingStart(), chosenPlant.getSeedingEnd()).checkSowingPeriod();
            this.finalSeedPurchase(chosenPlant, seedTime);
        }
    }

    public void finalSeedPurchase(Plant chosenPlant, Boolean seedTime) {
        if (myFarmer.getCash() >= chosenPlant.costOfPlanting() && seedTime) {
            myFarmer.subtractCash(chosenPlant.costOfPlanting());
            this.subtractFreeArea();
            myFarmer.addCrop(chosenPlant);
            this.myFarmer.subtractPlant(chosenPlant);
            chosenPlant.setDateOfSeed(this.time.getToday());
            System.out.println("Pomyślnie zasiano.");
        } else if (myFarmer.getCash() >= chosenPlant.costOfPlanting() && !seedTime) {
            System.out.println("To nie jest czas na zasadzenie " + chosenPlant);
            System.out.println("Aktualna data to: " + this.time.getToday());
            System.out.println("Okres sadzenia " + chosenPlant + " : " + chosenPlant.getSeedingPeriod());
        } else {
            System.out.println("Za mało pieniędzy na zasadzenie tej rosliny");
        }
    }

    public Boolean checkPlantNumberForSow(Integer plantNumber) {
        return plantNumber <= myFarmer.getPlants().size();
    }

    public Plant getSinglePlant(Integer nr) {
        return myFarmer.getPlants().get(nr);
    }

    public void subtractFreeArea() {
        for (Field field : this.myFarmer.getFields()) {
            if (field.getFreeArea() > 0) {
                field.subtractFreeArea();
                break;
            }
        }
    }

    public void giveFreeArea(){
        for (Field field : this.myFarmer.getFields()) {
            if (field.getFreeArea() < field.getArea()) {
                field.giveFreeArea();
                break;
            }
        }
    }

    public void harvestCrop() {
        System.out.println("\n");
        if (this.buildingsManager.checkBuildingInFarm("Barn")) {
            this.chooseCropToHarvest();
        } else {
            System.out.println("Zebrane uprawy musisz przechowywac w Stodole");
            System.out.println("Wroc do punktu 3 i kup Stodole");
            this.action.next();
            this.action.mainChoices();
        }
    }

    public void chooseCropToHarvest() {
        System.out.println("Wybierz uprawe. Jesli chcesz zrezygnowac wcisnij '0'");
        System.out.println("Twoja dostepna gotowka: " + myFarmer.getCash() + " PLN");

        String cropNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (Objects.equals(cropNumber, "0") || !pattern.matcher(cropNumber).matches()) {
            this.action.mainChoices();
        } else {
            int cropIntNumber = Integer.parseInt(cropNumber);
            this.checkingChosenCrop(cropIntNumber);
        }
    }

    public void harvestCrop(Harvestable crop) {
        System.out.println("\n");
        System.out.println("Chcesz zebrac " + crop);
        System.out.println("Koszt zbioru to: " + crop.getCostOfHarvest() + "PLN");
        System.out.println("1.Zbierz");
        System.out.println("0.Cofnij");
        String select = scanner.nextLine();
        if (Objects.equals(select, "1")) {
            this.finallyHarvestCrop(crop);
        } else if (Objects.equals(select, "0")) {
            this.harvestCrop();
        } else {
            System.out.println("Zly wybor");
        }
    }

    public void finallyHarvestCrop(Harvestable crop) {
        if (this.myFarmer.getCash() >= crop.getCostOfHarvest()) {
            this.myFarmer.subtractCrop((Seedable) crop);
            this.giveFreeArea();
            this.myFarmer.subtractCash(crop.getCostOfHarvest());
            this.myFarmer.addPlantToStock((Plant) crop);
            crop.setCurrentAmount(crop.getCropYields());
            System.out.println("Pomyślnie zebrano " + crop + " - " + crop.getCropYields() + " ton");
        } else {
            System.out.println("Nie stac Cie na zbior roslin");
        }
    }

    public void checkingChosenCrop(Integer cropIntNumber) {
        if (!checkCropNumberForHarvest(cropIntNumber)) {
            System.out.println("Zly numer uprawy. Wybierz jeszcze raz.");
            this.harvestCrop();
        } else {
            Seedable chosenCrop = this.getSingleCrop(cropIntNumber - 1);
            this.infoAboutCrop(chosenCrop);
        }
    }

    public Boolean checkCropNumberForHarvest(Integer cropNumber) {
        return cropNumber <= this.myFarmer.getCrops().size();
    }


    public Seedable getSingleCrop(Integer nr) {
        return this.myFarmer.getCrops().get(nr);
    }

    public void infoAboutCrop(Seedable crop) {
        if (Objects.equals(crop.getStatus(this.time.getToday()), "ROŚNIE")) {
            int weeks = Math.toIntExact(crop.getNumberOfWeekToHarvest() - crop.howManyWeeksAfterPlanting(this.time.getToday()));
            System.out.println("Musisz zaczekac jeszcze " + weeks + " tygodni");
        } else {
            this.harvestCrop((Harvestable) crop);
        }
    }

    public void chooseItemForSale() {
        String number = scanner.nextLine();
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        try {
            if (Objects.equals(number, "0") || !pattern.matcher(number).matches()) {
                this.action.sale();
            } else {
                int intNumber = Integer.parseInt(number);
                this.checkingChosenItem(intNumber);
            }
        } catch(NumberFormatException e) {
            System.err.println("Zla liczba");
        }


    }

    public void checkingChosenItem(Integer number) {
        if (!checkCropNumberForSell(number)) {
            System.out.println("Zly numer. Wybierz jeszcze raz.");
            this.action.salePlants();
        } else {
            Harvestable chosenPlant = this.getSinglePlantStock(number - 1);
            System.out.println("Ile ton chcesz sprzedac z dostępnych " + chosenPlant.getCurrentAmount());
            String amount = scanner.nextLine();
            try {
                double amountOfTons = Double.parseDouble(amount);
                chosenPlant.removingKilos(amountOfTons);
                if (chosenPlant.getCurrentAmount() == 0) {
                    this.myFarmer.removePlantFromStock((Plant) chosenPlant);
                }
                Double price = amountOfTons * (chosenPlant.getPricePerKilo() * 1000);
                this.myFarmer.addCash(price);
                System.out.println("Pomyślnie sprzedano");
            } catch(NumberFormatException e) {
                System.err.println("Wybierz liczbe calkowita");
            }
        }
    }

    public Boolean checkCropNumberForSell(Integer number) {
        return number <= this.myFarmer.getPlantStock().size();
    }

    public Harvestable getSinglePlantStock(Integer nr) {
        return (Harvestable) this.myFarmer.getPlantStock().get(nr);
    }
}

