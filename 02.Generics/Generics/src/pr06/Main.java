package pr06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<DoubleBox<Double>> myDoubleBoxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double currentElement = Double.valueOf(input.nextLine());

            DoubleBox<Double> currDoubleBox = new DoubleBox<>(currentElement);
            myDoubleBoxList.add(currDoubleBox);
        }

        DoubleBox<Double> element = new DoubleBox<>(Double.valueOf(input.nextLine()));
        int countNumber = count(myDoubleBoxList, element);
        System.out.println(countNumber);
    }

    private static <T extends Comparable<T>> int count(List<T> myDoubleBoxList, T element) {
        int count = 0;

        for (int i = 0; i < myDoubleBoxList.size(); i++) {
            T currElement = myDoubleBoxList.get(i);

            if (currElement.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
