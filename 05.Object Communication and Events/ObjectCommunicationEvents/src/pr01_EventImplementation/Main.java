package pr01_EventImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            String name = input.nextLine();

            if (name.equals("End")) {
                break;
            }

            NameChange nameChange = new NameChange(name);
            Handler handler = new Handler(nameChange);
            Dispatcher user = new Dispatcher(name, handler);

            user.addNameChangeListener(handler);

            user.fireNameChangeEvent(nameChange);
        }
    }
}
