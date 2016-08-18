package pr00_LiveDemo.interfaces;

import pr01_Database.interfaces.People;

public interface MyList<T> extends Iterable<T> {

    void add(T element, int index);

    T element(int index);

    boolean contains(T element);

    T[] getAll();
}
