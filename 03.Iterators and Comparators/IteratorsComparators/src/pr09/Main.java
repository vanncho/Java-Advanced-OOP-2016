package pr09;

import pr09.interfaces.MyLinkedList;
import pr09.models.MyLinkedListImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedListImpl<>();
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] parameters = line.split(" ");
            String command = parameters[0];
            int number = Integer.parseInt(parameters[1]);
            if(command.equals("Add")){
                myLinkedList.add(number);
            }else if(command.equals("Remove")){
                myLinkedList.remove(number);
            }
        }

        System.out.println(myLinkedList.getSize());

        for (Integer number : myLinkedList){
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
