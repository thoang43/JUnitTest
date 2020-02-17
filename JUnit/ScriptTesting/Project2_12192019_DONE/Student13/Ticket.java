import java.util.Random;

/**
*The purpose of this class is to model a Ticket
*Due Date: 9/30/2019
*/
public class Ticket {
	
	//private instance fields
	private String name;			//Driver's Name
	private int speed;				//The speed that the driver was driving
	private int speedLimit;			//The speed limit the driver violated
	private int ticketNumber;		//The number on the ticket
	private boolean schoolZone;		//Whether or not it was in a school zone. True if in school zone, False otherwise
	private boolean workZone;		//Whether or not it was in a work zone. True if in work zone, False otherwise
	
	/**
	 *  Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
	Ticket number will be set randomly to a number between 100000 and 999999 inclusively.
	Ticket type will be set to either "Payable" or "Must Appear" based on the following:
	1) 1 - 10 MPH over limit - $140 minimum
	school zone - $200
	work zone - $250
	2) 11 - 20 MPH over limit - $195 minimum
	school zone - $300
	work zone - $350
	3) 21 - 30 MPH over limit - $450
	4) 31 - 40 MPH over limit - $495, must appear personally
	5) 41 MPH and up - $600, must appear personally
	 * @param driverName - name of violator
	 * @param driverSpeed - speed violator was going
	 * @param speedL - the speedlimit
	 * @param school - whether in a school zone or not
	 * @param work - whether in a work zone or not
	 */
	public Ticket(String driverName, int driverSpeed, int speedL, boolean school, boolean work)
	{
		name = driverName;
		speed = driverSpeed;
		speedLimit = speedL;
		schoolZone = school;
		workZone = work;
		ticketNumber = generateTicketNum();

	}
	
	/**
	 * Creates a Ticket object with the given name, speed, speed limit.
	school zone and work zone are set to false.
	Ticket number will be set randomly to a number between 100000 and 999999 inclusively.
	Ticket type will be set to either "Payable" or "Must Appear" based on the following:
	1) 1 - 10 MPH over limit - $140 minimum
	school zone - $200
	work zone - $250
	2) 11 - 20 MPH over limit - $195 minimum
	school zone - $300
	work zone - $350
	3) 21 - 30 MPH over limit - $450
	4) 31 - 40 MPH over limit - $495, must appear personally
	5) 41 MPH and up - $600, must appear personally
	 * @param name - name of the violator 
	 * @param driverSpeed - speed violator was going
	 * @param speedL - the speed limit
	 */
	public Ticket(String driverName, int driverSpeed, int speedL)
	{
		name = driverName;
		speed = driverSpeed;
		speedLimit = speedL;
		schoolZone = false;
		workZone = false;

	}
	
	/**
	 * Get name
	 * @return string with the name of the violator
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Get speed
	 * @return integer representing driver's speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	/**
	 * Get speed limit
	 * @return integer representing the speed limit
	 */
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	/**
	 * Get ticket number
	 * @return integer representing the ticket number
	 */
	public int getTicketNumber()
	{
		return ticketNumber;
	}
	
	/**
	 *Get ticket type
	 * @return either string "MUST APPEAR" or "PAYABLE" depending on the violation
	 */
	public String getTicketType()
	{
		return determineTicketType();
	}
	/**
	 * Whether violator was in a school zone
	 * @return true if in school zone, false if not
	 */
	public boolean isSchoolZone()
	{
		return schoolZone;
	}
	/**
	 * Whether violator was in a school zone
	 * @return true if in school zone, false if not
	 */
	public boolean isWorkZone()
	{
		return workZone;
	}
	
	/**
	 * Calculate the speeding fine.
	Calculate the fine based on the following:
	1 - 10 MPH over limit - $140 minimum
	school zone - $200
	work zone - $250
	11 - 20 MPH over limit - $195 minimum
	school zone - $300
	work zone - $350
	21 - 30 MPH over limit - $450
	31 - 40 MPH over limit - $495, must appear personally
	41 MPH and up - $600, must appear personally
	 * @return the fine for this speed based on the speedLimit
	 */
	public double calculateFine()
	{
		int speedDifference = this.speed - this.speedLimit;  //calculates the amount of MPH over the limit
		
		if (speedDifference >= 1 && speedDifference <= 10) 
		{
			if (!(this.schoolZone) && !(this.workZone))
			{
				return 140.00;
			}
			else if (this.schoolZone && !(this.workZone))
			{
				return 200.00;
			}
			else
			{
				return 240.00;
			}
		}
		
		else if (speedDifference >= 11 && speedDifference <= 20)
		{
			if (!(this.schoolZone) && !(this.workZone))
			{
				return 195.00;
			}
			else if (this.schoolZone && !(this.workZone))
			{
				return 300.00;
			}
			else
			{
				return 350.00;
			}
		}
		
		else if (speedDifference >= 21 && speedDifference <= 30)
		{
			return 450.00;
		}
		
		else if (speedDifference >= 31 && speedDifference <= 40)
		{
			return 495.00;
		}
		
		else if (speedDifference >= 41)
		{
			return 600.00;
		}
		
		else
		{
			return 00.00;
		}
		}
	
	/**
	 * Print a notice to be sent to the speeder
	Must follow exact format. See assignment description.
	Note: There are no blank lines before "Department of Motor Vehicles"
	There are two blank lines between "Automated Traffic Enforcement" and the "Dear (name)"
	There is one black line between "Dear (name)" and "Please pay ..."
	Based on the following data:
	Name: Betty Boop
	Speed: 58
	Speed Limit: 25
	School Zone: No
	Work Zone: Yes
	Department of Motor Vehicles
	Automated Traffic Enforcement
	Dear Betty Boop,
	Please pay the following speeding fine of $450.00 to the DMV within 10 days of
	receiving this notice to avoid a driver’s license suspension. You are being fined
	for going 58 MPH in a 25 MPH work zone.
	Ticket Type: MUST APPEAR
	You must appear at the County Court House on October 5, 2019 (day is randomly generated)
	Ticket Number: 936826 (number is randomly generated)
	Returned checks are subject to a returned check fee of $35.00.
	Sincerely,
	Professor Kartchner (put your name here)
	 * @return string representing the notice to be sent to the speeder
	 */
	public String printNotice()
	{
		String notice;
		String zone = "";
		
		notice = "Department of Motor Vehicles\n"
				+ "Automated Traffic Enforcement\n\n\n"
				+ "Dear " + name +",\n\n"
				+ "Please pay the following speeding fine of $" + String.format("%.2f", calculateFine()) + " to the DMV within 10 days of\n"
				+ "receiving this notice to avoid a driver's license suspension. You are being fined\n"
				+ "for going " + speed +" MPH in a " + speedLimit + " MPH ";
		
				//changes text depending on whether it's a school or work zone
				if (isSchoolZone() && !(isWorkZone()))
					zone = "school ";
				if (isWorkZone() && !(isSchoolZone()))
					zone = "work ";
				if (isWorkZone() && isSchoolZone())
					zone = "school and work ";
				notice = notice + zone + "zone.\n\n" + "Ticket Type: " + determineTicketType() + "\n";
				
		if (determineTicketType().contains("APPEAR")) //adds this text if the ticket type is MUST APPEAR in court
		{
			notice += ("You must appear at the Country Course House on October " + generateCourtDate() +", 2019.\n");
		}
		notice += ("Ticket Number: " + generateTicketNum() + "\n\n"
				+ "Returned checks are subject to a returned check fee of $35.00\n\n"
				+ "Sincerely,\nMalcolm Almuntazar-Harris");
		
		return notice;
		
	}
	
	/**
	 * Generates and returns a random number between 100000 and 999999 to serve as the ticket number
	 * @return integer between 100000 and 999999
	 */
	private int generateTicketNum()
	{
		Random r = new Random();
		int low = 100000;
		int high = 999999;
		return r.nextInt(high-low) + low;  //formula for random number between two numbers
	}
	
	/**
	 * Generates and returns a random number between 1 and 31 to serve as the date for the court date
	 * @return a random integer 1 and 31
	 */
	private int generateCourtDate()
	{
		Random r = new Random();
		int low = 1;
		int high = 31;
		return r.nextInt(high-low) + low; //formula for random number between two numbers
	}
	/**
	 * Determines ticket type by calling calculateFine() and determining based on fine amount
	 * @return string with ticket type
	 */
	private String determineTicketType()
	{
		if (calculateFine() >= 495.00)  //uses calculate fine method and returns ticket type based on amount
			return "MUST APPEAR";
		else
			return "PAYABLE";
	}
	/**
	 * String representation of the ticket object
	No specific format
	Must include at a minimum Name, speed, speed limit, ticket number and ticket Type
	 */
	public String toString()
	{
		return ("Name: " + this.name + "\n"
				+ "Speed: " + this.speed + "\n"
				+ "Speed Limit: " + this.speedLimit + "\n"
				+ "Fine: " + String.format("%.2f", calculateFine()) + "\n"
				+ "Ticket Type: " + determineTicketType() + "\n"
				+ "Ticket Number: " + generateTicketNum());
	}
	/**
	 * set name
	 * @param name to be set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * set speed
	 * @param speed to be set
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	/**
	 * set speedLimit
	 * @param speed limit to be set
	 */
	public void setSpeedLimit(int speedLimit)
	{
		this.speedLimit = speedLimit;
	}
	/**
	 * set if violator was in school zone
	 * @param schoolZone - if violator was in school zone
	 */
	public void setSchoolZone(boolean schoolZone)
	{
		this.schoolZone = schoolZone;
	}
	/**
	 * set if violator was in a work zone
	 * @param workZone - if violator was in a work zone
	 */
	public void setWorkZone(boolean workZone)
	{
		this.workZone = workZone;
	}
}
