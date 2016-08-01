package pr07.models;

import pr07.interfaces.Birthday;

public class Pet implements Birthday {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
