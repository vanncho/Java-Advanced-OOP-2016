package adapterPatternDemo.models;

import adapterPatternDemo.interfaces.GasStation;
import adapterPatternDemo.interfaces.Refillable;

public class AdapterGasStation implements GasStation {
    private Refillable vehicle;

    public AdapterGasStation(String fuelType) {
        if (fuelType.equalsIgnoreCase("petrol")) {
            this.vehicle = new PetrolCar();
        } else if (fuelType.equalsIgnoreCase("diesel")) {
            this.vehicle = new DieselCar();
        } else if (fuelType.equalsIgnoreCase("lpg")) {
            this.vehicle = new LpgCar();
        }
    }

    @Override
    public void fill(String fuelType, int amount) {
        if (fuelType.equalsIgnoreCase("petrol")) {
            this.vehicle.fillPetrol(amount);
        } else if (fuelType.equalsIgnoreCase("diesel")) {
            this.vehicle.fillDiesel(amount);
        } else if (fuelType.equalsIgnoreCase("lpg")) {
            this.vehicle.fillLpg(amount);
        }
    }
}
