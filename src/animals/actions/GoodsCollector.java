package animals.actions;

import actions.TimeManager;
import animals.Animal;
import farmer.Farmer;

public class GoodsCollector {

    private final Farmer myFarmer;
    private final TimeManager time;

    public GoodsCollector(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
    }

    public void collect(){
        System.out.println("");
        System.out.println("Za sprzedane dobra: ");
        for(Animal animal : this.myFarmer.getAllAnimals()){
            if (animal.isAdult(this.time.getToday())){
                System.out.println("\t"+animal.collect());
            }
        }
        Double profit = this.myFarmer.getAllAnimals().size() *300.00;

        System.out.println(" zarabiasz: "+profit);
        this.myFarmer.addCash(profit);
    }
}
