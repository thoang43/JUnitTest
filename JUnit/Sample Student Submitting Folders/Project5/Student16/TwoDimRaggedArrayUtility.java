//import statements
import java.io.*;
import java.util.Scanner;

/** 
 * TwoDimRaggedArrayUtility contains static methods that will read in files,
 * write to files, calculate various totals, find averages, highest and lowest values,
 * and indexes of said values.
 *
 */

public class TwoDimRaggedArrayUtility 
{
	/**Read in a file containing sales data, then return a 2D ragged array containing
	 * the data
	 * @param file the File object representing a file
	 * @return data[][] the 2D ragged array containing sales data
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(File file) 
			      throws FileNotFoundException
	{
		//return null if the input file doesn't exist
		if(!file.exists()) return null;
		
		//create scanner object to get input from file
		Scanner fileInput = new Scanner(file);
		
		//return null if the file is empty, else start reading in
		if(!fileInput.hasNext())
		{
			fileInput.close();
			return null;
		}
		else
		{
			//create a String 2d array representing elements in the input file
			String[][] strings = new String[10][10];
			
			//create String variable that'll represent full lines of the input file
			String line = fileInput.nextLine();
			
			//create int variable to count the number of rows needed for 2d ragged array
			int countRows = 0;
			
			//for loop through the rows of the String 2d array
			for(int row = 0; row < strings.length; row++)
			{
				//create new scanner object to get input from a line 
				Scanner lineInput = new Scanner(line);
				
				//for loop through the columns of the String 2d array
				for(int col = 0; col < strings[row].length; col++)
				{
					//if there is an input coming up, add the input to the String array
					//else end the column for loop, and close the line scanner object
					if(lineInput.hasNext())
					{
						strings[row][col] = lineInput.next();
					}
					else
					{
						col = strings[row].length;
						lineInput.close();
					}
				}
				
				countRows++;
				
				//if the file has a line coming up, create another scanner object for the line
				//else end the row for loop, and close the file
				if(fileInput.hasNextLine())
				{
					line = fileInput.nextLine();
					lineInput = new Scanner(line);
				}
				else
				{
					row = strings.length;
					fileInput.close();
				}
			}
			
			//start counting number of columns needed for the 2d ragged array
			int countCols = 0;
			
			//create the 2d ragged array with a length = to the number of rows counted
			double[][] data = new double[countRows][];
			
			//for loop through the rows of the 2d ragged array
			for(int row = 0; row < data.length; row++)
			{
				//for loop through the columns of the String 2d array
				for(int col = 0; col < strings[row].length; col++)
				{
					//if the current element in the String 2d array isn't null,
					//increment the count of columns
					//else end the column loop
					if(strings[row][col] != null)
					{
						countCols++;
					}
					else col = strings[row].length;
				}
				
				//set the length of the current to the number of columns counted
				data[row] = new double[countCols];

				//reset column counter
				countCols = 0;
			}
			
			//for loop through the rows of the 2d ragged array
			for(int row = 0; row < data.length; row++)
			{
				//for loop through the columns of the 2d ragged array of the current row
				for(int col = 0; col < data[row].length; col++)
				{
					//convert the element in the String 2d array to a double, then add to the ragged array
					data[row][col] = Double.parseDouble(strings[row][col]);
				}
			}
			
			//return the 2d ragged array
			return data;
		}
	}
	
	/**Write to a file, outputting the data from a 2D ragged array representing sales data
	 * @param data[][] the 2D ragged array representing sales data
	 * @param outputFile the File object representing a file 
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile)
								   throws java.io.FileNotFoundException
	{
		//create PrintWriter object that'll allow writing to a new text file
		PrintWriter pw = new PrintWriter(outputFile);
		
		//for loop through the rows and columns of the 2d ragged array
		for(int r = 0; r < data.length; r++)
		{
			for(int c = 0; c < data[r].length; c++)
			{
				//print the current element in the 2d array into the output file
				pw.print(data[r][c] + " ");
			}
			pw.println();
		}
		
		//close the file
		pw.close();
	}
	
	/**Calculate the total of all sales numbers in a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @return total the total of all sales numbers
	 */
	public static double getTotal(double[][] data)
	{
		//create double representing the total
		double total = 0;
		
		//for loop through the rows and columns of the 2d ragged array
		for(int r = 0; r < data.length; r++)
		{
			for(int c = 0; c < data[r].length; c++)
			{
				//add the current element to the total
				total += data[r][c];
			}
		}
		
		//return the total
		return total;
	}
	
	/**Calculate the average of all sales numbers in a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @return the average
	 */
	public static double getAverage(double[][] data)
	{
		//create double representing the sum and number of elements in the 2d ragged array
		double sum = 0;
		int count = 0;
		
		//for loop through the rows and columns of the 2d ragged array
		for(int r = 0; r < data.length; r++)
		{
			for(int c = 0; c < data[r].length; c++)
			{
				//add the current element to the sum
				sum += data[r][c];
				
				//increment count
				count++;
			}
		}
		
		//return average
		return sum/count;
	}
	
	/**Calculate the total of a certain row of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param row the row of the 2D ragged array 
	 * @return total the total
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		//create double representing the total
		double total = 0;
		
		//for loop through the rows of the 2d ragged array
		for(int c = 0; c < data[row].length; c++)
		{
			//add the current element to the total
			total += data[row][c];
		}
		
		//return total
		return total;
	}
	
	/**Calculate the total of a certain column of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param col the column of the 2D ragged array to calculate the total from
	 * @return total the total
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		//create double representing the total
		double total = 0;
		
		//for loop through the rows of the 2d ragged array
		for(int r = 0; r < data.length; r++)
		{
			//add the current element to the total, if possible
			if(data[r].length > col)
			total += data[r][col];
		}
		
		//return total
		return total;
	}
	
	/**Find the highest value in a certain row of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param row the row of the 2D ragged array 
	 * @return highest the highest value
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		//create double representing the highest value of 
		double highest = data[row][0];
		
		//for loop through the columns of the 2d ragged array
		for(int c = 1; c < data[row].length; c++)
		{
			//if the highest is less than the current element, set highest to that element
			if(highest < data[row][c])
			{
				highest = data[row][c];
			}
		}
		
		//return highest
		return highest;
	}
	
	/**Find the index of the highest value in a certain row of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param row the row of the 2D ragged array 
	 * @return the index of the highest value
	 */		
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		//create double representing the highest value of the row
		double highest = getHighestInRow(data, row);
		
		//for loop through the columns of the 2d ragged array
		for(int c = 0; c < data[row].length; c++)
		{
			//if the current element is the highest value, return the index
			if(data[row][c] == highest)
			{
				return c;
			}
		}
		return 0;
	}
	
	/**Find the lowest value in a certain row of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param row the row of the 2D ragged array 
	 * @return lowest the lowest value
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		//create double representing the lowest value
		double lowest = data[row][0];
		
		//for loop through the columns of the 2d ragged array
		for(int c = 1; c < data[row].length; c++)
		{
			//if the current element is less than the lowest value, set the lowest value to current element
			if(lowest > data[row][c])
			{
				lowest = data[row][c];
			}
		}
		
		//return lowest
		return lowest;
	}
	
	
	/**Find the index of the lowest value in a certain row of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param row the row of the 2D ragged array 
	 * @return the index of the lowest value
	 */		
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		//create double representing the lowest value
		double lowest = getLowestInRow(data, row);
		
		//for loop through the columns of the 2d ragged array
		for(int c = 0; c < data[row].length; c++)
		{
			//if the current element is the lowest value, return the index
			if(data[row][c] == lowest)
			{
				return c;
			}
		}
		return 0;
	}
	
	/**Find the highest value in a certain column of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param col the column of the 2D ragged array 
	 * @return highest the highest value
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		//create double representing highest value
		double highest = 0;
		//create int representing row 
		int row = 0;
		
		//for loop through the row of the 2d ragged array
		for(int r = 0; r < data.length; r++)
		{
			//set the first valid value found to the highest value variable
			if(data[r].length > col) 
			{
				highest = data[r][col];
				row = r;
				r = data.length;
			}
		}
		
		//for loop from the row of the first found value
		for(int r = row; r < data.length; r++)
		{
			//check, if possible, if the highest value is less than the current element
			if(data[r].length > col)
			{
				if(data[r][col] > highest)
				{
					highest = data[r][col];
				}
			}
		}
		
		//return highest
		return highest;
	}

	/**Find the index of the highest value in a certain column of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param col the column of the 2D ragged array 
	 * @return the index of the highest value
	 */		
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		//create double to represent the highest value
		double highest = getHighestInColumn(data, col);
		
		//for loop through the rows of the ragged array
		for(int r = 0; r < data.length; r++)
		{
			//see, if possible, if the highest is the current element
			//if so, return the index
			if(data[r].length > col)
			{
				if(data[r][col] == highest)
				{
					return r;
				}
			}
		}
		return 0;
	}

	/**Find the lowest value in a certain column of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param col the column of the 2D ragged array 
	 * @return lowest the lowest value
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		//create double to represent the lowest value
		double lowest = 0;
		//create int representing row 
		int row = 0;
		
		//for loop through the rows of the ragged array
		for(int r = 0; r < data.length; r++)
		{
			//set the first valid value found to the lowest value variable
			if(data[r].length > col) 
			{
				lowest = data[r][col];
				row = r;
				r = data.length;
			}
		}
		
		//for loop from the row of the first found value
		for(int r = row; r < data.length; r++)
		{
			//check, if possible, if the lowest value is greater than the current element
			if(data[r].length > col)
			{
				if(data[r][col] < lowest)
				{
					lowest = data[r][col];
				}
			}
		}
		//return lowest
		return lowest;
	}
	
	/**Find the index of the lowest value in a certain column of a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @param col the column of the 2D ragged array 
	 * @return the index of the lowest value
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		//create double to represent lowest value
		double lowest = getLowestInColumn(data, col);
		
		//for loop through the rows of the ragged array
		for(int r = 0; r < data.length; r++)
		{
			//check if the current element is the lowest value, if so, return the index
			if(data[r].length > col)
			{
				if(data[r][col] == lowest)
				{
					
					return r;
				}
			}
		}
		return 0;
	}
	
	/**Find the highest value in a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @return highest the highest value
	 */
	public static double getHighestInArray(double[][] data)
	{
		//create double to represent the highest value
		double highest = getHighestInRow(data, 0);
		
		//for loop through the rows of the ragged array
		for(int r = 1; r < data.length; r++)
		{
			double highestInRow = getHighestInRow(data, r);
			//compare highest values; replace the true highest if found a larger value
			if(highest < highestInRow)
			{
				highest = highestInRow;
			}
		}
		//return highest
		return highest;
	}
	
	/**Find the lowest value in a 2D ragged array
	 * @param data[][] the 2D ragged array containing sales data
	 * @return lowest the lowest value
	 */
	public static double getLowestInArray(double[][] data)
	{
		//create double to represent the highest value
		double lowest = getLowestInRow(data, 0);
		
		//for loop through the rows of the ragged array
		for(int r = 1; r < data.length; r++)
		{
			double lowestInRow = getLowestInRow(data, r);
			//compare lowest values; replace the true lowest if found a smaller value
			if(lowest > lowestInRow)
			{
				lowest = lowestInRow;
			}
		}
		//return lowest
		return lowest;
	}
}
