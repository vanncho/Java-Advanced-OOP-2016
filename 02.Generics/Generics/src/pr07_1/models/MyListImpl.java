package pr07_1.models;

import pr07_1.interfaces.MyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyListImpl<T extends Comparable<T>> implements MyList<T> {
    private List<T> innerListContainer;

    public MyListImpl() {
        this.innerListContainer = new ArrayList<T>();
    }


    @Override
    public void add(T element) {
        this.innerListContainer.add(element);
    }

    @Override
    public void remove(int index) {
        this.innerListContainer.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.innerListContainer.contains(element);
    }

    @Override
    public void swap(int indexOne, int indexTwo) {
        Collections.swap(this.innerListContainer, indexOne, indexTwo);
    }

    @Override
    public int countGreaterThat(T element) {
        int count  = 0;

        for (T t : this.innerListContainer) {

            if (t.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public T getMax() {
        T maxEelement = this.innerListContainer.get(0);

        for (int i = 1; i < this.innerListContainer.size(); i++) {

            if (this.innerListContainer.get(i).compareTo(maxEelement) > 0) {
                maxEelement = this.innerListContainer.get(i);
            }
        }

        return maxEelement;
    }

    @Override
    public T getMin() {
        T minEelement = this.innerListContainer.get(0);

        for (int i = 1; i < this.innerListContainer.size(); i++) {

            if (this.innerListContainer.get(i).compareTo(minEelement) < 0) {
                minEelement = this.innerListContainer.get(i);
            }
        }

        return minEelement;
    }

    @Override
    public int getSizeOfList() {
        return this.innerListContainer.size();
    }

    @Override
    public T getCurrIndex(int index) {
        return this.innerListContainer.get(index);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.innerListContainer.size(); i++) {

            if (i < this.innerListContainer.size() - 1) {
                output.append(this.innerListContainer.get(i).toString()).append(System.lineSeparator());
            } else {
                output.append(this.innerListContainer.get(i).toString());
            }
        }

        return output.toString();
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {
            int indexCount = 0;

            @Override
            public boolean hasNext() {
                return indexCount < innerListContainer.size();
            }

            @Override
            public T next() {
                return innerListContainer.get(indexCount++);
            }
        };

        return iterator;
    }
}
