package pr01_CommandPatternWithDependencyInjection.models;

import pr01_CommandPatternWithDependencyInjection.interfaces.Executable;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
