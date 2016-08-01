package pr10;

import pr10.annotations.WeaponAnnotation;
import pr10.enumerators.Gem;
import pr10.enumerators.WeaponType;
import pr10.interfaces.Weapon;
import pr10.models.WeaponImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Weapon> weapons = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        WeaponAnnotation annotation = Weapon.class.getAnnotation(WeaponAnnotation.class);

        while (true) {
            String[] tokens = reader.readLine().split(";");

            if (tokens[0].equals("END")) {
                break;
            }

            switch (tokens[0]) {
                case "Create": {
                    String name = tokens[2];
                    WeaponType weaponType = WeaponType.valueOf(tokens[1]);
                    Weapon currWeapon = new WeaponImpl(name, weaponType);
                    weapons.put(name, currWeapon);
                }
                    break;
                case "Add": {
                    String name = tokens[1];
                    int index = Integer.valueOf(tokens[2]);
                    Gem gemType = Gem.valueOf(tokens[3]);
                    Weapon currWeapon = weapons.get(name);
                    currWeapon.addGem(gemType, index);
                    weapons.put(name, currWeapon);
                }
                    break;
                case "Remove": {
                    String name = tokens[1];
                    int index = Integer.valueOf(tokens[2]);
                    Weapon currWeapon = weapons.get(name);
                    currWeapon.removeGem(index);
                    weapons.put(name, currWeapon);

                }
                    break;
                case "Print":
                    String name = tokens[1];
                    Weapon weapon = weapons.get(name);
                    System.out.println(weapon);
                    break;
                case "Compare": {
                    String weaponNameOne = tokens[1];
                    String weaponNameTwo = tokens[2];
                    Weapon firstWeapon = weapons.get(weaponNameOne);
                    Weapon secondWeapon = weapons.get(weaponNameTwo);

                    if (firstWeapon.compareTo(secondWeapon) < 0){
                        System.out.println(firstWeapon.compareToString());
                    } else if (firstWeapon.compareTo(secondWeapon) > 0){
                        System.out.println(secondWeapon.compareToString());
                    } else if (firstWeapon.compareTo(secondWeapon) == 0){
                        System.out.println(firstWeapon.compareToString());
                    }
                }
                    break;
                case "Author":
                    System.out.printf("Author: %s%n", annotation.author());

                    break;
                case "Revision":
                    System.out.printf("Revision: %d%n", annotation.revision());

                    break;
                case "Description":
                    System.out.printf("Class description: %s%n", annotation.description());

                    break;
                case "Reviewers":
                    System.out.printf("Reviewers: %s%n", annotation.reviewers());

                    break;
            }
        }
    }
}
