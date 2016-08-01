package pr05;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {

        if (this.getName().compareTo(other.getName()) == 0 &&
                this.getAge() == other.getAge() &&
                this.getTown().compareTo(other.getTown()) == 0) {
            return 0;
        }

        return -1;
    }
}
