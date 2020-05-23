
import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
 *
 * This utility works with negative and positive numbers
 *
 * This is a utility class -- there are no private data members
 *
 *  */
public class TwoDimRaggedArrayUtility extends java.lang.Object
{
    /**
     * Constructor = VOID
     */
    public TwoDimRaggedArrayUtility(){}

    /**
     * Reads from a file and returns a ragged array of doubles.
     * The max # rows is 10, max # columns for each row is 10.
     * Each row in file is separated by a new line. Each element in the row is separated by a space.
     * Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array.
     * 1. Read the doubles from the file into a temporary array [10][10] of Strings which was initialized to nulls.
     * 2. find out how many rows there are (any rows that has the first element !=null is a valid row).
     * 3. Create the array based on the # of rows, (i.e., see below):
     * double[][] array = new double[#rows][]
     * 4. Determine the # of columns for the first row (any element != null is a valid element)
     * 5. Create the array based on the num of rows, i.e.,
     * array[0] = new double[#columns]
     * 6. Put the values from the temporary array into in the row (don't forget to convert from Strings to doubles)
     * 7. Repeat for all rows
     * @param file the file to read from
     * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
     */
    public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException
    {
        double[][] data = null;
        try
        {
            Scanner input = new Scanner(file);
            int rows = 0;
            
            while (input.hasNextLine())
            {
                rows++;
                input.nextLine();
            }
            
            input.close();
            input = new Scanner(file);
            String line;
            data = new double[rows][];
            
            for (int i = 0; i < data.length; i++)
            {
                line = input.nextLine();
                String[] numbers = line.split(" ");
                data[i] = new double[numbers.length];
                
                for (int j = 0; j < data[i].length; j++)
                {
                    data[i][j] = Double.valueOf(numbers[j]);
                }
            }
            input.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * writeFile method
     * @param data two dimensional ragged array of doubles
     * @param outputFile the file to write to
     */
    public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException
    {
        try
        {
            BufferedWriter bufferedWrite = new BufferedWriter(new FileWriter(outputFile));
            for (int i = 0; i < data.length; i++)
            {
                for (int j=0; j<data[i].length; j++)
                {
                    bufferedWrite.write(data[i][j] + " ");
                }
                
                bufferedWrite.write("\n");
            }
            
            bufferedWrite.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Returns the total of all elements of the two dimensional array
     * @param data the two dimensional array to get total of
     * @return the sum of all the elements in the two dim array
     */
    public static double getTotal(double[][] data)
    {
        double total = 0.0;
        
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                total += data[i][j];
            }
        }
        return total;
    }

    /**
     * returns the average of the elements in the two dimensional array
     * @param data the two dimensional array to get the average of
     * @return the average of the elements in the two dimensional array (total of elements/num of elements)
     */
    public static double getAverage(double[][] data)
    {
        double average;
        int numOfElements = 0;
        
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                numOfElements++;
            }
        }
        average = (getTotal(data)) / numOfElements;
        return average;
    }

    /**
     * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
     * @param data the two dimensional array
     * @param row the row index to take the total of (0 = first row)
     * @return the total of the row
     */
    public static double getRowTotal(double[][] data, int row)
    {
        double totalInRow = 0.0;
        
        for (int i = 0; i < data[row].length; i++)
        {
            totalInRow += data[row][i];
        }
        return totalInRow;
    }

    /**
     * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
     * @param data the two dimensional array
     * @param col the column index to take the total of (0 refers to the first column)
     * @return the total of the row
     */
    public static double getColumnTotal(double[][] data, int col)
    {
        double totalInCol = 0.0;
        
        for (int i = 0; i < data.length; i++)
        {
            if (col < data[i].length)
                try
            	{
                    totalInCol += data[i][col];
                } catch(Exception e)
            	{
                    totalInCol += 0;
                }
        }
        return totalInCol;
    }

    /**
     * Returns the largest element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dimensional array
     * @param row the row index to find the largest element of (0=first row)
     * @return the largest element of the row
     */
    public static double getHighestInRow(double[][] data, int row)
    {
        int maxRowIndex = 0;
        double maxInRow = data[row][0];
        
        for (int i = 0; i < data[row].length; i++)
        {
            if(data[row][i] > maxInRow)
            {
                maxInRow = data[row][i];
                maxRowIndex = i;
            }
        }
        return maxInRow;
    }

    /**
     * Returns the index of the largest element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dimensional array
     * @param row the row index to find the largest element (0=first row)
     * @returns the row index of the largest element
     */
    public static int getHighestInRowIndex(double[][] data, int row)
    {
        int maxRowIndex = 0;
        double maxInRow = data[row][0];
        
        for (int i = 0; i < data[row].length; i++)
        {
            if (data[row][i] > maxInRow)
            {
                maxInRow = data[row][i];
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    /**
     * Returns the smallest element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dim array
     * @param the row index to find the smallest element of (0=first row)
     * @return the smallest element of row
     */
    public static double getLowestInRow(double[][] data, int row)
    {
        int minRowIndex = 0;
        double minInRow = data[row][0];
        
        for (int i = 0; i < data[row].length; i++)
        {
            if (data[row][i] < minInRow)
            {
                minInRow = data[row][i];
                minRowIndex = i;
            }
        }
        return minInRow;
    }

    /**
     * Returns the index of the smallest element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dim array
     * @param the row index to find the smallest element of (0=first row)
     * @return the index of the smallest element of row
     */
    public static int getLowestInRowIndex(double[][] data, int row)
    {
        int minRowIndex = 0;
        double minInRow = data[row][0];
        
        for (int i = 0; i < data[row].length; i++)
        {
            if (data[row][i] < minInRow)
            {
                minInRow = data[row][i];
                minRowIndex = i;
            }
        }
        return minRowIndex;
    }

    /**
     * Returns the largest element of the selected column in the two dim array index (0=first column)
     * If a row in the two dim array doesn't have this column index, it is not an error, it does not participate in this method
     * @param data the two dim array
     * @param col the column index to find the largest element of (0=first column)
     * @return the largest element of the column
     */
    public static double getHighestInColumn(double[][] data, int col)
    {
        int maxColIndex = 0;
        double maxInCol;
        
        try
        {
            maxInCol = data[0][col];
        } catch (Exception e)
        {
            maxInCol = 0.0;
        }
        
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if (data[i][col] > maxInCol)
                {
                    maxInCol = data[i][col];
                    maxColIndex = i;
                }
            } catch (Exception e)
            {
                continue;
            }
        }
        return maxInCol;
    }

    /**
     * Returns index of the largest element of the selected column in the two dim array index (0=first column)
     * If a row in the two dim array doesn't have this column index, it is not an error, it does not participate in this method
     * @param data the two dim array
     * @param col the column index to find the largest element of (0=first column)
     * @return index of the largest element of the column
     */
    public static int getHighestInColumnIndex(double[][] data, int col)
    {
        int maxColIndex = 0;
        double maxInCol;
        
        try
        {
            maxInCol = data[0][col];
        } catch (Exception e)
        {
            maxInCol = 0.0;
        }
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if (data[i][col] > maxInCol)
                {
                    maxInCol = data[i][col];
                    maxColIndex = i;
                }
            } catch (Exception e)
            {
                continue;
            }
        }
        return maxColIndex;
    }

    /**
     * Returns the smallest element of the selected column in the two dim array index (0=first column)
     * If a row in the two dim array does not have this column index, it is not an error, it does not participate in this method
     * @param data the two dimensional array
     * @param col the column index to find the smallest element of (0=first column)
     * @return the smallest element of the column
     */
    public static double getLowestInColumn(double[][] data, int col)
    {
        int minColIndex = 0;
        double minInCol;
        
        try
        {
            minInCol = data[0][col];
        } catch (Exception e)
        {
            minInCol = Double.POSITIVE_INFINITY;
        }
        for (int i = 0; i < data.length; i++) {
            try
            {
                if (data[i][col] < minInCol)
                {
                    minInCol = data[i][col];
                    minColIndex = i;
                }
            } 
            catch (Exception e)
            {
                continue;
            }
        }
        return minInCol;
    }

    /**
     * Returns the index of the smallest element of the selected column in the two dimensional array index (0=first column)
     * If a roww in the two dimensional array does not have this column index, it is not an error, it does not participate in this method
     * @param data the two dim array
     * @param col the column index to find the smallest element of (0=first column)
     * @return the index of the smallest element in the column
     */
    public static int getLowestInColumnIndex(double[][] data, int col)
    {
        int minColIndex = 0;
        double minInCol;
        
        try
        {
            minInCol = data[0][col];
        } catch (Exception e)
        {
            minInCol = Double.POSITIVE_INFINITY;
        }
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if (data[i][col] < minInCol)
                {
                    minInCol = data[i][col];
                    minColIndex = i;
                }
            } 
            catch (Exception e)
            {
                continue;
            }
        }
        return minColIndex;
    }

    /**
     * Returns the largest element in the two dimensional array
     * @param data the two dimensional array
     * @return the largest element in the two dimensional array
     */
    public static double getHighestInArray(double[][] data)
    {
        double maxInArray = data[0][0];
        int rowIndex = 0;
        int colIndex = 0;
        
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                if (data[i][j] > maxInArray)
                {
                    maxInArray = data[i][j];
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        return maxInArray;
    }

    /**
     * Returns the smallest element in the two dimensional array
     * @param data the two dimensional array
     * @return the smallest element in the two dimensional array
     */
    public static double getLowestInArray (double[][] data)
    {
        double minInArray = data[0][0];
        int rowIndex = 0;
        int colIndex = 0;
        
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                if (data[i][j] < minInArray) {
                    minInArray = data[i][j];
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        return minInArray;
    }

    /****************************************************************************************************************************
     * CUSTOM ADDED METHODS FOR HOLIDAYBONUS.JAVA (in hopes to increase readability & decrease code repeating)
     ****************************************************************************************************************************/

    
    /**
     * Returns the largest POSITIVE element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dimensional array
     * @param row the row index to find the largest POSITIVE element of (0=first row)
     * @return the largest POSITIVE element of the row
     */
    public static double getHighestPositiveInRow(double[][] data, int row)
    {
        int maxRowIndex = 0;
        double maxInRow = data[row][0];
        double lowerCap = 0.0;
        
        for (int i = 0; i < data[row].length; i++)
        {
            if((data[row][i] > maxInRow) && (data[row][i] > lowerCap))
            {
                maxInRow = data[row][i];
                maxRowIndex = i;
            }
        }
        return maxInRow;
    }

    /**
     * Returns the index of the largest POSITIVE element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dimensional array
     * @param row the row index to find the largest POSITIVE element (0=first row)
     * @returns the row index of the largest POSITIVE element
     */
    public static int getHighestPositiveInRowIndex(double[][] data, int row)
    {
        int maxRowIndex = 0;
        double maxInRow = data[row][0];
        double lowerCap = 0.0;
        
        for (int i = 0; i < data[row].length; i++)
        {
            if ((data[row][i] > maxInRow) && (data[row][i] > lowerCap))
            {
                maxInRow = data[row][i];
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    /**
     * Returns the smallest POSITIVE element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dim array
     * @param the row index to find the smallest POSITIVE element of (0=first row)
     * @return the smallest POSITIVE element of row
     */
    public static double getLowestPositiveInRow(double[][] data, int row)
    {
        int minRowIndex = 0;
        double minInRow = data[row][0];
        double cap = 0.0;
        
        for (int i = 0; i < data[row].length; i++)
        {
            if ((data[row][i] < minInRow) && (data[row][i] > cap))
            {
                minInRow = data[row][i];
                minRowIndex = i;
            }
        }
        return minInRow;
    }

    /**
     * Returns the index of the smallest POSITIVE element of the selected row in the two dimensional array index (0=first row)
     * @param data the two dim array
     * @param the row index to find the smallest POSITIVE element of (0=first row)
     * @return the index of the smallest POSITIVE element of row
     */
    public static int getLowestPositiveInRowIndex(double[][] data, int row)
    {
        int minRowIndex = 0;
        double minInRow = data[row][0];
        double cap = 0.0;
        
        for (int i = 0; i < data[row].length; i++)
        {
            if ((data[row][i] < minInRow) && (data[row][i] > cap))
            {
                minInRow = data[row][i];
                minRowIndex = i;
            }
        }
        return minRowIndex;
    }

    /**
     * Returns the largest POSITIVE element of the selected column in the two dim array index (0=first column)
     * If a row in the two dim array doesn't have this column index, it is not an error, it does not participate in this method
     * @param data the two dim array
     * @param col the column index to find the largest POSITIVE element of (0=first column)
     * @return the largest POSITIVE element of the column
     */
    public static double getHighestPositiveInColumn(double[][] data, int col)
    {
        int maxColIndex = 0;
        double maxInCol = 0.0;
        double cap = 0.0;
        
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if ((data[i][col] > maxInCol) && (data[i][col] > cap))
                {
                    maxInCol = data[i][col];
                    maxColIndex = i;
                }
            } catch (Exception e)
            {
                continue;
            }
        }
        return maxInCol;
    }

    /**
     * Returns index of the largest POSITIVE element of the selected column in the two dim array index (0=first column)
     * If a row in the two dim array doesn't have this column index, it is not an error, it does not participate in this method
     * @param data the two dim array
     * @param col the column index to find the largest POSITIVE element of (0=first column)
     * @return index of the largest POSITIVE element of the column
     */
    public static int getHighestPositiveInColumnIndex(double[][] data, int col)
    {
        int maxColIndex = 0;
        double maxInCol = 0.0;
        double cap = 0.0;
        
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if ((data[i][col] > maxInCol) && (data[i][col] > cap))
                {
                    maxInCol = data[i][col];
                    maxColIndex = i;
                }
            } catch (Exception e)
            {
                continue;
            }
        }
        return maxColIndex;
    }

    /**
     * Returns the smallest POSITIVE element of the selected column in the two dim array index (0=first column)
     * If a row in the two dim array does not have this column index, it is not an error, it does not participate in this method
     * @param data the two dimensional array
     * @param col the column index to find the smallest POSITIVE element of (0=first column)
     * @return the smallest POSITIVE element of the column
     */
    public static double getLowestPositiveInColumn(double[][] data, int col)
    {
        int minColIndex = 0;
        double minInCol = Double.POSITIVE_INFINITY;
        double cap = 0.0;
        
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if ((data[i][col] < minInCol) && (data[i][col] > cap))
                {
                    minInCol = data[i][col];
                    minColIndex = i;
                }
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return minInCol;
    }

    /**
     * Returns the index of the smallest POSITIVE element of the selected column in the two dimensional array index (0=first column)
     * If a row in the two dimensional array does not have this column index, it is not an error, it does not participate in this method
     * @param data the two dim array
     * @param col the column index to find the smallest POSITIVE element of (0=first column)
     * @return the index of the smallest POSITIVE element in the column
     */
    public static int getLowestPositiveInColumnIndex(double[][] data, int col)
    {
        int minColIndex = 0;
        double minInCol = Double.POSITIVE_INFINITY;
        double cap = 0.0;
        
        for (int i = 0; i < data.length; i++)
        {
            try
            {
                if ((data[i][col] < minInCol) && (data[i][col] > cap))
                {
                    minInCol = data[i][col];
                    minColIndex = i;
                }
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return minColIndex;
    }
    
}
