import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.print.Printer;

/*
 * Taoheed King
 * Two Dim Ragged Array Utility. Java
 */
/**
 * 
 * @author Taoheed King
 * @return array
 *
 */
public class TwoDimRaggedArrayUtility {

	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException {

		Scanner scan = new Scanner(new FileReader(file));
		int columns = 0;
		int rows = 0;
		double[][] array = null;

		String[][] temporaryArray = new String[10][10];
		for (int n = 0; n < temporaryArray.length; n++) {
			if (scan.hasNextLine()) {
				String[] line = scan.nextLine().split(" ");
				for (int k = 0; k < line.length; k++) {
					temporaryArray[n][k] = line[k];
				}
			}
		}
		scan.close();

		for (int a = 0; a < temporaryArray.length && !(temporaryArray[a][0] == null); a++) {
			rows = a;
		}
		array = new double[rows + 1][];
		for (int b = 0; b < array.length; b++) {
			for (int c = 0; c < temporaryArray[b].length && !(temporaryArray[b][c] == null); c++) {
				columns = c;
			}
			array[b] = new double[columns + 1];
		}
		for (int b = 0; b < array.length; b++) {
			for (int c = 0; c < array[b].length; c++) {
				array[b][c] = Double.parseDouble(temporaryArray[b][c]);
			}
		}

		/*
		 * for(int a =0; a< temporaryArray.length; a ++) { if(temporaryArray[a][0] ==
		 * null) { rows = a; array = new double [rows][a]; } } for(int b = 0; b< rows;
		 * b++) { for (int c =0; c < temporaryArray.length; c++) {
		 * if(temporaryArray[b][c] == null) { columns = c; array [b] = new double
		 * [columns]; break; } } for (int d = 0; d < array.length; d ++) { if(!
		 * (array[d] == null)) { for(int f = 0; f <array[d].length; f ++) { array [d][f]
		 * = Double.parseDouble(temporaryArray[d][f]); } } } }
		 */

		return array;

	}

	// Write To File
	/**
	 * 
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(outputFile);
		String amountOfRowsString = "";
		for (int n = 0; n < data.length; n++) {
			for (int p = 0; p < data.length; p++) {
				amountOfRowsString += data[n][p] + "";
			}
			file.println(amountOfRowsString);
			amountOfRowsString = "";
		}
		file.close();
	}

	// Get Total
	/**
	 * 
	 * @param data
	 * @return total
	 */
	public static double getTotal(double[][] data) {
		double total = 0;

		for (int m = 0; m < data.length; m++) {
			for (int n = 0; n < data[m].length; n++) {
				total += data[m][n];
			}
		}
		return total;
	}

	// Get Average
	/**
	 * 
	 * @param data
	 * @return total/counter
	 */
	public static double getAverage(double[][] data) {
		double counter = 0;
		double total = 0;
		for (int m = 0; m < data.length; m++) {
			counter += data[m].length;
		}
		for (int m = 0; m < data.length; m++) {
			for (int n = 0; n < data[m].length; n++) {
				total += data[m][n];
			}
		}
		return total / counter;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return rowTotal
	 */
	// Get Row Total
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0.0;
		for (int n = 0; n < data[row].length; n++) {
			rowTotal += data[row][n];
		}
		return rowTotal;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return columnTotal
	 */
	// Get Column Total
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 100.0;
		for (int n = 0; n < data[col].length; n++) {
			columnTotal += data[n][col];
		}
		return columnTotal;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return highest
	 */
	// Highest In Row
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0.0;
		for (int n = 0; n < data[row].length; n++) {
			if (highest < data[row][n]) {
				highest = data[row][n];
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return highestRowIndex
	 */
	// Highest In Row Index
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = 0.0;
		int highestRowIndex = 0;
		for (int n = 0; n < data[row].length; n++) {
			if (highest < data[row][n]) {
				highest = data[row][n];
				highestRowIndex = n;
			}
		}
		return highestRowIndex;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return lowest
	 */
	// Lowest In Row
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 100.0;
		for (int n = 0; n < data[row].length; n++) {
			if (lowest > data[row][n]) {
				lowest = data[row][n];
			}
		}
		return lowest;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return lowestRowIndex
	 */
	// Lowest In Row Index
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = 100.0;
		int lowestRowIndex = 0;
		for (int n = 0; n < data[row].length; n++) {
			if (lowest > data[row][n]) {
				lowest = data[row][n];
				lowestRowIndex = n;
			}
		}
		return lowestRowIndex;
	}

	// Highest In Column
	/**
	 * 
	 * @param data
	 * @param col
	 * @return highest
	 * 
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 100.0;
		for (int n = 0; n < data[col].length; n++) {
			if (highest < data[col][n]) {
				highest = data[col][n];
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return highestColumnIndex
	 */
	// Highest In Column Index
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0.0;
		int highestColumnIndex = 0;
		for (int n = 0; n > data.length; n++) {
			// for (int m=0; m<data[n].length; m++) {
			if ((data[n].length >= col) && highest > data[n][col]) {
				highest = data[n][col];
				highestColumnIndex = n;
			}
			// }
		}
		return highestColumnIndex;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return lowest
	 */
	// Lowest In Column
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = 100.0;
		for (int n = 0; n < data.length; n++) {
			if ((data[n].length >= col) && lowest > data[n][col]) {
				lowest = data[n][col];
			}
		}
		return lowest;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return lowestColumnIndex
	 */
	// Lowest In Column Index
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = 100.0;
		int lowestColumnIndex = 0;
		for (int n = 0; n < data.length; n++) {
			// for (int m=0; m<data[n].length; m++) {
			if ((data[n].length >= col) && lowest > data[n][col]) {
				lowest = data[n][col];
				lowestColumnIndex = n;
			}
			// }
		}
		return lowestColumnIndex;
	}

	/**
	 * 
	 * @param data
	 * @return highest
	 */
	// Highest in Array
	public static double getHighestInArray(double[][] data) {
		double highest = 0.0;
		int row;
		int col;

		for (row = 0; row < data.length; row++) {
			for (col = 0; col < data[row].length; col++) {
				if (highest < data[row][col]) {
					highest = data[row][col];
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data
	 * @return lowest
	 */
	// Lowest in Array
	public static double getLowestInArray(double[][] data) {
		double lowest = 100.0;
		int row;
		int col;

		for (row = 0; row < data.length; row++) {
			for (col = 0; col < data[row].length; col++) {
				if (lowest > data[row][col]) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}

}
