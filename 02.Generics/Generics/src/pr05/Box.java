package pr05;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T element;

    public Box(T element) {
        this.setElement(element);
    }

    private void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    @Override
    public int compareTo(Box<T> tBox) {
        return this.getElement().compareTo(tBox.getElement());
    }
}
