package _solutionF2018;

import java.io.*;


import java.util.Scanner;


/**
 * 
 * 
 *
 */
public class TwoDimRaggedArrayUtility {
	
	private static Scanner userInput;
	private static PrintWriter fileWriter;
	
/**Default Constructor 
 * 
 */
	TwoDimRaggedArrayUtility(){
		
	}
	
	
	/**This method will read the text files and and them to the 2-D ragged Arrays
	 * 
	 * @param file The file that is being read by the method
	 * @return Returns the Array 
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		double[][] inputFile=null;		
		int rows=0;
		String line="";
		
			
			try {
			userInput = new Scanner(file);
			Scanner readLineNum=new Scanner(file); //Opens and reads the file
			while(readLineNum.hasNextLine()) { //Will continue if there is a line
				readLineNum.nextLine(); //Will go to the next line until there are none 
				++rows; //Counter for the amount of rows depending on how many lines 
				
			}
			readLineNum.close(); //Closes File
			
			inputFile= new double [rows][];
				
				for(int i =0;i<inputFile.length;i++) {
					line= userInput.nextLine();				
					String[]nums=line.split(" "); //Splits the numbers into seperate strings 
					inputFile[i]= new double[nums.length];
				for(int x=0;x<inputFile[i].length;x++) {
					inputFile[i][x]= Double.parseDouble(nums[x]); //Converts the string numbers into doubles 
					
					
					
				}									
			}				
		}
			catch (FileNotFoundException e) {
				System.out.print("Error File not Found");
				}
			
		//Returns the array
	return inputFile;
	}
	
	/**This Method reads the files then writes over them making sure it is printed correctly written with spaces in between
	 * 
	 * @param data The Array being passed in
	 * @param outputFile The file that is being written over and then outputted 
	 */
	public static void writeToFile(double [][]data, File outputFile) {
		int fileCount=0;
		
		do {
			try {
				fileWriter = new PrintWriter(outputFile);
				//I and X essentially represent rows and columns and the file writer writes the new doubles in the file 
				for(int i=0;i<data.length;i++) {
					for(int x=0;x<data[i].length;x++) {
						fileWriter.print(data[i][x]+" "); //Adding a blank space so each number has space in between 
					}
				fileWriter.println();
				}
				fileCount=1; //To exit from the do while loop 
			}
			catch(FileNotFoundException e) {
				System.out.print("Error an Exception has occured");
			}
		}while (fileCount==0);
		
	fileWriter.close(); //Closes file 
	}
/**This will all of he Array rows and columns together to get a total
 * 
 * @param data Data Array being passed in 
 * @return The total Amount
 */
	public static double getTotal(double [][]data) {
		double total=0;
		for(int i=0;i<data.length;i++)
			for(int x=0;x<data[i].length;x++) { //Two for loops to get both dimensions of the array then adding it again 
				total+=data[i][x];
			}
		return total;
	}
	/**
	 * 
	 * @param data
	 * @return Returns the average 
	 */
	public static double getAverage(double[][]data) {
		int totalAverage=0;
		double average;
		
		for(int i=0;i<data.length;i++) {
			for(int x=0;x<data[i].length;x++) {
				//Adds one to total average to have the total amount of data sets in the array to then find the average
				totalAverage++;
			}
		}
		average=(getTotal(data))/totalAverage; //Calling the total amount method and divide that value by the total average
		
		return average; //Returns the average
	}
	/**Counts the amount of rows there are
	 * 
	 * @param data The array being passed in 
	 * @param row The amount of rows 
	 * @return
	 */
	public static double getRowTotal(double[][] data, int row) {
		double totalRows=0;
		
		for(int i=0;i<data[row].length;i++) { // Adding the amount of rows 
			totalRows+=data[row][i];
		}
	return totalRows; //Returns the total amount of rows	
	}
	/**Counts the amount of columns there are
	 * 
	 * @param data -Array being passed in 
	 * @param col -Amount of columns 
	 * @return Returns the amount of Columns
	 */
	public static double getColumnTotal(double [][]data, int col) {
		double totalCol=0;
		
		for(int i=0;i<data.length;i++) { 
			if(col<data[i].length) { //If the number of columns is less than the number of rows then it adds one to the total amount of columns
			totalCol+=data[i][col];
			}
		}
		return totalCol;
	}
	/**Returns the highest number in the row 
	 * 
	 * @param data Array being passed in 
	 * @param row The amount of rows 
	 * @return Returns the largest element in the row
	 */
	public static double getHighestInRow(double[][]data, int row) {
		double highestRow=0;
		for(int i=0;i<data[row].length;i++) {
			if(i==0) { //Sets highest row to [0] to then test against the other elements
				highestRow=data[row][i];
					}
						if(data[row][i]>highestRow) { //If another element is greater than highest row new value is now the other element
								highestRow=data[row][i];
							}
					}
			return highestRow;
	}
	/**Returns the index of the highest element in the row
	 * 
	 * @param data Passed in Array
	 * @param row The amount of rows
	 * @return Returns the index of the highest element 
	 */
	public static int getHighestInRowIndex(double[][]data, int row) {
		int highestRowIndex=0;
		double highIndex=0;
			for(int i=0;i<data[row].length;i++) {
				if(i==0) { //Sets highest row to [0] to then test against the other elements
					highIndex=data[row][i];
							}
							if(highIndex<data[row][i]) {
								highIndex=data[row][i]; 
									highestRowIndex=i; // i Represents the index in where the highest element is located 
							}
				}
		return highestRowIndex;
	}
	/**Returns the lowest element in the row 
	 * 
	 * @param data Passed in array 
	 * @param row The amount of rows
	 * @return Returns the the lowest element in the row 
	 */
	public static double getLowestInRow(double[][]data, int row) {
		double lowestRow=0;
		for(int i=0;i<data[row].length;i++) {
			if(i==0) { //Set the lowestRow to 0's elements for testing 
				lowestRow=data[row][i];
			}
			if(lowestRow>data[row][i]) { // Testing 0's elements to the others than giving it a new value 
				lowestRow=data[row][i];
			}
			
		}				
		return lowestRow;
	}
	/**Returns the lowest element in row index
	 *  
	 * @param data Passed in array 
	 * @param row The amount of row
	 * @return Returns the lowest element's index
	 */
	public static int getLowestInRowIndex(double[][]data, int row) {
		double lowIndex=0;
		int lowestRowIndex=0;
		for(int i=0;i<data[row].length;i++) {
			if(i==0) {
				lowIndex=data[row][i];
			}
		if(lowIndex>data[row][i]) {
			lowIndex=data[row][i]; //Testing the elements against other 
			lowestRowIndex=i;
		}
			
		}
		return lowestRowIndex;
	}
	/**This method gets the highest number in the column
	 * 
	 * @param data Array being passed in 
	 * @param col The amount of columns there are 
	 * @return Returns highest element in the column
	 */
	public static double getHighestInColumn(double[][]data,int col) {
		double highestColumn=0;
		boolean compareTest=false;
		for(int row=0;row<data.length;row++) {
			if(col<data[row].length && compareTest==false) { //If the amount of columns is less than row length 
				highestColumn=data[row][col]; //Assign new value to the highest column 
				compareTest=true; //To skip over the first test to then use the second test 
			} else if(col<data[row].length && highestColumn<data[row][col]) {
				highestColumn=data[row][col];
			}
		
		}
		return highestColumn;	
	}
	/**Returns the index of the highest element 
	 * 
	 * @param data Array being passed in 
	 * @param col The amount of columns 
	 * @return  Returns the index of the highest element 
	 */
	public static int getHighestInColumnIndex(double[][]data,int col) {
		double highColIndex=0;
		int colIndex=0;
		boolean compareTest=false;
		for(int i=0;i<data.length;i++) { 
			if(col<data[i].length && compareTest==false) {
				highColIndex=data[i][col];
				compareTest=true;
				colIndex=i; // Adds the index to the variable to be returned
			} else if(col<data[i].length && highColIndex<data[i][col]) { //second test to possibly change the index
				highColIndex=data[i][col];
				colIndex=i;
			}
				
		}
		return colIndex;
	}
	/** This method returns the element which is the lowest in the column
	 * 
	 * @param data The array being passed into the method 
	 * @param col The  amount of columns
	 * @return Returns the lowest element in the column 
	 */
	public static double getLowestInColumn(double[][]data, int col) {
		double lowCol=0;
		boolean compareTest=false;
			for(int i=0;i<data.length;i++) {
				if(col<data[i].length && compareTest==false) { //To set the first value to then be tested 
					lowCol=data[i][col];
					compareTest=true;
					}
				//If the lowest column element in the variable
				//is greater than the current element the value changes

				else if(col<data[i].length && data[i][col]<lowCol) { 
					lowCol=data[i][col];
					}
			}
			return lowCol;
		}
	/**Returns the lowest element index in the column 
	 * 
	 * @param data Array being passed in 
	 * @param col The amount of columns 
	 * @return Returns the index of the lowest element
	 */
	public static int getLowestInColumnIndex(double[][]data,int col) {
		double lowColIndex=0;
		int colIndex=0;
		boolean compareTest=false;
		
		for(int i =0;i<data.length;i++) {
			if(col<data[i].length && compareTest==false) {
				lowColIndex=data[i][col];
				compareTest=true;
				colIndex=i; // Adds the index of the element to the variable to then be returned 
				}
			else if(col<data[i].length && data[i][col]<lowColIndex) { //Second test to possibly change the index
				lowColIndex=data[i][col];
				colIndex=i;
			}
		}
		
		return colIndex;
		}
	/**Returns the highest elements in the array
	 * 
	 * @param data The passed in array 
	 * @return Returns the highest in array elements
	 */
	public static double getHighestInArray(double[][]data) {
		double highestArray=0;
		for(int i=0;i<data.length;i++) { //To get the amount of rows essentially 
			for(int x=0;x<data[i].length;x++) { //To get the amount of columns essentially 
				if(i==0&&x==0) { //Sets the variable to the first elements in the array for testing 
					highestArray=data[i][x];
							}
					if(highestArray<data[i][x]) { //Second test to possible change the value of the variable
						highestArray=data[i][x];
						
								}
						}
				}
			return highestArray;
		}
	/**Returns the lowest element in the array 
	 * 
	 * @param data The array being passed in 
	 * @return Returns the lowest element in the array 
	 */
	public static double getLowestInArray(double[][]data) {
		double lowestArray=0;
		for(int i=0;i<data.length;i++) {
			for(int x=0;x<data[i].length;x++) {
				if(i==0&&x==0) { //Sets the variable to the first elements in the array for testing
					lowestArray=data[i][x];
							}
						if(lowestArray>data[i][x]) {
								lowestArray=data[i][x];//Second test to possible change the value of the variable
						
									}
							}
					}
		return lowestArray;
	}
	
}
