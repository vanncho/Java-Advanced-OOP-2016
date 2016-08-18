package pr01_CommandPatternWithDependencyInjection.models;

public class EndCommand extends Command {

    public EndCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "End";
    }
}
