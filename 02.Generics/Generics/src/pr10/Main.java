package pr10;

import pr10.interfaces.Threeuple;
import pr10.models.ThreeupleImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("[\\s]+");
        String name = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];
        String town = firstLine[3];
        Threeuple<String, String, String> tupleOne = new ThreeupleImpl<>(name, address, town);

        System.out.println(tupleOne.getTupleKey() + " -> " + tupleOne.getTupleValue() + " -> " + tupleOne.getTupleThree());

        String[] secondLine = reader.readLine().split("[\\s]+");
        String nameSecond = secondLine[0];
        int liters = Integer.valueOf(secondLine[1]);
        String doesDrink = secondLine[2];
        boolean isDrunk = false;

        if (doesDrink.equals("drunk")) {
            isDrunk = true;
        }

        Threeuple<String, Integer, String> tupleTwo = new ThreeupleImpl<>(nameSecond, liters, doesDrink);

        System.out.println(tupleTwo.getTupleKey() + " -> " + tupleTwo.getTupleValue() + " -> " + isDrunk);

        String[] thirdLine = reader.readLine().split("[\\s]+");
        String thirdName = thirdLine[0];
        double secondParam = Double.valueOf(thirdLine[1]);
        String currency = thirdLine[2];
        Threeuple<String, Double, String> tupleThree = new ThreeupleImpl<>(thirdName, secondParam, currency);

        System.out.println(tupleThree.getTupleKey() + " -> " + tupleThree.getTupleValue() + " -> " + tupleThree.getTupleThree());
    }
}
