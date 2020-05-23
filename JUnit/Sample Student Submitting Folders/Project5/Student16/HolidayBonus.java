/** 
 * HolidayBonus class will contain static methods that will calculate holiday bonuses of 
 * each store, and the total holiday bonus.
 * 
 * 
 */

public class HolidayBonus {

	/**Calculate holiday bonuses of all stores based on data provided
	 * 
	 * @param data[][] the ragged double array that will contain sales data of all stores
	 * @param highBonus the bonus given to stores with highest sales in a category
	 * @param lowBonus the bonus given to stores with lowest sales in a category
	 * @param bonus the bonus given to stores that didn't have highest or lowest sales
	 * @return storeBonuses[] - the bonuses of all the stores
	 */
	public static double[] calculateHolidayBonus(double[][] data, double highBonus, double lowBonus,
												 double bonus)
	{
		//create double array that will hold the store bonuses
		double[] storeBonuses = new double[data.length];
		//create int to represent the largest row length possible
		int colMax = data[0].length;
		
		//for loop through rows of data
		for(int r = 1; r < data.length; r++)
		{
			if(colMax < data[r].length)
			{
				colMax = data[r].length;
			}
		}
		
		//find indexes of highest, and lowest values, then distribute bonuses appropriately
		for(int c = 0; c < colMax; c++)
		{
			int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, c);
			int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, c);
			
			for(int r = 0; r < data.length; r++)
			{
				if(data[r].length > c)
				{
					//give regular bonus to stores that didn't get highest or lowest
					if(r != highestIndex && r != lowestIndex && data[r][c] > 0)
					{
						storeBonuses[r] += bonus;
					}
					
					//skip next element if it was the highest or lowest index
					if((r+1) == highestIndex || (r+1) == lowestIndex)
					{
						r++;
					}
				}
			}
			//give bonus as long as sales are above 0
			if(data[highestIndex][c] > 0)
			storeBonuses[highestIndex] += highBonus;
			
			//give lowest bonus as long as highest bonus wasn't given 
			if(highestIndex != lowestIndex && data[lowestIndex][c] > 0)
				storeBonuses[lowestIndex] += lowBonus;
			
		}
		//return store bonuses array
		return storeBonuses;
	}
	
	/**Calculate the total holiday bonus given to all stores based on data provided
	 * 
	 * @param data[][] the ragged double array that will contain sales data of all stores
	 * @param highBonus the bonus given to stores with highest sales in a category
	 * @param lowBonus the bonus given to stores with lowest sales in a category
	 * @param bonus the bonus given to stores that didn't have highest or lowest sales
	 * @return total - the total holiday bonus
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double highBonus, double lowBonus,
												    double bonus)
	{
		//call method that'll calculate and return a array of bonuses
		double[] storeBonuses = calculateHolidayBonus(data, highBonus, lowBonus, bonus);
		//create double to represent total
		double total = 0;
		
		//for loop through the array, and add to total each element
		for(int x = 0; x < storeBonuses.length; x++)
		{
			total += storeBonuses[x];
		}
		
		//return total
		return total;
	}
}
