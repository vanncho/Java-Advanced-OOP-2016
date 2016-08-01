package pr06_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<MyDoubleBox<Double>> myList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double currentElement = Double.valueOf(reader.readLine());

            MyDoubleBox<Double> currDoubleBox = new MyDoubleBox<>(currentElement);
            myList.add(currDoubleBox);
        }

        MyDoubleBox<Double> elementToCompare = new MyDoubleBox<>(Double.valueOf(reader.readLine()));
        int countNumber = count(myList, elementToCompare);
        System.out.println(countNumber);
    }

    private static <T extends Comparable<T>> int count(List<T> boxElements, T element) {
        int count = 0;

        for (int i = 0; i < boxElements.size(); i++) {
            T currElem = boxElements.get(i);

            if (currElem.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
