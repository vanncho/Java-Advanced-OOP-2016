package pr10.interfaces;

import pr10.annotations.WeaponAnnotation;
import pr10.enumerators.Gem;

@WeaponAnnotation
public interface Weapon extends Comparable<Weapon> {

    void addGem(Gem type, int index);

    void removeGem(int index);

    String getName();

    double calculateItemLevel();

    String compareToString();
}
