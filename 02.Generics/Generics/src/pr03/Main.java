package pr03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] elements = new String[n];
        for (int i = 0; i < n; i++) {
            String currElement = input.nextLine();

            elements[i] = currElement;
        }

        int indexOne = Integer.valueOf(input.next());
        int indexTwo = Integer.valueOf(input.next());

        String[] swaped = createList(elements, indexOne, indexTwo);

        for (int i = 0; i < swaped.length; i++) {
            System.out.printf("%s: %s%n", swaped[i].getClass().getName(), swaped[i]);
        }
    }

    private static <T> T[] createList(T[] elements, int indexOne, int indexTwo) {

        T swap = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = swap;

        return elements;
    }
}
