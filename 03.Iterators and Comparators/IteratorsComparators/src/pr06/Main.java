package pr06;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        TreeSet<Person> firstSet = new TreeSet<>();
        TreeSet<Person> secondSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] personTokens = input.nextLine().split("[\\s]+");

            Person currentPerson = new Person(personTokens[0], Integer.valueOf(personTokens[1]));
            firstSet.add(currentPerson);
            secondSet.add(currentPerson);
        }

        firstSet.stream().sorted(new Person.PersonNameCompare()).forEach(System.out::println);
        secondSet.stream().sorted(new Person.PersonAgeCompare()).forEach(System.out::println);
    }
}
