
/**
 * This class will calculate holiday bonuses for each store and calculates
 * holiday bonuses of the total.
 * 
 * 
 *
 */
public class HolidayBonus {
	/**
	 * Calculates the holiday bonus for each store
	 * 
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus;
		int a = 0;

		for (int x = 0; x < data.length; x++) {
			if (data[x].length > a)
				a = data[x].length;
		}
		bonus = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			double amount = 0.0;
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j) && data[i][j] > 0)
					amount += high;
				else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j) && data[i][j] > 0)
					amount += low;
				else if (data[i][j] <= 0)
					amount += 0;
				else
					amount += other;
			}
			bonus[i] = amount;
		}
		return bonus;
	}

	/**
	 * Calculates the total holiday bonuses
	 * 
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		int size = 0;
		double amount = 0.0;

		size = HolidayBonus.calculateHolidayBonus(data, high, low, other).length;

		for (int i = 0; i < size; i++) {
			amount += calculateHolidayBonus(data, high, low, other)[i];
		}
		return amount;
	}
}
