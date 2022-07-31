package animals.actions;

import actions.TimeManager;
import animals.Animal;
import crops.interfaces.Harvestable;
import crops.Plant;
import farmer.Farmer;

import java.util.Objects;

public class AnimalFeeder {

    private final Farmer myFarmer;
    private final TimeManager time;

    public AnimalFeeder(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
    }

    public void feedingAnimals() {
        for (Animal animal : this.myFarmer.getAllAnimals()) {

            String food = animal.getTypeOfFood();

            if (!Objects.equals(food, "") && getFoodWeight(animal) > 0) {
                checkHasFarmerPlantsInStock(animal, food);
            } else if (Objects.equals(food, "") && getFoodWeight(animal) > 0) {
                feedingWithMoney(animal);
            }
        }
    }

    private void checkHasFarmerPlantsInStock(Animal animal, String food) {
        if (hasFarmerPlantsInStock() && foodIsInStock(getPlant(food))) {
            Harvestable foodPlant = (Harvestable) getPlant(food);
            feedingWithFood(animal, foodPlant);
        } else {
            feedingWithMoney(animal);
        }
    }

    private Boolean foodIsInStock(Plant plant) {
        return plant != null;
    }

    private Plant getPlant(String food) {
        Plant foodPlant = null;
        for (Plant plant : this.myFarmer.getPlantStock()) {
            if (plant.getClass().getSimpleName().equals(food)) {
                foodPlant = plant;
            }
        }
        return foodPlant;
    }

    private void feedingWithFood(Animal animal, Harvestable foodPlant) {
        Double foodWeight = getFoodWeight(animal);
        if (foodPlant.getCurrentAmount() >= foodWeight) {
            removePlant(foodPlant, foodWeight);
            animal.gainingWeight(this.time.getToday());
        } else {
            double difference = foodWeight - foodPlant.getCurrentAmount();
            foodPlant.removingKilos(difference);
            foodWeight -= difference;
            feedingWithMoney(animal, foodWeight);
        }
    }

    private void feedingWithMoney(Animal animal) {
        feedingWithMoney(animal, animal.getKilosOfFood());
    }

    private void feedingWithMoney(Animal animal, Double foodWeight) {
        Double priceForFood = foodWeight * 25.00;
        if (myFarmer.getCash() >= priceForFood) {
            this.myFarmer.subtractCash(priceForFood);
            animal.gainingWeight(this.time.getToday());
        } else {
            animal.losingWeight();
            if (animal.getWeight() <= 0) {
                this.myFarmer.deleteAnimal(animal, animal.getHouse());
                System.out.println("Brak gotowki na zakup jedzenia Twoje zwierzta umieraja");
            }
        }
    }

    private Double getFoodWeight(Animal animal) {
        return animal.getKilosOfFood() / 1000;
    }

    private Boolean hasFarmerPlantsInStock() {
        return this.myFarmer.getPlantStock().size() > 0;
    }

    private void removePlant(Harvestable foodPlant, Double foodWeight) {
        Double currentAmount = foodPlant.getCurrentAmount();
        if (currentAmount >= foodWeight) {
            double newAmount = currentAmount - foodWeight;
            foodPlant.setCurrentAmount(newAmount);
        } else {
            this.myFarmer.removePlantFromStock((Plant) foodPlant);
        }
    }
}