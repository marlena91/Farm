package crops.actions;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class SowingTime {

    LocalDate time;
    Integer start;
    Integer end;

    public SowingTime(LocalDate time, Integer start, Integer end){
        this.time = time;
        this.start = start;
        this.end = end;
    }

    public Boolean checkSowingPeriod(){
        int week = time.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        return (week >= start && week <= end);
    }
}
