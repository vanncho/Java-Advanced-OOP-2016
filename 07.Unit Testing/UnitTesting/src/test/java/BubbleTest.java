import org.junit.Assert;
import org.junit.Test;
import pr03_BubbleSortTest.Bubble;

public class BubbleTest {

    @Test
    public void sortingIntegersShouldSortCorrectly() {

        // Arrange
        Integer[] elements = {7, 2, 9, 5, 3};
        Integer[] expected = {2, 3, 5, 7, 9};

        // Act
        Integer[] actual = Bubble.sort(Integer.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingStringShouldSortCorrectly() {

        // Arrange
        String[] elements = {"ivan", "pesho", "asen"};
        String[] expected = {"asen", "ivan", "pesho"};

        // Act
        String[] actual = Bubble.sort(String.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingDoubleShouldSortCorrectly() {

        //Arrange
        Double[] elements = {0.5, 0.1, 0.3, 0.2};
        Double[] expected = {0.1, 0.2, 0.3, 0.5};

        // Act
        Double[] actual = Bubble.sort(Double.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingWithEqualsElementsShouldSortCorrectly() {

        // Arrange
        Integer[] elements = {5, 5, 8, 8, 4, 4};
        Integer[] expected = {4, 4, 5, 5, 8, 8};

        // Act
        Integer[] actual = Bubble.sort(Integer.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortSortedElementsShouldSortCorrectly() {

        // Arrange
        Double[] elements = {1.1, 2.2, 3.3, 4.4};
        Double[] expected = {1.1, 2.2, 3.3, 4.4};

        // Act
        Double[] actual = Bubble.sort(Double.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortCollectionWithNullsElementsShouldSortCorrectly() {

        // Arrange
        Integer[] elements = {null, null, null};
        Integer[] expected = {null, null, null};

        // Act
        Integer[] actual = Bubble.sort(Integer.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingCollectionWithNumbersAndNullsShouldSortCorrectly() {

        // Arrange
        Integer[] elements = {null, 8, 4, null, 5};
        Integer[] expected = {4, 5, 8, null, null};

        // Act
        Integer[] actual = Bubble.sort(Integer.class, elements);

        // Assert
        Assert.assertArrayEquals(expected, actual);
    }
}
