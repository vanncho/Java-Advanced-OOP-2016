package wasteDisposal.strategies;

import wasteDisposal.constants.Values;
import wasteDisposal.processData.ConcreteProcessingData;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.waste.Waste;

public class RecyclableStrategy extends StrategyAbstract {

    private ProcessingData dataForProcess;

    public RecyclableStrategy() {
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double energyBalance = Values.RECYCLABLE_GARBAGE_ENERGY_PRODUCED -
                               Values.RECYCLABLE_GARBAGE_ENERGY_USED * calculateTotalGarbageVolume(garbage);
        double capitalBalance = Values.RECYCLABLE_GARBAGE_CAPITAL_EARNED * garbage.getWeight() -
                                Values.RECYCLABLE_GARBAGE_CAPITAL_USED;

        this.dataForProcess = new ConcreteProcessingData(energyBalance, capitalBalance);
        return this.dataForProcess;
    }
}
