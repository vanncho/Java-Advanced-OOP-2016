package bg.softuni.models.interfaces;

import java.util.Map;

public interface CoreDataBase<Core> {

    int getSize();

    void addCore(Core core);

    Core removeCore(String name);

    boolean containsCore(String name);

    Core getSelectedCore();

    void selectCore(String name);

    Map<String, Core> getCoreDB();
}
