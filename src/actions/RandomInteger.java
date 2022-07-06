package actions;

import java.util.concurrent.ThreadLocalRandom;

public class RandomInteger {

    private Integer min;
    private Integer max;

    public RandomInteger(Integer min, Integer max){
        this.min = min;
        this.max = max;
    }

    public Integer getRandom(){
        return ThreadLocalRandom.current().nextInt(this.min, this.max + 1);
    }
}
