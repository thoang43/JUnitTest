import java.util.Random;
import java.text.DecimalFormat;

public class Ticket {
  
   // declaration of variables
   private String name, ticketType = "PAYABLE";
   private int speed, speedLimit, ticketNum;
   private boolean schoolZone = false, workZone = false;
   private int courtDate;
   private final String MY_NAME = "Zarish Akbar";
  

/** constructor creates Ticket with school/work zone
*
* @param n name
* @param s speed
* @param sl speed limit
* @param sz school zone
* @param wz work zone
*/

public Ticket(String n, int s, int sl, boolean sz, boolean wz) {
   name = n;
   speed = s;
   speedLimit = sl;
   schoolZone = sz;
   workZone = wz;
}

/** constructor creates Ticket without school/work zone
*
* @param n name
* @param s speed
* @param sl speed limit
*/

public Ticket(String n, int s, int sl) {
   name = n;
   speed = s;
   speedLimit = sl;
}

/** set driver's name
*
* @param n name
*/

public void setName(String n) {
   name = n;
}

/** set driver's speed
*
* @param s speed
*/

public void setSpeed(int s) {
   speed = s;
}

/** set speed limit
*
* @param sl speed limit
*/

public void setSpeedLimit(int sl) {
   speedLimit = sl;
}

/** indicates whether violation occurred in school zone
*
* @param sz sets True if violation occurred in school zone
*/

public void setSchoolZone(boolean sz) {
   schoolZone = sz;
}

/** indicates whether violation occurred in work zone
*
* @param wz sets True if violation occurred in work zone
*/

public void setWorkZone(boolean wz) {
   workZone = wz;
}

/** method calculates the amount of the fine, based on the speed the driver was going at,
* and if the violation occurred in a school/work zone.
*
* @return returns the fine
*/

public double calculateFine() {
   double fine = 0.0;

   // validates inputs and calls to printNotice()
   if(!inputValidation()) {
       return 0.000000000;
   }
  
   else {
  
       if((speed - speedLimit >= 1) && (speed - speedLimit <= 10)) {
           fine = 140.00;
           if(schoolZone) fine += 60.00;
           if(workZone) fine += 110.00;
           ticketType = "PAYABLE";
       }
      
       else if((speed - speedLimit >= 11) && (speed - speedLimit <= 20)) {
           fine = 195.00;
           if(schoolZone) fine += 105.00;
           if(workZone) fine += 155.00;
           ticketType = "PAYABLE";
       }

       else if((speed - speedLimit >= 21) && (speed - speedLimit <= 30)) {
           fine = 450.00;
           ticketType = "PAYABLE";
       }
      
       else if(speed - speedLimit > 30) {
           if (speed - speedLimit <= 40) 
        	   fine = 495.00;
           else fine = 600.00;
           ticketType ="MUST APPEAR";
       }
      
       else {
           fine = 9999999999999.87;
           System.out.print("Error in method generateFine().");
       }
  
   }

   return fine;
  
}

/** method generates notice and returns information from calculateFine() and getTicketType() methods
*
* @return returns print String
*/

public String printNotice() {
   DecimalFormat df = new DecimalFormat("0.00");

   if(calculateFine() == 0.00) {
       String errorString = "There is an error in your data. "
                       + "Please try again.\n"
                       + "Speed and speed limit have to be greater than zero.\n"
                       + "The speed limit should be no greater than 80 miles per hour. \n"
                       + "The speed should be greater than the speed limit.";
      
       return errorString;
   }
  
   else {
       String notice = ("Department of Motor Vehicles\n"
               + "Automatic Traffic Enforcement \n\n\n"
               + "Dear " + name + ",\n\n"
               + "Please pay the following fine of $" + df.format(calculateFine()) + " to the DMV "
               + "within 10 days of \nreceiving this notice to avoid a driver's license "
               + "suspension.\nYou are being fined for going " + speed + " MPH in a "
               + speedLimit + " MPH"+ (workZone?" work":"") + (workZone && schoolZone?" and":"")
               + (schoolZone?" school":"") + " zone."
               + "\n\n" + "Ticket Type: " + getTicketType() + "\n"
               + DetermineTicketType() + "\n" + "Ticket Number: " + generateTicketNum() + "\n\n"
               + "Returned checks are subject to a returned check fee of $35.00.\n\n"
               + "Sincerely,\n" + MY_NAME);
       return notice;
   }
}

/** method returns ticket number
*
* @return returns ticket number
*/

public int getTicketNum() {
   return ticketNum;
}

/** method returns the type of ticket as a String
*
* @return returns ticket type
*/

public String getTicketType() {
   return ticketType;
}

/** method returns the name of the driver as a String
*
* @return returns name
*/

public String getName() {
   return name;
}

/** method returns the speed of the driver
*
* @return returns speed
*/

public int getSpeed() {
   return speed;
}

/** method returns the speed limit
*
* @return returns the speed limit
*/

public int getSpeedLimit() {
   return speedLimit;
}

/** method returns whether violation took place in a school zone
*
* @return returns true if violation was in school zone
*/

public boolean isSchoolZone() {
   return schoolZone;
}

/** method returns whether violation took place in a work zone
*
* @return returns true if violation was in work zone
*/

public boolean isWorkZone() {
   return workZone;
}

/** method randomly generates ticket number
*
* @return returns ticket number as an integer
*/

private int generateTicketNum() {
   Random rand = new Random();
  
   int num = rand.nextInt(899999) + 100000;
   ticketNum = num;
   return num;
}

/** method generates court date as a random date in October
*
* @return returns court date
*/

private int generateCourtDate() {
   Random rand = new Random();
   courtDate = rand.nextInt(30) + 1;
   return courtDate;
}

/** method makes a string
*
* @return returns String of the ticket notice
*/

public String toString() {
   String string = printNotice();
   return string;
}

/** method tests ticket type and generates a court date for MUST APPEAR tickets.
* 
* @return returns an empty string if condition doesn't apply
*/

private String DetermineTicketType() {
   if(ticketType.equals("")) return ("ERROR null ticket type\n");
   if(ticketType.equals("MUST APPEAR")){ return "You must appear at the County Court House on 10/"
                                           + generateCourtDate() + "/2018\n";
   }
   else return "";

}

/** method to validate user input (speed and speed limit greater than zero, speed greater than
* speed limit, and speed limit less than or equal to 80 MPH)
* 
* @return returns True if input is valid
*/

private boolean inputValidation() {
   if (speed <= 0 || speedLimit <= 0) return false;
   else if (speed <= speedLimit) return false;
   else if (speedLimit > 80) return false;
   else return true;
}

}