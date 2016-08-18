package pr03_DependencyInversion.interfaces;

public interface Calculator {

    void changeStrategy(char operator);

    int performCalculation(int firstOperand,int secondOperand);
}
