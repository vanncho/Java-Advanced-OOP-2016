package pr02_KingsGambit.models;

import pr02_KingsGambit.interfaces.Unit;

import java.util.LinkedHashMap;

public class Data {

    private LinkedHashMap<String, Unit> units;

    public Data() {
        this.units = new LinkedHashMap();
    }

    public void addUnitToData(Unit unit) {
        this.units.put(unit.getName(), unit);
    }

    public void removeUnit(Unit unit) {
        this.units.remove(unit.getName());
    }

    public LinkedHashMap<String, Unit> getUnits() {
        return this.units;
    }
}
