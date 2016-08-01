package pr07.models;

import pr07.interfaces.CustomList;
import pr07.interfaces.Sorter;

public class SorterImpl<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sortList(CustomList<T> elements) {

        for (int i = 0; i < elements.getSize(); i++) {
            T currentElement = elements.get(i);

            for (int j = i + 1; j < elements.getSize(); j++) {

                if (currentElement.compareTo(elements.get(j)) > 0) {
                    elements.swapElem(i, j);
                }
            }
        }
    }
}
