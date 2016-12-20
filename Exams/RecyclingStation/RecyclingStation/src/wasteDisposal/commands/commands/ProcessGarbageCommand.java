package wasteDisposal.commands.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.commands.CommandAbstract;
import wasteDisposal.constants.Messages;
import wasteDisposal.constants.Paths;
import wasteDisposal.factories.WasteCreator;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.processData.dataBase.ProcessDataBase;
import wasteDisposal.processors.GarbageProcessor;
import wasteDisposal.strategies.GarbageDisposalStrategy;
import wasteDisposal.strategies.holders.StrategyHolder;
import wasteDisposal.waste.Waste;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class ProcessGarbageCommand extends CommandAbstract {

    @Inject
    private WasteCreator wasteCreator;
    @Inject
    private GarbageProcessor garbageProcessor;
    @Inject
    private StrategyHolder strategyHolder;
    @Inject
    private ProcessDataBase processDataBase;

    public ProcessGarbageCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {

        String wasteName = this.getData()[1];
        double weight = Double.valueOf(this.getData()[2]);
        double volumePerKg = Double.valueOf(this.getData()[3]);
        String garbageType = this.getData()[4];

        Waste waste = this.wasteCreator.create(wasteName, volumePerKg, weight, garbageType);
        Annotation[] annotations = waste.getClass().getAnnotations();

        GarbageDisposalStrategy garbageDisposalStrategy = null;

        try {
            Class strategy = Class.forName(Paths.STRATEGIES_PACKAGE_PATH + this.getData()[4] + "Strategy");
            @SuppressWarnings("unchecked")
            Constructor constructor = strategy.getDeclaredConstructor();
            garbageDisposalStrategy = (GarbageDisposalStrategy) constructor.newInstance();

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        this.strategyHolder.addStrategy(annotations[0].annotationType(), garbageDisposalStrategy);
        ProcessingData currentProcessingData = this.garbageProcessor.processWaste(waste);
        this.processDataBase.getProcessingDatas().add(currentProcessingData);

        return String.format(Messages.PROCESS_GARABAGE_SUCCSESSFUL, weight, wasteName);
    }
}
