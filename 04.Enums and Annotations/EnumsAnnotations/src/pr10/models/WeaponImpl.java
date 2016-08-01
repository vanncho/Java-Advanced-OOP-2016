package pr10.models;

import pr10.enumerators.Gem;
import pr10.enumerators.WeaponType;
import pr10.interfaces.Weapon;

public class WeaponImpl implements Weapon, Comparable<Weapon> {

    private String name;
    private WeaponType weaponType;
    private Gem[] sockets;
    private double itemLevel;

    public WeaponImpl(String name, WeaponType weaponType) {
        this.setName(name);
        this.setWeaponType(weaponType);
        this.sockets = new Gem[this.weaponType.getMaxNumberOfSockets()];
        this.setItemLevel(0d);
    }

    private double getItemLevel() {
        return this.itemLevel;
    }

    private void setItemLevel(double itemLevel) {
        this.itemLevel = itemLevel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    private void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public void addGem(Gem type, int index) {

        if (index >= 0 && index < this.sockets.length) {
            this.sockets[index] = type;
        }
    }

    @Override
    public void removeGem(int index) {

        if (index >= 0 && index < this.sockets.length) {
            this.sockets[index] = null;
        }
    }

    private int getMinDamage() {
        int minDamage = this.weaponType.getMinDamage();

        for (int i = 0; i < this.getAllStrength(); i++) {
            minDamage += 2;
        }

        for (int i = 0; i < this.getAllAgility(); i++) {
            minDamage += 1;
        }

        return minDamage;
    }

    private int getMaxDamage() {
        int maxDamage = this.weaponType.getMaxDamage();

        for (int i = 0; i < this.getAllStrength(); i++) {
            maxDamage += 3;
        }

        for (int i = 0; i < this.getAllAgility(); i++) {
            maxDamage += 4;
        }

        return maxDamage;
    }

    private int getAllStrength() {
        int strength = 0;

        for (Gem socket : this.sockets) {

            if (socket != null) {
                strength += socket.getStrength();
            }
        }

        return strength;
    }

    private int getAllAgility() {
        int agility = 0;

        for (Gem socket : this.sockets) {

            if (socket != null) {
                agility += socket.getAgility();
            }
        }

        return agility;
    }

    private int getVitality() {
        int vitality = 0;

        for (Gem socket : this.sockets) {

            if (socket != null) {
                vitality += socket.getVitality();
            }
        }

        return vitality;
    }

    @Override
    public double calculateItemLevel() {
        double averageMinMax = (this.getMinDamage() + this.getMaxDamage()) / 2.0;
        return averageMinMax + (this.getAllStrength() + this.getAllAgility() + this.getVitality());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getAllStrength(),
                this.getAllAgility(),
                this.getVitality());
    }

    public String compareToString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getAllStrength(),
                this.getAllAgility(),
                this.getVitality(),
                this.calculateItemLevel());
    }

    @Override
    public int compareTo(Weapon weapon) {

        if (this.calculateItemLevel() > weapon.calculateItemLevel()) {
            return -1;
        } else if (this.calculateItemLevel() < weapon.calculateItemLevel()) {
            return 1;
        }

        return 0;
    }
}
