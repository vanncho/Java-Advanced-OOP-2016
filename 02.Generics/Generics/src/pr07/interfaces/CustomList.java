package pr07.interfaces;

public interface CustomList<T> {

    void addElem(T element);

    void removeElem(int index);

    boolean containsElem(T element);

    void swapElem(int indexFirst, int indexSecond);

    int countGreaterThat(T element);

    T getMax();

    T getMin();

    int getSize();

    T get(int index);
}
