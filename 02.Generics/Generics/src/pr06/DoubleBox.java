package pr06;

public class DoubleBox<T extends Comparable<T>> implements Comparable<DoubleBox<T>> {
    private T element;

    public DoubleBox(T element) {
        this.setElement(element);
    }

    private void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return this.element;
    }

    @Override
    public int compareTo(DoubleBox<T> tDoubleBox) {
        return this.getElement().compareTo(tDoubleBox.getElement());
    }
}
