package wasteDisposal.commands;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data);
}
