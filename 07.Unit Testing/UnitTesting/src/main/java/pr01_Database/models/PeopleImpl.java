package pr01_Database.models;

import pr01_Database.interfaces.People;

public abstract class PeopleImpl implements People {

    private String userName;
    private Long id;

    protected PeopleImpl(String userName, Long id) {
        this.setUserName(userName);
        this.setId(id);
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public int compareTo(People people) {

        if (this.getId() < people.getId() && this.getUserName().compareTo(people.getUserName()) < 0) {
            return -1;
        } else if (this.getId() > people.getId() && this.getUserName().compareTo(people.getUserName()) > 0) {
            return 1;
        }

        return 0;
    }
}
