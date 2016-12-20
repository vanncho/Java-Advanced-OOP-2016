package wasteDisposal.strategies;

import wasteDisposal.waste.Waste;

public abstract class StrategyAbstract implements GarbageDisposalStrategy {

    protected StrategyAbstract() {
    }

    protected double calculateTotalGarbageVolume(Waste waste) {
        return waste.getWeight() * waste.getVolumePerKg();
    }
}
