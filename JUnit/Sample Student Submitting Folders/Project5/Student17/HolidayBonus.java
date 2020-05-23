public class HolidayBonus {
	
	public static double[] calculateHolidayBonus(double[][] data, double highest, double lowest, double other){
		double[] bonuses = new double[data.length];
		for (int row = 0; row < data.length; row++){
			for (int col = 0; col < data[row].length; col++){
				double categoryHigh = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double categoryLow = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				if(data[row][col] > 0){
					if(data[row][col] == categoryHigh){
						bonuses[row] = bonuses[row] + highest;
					}else if(data[row][col] == categoryLow){
						bonuses[row] = bonuses[row] + lowest;						
					}else{
						bonuses[row] = bonuses[row] + other;
					}
				}
			}
		}
		return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double highest, double lowest, double other){
		double[] bonuses = calculateHolidayBonus(data, highest, lowest, other);
		double total = 0.0;
		for (int i = 0; i < bonuses.length; i++){
			total += bonuses[i];
		}
		return total;
	}	
}