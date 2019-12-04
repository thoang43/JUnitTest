
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookPrivateTest {
	private GradeBook gradeBook1;
	private GradeBook gradeBook2;
	
	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		
		
		gradeBook1.addScore(95);
		gradeBook1.addScore(80);
		gradeBook1.addScore(75);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook1 = null;

	}

	@Test
	void testAddScore() {
		assertTrue(gradeBook1.toString().equals("95.0 80.0 75.0"));

		assertEquals(gradeBook1.getScoresSize(),3,0.001);

	}

	@Test
	void testSum() {
		//Change
		assertEquals(gradeBook1.sum(), 1000,0.001);
		assertEquals(gradeBook2.sum(),170,0.001);
	}

	@Test
	void testMinimum() {
		//75
		assertEquals(gradeBook1.minimum(),100,0.001);
		
	}

	@Test
	void testFinalScore() {
		assertEquals(gradeBook1.finalScore(),175,0.001);

	}

	@Test
	void testGetScoresSize() {
		assertEquals(gradeBook1.getScoresSize(),3,0.001);
	
	}

	@Test
	void testToString() {
		assertTrue(gradeBook1.toString().equals("95.0 80.0 75.0"));

	}

}
