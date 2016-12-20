package wasteDisposal.commands.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.commands.CommandAbstract;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.processData.dataBase.ProcessDataBase;
import wasteDisposal.processors.GarbageProcessor;

public class StatusCommand extends CommandAbstract {

    @Inject
    private ProcessingData processingData;
    @Inject
    private GarbageProcessor garbageProcesor;
    @Inject
    private ProcessDataBase processDataBase;

    public StatusCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        double energy = 0d;
        double capital = 0d;

        for (ProcessingData data : this.processDataBase.getProcessingDatas()) {
            energy += data.getEnergyBalance();
            capital += data.getCapitalBalance();
        }
        return String.format("Energy: %.2f Capital: %.2f", energy, capital);
    }
}
