package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		Class<BlackBoxInt> boxClass = BlackBoxInt.class;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Constructor boxConstructor = boxClass.getDeclaredConstructor();
        boxConstructor.setAccessible(true);

        BlackBoxInt bbi = (BlackBoxInt) boxConstructor.newInstance();

        while (true) {
            String[] line = reader.readLine().split("_");
            String command = line[0];

            if (command.equals("END")) {
                break;
            }

            int value = Integer.valueOf(line[1]);

            try {

                Field boxField = BlackBoxInt.class.getDeclaredField("innerValue");
                boxField.setAccessible(true);
                //boxField.set(bbi, value);

                Method method = boxClass.getDeclaredMethod(command, int.class);
                method.setAccessible(true);
                method.invoke(bbi, value);

                System.out.println(boxField.get(bbi));

            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
    }
}
