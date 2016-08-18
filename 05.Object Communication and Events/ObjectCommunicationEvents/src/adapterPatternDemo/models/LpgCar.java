package adapterPatternDemo.models;

import adapterPatternDemo.interfaces.Refillable;

public class LpgCar implements Refillable {

    @Override
    public void fillPetrol(int amount) {

    }

    @Override
    public void fillDiesel(int amount) {

    }

    @Override
    public void fillLpg(int amount) {
        System.out.println(amount + " liters filled.");
    }
}
