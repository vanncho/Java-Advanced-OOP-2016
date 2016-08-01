package pr07_1.models;

import pr07_1.interfaces.MyList;
import pr07_1.interfaces.Sorter;

public class SorterImpl<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(MyList<T> elements) {

        for (int i = 0; i < elements.getSizeOfList(); i++) {
            T currElement = elements.getCurrIndex(i);

            for (int j = i + 1; j < elements.getSizeOfList(); j++) {
                T element = elements.getCurrIndex(j);

                if (currElement.compareTo(element) > 0) {
                    elements.swap(i, j);
                }
            }
        }
    }
}