/**
 * This class calculates and returns the holiday
 * bonus of each given store in a district,
 * as well as the total of all holiday bonuses.
 * 
 * CMSC - 203
 * 11/9/2019
 */
public class HolidayBonus {

	/**
	 * This method creates and returns an array of the bonus
	 * each store earns based on how much money they earned.
	 * @param arr A two dimensional array of doubles.
	 * @param high The bonus for the store that made the most sales.
	 * @param low The bonus for the store that made the least sales.
	 * @param other The bonus for all other stores.
	 * @return An array that holds the bonus each store earned.
	 */
	public static double[] calculateHolidayBonus(double[][] arr, 
							double high, double low, double other) {

		// Initialize the storeBonus array with the number of stores.
		double [] storeBonus = new double[arr.length];

		// Declare two doubles for the highest and lowest values in the array.
		double highest = TwoDimRaggedArrayUtility.getHighestInArray(arr);
		double lowest = TwoDimRaggedArrayUtility.getLowestInArray(arr);
		
		// Enter each store's bonus into the storeBonus array.
		for (int i = 0; i < arr.length; i++) {												// For loop 1
			// Initialize an array at the current element in the
			// storeBonus array.

			// Set the bonus for the current row = 0.
			double holidayBonus = 0;

			
			// Loop through the columns in the row.
			for (int j = 0; j < arr[i].length; j++) {										// For loop 2
				
				// Check to make sure a column exists at [i][j].
				if (j < arr[i].length) { 
					// Set highest equal to the highest value in the column j.
					highest = TwoDimRaggedArrayUtility.getHighestInColumn(arr, j);
					// Set lowest equal to the lowest value in the column j.
					lowest = TwoDimRaggedArrayUtility.getLowestInColumn(arr, j);
				}
				
				// Awards the largest bonus to the store with
				// the most sales.
				if (arr[i][j] == highest) {
					if (highest > 0)
						holidayBonus += high;

				}
				// Awards the smallest bonus to the store with
				// the least sales.
				else if (arr[i][j] == lowest) {
					// If the value in lowest is less than 0, no bonus
					// is awarded.
					if (lowest > 0)
						holidayBonus += low;
				}
				
				// Awards a standard bonus to all other stores.
				else {
					// If the value of the element is less than 0,
					// no bonus is awarded.
					if (arr[i][j] > 0)
						holidayBonus += other;
				}
			} // End for loop 2
			
			// Set the holiday bonus for the store.
			storeBonus[i] = holidayBonus;
		} /// End for loop 1
		
		return storeBonus;
	} // End method
	/**
	 * This method adds the bonus of each store together
	 * to get the total cost of all bonuses.
	 * @param arr A two dimensional array of doubles.
	 * @param high The bonus given to the highest earning store.
	 * @param low The bonus given to the lowest earning store.
	 * @param other The bonus given to all other stores.
	 * @return Returns the total cost of all store bonuses.
	 */
	public static double calculateTotalHolidayBonus(double[][] arr, 
								double high, double low, double other) {
		
		// Calculate the holiday bonus for each store.
		double [] holBonus = calculateHolidayBonus(arr, high, low, other);
		
		// Declare and initialize an accumulator to 0.
		double total = 0;
		
		// Add each store's bonus together.
		for (int i = 0; i < holBonus.length; i++) {
			total += holBonus[i];
		}
		// Return the total of all store bonuses.
		return total;		
	} // End of method
} // End of class
