package wasteDisposal.commands;

public abstract class CommandAbstract implements Executable {

    private String[] data;

    protected CommandAbstract(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
