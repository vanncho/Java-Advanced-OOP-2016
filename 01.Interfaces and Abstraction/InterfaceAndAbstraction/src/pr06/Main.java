package pr06;

import pr06.interfaces.Birthday;
import pr06.interfaces.Serializable;
import pr06.models.Citizen;
import pr06.models.Pet;
import pr06.models.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Serializable> serials = new ArrayList<>();
        List<Birthday> models = new ArrayList<>();

        while (true) {
            String[] tokens = input.nextLine().split("[\\s]+");

            if (tokens[0].equals("End")) {
                break;
            }

            Citizen citizen = null;
            Robot robot = null;
            Pet pet = null;

            if (tokens.length == 3) {
                String type = tokens[0];
                String name = tokens[1];

                switch (type) {
                    case "Robot":
                        String id = tokens[2];
                        robot = new Robot(name, id);
                        serials.add(robot);
                        break;
                    case "Pet":
                        String birthday = tokens[2];
                        pet = new Pet(name, birthday);
                        models.add(pet);
                        break;
                }
            } else if (tokens.length == 5) {
                String name = tokens[1];
                int age = Integer.valueOf(tokens[2]);
                String id = tokens[3];
                String birthday = tokens[4];
                citizen = new Citizen(name, age, id, birthday);
                models.add(citizen);
            }
        }

        String birthdayEnd = input.nextLine();

        for (Birthday model : models) {
            if (model.getBirthday().endsWith(birthdayEnd)) {
                System.out.println(model.getBirthday());
            }
        }
    }
}
