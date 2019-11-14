//package default;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleTest {
	
	@Test
	public void testSimple() {
		assertTrue(false,"Error");
		assertTrue(false,"2nd Error");
		assertEquals(5.9,6.0,0.1);
		assertEquals(2,3,0.001);
	}

	
}
