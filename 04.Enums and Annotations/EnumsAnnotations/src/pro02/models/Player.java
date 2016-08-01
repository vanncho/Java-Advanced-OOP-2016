package pro02.models;

import pro02.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Card card;
    private List<Card> hand;
    private int handPower;

    public Player(String name) {
        this.setName(name);
        this.setCard(card);
        this.setHand(new ArrayList<>());
        this.setHandPower(0);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    private void setCard(Card card) {
        this.card = card;
    }

    public List<Card> getHand() {
        return hand;
    }

    private void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getHandPower() {
        return handPower;
    }

    private void setHandPower(int handPower) {
        this.handPower = handPower;
    }

    public void addCard(Card card) {

        if (hand.contains(card)) {
            throw new IllegalArgumentException("Card is not in the deck.");
        }

        this.hand.add(card);
    }

    public Card getMaxPlayerCard() {
        Card maxCard = this.hand.get(0);
        int max = maxCard.calculateCardPower();

        for (int i = 1; i < this.hand.size(); i++) {
            Card currentCard = this.hand.get(i);
            int currMax = currentCard.calculateCardPower();
            if (currMax > max) {
                max = currMax;
                maxCard = this.hand.get(i);
            }
        }

        return maxCard;
    }
}
