package pr10.models;

import pr10.interfaces.Demon;

public class DemonImpl<T> extends CharacterImpl<T> implements Demon<T> {

    public DemonImpl(String username, String characterType, T specialPoints, int level) {
        super(username, characterType, specialPoints, level);
    }

    @Override
    public String getEnergy() {
        return (this.getUsername().length() * 217) + "";
    }

    @Override
    public double getCalculateSpecial() {
        return ((Double) this.getSpecialPoints() * this.getLevel());
    }
}
