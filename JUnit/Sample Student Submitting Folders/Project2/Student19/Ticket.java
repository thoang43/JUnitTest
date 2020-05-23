/**
 * Ticket class, represents a Ticket object
 * 
 * 
 *
 */

import java.util.Random;

public class Ticket {
	
	private String	name,
					ticketType;
	private int 	speed,
					speedLimit,
					ticketNum;
	
	private boolean school,
					work;
	
/** 	
 * Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
 * Ticket number will be set randomly to a number between 100000 and 999999 inclusively.
 * Ticket type will be set to either "Payable" or "Must Appear" based on the following:
 * 1) 1 - 10 MPH over limit - $140 minimum
 * school zone - $200
 * work zone - $250
 * 2) 11 - 20 MPH over limit - $195 minimum
 * school zone - $300
 * work zone - $350
 * 3) 21 - 30 MPH over limit - $450
 * 4) 31 - 40 MPH over limit - $495, must appear personally
 * 5) 41 MPH and up - $600, must appear personally
 * @param name name of the violator
 * @param speed speed violator was going
 * @param speedLimit the speed limit
 * @param school whether in a school zone or not
 * @param work whether in a work zone or not
 */
	public Ticket(String name, int speed, int speedLimit, boolean school, boolean work) {
		
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.school = school;
		this.work = work;
		
		this.ticketNum = generateTicketNum();
		this.ticketType = determineTicketType(speed, speedLimit);

	}
	
/** 
 * Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
 * Ticket number will be set randomly to a number between 100000 and 999999 inclusively.
 * Ticket type will be set to either "Payable" or "Must Appear" based on the following:
 * 1) 1 - 10 MPH over limit - $140 minimum
 * school zone - $200
 * work zone - $250
 * 2) 11 - 20 MPH over limit - $195 minimum
 * school zone - $300
 * work zone - $350
 * 3) 21 - 30 MPH over limit - $450
 * 4) 31 - 40 MPH over limit - $495, must appear personally
 * 5) 41 MPH and up - $600, must appear personally
 * @param name
 * @param speed
 * @param speedLimit
 */
	public Ticket(String name, int speed, int speedLimit) {
		
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.school = false;
		this.work = false;
		
		this.ticketNum = generateTicketNum();
		this.ticketType = determineTicketType(speed, speedLimit);
		
	}
	
	/**
	 * Gets the ticketType
	 * @return ticketType the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}
	
	/**
	 * Get name
	 * @return name the name of the violator
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get speed
	 * @return speed the speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	
	/**
	 * Get speedlimit
	 * @return speedLimit the speed limit
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	
	/**
	 * Get ticketNum
	 * @return ticketNum ticket number
	 */
	public int getTicketNum() {
		return ticketNum;
	}
	
	
	/**
	 * Whether violator was in school zone
	 * @return true if in school zone, false if not
	 */
	public boolean isSchoolZone() {
		return school;
	}
	
	/**
	 * Whether violator was in work zone
	 * @return true if in work zone, false if not
	 */
	public boolean isWorkZone() {
		return work;
	}
	
	/**
	 * Set name
	 * @param name the name of the violator
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set speed
	 * @param speed speed to be set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Set speedlimit
	 * @param speedLimit speed limit to be set
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}
	
	/**
	 * Set if violator was in school zone
	 * @param school if violator was in school zone
	 */
	public void setSchoolZone(boolean school) {
		this.school = school;
	}
	
	/**
	 * Set if violator was in work zone
	 * @param work if violator was in work zone
	 */
	public void setWorkZone(boolean work) {
		this.work = work;
	}
	
	/**
	 * Return the ticketType of "Payable" or "Must Appear"
	 * @param speed
	 * @param speedLimit
	 * @return the ticketType
	 */
	private String determineTicketType(int speed, int speedLimit) {
		
		if (speed - speedLimit > 30)
			return "MUST APPEAR";
		else
			return "PAYABLE";
	}
	
	/**
	 * Generates a random ticket number between 100,000 and 999,999
	 * @return ticket number
	 */
	private int generateTicketNum() {
		
		int ticketNum;
		Random randNum = new Random();
		ticketNum = randNum.nextInt(899999) + 100000;
		return ticketNum;
	}
	
	/**
	 * Generates a random court date between 1 and 31
	 * @return court date
	 */
	private int generateCourtDate() {
		
		int courtDate;
		Random randNum = new Random();
		courtDate = randNum.nextInt(30) + 1;
		return courtDate;
	}
	
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
	public double calculateFine() {
		
		double fine = 0;
		int overLimit = speed - speedLimit;
		
		if (overLimit < 21) {
			
			if (overLimit > 10) {
				
				if (work)
					fine = 350.0;
				else if (school)
					fine = 300.0;
				else
					fine = 195.0;
			}
			
			else {
				if (work) 
					fine = 250.0;
				else if (school)
					fine = 200.0;
				else 
					fine = 140.0;
				}
			}
		else if (overLimit < 31)
			fine = 450;
		else if (overLimit < 41)
			fine = 495.0;
		else if (overLimit >= 41)
			fine = 600.0;
		
		return fine;
		}
	
	/**
	 * Generates a ticket notice based on the fields of the ticket
	 * 
	 * @return string string containing the ticket notice
	 */
	public String printNotice() {
		
		String zone = "";
		String appear = "";
		String fine = String.format("$%,.2f", calculateFine());
				
		if (work && school)
			zone = "work and school ";
		else if (work)
			zone = "work ";
		else if (school)
			zone = "school ";
		
		if (ticketType == "MUST APPEAR")
			appear = "You must appear at the County Court House on October " + generateCourtDate() + ". 2019.\n";
		
		
		String notice =		"Department of Motor Vehicles\n" +
							"Automated Traffic Enforcement\n\n\n" +
				
							"Dear " + name + ",\n\n" +
							
							"Please pay the following speeding fine of " + fine + " to the DMV within 10 days of\n" +
							"receiving this notice to avoid a driver's license suspension. You are being fined\n" +
							"for going " + speed + " MPH in a " + speedLimit + " MPH " + zone + "zone.\n\n" +
							
							"Ticket Type: " + ticketType + "\n" + 
							appear +
							"Ticket Number: " + ticketNum + "\n\n" +
							
							"Returned checks are subject to a returned check fee of $35.00.\n\n" +
							
							"Sincerely,\n" +
							"Christian Watson"; 
		
		return notice;
	}
	
	/**
	 * String representation of the Ticket object
	 * No specified format
	 * Must include at a minimum Name, speed, speed limit, ticket number, and ticket type
	 */
	public String toString() {
		
		String ticketString = 	"Ticket No.: " + ticketNum + "\n" +
								"Name: " + name + "\n" +
								"Speed: " + speed + "\n" +
								"Posted Speed: " + speedLimit + "\n" +
								"Fine: " +  calculateFine() + "\n" +
								"Ticket Type: " + ticketType;
		return ticketString;
	}
}