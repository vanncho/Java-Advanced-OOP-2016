package liveDemosLecture;

public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> arrayStack = new ArrayStack<>(Integer.class, 2);
        arrayStack.push(1);

        System.out.println(arrayStack.pop());
    }
}
