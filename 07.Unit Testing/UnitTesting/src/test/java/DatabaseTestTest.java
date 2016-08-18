import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import pr00_LiveDemo.models.CustomList;
import pr01_Database.interfaces.MyDatabase;
import pr01_Database.interfaces.People;
import pr01_Database.models.Database;
import pr01_Database.models.Gosho;
import pr01_Database.models.Ivan;
import pr01_Database.models.Spas;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DatabaseTestTest {

    private Database database;
    private People gosho;
    private People ivan;

    @Before
    public void initialize() throws OperationNotSupportedException {
        //this.database = new Database(1, 2, 3, 4);
        gosho = new Gosho("goshoPi4", 223344532325L);
        ivan = new Ivan("vancho", 143545675678L);
    }

    ////region Constructors
    //@Test(expected = OperationNotSupportedException.class)
    //public void constructorWithMoreElementsShouldThrowException() throws OperationNotSupportedException {
    //    this.database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    //}
//
    //@Test(expected = OperationNotSupportedException.class)
    //public void constructorWithNoElementShouldThrowException() throws OperationNotSupportedException {
    //    this.database = new Database();
    //}
    ////endregion
//
    ////region add
    //@Test(expected = OperationNotSupportedException.class)
    //public void addElementNullShouldThrowsException() throws OperationNotSupportedException {
    //    Integer element = null;
    //    this.database.add(element);
    //}
//
    //@Test
    //public void addedElementShouldBeAtLastIndex() throws OperationNotSupportedException {
//
    //    // Arrange
    //    int elementToAdd = 3;
    //    int expectedIndex = 4;
//
    //    // Act
    //    this.database.add(elementToAdd);
//
    //    // Assert
    //    Assert.assertTrue(this.database.getElements()[expectedIndex] == elementToAdd);
    //}
//
    //@Test(expected = OperationNotSupportedException.class)
    //public void addNullElementShouldThrowException() throws OperationNotSupportedException {
    //    Integer element = null;
    //    this.database.add(element);
    //}
    ////endregion
//
    ////region remove
    //@Test
    //public void collectionLengthAfterRemovalShouldBeLesser() {
//
    //    // Arrange
    //    int expected = this.database.getElements().length - 1;
//
    //    // Act
    //    this.database.remove();
//
    //    // Assert
    //    Assert.assertEquals(this.database.getElements().length, expected);
    //}
//
    //@Test
    //public void theRemovalElementShouldNotExistsAfterRemoval() {
//
    //    // Arrange
    //    String expected = "1 2 3";
//
    //    // Act
    //    this.database.remove();
    //    String actual = Arrays.stream(this.database.getElements())
    //            .map(Object::toString)
    //            .collect(Collectors.joining(" "));
//
    //    // Assert
    //    Assert.assertEquals(expected, actual);
    //}
    ////end region
//
    //@Test
    //public void getElementsShouldReturnExpectedElements() throws Exception {
    //    // Arrange
    //    String expectedElements = "1 2 3 4";
    //    String actualElements =
    //            Arrays.stream(database.getElements())
    //                    .map(Object::toString)
    //                    .collect(Collectors.joining(" "));
//
    //    // Assert
    //    Assert.assertEquals(actualElements, expectedElements);
//
    //}


    /*
    TEST FUNCTIONALITY OF CHANGED IMPLEMENTATION OF DATABASE TO ACCEPT ONLY PEOPLE
     */


    //region Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void constructorWithNoPeopleShouldThrowException() throws OperationNotSupportedException {

        this.database = new Database();
    }
    //endregion

    //region Add
    @Test(expected = OperationNotSupportedException.class)
    public void addElementNullShouldThrowException() throws OperationNotSupportedException {

        People people = null;
        try {
            this.database.add(people);
        } catch (NullPointerException npe){
            throw new OperationNotSupportedException();
        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPeopleWithNullIdShouldThrowException() throws OperationNotSupportedException {

        MyDatabase myDatabase = new Database(this.gosho, this.ivan);
        People duplicateIdPerson = new Spas("spasich", null);
        myDatabase.add(duplicateIdPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPeopleWithNegativeIdShouldThrowException() throws OperationNotSupportedException {

        MyDatabase myDatabase = new Database(this.gosho, this.ivan);
        People duplicateIdPerson = new Spas("spasich", -143545675678L);
        myDatabase.add(duplicateIdPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPeopleWithNullUserNameShouldThrowException() throws OperationNotSupportedException {

        MyDatabase myDatabase = new Database(this.gosho, this.ivan);
        People duplicateIdPerson = new Spas(null, 143545675678L);
        myDatabase.add(duplicateIdPerson);
    }

    @Test
    public void addedPeopleShouldBeAtLastIndex() throws OperationNotSupportedException {

        // Arrange
        MyDatabase myDatabase = new Database(this.gosho);
        myDatabase.add(this.ivan);

        // Act
        People actual = (People) myDatabase.getElements()[1];
//
        // Assert
        Assert.assertEquals(this.ivan, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addedPeopleWithEqualsIdShouldThrowException() throws OperationNotSupportedException {

        MyDatabase myDatabase = new Database(this.gosho, this.ivan);
        People duplicateIdPerson = new Spas("spasich", 143545675678L);
        myDatabase.add(duplicateIdPerson);
    }
    //endregion

    //region Remove
    @Test
    public void collectionLengthAfterRemovalShouldBeLesser() throws OperationNotSupportedException {

        // Arrange
        this.database = new Database(this.ivan, this.gosho);
        int expected = this.database.getElements().length - 1;

        // Act
        this.database.remove();

        // Assert
        Assert.assertEquals(this.database.getElements().length, expected);
    }
    //endregion

    //region FindById
    @Test
    public void findInCollectionPeopleByIdShouldPass() throws Exception {

        // Arrange
        this.database = new Database(this.gosho, this.ivan);

        // Act
        People actualPeople = this.database.findById(143545675678L);

        // Assert
        Assert.assertEquals(this.ivan, actualPeople);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findInCollectionPeopleByIdNotPresentShouldThrowException() throws Exception {

        // Arrange
        this.database = new Database(this.gosho, this.ivan);

        // Act
        People actualPeople = this.database.findById(99999999999L);
    }
    //endregion

    //region FindByUserName
    @Test
    public void findInCollectionPeopleByUsernameShouldPass() throws Exception {

        // Arrange
        this.database = new Database(this.gosho, this.ivan);

        // Act
        People actualPeople = this.database.findByUsername("vancho");

        // Assert
        Assert.assertEquals(this.ivan, actualPeople);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findInCollectionPeopleByUserNameNotPresentShouldThrowException() throws Exception {

        // Arrange
        this.database = new Database(this.gosho, this.ivan);

        // Act
        People actualPeople = this.database.findByUsername("svircho");
    }
    //endregion
}