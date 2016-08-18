package pr03_DependencyInversion.models;

import pr03_DependencyInversion.interfaces.Strategy;

public class AdditionStrategy implements Strategy {

    @Override
    public int doOperation(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
