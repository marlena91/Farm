package actions;

import animals.Animal;
import animals.actions.AnimalFeeder;
import animals.actions.AnimalMultiplicationer;
import animals.actions.GoodsCollector;
import area.actions.EventsCreator;
import crops.actions.PlantsManager;
import crops.interfaces.Seedable;
import farmer.Farmer;

import java.util.ArrayList;

public class EndWeek {

    private final Farmer myFarmer;
    private final TimeManager time;
    private final PlantsManager plantsManager;

    public EndWeek(Farmer myFarmer, TimeManager time, PlantsManager plantsManager) {
        this.myFarmer = myFarmer;
        this.time = time;
        this.plantsManager = plantsManager;
    }

    public void feedAnimals(){
        if (this.myFarmer.getAllAnimals().size() > 0) {
            System.out.println("\n");
            System.out.println("Karmienie zwierzat ...");
            AnimalFeeder animalFeeder = new AnimalFeeder(this.myFarmer, this.time);
            animalFeeder.feedingAnimals();
            System.out.println("..... karmienie zakonczone");
        }
    }

    public void reproductionAnimals(){
        if (this.myFarmer.getAllAnimals().size() > 0) {
            AnimalMultiplicationer animalMultiplicationer = new AnimalMultiplicationer(this.myFarmer, this.time);
            animalMultiplicationer.animalReproduction();
        }
    }

    public void randomEvent(){
        RandomInteger chanceOfRandomEvent = new RandomInteger(1, 100);
        if(chanceOfRandomEvent.getRandom() <= 5 && !this.myFarmer.getCrops().isEmpty()){
            EventsCreator eventsCreator = new EventsCreator(this.myFarmer, this.plantsManager);
            eventsCreator.createRandomEvent();
        }
    }

    public void collectGoods(){
        if(!myFarmer.getAllAnimals().isEmpty()){
            GoodsCollector goodsCollector = new GoodsCollector(this.myFarmer, this.time);
            goodsCollector.collect();
        }
    }

    public void protectionAgainstPests(){
        if(!myFarmer.getCrops().isEmpty()){
            Double cost = myFarmer.getCrops().size() * 300.00;
            System.out.println("\n");
            System.out.println("Ponosisz cotygodniowe koszty ochrony przed szkodnikami "+ cost+ "PLN");
            this.myFarmer.subtractCash(cost);
        }
    }
    
    public void checkIfWon(){
        if(hasTwentyHectares() && fulfillAnimalsCondition() && fulfillCropsCondition()){
            System.out.println("\n\n\n****************************************** G R A T U L A C J E ! ! ! ! ! ! ! ******************************************");
            System.out.println("WYGRALES!!!! ZOSTALES ROLNIKIEM DOSKONALYM!!! BRAWO!!!!!");
            System.out.println("\n spelniles wszystkie warunki posiadasz 20ha ziemi, 5 roznych rodzajow zwierzat i 5 roznych rodzajow upraw w sojej stodole");
            System.out.println("\n****************************************** G R A T U L A C J E ! ! ! ! ! ! ! ******************************************");
        }
    }
    
    private Boolean hasTwentyHectares(){
        return this.myFarmer.sumOfAllFields() >= 20;
    }
    
    private Boolean fulfillAnimalsCondition(){
        ArrayList<String> animalsClasses = new ArrayList<>();
        for(Animal animal : this.myFarmer.getAllAnimals()){
            animalsClasses.add(animal.getClass().getName());
        }
        return removeDuplicates(animalsClasses).size() >=5;
    }

    private Boolean fulfillCropsCondition(){
        ArrayList<String> cropsClasses = new ArrayList<>();
        for(Seedable crop : this.myFarmer.getCrops()){
            cropsClasses.add(crop.getClass().getName());
        }
        return removeDuplicates(cropsClasses).size() >=5;
    }

    public ArrayList<String> removeDuplicates(ArrayList<String> list){
        ArrayList<String> newList = new ArrayList<>();
        for (String element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

}
