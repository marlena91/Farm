package actions;

import animals.actions.AnimalFeeder;
import animals.actions.AnimalMultiplicationer;
import animals.actions.GoodsCollector;
import area.actions.EventsCreator;
import crops.actions.PlantsManager;
import farmer.Farmer;

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
            System.out.println("");
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
}
