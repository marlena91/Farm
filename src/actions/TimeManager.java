package actions;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeManager {

    private String today;
    private Integer weeksCounter;

    public TimeManager(){
        this.today = "2020-01-01";
        this.weeksCounter = 1;
    }

    public void start(){
        System.out.println("Dzisiejsza data: "+this.getToday());
        System.out.println("Tydzien nr: "+this.getWeeksCounter());
    }

    public LocalDate getToday() {
        return LocalDate.parse(this.today);
    }

    public Integer getWeeksCounter() {
        return this.weeksCounter;
    }

    public void addWeek() {
        LocalDate date = LocalDate.parse(this.today).plusWeeks(1);
        this.today = date.toString();
        this. weeksCounter += 1;
    }


}
