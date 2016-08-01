package pr01;

import pr01.interfaces.Birthable;
import pr01.interfaces.Identifiable;
import pr01.interfaces.Person;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Class[] citizenInterfaces = Citizen.class.getInterfaces();
        //if(Arrays.asList(citizenInterfaces).contains(Person.class)){
        //    Method[] fields = Person.class.getDeclaredMethods();
        //    System.out.println(fields.length);

        //    Scanner scanner = new Scanner(System.in);
        //    String name = scanner.nextLine();

        //    int age = Integer.parseInt(scanner.nextLine());
        //    Person person = new Citizen(name,age);
        //    System.out.println(person.getName());
        //    System.out.println(person.getAge());
        //}

        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            methods = Identifiable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthdate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name, age, id, birthdate);
            Birthable birthable = new Citizen(name, age, id, birthdate);
        }
    }
}
