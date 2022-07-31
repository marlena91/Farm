package crops.interfaces;


import java.time.LocalDate;

public interface Seedable {
    Double costOfPlanting();

    Integer getSeedingStart();

    Integer getSeedingEnd();

    Integer getNumberOfWeekToHarvest();

    String getSeedingPeriod();

    LocalDate getDateOfSeed();

    void setDateOfSeed(LocalDate dateOfSeed);

    String getStatus(LocalDate today);

    long howManyWeeksAfterPlanting(LocalDate today);
}
