package pr03_DependencyInversion.models;


import pr03_DependencyInversion.interfaces.Calculator;
import pr03_DependencyInversion.interfaces.Strategy;

public class PrimitiveCalculator implements Calculator {

    private boolean isAddition;
    private Strategy strategy;
    private StrategyFactory strategyFactory;

    public PrimitiveCalculator(){
        this.strategy = new AdditionStrategy();
        this.isAddition = true;
        this.strategyFactory = new StrategyFactory();
    }

    @Override
    public void changeStrategy(char operator){
        this.strategy = this.strategyFactory.createStrategy(operator);
    }

    @Override
    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.doOperation(firstOperand, secondOperand);
    }
}
