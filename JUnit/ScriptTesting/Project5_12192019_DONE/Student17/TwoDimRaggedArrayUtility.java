import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility{

	public static double[][] readFile(File file) throws FileNotFoundException{
		double[][] array;
		Scanner input = new Scanner(file);
		int rows = 0;
		while(input.hasNextLine()){
			rows++;
			input.nextLine();
		}
		input.close();
		input = new Scanner(file);
		String line;
		array = new double[rows][];
		for(int i = 0; i < array.length; i++){
			line = input.nextLine();
			String[] data = line.split(" ");
			array[i] = new double[data.length];
			for(int j = 0; j < array[i].length; j++){
				array[i][j] = Double.valueOf(data[j]);
			}
		}
		input.close();
		return array;
	}
	
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException{
		PrintWriter output = new PrintWriter(file);
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
					output.print(data[i][j] + " ");
			}
			output.println();
		}
		output.close();
	}
	
	public static double getTotal(double[][] array){
		double total = 0.0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				total += array[i][j];
			}
		}
		return total;
	}
	
	public static double getAverage(double[][] array){
		double average;
		int count = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				count++;
			}
		}
		average = getTotal(array) / count;
		return average;
	}
	
	public static double getRowTotal(double[][] array, int row){
		double total = 0.0;
		for(int i = 0; i < array[row].length; i++){
			total += array[row][i];
		}
		return total;
	}
	
	public static double getColumnTotal(double[][] array, int col){
		double total = 0.0;
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length){
				total += array[i][col];
			}
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] array, int row){
		double highest = 0.0;
		for(int i = 0; i < array[row].length; i++){
			if(i == 0){
				highest = array[row][i];
			}
			else if(array[row][i] > highest){
				highest = array[row][i];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] array, int row) {
		double highest = 0.0;
		int index = -1;
		for(int i = 0; i < array[row].length; i++){
			if(i == 0){
				highest = array[row][i];
				index = i;
			}
			else if(array[row][i] > highest){
				highest = array[row][i];
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInRow(double[][] array, int row){
		double lowest = 0.0;
		for(int i = 0; i < array[row].length; i++){
			if(i == 0){
				lowest = array[row][i];
			}
			else if(array[row][i] < lowest){
				lowest = array[row][i];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] array, int row) {
		double lowest = 0.0;
		int index = -1;
		for(int i = 0; i < array[row].length; i++){
			if(i == 0){
				lowest = array[row][i];
				index = i;
			}
			else if(array[row][i] < lowest){
				lowest = array[row][i];
				index = i;
			}
		}
		return index;
	}
	
	public static double getHighestInColumn(double[][] array, int col){
		double highest = Double.NEGATIVE_INFINITY;
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length && array[i][col] > highest){
				highest = array[i][col];
			}
		}
		return highest;
	}
	
	public static int getHighestInColumnIndex(double[][] array, int col) {
		double highest = Double.NEGATIVE_INFINITY;
		int index = -1;
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length && array[i][col] > highest){
				highest = array[i][col];
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInColumn(double[][] array, int col){
		double lowest = Double.POSITIVE_INFINITY;
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length && array[i][col] < lowest){
				lowest = array[i][col];
			}
		}
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double[][] array, int col) {
		double lowest = Double.POSITIVE_INFINITY;
		int index = -1;
		for(int i = 0; i < array.length; i++){
			if(col < array[i].length && array[i][col] < lowest){
				lowest = array[i][col];
				index = i;
			}
		}
		return index;
	}
	
	public static double getHighestInArray(double[][] array){
		double highest = 0.0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				if(i == 0 && j == 0){
					highest = array[i][j];
				}
				else if(array[i][j] > highest){
					highest = array[i][j];
				}
			}
		}
		return highest;
	}
	
	public static double getLowestInArray(double[][] array){
		double lowest = 0.0;
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				if(i == 0 && j == 0){
					lowest = array[i][j];
				}
				else if(array[i][j] < lowest){
					lowest = array[i][j];
				}
			}
		}
		return lowest;
	}
}