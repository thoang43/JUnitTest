import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Two Dimensional Array Utility
 * 
 * author: Matthew Proctor
 */


public class TwoDimRaggedArrayUtility {

	
	//Class Constructor
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	
	//Class Methods
	
	
	
	//readFile method
	public static double[][] readFile(File inputFile) throws java.io.FileNotFoundException{
		
		//Create file object
		
		
		
		//Create scanner objects
		Scanner s = new Scanner(inputFile);
		Scanner x = new Scanner(inputFile);
		
		
		//Create temporary array of Double
		Double t[][] = new Double[10][10];
		
		//Set row counter
		int r = 0;
		
		//Find number of columns in file
		while(s.hasNextLine()) {
			
			int c = s.nextLine().split(" ").length;	
		
			//Set temporary array
			for(int i = 0; i < c; i++) {
				
				if(x.hasNextDouble()) {
					
					t[r][i] = x.nextDouble();	
					
				}
				
				//System.out.print(t[r][i]);
				
				
			}
			
			//System.out.println();
			
			//increase row count
			r++;
		}
		
		//Create ragged array
		double d[][] = new double[r][];
		
		//Set counter for columns
		int n = 0;
		
		//Loop and set array
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < t[i].length; j++) {
				
				
				//check column count
				if(t[i][j] !=null) {
					
					n++;
					
				}
			
			}
			
			//initialize ragged array
			d[i] = new double[n];
			
			
			//set ragged array
			for(int j = 0; j < n; j++) {
				
				d[i][j] = t[i][j];
				
				//System.out.print(d[i][j]);
				
				
			}
			
			//System.out.println();
			
			//reset counter
			n = 0;
		}
		
		//close scanners
		s.close();
		x.close();
		
		//return array
		return d;
		
		
		
	}
	
	//writeToFile method
	public static void writeToFile(double[][] data, File outputFile) throws IOException, java.io.FileNotFoundException {
		
		//creates buffered writer
		BufferedWriter o = new BufferedWriter(new FileWriter(outputFile));
		
		//Loop through array and write to file
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				o.write(Double.toString(data[i][j]) + " ");
			}
			o.newLine();
		}
		
		o.close();
		
		
	}
	
	//getTotal method
	public static double getTotal(double[][] data) {
		
		double sum = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				
				sum += data[i][j];
			}
		}
		
		return sum;
		
	}
	
	//getAverage method
	public static double getAverage(double[][] data) {
		
		double sum = 0;
		int count = 0;
		double avg;
		
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				
				sum += data[i][j];
				
				count++;
			}
		}
		
		avg = sum / count;
		
		return avg;
		
	}
	
	//getRowTotal method
	public static double getRowTotal(double[][] data, int row) {
		
		double sum = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			
			sum += data[row][i];
		}
		
		return sum;
		
	}
	
	//getColumnTotal method
	public static double getColumnTotal(double[][] data, int col) {
		
		double sum = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				
				if(j == col) {
					sum += data[i][j];
				}
				
			}
		}
		
		return sum;
		
	}
	
	//getHighestInRow method
	public static double getHighestInRow(double[][] data, int row) {
		
		double high = data[row][0];
		
		for(int i = 0; i < data[row].length; i++) {
			
			if(data[row][i] > high) {
				
				high = data[row][i];
			}
			
		}
		
		return high;
		
	}
	
	//getHighestInRowIndex method
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		double high = data[row][0];
		int index = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			
			if(data[row][i] > high) {
				
				high = data[row][i];
				index = i;
			}
			
		}
		
		return index;
		
	}
	
	//getLowestInRow
	public static double getLowestInRow(double[][] data, int row) {
		
		double low = data[row][0];
		
		
		for(int i = 0; i < data[row].length; i++) {
			
			if(data[row][i] < low) {
				
				low = data[row][i];
				
			}
			
		}
		
		return low;
		
	}
	
	//getLowestInRowIndex
	public static int getLowestInRowIndex(double[][] data, int row) {
		
		double low = data[row][0];
		int index = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			
			if(data[row][i] < low) {
				
				low = data[row][i];
				index = i;
			}
			
		}
		
		return index;
		
	}
	
	//getHighestInColumn
	public static double getHighestInColumn(double[][] data, int col) {
		
		int count = 0;
		double high = 0;
		
		for(int i = 0; i < data.length; i++) {
			
			for(int j = 0; j < data[i].length; j++) {
				
				if(j == col) {
					
					if(count < 1) {
						high = data[i][j];
						count++;
					}
					
					if(data[i][j] > high) {
						
						high = data[i][j];
						
					}
					
				}
				
			}
			
		}
		
		return high;
		
	}
	
	//getHighestInColumnIndex
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		int index = 0;
		int count = 0;
		double high = 0;
		
		for(int i = 0; i < data.length; i++) {
			
			for(int j = 0; j < data[i].length; j++) {
				
				if(j == col) {
					
					if(count < 1) {
						high = data[i][j];
						index = i;
						count++;
						
					}
					
					if(data[i][j] > high) {
						
						high = data[i][j];
						index = i;
						
					}
					
				}
				
			}
			
		}
		
		return index;
		
	}
	
	//getLowestInColumn
	public static double getLowestInColumn(double[][] data, int col) {
		
		int count = 0;
		double low = 0;
		
		for(int i = 0; i < data.length; i++) {
			
			for(int j = 0; j < data[i].length; j++) {
				
				if(j == col) {
					
					if(count < 1) {
						
						low = data[i][j];
						count++;
					}
					
					
					if(data[i][j] < low) {
						
						low = data[i][j];
						
					}
					
				}
				
			}
			
		}
		
		return low;
		
	}
	
	//getLowestInColumnIndex
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		
		int index = 0;
		int count = 0;
		double low = 0;
		
		for(int i = 0; i < data.length; i++) {
			
			
			for(int j = 0; j < data[i].length; j++) {
				
				if(j == col) {
					
					if(count < 1) {
						
						low = data[i][j];
						index = i;
						count++;
					}
					
					
					if(data[i][j] < low) {
						
						low = data[i][j];
						index = i;
						
					}
					
				}
				
			}
			
		}
		
		return index;
		
		
	}
	
	//getHighestInArray
	public static double getHighestInArray(double[][] data) {
		
		double high = data[0][0];
		
		for(int i = 0; i < data.length; i++) {
			
			for(int j = 0; j < data[i].length; j++) {
				
				if(data[i][j] > high) {
					
					high = data[i][j];
					
				}
				
			}
			
		}
		
		return high;
		
	}
	
	//getLowestInArray
	public static double getLowestInArray(double[][] data) {
		
		double low = data[0][0];
		
		for(int i = 0; i < data.length; i++) {
			
			for(int j = 0; j < data[i].length; j++) {
				
				if(data[i][j] < low) {
					
					low = data[i][j];
					
				}
				
			}
			
		}
		
		return low;
		
	}
	
	
}
