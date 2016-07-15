package bg.softuni.io.commands;

import bg.softuni.contracts.ContentComparer;
import bg.softuni.contracts.Database;
import bg.softuni.contracts.DirectoryManager;
import bg.softuni.contracts.Downloader;
import bg.softuni.exceptions.InvalidInputException;

public class ReadDatabaseCommand extends Command {

    public ReadDatabaseCommand(String input,
                               String[] data,
                               ContentComparer tester,
                               Database repository,
                               Downloader downloadManager,
                               DirectoryManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileName = data[1];
        this.getRepository().loadData(fileName);
    }
}