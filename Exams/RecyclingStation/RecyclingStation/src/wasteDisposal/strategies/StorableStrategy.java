package wasteDisposal.strategies;

import wasteDisposal.constants.Values;
import wasteDisposal.processData.ConcreteProcessingData;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.waste.Waste;

public class StorableStrategy extends StrategyAbstract {

    private ProcessingData dataForProcess;

    public StorableStrategy() {
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double energyBalance = Values.STORABLE_GARBAGE_ENERGY_PRODUCED -
                               Values.STORABLE_GARBAGE_ENERGY_USED * calculateTotalGarbageVolume(garbage);
        double capitalBalance = Values.STORABLE_GARBAGE_CAPITAL_EARNED -
                                Values.STORABLE_GARBAGE_CAPITAL_USED * calculateTotalGarbageVolume(garbage);

        this.dataForProcess = new ConcreteProcessingData(energyBalance, capitalBalance);
        return this.dataForProcess;
    }
}
