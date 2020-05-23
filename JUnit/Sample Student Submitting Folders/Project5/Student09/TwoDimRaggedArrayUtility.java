
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *Changes two dimensional array to handle positive and negative numbers.
 * @author Michael Pontillo
 */
public class TwoDimRaggedArrayUtility {

  /**
   * Returns the average of the elements in the two dimensional array
   * 
   * @param data array getting average
   *
   * @return average: (total of elements/num of
   *         elements)
   */
  public static double getAverage(double[][] data) {
    
    int elements = 0;
    double sum = 0;
    for (int i = 0;i < data.length;i++) {
      elements += data[i].length; 
      for (int j = 0;j < data[i].length;j++) {
        sum += data[i][j];
      }
    }
    return sum / elements;
  }

  /**
   * Returns total array index 0 from first column
   * does not output error for non column index
   * @param data 2 dim array
   * @param column first column inxex
   * @return total of column
   */
  public static double getColumnTotal(double[][] data, int column) {
    double columnTot = 0;
    for (int i = 0;i < data.length;i++) {
      if (column >= data[i].length) {
        continue;
      }
        columnTot += data[i][column];
    }
    return columnTot;
  }
  /**
   * Return largest element
   * @param data the two dimensional array
   * @return the largest element 2 dimensional array
   */
  public static double getHighestInArray(double[][] data) {
    double high = -999999;
    for (int i = 0;i < data.length;i++) { 
      for (int j = 0;j < data[i].length;j++) {
        if (data[i][j] > high) {
          high = data[i][j];
        }
      }
    }
    return high;
  }
  /**
   * Returns highest element in array
   * @param data the two dimensional array
   * @param column
   * @return
   */
  public static double getHighestInColumn(double[][] data, int column) {
    double highest = -999999;
    for (int i = 0;i < data.length;i++) {
      if (column >= data[i].length) {
        continue;
      }
      if (data[i][column] > highest) {
        highest = data[i][column];
      }
    }
    return highest;
  }

  /**
   * Returns from index 0 of highest column
   * @param data
   * @param column
   * @return
   */
  public static int getHighestInColumnIndex(double[][] data, int column) {
    double high = -999999;
    int indexHC = -1;
    for (int i = 0;i < data.length;i++) {
      if (column >= data[i].length) {
        continue;
      }
      if (data[i][column] > high ) {
        high = data[i][column];
        indexHC = i;
      }
    }
    return indexHC;
  }

  /**
   * Returns the largest element of the selected row in the two dimensional array index 0 refers to
   * the first row
   * @param data array
   * @param row the row index to find largest element
   * @return the largest element of the row
   */
  public static double getHighestInRow(double[][] data, int row) {
    double highR = -999999;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] > highR) {
        highR = data[row][i];
      }
    }
    return highR;
  }

  /**
   * Returns the largest element of the row
   * @param data
   * @param row index of largest
   * @return
   */
  public static int getHighestInRowIndex(double[][] data, int row) {
    double highRI = -999999;
    int indexRI = -1;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] > highRI) {
        highRI = data[row][i];
        indexRI = i;
      }
    }
    return indexRI;
  }

  /**
   * Returns smallest element within the two dimensional array
   * @param data the two dimensional array
   * @return the smallest element in the two dimensional array
   */
  public static double getLowestInArray(double[][] data) {
    double lowArray = 999999;
    for (int i = 0;i < data.length;i++) { 
      for (int j = 0;j < data[i].length;j++) {
        if (data[i][j] < lowArray) {
          lowArray = data[i][j];
        }
      }
    }
    return lowArray;
  }



  /**
   * Returns the smallest element of the selected column
   * @param data the two dimensional array
   * @param column the column index to find the smallest element
   * @return the smallest element of the column
   */
  public static double getLowestInColumn(double[][] data, int column) {
    double lowC = 999999;
    for (int i = 0;i < data.length;i++) {
      if (column >= data[i].length) {
        continue;
      }
      if (data[i][column] < lowC) {
        lowC = data[i][column];
      }
    }
    return lowC;
  }

  /**
   * Returns the index of the smallest element of the selected column
   * @param data the two dimensional array
   * @param col the column index to find the smallest element
   * @return the index of the smallest element of the column
   */
  public static int getLowestInColumnIndex(double[][] data, int col) {
    double low = 999999;
    int index = -1;
    for (int i = 0;i < data.length;i++) {
      if (col >= data[i].length) {
        continue;
      }
      if (data[i][col] < low ) {
        low = data[i][col];
        index = i;
      }
    }

    return index;

  }


  /**
   * Returns the smallest element in row
   * @param data the two dimensional array
   * @param row the row index to find the smallest element of (0 refers to the first row)
   * @return the smallest element of the row
   */
  public static double getLowestInRow(double[][] data, int row) {
    double lowR = 999999;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] < lowR) {
        lowR = data[row][i];
      }
    }
    return lowR;
  }

  /**
   * Returns the index of the smallest in row
   * @param data the two dimensional array
   * @param row the row index to find the smallest element
   *
   * @return the index of the smallest in row
   */
  public static int getLowestInRowIndex(double[][] data, int row) {
    double lowRI = 999999;
    int index = -1;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] < lowRI) {
        lowRI = data[row][i];
        index = i;
      }
    }
    return index;
  }

  /**
   * Returns the total of the selected row
   * @param data the two dimensional array
   * @param row the row index to take the total
   */
  public static double getRowTotal(double[][] data, int row) {
    double sumOfTotal = 0;
    for (int i = 0;i < data[row].length;i++) {
        sumOfTotal += data[row][i];
    }
    return sumOfTotal;
  }

  /**
   * Returns the total
   * @param data the two dimensional array getting total of
   * @return the sum of all the elements */

  public static double getTotal(double[][] data) {
    double sumOfTotal = 0;
    for (int i = 0;i < data.length;i++) { 
      for (int j = 0;j < data[i].length;j++) {
        sumOfTotal += data[i][j];
      }
    }
    
    return sumOfTotal;
  }

  /**
   * reads and returns data
   * @param file the file to read from
   * @return a two dimensional ragged array of doubles if there is no empty file,
   * program will return null if empty
   * @throws FileNotFoundException 
   */
  public static double[][] readFile(File file) throws FileNotFoundException  {
    Scanner sf = new Scanner(file);
    int indexOfRow = 0;
    String[][] temp = new String[10][]; 


    // read/pass numbers to temp array as String
    while (sf.hasNextLine()) {
     String[] row = sf.nextLine().split(" ");
     temp[indexOfRow] = new String[row.length];
     for (int i = 0;i < row.length;i++) {
       temp[indexOfRow][i]=row[i];
     }
     indexOfRow++;
    }
   // Create double data array and parse numbers as doubles
    double[][]data = new double[indexOfRow][];
    for (int i = 0; i < indexOfRow;i++) {
      data[i]= new double[temp[i].length];
      for (int j = 0;j < temp[i].length;j++) {
          System.out.print(temp[i][j] + " ");
          data[i][j] = Double.parseDouble(temp[i][j]);
      }
      System.out.println();
    }
    
    sf.close();
    return data;
  }

  /**
   * writes ragged array of doubles seperated by line
   * file and each double is separated by a space.
   * @param data two dimensional ragged array of double
   * @param outputFile the file to write to
   * @throws FileNotFoundException 
   */
  public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
    PrintWriter output = new PrintWriter(outputFile);
    StringBuilder sb = new StringBuilder();
    for (int i = 0;i < data.length;i++) {
      for (int j = 0;j < data[i].length;j++) {
        sb.append(data[i][j]).append(" ");
      }
      sb.append("\n");
    }
    output.print(sb.toString());
    output.close();
  }

}
