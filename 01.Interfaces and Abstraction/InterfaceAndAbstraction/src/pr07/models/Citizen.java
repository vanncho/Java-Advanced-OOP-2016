package pr07.models;

import pr07.interfaces.Birthday;
import pr07.interfaces.Buyer;
import pr07.interfaces.Human;
import pr07.interfaces.Serializable;

public class Citizen implements Human, Serializable, Birthday, Buyer {
    private static final int FOOD_AMOUNT = 10;
    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age, String id, String birthday) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthday(birthday);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public int buyFood() {
       return FOOD_AMOUNT;
    }
}
