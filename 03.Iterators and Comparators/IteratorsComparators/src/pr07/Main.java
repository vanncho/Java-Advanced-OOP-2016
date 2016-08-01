package pr07;

import pr07.interfaces.Person;
import pr07.models.PersonImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] personTokens = input.nextLine().split("[\\s]+");

            Person currentPerson = new PersonImpl(personTokens[0], Integer.valueOf(personTokens[1]));
            treeSet.add(currentPerson);
            hashSet.add(currentPerson);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
