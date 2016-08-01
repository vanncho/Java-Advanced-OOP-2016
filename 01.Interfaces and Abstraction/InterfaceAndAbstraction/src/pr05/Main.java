package pr05;

import pr05.interfaces.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Serializable> models = new ArrayList<>();

        while (true) {
            String[] tokens = input.nextLine().split("[\\s]+");

            if (tokens[0].equals("End")) {
                break;
            }

            Citizen citizen = null;
            Robot robot = null;

            if (tokens.length == 2) {
                String model = tokens[0];
                String id = tokens[1];
                robot = new Robot(model, id);
                models.add(robot);

            } else if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.valueOf(tokens[1]);
                String id = tokens[2];
                citizen = new Citizen(name, age, id);
                models.add(citizen);
            }
        }

        String borderCheck = input.nextLine();

        for (Serializable model : models) {
            if (model.getId().endsWith(borderCheck)) {
                System.out.println(model.getId());
            }
        }
    }
}
