/** TwoDimRaggedArrayUtility class
 * Purpose: Read/write to a file which containing store sales, calculate metrics
 * based on sales amounts (totals, averages, etc) for different portions of the 
 * sales data (per row, per column, whole data set).
 * 
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {

	//Instance variables
	private double[][] data;
	private int col;
	private int row;
	
	/**
	 * Default no-arg constructor - set instance variables to zero/null
	 */
	public TwoDimRaggedArrayUtility() {
		data=null;
		col=0;
		row=0;
	}
	
	/**
	 * Read a file into the interface to load existing sales data
	 * @param file - file to be read in
	 * @return 2D array of doubles containing sales data
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		Scanner scan;
		String stringFromFile="";
		String[] listOfStrings=null;
		double[][] listOfDoubles=new double[10][];
		double[][] newListOfDoubles=null;
		int i=0;
		
		try {
			scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				stringFromFile=scan.nextLine();
				listOfStrings=stringFromFile.split(" ");
				listOfDoubles[i]=new double[listOfStrings.length];
				for (int j=0; j<listOfStrings.length; j++) {
					double temp=0;
					temp=Double.parseDouble(listOfStrings[j]);
					listOfDoubles[i][j]=temp;
				}
				i++;
			}
			
			newListOfDoubles=new double[i][];
			for (int row=0; row<i; row++) {
				newListOfDoubles[row]=new double[listOfDoubles[row].length];
				for (int column=0; column<listOfDoubles[row].length; column++) {
					newListOfDoubles[row][column]=listOfDoubles[row][column];
				}
			}
				
			scan.close();
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return newListOfDoubles;
	}
	
	/**
	 * Writes sales data to file from interface
	 * @param data - 2D array of sales data to be written into file
	 * @param outputFile - location of file to be written
	 * @throws FileNotFoundException
	 * @return none
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		FileWriter fw = null;
		BufferedWriter bf = null;
		StringBuilder sb = null;
		try {
			fw = new FileWriter(outputFile);
			bf = new BufferedWriter(fw);
			sb = new StringBuilder();
			//bf.write to write to file using BufferedWriter
			for (int i=0; i<data.length; i++) {
				for (int j=0; j<data[i].length; j++) {
					sb.append(data[i][j]);
					if (j<(data[i].length-1)) {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			
			bf.write(sb.toString());
			bf.close();
			fw.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	/**
	 * Calculates total sum of sales amounts in 2D array
	 * @param data - 2D array to be summed
	 * @return double - sum of sales
	 */
	public static double getTotal(double[][] data) {
		double total=0.0;
		for (int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				total+=data[i][j];
			}
		}
		return total;
	}
	
	/**
	 * Calculates average of sales amounts in 2D array
	 * @param data - 2D array containing amounts to be averaged
	 * @return double - average of sales
	 */
	public static double getAverage(double[][] data) {
		double avg=0.0;
		int numberOfValues=0;
		double total = getTotal(data);
		for (int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				numberOfValues++;
			}
		}
		avg=getTotal(data)/numberOfValues;
		return avg;
	}
	
	/**
	 * Calculates total sales in a given row
	 * @param data - 2D array containing row
	 * @param row - row in array to be totaled
	 * @return double - total amount
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total=0.0;
		for (int i=0; i<data[row].length; i++) {
			total+=data[row][i];
		}
		return total;
	}
	
	/**
	 * Calculates total sales in a given column
	 * @param data - 2D array containing column
	 * @param col - column in array to be totaled
	 * @return double - total amount
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total=0.0;
		for (int i=0; i<data.length; i++) {
			if (col<data[i].length) {
				total+=data[i][col];
			}
		}
		return total;
	}
	
	/**
	 * Identifies highest sales amount in a given row
	 * @param data - 2D array containing row
	 * @param row - row in array to be searched
	 * @return double - highest sales amount in that row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest=Double.MIN_VALUE;
		
		for (int i=0; i<data[row].length; i++) {
			if (data[row][i]>highest) {
				highest=data[row][i];
			}
		}
		return highest;
	}
	
	/**
	 * Identifies index of highest sales amount in a given row
	 * @param data - 2D array containing row
	 * @param row - row in array to be searched
	 * @return int - index of highest sales amount in that row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest=Double.MIN_VALUE;
		int index=0;
		
		for (int i=0; i<data[row].length; i++) {
			if (data[row][i]>highest) {
				highest=data[row][i];
				index=i;
			}
		}
		return index;
	}
	
	/**
	 * Identifies lowest sales amount in a given row
	 * @param data - 2D array containing row
	 * @param row - row in array to be searched
	 * @return double - lowest sales amount in that row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest=Double.MAX_VALUE;
		
		for (int i=0; i<data[row].length; i++) {
			if (data[row][i]<lowest) {
				lowest=data[row][i];
			}
		}
		return lowest;
	}
	
	/**
	 * Identifies index of lowest sales amount in a given row
	 * @param data - 2D array containing row
	 * @param row - row in array to be searched
	 * @return int - index of lowest sales amount in that row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest=Double.MAX_VALUE;
		int index=0;
		
		for (int i=0; i<data[row].length; i++) {
			if (data[row][i]<lowest) {
				lowest=data[row][i];
				index=i;
			}
		}
		return index;
	}
	
	/**
	 * Identifies highest sales amount in a given column
	 * @param data - 2D array containing column
	 * @param col - column in array to be searched
	 * @return double - highest sales amount in that column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest=Double.MIN_VALUE;
		for (int i=0; i<data.length; i++) {
			if (col<data[i].length) {
				if (data[i][col]>highest) {
					highest=data[i][col];
				}
			}
		}
		return highest;
	}
	
	/**
	 * Identifies index of highest sales amount in a given column
	 * @param data - 2D array containing column
	 * @param col - column in array to be searched
	 * @return int - index of highest sales amount in that column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest=Double.MIN_VALUE;
		int index=0;
		
		for (int i=0; i<data.length; i++) {
			if (col<data[i].length) {
				if (data[i][col]>highest) {
					highest=data[i][col];
					index=i;
				}
			}
		}
		return index;
	}

	/**
	 * Identifies lowest sales amount in a given column
	 * @param data - 2D array containing column
	 * @param col - column in array to be searched
	 * @return double - lowest sales amount in that column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest=Double.MAX_VALUE;
		for (int i=0; i<data.length; i++) {
			if (col<data[i].length) {
				if (data[i][col]<lowest) {
					lowest=data[i][col];
				}
			}
		}
		return lowest;
	}
	
	/**
	 * Identifies index of lowest sales amount in a given column
	 * @param data - 2D array containing column
	 * @param col - column in array to be searched
	 * @return int - index of lowest sales amount in that column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest=Double.MAX_VALUE;
		int index=0;
		
		for (int i=0; i<data.length; i++) {
			if (col<data[i].length) {
				if (data[i][col]<lowest) {
					lowest=data[i][col];
					index=i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Identify highest sales amount in whole array
	 * @param data - 2D array to be searched
	 * @return double - highest sales amount in array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest=0.0;
		
		for (int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				if (data[i][j]>highest) {
					highest=data[i][j];
				}
			}
		}
		return highest;
	}
	
	/**
	 * Identify lowest sales amount in whole array
	 * @param data - 2D array to be searched
	 * @return double - lowest sales amount in array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest=Double.MAX_VALUE;
		
		for (int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {
				if (data[i][j]<lowest) {
					lowest=data[i][j];
				}
			}
		}
		return lowest;
	}

}
