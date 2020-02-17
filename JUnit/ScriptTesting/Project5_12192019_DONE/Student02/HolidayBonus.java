public class HolidayBonus {
	//HolidayBonus method 
public static double[] calculateHolidayBonus(double [][] data, double high, double low, double other)
{
double[][] holidayBonusArr = new double[data.length][];
for (int i = 0; i < data.length; i++)
{
holidayBonusArr[i] = new double[data[i].length];
}
for (int i = 0, j = 0; i < holidayBonusArr.length; i++, j++)
{
double highIndex = TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
double lowIndex = TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
if (i < holidayBonusArr[j].length)
{
holidayBonusArr[(int) highIndex][i] = high;
holidayBonusArr[(int) lowIndex][i] = low;
if (j == highIndex || j == lowIndex)
continue;
else
{
holidayBonusArr[j][i] = other;
}
}
}
double[] holidayBonusPerStore = new double[data.length];
for (int i = 0; i < holidayBonusArr.length; i++)
{for (int j = 0; j < holidayBonusArr[i].length; j++)
{
holidayBonusPerStore[i] += holidayBonusArr[i][j];
}
}
return holidayBonusPerStore;
}

//HolidayBonus method
public static double calculateTotalHolidayBonus(double [][] data, double high, double low, double other)
{
double[][] holidayBonusArr = new double[data.length][];
for (int kk = 0; kk < data.length; kk++)
{
holidayBonusArr[kk] = new double[data[kk].length];
}
for (int kk = 0, aa = 0; kk < holidayBonusArr.length; kk++, aa++)
{
double highIndex = TwoDimRaggedArrayUtility.getHighestInColumn(data, kk);
double lowIndex = TwoDimRaggedArrayUtility.getLowestInColumn(data, kk);
if (kk < holidayBonusArr[aa].length)
{
holidayBonusArr[(int) highIndex][kk] = high;
holidayBonusArr[(int) lowIndex][kk] = low;
if (aa == highIndex || aa == lowIndex)
continue;
else
{
holidayBonusArr[aa][kk] = other;
}
}
}
double holidayTotal = 0.0;
for (int kk = 0; kk < holidayBonusArr.length; kk++)
{
for (int aa = 0; aa < holidayBonusArr[kk].length; aa++)
{
holidayTotal += holidayBonusArr[kk][aa];
}
}
return holidayTotal;
}
}