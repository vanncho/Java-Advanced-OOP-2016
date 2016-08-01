package pr10.models;

import pr10.interfaces.Archangel;

public class ArchangelImpl<T> extends CharacterImpl<T> implements Archangel<T> {

    public ArchangelImpl(String username, String characterType, T specialPoints, int level) {
        super(username, characterType, specialPoints, level);
    }

    @Override
    public String getMana() {
        return getUsernameReversed() + "" + (this.getUsername().length() * 21);
    }

    private String getUsernameReversed() {
        StringBuilder reversed = new StringBuilder();

        for (int i = this.getUsername().length() - 1; i >= 0; i--) {
            reversed.append(this.getUsername().charAt(i));
        }

        return reversed.toString();
    }

    @Override
    public int getCalculateSpecial() {
        return ((Integer) this.getSpecialPoints() * this.getLevel());
    }
}
