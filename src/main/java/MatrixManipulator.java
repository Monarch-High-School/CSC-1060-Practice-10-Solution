/**
 * Practice 10
 * This Java class contains a series of static methods that are designed to manipulate 2D arrays.
 * @author
 * @version 1.0
 * @since 2025-03
 */

 public class MatrixManipulator {

    /**
     * Computes the average of the values in a 2D array of doubles.
     * @param matrix A 2-dimensional array of double values
     * @return The average of all values in the matrix
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static double getAverage(double [][] matrix) throws IllegalArgumentException {

    }

    /**
     * Computes the averages of all values for each row in a 2-D array of doubles.
     * @param matrix A 2-dimensional array of double values
     * @return An array of doubles containing averages of the rows.
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static double[] getAverageRows(double [][] matrix) throws IllegalArgumentException {

    }

    /**
     * Computes the averages of all values for each column in a 2-D array of doubles.
     * @param matrix A 2-dimensional array of double values
     * @return An array of doubles containing averages of the columns.
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static double[] getAverageCol(double [][] matrix) throws IllegalArgumentException {

    }    

    /**
     * Reshapes a 2-D matrix of doubles into a new matrix of rows x cols.
     * Example the matrix [1, 2, 3, 4]
     *                    [5, 6, 7, 8]
     *                   
     * reshaped into a 4 x 2 matrix would be
     *                    [1, 2]
     *                    [3, 4]
     *                    [5, 6]
     *                    [7, 8]
     * @param matrix a 2-d array of doubles
     * @param rows an integer representing the new row dimensions of the matrix
     * @param cols an integer representing the new col dimensions of the matrix
     * @return double[][] a new matrix of dimensions rows x cols. The dimensions of the original matrix 
     * must have the same product as the new matrix. 
     * @throws IllegalArgumentException if the matrix is empty (has no columns) or the matrix cannot be resized per rows and cols
     */
    public static double [][] reshape(double [][] matrix, int rows, int cols) throws IllegalArgumentException {

    }

    /**
     * Creates a new 2-dimensional array of random integers in the range [lower ... upper]
     * @param rows The number of rows in the array
     * @param cols The number of cols in the array
     * @param lower The lower inclusive bound of the range
     * @param upper The upper inclusive bound of the range
     * @return A rows x cols 2-D array of random ints between [lower ... upper]
      * @throws IllegalArgumentException if the number of rows or cols < 1
     * 
     */
    public static int[][] populateRandom(int rows, int cols, int lower, int upper) throws IllegalArgumentException {

    }

    /**
     * Determines whether a 2-dimensional array of String objects contains duplicated values.
     * @param matrix A 2-dimensional array of String objects
     * @return boolean whether the matrix contains any duplicated values
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static boolean containsDuplicates(String [][] matrix) throws IllegalArgumentException{

    }  
 }