package pr01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            Box<String> myBox = new Box<>(str);
            System.out.println(myBox);
        }
    }
}
