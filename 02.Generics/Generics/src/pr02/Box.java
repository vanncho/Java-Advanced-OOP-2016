package pr02;

public class Box<E> {
    private E object;

    public Box(E object) {
        this.object = object;
    }


    @Override
    public String toString() {
        return String.format("%s: %d", this.object.getClass().getName(), this.object);
    }
}
