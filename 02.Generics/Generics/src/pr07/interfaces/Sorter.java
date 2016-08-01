package pr07.interfaces;

public interface Sorter<T extends Comparable<T>> {

    void sortList(CustomList<T> elements);
}
