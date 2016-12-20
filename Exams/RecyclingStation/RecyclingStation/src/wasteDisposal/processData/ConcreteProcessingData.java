package wasteDisposal.processData;

public class ConcreteProcessingData implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    public ConcreteProcessingData(double energyBalance, double capitalBalance) {
        this.setEnergyBalance(energyBalance);
        this.setCapitalBalance(capitalBalance);
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}
