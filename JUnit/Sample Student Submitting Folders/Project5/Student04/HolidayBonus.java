
/**
 * This class will calculate holiday bonuses for each store and calculates holiday bonuses of the total.
 * 
 *
 */
public class HolidayBonus 
{
	/**
	 * Calculates the holiday bonus for each store
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][] data,double high,double low,double other)
	{
		double[] bonus ;
		int ep=0;

		for (int a=0;a<data.length;a++)
		{
			if(data[a].length>ep)
				ep=data[a].length;
		}
		bonus=new double[data.length];
		for(int i=0;i<data.length;i++) 
		{
			double total=0.0;
			for(int j=0;j<data[i].length;j++)
			{
				if(data[i][j]==TwoDimRaggedArrayUtility.getHighestInColumn(data, j)&&data[i][j]>0)
					total+=high;
				else if(data[i][j]==TwoDimRaggedArrayUtility.getLowestInColumn(data,j)&&data[i][j]>0)
					total+=low;
				else if(data[i][j]<=0)
					total+=0;
				else 
					total+=other;
			}
			bonus[i]=total;
		}
		return bonus;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) 
	{
		int size=0;
		double total=0.0;

		size=HolidayBonus.calculateHolidayBonus(data,high,low,other).length;

		for (int i=0;i<size;i++)
		{
			total+=calculateHolidayBonus(data,high,low,other)[i];
		}
		return total;
	}
}


