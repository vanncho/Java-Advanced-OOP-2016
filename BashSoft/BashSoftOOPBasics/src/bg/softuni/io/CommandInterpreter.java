package bg.softuni.io;

import bg.softuni.annotations.Alias;
import bg.softuni.annotations.Inject;
import bg.softuni.contracts.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_LOCATION = "src/bg/softuni/io/commands";
    private static final String COMMANDS_PACKAGE = "bg.softuni.io.commands.";
    private ContentComparer tester;
    private Database repository;
    private Downloader downloadManager;
    private DirectoryManager ioManager;

    public CommandInterpreter(ContentComparer tester,
                              Database repository,
                              Downloader downloadManager,
                              DirectoryManager ioManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception ex) {
            OutputWriter.displayException(ex.getMessage());
        }
    }

    private Executable parseCommand(String input, String[] data, String command) {

        File commandsFolder = new File(COMMANDS_LOCATION);
        Executable executable = null;

        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }

            try {
                String className = file.getName().substring(0, file.getName().lastIndexOf("."));

                Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);

                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }

                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();

                if (!value.equalsIgnoreCase(command)) {
                    continue;
                }

                Constructor exeCtor = exeClass.getConstructor(String.class, String[].class);
                executable = (Executable) exeCtor.newInstance(input, data);

                this.injectDependancies(executable, exeClass);

            } catch (ReflectiveOperationException rfe) {
                rfe.printStackTrace();
            }
        }

        return executable;
    }

    private void injectDependancies(Executable executable, Class<Executable> exeClass)
            throws ReflectiveOperationException {

        Field[] exeFields = exeClass.getDeclaredFields();
        for (Field fieldToSet : exeFields) {
            if (!fieldToSet.isAnnotationPresent(Inject.class)) {
                continue;
            }

            fieldToSet.setAccessible(true);

            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
            for (Field theseField : theseFields) {

                if (!theseField.getType().equals(fieldToSet)) {
                    continue;
                }

                theseField.setAccessible(true);
                fieldToSet.set(executable, theseField.get(this));
            }
        }
    }
}
