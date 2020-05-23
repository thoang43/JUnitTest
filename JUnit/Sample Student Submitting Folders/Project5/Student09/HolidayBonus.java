
/**
 * Calculate holiday bonuses that represent the sales for each
 * store in their respective category
 * Calculates store with highest, lowest, and other sales amount in their category
 * 
 * 
 *
 */
public class HolidayBonus {

  /**
   * Calculates the holiday bonus for each store
   * 
   * @param data the two dimensional array of store sales
   * @param low bonus for the lowest store in category
   * @param high bonus for the highest store in category
   * @param other bonus for all other stores in category
   * @return array of the bonus for each store
   */
  public static double[] calculateHolidayBonus(double[][] data, double high, double low,
      double other) {
    double[] bonus = new double[data.length];
    
    //max number of categories
    int maxC = 0;
    for (int i = 0;i < data.length;i++) {
      if (maxC < data[i].length) {
        maxC = data[i].length;
      }
    }
    
    for (int j = 0;j < maxC;j++) {
      // bonus for high and low
      int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
      int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
      
      // only positive sale numbers get high bonus
      if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0) {  
        bonus[highBonusIndex] += high;
      }
      
      // only positive and non high get low bonus
      if (TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 && highBonusIndex!=lowBonusIndex ) {
        bonus[lowBonusIndex] += low;
      }
      
      // other bonus for category outside of high and low
      for (int i = 0;i < data.length;i++) {
        if (j >= data[i].length || i==highBonusIndex || i==lowBonusIndex || data[i][j] <= 0) {
          continue;
        } else {
          bonus[i] += other;
        } 
        System.out.println();
      }
    }   
    return bonus;
  }

  /**
   * Calculates the total holiday bonuses
   *
   *
   * @param data two dimensional array of store sales
   *
   * @param high bonus for highest store in category
   *
   * @param low bonus for lowest store in category
   *
   *
   * @param other bonus for other stores in category
   *
   *
   * @return the total of all holiday bonuses
   */
  public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
      double other) {
    
    double[] bonusArray = calculateHolidayBonus(data, high, low, other);
    double totalHB = 0;
    
    for (double bonus:bonusArray) {
      totalHB+=bonus;
    }
    return totalHB;
  }
}
