package pr01.models;

import pr01.interfaces.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIteratorImpl<T> implements ListyIterator<T> {

    private List<T> elements;
    private int index;

    public ListyIteratorImpl(List<T> elements) {
        this.setElements(elements);
        this.setIndex(0);
    }

    @Override
    public boolean move() {

        if ((this.getIndex() + 1) < this.elements.size()) {
            this.setIndex(this.getIndex() + 1);
            return true;
        }

        return false;
    }

    @Override
    public String print() {

        if (this.elements.size() == 0) {
            throw new UnsupportedOperationException("Invalid Operation!");
        }

        return elements.get(getIndex()).toString();
    }

    @Override
    public String printAll() {
        StringBuilder output = new StringBuilder();

        for (T element : this.elements) {
            output.append(String.format("%s ", element));
        }

        output.setLength(output.length() - 1);
        return output.toString();
    }

    @Override
    public boolean hasNext() {
        return this.getIndex() < this.elements.size() - 1;
    }

    @Override
    public T next() {

        if (this.hasNext()) {
            return this.elements.get(this.moveIndex());
        }

        throw new UnsupportedOperationException("Invalid Operation!");
    }

    private void setElements(List<T> elements) {
        this.elements = elements;
    }

    private int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    private int moveIndex() {
        return this.getIndex() + 1;
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(this.index++);
            }
        };

        return iterator;
    }
}
