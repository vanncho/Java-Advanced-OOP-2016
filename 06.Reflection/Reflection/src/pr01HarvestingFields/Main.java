package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        Scanner input = new Scanner(System.in);

        while (true) {
            String line = input.nextLine();

            if (line.equals("HARVEST")) {
                break;
            }

            Field[] allFields = richSoilLandClass.getDeclaredFields();

            for (Field privateField : allFields) {

                String accessModifier = Modifier.toString(privateField.getModifiers());
                String fieldName = privateField.getName();
                Class fieldType = privateField.getType();

                if (accessModifier.equals(line)) {
                    System.out.printf("%s %s %s%n", accessModifier, fieldType.getSimpleName(), fieldName);
                } else if (line.equals("all")){
                    System.out.printf("%s %s %s%n", accessModifier, fieldType.getSimpleName(), fieldName);
                }
            }
        }
    }
}
