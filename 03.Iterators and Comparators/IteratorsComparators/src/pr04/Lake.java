package pr04;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Lake implements Iterable<Integer> {

    private List<Integer> elements;

    public Lake(Integer... elements) {
        this.elements = Arrays.asList(elements);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int index;
        private boolean isOutside;

        @Override
        public boolean hasNext() {

            if (this.index >= elements.size() && !isOutside) {
                this.index = 1;
                isOutside = true;
            }

            return this.index < elements.size();
        }

        @Override
        public Integer next() {

            if (this.hasNext()) {
                int toReturn = elements.get(index);
                this.index += 2;
                return toReturn;
            }

            throw new NoSuchElementException();
        }
    }
}
