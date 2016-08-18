package adapterPatternDemo.models;

import adapterPatternDemo.interfaces.Refillable;

public class PetrolCar implements Refillable {

    @Override
    public void fillPetrol(int amount) {
        System.out.println(amount + " liters filled.");
    }

    @Override
    public void fillDiesel(int amount) {

    }

    @Override
    public void fillLpg(int amount) {

    }
}
