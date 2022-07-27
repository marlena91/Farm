package crops;

public interface Harvestable {
    Double getCostOfHarvest();
    Double getCropYields();
    void setCurrentAmount(Double amount);
    Double getCurrentAmount();
    Double getPricePerKilo();
}
