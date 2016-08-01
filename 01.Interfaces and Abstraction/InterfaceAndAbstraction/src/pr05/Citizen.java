package pr05;

import pr05.interfaces.Human;
import pr05.interfaces.Serializable;

public class Citizen implements Human, Serializable {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
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
}
