package pr01_CommandPatternWithDependencyInjection.models;

import pr01_CommandPatternWithDependencyInjection.annotations.Inject;
import pr01_CommandPatternWithDependencyInjection.interfaces.CommandInterpreter;
import pr01_CommandPatternWithDependencyInjection.interfaces.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE = "pr01_CommandPatternWithDependencyInjection.models.";

    private StringBuilder builder;
    private Thread thread;

    public CommandInterpreterImpl(StringBuilder builder, Thread thread) {
        this.builder = builder;
        this.thread = thread;
    }

    @Override
    public Executable interpretCommand(String commandName, String[] data) {

        Executable exe = null;

        try {
            Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + commandName + "Command");
            Constructor ctor = exeClass.getDeclaredConstructor(String[].class);
            exe = (Executable) ctor.newInstance((Object) data);

            this.resolveDependencies(exe, exeClass);

        } catch (ReflectiveOperationException e) {

            throw new RuntimeException("Invalid command!");
        }

        return exe;
    }

    private void resolveDependencies(Executable exe, Class<Executable> exeClass) throws IllegalAccessException {

        Field[] fields = exeClass.getDeclaredFields();
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

                field.set(exe, theseField.get(this));
            }
        }
    }
}
