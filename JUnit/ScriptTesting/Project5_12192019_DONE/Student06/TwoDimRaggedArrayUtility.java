import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Utility class used to process multi-dimensional arrays and text files containing store sales information
 * 
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
 * 
 * This utility works with negative and positive numbers
 * 
 * This is a utility class - there are no private data members
 * 
 * 
 *
 */
public class TwoDimRaggedArrayUtility {
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 *
	 * @param data the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of elements/num of elements)
	 */
	public static double getAverage(double[][] data) {
		
		int count = 0;
		double total = 0;
		
		for (int row = 0; row < data.length; row++) {
			
			for (int col = 0; col < data[row].length; col++) {
				
				total += data[row][col];
				count++;
			}
		}
		
		return (total/count);
		
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array index 0 refers to the first column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		
		double total = 0;
		
		for (int row = 0; row < data.length; row++) {
			
			if (col < data[row].length) {
				
				total += data[row][col];
			}
		}
		
		return total;
	}
	
	/**
	 * Returns the largest element in the two dimensional array
	 * 
	 * @param data the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double [][] data) {
		
		double highest = -Double.MAX_VALUE;
		
		for (int row = 0; row < data.length; row++) {
			
			for (int col = 0; col < data[row].length; col++) {
				
				if (data[row][col] > highest) {
					
					highest = data[row][col];
				}
				
			}
		}
		
		return highest;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method. 
	 * 
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		
		double highest = -Double.MAX_VALUE;
		
		for (int row = 0; row < data.length; row++) {
			
			if (col < data[row].length) {
				
				if (data[row][col] > highest) {
				
					highest = data[row][col];
				}
			}
		}
		
		return highest;
	}
	
	/**
	 * Returns the index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the index of the largest element in the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		double highest = -Double.MAX_VALUE;
		int highestIndex = -1;
		
		for (int row = 0; row < data.length; row++) {
			
			if (col < data[row].length) {
				
				if (data[row][col] > highest) {
	
					highest = data[row][col];
					highestIndex = row;
				}
			}
		}
		
		return highestIndex;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row
	 * 
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		
		double highest = -Double.MAX_VALUE;
		
		for (int col = 0; col < data[row].length; col++) {
			 
			if (data[row][col] > highest) {
				
				highest = data[row][col];
			}
		}
		
		return highest;
	}
	
	/**
	 * Returns the index of largest element of the selected row in the two dimensional array index 0 refers to the first row/
	 * 
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the index of largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		double highest = -Double.MAX_VALUE;
		int highestIndex= -1;
		
		for (int col = 0; col < data[row].length; col++) {
			 
			if (data[row][col] > highest) {
				
				highest = data[row][col];
				highestIndex = col;
			}
		}
		
		return highestIndex;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		
		double lowest = Double.MAX_VALUE;
		
		for (int row = 0; row < data.length; row++) {
			
			for (int col = 0; col < data[row].length; col++) {
				
				if (data[row][col] < lowest) {
					
					lowest = data[row][col];
				}
			}
		}
		
		return lowest;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		
		double lowest = Double.MAX_VALUE;
		
		for (int row = 0; row < data.length; row++) {
			
			if (col < data[row].length) {
			
				if (data[row][col] < lowest) {
				
					lowest = data[row][col];
				}
			}
		}
		
		return lowest;
	}
	
	/**
	 * Returns the index of the smallest element in the two dimensional array index 0 refers to the first column.  If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this method.
	 * 
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		double lowest = Double.MAX_VALUE;
		int lowestIndex = -1;
		
		for (int row = 0; row < data.length; row++) {
			
			if (col < data[row].length) {
				
				if (data[row][col] < lowest) {
				
					lowest = data[row][col];
					lowestIndex = row;
				}
			}
		}
		
		return lowestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * 
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		
		double lowest = Double.MAX_VALUE;
		
		for (int col = 0; col < data[row].length; col++) {
			
			if (data[row][col] < lowest) {
				
				lowest = data[row][col];
			}
		}
		
		return lowest;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row
	 * 
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		
		double lowest = Double.MAX_VALUE;
		int lowestIndex = -1;
		
		for (int col = 0; col < data[row].length; col++) {
			
			if (data[row][col] < lowest) {
				
				lowest = data[row][col];
				lowestIndex = col;
			}
		}
		
		return lowestIndex;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * 
	 * @param data the two dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		
		double total = 0;
		
		for (int col = 0; col < data[row].length; col++) {
			
			total += data[row][col];
		}
		
		return total;
	}
	
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data the two dimensional array
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		for (int row = 0; row < data.length; row++) {
			
			for (int col = 0; col < data[row].length; col++) {
				
				total += data[row][col];
			}
		}
		
		return total;
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles. 
	 * The maximum rows is 10 and the maximum columns for each row is 10.
	 * Each row in the file is separated by a new line.
	 * Each element in the row is separated by a space.
	 * 
	 * @param file the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty.
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		
		// First part creates a 10x10 temp. array, opens the file, and reads it into the temp. array. While doing this, it counts how many lines are read in.
		
		String[][] tempArray = new String[10][10];
		int lineCount = 0;
		
		Scanner fileScanner = new Scanner(file);
		
		// Return a null if the file is empty
		if (!(fileScanner.hasNext())) {				
			
			fileScanner.close();
			return null;
		}
		
		// The file is not empty, proceed
		while (fileScanner.hasNext()) {
			
			String line = fileScanner.nextLine();
			
			tempArray[lineCount] = line.split(" "); // tokenize the line using space as the delimiter and read each token into it's own element in the row
			lineCount++;
			}
		
		// Second part closes the file, creates a new array with the correct number of lines, initializes each row to the number of non-null columns in the
		// corresponding row in the temp. array, then copies the values from the temp. array to the final array, converting each element from String to double.
		
		fileScanner.close();
		double[][] finalArray = new double[lineCount][];				 
		
		for (int row = 0; row < finalArray.length; row++) {
			
			int colCount = 0;
			
			for (int col = 0; col < tempArray[row].length; col++) {		
				
				if (!(tempArray[row][col] == null)) {
					
					colCount++;
				}
			}
			
			finalArray[row] = new double[colCount];						
			
			for (int i = 0; i < finalArray[row].length; i++) {
				
				finalArray[row][i] = Double.parseDouble(tempArray[row][i]);
			}
		}
			
		return finalArray;
	}
	
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.
	 * 
	 * @param data the two dimensional array
	 * @param outputfile the file to write to
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputfile) throws FileNotFoundException {
		
		PrintWriter outFile = new PrintWriter(outputfile);
		
		for (int row = 0; row < data.length; row++) {
			
			for (int col = 0; col < data[row].length; col++) {
				
				outFile.print(data[row][col] + " ");
			}
			
			outFile.println();	
		}
		
		outFile.close();
		
	}
}  