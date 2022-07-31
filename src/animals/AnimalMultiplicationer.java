package animals;

import actions.RandomInteger;
import actions.TimeManager;
import area.Ground;
import building.HouseForPets;
import farmer.Farmer;

import java.util.List;


public class AnimalMultiplicationer {

    private final Farmer myFarmer;
    private final TimeManager time;

    public AnimalMultiplicationer(Farmer myFarmer, TimeManager time) {
        this.myFarmer = myFarmer;
        this.time = time;
    }

    public void animalReproduction(){
        List<HouseForPets> animalBuildings = this.myFarmer.getHousesForPets();
        RandomInteger chanceOfReproduction = new RandomInteger(1, 100);

        for (HouseForPets building : animalBuildings){
            if(chanceOfReproduction.getRandom() <= 10){
                reproduction(building);
            }
        }
    }

    private void reproduction(HouseForPets building){
        if(minTwoAnimals(building) && allAdult(building)){
            building.newAnimal(this.time.getToday());
            System.out.println("W "+building + " zwierzeta rozmnozyly sie, gratulacje!");
        }
    }

    private Boolean minTwoAnimals(HouseForPets building){
        return building.getAnimals().size() >= 2;
    }

    private Boolean allAdult(HouseForPets building) {
        boolean response = false;
        for(Animal animal : building.getAnimals()){
            if (animal.isAdult(this.time.getToday())){
                response = true;
            }
        }
        return response;
    }

}
