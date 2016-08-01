package pro02;

import pro02.enumerations.CardPowers;
import pro02.enumerations.CardRank;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {

    private CardRank cardRank;
    private CardPowers cardPowers;

    public Card(CardRank cardRank, CardPowers cardPowers) {
        this.setCardRank(cardRank);
        this.setCardPowers(cardPowers);
    }

    public CardRank getCardRank() {
        return this.cardRank;
    }

    private void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public CardPowers getCardPowers() {
        return this.cardPowers;
    }

    private void setCardPowers(CardPowers cardPowers) {
        this.cardPowers = cardPowers;
    }

    public int calculateCardPower() {
        return this.getCardRank().getDescription() + this.cardPowers.getDescription();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.getCardRank().name(), this.getCardPowers().name());
    }


    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Card)) {
            return false;
        }

        return this.cardRank.name().equals(((Card) o).getCardRank().name()) && this.cardPowers.name().equals(((Card) o).cardPowers.name());
    }

    @Override
    public int compareTo(Card card) {

        if (this.calculateCardPower() > card.calculateCardPower()) {
            return -1;
        } else if (this.calculateCardPower() < card.calculateCardPower()) {
            return 1;
        }

        return 0;
    }
}
