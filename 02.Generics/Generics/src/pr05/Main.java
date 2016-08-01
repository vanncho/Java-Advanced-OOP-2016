package pr05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Box<String> box = new Box(input.nextLine());
            boxList.add(box);
        }

        Box<String> element = new Box<>(input.nextLine());
        int countNumber = count(boxList, element);
        System.out.println(countNumber);
    }

    private static <T extends Comparable<T>> int count(List<T> list, T element) {
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            T currBox = list.get(i);

            if (currBox.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
