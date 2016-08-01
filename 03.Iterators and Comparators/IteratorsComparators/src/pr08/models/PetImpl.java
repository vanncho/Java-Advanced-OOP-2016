package pr08.models;

import pr08.interfaces.Pet;

public class PetImpl implements Pet {

    private String name;
    private int age;
    private String kind;

    public PetImpl(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
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
    public String getKind() {
        return this.kind;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.getName(), this.getAge(), this.getKind());
    }
}
