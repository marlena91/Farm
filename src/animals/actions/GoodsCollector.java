package animals.actions;

import actions.TimeManager;
import animals.Animal;
import farmer.Farmer;

import java.util.ArrayList;
import java.util.List;

public class GoodsCollector {

    private final Farmer myFarmer;
    private final TimeManager time;

    public GoodsCollector(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
    }

    public void collect(){
        System.out.println("");
        int i = 0;
        List<String> goods = new ArrayList<>();
        for(Animal animal : this.myFarmer.getAllAnimals()){
            if (animal.isAdult(this.time.getToday())){

                goods.add(animal.collect());
                i ++;
            }
        }

        if(i>0){
            System.out.println("Codziennie robiles obchod swojej farmy, zbierajac dobra od swoich zwierzat");
            System.out.println("Za zebrane: "+goods);
            Double profit = i *300.00;
            System.out.println(" zarabiasz: "+profit);
            this.myFarmer.addCash(profit);
        }


    }
}
