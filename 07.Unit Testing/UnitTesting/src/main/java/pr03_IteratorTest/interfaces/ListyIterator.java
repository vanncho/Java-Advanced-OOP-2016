package pr03_IteratorTest.interfaces;

import java.util.Iterator;

public interface ListyIterator<T> extends Iterator<T>, Iterable<T> {

    boolean move();

    String print();

    String printAll();

    boolean hasNext();

    int getInternalIndex();
}
