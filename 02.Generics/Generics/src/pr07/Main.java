package pr07;

import pr07.interfaces.CustomList;
import pr07.interfaces.Sorter;
import pr07.models.CustomListImpl;
import pr07.models.SorterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomListImpl<>();

        while (true) {
            String[] tokens = reader.readLine().trim().split("[\\s]+");

            if (tokens[0].equals("END")) {
                break;
            }

            switch (tokens[0]) {
                case "Add":
                    customList.addElem(tokens[1]);
                    break;
                case "Remove":
                    customList.removeElem(Integer.valueOf(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.containsElem(tokens[1]));
                    break;
                case "Swap":
                    customList.swapElem(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThat(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.print(customList.toString());
                    break;
                case "Sort":
                    Sorter<String> sorter = new SorterImpl<>();
                    sorter.sortList(customList);
                    break;
            }
        }
    }
}
