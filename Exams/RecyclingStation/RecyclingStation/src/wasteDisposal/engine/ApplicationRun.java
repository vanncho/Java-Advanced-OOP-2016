package wasteDisposal.engine;

import wasteDisposal.commands.CommandInterpreter;
import wasteDisposal.commands.Executable;
import wasteDisposal.constants.Messages;
import wasteDisposal.io.reader.ConsoleReader;
import wasteDisposal.io.reader.Reader;
import wasteDisposal.io.writer.ConsoleWriter;
import wasteDisposal.io.writer.Writer;
import wasteDisposal.strategies.holders.DefaultStrategyHolder;
import wasteDisposal.strategies.holders.StrategyHolder;

import java.io.IOException;

public class ApplicationRun implements Runnable {

    private StrategyHolder strategyHolder;
    private CommandInterpreter commandInterpreter;
    private Reader reader;
    private Writer writer;

    public ApplicationRun(CommandInterpreter commandInterpreter) {
        this.strategyHolder = new DefaultStrategyHolder();
        this.commandInterpreter = commandInterpreter;
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
    }

    @Override
    public void run() {

        try {
            while (true) {

                String input = this.reader.readLine();
                String[] data = input.split(Messages.SPLIT_INPUT_REGEX);

                Executable executableCommand = this.commandInterpreter.interpretCommand(data);
                String result = executableCommand.execute();

                if (result.equals(Messages.END_COMMAND)) {
                    break;
                }

                this.writer.writeLine(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
