package wasteDisposal.factories;

import wasteDisposal.waste.Waste;

public interface WasteCreator {

    Waste create(String name, double weight, double volumePerKg, String garbageType);
}
