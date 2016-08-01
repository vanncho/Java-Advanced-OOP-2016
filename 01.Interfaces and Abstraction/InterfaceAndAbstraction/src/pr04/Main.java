package pr04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numbersTokens = input.nextLine().split("[\\s]+");
        String[] addressTokens = input.nextLine().split("[\\s]+");

        Smartphone smartphone = new Smartphone();

        for (int i = 0; i < numbersTokens.length; i++) {

            smartphone.calling(numbersTokens[i]);
        }

        for (int i = 0; i < addressTokens.length; i++) {
            smartphone.bowsing(addressTokens[i]);
        }
    }
}
