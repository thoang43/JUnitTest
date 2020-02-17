import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENTTest {
	//create several (more than 2) data sets for testing. These data sets must be different
	//then the data sets in TwoDimRaggedArrayUtilityTest
	double[][] arrayASet =  {{12500.25,34800.08,12312.34,58673.35,48738.43},{10992.48,91575.85,74857.45,18453.68},
			{42068.45,38109.65,19485.48,10593.57,-100.05,5000.89},{8400,19399.45,9500.11,74839.38,43919.09,28405.34},
			{-4500.45,36000.40,48259.21,46833.33},{9500.07,63754.34,-9500.75,24755.33,-148.24}};
	double[][] arrayBSet =  {{10500.25,34821.08,12312.34,58333.35,54438.43},{16992.48,93675.85,77897.45,18453.68},
			{42568.45,46109.65,19215.48,10593.57,-154.05,5123.89},{8443,19399.45,9500.11,74839.38,43919.09,28405.34},
			{-4690.45,36231.40,48259.21,46833.33},{9386.07,68574.34,-9375.75,24755.33,-169.24}};
	double[][] arrayATest;
	double[][] arrayBTest;
	
	@Before
	public void setUp() throws Exception {
		File inputFile1 = new File("firstTest.txt");
		TwoDimRaggedArrayUtility.writeToFile(arrayASet, inputFile1);
		File inputFile2 = new File("SecondTest.txt");
		TwoDimRaggedArrayUtility.writeToFile(arrayBSet, inputFile2);
		
		
		arrayATest = TwoDimRaggedArrayUtility.readFile(inputFile1);
		arrayBTest = TwoDimRaggedArrayUtility.readFile(inputFile2);
	}

	@After
	public void tearDown() throws Exception {
		arrayATest = null;
		arrayBTest = null;
	}

	/**
	 * Test getTotal method
	 * Returns the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotalSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getTotal(arrayATest),877478.51,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getTotal(arrayBTest),905192.51,0.1);
	}

	/**
	 * Test getAverage method
	 * Returns the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverageSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getAverage(arrayATest),29249.28,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getAverage(arrayBTest),30173.08,0.1);
	}

	
	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotalSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(arrayATest, 0),167024.45,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(arrayATest, 1),195879.46,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(arrayBTest, 0),170405.450,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(arrayBTest, 1),207019.46,0.1);
	}
	

	/**
	 * Test getColumnTotal method
	 * Returns the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotalSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(arrayATest, 0),78960.80,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(arrayATest, 1),283639.77,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(arrayBTest, 0),83199.80,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(arrayBTest, 1),298811.77,0.1);
	}
	

	/**
	 * Test getHighestInRow method
	 * Returns the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(arrayATest, 3),74839.38,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(arrayATest, 0),58673.35,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(arrayBTest, 3),74839.38,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(arrayBTest, 0),58333.35,0.1);
	}

	/**
	 * Test getHighestInRowIndex method
	 * Returns the index of the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowIndexSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(arrayATest, 0),3,0);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(arrayATest, 1),1,0);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(arrayBTest, 0),3,0);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(arrayBTest, 1),1,0);
	}
	
	
	/**
	 * Test getLowestInColumn method
	 * Returns the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(arrayATest, 1),19399.45,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(arrayATest, 3),10593.57,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(arrayBTest, 1),19399.45,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(arrayBTest, 3),10593.57,0.1);
	}

	/**
	 * Test getLowestInColumnIndex method
	 * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndexSTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(arrayATest, 1),3,0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(arrayATest, 3),2,0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(arrayBTest, 1),3,0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(arrayBTest, 3),2,0);
	}
	

	/**
	 * Test getLowestInArray method
	 * Returns the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArraySTUDENT() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInArray(arrayATest),-9500.75,0.1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInArray(arrayBTest),-9375.75,0.1);
	}
	
	
	
}
