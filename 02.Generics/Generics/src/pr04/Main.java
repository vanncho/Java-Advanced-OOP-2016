package pr04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        Integer[] elements = new Integer[n];
        for (int i = 0; i < n; i++) {
            String currElement = input.nextLine();

            elements[i] = Integer.valueOf(currElement);
        }

        int indexOne = Integer.valueOf(input.next());
        int indexTwo = Integer.valueOf(input.next());

        Integer[] swaped = createList(elements, indexOne, indexTwo);

        for (int i = 0; i < swaped.length; i++) {
            System.out.printf("%s: %d%n", swaped[i].getClass().getName(), swaped[i]);
        }
    }

    private static <T> T[] createList(T[] elements, int indexOne, int indexTwo) {

        T swap = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = swap;

        return elements;
    }
}
