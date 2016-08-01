package pr03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] lights = input.nextLine().split("[\\s]+");
        int n = Integer.parseInt(input.nextLine());

        TrafficLights[] traffic = new TrafficLights[lights.length];

        for (int i = 0; i < traffic.length; i++) {
            traffic[i] = TrafficLights.valueOf(lights[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                traffic[j] = traffic[j].next();
                System.out.printf("%s ", traffic[j]);
            }
            System.out.println();
        }
    }
}
