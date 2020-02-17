package _solutionF2018;

/**
 * 
 *  
 *
 */
public class HolidayBonus {
	
	/**Constructor for holiday bonuses
	 * 
	 */
	HolidayBonus(){
	
	}
	
	
	/**
	 * 
	 * @param data Array holding the store data 
	 * @param high Bonus for the store with the highest amount of sales 
	 * @param low Bonus for the store with the lowest amount of sales 
	 * @param other Bonus for the stores that are neither the lowest or highest 
	 * @return Returns the array which holds in the bonuses for the store 
	 */
	public static double []calculateHolidayBonus(double [][]data, double high, double low, double other){
		int storeNums=data.length;
		//Create Array that holds the bonuses for each store with a size of the amount of stores
		double[]holidayBonus=new double[storeNums];
		
		for(int rows=0;rows<data.length;rows++) { //Finds the amount of rows 
			for(int col=0;col<data[rows].length;col++) {
				double highestSales=TwoDimRaggedArrayUtility.getHighestInColumn(data,col); //Set a variable to the highest element in the column 
				double lowestSales=TwoDimRaggedArrayUtility.getLowestInColumn(data, col); //Sets a variable to the lowest element in the column 
				
				if(data[rows][col]>0) { //If the current element is greater than zero it can be given a bonus which then is distributed below 
					if(data[rows][col]==highestSales) { // Tests to see if the element is equal to the element with the highest element 
						holidayBonus[rows]+=high; //Adds the element to the and bonus to the array 
					}
					else if(data[rows][col]==lowestSales) { //Checks to see if the element is equal to the lowest in the column
						holidayBonus[rows]+=low; //Adds the lowest bonus to the element 
					}
					else {
						holidayBonus[rows]+=other; // Adds the other bonus to the other stores 
					}
				}
			}
		}
		
		return holidayBonus;
	}
		
		
		
		
		
		
		
		
		
	
	
	/** Takes all the elements bonuses and then adds them together 
	 * 
	 * @param data Array being passed in 
	 * @param high Highest store bonus
	 * @param low Lowest store bonus 
	 * @param other Other store bonuses
	 * @return Returns the total amount of bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][]data,double high,double low,double other) {
	
		
		int numStores=data.length; //The amount of stores 
		
		double bonus[]=HolidayBonus.calculateHolidayBonus(data, high, low, other); //Call the calculate bonus method 
		double totalHolidayBonus=0;
		for(int i=0;i<numStores;i++) { //For loop to look through the array of bonuses 
			totalHolidayBonus+=bonus[i]; //Adds each bonus one by one 
		}
		return totalHolidayBonus;
	}
	
	
	
}
