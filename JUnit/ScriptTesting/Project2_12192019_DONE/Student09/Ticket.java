import java.util.Random;
import java.text.DecimalFormat;

/**
* 
*
*/
public class Ticket
extends java.lang.Object
{
	private String name;
	private String ticketType;
	
	private int speed;
	private int speedLimit;
	
	private int ticketNumber;
	
	private boolean schoolZone;
	private boolean workZone;
	
	/** Creates a Ticket object with the given name, speed, speed limit.
	*  
	*  @param name - name of the violator
	*  @param speed - speed violator was going
	*  @param speedLimit - the speedlimit
	*  @param speedLimit - the speedlimit
	*  @param school - whether in a school zone or not
	*  @param work - whether in a work zone or not
	*/
	public Ticket(String name, int speed,int speedLimit, boolean school, boolean work)
	{		
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		
		this.schoolZone = school;
		this.workZone = work;
		
		ticketNumber = generateTicketNum();
		ticketType = getTicketType();
	}
		
	/** Creates a Ticket object with the given name, speed, speed limit.
	*  	school zone and work zone are set to false. 
	*  @param name - name of the violator
	*  @param speed - speed violator was going
	*  @param speedLimit - the speedlimit
	*/
	public Ticket(String name, int speed, int speedLimit)
	{
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		
		schoolZone = false;
		workZone = false;
		
		ticketNumber = generateTicketNum();
		ticketType = getTicketType();
	}
	
	
	/** Finds the number of times value is found in the array
	*    The instance variable named intArray is the integer array
	*  @param value  the value to count
	*  @return   the number of times value was found
	*/
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	
	public void setSpeedLimit(int speedLimit)
	{
		this.speedLimit = speedLimit;
	}
	
	
	public int getTicketNum()
	{
		return ticketNumber;
	}
	
	public void setTicketNum​(int ticketNum)
	{
		this.ticketNumber = ticketNum;
	}
	
	
	public boolean isSchoolZone()
	{
		return schoolZone;
	}
	
	public void setSchoolZone(boolean schoolZone)
	{
		this.schoolZone = schoolZone;
	}
	
	
	public boolean isWorkZone()
	{
		return workZone;
	}
	
	public void setWorkZone(boolean workZone)
	{
		this.workZone = workZone;
	}
	
	
	public String getTicketType()
	{
		return determineTicketType();
	}
	
	
	
	
	public double calculateFine()
	{
		double fine = 0;
		int overLimit = (speed - speedLimit);
		
		if( overLimit >= 1 && overLimit <= 10 )
		{
			if(schoolZone == false && workZone == false)
			{
				fine = 140.00;
			}
			
			else if(workZone == false)
			{
				fine = 200.00;
			}
			
			else if(schoolZone == false)
			{
				fine = 250.00;
			}
		}
		
		else if( overLimit >= 11 && overLimit <= 20 )
		{
			if(schoolZone == false && workZone == false)
			{
				fine = 195.00;
			}
			
			else if(workZone == false)
			{
				fine = 300.00;
			}
			
			else if(schoolZone == false)
			{
				fine = 350.00;
			}
		}
		
		else if( overLimit >= 21 && overLimit <= 30 )
		{
			fine = 450.00;
		}
		
		else if( overLimit >= 31 && overLimit <= 40 )
		{
			fine = 495.00;
		}
		
		else if( overLimit >= 41)
		{
			fine = 600.00;
		}
		
		return fine;
	}
	
	
	public String printNotice()
	{
		String notice = "";
		
		notice += "Department of Motor Vehicles";
		notice += "\n";
		notice += "Automated Traffic Enforcement";
		notice += "\n";
		
		notice += "\n";
		notice += "\n";
		
		notice += "Dear " + name + ",";
		notice += "\n";
		
		notice += "\n";
		
		DecimalFormat df = new DecimalFormat("#0.00");
		
		notice += "Please pay the following speeding fine of $" + df.format(calculateFine()) + " to the DMV within 10 days of";
		notice += "\n";
		notice += "receiving this notice to avoid a driver's license suspension. You are being fined";
		notice += "\n";
		notice += "for going " + speed + " MPH in a " + speedLimit + " MPH "; //+ " zone.";
		
		if(schoolZone == false && workZone == false)
		{
			notice += "zone.";
		}
		
		else if(schoolZone == true && workZone == true)
		{
			notice += "school zone and work zone.";
		}
		
		else if(workZone == false)
		{
			notice += "school zone.";
		}
		
		else if(schoolZone == false)
		{
			notice += "work zone.";
		}
		
		notice += "\n";
		notice += "\n";
		
		notice += "Ticket Type: " + getTicketType();
		
		if(getTicketType() == "MUST APPEAR")
		{
			notice += "\n";
			notice += "You must appear at the County Court House on October " + generateCourtDate() + ", 2018.";
		}
		notice += "\n";
		
		notice += "Ticket Number: " + getTicketNum();
		notice += "\n";
		notice += "\n";
		notice += "\n";
		
		notice += "Returned checks are subject to a returned check fee of $35.00.";
		
		notice += "\n";
		notice += "\n";
		
		notice += "Sincerely,";
		notice += "\n";
		notice += "Mert Seremet";
		
		return notice;
	}
	
	private int generateTicketNum()
	{
		Random r = new Random();
		int randomTicketNum = r.nextInt((999999 - 100000) + 1) + 100000;
		
		return randomTicketNum;
	}
	
	private int generateCourtDate()
	{
		Random r = new Random();
		int randomDay = r.nextInt((31 - 1) + 1) + 1;
		
		return randomDay;
	}
	
	private String determineTicketType()
	{
		String type = "";
		
		if( (speed - speedLimit) <= 30)
		{
			type = "PAYABLE";
		}
		
		else if( (speed - speedLimit) > 30)
		{
			type = "MUST APPEAR";
		}
		
		return type;
	}
	
	public String toString()
	{
		return "{Violator Name: " + name + ", Speed: " + speed + ", Speed Limit: " + speedLimit + ", Ticket Numer: " + ticketNumber + ", Ticket Type: " + ticketType + "}";
	}
}