package pr03_IteratorTest;

import pr03_IteratorTest.interfaces.ListyIterator;
import pr03_IteratorTest.models.ListyIteratorImpl;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator<String> myListIterator = null;

        while (true) {
            String line = reader.readLine();
            String[] commandLine = line.split("[\\s]+");

            if (commandLine[0].equalsIgnoreCase("end")) {
                break;
            }

            switch (commandLine[0]) {
                case "Create":
                    if (commandLine.length == 1) {
                        myListIterator = new ListyIteratorImpl<>(new ArrayList<>());
                    } else {
                        String listArguments = line.substring(line.indexOf(" ") + 1);
                        String[] tokens = listArguments.split("[\\s]+");
                        myListIterator = new ListyIteratorImpl<>(Arrays.asList(tokens));
                    }

                    break;
                case "Move":
                    System.out.println(myListIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(myListIterator.print());
                    } catch (UnsupportedOperationException uoe) {
                        System.out.println(uoe.getMessage());
                    }
                    break;
                case "PrintAll":
                    System.out.println(myListIterator.printAll());
                    break;
                case "HasNext":
                    System.out.println(myListIterator.hasNext());
                    break;

            }
        }
    }
}
