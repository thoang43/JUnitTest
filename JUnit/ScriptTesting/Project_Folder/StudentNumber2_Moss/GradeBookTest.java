import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	private GradeBook gradeBook1;
	private GradeBook gradeBook2;
	
	@Before
	public void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		
		gradeBook1.addScore(95);
		gradeBook1.addScore(80);
		gradeBook1.addScore(75);
		
		gradeBook2.addScore(98);
		gradeBook2.addScore(72);
		
	}

	@After
	public void tearDown() throws Exception {
		gradeBook1 = null;
		gradeBook2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(gradeBook1.toString().equals("95.0 80.0 75.0"));
		assertTrue(gradeBook2.toString().equals("98.0 72.0"));
		assertEquals(gradeBook1.getScoresSize(),3,0.001);
		assertEquals(gradeBook2.getScoresSize(),2,0.001);
	}

	@Test
	public void testSum() {
		assertEquals(gradeBook1.sum(),250,0.001);
		assertEquals(gradeBook2.sum(),170,0.001);
	}

	@Test
	public void testMinimum() {
		//75 to 100
		assertEquals(gradeBook1.minimum(),100,0.001);
		assertEquals(gradeBook2.minimum(),72,0.001);
	}

	@Test
	public void testFinalScore() {
		//175 to 200
		assertEquals(gradeBook1.finalScore(),200,0.001);
		assertEquals(gradeBook2.finalScore(),98,0.001);
	}

	@Test
	public void testGetScoresSize() {
		assertEquals(gradeBook1.getScoresSize(),3,0.001);
		assertEquals(gradeBook2.getScoresSize(),2,0.001);
	}

	@Test
	public void testToString() {
		assertTrue(gradeBook1.toString().equals("95.0 80.0 75.0"));
		assertTrue(gradeBook2.toString().equals("98.0 72.0"));
	}

}
