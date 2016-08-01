package pr03;

import pr03.interfaces.MyStack;
import pr03.models.MyStackImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MyStack<Integer> myStack = new MyStackImpl();

        while (true) {
            String line = input.nextLine();
            String[] tokens = line.split("[\\s]+");

            if (tokens[0].equals("END")) {
                break;
            }

            switch (tokens[0]) {
                case "Push":
                    myStack.push(line.substring(line.indexOf(" ") + 1));
                    break;
                case "Pop":

                    try {
                        myStack.pop();
                    } catch (UnsupportedOperationException uoe) {
                        System.out.println(uoe.getMessage());
                    }

                    break;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer integer : myStack) {
                System.out.println(integer);
            }
        }
    }
}
