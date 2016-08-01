package pro02.enumerations;

import pro02.annotations.Suit;

@Suit
public enum CardPowers {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    private CardPowers(int description) {
        this.power = description;
    }

    public int getDescription() {
        return this.power;
    }
}
