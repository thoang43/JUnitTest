/**HolidayBonus class
 * Purpose: Calculate holiday bonuses for high, low, and other performing stores
 * based on sales metrics calculated in TwoDimRaggedArrayUtility class
 * 
 */

public class HolidayBonus {

	//Instance variables
	private double[][] data;
	private double high;
	private double low;
	private double other;
	
	/**
	 * Default no-arg constructor - set instance variables to zero/null
	 */
	public HolidayBonus() {
		data=null;
		high=0;
		low=0;
		other=0;
	}
	
	/**
	 * Calculate holiday bonus amounts for stores based on sales
	 * @param data - 2D array of doubles representing store sales
	 * @param high - bonus amount for high performing stores
	 * @param low - bonus amount for low performing stores
	 * @param other - bonus amount for other performing stores
	 * @return array of doubles
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double highest=0;
		double lowest=0;
		double[] dub = new double[data.length];
		double sum=0;
		
		for (int i=0; i<data.length; i++) {
			for (int j=0; j<data[i].length; j++) {

				highest=TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
				lowest=TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
				if (data[i][j] >0) {
					if (data[i][j]==highest) {
						sum+=high;
					}
					else if (data[i][j]==lowest) {
						sum+=low;
					}
					else {
						sum+=other;
					} //Negative numbers not qualified to get a bonus
				}
				
			}
			dub[i]=sum;
			sum=0;
		}
		return dub;
	}
	
	/**
	 * Calculate total holiday bonuses each store accumulated
	 * @param data - 2D array of doubles representing store sales
	 * @param high - bonus amount for high performing stores
	 * @param low - bonus amount for low performing stores
	 * @param other - bonus amount for other performing stores
	 * @return double - total amount of bonuses
	 */
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = calculateHolidayBonus(data, high, low, other);
		double total =0.0;
		for (int i = 0; i < bonus.length; i++) {
			total += bonus[i];
		}
		return total;
	}
}
