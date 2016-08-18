package adapterPatternDemo;

import adapterPatternDemo.interfaces.GasStation;
import adapterPatternDemo.models.CityGasStation;

public class Main {
    public static void main(String[] args) {
        GasStation gasStation = new CityGasStation();

        gasStation.fill("Metan", 20);
        gasStation.fill("Petrol", 100);
    }
}
