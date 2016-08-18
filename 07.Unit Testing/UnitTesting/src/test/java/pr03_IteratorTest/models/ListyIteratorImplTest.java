package pr03_IteratorTest.models;

import org.junit.Assert;
import org.junit.Test;
import pr03_IteratorTest.interfaces.ListyIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ListyIteratorImplTest {

    private ListyIterator listyIterator;

    //region Constructor
    @Test
    public void addElementNullShouldThrowsException() throws OperationNotSupportedException {

        this.listyIterator = new ListyIteratorImpl(null);
    }
    //endregion

    //region Move
    @Test
    public void moveInternalIndexWithOnePositionShouldActuallyMoveItWithOne() throws Exception {

        // Arrange
        this.listyIterator = new ListyIteratorImpl(Arrays.asList("Ivan", "Gosho", "Pesho"));
        int expectedIndex = 1;

        // Act
        this.listyIterator.move();
        int actualIndex = listyIterator.getInternalIndex();

        // Assert
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void moveInternalIndexInListyIteratorWithMoreThanOneElementShouldReturnTrue() throws Exception {

        // Arrange
        this.listyIterator = new ListyIteratorImpl(Arrays.asList("Ivan", "Gosho", "Pesho"));
        boolean expected = true;

        // Act
        this.listyIterator.move();
        boolean actual = listyIterator.move();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moveInternalIndexInListyIteratorWithOneElementShouldShouldReturnFalse() throws Exception {

        // Arrange
        this.listyIterator = new ListyIteratorImpl(Arrays.asList("Ivan"));
        boolean expected = false;

        // Act
        this.listyIterator.move();
        boolean actual = listyIterator.move();

        // Assert
        Assert.assertEquals(expected, actual);
    }
    //endregion

    // OTHERS DOWN NOT IMPLEMENTED BECAUSE STARTED TO OTHER PROBLEMS FOR JUDGE

    @Test
    public void print() throws Exception {

    }

    @Test
    public void printAll() throws Exception {

    }

    @Test
    public void hasNext() throws Exception {

    }

    @Test
    public void next() throws Exception {

    }

    @Test
    public void iterator() throws Exception {

    }

}