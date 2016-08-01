package pr07.models;

import pr07.interfaces.Person;

public class PersonImpl implements Person, Comparable<Person> {

    private String name;
    private int age;

    public PersonImpl(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
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
    public int hashCode() {
        return this.getName().hashCode() + this.getAge() * 3;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Person)) {
            return false;
        }

        Person current = (Person) obj;
        return this.getName().equals(current.getName()) && this.getAge() == current.getAge();
    }

    @Override
    public int compareTo(Person o) {
        int returnValue = this.getName().compareTo(o.getName());

        if (returnValue == 0) {
            returnValue = Integer.compare(this.getAge(), o.getAge());
        }

        return returnValue;
    }
}
