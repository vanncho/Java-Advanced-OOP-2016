package pr03_DependencyInversion.models;

import pr03_DependencyInversion.interfaces.Strategy;

public class SubtractionStrategy implements Strategy {

    @Override
    public int doOperation(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
