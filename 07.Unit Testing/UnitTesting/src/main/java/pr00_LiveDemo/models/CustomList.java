package pr00_LiveDemo.models;

import pr00_LiveDemo.interfaces.MyList;
import pr01_Database.interfaces.People;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/*
Документация - САМО на публичните методи на класа, интерфейсите. И на самите класове!
 */
public class CustomList<T extends Comparable<T>> implements MyList<T>, Iterable<T> {

    private T[] array;

    public CustomList(T... array) throws OperationNotSupportedException {

        if (array == null) {
            throw new OperationNotSupportedException();
        }
        this.array = array;
    }

    @Override
    public void add(T element, int index) {

        this.array[index] = element;
    }

    @Override
    public T element(int index) {

        T removedElement = this.array[index];

        for (int i = index; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[this.array.length - 1] = null;
        return removedElement;
    }

    @Override
    public boolean contains(T element) {

        for (T currentElement : this.array) {

            if (currentElement.compareTo(element) == 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] getAll() {
        T[] newCopyOfArray = (T[]) new Object[this.array.length];
        int index = 0;

        for (int i = 0; i < newCopyOfArray.length; i++) {

            if (this.array[i] == null) {
                break;
            }

            newCopyOfArray[index++] = this.array[i];
        }

        return newCopyOfArray;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {

                if (index > array.length - 1) {
                    return false;
                }

                if (array[index] == null) {
                    return false;
                }

                return true;
            }

            @Override
            public T next() {

                if (this.hasNext()) {
                    return array[index++];
                }

                throw new NoSuchElementException();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {

        //consumer.accept(iterator().next());  // not correct
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
