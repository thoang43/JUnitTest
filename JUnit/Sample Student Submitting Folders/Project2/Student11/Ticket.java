/*
 * 
 * 9/29/19
 * CMSC 203-22656
 */
import java.util.Random;

public class Ticket {

	//Class variables
	private String name;
	private String ticketType;
	private int speed;
	private int speedLimit;
	private boolean work;
	private boolean school;
	private int ticketNum;
	private double fine;
	
	//Class Constructors
	public Ticket(String name, int speed, int speedLimit) {
		
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		
		ticketType = determineTicketType();
		ticketNum = generateTicketNum();
		fine = calculateFine();
		
	}
	
	public Ticket(String name, int speed, int speedLimit, boolean school, boolean work) {
		
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.work = work;
		this.school = school;
		
		
		ticketNum = generateTicketNum();
		ticketType = determineTicketType();
		fine = calculateFine();
	}

	//Class Methods
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	public boolean isWorkZone() {
		return work;
	}

	public void setWorkZone(boolean work) {
		this.work = work;
	}

	public boolean isSchoolZone() {
		return school;
	}

	public void setSchoolZone(boolean school) {
		this.school = school;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	
	public double calculateFine() {
		
		double fine = 0;
		
		if(speed > speedLimit) {
			
			int x = speed - speedLimit;
			
			if(x >= 1 && x <= 10) {
				
				if(school == true) {
					
					fine = 200.00;
				}
				
				else if(work == true) {
					
					fine = 250.00;
				}
				
				else {
				fine = 140.00;	
				}
			}
			
			
			else if(x >= 11 && x <= 20){
				
				if(school == true) {
					
					fine = 300.00;
				}
				
				else if(work == true) {
					
					fine = 350.00;
				}
				else {
					fine = 195.00;
				}
				 
				
			}
			
			
			else if(x >= 21 && x <= 30) {
				
				fine = 450.00;
			}
			
			else if(x >= 31 && x <= 40) {
				
				fine = 495.00;
			}
			
			else if(x >= 41) {
				
				fine = 600.00;
			}
			
		}
		
		else {
			fine = 0;
		}
		
		return fine;
		
	}
	
	//determine ticket type
	public String determineTicketType() {
		
		//sets ticket type
		if(speed > speedLimit) {
			
			int x = speed - speedLimit; //WTF
			
			if(x >= 1 && x <= 10) {
				ticketType = "Payable";
			}
			
			else if(x >= 11 && x <= 20) {
				ticketType = "Payable";
			}
			
			else if(x >= 21 && x <= 30) {
				ticketType = "Payable";
			}
			
			else if(x >= 31 && x <= 40) {
				ticketType = "Must Appear";
			}
			
			else if(x >= 41) {
				ticketType = "Must Appear";
			}
			
		}
		else {
			ticketType = "Invalid";
		}
		
		return ticketType;
		
	}
	
	public String getTicketType() {
		
		
		return ticketType;
	}
	
	//generates ticket number
	private int generateTicketNum() {
	
		int max = 999999;
		int min = 100000;
		
		Random rand = new Random();
		
		int r  = rand.nextInt(max - min) + min;
		
		return r;
		
	}
	
	//generates court date
	private int generateCourtDate() {
		
		int max = 31;
		int min = 1;
		
		Random rand = new Random();
		
		int r  = rand.nextInt(max - min) + min;
		
		return r;
		
	}
	
	//returns notice
	public String printNotice() {
		
		String s = "";
		if(school == true) {
			s = "school ";
		}
		
		String w = "";
		if(work == true) {
			w = "work ";
		}
		
		String c ="";
		if(ticketType == "Must Appear") {
			c = "You must appear at the County Court House on October " + generateCourtDate() + ", 2019" + "\n";
		}
		
		
		
		String notice = String.format("\n" + "Department of Motor Vehicles" + "\n" +
		"Automated Traffic Enforcement" + "\n" + "\n" + "Dear " + name + ","
		+ "\n" + "\n" + "Please pay the following speeding fine of $" + "%.2f" + 
		" to the DMV within 10 days of receiving this notice to avoid a driver's license "
		+ "suspension." + "\n" + "You are being fined for going " + speed + " MPH in a " + speedLimit
		+ " MPH " + s + w + "zone." + "\n" + "\n" + "Ticket Type: " + ticketType + "\n" + c   
		+ "Ticket Number: " + ticketNum + "\n" + "\n" + "Returned checks are subject "
		+ "to a returned check fee of $35.00." + "\n" + "\n" + "Sincerely," + "\n" + "Matthew Proctor" + "\n" + "\n", fine);
		
		return notice;
				
	}

	public String toString() {
		
		String t = "Name on ticket: " + name + "\n" +
				"Violator speed: " + speed + "\n" + 
				"Speed Limit: "+ speedLimit + "\n" +
				"Ticket Number: " + ticketNum + "\n" +
				"Ticket Type: " + ticketType;
		
		return t;
	}
}
