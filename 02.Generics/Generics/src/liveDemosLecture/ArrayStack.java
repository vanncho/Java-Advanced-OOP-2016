package liveDemosLecture;

import java.lang.reflect.Array;

public class ArrayStack<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private Class<E> classType;
    private E[] array;
    private int index = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<E> classType) {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        this.classType = classType;
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<E> classType, int capacity) {
        this.array = (E[]) Array.newInstance(classType, capacity);
        this.classType = classType;
    }

    public void push(E element) {

        if (this.index == array.length) {
            this.resize();
        }
        this.array[this.index] = element;
        index++;
    }

    public E pop() {
        return this.array[--this.index];
    }

    public E peek() {
        return this.array[this.index - 1];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArray = (E[]) Array.newInstance(this.classType, this.array.length * 2);

        for (int i = 0; i < this.array.length; i++) {
            newArray[i]= this.array[i];
        }

        this.array = newArray;
    }
}
