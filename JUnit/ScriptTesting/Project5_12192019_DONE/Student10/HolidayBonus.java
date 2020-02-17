
public class HolidayBonus {

	
	//Class Constructor
	
	public HolidayBonus(){
		
	}
	
	
	//Class Methods
	
	
	//calculateHolidayBonus method
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		double b[] = new double[data.length];
		
		
		
		for(int i = 0; i < data.length; i++) {
			
			double storeBonus = 0;
			
			for(int j = 0; j < data[i].length; j++) {
				
				int max;
				int min;
				
				
				double colBonus;
				
				max = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
				min = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
				
				
				if(data[i][j] <= 0) {
					
					colBonus = 0;
				}
				
				
				else if(max == i) {
					
					colBonus = high;
					
				}
				
				else if(min == i) {
					
					colBonus = low;
				}
			
				
				else {
					
					colBonus = other;
				}
				
				
				storeBonus += colBonus;
				
			}
			
			b[i] = storeBonus;
			
			//System.out.print(b[i]);
			
			//System.out.println();
		}
		
		return b;
		
	}
	
	//calculateTotalHolidayBonus
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double totalBonus = 0;
		
		
		for(int i = 0; i < data.length; i++) {
			
			double storeBonus = 0;
			
			for(int j = 0; j < data[i].length; j++) {
				
				int max;
				int min;
				
				
				double colBonus;
				
				max = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
				min = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
				
				
				if(data[i][j] <= 0) {
					
					colBonus = 0;
				}
				
				
				else if(max == i) {
					
					colBonus = high;
					
				}
				
				else if(min == i) {
					
					colBonus = low;
				}
			
				
				else {
					
					colBonus = other;
				}
				
				
				storeBonus += colBonus;
		
			
			}
			
			totalBonus += storeBonus;
			
		}
		
		return totalBonus;
	}
}
