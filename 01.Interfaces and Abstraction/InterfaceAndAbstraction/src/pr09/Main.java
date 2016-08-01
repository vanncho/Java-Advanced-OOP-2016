package pr09;

import pr09.interfaces.AddCollection;
import pr09.interfaces.AddRemoveCollection;
import pr09.interfaces.MyList;
import pr09.models.AddCollectionImpl;
import pr09.models.AddRemoveCollectionImpl;
import pr09.models.MyListImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] elements = input.nextLine().split("[\\s]+");

        AddCollection addColl = new AddCollectionImpl();
        AddRemoveCollection addRemColl = new AddRemoveCollectionImpl();
        MyList myList = new MyListImpl();

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            String currentElement = elements[i];

            first.add(addColl.myAdd(currentElement));
            second.add(addRemColl.myAdd(currentElement));
            third.add(myList.myAdd(currentElement));
        }

        for (Integer integer : first) {
            System.out.printf("%d ", integer);
        }

        System.out.println();

        for (Integer integer : second) {
            System.out.printf("%d ", integer);;
        }

        System.out.println();

        for (Integer integer : third) {
            System.out.printf("%d ", integer);
        }

        System.out.println();

        int n = Integer.valueOf(input.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("%s ", addRemColl.myRemove());
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%s ", myList.myRemove());
        }
    }
}
