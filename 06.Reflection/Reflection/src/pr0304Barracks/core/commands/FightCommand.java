package pr0304Barracks.core.commands;

public class FightCommand extends Command {

    protected FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
