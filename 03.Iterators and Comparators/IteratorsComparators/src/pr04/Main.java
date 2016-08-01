package pr04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numAsStrings = input.nextLine().split("[,\\s]+");
        Integer[] nums = new Integer[numAsStrings.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(numAsStrings[i]);
        }

        Lake lake = new Lake(nums);
        String end = input.nextLine();

        if (end.equals("END")) {

            StringBuilder output = new StringBuilder();

            for (Integer integer : lake) {
                output.append(integer).append(", ");
            }

            output.setLength(output.length() - 2);
            System.out.println(output.toString());
        }
    }
}
