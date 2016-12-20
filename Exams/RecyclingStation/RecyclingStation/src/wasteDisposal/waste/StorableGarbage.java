package wasteDisposal.waste;

import wasteDisposal.annotations.Storable;

@Storable
public class StorableGarbage extends WasteAbstract {

    public StorableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
