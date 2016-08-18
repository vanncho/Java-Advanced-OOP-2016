package pr03_BubbleSortTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bubble {

    public static <T extends Comparable<T>> T[] sort(Class classType, T[] elements) {

        List<T> nulls = new ArrayList<T>();
        List<T> notNulls = new ArrayList<T>();

        int elementsLength = elements.length;

        for (int i = 0; i < elementsLength; i++) {
            if (elements[i] == null) {
                nulls.add(elements[i]);
            } else {
                notNulls.add(elements[i]);
            }
        }

        int notNullsSize = notNulls.size();
        for (int i = 0; i < notNullsSize; i++) {

            boolean isSwaped = false;

            for (int j = 0; j < notNullsSize - i - 1; j++) {

                if (notNulls.get(j).compareTo(notNulls.get(j + 1)) > 0) {
                    swapElements(notNulls, j, j + 1);
                    isSwaped = true;
                }
            }

            if (!isSwaped) {
                break;
            }
        }

        T[] sortedElements = (T[]) Array.newInstance(classType, notNullsSize + nulls.size());

        for (int i = 0; i < notNullsSize; i++) {
            sortedElements[i] = notNulls.get(i);
        }

        return sortedElements;
    }

    private static <T extends Comparable<T>> void swapElements(List<T> elements, int currentIndex, int nextIndex) {

        T elementSwap = elements.get(currentIndex);
        elements.set(currentIndex, elements.get(nextIndex));
        elements.set(nextIndex, elementSwap);
    }
}
