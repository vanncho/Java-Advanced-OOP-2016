package wasteDisposal.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.constants.Paths;
import wasteDisposal.factories.WasteCreator;
import wasteDisposal.processData.ProcessingData;
import wasteDisposal.processData.dataBase.ProcessDataBase;
import wasteDisposal.processors.GarbageProcessor;
import wasteDisposal.strategies.holders.StrategyHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private WasteCreator wasteCreator;
    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolder;
    private ProcessingData processingData;
    private ProcessDataBase processDataBase;

    public CommandInterpreterImpl(WasteCreator wasteCreator,
                                  GarbageProcessor garbageProcessor,
                                  StrategyHolder strategyHolder,
                                  ProcessingData processingData,
                                  ProcessDataBase processDataBase) {
        this.wasteCreator = wasteCreator;
        this.garbageProcessor = garbageProcessor;
        this.strategyHolder = strategyHolder;
        this.processingData = processingData;
        this.processDataBase = processDataBase;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        Executable executable = null;

        String commandName = data[0];
        String path = Paths.COMMANDS_PACKAGE_PATH + commandName + "Command";

        try {
            Class executableClass = Class.forName(path);
            @SuppressWarnings("unchecked")
            Constructor constructor = executableClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            executable = (Executable) constructor.newInstance((Object) data);

            this.resolveDependencies(executableClass, executable);
            return executable;

        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException("No such command exists!");
        }
    }

    private void resolveDependencies(Class executableClass, Executable executable) throws IllegalAccessException {

        Field[] fields = executableClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            Field[] theseFields = CommandInterpreterImpl.class.getDeclaredFields();
            for (Field theseField : theseFields) {
                theseField.setAccessible(true);

                if (!theseField.getType().equals(field.getType())) {
                    continue;
                }

                field.set(executable, theseField.get(this));
            }
        }
    }
}
