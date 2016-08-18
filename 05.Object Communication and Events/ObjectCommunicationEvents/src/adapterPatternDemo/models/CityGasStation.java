package adapterPatternDemo.models;

import adapterPatternDemo.interfaces.GasStation;

public class CityGasStation implements GasStation {
    private GasStation gasStation;

    @Override
    public void fill(String fuelType, int amount) {
        if (fuelType.equalsIgnoreCase("water")) {
            System.out.println(amount + " liters filled.");
        } else if (fuelType.equalsIgnoreCase("petrol") ||
                fuelType.equalsIgnoreCase("diesel") ||
                fuelType.equalsIgnoreCase("lpg")) {

            this.gasStation = new AdapterGasStation(fuelType);
            this.gasStation.fill(fuelType, amount);
        } else {
            System.out.println("Fuel type is not supported!");
        }
    }
}
