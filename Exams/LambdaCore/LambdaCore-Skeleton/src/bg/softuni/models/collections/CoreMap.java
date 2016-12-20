package bg.softuni.models.collections;

import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.CoreDataBase;

import java.util.HashMap;
import java.util.Map;

public class CoreMap implements CoreDataBase<Core> {

    private Map<String, Core> coreDB;
    private Core activeCore;

    public CoreMap() {
        this.coreDB = new HashMap<>();
    }

    @Override
    public int getSize() {
        return this.coreDB.size();
    }

    @Override
    public void addCore(Core core) {
        this.coreDB.put(core.getName(), core);
    }

    @Override
    public Core removeCore(String name) {
        return this.coreDB.remove(name);
    }

    @Override
    public boolean containsCore(String name) {
        return this.coreDB.containsKey(name);
    }

    @Override
    public Core getSelectedCore(){
        return this.activeCore;
    }

    @Override
    public void selectCore(String name) {
        Core selectCore = this.coreDB.get(name);
        this.activeCore = selectCore;
    }

    @Override
    public Map<String, Core> getCoreDB() {
        Map<String, Core> newCollection = new HashMap<>();

        for (String s : this.coreDB.keySet()) {
            String key = s;
            Core value = this.coreDB.get(key);

            newCollection.put(key, value);
        }

        return newCollection;
    }
}
