package pr01.interfaces;

import java.util.Iterator;

public interface ListyIterator<T> extends Iterator<T>, Iterable<T> {

    boolean move();

    String print();

    String printAll();

    boolean hasNext();
}
