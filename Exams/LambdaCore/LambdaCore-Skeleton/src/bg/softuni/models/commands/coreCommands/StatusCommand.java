package bg.softuni.models.commands.coreCommands;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Command;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreDataBase;

import java.util.Map;

public class StatusCommand extends Command {

    @Inject
    private CoreDataBase<Core> coreDB;

    protected StatusCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {

        StringBuilder coreInfo = new StringBuilder();
        int totalDurability = 0;
        int totalFragments = 0;

        for (Map.Entry<String,Core> stringCoreEntry : this.coreDB.getCoreDB().entrySet()) {
            String key = stringCoreEntry.getKey();
            Core currentCore = this.coreDB.getCoreDB().get(key);
            totalDurability += currentCore.getDurability();
            totalFragments += currentCore.getAllFragments().size();
            coreInfo.append(currentCore);
            coreInfo.append(System.lineSeparator());
            coreInfo.setLength(coreInfo.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Lambda Core Power Plant Status:%n"));
        sb.append(String.format("Total Durability: %d%n", totalDurability));
        sb.append(String.format("Total Cores: %d%n", this.coreDB.getSize()));
        sb.append(String.format("Total Fragments: %d%n", totalFragments));

        coreInfo.setLength(coreInfo.length() - 1);
        sb.append(coreInfo.toString());

        return sb.toString();
    }
}
