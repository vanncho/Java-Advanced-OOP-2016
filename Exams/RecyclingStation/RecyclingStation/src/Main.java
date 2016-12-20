import wasteDisposal.commands.CommandInterpreter;
import wasteDisposal.commands.CommandInterpreterImpl;
import wasteDisposal.engine.ApplicationRun;
import wasteDisposal.engine.Runnable;
import wasteDisposal.factories.WasteCreator;
import wasteDisposal.factories.WasteFactory;
import wasteDisposal.processData.ConcreteProcessingData;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.processData.dataBase.ConcreteProcessDataBase;
import wasteDisposal.processData.dataBase.ProcessDataBase;
import wasteDisposal.processors.DefaultGarbageProcessor;
import wasteDisposal.processors.GarbageProcessor;
import wasteDisposal.strategies.holders.DefaultStrategyHolder;
import wasteDisposal.strategies.holders.StrategyHolder;

public class Main {
    public static void main(String[] args) {

        WasteCreator wasteCreator = new WasteFactory();
        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        ProcessingData processingData = new ConcreteProcessingData(0, 0);
        ProcessDataBase processDataBase = new ConcreteProcessDataBase();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(wasteCreator, garbageProcessor, strategyHolder, processingData, processDataBase);
        Runnable applicationRun = new ApplicationRun(commandInterpreter);
        applicationRun.run();
    }
}
