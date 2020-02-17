import java.io.File;
import javafx.stage.FileChooser;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the Holiday Bonus Calculations for Disney Retail District #5
 *
 * Bonuses are calculated based on how much each retail store sold in each category.
 * The retail store with the highest amount sold in a category will receive $5,000.
 * The retail store with the lowest amount sold in a category will receive $1,000.
 * All other retail stores in district #5 will receive $2,000.
 * If a retail store didn't sell anything in a category, or they have a negative sales amount, they are not eligible for any bonus.
 * If only one retail store sold items in a category, they are eligible to receive only the bonus of $5,000 for said category.
 *
 * 
 */
public class HolidayBonus extends java.lang.Object
{
    public static TwoDimRaggedArrayUtility rag;

    /**
     * Constructor = VOID
     */
    public HolidayBonus(){}

    /**
     * Calculates the holiday bonus for each store.
     * @param data the two dimensional array of store sales
     * @param high bonus for the highest store in a category
     * @param low bonus for the lowest store in a category
     * @param other bonus for all other stores in a category
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
    {

        Map<Integer, Double> bonusMap = new HashMap<>(); //key=storeIndex, val=TOTAL BONUS AMOUNT

        int rows = data.length;
        int maxColumns = HolidayBonus.getMaxColumnsPerRow(data);
        double[] array = new double[rows]; //array to return at end of method

        Map<Integer, Integer> categoryMap = HolidayBonus.getMapCategories(data);
        Map<Integer, Integer> emptyMap = HolidayBonus.getMapEmpties(data);
        Map<Integer, Integer> negMap = HolidayBonus.getMapNegatives(data);
        Map<Integer, Integer> maxMap = HolidayBonus.getMapMaxPositive(data);
        Map<Integer, Integer> minMap = HolidayBonus.getMapMinPositive(data);
        Map<Integer, Integer> medMap = HolidayBonus.getMapMedium(data, minMap, maxMap, emptyMap, negMap);

        //iterate through each map. #med sales is determined by the other maps.
        //bonus as follows: #maxSales*high, #medSales*other, #minSales*low, #zeroSales*0
        Iterator<Map.Entry<Integer, Integer>> maxIt = maxMap.entrySet().iterator();
        
        while (maxIt.hasNext())
        {
            Map.Entry<Integer, Integer> entry = maxIt.next();
            int storeIndex = entry.getKey();
            int numMax = entry.getValue();        
            
            if (bonusMap.containsKey(storeIndex))
            {
                double current = bonusMap.get(storeIndex);
                double toAdd = high * numMax;
                bonusMap.replace(storeIndex, current+toAdd);
            }
            else
            {
                double toPut = high * numMax;
                bonusMap.put(storeIndex, toPut);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> minIt = minMap.entrySet().iterator();
        
        while (minIt.hasNext())
        {
            Map.Entry<Integer, Integer> entry = minIt.next();
            int storeIndex = entry.getKey();
            int numMin = entry.getValue();
            
            if (bonusMap.containsKey(storeIndex))
            {
                double current = bonusMap.get(storeIndex);
                double toAdd = low*  numMin;
                bonusMap.replace(storeIndex, current+toAdd);
            }
            else
            {
                double toPut = low * numMin;
                bonusMap.put(storeIndex, toPut);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> medIt = medMap.entrySet().iterator();
        
        while (medIt.hasNext())
        {
            Map.Entry<Integer, Integer> entry = medIt.next();
            int storeIndex = entry.getKey();
            int numMed = entry.getValue();
            
            if (bonusMap.containsKey(storeIndex))
            {
                double current = bonusMap.get(storeIndex);
                double toAdd = numMed * other;
                bonusMap.replace(storeIndex, current + toAdd);
            }
            else
            {
                double toPut = other * numMed;
                bonusMap.put(storeIndex, toPut);
            }
        }

        //FINALLY: put bonus values into array to return!
        Iterator<Map.Entry<Integer, Double>> it = bonusMap.entrySet().iterator();
        
        while (it.hasNext())
        {
            Map.Entry<Integer, Double> entry = it.next();
            int storeIndex = entry.getKey();
            double bonus = entry.getValue();
            array[storeIndex] = bonus;
        }

        return array;
    }

    /**
     * Calculates the total holiday bonuses
     * @param data the two dimensional array of store sales
     * @param high bonus for the highest store in a category
     * @param low bonus for the lowest store in a category
     * @param other bonus for all other stores in a category
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
    {
        double total = 0;
        double[] bonuses = HolidayBonus.calculateHolidayBonus(data, high, low, other);
        for (int i = 0; i < bonuses.length; i++)
        {
            total += bonuses[i];
        }
        return total;
    }

    /****************************************************************************************************************************
     * CUSTOM ADDED METHODS FOR HOLIDAYBONUS.JAVA (in hopes to increase readability & decrease code repeating)
     ****************************************************************************************************************************/

    /**
     * Returns the highest number of columns in a row
     * @param data a two dim array
     * @return int value showing the max number of columns per row
     */
    public static int getMaxColumnsPerRow(double[][] data)
    {
        HashMap<Integer, Integer> columnsMap = new HashMap<>();
        int rows = data.length;
        
        for (int row = 0; row < rows; row++)
        {
            columnsMap.put(row, data[row].length);
        }
        
        int maxColumns = 0;
        int maxIndex = 0;
        
        Iterator<Map.Entry<Integer, Integer>> it = columnsMap.entrySet().iterator();
        
        while (it.hasNext())
        {
            Map.Entry<Integer, Integer> entry = it.next();
            int numColumns = entry.getValue();
            
            if (numColumns > maxColumns)
            {
                maxColumns = numColumns;
                maxIndex = entry.getKey();
            }
        }
        return maxColumns;
    }

    /**
     * Returns HashMap containing the number of columns each row contains
     * @param data two dim array
     * @return HashMap counting number of columns each row contains (key=row, val=number of columns)
     */
    public static HashMap<Integer, Integer> getMapCategories(double[][] data)
    {
        HashMap<Integer, Integer> toReturn = new HashMap<>();
        int rows = data.length;
        
        for (int row = 0; row < rows; row++)
        {
            toReturn.put(row, data[row].length);
        }
        return toReturn;
    }

    /**
     * Returns a HashMap containing the number of blank doubles each row contains
     * @param data two dim array
     * @return HashMap counting the number of blank values per row(key=row index, val=number of empty doubles)
     */
    public static HashMap<Integer, Integer> getMapEmpties(double[][] data)
    {
        HashMap<Integer, Integer> toReturn = new HashMap<>();
        HashMap<Integer, Integer> categories = HolidayBonus.getMapCategories(data);
        int maxColumns = 0;
        int maxIndex = 0;
        Iterator<Map.Entry<Integer, Integer>> it = categories.entrySet().iterator();
        
        while (it.hasNext())
        {
            Map.Entry<Integer, Integer> entry = it.next();
            int numCols = entry.getValue();
            
            if (numCols > maxColumns)
            {
                maxColumns = numCols;
                maxIndex = entry.getKey();
            }
        }
        for (int row = 0; row < data.length; row++)
        {
            toReturn.put(row, maxColumns - data[row].length);
        }
        return toReturn;
    }

    /**
     * Returns a list containing indices of negative numbers
     * Indices represented in string format.
     * @param data the two dimensional array to seek
     * @return a list of index values showing negative doubles.
     */
    public static ArrayList<String> getNegativesList (double[][] data)
    {
        double zero = 0.0;
        int counter = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j<  data[i].length; j++)
            {
                if (data[i][j] < zero)
                {
                    String toAdd = i + ":"+j;
                    list.add(counter, toAdd);
                    counter++;
                }
            }
        }
        return list;
    }

    /**
     * Translates the results from getNegativesList method
     * @param list an array list of string coordinates
     * @return a hashmap counting the number of negative doubles in each row (key=row, val=num negatives)
     */
    public static HashMap<Integer, Integer> translateNegativeList(ArrayList<String> list)
    {
        HashMap<Integer, Integer> negMap = new HashMap<>();
        
        for (String n : list)
        {
            String[] coordinate = n.split(":");
            int row = Integer.parseInt(coordinate[0]);
            int column = Integer.parseInt(coordinate[1]);
           
            if (negMap.containsKey(row))
            {
                int current = negMap.get(row);
                negMap.replace(row, current + 1);
            }
            else
            {
                negMap.put(row, 1);
            }
        }
        return negMap;
    }

    /**
     * Uses above methods to return a hashmap containing the number of negative values in each row
     * @param data two dim array
     * @return HashMap containing the number of negative values in each row (key=row, val=# of negatives)
     */
    public static HashMap<Integer, Integer> getMapNegatives(double[][] data)
    {
        ArrayList<String> listNeg = HolidayBonus.getNegativesList(data);
        HashMap<Integer, Integer> toReturn = HolidayBonus.translateNegativeList(listNeg);
        
        return toReturn;
    }

    /**
     * Returns a HashMap containing the number of max columns for each row
     * @param data a two dim array
     * @return a HashMap counting the number of max values in each row (key=row, val=number of max values)
     */
    public static HashMap<Integer, Integer> getMapMaxPositive(double[][] data)
    {
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        int maxColumns = HolidayBonus.getMaxColumnsPerRow(data);
        
        for (int c = 0; c < maxColumns; c++)
        {
            int highestIndex = rag.getHighestPositiveInColumnIndex(data, c);
            int lowestIndex = rag.getLowestPositiveInColumnIndex(data, c);
            
            if (maxMap.containsKey(highestIndex))
            {
                int current = maxMap.get(highestIndex);
                maxMap.replace(highestIndex, current + 1);
            }
            else
            {
                maxMap.put(highestIndex, 1);
            }
        }
        return maxMap;
    }

    /**
     * Returns a HashMap containing the number of min columns for each row
     * @param data a two dim array
     * @return a HashMap couting the number of min values in each row (key=row, val=#of mins)
     */
    public static HashMap<Integer, Integer> getMapMinPositive(double[][] data)
    {
        int maxColumns = HolidayBonus.getMaxColumnsPerRow(data);
        HashMap<Integer, Integer> minMap = new HashMap<>();
        
        for (int c = 0; c < maxColumns; c++)
        {
            int highestIndex = rag.getHighestPositiveInColumnIndex(data, c);
            int lowestIndex = rag.getLowestPositiveInColumnIndex(data, c);
            
            if (!(lowestIndex == highestIndex))
            {
                if (minMap.containsKey(lowestIndex))
                {
                    int current = minMap.get(lowestIndex);
                    minMap.replace(lowestIndex, current + 1);
                }
                
                else
                {
                    minMap.put(lowestIndex, 1);
                }
            }
            else
            {
                //do nothing
            }
        }
        return minMap;
    }

    /**
     * Returns a HashMap containing the number of medium sales for each row
     * @param data a two dim array
     * @return a HashMap counting the number of medium values in each row (key=row, val=#meds)
     */
    public static HashMap<Integer, Integer> getMapMedium(double[][] data, 
    Map<Integer, Integer> minMap,
    Map<Integer, Integer> maxMap,
    Map<Integer, Integer> emptyMap,
    Map<Integer, Integer> negMap)
    {
        HashMap<Integer, Integer> medMap = new HashMap<>();
        int maxColumns = HolidayBonus.getMaxColumnsPerRow(data);
        int rows = data.length;
        
        for (int r = 0; r < rows; r++)
        {
            int min = 0;
            int max = 0;
            int empty = 0;
            int negatives = 0;
            
            if (minMap.containsKey(r))
                min = minMap.get(r);
            
            if (maxMap.containsKey(r))
                max = maxMap.get(r);
            
            if (emptyMap.containsKey(r))
                empty = emptyMap.get(r);
            
            if (negMap.containsKey(r))
                negatives = negMap.get(r);
            
            int trackedSales = min+max+empty+negatives;
            int mediums = maxColumns - trackedSales;
            medMap.put(r, mediums);
        }
        return medMap;
    }
}
