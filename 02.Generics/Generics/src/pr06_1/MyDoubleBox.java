package pr06_1;

public class MyDoubleBox<T extends Comparable<T>> implements Comparable<MyDoubleBox<T>> {
    private T element;

    public MyDoubleBox(T element) {
        this.setElement(element);
    }

    private void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return this.element;
    }

    @Override
    public int compareTo(MyDoubleBox<T> tMyDoubleBox) {
        return this.getElement().compareTo(tMyDoubleBox.getElement());
    }
}
