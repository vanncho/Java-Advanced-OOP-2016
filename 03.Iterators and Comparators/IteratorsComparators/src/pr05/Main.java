package pr05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        while (true) {
            String[] nameTokens = input.nextLine().split("[\\s]+");

            if (nameTokens[0].equals("END")) {
                break;
            }

            Person person = new Person(nameTokens[0], Integer.valueOf(nameTokens[1]), nameTokens[2]);
            personList.add(person);
        }

        int numberOfEquals = 0;
        int numberOfDifferent = 0;
        int peoples = Integer.valueOf(input.nextLine());
        Person one = personList.remove(peoples - 1);

        for (int i = 0; i < personList.size(); i++) {

            Person two = personList.get(i);

            if (one.compareTo(two) == 0) {
                numberOfEquals++;
                continue;
            }

            numberOfDifferent++;
        }

        if (numberOfEquals != 0) {
            System.out.printf("%d %d %d", numberOfEquals + 1, numberOfDifferent, personList.size() + 1);
        } else {
            System.out.println("No matches");
        }
    }
}
