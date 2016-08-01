package pr01;

public class Box<E> {
    private E object;

    public Box(E object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.object.getClass().getName(), this.object);
    }
}
