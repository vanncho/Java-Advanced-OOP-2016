package pr07_1.interfaces;

public interface MyList<T extends Comparable<T>> extends Iterable<T> {

    void add(T element);

    void remove(int index);

    boolean contains(T element);

    void swap(int indexOne, int indexTwo);

    int countGreaterThat(T element);

    T getMax();

    T getMin();

    int getSizeOfList();

    T getCurrIndex(int index);
}
