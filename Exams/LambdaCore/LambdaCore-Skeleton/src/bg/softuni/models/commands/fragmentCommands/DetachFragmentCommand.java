package bg.softuni.models.commands.fragmentCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Command;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreDataBase;
import bg.softuni.models.interfaces.Fragment;

public class DetachFragmentCommand extends Command {

    @Inject
    private CoreDataBase<Core> coreDB;

    protected DetachFragmentCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String fragmentName = null; //// !!! PROBLEM  ????

        if (this.coreDB.getSelectedCore() != null) {
            Core currentCore = this.coreDB.getSelectedCore();
            Fragment fragmentToDetach = currentCore.detachFragment();
            fragmentName = fragmentToDetach.getName();

            return String.format(Messages.FRAGMENT_SUCCESSFULLY_DETACH, fragmentName, currentCore.getName());
        }

        return String.format(Messages.FRAGMENT_FAILURE_DETACH, fragmentName);
    }
}
