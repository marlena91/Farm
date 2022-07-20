package crops;


import java.time.LocalDate;

public interface Seedable {
    Double costOfPlanting();
    Integer getSeedingStart();
    Integer getSeedingEnd();
    String getSeedingPeriod();
    LocalDate getDateOfSeed();
    void setDateOfSeed(LocalDate dateOfSeed);
}
