package bg.softuni.io.commands;

import bg.softuni.annotations.Alias;
import bg.softuni.annotations.Inject;
import bg.softuni.contracts.Downloader;
import bg.softuni.exceptions.InvalidInputException;

@Alias("downloadasynch")
public class DownloadAsynchCommand extends Command {

    @Inject
    private Downloader downloadManager;

    public DownloadAsynchCommand(String input, String[] data) {
        super(input, data);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileUrl = data[1];
        this.downloadManager.downloadOnNewThread(fileUrl);
    }
}
