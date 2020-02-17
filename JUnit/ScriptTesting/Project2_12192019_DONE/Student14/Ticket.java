/**
 * the purpose of this class is to calculate fees 
 * for a speeding ticket and print a notice for the violator
 * 
 * 9/28/2019
 */
public class Ticket 
{
	private String name;
	private String ticketType;
	private int ticketNum;
	private int speed;
	private int speedLimit;
	private boolean schoolZone;
	private boolean workZone;
	
	/**Creates a Ticket object with the given name, speed, speed limit.
	 * school zone and work zone are set to false.
	 * @param name
	 * @param speed
	 * @param speedLimit
	 */
	public Ticket (String name, int speed, int speedLimit)
	{
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
		this.schoolZone=false;
		this.workZone=false;
		determineTicketType();
	}
	
	/**Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
	 * @param name
	 * @param speed
	 * @param speedLimit
	 * @param school
	 * @param work
	 */
	public Ticket (String name, int speed, int speedLimit, boolean school, boolean work)
	{
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
		this.schoolZone=school;
		this.workZone=work;
		determineTicketType();
	}
	
	/**sets name of violator
	 * @param name
	 */
	public void setName (String name)
	{
		this.name = name;
	}
	
	/**gets the name of violator
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
		
	/**set speed of violator
	 * @param speed
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	/**get speed of violator
	 * @return speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**set the speed limit
	 * @param speedLimit
	 */
	public void setSpeedLimit(int speedLimit)
	{
		this.speedLimit = speedLimit;
	}

	/** get speed limit
	 * @return speed limit
	 */
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	
	/**generate a ticket number between 100000 and 999999
	 * @return ticketNum
	 */
	private int generateTicketNum()
	{
		int ticketNum = (int)(Math.random()*100000+999999);
		return ticketNum;
	}
	
	/**set the ticket number
	 * @param ticketNum
	 */
	public void setTicketNum(int ticketNum)
	{
		this.ticketNum = ticketNum;
	}
	/**method to randomly generate a day between 1 and 31
	 * @return courtDate
	 */
	private String generateCourtDate()
	{
	      int day=(int)(Math.random()*31+1);
	       return day + " October 2019";
	}
	
	/**set if violator was in school zone
	 * @param schoolZone
	 */
	public void setSchoolZone(boolean schoolZone)
	{
		this.schoolZone = schoolZone;
	}
	
	/**whether the violator was in school zone or not
	 * @return schoolzone
	 */
	public boolean isSchoolZone()
	{
		return schoolZone;
	}
	
	/**set if violator was in work zone
	 * @param workZone
	 */
	public void setWorkZone(boolean workZone)
	{
		this.workZone=workZone;
	}
	
	/**whether violator was in work zone
	 * @return work zone
	 */
	public boolean isWorkZone()
	{
		return workZone;
	}
	
	/**calculate the speeding fine
	 * @return fine
	 */
	public double calculateFine()
	{
		double fine = 0;
		//if speed is in range of 1-10mph
		if((this.speed-this.speedLimit) >= 1 && (speed-speedLimit) <= 10) 
		{
			fine=140;
			if(schoolZone) 
				fine=200;
			else if(schoolZone && workZone)
				fine=250;
		}
		//if speed limit is within 11-20mph
		else if ((this.speed-this.speedLimit) >= 11 && (speed-speedLimit) <= 20)
		{
			fine=195;
			if (schoolZone)
				fine=300;
			else if (schoolZone && workZone)
				fine=350;
		}
		//if speed is within 21-30mph
		else if ((this.speed-this.speedLimit) >= 21 && (speed-speedLimit) <= 30)
		{
			fine = 450;
		}
		//if speed is within 31-40mph
		else if ((this.speed-this.speedLimit) >= 31 && (speed-speedLimit) <= 40)
		{
			fine = 495;
		}
		//check if speed is over 40 and up
		else if ((this.speed-this.speedLimit) >= 41)
		{
			fine = 600;
		}
		return fine;	
	}
	
	/**return the ticket type of "payable" or "must appear"
	 * @return tickettype
	 */
	private void determineTicketType()
	{
		if ((this.speed-this.speedLimit) >= 1 && (speed-speedLimit) <= 30)
			this.ticketType = "Payable";
		else
			this.ticketType = "Must Appear "
			+ "\nYou must appear at the County Court House on " + generateCourtDate();
	}

	/**set the ticket type
	 * @param ticketType
	 */
	public void setTicketType(String ticketType)
	{
		this.ticketType = ticketType;
	}
		 
	/**get the ticket type
	 * @return ticket type
	 */
	public String getTicketType()
	{
		return ticketType;
	}
	
	/**print a notice to the speeder
	 * @return print notice
	 */
	public String printNotice()
	{
		return "\nDepartment of Motor Vehicle\n" + 
	"Automated Traffic Enforcement\n\n\n" +
	"Dear "+ name +	
	"\n\nPlease pay the following speeding fine of " + calculateFine() +
	" to the DMV within 10 days of\n" + 
	"receiving this notice to avoid a driver's license suspension. You are being fined\n" +
	"for going " + speed + "MPH in a " + speedLimit + "MPH zone.\n\n" +
	"Ticket Type: " + ticketType + 
	"\nTicket Number: " + generateTicketNum() + 
	"\n\nReturned checks are subject to a fee of $35.00.\n\n" + 
	"Sincerely,\n" + "Lauren Jin\n\n";
	}
	
	/**string representation of the ticket object
	 */
	public String toString()
	{
		return "Name: "+this.name+ 
				"\nSpeed: "+this.speed+
				"\nSpeed Limit: "+this.speedLimit+ 
				"\nSchool Zone: " + isSchoolZone()+
				"\nWork Zone: " + isWorkZone();
			
		            
		}
}
