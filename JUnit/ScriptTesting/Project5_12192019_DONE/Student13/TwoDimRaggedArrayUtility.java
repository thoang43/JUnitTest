/**
 * This is a utility class designed to obtain various
 * values and indexes from a ragged, two dimensional array.
 * 
 * CMSC - 203
 * 11/9/2019
 */

import java.util.Scanner;
import java.io.*;
	
public class TwoDimRaggedArrayUtility {

		/**
		 * This method locates and returns the 
		 * lowest value in the array.
		 * @param arr A two dimensional array of doubles.
		 * @return The lowest value in the array.
		 */
		public static double getLowestInArray(double[][] arr) {
			
			// Create a double variable and set it equal
			// to the first element in the array.
			double min = arr[0][0];
			
			// Loop through the rows in the array.
			for (int i = 0; i < arr.length; i++) {					// For loop 1
				
				// Loop through the columns in the array.
				for (int i2 = 0; i2 < arr[i].length; i2++) {		// For loop 2
					
					// If the current element is less than min,
					// store its value into min.
					if (arr[i][i2] < min) {
						min = arr[i][i2];
					}
				} // End for loop 2
			} // End for loop 1
			return min;
		} // End of method	
		/**
		 * This method locates and returns the highest value 
		 * in the array.
		 * @param arr A two dimensional array of doubles.
		 * @return The highest value in the array.
		 */
		public static double getHighestInArray(double[][] arr) {
			
			// Create a double variable named max and set it 
			// equal to the first element in the array.
			double max = arr[0][0];
			
			// Loop through the rows in the array.
			for (int i = 0; i < arr.length; i++) {					// For loop 1
				
				// Loop through the columns in the array.
				for (int i2 = 0; i2 < arr[i].length; i2++) {		// For loop 2
					
					// If the current element is greater than
					// the value in max, store it in max.
					if (arr[i][i2] > max) {
						max = arr[i][i2];
					}
				} // End for loop 2
			} // End for loop 1
			return max;
		} // End of method
		/**
		 * This method locates and returns the index of the lowest
		 * value in the given column.
		 * @param arr A two dimensional array of doubles.
		 * @param col An integer value representing the column to search.
		 * @return The index of the lowest value in the column.
		 */
		public static int getLowestInColumnIndex(double[][] arr, int col) {
			
			// Create a double variable to hold the minimum value
			// in the column and set it equal to the highest value
			// in the array.
			double minValue = getHighestInArray(arr);
			// Create an int variable to hold the index of the element
			// with the lowest value. Initialize it to 0.
			int minIndex = 0;
			
			// Loop through the rows of the array.
			for (int i = 0; i < arr.length; i++) {
				
				// Check to make sure the length of the row is 
				// greater than the value in col.
				if (col < arr[i].length) {
					
					// If the value in the row at the given column
					// is less than minValue, store it into minValue
					// And store its row subscript into minIndex.
					if (arr[i][col] < minValue) {
						minValue = arr[i][col];
						minIndex = i;
					} // End if statement
				} // End if statement
			} // End for loop
			return minIndex;
		} // End of method
		/**
		 * This method locates and returns the lowest
		 * value in the given column.
		 * @param arr A two dimensional array of doubles.
		 * @param col An integer value representing the column to search.
		 * @return The lowest value in the column.
		 */
		public static double getLowestInColumn(double[][] arr, int col) {
			
			// Declare a double variable to hold the minimum value
			// in the given column. Set it equal to the highest
			// value in the array.
			double minValue = getHighestInArray(arr);
			
			// Loop through the rows of the array.
			for (int i = 0; i < arr.length; i++) {
				
				// Check to make sure the length of the row is 
				// greater than the value in col.
				if (col < arr[i].length) {
					
					// If the current row's value at the given column
					// is less than minValue, store it into minValue.
					if (arr[i][col] < minValue) {
						minValue = arr[i][col];
					} // End if statement
				} // End if statement
			} // End for loop
			return minValue;
		} // End of method
		/**
		 * This method returns the index of the highest
		 * value in the given column.
		 * @param arr A two dimensional array of doubles.
		 * @param col An integer value representing the column to search.
		 * @return The index of the highest value in the column.
		 */
		public static int getHighestInColumnIndex(double[][] arr, int col) {
			
			// Create a double variable to hold the maximum value
			// in the given column. Set it equal to the lowest
			// value in the array.
			double maxValue = getLowestInArray(arr);
			// Holds the index of the highest value in the column.
			int maxIndex = 0;
			
			// Loop through the rows at the given column.
			for (int i = 0; i < arr.length; i++) {
				
				// Check to make sure the length of the row is 
				// greater than the value in col.
				if (col < arr[i].length) {
					
					// If the current row's value at the given column
					// is greater than maxValue, store it into maxValue.
					// Set maxIndex equal to the current row's element.
					if (arr[i][col] > maxValue) {
						maxValue = arr[i][col];
						maxIndex = i;
					} // End if statement
				}// End if statement
			} // End for loop
			return maxIndex;
		} // End of method
		/**
		 * This method locates and returns the highest value
		 * in a given column.
		 * @param arr A two dimensional array of doubles.
		 * @param col An integer representing the column to search.
		 * @return The highest value in the given column.
		 */
		public static double getHighestInColumn(double[][] arr, int col) {
			
			// Declare a double variable to hold the max
			// value in the given column. Set it equal to the
			// lowest value in the array.
			double maxValue = getLowestInArray(arr);
			
			// Loop through the rows at the given column.
			for (int i = 0; i < arr.length; i++) {
				
				// Check to make sure the length of the row is 
				// greater than the value in col.
				if (col < arr[i].length) {
					
					// If the current value at col in the row i
					// is greater than max value, store it in
					// maxValue.
					if (arr[i][col] > maxValue) {
						maxValue = arr[i][col];
					} // End if statement
				} // End if statement
			} // End for loop
			return maxValue;
		} // End of method
		/**
		 * This method locates and returns the index 
		 * of the lowest value in the row.
		 * @param arr A two dimensional array of doubles.
		 * @param row An integer value that represents the row to search.
		 * @return The index of the lowest value in the row.
		 */
		public static int getLowestInRowIndex(double[][] arr, int row) { 
			
			// Declare a double variable and assign it the
			// max value in the array. 
			double minValue = getHighestInArray(arr);
			// Declare an int variable to hold the index of
			// the minimum value in the row.
			int minIndex = 0;
			
			// Loop through the elements in the given row
			// of the array.
			for (int i = 0; i < arr[row].length; i++) {
				// If the value of the current element in the 
				// given row is less than the value stored in
				// minValue, store it in minValue. Store the
				// index of that value into minIndex.
				if (arr[row][i] < minValue) {
					minValue = arr[row][i];
					minIndex = i;
				} // End if statement
			} // End for loop
			return minIndex;
		} // End of method
		/**
		 * This method locates and returns the lowest value
		 * in the given row.
		 * @param arr A two dimensional array of doubles.
		 * @param row An integer value that represents the row to search.
		 * @return The minimum value in the given row.
		 */
		public static double getLowestInRow(double[][] arr, int row) { 
			
			// Declare a double variable and assign it the max
			// value in the array.
			double minValue = getHighestInArray(arr);
			
			// Loop through the elements in the given row.
			for (int i = 0; i < arr[row].length; i++) {
				// If the current element in the given row
				// is less than minValue, store it in minValue.
				if (arr[row][i] < minValue) {
					minValue = arr[row][i];
				} // End if statement
			} // End for loop
			return minValue;
		} // End of method
		/**
		 * This method locates the highest value in the 
		 * given row and returns its index.
		 * @param arr A two dimensional array of doubles.
		 * @param row An integer representing the row to be searched.
		 * @return The index of the highest value in the row.
		 */
		public static int getHighestInRowIndex(double[][] arr, int row) { 
			
			// Declare a double variable and assign it the minimum
			// value in the array.
			double maxValue = getLowestInArray(arr);
			// Declare an int variable to hold the index of the 
			// max value in the row.
			int maxIndex = 0;
			
			// Loop through the elements in the given row.
			for (int i = 0; i < arr[row].length; i++) {
				// If the value stored in the current element of
				// the given row is greater than maxValue, store
				// it in maxValue. Store the index of this value
				// into maxIndex.
				if (arr[row][i] > maxValue) {
					maxValue = arr[row][i];
					maxIndex = i;
				} // End if statement
			} // End for loop
			return maxIndex;
		} // End of method
		/**
		 * This method locates and returns the highest value 
		 * in the given row.
		 * @param arr A two dimensional array of doubles.
		 * @param row An integer representing the row to be searched.
		 * @return The highest value in the row.
		 */
		public static double getHighestInRow(double[][] arr, int row) { 
			
			// Declare a double variable and assign it the minimum
			// value in the array.
			double maxValue = getLowestInArray(arr);
			
			// Loop through the elements in the given row.
			for (int i = 0; i < arr[row].length; i++) {
				// If the current element in the given row
				// is greater than maxValue, store it into
				// maxValue.
				if (arr[row][i] > maxValue) {
					maxValue = arr[row][i];
				} // End if statement
			} // End for loop
			return maxValue;
		} // End of method
		/**
		 * This value calculates the total of all the
		 * values in the given column.
		 * @param arr A two dimensional array of doubles.
		 * @param col An integer representing the column to be searched.
		 * @return The total of all the values in the given row.
		 */
		public static double getColumnTotal(double[][] arr, int col) {
			
			// Declare and initialize an accumulator to 0.
			double total = 0.0;
			
			// Loop through the rows of the array.
			for (int i = 0; i < arr.length; i++) {
				// Check to make sure the length of the row is 
				// greater than the value in col.
				if (col < arr[i].length) {
					// Add the value in the current element to total.
					total += arr[i][col];
				} // End if statement
			} // End for loop
			return total;
		} // End of method
		/**
		 * This method calculates the total of all the
		 * values in the given row.
		 * @param arr A two dimensional array of doubles.
		 * @param row An integer representing the row to be searched.
		 * @return The total of all the values in the given row.
		 */
		public static double getRowTotal(double[][] arr, int row) {
			
			// Declare and initialize an accumulator to 0.
			double total = 0.0;
			
			// Loop through the elements in the given row.
			for (int i = 0; i < arr[row].length; i++) {
				// Add the current element to total.
				total += arr[row][i];
			} // End for loop.
			return total;
		} // End of method
		/**
		 * This value calculates the average of all the 
		 * values in the array.
		 * @param arr A two dimensional array of doubles.
		 * @return The average of all the values in the array.
		 */
		public static double getAverage(double[][] arr) {
			
			// Declare and initialize an accumulator to 0.
			double total = 0.0;
			// Declare and initialize a variable to hold the
			// average.
			double average = 0.0;
			// Counts the number of values that have been
			// added to the total.
			int counter = 0;
			
			// Loop through the rows of the array.
			for (int i = 0; i < arr.length; i++) {
				// Loop through the columns of the array.
				for (int i2 = 0; i2 < arr[i].length; i2++) {
					// Add the current value to the total.
					total += arr[i][i2];
					// Increment the value counter by 1.
					counter++;
				} // End for loop.
			} // End for loop.
			
			// Calculate the average of the values in the array.
			average = total / counter;
			return average;
		} // End of method
		/**
		 *  This value calculates the total of all the
		 *  values in the array.
		 * @param arr A two dimensional array of doubles.
		 * @return The total of all the values in the array.
		 */
		public static double getTotal(double[][] arr) {
			
			// Declare and initialize an accumulator to 0.
			double total = 0.0;
			
			// Loop through the rows of the array.
			for (int i = 0; i < arr.length; i++) {
				// Loop through the columns of the array.
				for (int i2 = 0; i2 < arr[i].length; i2++) {
					// Add the current value to the total.
					total += arr[i][i2];
				} // End for loop
			} // End for loop
			return total;
		} // End of method
		/**
		 * This method accepts a two dimensional array and a file,
		 * and then writes the values stored in the array to the file.
		 * @param arr A two dimensional array of doubles.
		 * @param file The file to store the values of the array into.
		 * @throws IOException Used for file errors.
		 */
		public static void writeToFile(double[][] arr, File file) throws IOException {
			
			// Declare a PrintWriter object and connect it
			// to the file parameter.
			PrintWriter outputFile = new PrintWriter(file);
			
			// Check to see if the file exists.
			if (!file.exists()) {
				System.out.println("The file does not exist.");
				System.exit(0);
			}
			
			// Loop through the rows of the array.
			for (int i = 0; i < arr.length; i++) {
				// Loop through the columns of the array.
				for (int i2 = 0; i2 < arr[i].length; i2++) {
					// Write the value of the current element to the file
					// with a space character after it.
					outputFile.print(arr[i][i2] + " ");
				} // End for loop
				// Print a newline character to the file.
				outputFile.println();
			} // End for loop
			// Close the file.
			outputFile.close();
		} // End of method
		/**
		 * This method reads values from a file and stores them
		 * into a two dimensional ragged array.
		 * @param file A text file to read values from.
		 * @return A two dimensional, ragged array of doubles
		 * @throws IOException Used for file errors.
		 */
		public static double [][] readFile(File file) throws IOException {
			
			// Create a Scanner object and connect it to the
			// given file.
			Scanner inputFile = new Scanner(file);
			
			// Check to see if the file exists.
			if (!file.exists()) {
				System.out.println("The file does not exist.");
				System.exit(0);
			}
			
			// Declare and initialize a counter to store how
			// many lines (used for rows) are in the file.
			int count = 0;
			// Declare a String variable to hold a line of text
			// from the input file.
			String line = "";
		
			// Count the rows in the text file.
			while (inputFile.hasNext()) {
				// Read in the next line.
				line = inputFile.nextLine();
				count++;
			}
			// Close the file.
			inputFile.close();
			// Open the file again to reset the read position.
			inputFile = new Scanner(file);
			
			// Declare a two dimensional array of Strings and 
			// initialize it with the number of lines in the file.
			String [][] nums = new String[count][];
			
			// Read the values from the file and store them into the array.
			for (int i = 0; inputFile.hasNext() && i < nums.length; i++) {
				// Store the current line of the file.
				line = inputFile.nextLine();
				// Split the values in the String line and initialize
				// the second dimension of the array.
				nums[i] = line.split(" ");
			} // End for loop
			
			// Declare a two dimensional array of doubles and 
			// initialize it with the length of the nums array.
			double [][] doubs = new double[nums.length][];
			
			// Loop through the rows in the nums array.
			for (int i = 0; i < nums.length; i++) {
				// Initialize an array at the current element of
				// the doubs array.
				doubs[i] = new double[nums[i].length];
				// Loop through the columns of the nums array.
				for (int i2 = 0; i2 < nums[i].length; i2++) {
					// Convert the String in nums to a double
					// and store the value into the doubs array.
					doubs[i][i2] = Double.parseDouble(nums[i][i2]);	
				} // End for loop
			} // End for loop

			// Close the file.
			inputFile.close();
			
			// Return the array.
			return doubs;
		} // End of method

		
} // End of class


	
	
	

