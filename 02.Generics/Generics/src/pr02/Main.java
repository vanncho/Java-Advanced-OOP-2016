package pr02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(input.nextLine());
            Box<Integer> myBox = new Box<>(num);
            System.out.println(myBox);
        }
    }
}
