package actions;

import animals.Animal;
import animals.Salable;
import crops.Harvestable;
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

            if (!Objects.equals(food, "") && getFoodWeight(animal)>0) {
                checkHasFarmerPlantsInStock(animal, food);
            } else if(Objects.equals(food, "") && getFoodWeight(animal)>0) {
                feedingWithMoney(animal);
            }
        }
    }

    private void checkHasFarmerPlantsInStock(Animal animal, String food){
        if(hasFarmerPlantsInStock() && foodIsInStock(getPlant(food))){
            Harvestable foodPlant = (Harvestable) getPlant(food);
            feedingWithFood(animal, foodPlant);
        } else {
            feedingWithMoney(animal);
        }
    }

    private Boolean foodIsInStock(Plant plant){
        return plant!=null;
    }

    private Plant getPlant(String food){
        Plant foodPlant = null;
        for (Plant plant : this.myFarmer.getPlantStock()) {
            if (plant.getClass().getSimpleName().equals(food)) {
                foodPlant = plant;
            }
        }
        return foodPlant;
    }

    private void feedingWithFood(Animal animal, Harvestable foodPlant){
        Double foodWeight = getFoodWeight(animal);
        if (foodPlant.getCurrentAmount() >= foodWeight) {
            removePlant(foodPlant, foodWeight);
            System.out.println("ZWIERZE TYJE TEST");
            animal.gainingWeight(this.time.getToday());
        } else {
            double difference = foodWeight - foodPlant.getCurrentAmount();
            foodPlant.removingKilos(difference);
            foodWeight -= difference;
            System.out.println("Zabraklo rosliny pozostala czesc zaplata gotowki");
            feedingWithMoney(animal, foodWeight);
        }
    }

    private void feedingWithMoney(Animal animal){
        System.out.println("test: Sprobuje nakarmic pieniedzmi");
    }

    private void feedingWithMoney(Animal animal, Double foodWeight){
        System.out.println("test: zabraklo rosli, pozostala czesc probuje nakarmic pieniedzmi");
        animal.gainingWeight(this.time.getToday());
        System.out.println("ZWIERZE TYJE TEST");

    }

    private Double getFoodWeight(Animal animal) {
        return animal.getKilosOfFood() / 1000;
    }

    private Boolean hasFarmerPlantsInStock(){
        return this.myFarmer.getPlantStock().size() > 0;
    }

    private void removePlant(Harvestable foodPlant, Double foodWeight){
        Double currentAmount = foodPlant.getCurrentAmount();
        if (currentAmount >= foodWeight) {
            double newAmount = currentAmount - foodWeight;
            foodPlant.setCurrentAmount(newAmount);
        } else {
            this.myFarmer.removePlantFromStock((Plant) foodPlant);
        }
    }
}


//
//

//                        KARMIENIE ROSLINAMI

//
//
//                               feedingWithPlants();
//                                  if (foodPlant.getCurrentAmount() >= foodWeight) {
//                                      foodPlant.removingKilos(foodWeight);
//                                      System.out.println("ZWIERZE TYJE TEST");
//                                      animal.gainingWeight(this.time.getToday());
//                                      break;
//                                  } else {
//                                      double difference = foodWeight - foodPlant.getCurrentAmount();
//                                      foodPlant.removingKilos(difference);
//                                      foodWeight -= difference;
//                                  }
//                                  System.out.println("TEST: FOODWEIGHT " + foodWeight);
//                                  System.out.println("ZWIERZE TYJE TEST");
//                                  animal.gainingWeight(this.time.getToday());
//



//                                  Double moneyNeeded = foodWeight * 500.00;
//                                  System.out.println("TEST POTRZEBNA KASA NA WYKARMIENIE : " + moneyNeeded);
//                                  if (this.myFarmer.getCash() >= moneyNeeded) {
//                                      System.out.println(plant + "TEST: Inne jedzenie tu pobiore po porstu kase");
//                                      System.out.println("TEST: KASA przed: " + this.myFarmer.getCash());
//                                      this.myFarmer.subtractCash(moneyNeeded);
//                                      System.out.println("TEST: KASA po: " + this.myFarmer.getCash());
//                                      System.out.println("ZWIERZE TYJE TEST");
//                                      animal.gainingWeight(this.time.getToday());
//                                  } else {
//                                      System.out.println("TEST: ZWIERZE CHUDNIE, bo nie ma kasy na jedzwenie");
//                                      System.out.println("ZWIERZE WAZY: " + animal.getWeight());
//                                      if (animal.getWeight() <= 0) {
//                                          Salable dieAnimal = (Salable) animal;
//                                          this.myFarmer.deleteAnimal(animal, dieAnimal.getHouse());
//                                      }
//                                      System.out.println("TEST: Zwierze umiera");
//                                  }
//                              }
//                          }
//


                    //karmienie pieniedzmi
//                              Double moneyNeeded = foodWeight * 500.00;
//                              System.out.println("TEST: Farmer nie ma zadnych roslin");
//                              System.out.println("TEST POTRZEBNA KASA NA WYKARMIENIE : " + moneyNeeded);
//                              if (this.myFarmer.getCash() >= moneyNeeded) {
//                                  System.out.println("TEST: KASA przed: " + this.myFarmer.getCash());
//                                  this.myFarmer.subtractCash(moneyNeeded);
//                                  System.out.println("TEST: KASA po: " + this.myFarmer.getCash());
//                                  System.out.println("ZWIERZE TYJE TEST");
//                                  animal.gainingWeight(this.time.getToday());
//                              } else {
//                                  System.out.println("TEST: ZWIERZE CHUDNIE, bo nie ma kasy na jedzwenie");
//                                  animal.losingWeight();
//                                      if (animal.getWeight() <= 0) {
//                                          Salable dieAnimal = (Salable) animal;
//                                          this.myFarmer.deleteAnimal(animal, dieAnimal.getHouse());
//                                      }
//                                  System.out.println("TEST: Zwierze umiera");
//                              }
//                         }
