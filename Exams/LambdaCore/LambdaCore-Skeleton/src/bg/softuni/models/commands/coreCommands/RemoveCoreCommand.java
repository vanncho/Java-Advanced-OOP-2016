package bg.softuni.models.commands.coreCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Command;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreDataBase;

public class RemoveCoreCommand extends Command {

    private static final int CORE_NAME_INDEX = 1;

    @Inject
    private CoreDataBase<Core> coreDB;

    protected RemoveCoreCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String name = this.getData()[CORE_NAME_INDEX];

        if (this.coreDB.containsCore(name)) {
            this.coreDB.removeCore(name);
            return String.format(Messages.SUCCESSFULLY_REMOVE_CORE, name);
        }

        return String.format(Messages.FAILED_REMOVE_CORE, name);
    }
}
