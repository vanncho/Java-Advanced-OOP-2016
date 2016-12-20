package wasteDisposal.waste;

public abstract class WasteAbstract implements Waste {

    private String name;
    private double volumePerKg;
    private double weight;

    protected WasteAbstract(String name, double volumePerKg, double weight) {
        this.setName(name);
        this.setVolumePerKg(volumePerKg);
        this.setWeight(weight);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    private void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }
}
