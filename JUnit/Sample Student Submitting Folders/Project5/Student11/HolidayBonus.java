/**
 * Class to calculate the holiday bonuses and totals
 * for the stores in a district
 * 
 *
 */
public class HolidayBonus {
	/**
	 * Method to calculate the holiday bonuses
	 * @param array 2D array to pass to method
	 * @param high Bonus if highest sales in category
	 * @param low Bonus if lowest sales in category
	 * @param other Bonus if neither highest or lowest
	 * @return bonusArray Array of bonuses
	 */
	public static double[] calculateHolidayBonus(double[][] array, double high, double low, double other) {
		double[] bonusArray = new double[6];
		int k =0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				
				if(array[i][j] < 0.0) {
					bonusArray[k] += 0.0;
				}
				else if(array[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(array, j)) {
					bonusArray[k] += high;
				}

				else if(array[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(array, j)) {
					bonusArray[k] += low;
				}
				else {
					bonusArray[k] += other;
				}
			}k++;
		}
		return bonusArray;
	}
	/**
	 * Method to calculate the total of the bonuses
	 * @param array 2D array to pass to method
	 * @param high Bonus if highest sales in category
	 * @param low Bonus if lowest sales in category
	 * @param other Bonus if neither highest or lowest
	 * @return totalHolidayBonus Total of the bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] array, double high, double low, double other) {
		double totalHolidayBonus = 0.0;
		double[] bonusArray = new double[6];
		int k = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				
				 if(array[i][j] < 0.0) {
					bonusArray[k] += 0.0;
				}
				else if(array[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(array, j)) {
					bonusArray[k] += high;
				}
				
				else if(array[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(array, j)) {
					bonusArray[k] += low;
				}
				else {
					bonusArray[k] += other;
				}
			}k++;
		}
		for(int i = 0; i < array.length; i++) {
			totalHolidayBonus += bonusArray[i];
		}
		return totalHolidayBonus;
	}
}
