package pr01_CommandPatternWithDependencyInjection.models;

public class PrintIntCommand extends Command {

    public PrintIntCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        int value = Integer.valueOf(this.getData()[1]);
        return Integer.toString(value) + " printed!";
    }
}
