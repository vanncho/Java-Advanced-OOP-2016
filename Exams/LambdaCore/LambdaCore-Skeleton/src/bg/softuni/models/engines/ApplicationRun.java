package bg.softuni.models.engines;

import bg.softuni.models.constants.Messages;
import bg.softuni.models.interfaces.CoreCommands;
import bg.softuni.models.interfaces.Executable;
import bg.softuni.models.interfaces.FragmentCommands;
import bg.softuni.models.io.reader.Reader;
import bg.softuni.models.io.writer.Writer;

import java.io.IOException;

public class ApplicationRun implements Runnable {

    private CoreCommands coreCommands;
    private FragmentCommands fragmentCommands;
    private Reader reader;
    private Writer writer;

    public ApplicationRun(CoreCommands coreCommands, FragmentCommands fragmentCommands, Reader reader, Writer writer) {
        this.coreCommands = coreCommands;
        this.fragmentCommands = fragmentCommands;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {

        try {

            while (true) {

                String input = this.reader.readLine();

                if (input.equals(Messages.END_COMMAND)) {
                    break;
                }

                String[] data = input.split("@");

                Executable excutableCommand = null;

                if (data[0].startsWith("Attach") || data[0].startsWith("Detach")) {
                    excutableCommand = this.fragmentCommands.interpretCoreCommand(data);
                } else {
                    excutableCommand = this.coreCommands.interpretCoreCommand(data);
                }

                String result = excutableCommand.execute();
                this.writer.writeLine(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
