package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Repository;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        this.repository.removeUnit(unitType);
        String toReturn = String.format("%s retired!", unitType);
        return toReturn;
    }
}
