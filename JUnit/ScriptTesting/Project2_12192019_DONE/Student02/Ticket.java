import java.util.Scanner;

	public class Ticket {
		 private String name;
		 private String ticketType;
		 private int carSpeed;
		 private int speedLimit;
		 private int ticketNumber;
		 private boolean schoolZone;
		 private boolean workZone;
	 
	 /**First Constructor*/
	 public Ticket(String name, int carSpeed, 
			 			int speedLimit, boolean schoolZone, 
			 			boolean workZone) {
		 
		 this.name = name;
		 this.carSpeed = carSpeed;
		 this.speedLimit = speedLimit;
		 this.schoolZone = schoolZone;
		 this.workZone = workZone;	 
	 }
	 
	 /**Second Constructor*/
	 public Ticket(String name, int carSpeed, int speedLimit) {

			this.name = name;
			this.ticketType = "";
			this.carSpeed = carSpeed;
			this.speedLimit = speedLimit;
			this.ticketNumber = 0;
			this.schoolZone = false;
			this.workZone = false;
	 }
	 /**Start of Getters and Setters*/
	 public String getName() {
		 return name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public String getTicketType() {
		 return ticketType;
	 }
	 
	 public void setTicketType(String ticketType) {
		 this.ticketType = ticketType;
	 }
	 
	 public int getCarSpeed() {
		 return carSpeed;
	 }
	 
	 public void setCarSpeed(int carSpeed) {
		 this.carSpeed = carSpeed;
	 }
	 
	 public int getSpeedLimit() {
		 return speedLimit;
	 }
	 
	 public void setSpeedlimit(int speedLimit) {
		 this.speedLimit = speedLimit;
	 }
	 
	 public int getTicketNumber() {
		 return ticketNumber;
	 }
	 
	 public void setTicketNumber(int ticketNumber) {
		 this.ticketNumber = ticketNumber;
	 }
	 
	 public boolean getSchoolZone() {
		 return schoolZone;
	 }
	 
	 public void setSchoolZone(boolean schoolZone) {
		 this.schoolZone = schoolZone;
	 }

	public boolean getWorkZone() {
		return workZone;
	}

	public void setWorkZone(boolean workZone) {
		this.workZone = workZone;
	}
	 
	public double calculateFine() {
		double fine = 0.0;
		getUserInput();
		int speedDiff = carSpeed - speedLimit;
		if (speedDiff >= 1 && speedDiff <= 10) {
			if (schoolZone && !workZone) {
				fine = 200;
			} else {
				fine = 250;
			}
		} else if (speedDiff >= 11 && speedDiff <= 20) {
			if (schoolZone && !workZone) {
				fine = 300;
			} else {
				fine = 350;
			}
		} else if (speedDiff >= 21 && speedDiff <= 30) {
			fine = 450;
		} else if (speedDiff >= 31 && speedDiff <= 40) {
			fine = 495;
		} else if (speedDiff >= 41) {
			fine = 600;
		}
		//Calculate Fine
		return fine;
	}

	public String printNotice() {
		String notice = "";
		return notice;
	}

	private int generateTicketNum() {
		int randomTicketNum = (int) (Math.random() * 100000);
		//Generate random number between 100000 and 999999 inclusively
		return randomTicketNum;
	}

	private int generateCourtDate() {
		int randomCourtDate = randomNumber(1,31);
		//Generate random number between 1 and 31 inclusively
		return randomCourtDate;
	}

	private String DetermineTicketType() {
		String typeOfTicket = "";
		int speedDiff = carSpeed - speedLimit;
		if (speedDiff > 31) {
			typeOfTicket = "Must Appear/nYou must appear at the County Court House on October " + generateCourtDate() +", 2018";
		} else {
			typeOfTicket = "PAYABLE";
		}
		//Condition Payable or Must Appear based on Table in Assignment Details
		return typeOfTicket;
	}

	private String getZone() {
		if (schoolZone && workZone) {
			return "School & Work Zone";
		} else if (schoolZone) {
			return "School";
		} else if (workZone) {
			return "Work";
		}
		return "";
	}


	public String toString() {
		String ticketString = "Department of Motor Vehicles\r\n" + 
				"Automated Traffic Enforcement\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Dear %s,\r\n" + 
				"\r\n" + 
				"Please pay the following speeding fine of $%d.00 to the DMV within 10 days of\r\n" + 
				"receiving this notice to avoid a driver's license suspension. You are being fined for going %d MPH in a %d MPH %s zone\r\n" + 
				"\r\n" + 
				"Ticket Type: %s\r\n" + 
				"Ticket Number: %d\r\n" + 
				"\r\n" + 
				"Returned checks are subject to a returned check fee of $35.00\r\n" + 
				"\r\n" + 
				"Sincerely\r\n" + 
				"Taoheed King\r\n" + 
				"";
		double fine = calculateFine();
		String zone = getZone();
		String ticket = DetermineTicketType();
		int tickNum = generateTicketNum();
		String formatted = String.format(ticketString, name, fine, carSpeed, speedLimit, zone, ticket, tickNum);
		//Ticket String must include ticket number and ticket type
		return ticketString;
	}

	private int randomNumber(int min, int max) {
		return (min + (int) (Math.random() * ((max - min) + 1)));
	}

	private void getUserInput() {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	    
		System.out.println("Name: ");
	    name = scanner.nextLine();
	    
	    System.out.println("Speed: ");
	    carSpeed = scanner.nextInt();
	    
	    System.out.println("Speed Limit: ");
	    speedLimit = scanner.nextInt();
	    
	    System.out.println("School Zone: ");
	    schoolZone = scanner.nextBoolean();
	    
	    System.out.println("Work Zone: ");
	    workZone = scanner.nextBoolean();
	    
	    scanner.close();
	}
}
