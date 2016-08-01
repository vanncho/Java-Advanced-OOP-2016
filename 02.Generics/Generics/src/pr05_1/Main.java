package pr05_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String currentElement = input.nextLine();
            Box<String> currBox = new Box<>(currentElement);
            boxList.add(currBox);
        }

        Box<String> element = new Box<>(input.nextLine());
        int countNumber = count(boxList, element);
        System.out.println(countNumber);
    }

    private static <T extends Comparable<T>> int count(List<T> boxList, T element) {
        int count = 0;

        for (int i = 0; i < boxList.size(); i++) {
            T currentElement = boxList.get(i);

            if (currentElement.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
