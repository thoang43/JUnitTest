import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;

import java.io.*;
import java.lang.reflect.Array;

/**
 * @author Malcolm Almuntazar-Harris
 *Class: CMSD 203
 *Professor: Alla Webb
 *Description: Utility class for 2D arrays
 *Due date: 17NOV2019
 */
public class TwoDimRaggedArrayUtility {
	
	/**
	 * Reads file of numbers and returns a 2d array of doubles
	 * @param file to be read
	 * @return array of doubles from file
	 */
	public static double[][] readFile(File file)  
	{
		double fileArray[][] = null;
		
		try {
			Scanner sc = new Scanner(file);
			int rowAmount = 0;
			
			while (sc.hasNextLine())  //iterate along each line the document
			{
				sc.nextLine();
				rowAmount++;
			}
			
			fileArray = new double[rowAmount][];
			sc.close();
			
			sc = new Scanner(file); //reset from the beginning
			String textLine;
			for (int i = 0; i < fileArray.length; i++)
			{
				textLine = sc.nextLine();
				String[] numbers = textLine.split(" ");
				fileArray[i] = new double[numbers.length];
				for (int j = 0; j < fileArray[i].length; j++)
				{
					fileArray[i][j] = Double.valueOf(numbers[j]);
				}
			}
			sc.close();
		}
		
		catch (Exception e) 
		{
			System.out.println("Error!");
			
		}
		return fileArray;
	}
	/**
	 * Passes a 2d array of doubles and a file, the array is written into the file
	 * @param array of numbers that should be written to file
	 * @param file to be written to
	 */
	public static void writeToFile(double array[][], File file)
	{
		try {
			PrintWriter writer;
			int arrayLength = array.length;
			
			writer = new PrintWriter(file);
			
			for (int i = 0; i< arrayLength; i++)
			{
				for(int j = 0; j< array[i].length; j++)
				{
					writer.print(array[i][j] + " ");
	        	}
				writer.println();
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Error!");
		}

	}
	/**
	 * Pass in a 2d array of doubles and returns the total of all elements
	 * @param array 
	 * @return total
	 */
	public static double getTotal(double[][] array)
	{
		double total = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				total += array[i][j];
			}
		}
		return total;
	}
	/**
	 * Returns the average of a 2d array
	 * @param array
	 * @return average
	 */
	public static double getAverage(double[][] array)
	{
		int elements = 0;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				elements++;
			}
		}
		return getTotal(array)/ (elements);
	}
	/**
	 * returns the total of a specified row that is entered
	 * @param array
	 * @param row
	 * @return
	 */
	public static double getRowTotal(double[][] array, int row)
	{
		double rowTotal = 0.0;
		for (int j = 0; j < array[row].length; j++)
		{
			rowTotal += array[row][j];
		}
		return rowTotal;
	}
	/**
	 * Pass in a 2d array of doubles and a column and returns a total for that column
	 * @param array
	 * @param column
	 * @return columnTotal
	 */
	public static double getColumnTotal(double[][] array, int column)
	{
		double columnTotal = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			if (column < array[i].length)
			{
				try {
					columnTotal += array[i][column];
				}
				catch (IndexOutOfBoundsException e)
				{
					columnTotal += 0.0;
				}
			}
		}
		return columnTotal;
	}
	/**
	 * Pass in an array and a row number and it returns the highest number in that row
	 * @param array
	 * @param row
	 * @return rowTotal
	 */
	public static double getHighestInRow(double[][] array, int row)
	{
		double rowMax = 0.0;
		
		for (int j = 0; j < array[row].length; j++)
		{
			if ( rowMax < array[row][j])
				rowMax = array[row][j];
		}
		return rowMax;
	}
	/**
	 * Pass in an array and it returns the index number for the highest in row
	 * @param array
	 * @param row
	 * @return highestRowIndex
	 */
	public static int getHighestInRowIndex(double[][] array, int row)
	{
		double rowMax = 0.0;
		int highestRowIndex = -1;
		
		for (int j = 0; j < array[row].length; j++)
		{
			if ( rowMax < array[row][j])
			{
				rowMax = array[row][j];
				highestRowIndex = j;
			}
		}
		return highestRowIndex;
	}
	/**
	 * Pass in an array and a row number and it returns the lowest number in that row
	 * @param array
	 * @param row
	 * @return rowMin
	 */
	public static double getLowestInRow(double[][]array, int row)
	{
		double rowMin = array[row][0];
		
		for (int j = 0; j < array[row].length; j++)
		{
			if ( rowMin > array[row][j])
				rowMin = array[row][j];
		}
		return rowMin;
	}
	/**
	 * Gets the index of the element with the lowest in a row
	 * @param array
	 * @param row
	 * @return lowestRowIndex
	 */
	public static int getLowestInRowIndex(double[][]array, int row)
	{
		double rowMin = array[row][0];
		int lowestRowIndex = 0;
		for (int j = 0; j < array[row].length; j++)
		{
			if (rowMin > array[row][j])
			{
				rowMin = array[row][j];
				lowestRowIndex = j;
			}
		}
		return lowestRowIndex;
	}
	/**
	 * Gets the highest value in a column provided
	 * @param array
	 * @param column
	 * @return columnMax
	 */
	public static double getHighestInColumn(double[][]array, int column)
	{
		double columnMax = -100000000.00000;
		for (int i = 0; i < array.length; i++)
		{
			if (column < array[i].length)
			{
					if (columnMax < array[i][column] )
						columnMax = array[i][column];
			}
		}
		return columnMax;
	}
	/**
	 * Returns the index number with the highest element
	 * @param array
	 * @param column
	 * @return columnMaxIndex
	 */
	public static int getHighestInColumnIndex(double[][]array, int column)
	{
		double columnMax = -100000000000.00000;
		int columnMaxIndex = -1;
		for (int i = 0; i < array.length; i++)
		{
			if (column < array[i].length)
			{
					if (columnMax < array[i][column] )
					{
						columnMax = array[i][column];
						columnMaxIndex = i;
					}
			}
		}
		return columnMaxIndex;
		
	}
	/**
	 * Given an array and a column number, it finds the minimum
	 * @param array
	 * @param column
	 * @return
	 */
	public static double getLowestInColumn(double[][]array, int column)
	{
		double columnMin = 1000000000.0000;
		for (int i = 0; i < array.length; i++)
		{
			if (column < array[i].length)
			{
					if (array[i][column] < columnMin)
						columnMin = array[i][column];
			}
		}
		return columnMin;
	}
	
	public static int getLowestInColumnIndex(double[][]array, int column)
	{
		double columnMin = 1000000000.0000;
		int columnMinIndex = -1;
		for (int i = 0; i < array.length; i++)
		{
			if (column < array[i].length)
			{
					if (array[i][column] < columnMin && column < array[i].length)
					{
						columnMin = array[i][column];
						columnMinIndex = i;
					}
			}
		}
		return columnMinIndex;
	}
	/**
	 * Iterates through an entire 2d array and returns the max element
	 * @param array
	 * @return
	 */
	public static double getHighestInArray(double[][] array)
	{
		double arrayMax = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				if (arrayMax < array[i][j])
					arrayMax = array[i][j];
			}
		}
		return arrayMax;
	}
	/**
	 * Iterates through the entire 2d array and returns the min element
	 * @param array
	 * @return arrayMin
	 */
	public static double getLowestInArray(double[][] array)
	{
		double arrayMin = array[0][0];
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				if (arrayMin > array[i][j])
					arrayMin = array[i][j];
			}
		}
		return arrayMin;
	}
}
