package assignment5;

/**
 * A class to calculate the Holiday Bonuses for stores in a sales district
 * 
 *
 */

public class HolidayBonus {
	
	/**		
	 * Calculate holiday bonus for each store in district
	 * @param arr a two-dimensional ragged array of doubles
	 * @param bonusHigh the bonus amount for the store with the highest sales in a category
	 * @param bonusLow the bonus amount for the store with the lowest sales in a category 
	 * @param bonusOther bonus amount for all other stores
	 * @return an array of doubles which represents the holiday bonuses for each of the stores in the district
	 */
	public static double[] calculateHolidayBonus (double[][] arr, double bonusHigh, double bonusLow, double bonusOther) {
//		Double[] arr2 = new double[rows of arr]
//		for each element in arr2
//			initialize each element in arr2 to 0
//		
//		int maxRowLength = length of first row in arr
//		for each row in arr
//			if current row's length is greater than maxRowLength, then maxRowLength = current row's length
//		
//		For each column in arr
//			double High = highestInColumn(arr, current column)
//			double Low = lowestInColumn(arr, current column)
//			for each row in current column
//				try
//					if current element is greater than 0
//						if arr has only 1 row
//							arr2[current row] += bonusHigh
//						else if arr has 2 rows
//							if arr[current row][current column] == high, then arr2[current row] += bonusHigh
//							else arr2[current row] += bonusLow
//					else (arr2 has more than 2 rows)
//						If arr[current row][current column] == high, then Arr2[current row] += bonushHigh
//						Else if arr[current row][current column] == low, then Arr2[current row] += bonusLow
//						Else Arr2[current row] += bonusOther
//			catch Exception, go to next row
//		Return arr2
		double[] arr2 = new double[arr.length];		
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 0;
		}
		
		int maxRowLength = arr[0].length;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length > maxRowLength) maxRowLength = arr[i].length;
		}
		
		for (int column = 0; column < maxRowLength; column++) {
			double high = TwoDimRaggedArrayUtility.getHighestInColumn(arr, column);
			double low = TwoDimRaggedArrayUtility.getLowestInColumn(arr, column);
			for (int row = 0; row < arr.length; row++) {
				try {
					if (arr[row][column] > 0){
						if (arr.length == 1) {
							arr2[row] += bonusHigh;
						}
						else if (arr.length == 2) {
							if (arr[row][column] == high) arr2[row] += bonusHigh;	
							else arr2[row] += bonusLow;
								
						}
						else {
							if (arr[row][column] == high) arr2[row] += bonusHigh;
							else if (arr[row][column] == low) arr2[row] += bonusLow;
							else arr2[row] += bonusOther;
						}
					}
				} catch (Exception e) {
					
				} 
			}
		} 
		return arr2;
	}
	
	

	/**
	 * calculate total holiday bonus of all stores in district
	 * @param arr a two-dimensional ragged array of doubles
	 * @param bonusHigh the bonus amount for the store with the highest sales in a category
	 * @param bonusLow the bonus amount for the store with the lowest sales in a category 
	 * @param bonusOther bonus amount for all other stores
	 * @return a double which represents the holiday bonuses for all of the stores in the district
	 */
	public static double calculateTotalHolidayBonus (double[][] arr, double bonusHigh, double bonusLow, double bonusOther) {
//		Double total = 0
//		For each column in arr
//			double high = highestInColumn(arr, current column)
//			double low = lowestInColumn(arr, current column)
//			If arr[current row][current column] != null
//				If arr[current row][current column] == high
//					total += bonushHigh
//				Else if arr[current row][current column] == low && > 0
//					total += bonusLow
//				Else if arr[current row][current column] > 0
//					total += bonusOther
		
//		Return total
		double[] arr2 = calculateHolidayBonus(arr, bonusHigh, bonusLow, bonusOther);
		double total = 0;
		for (int i = 0; i < arr2.length; i++) {
			total += arr2[i];
		}
		return total;
//		int maxRow = 0;
//		
//		for (int row = 0; row < arr.length; row++) {
//			if (arr[row].length > arr[maxRow].length) maxRow = row;
//		}
//		for (int column = 0; column < arr[maxRow].length; column++) {
//			double high = TwoDimRaggedArrayUtility.getHighestInColumn(arr, column);
//			double low = TwoDimRaggedArrayUtility.getLowestInColumn(arr, column);
//			for (int row = 0; row < arr.length; row++) {
//				try {
//					if (arr[row][column] == high) total+= bonusHigh;
//					else if (arr[row][column] == low && arr[row][column] > 0) total+= bonusLow;
//					else if (arr[row][column] > 0) total+= bonusOther;
//				}catch (Exception e) {
//				
//				} 
//			} 
//		} 		 
//		return total;
	}

}
