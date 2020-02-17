package _solution;
/*
 * 
 * CMSC 203
 * 9/27/2019
 */

import java.util.Random;

/**
 * This is a class that models a speeding ticket. It has methods
 * to store driver information, calculate a fine, determine 
 * if the driver needs to appear in court, and print a notice
 * that includes all of the relevant ticket information.
 * @author Nathan Nelson
 */


public class Ticket {

	// ******************* OBJECT FIELDS ******************
	private int speed;				// Holds driving speed
	private int speedLimit;			// Holds speed limit
	private int ticketNum;			// Holds number of ticket
	private String name;			// Holds driver name
	private String ticketType;		// Holds "PAYABLE" or "MUST APPEAR"
	private boolean school;			// Holds true/false depending on school zone status
	private boolean work;			// Holds true/false depending on work zone status
	
	// ******************** CONSTRUCTORS ******************
	/**
	 * This constructor accepts values for the name, 
	 * speed, and speed limit fields.
	 * @param n Holds the name of the driver.
	 * @param s Holds the speed the driver was driving.
	 * @param sL Holds the speed limit of the road.
	 */
	public Ticket(String n, int s, int sL)
	{
		name = n;
		speed = s;
		speedLimit = sL;
		school = false;
		work = false;
		
		// Determines the ticket type ("PAYABLE" OR "MUST APPEAR")
		ticketType = determineTicketType();
		
		// Generates a ticket number
		ticketNum = generateTicketNum();
		
	}
	/**
	 * This constructor accepts values for the name,
	 * speed, speed limit, school, and work fields.
	 * @param n Holds the name of the driver.
	 * @param s Holds the speed the driver was driving.
	 * @param sL Holds the speed limit of the road.
	 * @param sZ Holds the school zone status.
	 * @param wZ Holds the work zone status.
	 */
	public Ticket(String n, int s, int sL, boolean sZ, boolean wZ)
	{
		name = n;
		speed = s;
		speedLimit = sL;
		school = sZ;
		work = wZ;
		
		// Determines the ticket type ("PAYABLE" OR "MUST APPEAR")
		ticketType = determineTicketType();
		
		// Generates a ticket number
		ticketNum = generateTicketNum();
	}	
	
	// ********************** GETTERS *********************
	/**
	 * Returns the value stored in the name field.
	 * @return Returns the name of the driver.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the value stored in the speed field.
	 * @return Returns how fast the driver was going.
	 */
	public int getSpeed()
	{
		return speed;
	}
	/**
	 * Returns the value stored in the speedLimit field.
	 * @return Returns the speed limit of the road.
	 */
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	/**
	 * Returns the number stored in the ticketNum field.
	 * @return Returns the number of the ticket.
	 */
	public int getTicketNum()
	{
		return ticketNum;
	}
	/**
	 * Returns the value stored in the ticketType field.
	 * @return Returns either "PAYABLE" or "MUST APPEAR."
	 */
	public String getTicketType()
	{
		return ticketType;
	}
	/**
	 * Returns the value stored in the school field.
	 * @return Returns true or false depending on school zone status.
	 */
	public boolean isSchoolZone()
	{
		return school;
	}
	/**
	 * Returns the value stored in the work field.
	 * @return Returns true or false depending on the work zone status.
	 */
	public boolean isWorkZone()
	{
		return work;
	}
	
	// ********************** SETTERS **********************
	/**
	 * Stores the argument given into the name field.
	 * @param n Sets name equal to the argument passed to the method.
	 */
	public void setName(String n)
	{
		name = n;
	}
	/**
	 * Stores the argument given into the speed field.
	 * @param s Sets speed equal to the argument passed to the method.
	 */
	public void setSpeed(int s)
	{
		speed = s;
	}
	/**
	 * Stores the argument given into the speedLimit field.
	 * @param sL Sets speed limit equal to the argument passed to the method.
	 */
	public void setSpeedLimit(int sL)
	{
		speedLimit = sL;
	}
	/**
	 * Stores the argument given into the ticketNum field.
	 * @param tN Sets the ticket number equal to the argument passed to the method.
	 */
	public void setTicketNum(int tN)
	{
		ticketNum = tN;
	}
	/**
	 * Stores the argument given into the school field.
	 * @param sZ Sets the school zone equal to true or false.
	 */
	public void setSchoolZone(boolean sZ)
	{
		school = sZ;
	}
	/**
	 * Stores the argument given into the school field.
	 * @param wZ Sets the school zone equal to true or false.
	 */
	public void setWorkZone(boolean wZ)
	{
		work = wZ;
	}
	
	// ******************* PUBLIC METHODS ******************
	/**
	 * Calculates and returns the amount of the ticket fine
	 * @return Returns the fine as a double
	 */
	public double calculateFine()
	{
		double fine = 0.00;							// Holds the fine amount
		int s = speed;							// Speed the driver was going
		int sL = speedLimit;					// Speed limit of the road
		int speedOverLimit = s - sL;			// How much over the speed limit the driver was going
		
		// If speed limit is between 1 and 10 over the speed limit
		if (speedOverLimit > 0 && speedOverLimit <= 10)
		{
			// Set fine to $140.00
			fine = 140.00;
			
			// If ticket was in a school zone
			if (school == true)
			{
				fine = 200.00;
				if (school == true && work == true)
					fine = 250.00;

			}
			// If ticket was in a work zone
			else if (work == true)
			{
				// Set fine to $250.00
				fine = 250.00;
			}

		}
		else if (speedOverLimit > 10 && speedOverLimit <= 20)
		{
			// Set fine to $195.00
			fine = 195.00;
						
			// If ticket was in a school zone
			if (school == true)
			{
				fine = 300.00;
				
				// If work zone is also true
				if (school == true && work == true)
					fine = 350.00;
			}
			// If ticket was in a work zone
			else if (work == true)
			{
				// Set fine to $350.00
				fine = 350.00;
			}
		}
		else if (speedOverLimit > 20 && speedOverLimit <= 30)
		{
			// Set fine to $450.00
			fine = 450.00;
		}
		else if (speedOverLimit > 30 && speedOverLimit <= 40)
		{
			// Set fine to $495.00
			fine = 495.00;
		}
		else if (speedOverLimit > 40)
		{
			// Set fine to $600.00
			fine = 600.00;
		}
		
		return fine;
	}
	/**
	 * This method generates a notice for the driver,
	 * informing them of their ticket, its fine amount,
	 * the ticket number, and how long from now they have
	 * to pay it off.
	 * @return Returns a ticket notice.
	 */
	public String printNotice()
	{
		// Holds the text of the notice.
		String str;
		
		// Format first segment of the notice to include
		// name, fine, speed, and speed limit.
		str = String.format(
			"Department of Motor Vehicles\n"
			+ "Automated Traffic Enforcement\n\n\n"
			+ "Dear %s,"
			+ "\n\nPlease pay the following speeding fine of $%.2f"
			+ " to the DMV within 10 days of\nreceiving this notice" 
			+ " to avoid a driver's license suspension. You are being fined\n"  
			+ "for going %d MPH in a %d MPH ",
			name, calculateFine(), speed, speedLimit);
		
		// Format string based on school/work zone status.
		if (school == true && work == true)
			str = str + "school and work zone.\n\n";
		else if (school == true)
			str = str + "school zone.\n\n";
		else if (work == true)
			str = str + "work zone.\n\n"; 
		else
			str = str + "zone.\n\n";
		
		// Finish the notice.
		str = str + "Ticket Type: " + ticketType + "\n";
		str = str + "Ticket Number: " + ticketNum + "\n";
		str = str + "\nReturned checks are subject to a returned check fee of $35.00.\n";
		str = str + "\nSincerely,\n";
		str = str + "Nathan Nelson\n";
			
		// Returns the notice.
		return str;
	}
	/**
	 * This method generates the ticket type and number
	 * in a string.
	 * @return Returns the ticket type, court date (if any), and ticket number.
	 */
	public String toString()
	{
		// Declare a String variable to hold ticket info.
		
		// Add the ticket type to the string.
		String ticketStr = "Ticket Type: " + ticketType + "\n";
		
		// If driver must appear in court, add a court date.
		if (ticketType == "MUST APPEAR")
		{
			ticketStr = ticketStr + "You must appear at the County Court House on"
					+ "October " + generateCourtDate() + ", 2018.\n";
		}
		
		// Add the ticket number to the string.
		ticketStr = ticketStr + "Ticket Number: " + ticketNum + "\n";
		
		// Add the name of the driver.
		ticketStr = ticketStr + "Name: " + name + "\n";
		
		// Add the speed the driver was going.
		ticketStr = ticketStr + "Speed: " + speed + "\n";
		
		// Add the speed limit of the road.
		ticketStr = ticketStr + "Speed Limit: " + speedLimit + "\n";
		


		
		// Return the generate string.
		return ticketStr;
	}
	
	// ******************* PRIVATE METHODS *****************
	/**
	 * Generates a random number between 100,000 and 999,999.
	 * @return Returns the number of the ticket
	 */
	private int generateTicketNum()
	{
		// Create a Random object
		Random rand = new Random();
		
		// Int variable to hold the random number
		int num;
		
		// Generate an integer between 100,000 and 999,999
		num = rand.nextInt(899999) + 100000;
		
		return num;
	}
	/**
	 * Generates a court date for the ticket
	 * @return Returns 1 through 31 for the court date.
	 */
	private int generateCourtDate()
	{
		// Generate a Random object.
		Random rand = new Random();
		
		// Int variable to hold random number.
		int num = rand.nextInt(30) + 1;
		
		return num;
	}
	/**
	 * This method calculates the fine and determines the ticket type.
	 * @return Returns "PAYABLE" or "MUST APPEAR" as a string
	 */
	private String determineTicketType()
	{
		String tType;
		
		// Calculate the fine amount
		double fine = calculateFine();
		
		// For tickets over $450, driver must appear in court.
		if (fine > 450.00)
		{
			tType = "MUST APPEAR";
		}
		else
			tType = "PAYABLE";
		
		return tType;
	}
	
	
	
	
	
	
	
	
}
