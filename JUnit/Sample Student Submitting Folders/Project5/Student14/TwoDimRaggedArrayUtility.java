
/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
   This utility works with negative and positive numbers
   This is a utility class - there are no private data members
  
   
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10 Each row in the file is
	 * separated by a new line Each element in the row is separated by a space
	 * Suggestion: You need to know how many rows and how many columns there are for
	 * each row to create a ragged array. 1. Read the doubles from the file into an
	 * a temporary array [10][10] of Strings which was initialized to nulls. 2. Find
	 * out how many rows there are (any row that has the first element != null is a
	 * valid row) 3. Create the array based on the num of rows, i.e. double[][]array
	 * = new double[#rows][] 4. Determine the number of columns for the first row
	 * (any element != null is a valid element) 5. Create the first row, i.e.
	 * array[0] = new double[#columns] 6. Put the values from the temporary array
	 * into in the row (don't forget to convert from strings to doubles) 7. Repeat
	 * for all rows
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		double[][] data = null;
		try {
			Scanner input = new Scanner(file);
			int rows = 0;
			while (input.hasNextLine()) {
				++rows;
				input.nextLine();
			}
			input.close();
			input = new Scanner(file);
			String line;
			data = new double[rows][];
			for (int i = 0; i < data.length; ++i) {
				line = input.nextLine();
				String[] nums = line.split(" ");
				data[i] = new double[nums.length];
				for (int j = 0; j < data[i].length; ++j) {
					data[i][j] = Double.valueOf(nums[j]);
				}
			}
			input.close();
		} catch (IOException a) {
			a.printStackTrace();
		}
		return data;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file and each double is separated by a space.
	 * 
	 * @param data
	 * @param file
	 */
	public static void writeToFile(double[][] data, java.io.File file) {
		try {
			PrintWriter out = new PrintWriter(file);
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; ++j) {
					out.print(data[i][j] + " ");
				}
				out.println();
			}
			out.close();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}

	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @param data
	 * @return
	 */
	public static double getAverage(double[][] data) {
		double average = 0;
		int num = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				num += data[i][j];
				num += 1;
			}
		}
		return average / num;
	}

	/**
	 * Returns the largest element in the two dimensional array
	 * 
	 * @param data
	 * @return
	 */
	public static double getHighestInArray(double[][] data)

	{
		double max = 0.0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 0 && j == 0)
					max = data[i][j];
				else if (data[i][j] > max)
					max = data[i][j];
			}
		}
		return max;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < data.length; ++i) {
			if (col < data[i].length && data[i][col] > highest)
				highest = data[i][col];
		}
		return highest;
	}

	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index = 0;
		for (int i = 0; i < data.length; ++i) {

			if (col < data[i].length && data[i][col] == getHighestInColumn(data, col))
				index = i;

		}
		return index;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data
	 * @param rows
	 * @return
	 */
	public static double getHighestInRow(double[][] data, int rows) {
		double highest = 0.0;
		;
		for (int i = 0; i < data[rows].length; ++i) {
			if (i == 0)
				highest = data[rows][i];
			else if (data[rows][i] > highest)
				highest = data[rows][i];
		}
		return highest;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data
	 * @param rows
	 * @return
	 */
	public static int getHighestInRowIndex(double[][] data, int rows) {
		int index = 0;
		for (int i = 0; i < data[rows].length; ++i) {
			if (data[rows][i] == getHighestInRow(data, rows))
				index = i;
		}
		return index;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @param data
	 * @return
	 */
	public static double getLowestInArray(double data[][])

	{
		double min = 0.0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 0 && j == 0)
					min = data[i][j];
				else if (data[i][j] < min)
					min = data[i][j];
			}
		}
		return min;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; ++i) {
			if (col < data[i].length && data[i][col] < lowest)
				lowest = data[i][col];

		}
		return lowest;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * 
	 * @param data
	 * @param rows
	 * @return
	 */
	public static double getLowestInRow(double[][] data, int rows) {
		double lowest = 0.0;
		for (int i = 0; i < data[rows].length; ++i) {
			if (i == 0)
				lowest = data[rows][i];
			else if (data[rows][i] < lowest)
				lowest = data[rows][i];
		}
		return lowest;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index = 0;
		for (int i = 0; i < data.length; ++i) {
			if (col < data[i].length && data[i][col] == getLowestInColumn(data, col))
				index = i;

		}
		return index;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 * 
	 * @param data
	 * @param rows
	 * @return
	 */
	public static int getLowestInRowIndex(double[][] data, int rows) {
		int index = 0;
		for (int i = 0; i < data[rows].length; ++i) {
			if (data[rows][i] == getLowestInRow(data, rows))
				index = i;
		}
		return index;
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data
	 * @return
	 */
	public static double getTotal(double[][] data) {
		double amount = 0.0;
		for (int i = 0; i < data.length; ++i) {
			for (int j = 0; j < data[i].length; ++j) {
				amount += data[i][j];
			}
		}
		return amount;
	}

	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 * 
	 * @param data
	 * @param rows
	 * @return
	 */
	public static double getRowTotal(double[][] data, int rows) {
		double amount = 0;
		for (int i = 0; i < data[rows].length; ++i) {
			amount += data[rows][i];
		}
		return amount;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column. If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method.
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double amount = 0.0;
		for (int i = 0; i < data.length; ++i) {
			if (col < data[i].length)
				amount += data[i][col];
		}
		return amount;
	}
}
