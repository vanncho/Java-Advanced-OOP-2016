package pr01_Database.models;

import pr01_Database.interfaces.MyDatabase;
import pr01_Database.interfaces.People;

import javax.naming.OperationNotSupportedException;
import java.util.NoSuchElementException;

public class Database implements MyDatabase<People> {

    private People[] people;
    private int elementsCount = 0;
    private int index;


    public Database(People... people) throws OperationNotSupportedException {
        this.elementsCount = people.length;
        this.setElements(people);
        this.index = elementsCount - 1;
    }

    @Override
    public void add(People people) throws OperationNotSupportedException {

        int samePeopleCount = 0;

        if (people == null) {
            throw new OperationNotSupportedException();
        }

        if (people.getId() == null || people.getId() < 0) {
            throw new OperationNotSupportedException();
        }

        for (People currentPerson : this.people) {

            if (currentPerson != null) {
                if (Long.compare(currentPerson.getId(), people.getId()) == 0) {
                    samePeopleCount++;
                }

                if (samePeopleCount >= 1) {
                    throw new OperationNotSupportedException();
                }
            }
        }

        this.people[++index] = people;
        this.elementsCount++;
    }

    @Override
    public void remove() {
        this.people[index--] = null;
        this.elementsCount--;
    }

    @Override
    public People[] getElements() {
        People[] buffer = new PeopleImpl[elementsCount];
        int bufferIndex = 0;

        for (People element : people) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }

        return buffer;
    }

    private void setElements(People... people) throws OperationNotSupportedException {

        if (people.length > 16 ||
                people.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.people = new PeopleImpl[16];
        int bufferIndex = 0;

        for (People element : people) {
            this.people[bufferIndex++] = element;
        }

        this.index = people.length - 1;
    }

    @Override
    public People findById(Long id) throws OperationNotSupportedException {

        for (int i = 0; i < this.people.length; i++) {

            if (this.people[i] instanceof People) {
                People currentPerson = this.people[i];

                if (currentPerson.getId().compareTo(id) == 0) {
                    return currentPerson;
                }
            }
        }

        throw new OperationNotSupportedException();
    }

    @Override
    public People findByUsername(String userName) throws OperationNotSupportedException {

        for (int i = 0; i < this.people.length; i++) {

            if (this.people[i] instanceof People) {
                People currentPerson = this.people[i];

                if (currentPerson.getUserName().equals(userName)) {
                    return currentPerson;
                }
            }
        }

        throw new OperationNotSupportedException();
    }
}