import java.io.*;
import java.util.Scanner;
	/**
	 * Class to read in a 2D ragged array, calculate values,
	 * and write to a new file
	 * 
	 *
	 */
public class TwoDimRaggedArrayUtility {
	/**
	 * Method to read in a file of doubles to create a 2D array
	 * @param readFile File object to pass to method
	 * @return array 2D array of data from file
	 * @throws FileNotFoundException if file isn't found
	 */
	public static double[][] readFile(File readFile)throws FileNotFoundException{
		String[][] tempArray = new String [10][10];

		String[] row;
		Scanner inputFile = new Scanner(readFile);
		int rows = 0, columns = 0, k = 0;
		
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			row = line.split(" ");
			for(int j = 0; j < row.length; j++) {
				tempArray[k][j] = row[j];
				}
			k++;
			rows++;
		}
		inputFile.close();	
		
		double[][] array = new double [rows][];
		for(int i = 0; i < rows; i++) {
			columns = 0;
			for(int j = 0; j < tempArray[i].length; j++) {
				if(tempArray[i][j] != null)
					columns++;
			}
			array[i] = new double[columns];	
		}
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(tempArray[i][j] != null) {	
					double tempElement = Double.valueOf(tempArray[i][j]);
					array[i][j] = tempElement;
				}
			}
		}
		return array;
	}
	/**
	 * Method to write data from the array to a file
	 * @param array Data that will be written to the file
	 * @param file File object to open and write to a new file
	 * @throws FileNotFoundException if file isn't found
	 */
	public static void writeToFile(double [][] array, File file) throws FileNotFoundException {
		PrintWriter outputFile = new PrintWriter(file);
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				outputFile.print(array[i][j] + " ");
			}
			outputFile.println();
		}
		outputFile.close();
	}
	/**
	 * Method to calculate the total of the array values
	 * @param array 2D ragged array to pass to the method
	 * @return total Total of the array
	 */
	public static double getTotal(double[][] array) {
		double total = 0.0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				total += array[i][j];
			}
		}
		return total;
	}
	/**
	 * Method to calculate the average of the array values
	 * @param array 2D ragged array to pass to the method
	 * @return average Average of the array
	 */
	public static double getAverage(double[][] array) {
		double total = 0.0;
		double average;
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				total += array[i][j];
				count++;
			}
		}
		average = total/(double)count;
		return average;
	}
	/**
	 *  Method to calculate the total of a row
	 * @param array 2D ragged array to pass to the method
	 * @param row The row index
	 * @return rowTotal Total of row values
	 */
	public static double getRowTotal(double[][]array, int row) {
		double rowTotal = 0.0;
		for(int i = 0; i < array[row].length; i++) {
			rowTotal += array[row][i];
		}
		return rowTotal;
	}
	/**
	 * Method to calculate the total of a column
	 * @param array 2D array to pass to the method
	 * @param col The column index
	 * @return colTotal Total of the column values
	 */
	public static double getColumnTotal(double[][] array, int col) {
		double colTotal = 0.0;

		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else
				colTotal += array[i][col];
		}
		return colTotal;
	}
	/**
	 * Method to calculate the highest value in a row
	 * @param array 2D array to pass to the method
	 * @param row The row index
	 * @return highest Highest of row values
	 */
	public static double getHighestInRow(double[][] array, int row) {
		double highest = array[row][0];
		for(int i = 1; i < array[row].length; i++) {
			if(array[row][i] > highest) {
				highest = array[row][i];
			}
		}
		return highest;
	}
	/**
	 * Method to return the index of the highest in a row
	 * @param array 2D array to pass to method
	 * @param row The row index
	 * @return count Index of the highest in the row
	 */
	public static int getHighestInRowIndex(double[][] array, int row) {
		double highest = array[row][0];
		int count = 0;
		for(int i = 1; i < array[row].length; i++) {
			if(array[row][i] > highest) {			
				highest = array[row][i];
				count = i;
			}
		}
		return count;
	}
	/**
	 * Method to return the lowest in a row
	 * @param array 2D array to pass to method
	 * @param row The row index
	 * @return lowest Lowest of row values
	 */
	public static double getLowestInRow(double[][] array, int row) {
		double lowest = array[row][0];
		for(int i = 1; i < array[row].length; i++) {
			if(array[row][i] < lowest) {
				lowest = array[row][i];
			}
		}
		return lowest;
	}
	/**
	 * Method to return the index of the lowest in a row
	 * @param array 2D array to pass to method
	 * @param row The row index
	 * @return count Index of lowest in row
	 */
	public static int getLowestInRowIndex(double[][] array, int row) {
		double lowest = array[row][0];
		int count = 0;
		for(int i = 1; i < array[row].length; i++) {
			if(array[row][i] < lowest) {
				lowest = array[row][i];
				count = i;
			}
		}
		return count;
	}
	/**
	 * Method to return the highest in a column
	 * @param array 2D array to pass to method
	 * @param col The column index
	 * @return highest Highest value in column 
	 */
	public static double getHighestInColumn(double[][] array, int col) {
		double highest = 0;//= array[0][col];
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else
				highest= array[i][col];
		}

		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else 
				if(array[i][col] > highest) {
				highest = array[i][col];
			}
		}
		return highest;
	}
	/**
	 * Method to return the index of the highest value in a column
	 * @param array 2D array to pass to method
	 * @param col The column index
	 * @return count Index of highest in column
	 */
	public static int getHighestInColumnIndex(double[][] array, int col) {
		int count = 0;
		double highest = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else
				highest= array[i][col];
		}
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else
				if(array[i][col] >= highest) {
				highest = array[i][col];
				count = i;
				}
		}
		return count;
	}
	/**
	 * Method to return the lowest value in a column
	 * @param array 2D array to pass to method
	 * @param col The column index
	 * @return lowest Lowest value in column
	 */
	public static double getLowestInColumn(double[][] array, int col) {
		double lowest = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else
				lowest = array[i][col];
		}
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else 
				
				if(array[i][col] < lowest) {
				lowest = array[i][col];
			}
		}
		return lowest;
	}
	/**
	 * Method to return index of lowest value in a column
	 * @param array 2D array to pass to method
	 * @param col The column index
	 * @return count Index of lowest value in column
	 */
	public static int getLowestInColumnIndex(double[][] array, int col) {
		double lowest = 0;
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length)
				continue;
			else
				lowest = array[i][col];
		}
		
		for(int i = 0; i < array.length; i++) {
			if(col >= array[i].length) 
				continue;
			else
				if(array[i][col] < lowest) {
				lowest = array[i][col];
				count = i;
				}
		}
		return count;
	}
	/**
	 * Method to return highest value in the array
	 * @param array 2D array to pass to method
	 * @return highest Highest value in array
	 */
	public static double getHighestInArray(double[][] array) {
		double highest = array[0][0];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] > highest) {
					highest = array[i][j];
				}
			}
		}
		return highest;
	}
	/**
	 * Method to return lowest value in the array
	 * @param array 2D array to pass to method
	 * @return lowest Lowest value in array
	 */
	public static double getLowestInArray(double[][] array) {
		double lowest = array[0][0];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] < lowest) {
					lowest = array[i][j];
				}
			}
		}
		return lowest;
	}
}
