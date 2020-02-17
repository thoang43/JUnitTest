import java.util.Random;
import java.text.DecimalFormat;
/** This class holds the fields and methods to create the ticket*/
public class Ticket {
	/** 
	*/
	private String name, ticketType;
	private int speed, speedLimit, ticketNumber;
	private boolean workZone, schoolZone;
	/**
	 * Creates Ticket object with name, speed, speed limit, school zone, and work zone
	 * @param n
	 * @param s
	 * @param sL
	 * @param sZ
	 * @param wZ
	 */
	public Ticket(String n, int s, int sL, boolean sZ, boolean wZ) {
		name = n;
		speed = s;
		speedLimit = sL;
		schoolZone = sZ;
		workZone = wZ;
	}
	/**
	 * Creates Ticket object with name, speed, and speed limit, and sets school zone and work zone to false
	 * @param n
	 * @param s
	 * @param sL
	 */
	public Ticket(String n, int s, int sL) {
		name = n;
		speed = s;
		speedLimit = sL;
		schoolZone = false;
		workZone = false;
	}
	/**@return Returns name*/
	public String getName() {
		return name;
	}
	/** @return Returns ticket type*/
	public String getTicketType() {
		return ticketType;
	}
	/** @return Returns speed*/
	public int getSpeed() {
		return speed;
	}
	/** @return Returns speed limit*/
	public int getSpeedLimit() {
		return speedLimit;
	}
	/** @return Returns ticket number*/
	public int getTicketNum() {
		return ticketNumber;
	}
	/** @return Returns true or false for school zone*/
	public boolean isSchoolZone() {
		return schoolZone;
	}
	/** @return Returns true or false for work zone*/
	public boolean isWorkZone() {
		return workZone;
	}
	/** @param n for name input*/
	public void setName(String n) {
		name = n;
	}
	/** @param tT for ticket type input */
	public void setTicketType(String tT) {
		ticketType = tT;
	}
	/** @param s for speed input*/
	public void setSpeed(int s) {
		speed = s;
	}
	/** @param sL for speed limit input*/
	public void setSpeedLimit(int sL) {
		speedLimit = sL;
	}
	/** @param tN for ticket number input*/
	public void setTicketNum(int tN) {
		ticketNumber = tN;
	}
	/** @param b for boolean school zone input*/
	public void setSchoolZone(boolean b) {
		schoolZone = b;
	}
	/** @param b for boolean work zone input*/
	public void setWorkZone(boolean b) {
		workZone = b;
	}
	/** @return method to calculate and return the fine amount*/
	public double calculateFine() {
		double fine = 0;
		if(speed > speedLimit && speed <= speedLimit + 10) {
			if(workZone || (workZone && schoolZone)) {
				fine = 250.0;
			}else if(schoolZone) {
				fine = 200.0;
			}else {
			fine = 140.0;}
		}
		if(speed > speedLimit +10 && speed <= speedLimit + 20) {
			if(workZone || (workZone && schoolZone)) {
				fine = 350.0;
			}else if(schoolZone) {
				fine = 300.0;
			}else {
			fine = 195.0;}
		}
		else if(speed > speedLimit +20 && speed <= speedLimit + 30) {
			
			fine = 450.0;
		}
		else if(speed > speedLimit +30 && speed <= speedLimit + 40) {
			
			fine = 495.0;
		}
		else if(speed > speedLimit + 40) {
			
			fine = 600.0;
		}
		return fine;
	}
	/** @return method to print the fine notice*/
	public String printNotice() {
		DecimalFormat df = new DecimalFormat(".00");
		return ("Dear " + name + ",\n\n" + "Please pay the following speeding fine of $" + df.format(calculateFine()) + " to the DMV within"
						+ " 10 days of \nreceiving this notice to avoid a driver’s license suspension. You are being fined \n" + 
						"for going " + getSpeed() +" MPH in a " + getSpeedLimit() + " MPH " + 
						(isSchoolZone()&&isWorkZone()?"school and work":(isSchoolZone()?"school":(isWorkZone()?"work":""))) + "zone.\n\n" + toString()
						+"\nReturned checks are subject to a return check fee of $35.00.\n\nSincerely,\nMatthew Quander");
		
	}
	/** @return method to generate a ticket number*/
	private int generateTicketNumber() {
		Random rand = new Random();
		setTicketNum(rand.nextInt(899999) + 100000);
		return getTicketNum();
	}
	/** @return method to generate a court date*/
	private int generateCourtDate() {
		Random rand = new Random();
		return rand.nextInt(31) + 1;
	}
	/** @return method to determine the ticket type*/
	private String determineTicketType() {
		
		if(calculateFine() >= 140.0 && calculateFine() <= 450.0) {
			setTicketType("Payable");
		}
		else if(calculateFine() > 450.0) {
			setTicketType("Must Appear");
		}
		return getTicketType();
	}
	/** @return method to display ticket type, ticket number, and court date if applicable*/
	public String toString() {
		String value = "";
		if(determineTicketType() == "Payable") {
			value = "Ticket Type: Payable\nTicket Number: " + generateTicketNumber();	
		}
		else if(determineTicketType() == "Must Appear") {
			value = "Ticket Type: Must Appear\nYou Must appear at the County Courthouse on October "+ generateCourtDate() +", 2019\n"
					+ "Ticket Number: " + generateTicketNumber() + "\n";
		}
		return value;
	}
}
