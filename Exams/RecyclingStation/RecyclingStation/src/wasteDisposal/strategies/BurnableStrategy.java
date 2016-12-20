package wasteDisposal.strategies;

import wasteDisposal.annotations.Inject;
import wasteDisposal.constants.Values;
import wasteDisposal.processData.ConcreteProcessingData;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.waste.Waste;

public class BurnableStrategy extends StrategyAbstract {

    @Inject
    private ProcessingData dataForProcess;

    public BurnableStrategy() {
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double energyBalance = Values.BURNABLE_GARBAGE_ENERGY_PRODUCED * calculateTotalGarbageVolume(garbage) -
                               Values.BURNABLE_GARBAGE_ENERGY_USED * calculateTotalGarbageVolume(garbage);

        double capitalBalance = Values.BURNABLE_GARBAGE_CAPITAL_EARNED - Values.BURNABLE_GARBAGE_CAPITAL_USED;

        this.dataForProcess = new ConcreteProcessingData(energyBalance, capitalBalance);
        return this.dataForProcess;
    }
}
