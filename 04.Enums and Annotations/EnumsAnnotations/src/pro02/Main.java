package pro02;

import pro02.enumerations.CardPowers;
import pro02.enumerations.CardRank;
import pro02.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean firstHasFiveCards = false;
        boolean secondHasFiveCards = false;

        String firstPlayer = reader.readLine();
        String secondPlayer = reader.readLine();

        Player first = new Player(firstPlayer);
        Player second = new Player(secondPlayer);

        while (true) {

            while (first.getHand().size() < 5) {
                String[] cardTokens = reader.readLine().split("[\\s]+");

                try {
                    CardRank cardRank = CardRank.valueOf(cardTokens[0]);
                    CardPowers cardPowers = CardPowers.valueOf(cardTokens[2]);

                    Card currentCard = new Card(cardRank, cardPowers);

                    if (first.getHand().contains(currentCard)) {
                        System.out.println("Card is not in the deck.");
                        continue;
                    }

                    first.addCard(currentCard);
                }
                catch (IllegalArgumentException iae) {
                    System.out.println("No such card exists.");
                }
            }

            if (first.getHand().size() == 5) {
                firstHasFiveCards = true;
            }

            while (second.getHand().size() < 5) {
                String[] cardTokens = reader.readLine().split("[\\s]+");

                try {
                    CardRank cardRank = CardRank.valueOf(cardTokens[0]);
                    CardPowers cardPowers = CardPowers.valueOf(cardTokens[2]);

                    Card currentCard = new Card(cardRank, cardPowers);

                    if (second.getHand().contains(currentCard) || first.getHand().contains(currentCard)) {
                        System.out.println("Card is not in the deck.");
                        continue;
                    }

                    second.addCard(currentCard);
                }
                catch (IllegalArgumentException iae) {
                    System.out.println("No such card exists.");
                }
            }

            if (second.getHand().size() == 5) {
                secondHasFiveCards = true;
            }

            if (firstHasFiveCards && secondHasFiveCards) {
                break;
            }
        }

        int firstMax = first.getMaxPlayerCard().calculateCardPower();
        int secondMax = second.getMaxPlayerCard().calculateCardPower();

        if (firstMax > secondMax) {
            System.out.printf("%s wins with %s.", first.getName(), first.getMaxPlayerCard());
        } else if (secondMax > firstMax) {
            System.out.printf("%s wins with %s.", second.getName(), second.getMaxPlayerCard());
        }
    }
}
