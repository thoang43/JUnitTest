
/**
 * CMSC 203
 * 11/10/2019
 * This program takes in data from store sales and calculates the holiday bonuses
 * 
 */
public class HolidayBonus {
	
	private static TwoDimRaggedArrayUtility dimRag;
	
	/**
	 * Default Constructor
	 */
	public HolidayBonus() {
		
		dimRag = new TwoDimRaggedArrayUtility();
	}
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] result = new double[data.length];

		for(int i = 0; i < data[0].length; i++)
			calculateHighLowBonus(result, data, high, low, other, i);

		return result;
		
	}
	
	/**
	 * Calculates bonus based on high and low sales 
	 * @param result - bonus based on sales data
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @param column - category of sales
	 */
	public static void calculateHighLowBonus(double[] result, double[][] data, double high, double low, double other, int column) 
	{
		
		int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndexIgnoreNegative(data, column);
		int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, column);
		
		if(lowIndex == highIndex) {
			result[highIndex] += high;
			//System.out.println(lowIndex + " " + highIndex + " ");
		}
		else {
			result[lowIndex] += low;
			result[highIndex] += high;
		}
		for(int i=0;i<data.length;i++)
	    {
	           if(column <= data[i].length-1)
	           {               
	        	   if(i != highIndex && i != lowIndex) {
	        		   if(data[i][column] > 0)
	        			   result[i] += other;
	        	   }
	           }

	    }
		
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] result = new double[data.length];
		double total = 0;
		
		result = calculateHolidayBonus(data, high, low, other);

		for(int i=0; i<result.length; i++) {
			total += result[i];
		}
		
		return total;
	}
}