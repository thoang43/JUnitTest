import java.util.Random;

/**
 * 
 * Assignment 2 - Trafficking Ticket
 * CMSC 203
 * Professor Alla Webb
 * This class generates a TIcket based on the information provided by the 
 * user. 
 */
public class Ticket
{
   /**
    * speed - speed of the driver
    * speedLimit - speed limit in a certain location
    * schoolZone - The driver is driving near a school
    * workZone - The driver is driving near a work zone]
    * name - Name of the driver
    * courtAppearFlag - Whether the driver needs to appear in court or not
    */
   private int speed;
   private int speedLimit;
   private boolean schoolZone;
   private boolean workZone;
   private String name;
   boolean courtAppearFlag=false;


   /**
    * Constructor with 5 parameters to store driver's name, the speed driven, the
    * speed limit, school zone, and work zone
    * @param name
    * @param speed
    * @param speedLimit
    * @param schoolZone
    * @param workZone
    */
   public Ticket(String name, int speed, int speedLimit,
           boolean schoolZone, boolean workZone)
   {
       this.speed = speed;
       this.speedLimit = speedLimit;
       this.schoolZone = schoolZone;
       this.workZone = workZone;
       this.name = name;
   }
   
   /**
    * Constructor with 3 parameters to store the driver's name, speed driven, and
    * the speed limit
    * @param name
    * @param speed
    * @param speedLimit
    */
   public Ticket(String name, int speed, int speedLimit)
   {
       this.speed = speed;
       this.speedLimit = speedLimit;
       this.name = name;
       this.schoolZone = false;
       this.workZone = false;
   }
   //getter and setter methods
   /**
    * Gets the speed of the driver
    * @return speed
    */
   public int getSpeed() {
       return speed;
   }
   /**
    * Set the speed of the driver
    * @param speed
    */
   public void setSpeed(int speed) {
       this.speed = speed;
   }
   /**
    * Returns the speed limit of an area
    * @return speedLimit
    */
   public int getSpeedLimit() {
       return speedLimit;
   }
   /**
    * Sets the speed limit of an area
    * @param speedLimit
    */
   public void setSpeedLimit(int speedLimit) {
       this.speedLimit = speedLimit;
   }
   /**
    * Determines whether an area is a school zone or not
    * @return schoolZone
    */
   public boolean isSchoolZone() {
       return schoolZone;
   }
   /**
    * Sets an area as a school zone
    * @param schoolZone
    */
   public void setSchoolZone(boolean schoolZone) {
       this.schoolZone = schoolZone;
   }
   /**
    * Determines whether an area is a work zone or not
    * @return workZone
    */
   public boolean isWorkZone() {
       return workZone;
   }
   /**
    * Sets an area as a work zone
    * @param workZone
    */
   public void setWorkZone(boolean workZone) {
       this.workZone = workZone;
   }
   /**
    * Gets the name of the driver
    * @return name
    */
   public String getName() {
       return name;
   }
   /**
    * Sets the name of the driver
    * @param name
    */
   public void setName(String name) {
       this.name = name;
   }
   /**
    * Gets the ticket type of the notice issued
    * @return String
    */
   public String getTicketType() {
	   return determineTicketType();
   }

  
   /**
    * Calculates the fine based on the table
    * @return ticketFine
    */
   public double calculateFine()
   {
       int overLimit = speed - speedLimit;
       double ticketFine =  0.0;
       if(overLimit >= 1 && overLimit <= 10 )
       {      
           ticketFine = 140;
          
           if(schoolZone)
           {
               ticketFine = 200;
           }
           if(workZone)
           {
               ticketFine = 250;
           }          
       }
       else if(overLimit >= 11 && overLimit <= 20 )
       {
          
           if(overLimit >= 11)
           {
               ticketFine = 195;
           }
           if(schoolZone)
           {
               ticketFine = 300;
           }
           if(workZone)
           {
               ticketFine = 350;
           }
       }
       else if(overLimit >= 21 && overLimit <= 30) {
    	   
    	   ticketFine = 450;
       }
       
       else if(overLimit >= 31 && overLimit <= 40)
       {
           courtAppearFlag=true;
           ticketFine = 495;
       }
       else if(overLimit >= 41) {
    	   
    	   courtAppearFlag = true;
    	   ticketFine = 600;
       }
       return ticketFine;
   }
  
   /**
    * Displays the information of a ticket
    * @return String
    */
   public String printNotice()
   {  
       String text=" You are being fined for going " + speed+ 
    		   " MPH in a " + speedLimit+ " MPH zone.\n";
       
       if(schoolZone)
       {
           text =" You are being fined \nfor going "+speed+
                   " MPH in a "+speedLimit+" MPH school zone\n";
       }
       if(workZone)
       {
           text = " You are being fined \nfor going "+speed+
                   " MPH in a "+speedLimit+" MPH work zone.\n";
       }
       return "\n\nDepartment of Motor Vehicles\n"+
       "Automated Traffic Enforcement\n"+
       "\nDear " +name+",\n"+
       "\nPlease pay the following speeding fine of $"+calculateFine()+
       " to the DMV within 10 days of\n"+
       "receiving this notice to avoid a driver’s license suspension."
       +text+
       "\nTicket Type: "+determineTicketType()+
       "\nYou must appear at the County Court House on October "+generateCourtDate()+
       ", 2019"+
       "\nTicket Number: "+generateTicketNum()+ "\n" +
       "\nReturned checks are subject to a returned check fee of $35.00.\n"+
       "\nSincerely, "
       + "\nRohin Sharma";
   }
   /**
    * Generates a random number 100000 - 999999 for a ticket number
    * @return int
    */
   private int generateTicketNum()
   {
	   return (int)(Math.random()*999999 + 100000);
   }

   /**
    * Generates a court date for the violator
    * @return int
    */
   private int generateCourtDate()
   {
       return (int)(Math.random()*31) + 1;
   }

   /**
    * Determines the ticket type of whether it's payable or requires to appear
    * in court
    * @return String
    */
   private String determineTicketType()
   {
       return (courtAppearFlag==true) ? "MUST APPEAR" : "PAYABLE";
   }

   @Override
   /**
    * Generates a String of the ticket information
    * @return String
    */
   public String toString() {
       return "Ticket Number: "+generateTicketNum()+
               " Date: October" + generateCourtDate() + ", 2019"+
               " Ticket Type: "+determineTicketType();

   }
}

