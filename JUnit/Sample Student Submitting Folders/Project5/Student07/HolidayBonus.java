
public class HolidayBonus {
	
	/**
	 * 
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) 
	{
		double[] bonus = new double[data.length];
		
		for (int i = 0; i < 7; i++)
		{
			int highInColumnIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			int lowInColumnIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			
			for (int j = 0; j < bonus.length; j++)
			{
				if (highInColumnIndex == j)
					bonus[j] += high;
				else if (lowInColumnIndex == j && data[j][i] > 0)
					bonus[j] += low;
				else if (lowInColumnIndex == j && data[j][i] <= 0)
					bonus[j] += 0.0;
				else
					try {
						if (data[j][i] > 0)
							bonus[j] += other;
						else
							bonus[j] += 0.0;
					}
					catch (ArrayIndexOutOfBoundsException e) {
						bonus[j] += 0.0;
					}
			}
		}
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) 
	{
		double[] bonusArray =  calculateHolidayBonus(data, high, low, other);
		
		double bonusesTotal = 0.0;
		
		for (int i = 0; i < data.length; i++)
		{
			bonusesTotal += bonusArray[i];
		}
		
		return bonusesTotal;
	}
}
