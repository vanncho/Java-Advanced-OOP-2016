package pr03_DependencyInversion;

import pr03_DependencyInversion.models.PrimitiveCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PrimitiveCalculator calculator = new PrimitiveCalculator();

        Scanner input = new Scanner(System.in);

        while (true) {
            String[] lineTokens = input.nextLine().split("[\\s]+");

            if (lineTokens[0].equals("End")) {
                break;
            }

            if (lineTokens[0].equals("mode")) {
                calculator.changeStrategy(lineTokens[1].charAt(0));
                continue;
            }

            int result = calculator.performCalculation(Integer.valueOf(lineTokens[0]), Integer.valueOf(lineTokens[1]));
            System.out.println(result);
        }
    }
}
