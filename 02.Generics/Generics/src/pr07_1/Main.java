package pr07_1;

import pr07_1.interfaces.Sorter;
import pr07_1.models.SorterImpl;
import pr07_1.interfaces.MyList;
import pr07_1.models.MyListImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        MyList<String> myList = new MyListImpl<>();

        while (true) {
            String[] tokens = input.nextLine().split("[\\s]+");

            if (tokens[0].equals("END")) {
                break;
            }

            switch (tokens[0]) {
                case "Add":
                    myList.add(tokens[1]);
                    break;
                case "Remove":
                    myList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(myList.contains(tokens[1]));
                    break;
                case "Swap":
                    myList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThat(tokens[1]));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Print":
                    for (String currStringElement : myList) {
                        System.out.println(currStringElement);
                    }
                    break;
                case "Sort":
                    Sorter sorter = new SorterImpl();
                    sorter.sort(myList);
                    break;
            }
        }
    }
}
