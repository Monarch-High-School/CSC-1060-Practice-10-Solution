/**
 * Unit tests for MatrixManipulator
 * @author J. Cihlar
 * @version 1.0
 * @since 2025-03
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MatrixManipulatorTest {
    private final double DELTA = 1e-6;

    // Test for getAverage
    @Test
    public void testGetAverage() {
        double[][] matrix = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };
        double expected = 5.0;
        double actual = MatrixManipulator.getAverage(matrix);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testGetAverageEmptyMatrix() {
        double[][] matrix = {};
        assertThrows(IllegalArgumentException.class, () -> MatrixManipulator.getAverage(matrix));
    }

    @Test
    public void testGetAverageSingleElement() {
        double[][] matrix = {
            {10.0}
        };
        double expected = 10.0;
        double actual = MatrixManipulator.getAverage(matrix);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testGetAverageNegativeValues() {
        double[][] matrix = {
            {-1.0, -2.0},
            {-3.0, -4.0}
        };
        double expected = -2.5;
        double actual = MatrixManipulator.getAverage(matrix);
        assertEquals(expected, actual, DELTA);
    }

    // Test for getAverageRows
    @Test
    public void testGetAverageRows() {
        double[][] matrix = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };
        double[] expected = {2.0, 5.0, 8.0};
        double[] actual = MatrixManipulator.getAverageRows(matrix);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], DELTA);
        }
    }

    @Test
    public void testGetAverageRowsEmptyMatrix() {
        double[][] matrix = {};
        assertThrows(IllegalArgumentException.class, () -> MatrixManipulator.getAverageRows(matrix));
    }

    @Test
    public void testGetAverageRowsSingleRow() {
        double[][] matrix = {
            {2.0, 4.0, 6.0}
        };
        double[] expected = {4.0};
        double[] actual = MatrixManipulator.getAverageRows(matrix);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], DELTA);
        }
    }

    // Test for getAverageCol
    @Test
    public void testGetAverageCol() {
        double[][] matrix = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };
        double[] expected = {4.0, 5.0, 6.0};
        double[] actual = MatrixManipulator.getAverageCol(matrix);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], DELTA);
        }
    }

    @Test
    public void testGetAverageColEmptyMatrix() {
        double[][] matrix = {};
        assertThrows(IllegalArgumentException.class, () -> MatrixManipulator.getAverageCol(matrix));
    }

    @Test
    public void testGetAverageColSingleColumn() {
        double[][] matrix = {
            {1.0},
            {2.0},
            {3.0}
        };
        double[] expected = {2.0};
        double[] actual = MatrixManipulator.getAverageCol(matrix);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], DELTA);
        }
    }

    // Test for reshape
    @Test
    public void testReshape() {
        double[][] matrix = {
            {1.0, 2.0, 3.0, 4.0},
            {5.0, 6.0, 7.0, 8.0}
        };
        double[][] expected = {
            {1.0, 2.0},
            {3.0, 4.0},
            {5.0, 6.0},
            {7.0, 8.0}
        };
        double[][] actual = MatrixManipulator.reshape(matrix, 4, 2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testReshapeInvalidDimensions() {
        double[][] matrix = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0}
        };
        assertThrows(IllegalArgumentException.class, () -> MatrixManipulator.reshape(matrix, 3, 3));
    }

    @Test
    public void testReshapeSingleElement() {
        double[][] matrix = {
            {1.0}
        };
        double[][] reshaped = MatrixManipulator.reshape(matrix, 1, 1);
        assertArrayEquals(matrix, reshaped);
    }

    // Test for populateRandom
    @Test
    public void testPopulateRandom() {
        int rows = 3;
        int cols = 3;
        int lower = 1;
        int upper = 10;
        int[][] randomMatrix = MatrixManipulator.populateRandom(rows, cols, lower, upper);

        assertEquals(rows, randomMatrix.length);
        assertEquals(cols, randomMatrix[0].length);

        // Verify that all elements are within the given range
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertTrue(randomMatrix[i][j] >= lower && randomMatrix[i][j] <= upper);
            }
        }
    }

    @Test
    public void testPopulateRandomInvalidBounds() {
        int rows = 3;
        int cols = 3;
        int lower = 10;
        int upper = 1;
        assertThrows(IllegalArgumentException.class, () -> MatrixManipulator.populateRandom(rows, cols, lower, upper));
    }

    // Test for containsDuplicates
    @Test
    public void testContainsDuplicates() {
        String[][] matrix = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"}
        };
        boolean expected = false;
        boolean actual = MatrixManipulator.containsDuplicates(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void testContainsDuplicatesWithDuplicates() {
        String[][] matrix = {
            {"a", "b", "c"},
            {"d", "e", "a"},
            {"g", "h", "i"}
        };
        boolean expected = true;
        boolean actual = MatrixManipulator.containsDuplicates(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void testContainsDuplicatesEmptyMatrix() {
        String[][] matrix = {};
        boolean expected = false;
        boolean actual = MatrixManipulator.containsDuplicates(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void testContainsDuplicatesSingleRow() {
        String[][] matrix = {
            {"a", "b", "a"}
        };
        boolean expected = true;
        boolean actual = MatrixManipulator.containsDuplicates(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void testContainsDuplicatesSingleElement() {
        String[][] matrix = {
            {"a"}
        };
        boolean expected = false;
        boolean actual = MatrixManipulator.containsDuplicates(matrix);
        assertEquals(expected, actual);
    }
}
