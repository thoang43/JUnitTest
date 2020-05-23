import java.util.Random;
/**
 * 
 *
 */
public class Ticket {

	//Declare private variables
	private String name;
	private int speed;
	private int speedLimit;
	private boolean schoolZone;
	private boolean workZone;
	boolean ticketTyp = false;
	int overspeed = speed - speedLimit;
	
	
	/**
	 * Creates a Ticket object with the given name, speed, speed limit.
	 * @param name
	 * @param speed
	 * @param speedLimit
	 * @param schoolZone
	 * @param workZone
	 */
	//constructor
	public Ticket(String name, int speed, int speedLimit, boolean schoolZone, boolean workZone) 
	{
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.schoolZone = schoolZone;
		this.workZone = workZone;
		this.overspeed = speed - speedLimit;
	}
	
	//constructor
	/**
	 * Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
	 * Ticket number will be set randomly to a number between 100000 and 999999 inclusively.
	 * @param name
	 * @param speed
	 * @param speedLimit
	 */
	public Ticket(String name, int speed, int speedLimit)
	{
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.schoolZone = false;
		this.workZone = false;
		this.overspeed = speed - speedLimit;
	}
	
	//getter and setter methods
	/**
	 * Get name
	 * @return name the name of the violator
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set name
	 * @param name - the name of the violator
	 */
	public void setName(java.lang.String name)
	{
		this.name = name;
	}
	
	/**
	 * Get speed
	 * @return speed the speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Set speed
	 * @param speed - speed to be set
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	/**
	 * Get speedlimit
	 * @return speedlimit the speed limit
	 */
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	
	/**
	 * Set speedlimit
	 * @param speed - speed limit to be set
	 */
	public void setSpeedLimit(int speed)
	{
		this.speed = speed;
	}
	
	/**
	 * Whether violator was in school zone
	 * @return true if in school zone, false if not
	 */
	public boolean isSchoolZone()
	{
		return schoolZone;
	}
	
	/**
	 * Set if violator was in school zone
	 * @param schoolZone - if violator was in school zone
	 */
	public void setSchoolZone(boolean schoolZone)
	{
		this.schoolZone = schoolZone;
	}
	
	/**
	 * Whether violator was in work zone
	 * @return true if in work zone, false if not
	 */
	public boolean isWorkZone()
	{
		return workZone;
	}
	
	/**
	 * Set if violator was in work zone
	 * @param workZone - if violator was in work zone
	 */
	public void setWorkZone(boolean workZone)
	{
		this.workZone = workZone;
	}
	
	//method to calculate fine
	/**
	 * Calculate the speeding fine.
	 * Calculate the fine based on the following:
	 * 1 - 10 MPH over limit - $140 minimum
	 * school zone - $200
	 * work zone - $250
	 * 11 - 20 MPH over limit - $195 minimum
	 * school zone - $300
	 * work zone - $350
	 * 21 - 30 MPH over limit - $450
	 * 31 - 40 MPH over limit - $495, must appear personally
	 * 41 MPH and up - $600, must appear personally
	 * @return the fine for this speed based on the speedLimit
	 */
	public double calculateFine()
	{		
		if(overspeed >= 1 && overspeed <=10)
		{
			if(schoolZone)
				return 200;
			else if(workZone)
				return 250;
			else
				return 140;
		}
		else if(overspeed >= 11 && overspeed <= 20)
		{
			if(schoolZone)
				return 300;
			else if(workZone)
				return 350;
			else
				return 195;
		}
		else if(overspeed >= 21 && overspeed <= 30)
			{
			ticketTyp = true;
			return 450;
			}
		else if(overspeed >= 31 && overspeed <= 40)
			{
			ticketTyp = true;
			return 495;
			}
		else
			{
			ticketTyp = true;
			return 600;
			}
	}
	
	//method to determine ticket type
	/**
	 * Return the ticketType of "Payable" or "Must Appear"
	 * @return the ticketType
	 */
	public String determineTicketType()
	{
		if(ticketTyp == true)
		{
			return "Must appear personally";
		}
		else 
		{
			return "Payable";
		}
	}
	
	//method to print notice
	/**
	 * @return the notice to be sent to the speeder
	 */
	public String printNotice()
	{
		String textZone = "";
		String textSpeed = "";
		if(schoolZone && !workZone)
			{
			textZone = "You are being fined \nfor going " + speed + " MPH in a " + speedLimit + " MPH school zone\n";
			}
		if(!schoolZone && workZone)
		{
			textZone = "You are being fined \nfor going " + speed + " MPH in a " + speedLimit + " MPH work zone\n";
		}
		if(schoolZone && workZone)
		{
			textZone = "You are being fined \nfor going " + speed + " MPH in a " + speedLimit + " MPH school zone and work Zone\n";
		}
		
		if(overspeed > 30)
		{
			textSpeed = "You must appear at the County Court House on October " + createCourtDate() + ", 2019.";
		}
		
		return "\n\nDepartment of Motor Vehicles\n" + 
				"Automated Traffic Enforcement\n" + 
				"Drar " + name + ",\n\n" +
				"Please pay the following speeding fine of $" + calculateFine() + " to the DMV within 10 days of\n" 
				+ "receiving this notice to avoid a driver's license suspension." + textZone + "\n\n"
				+"Ticket Type: " + determineTicketType() + "\n" 
				+ textSpeed + "\n"
				+ "Ticket Number: " + createTicketNum() 
				+ "\n\nReturned checks are subject to a returned check fee of $35.00." 
				+ "\n\nSincerely\n" + "Rui Gao\n";
		
				
	
	}
	
	//method to create a random ticket number
	/**
	 * @return
	 */
	public long createTicketNum()
	{
		Random num = new Random();
		int x = 999999 -100000 + 1;
		int y = num.nextInt() % x;
		long ticketNum = 1000000 + y;
		return ticketNum;
	}
	
	//method to create a random court date
	/**
	 * @return
	 */
	public int createCourtDate()
	{
		Random date = new Random();
		int dt = date.nextInt(29) + 1;
		return dt;
	}

	//method to be a string
	/**
	 *String representation of the ticket object
	 * No specific format
	 * Must include at a minimum Name, speed, speed limit, ticket number and ticket Type
	 * @Overrides toString in class java.lang.Object
	 */
	public String toString()
	{
		return "Ticket Number: " + createTicketNum() + 
				"Date: " + createCourtDate() + "/oct/2019" +
				"Ticket Typ: " + determineTicketType();
	}
}