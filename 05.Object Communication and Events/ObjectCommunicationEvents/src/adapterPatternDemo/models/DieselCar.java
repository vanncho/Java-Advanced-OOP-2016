package adapterPatternDemo.models;

import adapterPatternDemo.interfaces.Refillable;

public class DieselCar implements Refillable {

    @Override
    public void fillPetrol(int amount) {

    }

    @Override
    public void fillDiesel(int amount) {
        System.out.println(amount + " liters filled.");
    }

    @Override
    public void fillLpg(int amount) {

    }
}
