/**
 * 
 * Utility class used to calculate Holiday Bonuses and their totals.
 * 
 * 
 *
 */
public class HolidayBonus {
	
	/**
	 * Calculates holiday bonus for each store
	 * 
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] bonuses = new double[data.length];
		
		for (int row = 0; row < data.length; row++) {
			
			double totalStoreBonus = 0.0;
			
			for (int col = 0; col < data[row].length; col++) {
				
				if (data[row][col] > 0) {
					
					if 	(row == TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col)) {
							
							totalStoreBonus += high;
						}
						else if (row == TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col)) {
							
							totalStoreBonus += low;
						}
						else {
							
							totalStoreBonus += other;
						}
				}
			}
			
			bonuses[row] = totalStoreBonus;
		}
		
		return bonuses;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * 
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] bonuses = new double[data.length];
		double totalBonuses = 0;
		
		bonuses = calculateHolidayBonus(data, high, low, other);
		
		for (int i = 0; i < bonuses.length; i++) {
			
			totalBonuses += bonuses[i];
		}
			
		return totalBonuses;
	}
}