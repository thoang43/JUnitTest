//import statements
import java.util.Random;

/**
 * A ticket contains information of a speeding incident, including the
 * violator's name, the speed they went at, the speed limit of the zone,
 * the ticket's number, what type of ticket it is, and whether they sped in
 * a work zone, school zone, both, or neither, all of which can be set or changed.
 * When a ticket is created, the fine can be calculated, and a notice can be printed.
 * 
 * 
 */

public class Ticket 
{
	//instance fields
	/** the name of the violator */
	private String name;
	/** the type of ticket */
	private String ticketType;
	
	/** the speed the violator was going at */
	private int speed; 
	/** the speed limit of the zone the violator was at */	
	private int speedLimit; 
	/** the ticket number */		
	private int ticketNum;
	
	/** indicator if the violator was speeding in a school zone */
	private boolean schoolZone; 
	/** indicator if the violator was speeding in a work zone */
	private boolean workZone;
	
	//Constructors
	/**Constructs a ticket with the given name, speed, and speed limit, while setting schoolZone and workZone to false. <br>
	 * Ticket number will be set randomly to a number between 100000 to 999999 inclusively. <br>
	 * Ticket type is determined based on information given. 
	 * @param theName the name of the violator
	 * @param theSpeed the speed the violator was going at
	 * @param theSpeedLimit the speed limit of the zone the violator was at
	 */
	public Ticket(String theName, int theSpeed, int theSpeedLimit)
	{
		name = theName;
		speed = theSpeed;
		speedLimit = theSpeedLimit;
		schoolZone = false;
		workZone = false;
		ticketNum = generateTicketNum();
		ticketType = determineTicketType();
	}
	
	/** Constructs a ticket with the given name, speed, speed limit, school zone, and work zone. <br>
	 * Ticket number will be set randomly to a number between 100000 to 999999 inclusively. <br>
	 * Ticket type is determined based on information given.
	 * @param theName the name of the violator
	 * @param theSpeed the speed the violator was going at
	 * @param theSpeedLimit the speed limit of the zone the violator was at
	 * @param theSchoolZone indicates whether they were in a school zone or not
	 * @param theWorkZone indicates whether they were in a work zone or not
	 */
	public Ticket(String theName, int theSpeed, int theSpeedLimit, boolean theSchoolZone, boolean theWorkZone)
	{
		name = theName;
		speed = theSpeed;
		speedLimit = theSpeedLimit;
		schoolZone = theSchoolZone;
		workZone = theWorkZone;
		ticketNum = generateTicketNum();
		ticketType = determineTicketType();
	}
	
	//public methods
	/** Gets the violator's name
	 * @return name - the name 
	 */
	public String getName() {return name;}
	
	/** Sets the name
	 * @param theName the name to be set 
	 */
	public void setName(String theName) {name = theName;}
	
	/** Gets the ticket type
	 * @return ticketType - the ticket type
	 */
	public String getTicketType() {return ticketType;}
	
	/** Gets the speed the violator went at
	 * @return speed - the speed 
	 */
	public int getSpeed() {return speed;}
	
	/** Sets the speed
	 * @param theSpeed the speed to set
	 */
	public void setSpeed(int theSpeed) {speed = theSpeed;}
	
	/** Gets the speed limit of the zone
	 * @return speedLimit - the speed limit
	 */
	public int getSpeedLimit() {return speedLimit;}
	
	/** Sets the speed limit
	 * @param theSpeedLimit the speed limit to set
	 */
	public void setSpeedLimit(int theSpeedLimit) {speedLimit = theSpeedLimit;}
	
	/** Gets the ticket's number
	 * @return ticketNum - the ticket's number
	 */
	public int getTicketNumber() {return ticketNum;}
	
	/** Sets the ticket number
	 * @param theTicketNum the ticket number to set
	 */
	public void setTicketNumber(int theTicketNum) {ticketNum = theTicketNum;}
	
	/** Checks if the violator was in a school zone or not
	 * @return schoolZone - true if in school zone, false otherwise
	 */
	public boolean isSchoolZone() {return schoolZone;}
	
	/** Set if the violator was in school zone or not
	 * @param theSchoolZone if violator was in school zone
	 */
	public void setSchoolZone(boolean theSchoolZone) {schoolZone = theSchoolZone;}
	
	/** Checks if the violator was in a work zone or not
	 * @return schoolZone - true if in work zone, false otherwise
	 */
	public boolean isWorkZone() {return workZone;}

	/** Set if the violator was in work zone or not
	 * @param theWorkZone if violator was in work zone
	 */
	public void setWorkZone(boolean theWorkZone) {workZone = theWorkZone;}
	
	/** Calculates the speeding fine depending on the following criteria: <br>
	 * 1 - 10 MPH over limit - $140 minimum <br>
	 * <ul>
	 * 		school zone - $200 <br>
	 * 		work zone - $250 
	 * </ul>
	 * 11 - 20 MPH over limit - $195 minimum <br>
	 * <ul>
	 * 		school zone - $300 <br>
	 * 		work zone - $350
	 * </ul>
	 * 21 - 30 MPH over limit - $450 <br>
	 * 31 - 40 MPH over limit - $495 <br>
	 * 41 MPH and up - $600
	 * @return the fine based on how much speed is over speed limit
	 */
	public double calculateFine() 
	{
		if((speed-speedLimit) >= 1 && (speed-speedLimit) <= 10)
		{
			if(schoolZone) {return 200.00;}
			else if(workZone) {return 250.00;}
			else {return 140.00;}
		}
		else if((speed-speedLimit) >= 11 && (speed-speedLimit) <= 20)
		{
			if(schoolZone) {return 300.00;}
			else if(workZone) {return 350.00;}
			else {return 195.00;}
		}
		else if((speed-speedLimit) >= 21 && (speed-speedLimit) <= 30)
		{return 450.00;}
		else if((speed-speedLimit) >= 31 && (speed-speedLimit) <= 40)
		{return 495.00;}
		else
		{return 600.00;}
	}
	
	/** Using information about a ticket, prints out a notice from the DMV, detailing what the violation was,
	 * what the fine is, various information about the ticket, and if needed to appear, gives a court date. 
	 * 
	 * @return the notice
	 */
	public String printNotice()
	{
		//text to represent the zone 
		String zone = "zone.";
		
		//format text depending on if the violator was in any particular zone
		if(schoolZone && workZone) {zone = "school and work zone.";}
		else if(schoolZone) {zone = "school zone.";}
		else if(workZone) {zone = "work zone.";}
		
		//return different notice's depending on whether the violator must appear in court or not
		if(ticketType.equals("PAYABLE"))
		{
			return "Department of Motor Vehicles\n" + 
				   "Automated Traffic Enforcement\n" +
				   "\n\n" +
				   "Dear " + name + ",\n" + 
				   "\n" +
				   "You must pay the following speeding fine of $" + String.format("%.2f", calculateFine()) + " within 10 days of\n" +
				   "receiving this notice in order to avoid a driver's license suspension. You're being fined\n" +
				   "for going " + speed + " MPH in a " + speedLimit + " MPH " + zone + "\n" +
				   "\n" +
				   "Ticket Type: " + ticketType + "\n" +
				   "Ticket Number: " + ticketNum + "\n" + 
				   "\n" +
				   "Return checks are subject to a returned check fee of $35.00.\n" +
				   "\n" +
				   "Sincerely,\n" + 
				   "Samuel Kim";
		}
		else
		{
			return "Department of Motor Vehicles\n" + 
				   "Automated Traffic Enforcement\n" +
				   "\n\n" +
				   "Dear " + name + ",\n\n" +
				   "You must pay the following speeding fine of $" +  String.format("%.2f", calculateFine()) + " within 10 days of\n" +
				   "receiving this notice in order to avoid a driver's license suspension. You're being fined\n" +
				   "for going " + speed + " MPH in a " + speedLimit + " MPH " + zone + "\n" +
				   "\n" +
				   "Ticket Type: " + ticketType + "\n" +
				   "You must appear at the County Court House on October " + generateCourtDate() + ", 2019\n" +
				   "Ticket Number: " + ticketNum + "\n" + 
				   "\n" +
				   "Return checks are subject to a returned check fee of $35.00.\n" +
				   "\n" +
				   "Sincerely,\n" + 
				   "Samuel Kim";
		}
	}
	
	//private methods
	/** Generates a number between 1 - 31 inclusive to represent any day of a month, specifically October
	 * @return the random number generated
	 */
	private int generateCourtDate()
	{
		//create a Random object
		Random rand = new Random();
		return (rand.nextInt(31) + 1);
	}
	
	/** Generates a number between 100000 - 999999 inclusive to represent a ticket number
	 * @return the random number generated
	 */
	private int generateTicketNum()
	{
		//create a Random object
		Random rand = new Random();
		return (rand.nextInt(899999) + 100000);
	}
	
	/** Determines what the type of a ticket based on the following criteria: <br>
	 * 1 - 30 MPH over limit <br>
	 * <ul>
	 * 		Ticket is "PAYABLE" 
	 * </ul>
	 * 30 and up MPH over limit <br>
	 * <ul>
     *		Violator "MUST APPEAR"
	 * </ul>
	 * @return the ticket type based on how much speed over the speed limit
	 */
	private String determineTicketType()
	{
		if((speed-speedLimit) >= 1 && (speed-speedLimit) <= 30)
		{
			return "PAYABLE";
		}
		else
		{
			return "MUST APPEAR";
		}
	}

	/** Gives a string representation of a ticket object
	 * @return the string representation
	 */
	public String toString()
	{
		return "Name: " + name + "\n" +
			   "Speed: " + speed + "\n" +
			   "Speed limit: " + speedLimit + "\n" +
			   "Ticket Type: " + ticketType + "\n" +
			   "Ticket Number: " + ticketNum + "\n";
	}
}
