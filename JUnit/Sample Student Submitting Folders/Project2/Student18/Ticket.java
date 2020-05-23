package _solution;

import java.util.Random;
import java.text.DecimalFormat;

/** The purpose of this class is to define methods
 * for a speeding ticket generator.
 * 9/25/2019
*/

public class Ticket {

	/**
	 * DecimalFormat formats numbers with two decimal places 
	 */
	DecimalFormat formatter = new DecimalFormat("#.00");
	
	//Declaring class attributes for Ticket class
	private String 	name, ticketType, zoneType;
	private int		speed, speedLimit, ticketNumber;
	private boolean	isSchoolZone, isWorkZone;
	
	/**
	 * Default no arg constructor
	 */
	public Ticket() {
		name="";
		ticketType="";
		speed=0;
		speedLimit=0;
		ticketNumber=0;
		isSchoolZone=false;
		isWorkZone=false;
		zoneType="";
	}
	
	/**
	 * Constructor 1 - setting parameter values to class attributes
	 * @param name, speed, speed limit, whether violation occurred in school or work zone
	 */
	public Ticket(String name, int speed, int speedLimit, boolean schoolZone, boolean workZone) {
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
		this.isSchoolZone=schoolZone;
		this.isWorkZone=workZone;
		this.ticketType=this.determineTicketType(speed, speedLimit);
	}
	
	/**
	 * Constructor 2 - with zones set to false
	 * @param name, speed, speed limit
	 */
	public Ticket(String name, int speed, int speedLimit) {
		this.name=name;
		this.speed=speed;
		this.speedLimit=speedLimit;
		this.isSchoolZone=false;
		this.isWorkZone=false;
		this.ticketType=this.determineTicketType(speed, speedLimit);
	}
	
	//GETTER METHODS
	
	/**
	 * The getName method returns the name.
	 * @return name of person receiving ticket
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The getSpeed method returns the speed of car.
	 * @return speed in MPH
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * The getSpeedLimit method returns the speed limit.
	 * @return speed limit in MPH
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	/**
	 * The getSchoolZone method returns whether the violation was in a school zone.
	 * @return if violation in school zone
	 */
	public boolean getSchoolZone() {
		return isSchoolZone;
	}
	
	/**
	 * The getWorkZone method returns whether the violation was in a work zone.
	 * @return if violation was in work zone
	 */

	public boolean getWorkZone() {
		return isWorkZone;
	}
	
	/**
	 * The getTicketType method returns the ticket type.
	 * @return ticket type
	 */
	public String getTicketType() {
		return ticketType;
	}
	
	//SETTER METHODS
	
	/**
	 * The setName method sets the name from user input to the private name variable.
	 * @param violator's name
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * The setSpeed method sets the speed from user input to the private speed variable.
	 * @param speed in MPH
	 */
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	/**
	 * The setSpeedLimit method sets the speed limit from user input to the private speedLimit variable.
	 * @param int speedLimit
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit=speedLimit;
	}
	
	/**
	 * The setSchoolZone method sets the school zone status from user input to the private isSchoolZone variable.
	 * @param school zone
	 */
	public void setSchoolZone(boolean schoolZone) {
		this.isSchoolZone=schoolZone;
	}
	
	/**
	 * The setWorkZone method sets the work zone status from user input to the private isWorkZone variable.
	 * @param work zone
	 */
	public void setWorkZone(boolean workZone) {
		this.isWorkZone=workZone;
	}
	
	/**
	 * The calculateFine method calculates the ticket fine from user input of speed, 
	 * speed limit, and whether violation was in a school/work zone and returns the fine amount.
	 * @param int speed, int speedLimit, boolean isSchoolZone, boolean isWorkZone
	 * @return fine amount
	 */
	public double calculateFine(int speed, int speedLimit, boolean isSchoolZone, boolean isWorkZone){
		double fine=0;
		int overLimit=speed-speedLimit;
		
		if ((overLimit>=1 && overLimit<=10) && isSchoolZone==false && isWorkZone==false) {
			fine=140;
		}
		else if ((overLimit>=1 && overLimit<=10) && isSchoolZone==true && isWorkZone==false) {
			fine=200;
		}
		else if ((overLimit>=1 && overLimit<=10) && isWorkZone==true) {
			fine=250;
		}
		else if ((overLimit>=11 && overLimit<=20) && isSchoolZone==false && isWorkZone==false) {
			fine=195;
		}
		else if ((overLimit>=11 && overLimit<=20) && isSchoolZone==true && isWorkZone==false) {
			fine=300;
		}
		else if ((overLimit>=11 && overLimit<=20) && isWorkZone==true) {
			fine=350;
		}
		else if ((overLimit>=21 && overLimit<=30)) {
			fine=450;
		}
		else if ((overLimit>=31 && overLimit<=40)) {
			fine=495;
		}
		else if ((overLimit>=41)) {
			fine=600;
		}
		
		return fine;
	}
	
	
	/**
	 * The calculateFine method calculates the ticket fine from user input of speed, 
	 * speed limit, and whether violation was in a school/work zone and returns the fine amount.
	 * @return fine amount
	 */
	public double calculateFine(){
		double fine=0;
		
		fine = this.calculateFine(this.speed, this.speedLimit, this.isSchoolZone, this.isWorkZone);
		
		return fine;
	}

	/**
	 * The determineTicketType method determines whether the ticket will be payable by mail or
	 * the violator must appear in court, depending on the speed violation.
	 * @param int speed, int speedLimit
	 * @return ticket type "payable" or "must appear"
	 */
	public String determineTicketType(int speed, int speedLimit) {
		int overLimit=speed-speedLimit;
		if (overLimit>=1 && overLimit<=30) {
			this.ticketType="PAYABLE";
		}
		else if (overLimit>=31) {
			this.ticketType="MUST APPEAR";
		}
		
		return ticketType;
	}
	
	/**
	 * The generateTicketNum method generates a random number from 100,000 to
	 * 999,999 inclusive as the ticket number.
	 * @return ticket number
	 */
	private int generateTicketNum() {
		int ticketNum;
		Random randomNumbers = new Random();
		ticketNum=randomNumbers.nextInt(899999)+100000;
		return ticketNum;
	}
	
	/**
	 * The generateCourtDate method generates a day in October for the
	 * violator to appear in court.
	 * @return court date in October 2019
	 */
	private int generateCourtDate() {
		int date;
		Random randomNumbers = new Random();
		date=randomNumbers.nextInt(30)+1;
		
		return date;
	}
	
	/**
	 * The isSchoolZone method returns whether 
	 * the violation was in a school zone.
	 * @return whether in school zone
	 */
	public boolean isSchoolZone() {
		return isSchoolZone;
	}
	
	/**
	 * The isWorkZone method returns whether 
	 * the violation was in a work zone.
	 * @return whether in work zone
	 */
	public boolean isWorkZone() {
		return isWorkZone;
	}
	
	/**
	 * The zoneType method returns a string "school", "work", "school and work",
	 * or "regular" for type of zone in the report.
	 * @return zone type: "school", "work", "school and work", "regular"
	 */
	public String zoneType() {
		if (this.isSchoolZone==true && this.isWorkZone==false) {
			this.zoneType="school";
		}
		else if (this.isWorkZone==true && this.isSchoolZone==false) {
			this.zoneType="work";
		}
		else if (this.isSchoolZone==true && this.isWorkZone==true) {
			this.zoneType="school and work";		
		}
		else {
			this.zoneType="normal";
		}
		return zoneType;
	}
	
	/**
	 * The printNotice method generates the final notice for the violator, which includes
	 * the user inputs and subsequent ticket type, fine, court date, and ticket number.
	 * @return final ticket report
	 */
	public String printNotice() {
		return ("Department of Motor Vehicles\nAutomated Traffic Enforcement\n\n\n" + "Dear " + getName() + ",\n\n" + "Please pay the following speeding fine of $" + 
				formatter.format(calculateFine(speed, speedLimit, isSchoolZone, isWorkZone)) + 
				" to the DMV within 10 days of \nreceiving this notice to avoid a driver's license suspension. "
				+ "You are being fined \nfor going " + speed + " MPH in a " + speedLimit + " MPH " + zoneType() + " zone.\n\n" +
				"Ticket Type: " + determineTicketType(speed, speedLimit) + "\nTicket Number: " + generateTicketNum() +
				"\nCourt Date: October " + generateCourtDate() + ", 2019" +
				"\n\nReturned checks are subject to a returned check fee of $35.00\n\nSincerely,\nEmily Tchai\n"
				);
	}
	
	/**
	 * The toString method outputs a string which, in this program, is the violation report.
	 * @return printNotice method
	 */
	public String toString() {
		return printNotice();
	}
}
