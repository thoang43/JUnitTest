
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TicketTest
{
	@Before
	public void setUp() throws Exception {
		ticket1 = new Ticket("Bob Brown",36, 25, true, false);
		ticket2 = new Ticket("Betty Boop",66,45,false, true);
		ticket3 = new Ticket("Edward Cullen",88,45);
	}

	@After
	public void tearDown() throws Exception {
		ticket1 = null;
		ticket2 = null;
		ticket3 = null;
	}


		
	@Test
	public void testGetName() {
		//test the getName
		assertTrue("Bob Brown".equals(ticket1.getName()));
		assertTrue("Betty Boop".equals(ticket2.getName()));
		assertTrue("Edward Cullen".equals(ticket3.getName()));

	}

	@Test
	public void testGetSpeed() {
		//test the getName
		assertTrue(36==ticket1.getSpeed());
		assertTrue(66==ticket2.getSpeed());
		assertTrue(88==ticket3.getSpeed());

	}
	
	@Test
	public void testGetSpeedLimit() {
		//test the getName
		assertTrue(25==ticket1.getSpeedLimit());
		assertTrue(45==ticket2.getSpeedLimit());
		assertTrue(45==ticket3.getSpeedLimit());

	}

	
@Test
	public void testGetSpeedLimit() {
		//test the getName
		assertTrue(25==ticket1.getSpeedLimit());
		assertTrue(45==ticket2.getSpeedLimit());
		assertTrue(45==ticket3.getSpeedLimit());

	}
	@Test
	public void testIsSchoolZone() {
		//test the getName
		assertTrue(ticket1.isSchoolZone()==true);
		assertTrue(ticket2.isSchoolZone()==false);
		assertTrue(ticket3.isSchoolZone()==false);

	}
	
	@Test
	public void testGetTicketType() {
		//test the getName
		assertTrue("PAYABLE".equals(ticket1.getTicketType()));
		assertTrue("PAYABLE".equals(ticket2.getTicketType()));
		assertTrue("MUST APPEAR".equals(ticket3.getTicketType()));

	}
	

		
}

