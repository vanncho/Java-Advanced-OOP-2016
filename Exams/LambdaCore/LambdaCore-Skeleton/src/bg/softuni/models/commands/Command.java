package bg.softuni.models.commands;

import bg.softuni.models.interfaces.Executable;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return this.data;
    }
}
