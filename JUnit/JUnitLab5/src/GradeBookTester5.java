import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	private GradeBook gradeBook1;
	private GradeBook gradeBook2;
	
	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		
		gradeBook1.addScore(95);
		gradeBook1.addScore(80);
		gradeBook1.addScore(75);
		
		gradeBook2.addScore(98);
		gradeBook2.addScore(72);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook1 = null;
		gradeBook2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(gradeBook1.toString().equals("95.0 80.0 75.0"));
		assertTrue(gradeBook2.toString().equals("98.0 72.0"));
		assertEquals(gradeBook1.getScoresSize(),3,0.001);
		assertEquals(gradeBook2.getScoresSize(),2,0.001);
	}

	@Test
	void testSum() {
		assertEquals(gradeBook1.sum(),250,0.001);
		assertEquals(gradeBook2.sum(),170,0.001);
	}

	@Test
	void testMinimum() {
		assertEquals(gradeBook1.minimum(),75,0.001);
		assertEquals(gradeBook2.minimum(),72,0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(gradeBook1.finalScore(),175,0.001);
		assertEquals(gradeBook2.finalScore(),98,0.001);
	}

	@Test
	void testGetScoresSize() {
		assertEquals(gradeBook1.getScoresSize(),3,0.001);
		assertEquals(gradeBook2.getScoresSize(),2,0.001);
	}

	@Test
	void testToString() {
		assertTrue(gradeBook1.toString().equals("95.0 80.0 75.0"));
		assertTrue(gradeBook2.toString().equals("98.0 72.0"));
	}

}
