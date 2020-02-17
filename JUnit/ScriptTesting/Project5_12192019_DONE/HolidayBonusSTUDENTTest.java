import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusSTUDENTTest {
	//create several (more than 2) data sets for testing. These data sets must be different
		//then the data sets in HolidayBonusTest
	double[][] testArrayA;
	double[][] testArrayB;
	File inputFile;
	@Before
	public void setUp() throws Exception {
		double[][] setUpArrayA = {{12500.25,34800.08,12312.34,58673.35,48738.43},{10992.48,91575.85,74857.45,18453.68},
		{42068.45,38109.65,19485.48,10593.57,-100.05,5000.89},{8400,19399.45,9500.11,74839.38,43919.09,28405.34},
		{-4500.45,36000.40,48259.21,46833.33},{9500.07,63754.34,-9500.75,24755.33,-148.24}};
		testArrayA = setUpArrayA;
		
		double[][] setUpArrayB = {{10500.25,34821.08,12312.34,58333.35,54438.43},{16992.48,93675.85,77897.45,18453.68},
				{42568.45,46109.65,19215.48,10593.57,-154.05,5123.89},{8443,19399.45,9500.11,74839.38,43919.09,28405.34},
				{-4690.45,36231.40,48259.21,46833.33},{9386.07,68574.34,-9375.75,24755.33,-169.24}};
		testArrayB = setUpArrayB;
		}
		
		
		

	@After
	public void tearDown() throws Exception {
		testArrayA = null;
	}

	
		/**
		 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */

		@Test
		public void testCalculateHolidayBonusSTUDENTA() {
			double[] arrayBonusA = HolidayBonus.calculateHolidayBonus(testArrayA, 5000, 1000, 2000);
			assertEquals(arrayBonusA[0],13000,0.1);
			assertEquals(arrayBonusA[1],14000,0.1);
			assertEquals(arrayBonusA[2],11000,0.1);
			assertEquals(arrayBonusA[3],17000,0.1);
			assertEquals(arrayBonusA[4],6000,0.1);
			assertEquals(arrayBonusA[5],6000,0.1);
			
			double[] arrayBonusB = HolidayBonus.calculateHolidayBonus(testArrayB, 5000, 1000, 2000);
			assertEquals(arrayBonusB[0],13000,0.1);
			assertEquals(arrayBonusB[1],14000,0.1);
			assertEquals(arrayBonusB[2],11000,0.1);
			assertEquals(arrayBonusB[3],17000,0.1);
			assertEquals(arrayBonusB[4],6000,0.1);
			assertEquals(arrayBonusB[5],6000,0.1);
		}
		

		/**
		 * Test calculateHolidayBonus method with a high of 1000, low of 250 and 500 as other
		 */

		@Test
		public void testCalculateHolidayBonusSTUDENTB() {
			double[] arrayBonusA = HolidayBonus.calculateHolidayBonus(testArrayA, 1000, 250, 500);
			assertEquals(arrayBonusA[0],3000,0.1);
			assertEquals(arrayBonusA[1],3000,0.1);
			assertEquals(arrayBonusA[2],2500,0.1);
			assertEquals(arrayBonusA[3],3750,0.1);
			assertEquals(arrayBonusA[4],1500,0.1);
			assertEquals(arrayBonusA[5],1500,0.1);
			
			double[] arrayBonusB = HolidayBonus.calculateHolidayBonus(testArrayB, 1000, 250, 500);
			assertEquals(arrayBonusB[0],3000,0.1);
			assertEquals(arrayBonusB[1],3000,0.1);
			assertEquals(arrayBonusB[2],2500,0.1);
			assertEquals(arrayBonusB[3],3750,0.1);
			assertEquals(arrayBonusB[4],1500,0.1);
			assertEquals(arrayBonusB[5],1500,0.1);
			
		}

		/**
		 * Test calculateTotalHolidayBonus method with a high of 5000, low of 1000 and 2000 as other
		 */
	@Test
	public void testCalculateTotalHolidayBonusA() {
		double totalA = HolidayBonus.calculateTotalHolidayBonus(testArrayA, 5000, 1000, 2000);
		assertEquals(totalA,67000.00,0.1);
		double totalB = HolidayBonus.calculateTotalHolidayBonus(testArrayB, 5000, 1000, 2000);
		assertEquals(totalB,67000.00,0.1);
	}
	
	/** 
	 * Test calculateTotalHolidayBonus method with a high of 1000, low of 250 and 500 as other
	 */
	@Test
	public void testCalculateTotalHolidayBonusB() {
		double totalA = HolidayBonus.calculateTotalHolidayBonus(testArrayA, 1000, 250, 500);
		assertEquals(totalA,15250.00,0.1);
		double totalB = HolidayBonus.calculateTotalHolidayBonus(testArrayB, 1000, 250, 500);
		assertEquals(totalB,15250.00,0.1);
	}

}
