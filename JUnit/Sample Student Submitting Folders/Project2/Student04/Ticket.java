import java.util.concurrent.ThreadLocalRandom;

public class Ticket {
	
	/**
	 * Represents this name.
	 */
	private String name;
	/**
	 * Represents this speed.
	 */
	private int speed;
	/**
	 * Represents this speed limit.
	 */
	private int speedLimit;
	/**
	 * Represents whether or not this violation occurred in a school zone.
	 */
	private boolean isSchoolZone;
	/**
	 * Represents whether or not this violation occurred in a work zone.
	 */
	private boolean isWorkZone;
	/**
	 * Represents this type of ticket. (PAYABLE or MUST APPEAR)
	 */
	private String ticketType;
	/**
	 * Represents this type of zone. (school or work)
	 */
	private String zoneType;
	/**
	 * Represents this fine amount.
	 */
	private double fine;
	/**
	 * Represents this court date.
	 */
	private String courtDate;
	/**
	 * Represents this ticket number.
	 */
	private int ticketNumber;
	
	/**
	 * Constructs a new empty Ticket.
	 */
	public Ticket() {
	}
	
	/**
	 * Constructs a new Ticket that produces values specified by user input.
	 * @param name Assigns a value to this class variable for the name of the offender.
	 * @param speed Assigns a value to this class variable for the speed that the offender was traveling.
	 * @param speedLimit Assigns a value to this class variable for the speed limit at the location of the offense.
	 * @param isSchoolZone Assigns a value to this class variable for whether the offense occurred in a school zone.
	 * @param isWorkZone Assigns a value to this class variable for whether the offense occurred in a work zone.
	 */
	public Ticket(String name, int speed, int speedLimit, boolean isSchoolZone, boolean isWorkZone) {
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.isSchoolZone = isSchoolZone;
		this.isWorkZone = isWorkZone;
	}
	
	/**
	 * Constructs a new Ticket that produces values specified by user input.
	 * @param name Assigns a value to this class variable for the name of the offender.
	 * @param speed Assigns a value to this class variable for the speed that the offender was traveling.
	 * @param speedLimit Assigns a value to this class variable for the speed limit at the location of the offense.
	 */
	public Ticket(String name, int speed, int speedLimit) {
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
	}
	
	/**
	 * Calculates the speeding fine.
	 * @return Fine calculated based on the following conditions:
	 * <pre>
	 * IF the speed is between 1 and 10 MPH over the speed limit = $140.00
	 * 		AND is in a school zone = $200.00
	 * 	OR
	 * 		AND is in a work zone or both = $250.00
	 * IF the speed is between 11 and 20 MPH over the speed limit = $195.00
	 * 		AND is in a school zone = $300.00
	 * 	OR
	 * 		AND is in a work zone or both
	 * IF the speed is between 21 and 30 MPH over the speed limit = $450.00
	 * IF the speed is between 31 and 40 MPH over the speed limit = $495.00
	 * IF the speed is 41 MPH or more over the speed limit = $600.00
	 * </pre>
	 */
	public double calculateFine() {
		double fine = 0.00;
		if((this.speed - this.speedLimit) > 0 && (this.speed - this.speedLimit) < 11) {
			if(isSchoolZone && !isWorkZone) {
				fine = 200.00;		
			}else if(isWorkZone && !isSchoolZone) {
				fine = 250.00;
			}else if(isSchoolZone && isWorkZone) {
				fine = 250.00;
			}else fine = 140.00;
		}
		if((this.speed - this.speedLimit) > 10 && (this.speed - this.speedLimit) < 21) {
			if(isSchoolZone && !isWorkZone) {
				fine = 300.00;	
			}else if(isWorkZone && !isSchoolZone) {
				fine = 350.00;
			}else if(isSchoolZone && isWorkZone) {
				fine = 350.00;
			}else fine = 195.00;
		}
		if((this.speed - this.speedLimit) > 20 && (this.speed - this.speedLimit) < 31) {
			fine = 450.00;
		}
		if((this.speed - this.speedLimit) > 30 && (this.speed - this.speedLimit) < 41) {
			fine = 495.00;
		}
		if((this.speed - this.speedLimit) > 40) {
			fine = 600.00;
		}
		return fine;
	}
	
	/**
	 * Prints a notice to send to the offender.
	 * @return The text required to print a notice that includes the name of the violator,
	 * the amount of the fine,
	 * the speed at which they were traveling,
	 * the speed limit where the violation occurred,
	 * the zone type where the violation occurred (if applicable),
	 * whether the offender must appear in court or the fine is payable without an appearance,
	 * the court date (if applicable),
	 * the ticket number,
	 * and other necessary information.
	 */
	public String printNotice() {
		ticketType = getTicketType();
		fine = calculateFine();
		courtDate = "October " + generateCourtDate() + ", 2019";
		ticketNumber = generateTicketNum();
		String notice =
				"Department of Motor Vehicles\n" +
				"Automated Traffic Enforcement\n" +
				"\n" +
				"\n" +
				"Dear " + name + ",\n" +
				"\n" +
				"Please pay the following speeding fine of $" + String.format("%1$,.2f", fine) + " to the DMV within 10 days of\n" +
				"receiving this notice to avoid a driver's license suspension. You are being fined\n" +
				"for going " + speed + " MPH in a " + speedLimit + " MPH " + zoneType + "zone.\n" +
				"\n" +
				"Ticket Type: " + ticketType + "\n" +
				((!"PAYABLE".equals(ticketType)) ? "You must appear at the County Court House on " + courtDate + "\n" : "") +
				"Ticket Number: " + ticketNumber + "\n" +
				"\n" +
				"Returned checks are subject to a returned check fee of $35.00.\n" +
				"\n" +
				"Sincerely,\n" +
				"Todd Harland";
		return notice;
	}
	
	/**
	 * Generates a ticket number.
	 * @return A ticket number randomly generated from 100,000 to 999,999.
	 */
	private int generateTicketNum() {
		int randomInt = ThreadLocalRandom.current().nextInt(100000, 1000000);
		return randomInt;
	}
	
	/**
	 * Generates a court date.
	 * @return A day in the month of October generated randomly from 1 to 31.
	 */
	private int generateCourtDate() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, 32);
		return randomInt;
	}
	
	/**
	 * Determines the ticket type.
	 * @return Ticket type determined by the following conditions:
	 * <pre>
	 * IF the speed is 30 MPH or more over the limit = MUST APPEAR
	 * ELSE the ticket = PAYABLE
	 * </pre>
	 */
	private String determineTicketType() {
		String ticketType = "";
		String determineTicketType = "";
		if((speed - speedLimit) > 30) {
			ticketType = "MUST APPEAR";
			if(isSchoolZone) {
				determineTicketType = "school ";
			}
			if(isWorkZone) {
				determineTicketType = "work ";
			}
			if(isSchoolZone && isWorkZone) {
				determineTicketType = "school & work ";
			}
		}
		else {
			ticketType = "PAYABLE";
			if(isSchoolZone) {
				determineTicketType = "school ";
			}
			if(isWorkZone) {
				determineTicketType = "work ";
			}
			if(isSchoolZone && isWorkZone) {
				determineTicketType = "school & work ";
			}
		}
		this.ticketType = ticketType;
		this.zoneType = determineTicketType;
		return ticketType;
	}
	
	/**
	 * Set the name.
	 * @param name Assigns a value to this class variable.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the name.
	 * @return The name class variable.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the speed.
	 * @param speed Assigns a value to this class variable.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Get the speed.
	 * @return The speed class variable.
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Set the speed limit.
	 * @param speedLimit Assigns a value to this class variable.
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}
	
	/**
	 * Get the speed limit.
	 * @return The speedLimit class variable.
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	/**
	 * Get the ticket type.
	 * @return The ticketType  class variable.
	 */
	public String getTicketType() {
		determineTicketType();
		return ticketType;
	}
	
	/**
	 * Set if the offense was in a school zone.
	 * @param isSchoolZone Assigns a value to this class variable.
	 */
	public void setSchoolZone(boolean isSchoolZone) {
		this.isSchoolZone = isSchoolZone;
	}
	
	/**
	 * Set if the offense was in a work zone.
	 * @param isWorkZone Assigns a value to this class variable.
	 */
	public void setWorkZone(boolean isWorkZone) {
		this.isWorkZone = isWorkZone;
	}
	
	/**
	 * Whether the offense was in a school zone.
	 * @return isWorkZone The isSchoolZone class variable.
	 */
	public boolean isSchoolZone() {
		if(this.isSchoolZone) {
			return true;
		}else
			return  false;
	}
	
	/**
	 * Whether the offense was in a work zone.
	 * @return isWorkZone The isWorkZone class variable.
	 */
	public boolean isWorkZone() {
		if(this.isWorkZone) {
			return true;
		}else
			return  false;
	}
	
	/**
	 * Name, speed, speed limit, ticket number and ticket type.
	 * @return The values of name, speed, speedLimit, ticketNumber, and ticketType.
	 */
	public String toString() {
		return name + " " + speed + " " + speedLimit + " " + ticketNumber + " " + ticketType;
	}
	
}