import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * CMSC 203
 * 11/10/2019
 * This program works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
 * to organize data 
 * 
 */
public class TwoDimRaggedArrayUtility{
	
	
	/**
	 * Default Constructor
	 */
	public TwoDimRaggedArrayUtility() {
		
		
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for each row is 10 
	 * Each row in the file is separated by a new line Each element in the row is separated by a space
	 * @param file - the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty
	 */
    public static double[][] readFile(File file) {
	   
       double[][] raggedArr = new double[6][];
       String line;
       int i = 0;
       try {
    	   
           BufferedReader br = new BufferedReader(new FileReader(file));      
           
           while((line = br.readLine())!= null){
        	   
               String[] temp = line.split(" ");
               int size = temp.length;
               raggedArr[i] = new double[size];
               
               for(int j = 0;j<size;j++){
            	   
                   raggedArr[i][j] = Double.parseDouble(temp[j]);
               }
               i++;
           }
           br.close();
       }
       catch(Exception ep)
       {
           ep.printStackTrace();
       }
       return raggedArr;
    }

    /**
     * Writes the ragged array of doubles into the file. Each row is on a separate line within the file 
     * and each double is separated by a space.
     * @param raggedArr - two dimensional ragged array of doubles
     * @param file - the file to write to
     */
    public static void writeToFile(double[][] raggedArr,File file) {
	   
       try {
    	   
           BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));
           
           for(int i = 0;i < raggedArr.length; i++) {
               for(int j = 0;j < raggedArr[i].length; j++){
            	   
            	   bufferWriter.write(raggedArr[i][j] + " ");
               }
               bufferWriter.newLine();
           }
           bufferWriter.close();
       }
       catch(Exception ep)
       {
           ep.printStackTrace();
       }

    }

    /**
     * Returns the total of all the elements of the two dimensional array
     * @param raggedArr - the two dimensional array getting total of
     * @return the sum of all the elements in the two dimensional array
     */
    public static double getTotal(double[][] raggedArr) {
	   
       double totalSum = 0;
       
       for(int i = 0;i < raggedArr.length; i++)
       {
           for(int j = 0;j<raggedArr[i].length; j++)
           {
        	   totalSum += raggedArr[i][j];
           }
       }
       return totalSum;
   }
   
    /**
     * Returns the average of the elements in the two dimensional array
     * @param raggedArr - the two dimensional array getting the average of
     * @return the average of the elements in the two dimensional array (total of elements/num of elements)
     */
    public static double getAverage(double[][] raggedArr) {
	   
       double totalAverage = 0;
       int numberOfElements = 0;
       
       for(int i = 0;i < raggedArr.length; i++)
       {
           for(int j = 0;j < raggedArr[i].length; j++)
           {
        	   totalAverage += raggedArr[i][j];
        	   numberOfElements += 1;
           }
       }
       totalAverage = totalAverage/numberOfElements ;
       
       return totalAverage;
    }
   
    /**
     * Returns the total of the selected row in the two dimensional array index 
     * 0 refers to the first row.
     * @param raggedArr - the two dimensional array
     * @param rowIndex - the row index to take the total of (0 refers to the first row)
     * @return the total of the row
     */
     public static double getRowTotal(double[][] raggedArr,int rowIndex) {
	   
       double totalOfRow = 0;
       for(int j = 0;j < raggedArr[rowIndex].length; j++)
       {
    	   totalOfRow += raggedArr[rowIndex][j];

       }
       return totalOfRow;
     }
   
     /**
      * Returns the total of the selected column in the two dimensional array index 
      * 0 refers to the first column
      * @param raggedArr - the two dimensional array
      * @param colIndex - the column index to take the total of (0 refers to the first column)
      * @return the total of the column
      */
     public static double getColumnTotal(double[][] raggedArr,int colIndex) {
	   
       double totalOfColumn = 0;
       for(int i = 0;i < raggedArr.length; i++)
       {
           if(colIndex <= raggedArr[i].length - 1)
        	   totalOfColumn += raggedArr[i][colIndex];
       }
       return totalOfColumn;
     }
   
    /**
     * Returns the largest element of the selected row in the two dimensional array 
     * index 0 refers to the first row.
     * @param raggedArr - the two dimensional array
     * @param rowIndex - the row index to find the largest element of (0 refers to the first row)
     * @return the largest element of the row
     */
    public static double getHighestInRow(double[][] raggedArr,int rowIndex) {
	   
       double highestInRow = raggedArr[rowIndex][0];
       for(int j = 0;j < raggedArr[rowIndex].length; j++)
       {
           if(raggedArr[rowIndex][j] > highestInRow)
        	   highestInRow = raggedArr[rowIndex][j];

       }
       return highestInRow;
    }
   
    /**
     * Returns the largest element of the selected row in the two dimensional array 
     * index 0 refers to the first row.
     * @param raggedArr - the two dimensional array
     * @param rowIndex - the row index to find the largest element of (0 refers to the first row)
     * @return the largest element of the row
     */
    public static int getHighestInRowIndex(double[][] raggedArr, int rowIndex) {
	   
	   double highestInRow = raggedArr[rowIndex][0];
	   int highestRowIndex = 0;
	   for(int j = 0; j < raggedArr[rowIndex].length; j++) {
		   
		   if(raggedArr[rowIndex][j] > highestInRow) {
			   highestInRow = raggedArr[rowIndex][j];
			   highestRowIndex = j;
		   }
	   }
	   return highestRowIndex;
    }
   
    /**
     * Returns the smallest element of the selected row in the two dimensional array 
     * index 0 refers to the first row.
     * @param raggedArr - the two dimensional array
     * @param rowIndex - the row index to find the smallest element of (0 refers to the first row)
     * @return the smallest element of the row
     */
    public static double getLowestInRow(double[][] raggedArr,int rowIndex) {
	   
       double lowestInRow = raggedArr[rowIndex][0];
       for(int j = 0;j < raggedArr[rowIndex].length; j++)
       {
           if(raggedArr[rowIndex][j] < lowestInRow)
        	   lowestInRow = raggedArr[rowIndex][j];

       }
       return lowestInRow;
    }
    
    /**
     * Returns the index of the smallest element of the selected row in the two dimensional 
     * array index 0 refers to the first row.
     * @param raggedArr - the two dimensional array
     * @param rowIndex - the row index to find the smallest element of (0 refers to the first row)
     * @return the index of the smallest element in the row
     */
    public static int getLowestInRowIndex(double[][] raggedArr, int rowIndex) {
	   
	   double lowestInRow = raggedArr[rowIndex][0];
	   int lowestIndex = 0;
       for(int j = 0;j < raggedArr[rowIndex].length; j++)
       {
           if(raggedArr[rowIndex][j] < lowestInRow) {
        	   lowestInRow = raggedArr[rowIndex][j];
        	   lowestIndex = j;
           }

       }
       return lowestIndex;
   }
   
    /**
     * Returns the largest element of the selected column in the two dimensional array 
     * index 0 refers to the first column.
     * @param raggedArr - the two dimensional array
     * @param colIndex - the column index to find the largest element of (0 refers to the first column)
     * @return the largest element of the column
     */
    public static double getHighestInColumn(double[][] raggedArr,int colIndex) {
	   
       double highestInColumn = raggedArr[0][colIndex];
       for(int i = 0;i < raggedArr.length; i++)
       {
           if(colIndex <= raggedArr[i].length - 1)
           {               
               if(raggedArr[i][colIndex] >  highestInColumn)
            	   highestInColumn = raggedArr[i][colIndex];
           }

       }
       return highestInColumn;     
    }
   
    /**
     * Returns index of the largest element of the selected column in the two dimensional 
     * array index 0 refers to the first column
     * @param raggedArr - the two dimensional array
     * @param columnIndex - the column index to find the largest element of (0 refers to the first column)
     * @return the index of the largest element of the column
     */
    public static int getHighestInColumnIndex(double[][] raggedArr, int columnIndex) {
	   
	   double highestInColumn = raggedArr[0][columnIndex];
	   int highestIndex = 0;
       for(int i = 0;i < raggedArr.length; i++)
       {
           if(columnIndex <= raggedArr[i].length - 1)
           {               
               if(raggedArr[i][columnIndex] > highestInColumn) {
            	   highestInColumn = raggedArr[i][columnIndex];
                   highestIndex = i;
               }
           }

       }
       return highestIndex;  
    }
   
    /**
     * Returns the smallest element of the selected column in the two dimensional array index 0 
     * refers to the first column
     * @param raggedArr - the two dimensional array
     * @param colIndex - the column index to find the smallest element of (0 refers to the first column)
     * @return the smallest element of the column
     */
    public static double getLowestInColumn(double[][] raggedArr,int colIndex) {
	   
       double lowestInColumn = raggedArr[0][colIndex];
       for(int i = 0;i < raggedArr.length;i++)
       {
           if(colIndex <= raggedArr[i].length-1)
               if(raggedArr[i][colIndex] < lowestInColumn)
            	   lowestInColumn = raggedArr[i][colIndex];

       }
       return lowestInColumn;  
    }
   
    /**
     * Returns the index of the smallest element of the selected column in the two dimensional 
     * array index 0 refers to the first column
     * @param raggedArr - the two dimensional array
     * @param columnIndex - the column index to find the smallest element of (0 refers to the first column)
     * @return the index of the smallest element of the column
     */
    public static int getLowestInColumnIndex(double[][] raggedArr, int columnIndex) {
	   
	   double lowestInColumn = raggedArr[0][columnIndex];
	   int lowestIndex = 0;
       for(int i = 0;i < raggedArr.length; i++)
       {
           if(columnIndex <= raggedArr[i].length-1)
               if(raggedArr[i][columnIndex] < lowestInColumn) {
            	   lowestInColumn = raggedArr[i][columnIndex];
                   lowestIndex = i;
               }

       }
       return lowestIndex; 
    }
   
    /**
     * Returns the index of the smallest element of the selected column in the two dimensional 
     * array index 0 refers to the first column. Ignores any negative values found
     * @param raggedArr - the two dimensional array
     * @param columnIndex - the column index to find the smallest element of (0 refers to the first column)
     * @return the index of the smallest element of the column
     */
    public static int getLowestInColumnIndexIgnoreNegative(double[][] raggedArr, int columnIndex) {
	   
	   double lowestInColumn = raggedArr[0][columnIndex];
	   int lowestIndex = 0;
       
	   if(lowestInColumn < 0)
		   lowestInColumn = 0;
	   
	   for(int i = 0; i < raggedArr.length; i++)
       {
		   System.out.println("Entering " + i);
		   if(columnIndex <= raggedArr[i].length-1) {
        	   System.out.println("IndexValue "+ i + " " + raggedArr[i][columnIndex]);
        	   if(raggedArr[i][columnIndex] > 0 ) 
               {
        		   if (lowestInColumn == 0) {
        			   lowestInColumn = raggedArr[i][columnIndex];
        			   lowestIndex = i;
        		   }
        		   else {
        			   if(raggedArr[i][columnIndex] < lowestInColumn) {
        				   lowestInColumn = raggedArr[i][columnIndex];
        				   lowestIndex = i;
        			   }
        		   }
               }
           }

       }
       return lowestIndex; 
    }
   
    /**
     * Returns the largest element in the two dimensional array
     * @param raggedArr - the two dimensional array
     * @return the largest element in the two dimensional array
     */
    public static double getHighestInArray(double[][] raggedArr) {
	   
       double highestArray = raggedArr[0][0];
       for(int i = 0;i < raggedArr.length; i++)
       {
           for(int j = 0;j < raggedArr[i].length; j++)
           {
               if(raggedArr[i][j] > highestArray)
            	   highestArray = raggedArr[i][j];

           }
       }
       return highestArray;
    }
   
    /**
     * Returns the smallest element in the two dimensional array
     * @param raggedArr - the two dimensional array
     * @return the smallest element in the two dimensional array
     */
    public static double getLowestInArray(double[][] raggedArr) {
	   
       double lowestArray = raggedArr[0][0];
       for(int i = 0;i < raggedArr.length; i++)
       {
           for(int j = 0;j < raggedArr[i].length; j++)
           {
               if(raggedArr[i][j] < lowestArray)
            	   lowestArray = raggedArr[i][j];

           }
       }
       return lowestArray;
    }
}