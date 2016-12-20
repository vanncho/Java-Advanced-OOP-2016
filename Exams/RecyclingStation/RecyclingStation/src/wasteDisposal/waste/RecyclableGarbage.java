package wasteDisposal.waste;

import wasteDisposal.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends WasteAbstract {

    public RecyclableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
