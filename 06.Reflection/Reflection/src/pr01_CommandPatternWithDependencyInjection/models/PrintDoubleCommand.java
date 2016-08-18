package pr01_CommandPatternWithDependencyInjection.models;

import pr01_CommandPatternWithDependencyInjection.annotations.Inject;

public class PrintDoubleCommand extends Command {

    @Inject
    private Thread decimalSpaces;

    public PrintDoubleCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        double value = Double.valueOf(this.getData()[1]);
        return Double.toString(value) + " printed!";
    }
}
