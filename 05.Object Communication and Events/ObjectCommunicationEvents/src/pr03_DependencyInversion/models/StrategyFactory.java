package pr03_DependencyInversion.models;

import pr03_DependencyInversion.interfaces.Strategy;

public class StrategyFactory {

    public Strategy createStrategy(char operator) {

        Strategy currentStrategy = null;

        switch (operator){
            case '+':
                //this.isAddition = true;
                currentStrategy = new AdditionStrategy();

                break;
            case '-':
                //this.isAddition = false;
                currentStrategy = new SubtractionStrategy();
                break;
            case '*':
                currentStrategy = new MultiplyStrategy();
                break;
            case '/':
                currentStrategy = new DevideStrategy();
                break;
            default:
                throw new IllegalArgumentException("No suck command!");
        }

        return currentStrategy;
    }
}
