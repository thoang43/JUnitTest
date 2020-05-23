package assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * create a TwoDimRaggedArray Utility Class
 * 
 *
 */

public class TwoDimRaggedArrayUtility {
	
	/**
	 * read doubles from a file to a ragged array of doubles
	 * @param file file to be read
	 * @return a two-dimensional ragged array of doubles
	 * @throws FileNotFoundException 
	 */
	public static double[][] readFile (File file) throws FileNotFoundException {
//		Int rows, columns
//		double[][] arr
//		create Scanner object holding contents of file
//		create another Scanner object holding contents of file
//		If file has more than 1 line
//			Rows = 1, columns = 1
//			While file has next line
//				Rows++
//				Create a StringTokenizer object holding current line in file
//				If number of tokens in current line > columns, then columns = number of tokens in current line
//				Go to next line
//			arr = new double[rows][columns]
//			For each row in arr
//				try reading corresponding line in file
//					For each column in current row of arr
//						Arr[current row][current column] = parsed double version of next String token
//			return arr
//		Else return null
		int rows, columns;
		double[][] arr;
		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(file);
		StringTokenizer fileLine;
		
		//rows that are supposed to be out of bounds are set to 0 instead
		if (scan.hasNextLine()) {
			rows = 1;
			columns = 1;
			while (scan.hasNextLine()) {
				rows++;
				fileLine = new StringTokenizer(scan.nextLine());
				if (fileLine.countTokens() > columns) columns = fileLine.countTokens();
			}
			scan.close();
			arr = new double[rows][columns];
			for (int row = 0; row < arr.length; row++) {
				try {
					fileLine = new StringTokenizer(scan2.nextLine());
						for (int column = 0; column < arr[row].length; column++) {
							if (fileLine.hasMoreTokens()){
								arr[row][column] = Double.parseDouble(fileLine.nextToken());
							}
						}
				}catch (Exception e) {
					
				}
			}
			scan2.close();
			return arr;
		}
		else {
			scan.close();
			scan2.close();
			return null;
		}
		
	}

	
	/**
	 * write from a ragged array of doubles to a file
	 * @param arr a two-dimensional ragged array of doubles
	 * @param file file to be written to
	 * @throws FileNotFoundException 
	 */
	public static void writeToFile (double[][] arr, File file) throws FileNotFoundException {
//		For each row in arr
//			For each column in current row
//				If arr[current row][current column] exists
//					Write arr[current row][current column] to file
//					If arr[current row][next column] exists
//						Add a whitespace
//					Else create another line in file
//				Else create another line in file
		PrintWriter outfile = new PrintWriter(file);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				String temp = String.valueOf(arr[i][j]) + " ";
				outfile.print(temp);
			}
			outfile.println();
		}
		outfile.close();
	}


	/**
	 * Get the total of all elements in two-dim ragged array of doubles
	 * @param arr a two-dimensional ragged array of doubles
	 * @return the total of the elements in the array
	 */
	public static double getTotal (double[][] arr) {
//		Double sum = 0
//		For each row in arr
//			For each column in each row
//				Sum += current element
//		Return sum
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += getRowTotal(arr, i);
		}
		return sum;
	}


	/**
	 * get the average of all elements in a two-dim ragged array of doubles
	 * @param arr a two-dimensional ragged array of doubles
	 * @return the average of the elements in the array 
	 */
	public static double getAverage(double[][] arr) {
//		int elements = 0;
//		for each row in arr
//			for each column in arr
//				elements++;
//		Return getTotal/number of elements in arr
		int elements = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int column = 0; column < arr[row].length; column++) {
				elements++;
			}
		}
		return getTotal(arr)/elements;
	}

	
	/**
	 * get the total of all elements in a row of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param row a row index
	 * @return the total of that row
	 */
	public static double getRowTotal(double[][] arr, int row) {
//		Double sum = 0
//		For each column element in row
//			Sum += current element
//		Return sum
		double sum = 0;
		for (int i = 0; i < arr[row].length; i++) {
			sum += arr[row][i];
		}
		return sum;
	}


	/**
	 * get the total of all elements in a column of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param column a column index
	 * @return the total of that column
	 */
	public static double getColumnTotal (double[][] arr, int column) {
//		double sum = 0
//		For each row in arr
//			If arr[row][column] exists, then sum += arr[row][column]
//		Return sum
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			try{
				sum += arr[i][column];
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}
		}
		return sum;
	}


	/**
	 * get the highest value element in a row of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param row a row index 
	 * @return the largest element in that row
	 */
	public static double getHighestInRow (double[][] arr, int row) {
//		Double highest = arr[row][0]
//		For each column element in row
//			If arr[row][current column] > highest, then highest = arr[row][current column]
//		Return highest
		double highest = arr[row][0];
		for (int i = 1; i < arr[row].length; i++) {
			if (arr[row][i] > highest) highest = arr[row][i];
		}
		return highest;
	}


	/**
	 * get the index of the highest value element in a row of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param row a row index 
	 * @return the index of the largest element in that row
	 */
	public static int getHighestInRowIndex (double[][] arr, int row) {
//		Int indexHigh = 0
//		For each column element in row
//			If arr[row][current column] > arr[row][indexHigh], then indexHigh = current column
//		Return indexHigh
		int indexHigh = 0;
		for (int i = 0; i < arr[row].length; i++) {
			if (arr[row][i] > arr[row][indexHigh]) indexHigh = i;
		}
		return indexHigh;
	}


	/**
	 * get the lowest value element in a row of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param row a row index 
	 * @return the smallest element in that row
	 */
	public static double getLowestInRow (double[][] arr, int row) {
//		Double lowest = arr[row][0]
//		For each column element in row
//			If arr[row][current column] < lowest, then lowest = arr[row][current column]
//		Return lowest
		double lowest = arr[row][0];
		for (int i = 1; i < arr[row].length; i++) {
			if (arr[row][i] < lowest) lowest = arr[row][i];
		}
		return lowest;
	}


	/**
	 * get the index of the lowest value element in a row of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param row a row index 
	 * @return the index of the smallest element in that row
	 */
	public static int getLowestInRowIndex (double[][] arr, int row) {
//		Int indexLow = 0
//		For each column element in row
//			If arr[row][current column] < arr[row][indexLow], then indexLow = current column
//		Return indexLow
		int indexLow = 0;
		for (int i = 0; i < arr[row].length; i++) {
			if (arr[row][i] < arr[row][indexLow]) indexLow = i;
		}
		return indexLow;
	}


	/**
	 * get the highest value element in a column of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param column a column index
	 * @return the largest element in that column
	 */
	public static double getHighestInColumn (double[][] arr, int column) {
//		Double highest = arr[0][column]
//		For each row in arr
//			If arr[current row][column] exists
//				If arr[current row][column] > highest, then highest = arr[current row][column]
//		Return highest
		int highest = getHighestInColumnIndex(arr, column);
		return arr[highest][column];
	}


	/**
	 * get the index of the lowest value element in a column of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param column a column index
	 * @return the index of the largest element in that column
	 */
	public static int getHighestInColumnIndex (double[][] arr, int column) {
//		Int indexHigh = 0
//		boolean highFound = false
//		while highFound == false (first element in column of arr hasn't been found)
//				go to next row 
//				if element exists, then indexHigh = row
//				highFound = true
//		For each row in arr
//			If arr[current row][column] exists
//				If arr[current row][column] > arr[indexHigh][column], then indexHigh = current row
//		Return indexHigh
		int indexHigh = 0;
		boolean highFound = false;
		
		while (highFound == false) {
			try {
				Double.valueOf(arr[indexHigh][column]);
				highFound = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				indexHigh++;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			try{
				if (arr[i][column] > arr[indexHigh][column]) indexHigh = i;
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}
		}
		return indexHigh;
	}


	/**
	 * get the lowest value element in a column of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param column a column index
	 * @return the smallest element in that column
	 */
	public static double getLowestInColumn (double[][] arr, int column) {
//		Double lowest = arr[0][column]
//		For each row in arr
//			If arr[current row][column] exists
//				If arr[current row][column] < lowest, then lowest = arr[current row][column]
//		Return lowest
		int lowest = getLowestInColumnIndex(arr, column);
		return arr[lowest][column];
	}


	/**
	 * get the index of the lowest value element in a column of a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @param column a column index
	 * @return the index of the smallest element in that column
	 */
	public static int getLowestInColumnIndex (double[][] arr, int column) {
//		int indexLow = 0
//		boolean lowFound = false
//		while lowFound == false (first element in column of arr hasn't been found)
//				go to next row 
//				if element exists, then indexLow = row
//				lowFound = true
//		For each row in arr
//			If arr[current row][column] exists
//				If arr[current row][column] > arr[indexLow][column], then indexLow = current row
//		Return indexLow
		
		int indexLow = 0;
		boolean lowFound = false;
		
		while (lowFound == false) {
			try {
				Double.valueOf(arr[indexLow][column]);
				lowFound = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				indexLow++;
			}
		}
		for (int row = 0; row < arr.length; row++) {
			try{
				if (arr[row][column] < arr[indexLow][column]) indexLow = row;
			} catch (ArrayIndexOutOfBoundsException e) {
				
			}
		}
		return indexLow;
	}

	/**
	 * get the highest value element in a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @return the largest element in the array
	 */
	public static double getHighestInArray (double[][] arr) {
//		double high = first element in arr
//		For each row in arr
//			For each column in row
//				If current element is greater than high, then replace high with current element
//		Return high
		double high = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > high) high = arr[i][j];
			}
		}
		return high;
	}

	/**
	 * get the lowest value element in a two-dim ragged array
	 * @param arr a two-dimensional ragged array of doubles
	 * @return the smallest element in the array
	 */
	public static double getLowestInArray (double[][] arr) {
//		double low = first element in arr
//		For each row in arr
//			For each column in row
//				If current element is less than low, then replace low with current element
//		Return low
		double low = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < low) low = arr[i][j];
			}
		}
		return low;
	}

}
