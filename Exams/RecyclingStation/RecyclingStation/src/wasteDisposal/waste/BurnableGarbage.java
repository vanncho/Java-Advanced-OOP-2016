package wasteDisposal.waste;

import wasteDisposal.annotations.Burnable;

@Burnable
public class BurnableGarbage extends  WasteAbstract {

    public BurnableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
