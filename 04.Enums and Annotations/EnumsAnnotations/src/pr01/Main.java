package pr01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String cards = input.nextLine();

        CardSuits[] cardSuits = CardSuits.values();

        System.out.println("Card Suits:");
        for (CardSuits cardSuit : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.name());
        }
    }
}
