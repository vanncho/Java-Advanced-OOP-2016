package pr01_CommandPatternWithDependencyInjection.models;

import pr01_CommandPatternWithDependencyInjection.annotations.Inject;

public class PrintBooleanCommand extends Command {

    @Inject
    private StringBuilder builder;
    private int someInt;

    public PrintBooleanCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        Boolean value = Boolean.valueOf(this.getData()[1]);

        // няма логика простo за @Inject анотацията
        this.builder.append(Boolean.toString(value));

        return builder.toString();
    }
}
