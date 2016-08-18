package pr00_LiveDemo.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pr00_LiveDemo.interfaces.MyList;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class CustomListTest {

    private MyList<Integer> customList;

    // Zakomentirano e zashtoto v dolnite testove shte polzvame razlichni vhodni: new CustomList<>(1,2,3);
    //@Before
    //public void initialize() {
    //    this.customList = new CustomList<>(1,2,3);
    //}

    //region constructor
    @Test
    public void constructorCheckCorrectAddingShouldPass() throws OperationNotSupportedException {

        // Arrange
        this.customList = new CustomList<>(1,2,3);
        String expected = "[1, 2, 3]";

        // Act
        String actual = customList.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorCheckNoArgumentsShouldPass() throws OperationNotSupportedException {

        // Arrange
        this.customList = new CustomList<>();
        String expected = "[]";

        // Act
        String actual = customList.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorCheckNullArgumentsShouldPass() throws OperationNotSupportedException {

        this.customList = new CustomList<>(null);
    }
    //endregion

    @Test
    public void add() throws Exception {

    }

    @Test
    public void element() throws Exception {

    }

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void iterator() throws Exception {

    }

    @Test
    public void forEach() throws Exception {

    }
}