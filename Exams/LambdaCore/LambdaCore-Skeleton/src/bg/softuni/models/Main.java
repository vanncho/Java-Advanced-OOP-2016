package bg.softuni.models;

import bg.softuni.models.collections.CoreMap;
import bg.softuni.models.collections.LStack;
import bg.softuni.models.commands.coreCommands.CoreCommandsImpl;
import bg.softuni.models.commands.fragmentCommands.FragmentCommandImpl;
import bg.softuni.models.engines.ApplicationRun;
import bg.softuni.models.engines.Runnable;
import bg.softuni.models.factories.CoreFactory;
import bg.softuni.models.factories.FragmentFactory;
import bg.softuni.models.interfaces.*;
import bg.softuni.models.io.reader.ConsoleReader;
import bg.softuni.models.io.reader.Reader;
import bg.softuni.models.io.writer.ConsoleWriter;
import bg.softuni.models.io.writer.Writer;

public class Main {
    public static void main(String[] args) {

        CoreDataBase<Core> coreData = new CoreMap();
        CoreCreator coreFactory = new CoreFactory();
        CoreCommands coreCommands = new CoreCommandsImpl(coreData, coreFactory);

        FragmentStack<Fragment> fragmentStack = new LStack<>();
        FragmentCreator fragmentFactory = new FragmentFactory();
        FragmentCommands fragmentCommands = new FragmentCommandImpl(fragmentStack, fragmentFactory, coreData);

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Runnable applicationRun = new ApplicationRun(coreCommands, fragmentCommands, reader, writer);
        applicationRun.run();
    }
}
