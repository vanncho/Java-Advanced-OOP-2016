package bg.softuni.models.commands.coreCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Command;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreDataBase;

public class SelectCoreCommand extends Command {

    private static final int CORE_NAME_INDEX = 1;

    @Inject
    private CoreDataBase<Core> coreDB;

    protected SelectCoreCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String name = this.getData()[CORE_NAME_INDEX];

        // TODO: ACTIVE CORE! What happens next?
        if (this.coreDB.containsCore(name)) {
            this.coreDB.selectCore(name);

            return String.format(Messages.CURRENT_CORE_SELECTED_SUCCESSFUL, name);
        }

        return String.format(Messages.CURRENT_CORE_SELECTED_FAILURE, name);
    }
}
