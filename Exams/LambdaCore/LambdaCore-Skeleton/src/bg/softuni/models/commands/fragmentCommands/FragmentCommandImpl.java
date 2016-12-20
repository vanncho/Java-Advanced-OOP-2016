package bg.softuni.models.commands.fragmentCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class FragmentCommandImpl implements FragmentCommands {

    private CoreDataBase<Core> coreDb;
    private FragmentStack<Fragment> fragmentDb;
    private FragmentCreator fragmentCreator;

    public FragmentCommandImpl(FragmentStack<Fragment> fragmentDb, FragmentCreator fragmentCreator, CoreDataBase<Core> coreDb) {
        this.fragmentDb = fragmentDb;
        this.fragmentCreator = fragmentCreator;
        this.coreDb = coreDb;
    }

    @Override
    public Executable interpretCoreCommand(String[] data) {
        Executable executable = null;
        String commandName = data[0].substring(0, data[0].length() - 1);
        String path = Messages.FRAGMENTS_COMMANDS_PACKAGE + commandName + "Command";

        try {
            Class executableClass = Class.forName(path);
            Constructor ctor = executableClass.getDeclaredConstructor(String[].class);
            ctor.setAccessible(true);
            executable = (Executable) ctor.newInstance((Object) data);

            this.injectDependencies(executable, executableClass);

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
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

            Field[] theseFields = FragmentCommandImpl.class.getDeclaredFields();
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
