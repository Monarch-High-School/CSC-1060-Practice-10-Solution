/**
 * Practice 10 - Solution
 * This Java class contains a series of static methods that are designed to manipulate 2D arrays.
 * @author J .Cihlar
 * @version 1.0
 * @since 2025-03
 */


 import java.util.HashSet;

 public class MatrixManipulator {

    /**
     * Computes the average of the values in a 2D array of doubles.
     * @param matrix A 2-dimensional array of double values
     * @return The average of all values in the matrix
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static double getAverage(double [][] matrix) throws IllegalArgumentException {
      if (matrix.length == 0) {
         throw new IllegalArgumentException("Matrix has no rows");
      }

      double total = 0.0;
      int count = 0;
      for (double [] row : matrix) {
         for (double val : row) {
            total += val;
            count++;
         }
      }
      if (count == 0) {
         throw new IllegalArgumentException("Matrix had no values");
      }
      return total/count;
    }

    /**
     * Computes the averages of all values for each row in a 2-D array of doubles.
     * @param matrix A 2-dimensional array of double values
     * @return An array of doubles containing averages of the rows.
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static double[] getAverageRows(double [][] matrix) throws IllegalArgumentException {
      if (matrix.length == 0) {
         throw new IllegalArgumentException("Matrix has no rows");
      }
      double [] result = new double[matrix.length];

      for (int row = 0; row < matrix.length; row++) {
         int count = 0;
         double total = 0.0;
         for (int col = 0; col < matrix[0].length; col++) {
            total += matrix[row][col];
            count++;
         }
         if (count == 0) {
            throw new IllegalArgumentException("Row index " + row + " had no values.");
         }
         result[row] = total/count;
      }
      return result;
    }

    /**
     * Computes the averages of all values for each column in a 2-D array of doubles.
     * @param matrix A 2-dimensional array of double values
     * @return An array of doubles containing averages of the columns.
     * @throws IllegalArgumentException if the matrix is empty (has no columns) or if rows are not the same length
     */
    public static double[] getAverageCol(double [][] matrix) throws IllegalArgumentException {
      if (matrix.length == 0) {
         throw new IllegalArgumentException("Matrix has no rows");
      }
      int len = matrix[0].length;
      for (double[] row : matrix) {
         if (row.length != len) {
            throw new IllegalArgumentException("Row are not the same length.");
         }
      }

      double [] result = new double[matrix[0].length];

      for (int col = 0; col < matrix[0].length; col++) {
         int count = 0;
         double total = 0.0;
         for (int row = 0; row < matrix.length; row++) {
            total += matrix[row][col];
            count++;
         }
         result[col] = total/count;
      }
      return result;
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
      if (matrix.length == 0) {
         throw new IllegalArgumentException("Matrix has no rows");
      }
         // check resizability
      if (rows * cols != matrix.length * matrix[0].length) {
         throw new IllegalArgumentException(matrix.length + "x" + matrix[0].length + " matrix cannot be resized to " + rows + "x" + cols + ".");
      }

      double [][] result = new double[rows][cols];

      int newRow = 0;
      int newCol = 0;

      for (int row = 0; row < matrix.length; row++) {
         for (int col = 0; col < matrix[row].length; col++) {
            result[newRow][newCol] = matrix[row][col];
               // increment and wrap-around if needed
            newCol++;
            if (newCol >= cols) {
               newCol = 0;
               newRow++;
            }
         }
      }
      return result;
    }

    /**
     * Creates a new 2-dimensional array of random integers in the range [lower ... upper]
     * @param rows The number of rows in the array
     * @param cols The number of cols in the array
     * @param lower The lower inclusive bound of the range. lower must be strictly less than upper
     * @param upper The upper inclusive bound of the range
     * @return A rows x cols 2-D array of random ints between [lower ... upper]
     * @throws IllegalArgumentException if the number of rows or cols < 1 or if lower >= upper
     * 
     */
    public static int[][] populateRandom(int rows, int cols, int lower, int upper) throws IllegalArgumentException {
         if (rows < 1) {
            throw new IllegalArgumentException("Invalid number of rows.");
         }
         if (cols < 1) {
            throw new IllegalArgumentException("Invalid number of columns.");
         }

         if (lower >= upper) {
            throw new IllegalArgumentException("Lower must be strictly less than upper.");
         }

         int [][] result = new int[rows][cols];

         for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
               result[row][col] = (int)(Math.random() * (upper - lower + 1)) + lower;
            }
         }
         return result;
    }

    /**
     * Determines whether a 2-dimensional array of String objects contains duplicated values.
     * @param matrix A 2-dimensional array of String objects
     * @return boolean whether the matrix contains any duplicated values
     * @throws IllegalArgumentException if the matrix is empty (has no columns)
     */
    public static boolean containsDuplicates(String [][] matrix) throws IllegalArgumentException {
      if (matrix.length == 0) {
         throw new IllegalArgumentException("Matrix is empty.");
      }
         // this solution uses HashSet, which is an efficient way of tracking what chars you've seen
      HashSet<String> hs = new HashSet<String>();
         // iterate over matrix
      for (String [] row : matrix) {
         for (String s : row) {
               // check if we've seen the string before
               // if so, then return true
            if (hs.contains(s)) {
               return true;
            }
               // otherwise add to the set
            else {
               hs.add(s);
            }
         }
      }
      return false;
    }  
 }