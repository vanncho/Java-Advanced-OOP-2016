package pr01_Database.interfaces;

import javax.naming.OperationNotSupportedException;

public interface MyDatabase<People> {

    void add(People element) throws OperationNotSupportedException;

    void remove();

    People[] getElements();

    People findById(Long id) throws OperationNotSupportedException;

    People findByUsername(String userName) throws OperationNotSupportedException;
}
