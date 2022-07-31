package area.actions;

import actions.RandomInteger;
import actions.TimeManager;
import crops.actions.PlantsManager;
import crops.interfaces.Seedable;
import farmer.Farmer;

import java.util.Arrays;
import java.util.List;

public class EventsCreator {

    private final Farmer myFarmer;
    private final PlantsManager plantsManager;

    public EventsCreator(Farmer myFarmer, PlantsManager plantsManager) {
        this.myFarmer = myFarmer;
        this.plantsManager = plantsManager;
    }

    public void createRandomEvent(){
        List<String> events = Arrays.asList(
                "Niespodziewanie nad Twoimi polami przeszlo tornado, zniszczylo cakowicie jedna z Twoich upraw: ",
                "Ogromna ulewa spowodowala powodz wymyla jedno z Twoich pol razem z cala roslinnoscia na nim zasiana: ",
                "Robak typu stonka urzadzil sobie na jednym z Twoich pole impreze, calkowicie zniszczyl jedno pole z: ",
                "To byl zwykly sloneczny dzien kiedy na jednym z Twoich pol wyladowalo UFO teraz nie masz juz roslin masz kregi na: ",
                "Strajk GMO okupuje jedno z Twoich pol, calkowicie zniszyli uprawe: "
        );

        RandomInteger randomEvent = new RandomInteger(0, 4);
        String event = events.get(randomEvent.getRandom());

        RandomInteger randomCrop = new RandomInteger(0, this.myFarmer.getCrops().size()-1);
        Seedable crop = this.myFarmer.getCrops().get(randomCrop.getRandom());

        this.myFarmer.subtractCrop(crop);
        this.plantsManager.giveFreeArea();
        System.out.println(event + crop);
    }
}
