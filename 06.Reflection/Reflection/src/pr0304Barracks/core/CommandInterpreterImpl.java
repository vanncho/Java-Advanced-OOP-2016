package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE = "pr0304Barracks.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Character firstChar = commandName.toUpperCase().charAt(0);
        String path = COMMANDS_PACKAGE + firstChar + commandName.substring(1) + "Command";
        Executable executable = null;

        try {
            Class executableClass = Class.forName(path);
            Constructor constructor = executableClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            executable = (Executable) constructor.newInstance((Object) data);

            this.injectDependencies(executable, executableClass);

        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }
        return executable;
    }

    private void injectDependencies(Executable executable, Class executableClass) throws IllegalAccessException {

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
