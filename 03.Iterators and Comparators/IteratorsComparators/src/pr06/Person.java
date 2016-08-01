package pr06;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }

    @Override
    public int compareTo(Person o) {
        return 1;
    }

    static class PersonAgeCompare implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {

            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (o1.getAge() > o2.getAge()) {
                return 1;
            }

            return 0;
        }
    }

    static class PersonNameCompare implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {

            if (o1.getName().length() == o2.getName().length()) {
                String firstLetterThis = o1.getName().charAt(0) + "";
                String firstLetterOther = o2.getName().charAt(0) + "";

                return firstLetterThis.compareToIgnoreCase(firstLetterOther);
            }

            if (o1.getName().length() < o2.getName().length()) {
                return -1;
            } else if (o1.getName().length() > o2.getName().length()) {
                return 1;
            }

            return 0;
        }
    }
}
