package pr07;

import pr07.interfaces.Buyer;
import pr07.models.Citizen;
import pr07.models.Rebel;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        HashMap<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("[\\s]+");

            Citizen citizen = null;
            Rebel rebel = null;

            String name = tokens[0];
            int age = Integer.valueOf(tokens[1]);

            if (tokens.length == 3) {
                String group = tokens[2];
                rebel = new Rebel(name, age, group);
                buyers.put(name, rebel);

            } else if (tokens.length == 4) {
                String id = tokens[2];
                String birthday = tokens[3];
                citizen = new Citizen(name, age, id, birthday);
                buyers.put(name, citizen);

            }
        }

        int food = 0;

        while (true) {
            String name = input.nextLine();

            if (name.equals("End")) {
                break;
            }

            if (buyers.containsKey(name)) {
                Buyer buyer = buyers.get(name);
                food += buyer.buyFood();
            }
        }

        System.out.println(food);
    }
}
