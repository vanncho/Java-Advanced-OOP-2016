package pr07_1.interfaces;


public interface Sorter<T extends Comparable<T>> {

    void sort(MyList<T> elements);
}
