package pr10.models;

import pr10.interfaces.Character;

public  class CharacterImpl<T> implements Character<T> {

    private String username;
    private String characterType;
    private T specialPoints;
    private int level;

    public CharacterImpl(String username, String characterType, T specialPoints, int level) {
        this.username = username;
        this.characterType = characterType;
        this.specialPoints = specialPoints;
        this.level = level;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public T getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
