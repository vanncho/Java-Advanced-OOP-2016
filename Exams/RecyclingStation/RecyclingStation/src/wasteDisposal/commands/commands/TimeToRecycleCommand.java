package wasteDisposal.commands.commands;

import wasteDisposal.commands.CommandAbstract;

public class TimeToRecycleCommand extends CommandAbstract {

    public TimeToRecycleCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "TimeToRecycle";
    }
}
