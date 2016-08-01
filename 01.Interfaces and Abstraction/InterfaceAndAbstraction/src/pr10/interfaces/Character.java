package pr10.interfaces;

public interface Character<T> {

    String getUsername();

    String getCharacterType();

    T getSpecialPoints();

    int getLevel();
}
