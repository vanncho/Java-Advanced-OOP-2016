package pr07.models;

import pr07.interfaces.Buyer;
import pr07.interfaces.Human;

public class Rebel implements Human, Buyer {
    private static final int FOOD_AMOUNT = 5;
    private String name;
    private int age;
    private String group;

    public Rebel(String name, int age, String group) {
        this.setName(name);
        this.setAge(age);
        this.setGroup(group);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    @Override
    public int buyFood() {
        return FOOD_AMOUNT;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
