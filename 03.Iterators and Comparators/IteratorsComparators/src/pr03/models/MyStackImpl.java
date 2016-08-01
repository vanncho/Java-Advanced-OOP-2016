package pr03.models;

import pr03.interfaces.MyStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyStackImpl implements MyStack<Integer> {

    private List<Integer> innerCollection;

    public MyStackImpl() {
        this.setInnerCollection();
    }

    private void setInnerCollection() {
        this.innerCollection = new ArrayList<>();
    }

    @Override
    public void push(String elements) {
        String[] elemAsString = elements.split("[,\\s]+");

        for (int i = 0; i < elemAsString.length; i++) {
            this.innerCollection.add(0, Integer.valueOf(elemAsString[i]));
        }
    }

    @Override
    public int pop() {

        if (this.innerCollection.size() == 0) {
            throw new UnsupportedOperationException("No elements");
        }

        return this.innerCollection.remove(0);
    }

    @Override
    public Iterator<Integer> iterator() {

        Iterator<Integer> iterator = new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < innerCollection.size();
            }

            @Override
            public Integer next() {
                return innerCollection.get(this.index++);
            }
        };

        return iterator;
    }
}
