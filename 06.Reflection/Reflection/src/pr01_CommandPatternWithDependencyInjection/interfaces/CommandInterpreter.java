package pr01_CommandPatternWithDependencyInjection.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String commandName, String[] data);
}
