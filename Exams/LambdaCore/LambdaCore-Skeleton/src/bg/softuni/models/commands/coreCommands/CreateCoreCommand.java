package bg.softuni.models.commands.coreCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Command;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.enums.CoreType;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreCreator;
import bg.softuni.models.interfaces.CoreDataBase;

public class CreateCoreCommand extends Command {

    private static final int CORE_TYPE_INDEX = 1;
    private static final int CORE_DURABILITY_INDEX = 2;

    @Inject
    private CoreDataBase<Core> coreDB;
    @Inject
    private CoreCreator coreFactory;

    protected CreateCoreCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String coreType = this.getData()[CORE_TYPE_INDEX];
        int durability = Integer.valueOf(getData()[CORE_DURABILITY_INDEX]);


        if (durability >= 0 && (coreType.toUpperCase().equals(CoreType.SYSTEM.name()) || coreType.toUpperCase().equals(CoreType.PARA.name()))) {

            Core core = this.coreFactory.create(coreType, durability);
            this.coreDB.addCore(core);
            return String.format(Messages.CORE_SUCCESSFUL_CREATED, core.getName());
        }

        return Messages.CORE_CREATED_FAIL;
    }
}
