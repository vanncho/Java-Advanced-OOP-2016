package wasteDisposal.factories;

import wasteDisposal.constants.Paths;
import wasteDisposal.waste.Waste;

import java.lang.reflect.Constructor;

public class WasteFactory implements WasteCreator {

    public WasteFactory() {
    }

    @Override
    public Waste create(String name, double weight, double volumePerKg, String garbageType) {

        Waste waste = null;

        try {
            Class coreClass = Class.forName(Paths.WASTE_PACKAGE_PATH + garbageType + "Garbage");
            @SuppressWarnings("unchecked")
            Constructor constructor = coreClass.getConstructor(String.class, double.class, double.class);
            waste = (Waste) constructor.newInstance(name, weight, volumePerKg);

            return waste;

        } catch (ReflectiveOperationException roe) {
            throw new IllegalArgumentException("No such waste exists!");
        }
    }
}
