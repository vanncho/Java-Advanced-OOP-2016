package bg.softuni.models.factories;

import bg.softuni.models.constants.Messages;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreCreator;
import bg.softuni.models.io.writer.ConsoleWriter;
import bg.softuni.models.io.writer.Writer;

import java.lang.reflect.Constructor;

public class CoreFactory implements CoreCreator {

    private int coreName;
    private Writer writer;

    public CoreFactory() {
        this.setCoreName(Messages.CORE_NAME_START);
        this.writer = new ConsoleWriter();
    }

    private void setCoreName(int value) {
        this.coreName = value;
    }

    private int getCoreName() {
        return coreName;
    }

    @Override
    public Core create(String coreType, int durability) {
        Core core = null;
        String coreName = ((char) this.getCoreName()) + "";

        try {
            Class coreClass = Class.forName(Messages.CORES_PACKAGE_PATH + coreType + Messages.CORE_NAME);
            Constructor ctor = coreClass.getConstructor(String.class, int.class);
            core = (Core) ctor.newInstance(coreName, durability);

            this.setCoreName(this.getCoreName() + 1);
            return core;

        } catch (ReflectiveOperationException roe) {
            return null;
        }
    }
}
