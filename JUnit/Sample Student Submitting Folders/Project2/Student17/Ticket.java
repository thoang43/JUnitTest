/**
 * 
 * Date: Sep 28-2019
 * Assignment 2
 * This is speeding tickets programming.
 * 
 * 
 */

import java.util.Random;

/**
 * This method creates a Ticket object with the given name, speed, speed limit, 
 * ticketNumber, school zone and work zone, overLimit.
 */

public class Ticket {
	
	private String name; // user name
	private int speed; // driving speed
	private int speedLimit; // the road speed limit
	int ticketNumber; // ticket number
	private boolean schoolZone; // Speeding in the school zone
	private boolean workZone; // Speeding in the work zone
	int overLimit=speed-speedLimit; // calculate the over limit
	boolean flag = false; // flag
	
	
	/**
	 * Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
	 * @param name
	 * @param speed
	 * @param speedLimit
	 * @param schoolZone
	 * @param workZone
	 */
	// A constructor that takes the name, speed, speed limit, school zone and work zone.
	public Ticket (String name, int speed, int speedLimit, boolean schoolZone,boolean workZone)
	{
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.schoolZone = schoolZone;
		this.workZone = workZone;
		this.overLimit=speed-speedLimit;
	}
	
	
	
	// Another constructor.
	/**
	 * Creates a Ticket object with the given name, speed, speed limit.
	 * @param name
	 * @param speed
	 * @param speedLimit
	 */
	public Ticket (String name, int speed, int speedLimit)
	{
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.overLimit=speed-speedLimit;
		
		// The school zone and work zone will be set to false.
		this.schoolZone = false;
		this.workZone = false;
	}
	
	
	//Getters and setters for the private instance variables.
    /**
     *Get name
     * @return
     */
    public String getName() 
	{
		return name;
	}
	/**
	 *Set name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	/**
	 *Get speed
	 * @return
	 */
	public int getSpeed() 
	{
		return speed;
	}
	
	
	/**
	 * Get speedlimit
	 * @return
	 */
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	
	
	/**
	 * Set speedlimit
	 * @param SpeedLimit
	 */
	public void setSpeedLimit(int SpeedLimit)
	{
		this.speedLimit = SpeedLimit;
	}
	
	
	/**
	 * Whether violator was in work zone
	 * @return
	 */
	public boolean isWorkZone()
	{
		return workZone;
	}
	
	
	/**
	 * Set if violator was in work zone
	 * @param workZone
	 */
	public void setWorkZonee(boolean workZone)
	{
		this.workZone = workZone;
	}
	
	
	/**
	 * Whether violator was in school zone
	 * @return
	 */
	public boolean isSchoolZone()
	{
		return schoolZone;
	}
	
	/**
	 * Set if violator was in school zone
	 * @param schoolZone
	 */
	public void setSchoolZone(boolean schoolZone)
	{
		this.schoolZone = schoolZone;
	}
	
	
	// Calculate and return the fine.
	/**
	 *Calculate the speeding fine.
	 *Calculate the fine based on the following: 
	 *1 - 10 MPH over limit - $140 minimum
	 *school zone - $200
	 *work zone - $250
	 *11 - 20 MPH over limit - $195 minimum
	 *school zone - $300
	 *work zone - $350
	 *21 - 30 MPH over limit - $450
	 *31 - 40 MPH over limit - $495, must appear personally
	 *41 MPH and up - $600, must appear personally
	 * @return
	 */
	public double calculateFine()
	{
		double fine=0.0; // set it equal to 0
		int  overLimit=speed-speedLimit; 
		// using if-else loop.
		if(overLimit>=1 && overLimit<=10)
		{
			fine=fine+140;
			if(schoolZone)
			{
				fine=fine+200;
			}
			if(workZone)
			{
				fine=fine+250;
			}
		}else if (overLimit>=11 && overLimit<=30)
		{
			fine=fine+195;
			if(overLimit>=21)
			{
				fine=fine+310;
			}
			if(schoolZone)
			{
				fine=fine+310;
			}
			if(workZone)
			{
				fine=fine+360;
			}
		}
		else if(overLimit>=31)
		{
			flag=true;
			if(overLimit<=40)
				fine=fine+450;
			else
				fine=fine+675;
		}
		return fine;
	}
	
	
	// Return a String with the contents of the Notice.
	/**
	 * Print a notice to be sent to the speeder
	 * Must follow exact format.
	 * @return
	 */
	public String printNotice()
	   {  
		
		String text="";
		String ts="";
	       if(schoolZone)
	       {
	    	   
	            text=" school zone\n";
	       
	       }
	       if(workZone)
	       {
	    	   
	           text=" Work zone.\n";
	        
	       }
	       
	       if(overLimit>30)
	       {
	    	 ts = "\nYou must appear at the County Court House on: "+"October "+generateCourtDate()+", 2019";
	       }
	       return "\n\nDepartment of Motor Vehicles\n"+
	       "Automated Traffic Enforcement\n\n"+
	       "\nDear " +name+",\n\n"+
	       "Please pay the following speeding fine of $"+calculateFine()+
	       " to the DMV within 10 days of\n"+
	       "receiving this notice to avoid a driver’s license suspension."+
	       " You are being fined \nfor going "+speed+
        " MPH in a "+speedLimit+" MPH "+text+
	       "\n\nTicket Type: "+ticketType()+ts+
	       "\nTicket Number: "+generateTicketNumber()+
	       "\n\nReturned checks are subject to a returned check fee of $35.00.\n"+
	       "\nSincerely\n"+"Li Jia";
	   }
	
	
	
	// Randomly generates a day between 1 and 31 inclusively.
	/**
	 * Randomly generates a day between 1 and 31 inclusively.
	 * @return
	 */
	private int generateCourtDate()
	   {
	       Random rn = new Random();
	       int n = 31 - 1 + 1;
	       int i = rn.nextInt() % n;
	       return 31 + i;
	   }
	
	
	// Randomly generates a ticket number between 100000 and 999999 inclusively.
	/**
	 * Ticket number will be set randomly to a number between 100000 and 999999 inclusively.
	 * @return
	 */
	private long generateTicketNumber()
	{
		Random rn = new Random();
		int n = 999999-100000+1;
		int i = rn.nextInt()%n;
		long randomNumber = 1000000+i;
		return randomNumber;
	}
	
	
	// Returns a string.
	/**
	 * Return the ticketType of "Payable" or "Must Appear"
	 * @return
	 */
	private String ticketType()
	{
		return(flag==true)?"Must Appear" : "Payable";
	}
	
	
	// Returns a string representation of a Ticket.
	/**
	 *String representation of the ticket object
	 *No specific format
	 *Must include at a minimum Name, speed, speed limit, ticket number and ticket Type
	 */
	@Override	
	public String toString()
	{
		return "Tick Number: " + generateTicketNumber()+" Date: "+generateCourtDate()+ "/Oct/2019"+" Ticket Type: "+ticketType();
	}

}


