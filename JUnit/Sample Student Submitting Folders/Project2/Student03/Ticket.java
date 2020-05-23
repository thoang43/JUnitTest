package assignment2;

import java.util.Random;

class Ticket {
//		Declare private instance variables
		private String NAME; //name of driver
		private String ticketType; //whether the ticket must be paid in court or not
		private int speed; //speed the driver was traveling at
		private int speedLim; //speed limit of zone in which the driver was traveling 
		private int ticketNum; //ticket number
		private Boolean schoolZone; //if the driver was in a school zone
		private Boolean workZone; //if the driver was in a work zone

		
		/**
		 * Constructor
		 * @param name name of driver
		 * @param newSpeed speed at which the driver was traveling
		 * @param speedLimit speed limit of the zone in which the driver was traveling
		 * @param newSchoolZone whether the driver was in a school zone or not
		 * @param newWorkZone whether the driver was in a work zone or not
		 */ 
		public Ticket(String name, int newSpeed, int speedLimit, boolean newSchoolZone, boolean newWorkZone) {
			NAME = name;
			speed = newSpeed;
			speedLim = speedLimit;
			schoolZone = newSchoolZone;
			workZone = newWorkZone;
		}

		
		/**
		 * Constructor
		 * @param name name of driver
		 * @param newSpeed speed the driver was traveling at
		 * @param speedLimit speed limit of the zone in which the driver was traveling
		 */
		public Ticket(String name, int newSpeed, int speedLimit) {
			NAME = name;
			speed = newSpeed;
			speedLim = speedLimit;
			schoolZone = false;
			workZone = false;
		}
		
		
//		Getters and setters for the private instance variables
		public String getName() {
			return NAME;
		}
		
		public String getTicketType() {
			return determineTicketType();
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public int getSpeedLim() {
			return speedLim;
		}
		
		public int getTicketNum() {
			return ticketNum;
		}
		
		public Boolean isSchoolZone() {
			return schoolZone;
		}
		
		public Boolean isWorkZone() {
			return workZone;
		}
		 
		public void setName(String name) {
			NAME = name;
		}
		
		public void setTicketType(String type) {
			ticketType = type;
		}
		
		public void setSpeed(int newSpeed) {
			speed = newSpeed;
		}
		
		public void setSpeedLim(int speedLimit) {
			speedLim = speedLimit;
		}
		
		public void setTicketNum(int tickNum) {
			ticketNum = tickNum;
		}
		
		public void setSchoolZone(boolean schoolZ) {
			schoolZone = schoolZ;
		}
	
		public void setWorkZone(boolean workZ) {
			workZone = workZ;
		}

		
		/**
		 * A public method which calculates the fine based on the table in Assignment Details
		 * @param speed the speed at which the driving was traveling
		 * @param speedLimit the speed limit of the zone in which the driving was traveling
		 * @param schoolZone whether the offender was in a school zone or not
		 * @param workZone whether the offender was in a work zone or not
		 * @return fine based on table in Assignment Details
		 */
		public double calculateFine() {
			double fine;
			int diff = speed - speedLim;
			if (diff <= 10) { //1 – 10 mph over speed limit
				if (schoolZone) fine = 200;
				else if (workZone) fine = 250;
				else fine = 140;
			}
			else if (diff <= 20) { //11 – 20 mph over speed limit
				if (schoolZone) fine = 300;
				else if (workZone) fine = 350;
				else fine = 195;
			}
			else if (diff <= 30) { //21 – 30 mph over speed limit
				fine = 450;
			} 
			else if (diff <= 40) { //31 – 40 mph over speed limit
				fine = 495;
			}
			else { //41+ mph over speed limit:
				fine = 600;
			}
			return fine;
		}

		
		/**
		 * A public method which returns a String with the contents of the Notice
		 * @return a String with the contents of the notice
		 */
		public String printNotice() {
			double fine = calculateFine();
			String notice = "Department of Motor Vehicles\n"
					+ "Automated Traffic Enforcement\n\n\n";
			
//			If in a school zone
			if (schoolZone && !workZone) {
				notice += "Dear " + NAME + ",\n\n"
						+ "Please pay the following speeding fine of $" + fine + "0 within 10 days of\n"
						+ "this notice to avoid a drivers license suspension. You are being fined\n"
						+ "for going "+ speed + " MPH in a " + speedLim + " MPH school zone.\n\n";
			}
			
//			if in a work zone
			else if (workZone && !schoolZone) {
				notice += "Dear " + NAME + ",\n"
						+ "Please pay the following speeding fine of $" + fine + "0 within 10 days of\n"
						+ "this notice to avoid a drivers license suspension. You are being fined\n"
						+ "for going "+ speed + " MPH in a " + speedLim + " MPH work zone.\n\n";
			}
			
//			if in a school zone and work zone
			else if (schoolZone && workZone) {
				notice += "Dear " + NAME + ",\n"
						+ "Please pay the following speeding fine of $" + fine + "0 within 10 days of\n"
						+ "this notice to avoid a drivers license suspension. You are being fined\n"
						+ "for going "+ speed + " MPH in a " + speedLim + " MPH school/work zone.\n\n";
			}
			
//			in neither a school zone or work zone
			else { 
				notice += "Dear " + NAME + ",\n"
						+ "Please pay the following speeding fine of $" + fine + "0 within 10 days of\n"
						+ "this notice to avoid a drivers license suspension. You are being fined\n"
						+ "for going "+ speed + " MPH in a " + speedLim + " MPH zone.\n\n";
			}
			
//			Print “Ticket Type:” + result of determineTicketType() method
			notice += "Ticket Type: " + determineTicketType();
			
			if (ticketType.equals("MUST APPEAR")) {
//				Print “court date:” + result of generateCourtDate() method 
				notice += "\nCourt Date: October " + generateCourtDate() + ", 2019";
			}
			
//			Print “ticket number:” + result of generateTicketNum() method
			notice += "\nTicket Number: " + generateTicketNum();
			return notice;
		}

		
		/**
		 * A private method which randomly generates a ticket number between 100000 and 999999 inclusively
		 * @return a ticket number between 100000 and 999999 inclusively
		 */
		private int generateTicketNum() {
//			create new random object
			Random rand = new Random();
//			Return randomly generated number between 100000 and 999999
			return rand.nextInt(900000) + 100000;
		}

		
		/**
		 * A private method which randomly generates a day between 1 and 31 inclusively
		 * @return a number between 1 and 31 inclusively
		 */ 
		private int generateCourtDate() {
//			Create new random object
			Random rand = new Random();
//			Return a randomly generated number between 1 and 31
			return rand.nextInt(31) + 1;
		}

		
		/**
		 * A private method which returns a string of either “Payable” or “Must Appear” based on the table in Assignment Details.
		 * @param speed the speed at which the driver was traveling
		 * @param speedLimit the speed limit in the zone the driver was driving in
		 * @return whether the offender must appear in court or not
		 */
		private String determineTicketType() {
			int diff = speed - speedLim;
//			If speed is 1 – 30 mph greater than speed limit then ticket type is “payable”
			if (diff >= 1 && diff <= 30) ticketType = "PAYABLE";
//			else speed is 31+ mph greater than speed limit then ticket type is “must appear”
			else ticketType = "MUST APPEAR";
			return ticketType;
		}
//	 
	/**
	 * A toString method that returns a string representation of a Ticket, including the ticket number and ticket type.
	 */
		public String toString() {
			return NAME + "; Speed: " + speed + "; Speed Limit: " + speedLim + "; " + ticketType;
	}
}
