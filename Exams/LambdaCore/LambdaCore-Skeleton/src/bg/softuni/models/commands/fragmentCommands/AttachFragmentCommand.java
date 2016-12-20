package bg.softuni.models.commands.fragmentCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Command;
import bg.softuni.models.constants.Messages;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.models.factories.FragmentFactory;
import bg.softuni.models.interfaces.*;

public class AttachFragmentCommand extends Command {

    @Inject
    private CoreDataBase<Core> coreDB;

    protected AttachFragmentCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {

        Core currentCore = null;
        String fragmentType = this.getData()[1];
        String fragmentName = this.getData()[2];
        int pressureAffection = Integer.valueOf(this.getData()[3]);
        boolean attach = false;

        if (this.coreDB.getSelectedCore() != null &&
                (fragmentType.toUpperCase().equals(FragmentType.COOLING.name()) ||
                fragmentType.toUpperCase().equals(FragmentType.NUCLEAR.name())) &&
                pressureAffection >= 0) {

            currentCore = this.coreDB.getSelectedCore();
            FragmentCreator fragment = new FragmentFactory();
            Fragment fragmentToAttach = fragment.create(fragmentType, fragmentName, pressureAffection);
            currentCore.attachFragment(fragmentToAttach);
            attach = currentCore.shouldAddTheFragment();
        }

        if (attach) {
            return String.format(Messages.FRAGMENT_SUCCESSFULLY_ATTACHED, fragmentName, currentCore.getName());
        }

        return String.format(Messages.FRAGMENT_FAILURE_ATTACHED, fragmentName);
    }
}
