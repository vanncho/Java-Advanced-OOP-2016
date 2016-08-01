package pr03;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {

        Scanner input = new Scanner(System.in);
        String driver = input.nextLine();

        Ferrari ferrari = new Ferrari(driver);

        System.out.printf("%s/%s/%s/%s%n", ferrari.getModel(), ferrari.useBrakes(), ferrari.pushGas(), ferrari.getDriver());

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
