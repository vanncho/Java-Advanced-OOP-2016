package pr10.enumerators;

public enum WeaponType {

    AXE(5, 10, 4),
    SWORD(4, 6, 3),
    KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int maxNumberOfSockets;

    private WeaponType(int minDamage, int maxDamage, int maxNumberOfSockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxNumberOfSockets = maxNumberOfSockets;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMaxNumberOfSockets() {
        return maxNumberOfSockets;
    }
}
