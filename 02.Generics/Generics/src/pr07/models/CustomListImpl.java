package pr07.models;

import pr07.interfaces.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {
    private List<T> customList;

    public CustomListImpl() {
        this.customList = new ArrayList<>();
    }

    @Override
    public void addElem(T element) {
        this.customList.add(element);
    }

    @Override
    public void removeElem(int index) {
        this.customList.remove(index);
    }

    @Override
    public boolean containsElem(T element) {
        return this.customList.contains(element);
    }

    @Override
    public void swapElem(int indexFirst, int indexSecond) {
        Collections.swap(this.customList, indexFirst, indexSecond);
    }

    @Override
    public int countGreaterThat(T element) {
        int count = 0;

        for (T elementFromCustomList : customList) {

            if (elementFromCustomList.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public T getMax() {
        T maxElement = this.customList.get(0);

        for (int i = 1; i < this.customList.size(); i++) {

            if (this.customList.get(i).compareTo(maxElement) > 0) {
                maxElement = this.customList.get(i);
            }
        }

        return maxElement;
    }

    @Override
    public T getMin() {
        T minElement = this.customList.get(0);

        for (int i = 1; i < this.customList.size(); i++) {

            if (this.customList.get(i).compareTo(minElement) < 0) {
                minElement = this.customList.get(i);
            }
        }

        return minElement;
    }

    @Override
    public int getSize() {
        return this.customList.size();
    }

    @Override
    public T get(int index) {
        return this.customList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.customList.size(); i++) {

            if (i < this.customList.size() - 1) {
                sb.append(this.customList.get(i).toString()).append(System.lineSeparator());
            } else {
                sb.append(this.customList.get(i));
            }
        }

        return sb.toString();
    }
}
