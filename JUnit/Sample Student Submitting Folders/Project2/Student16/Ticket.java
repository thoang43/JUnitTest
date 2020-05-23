/**


*/
import java.util.Random;
/**Declaring the private instance variables and public variables.
 
*/
public class Ticket {
	private String name ,ticketType;
	private int speed, speedZone;
	private boolean schoolZone,workZone;
	String zone;
	int ticketNumber,ticketNum;
	/**Creation of constructor 
	 *   Ticket
	 * 
	 */
	public Ticket(String ticketName,int actSpeed,int speedLim, boolean school, boolean work) {
		name=ticketName;
		speed=actSpeed;
		speedZone=speedLim;
		determineTicketType();
		this.setTicketNum(generateTicketNum());
		schoolZone= school;
		workZone=work;
		
	}
	/**Second Constructor Ticket
	 * 
	 * @param ticketName
	 * @param actSpeed
	 * @param speedLim
	 * 
	 */ 
	public Ticket(String ticketName, int actSpeed, int speedLim) {
		name=ticketName;
		speed=actSpeed;
		speedZone=speedLim;
		determineTicketType();
		this.setTicketNum(generateTicketNum());
		schoolZone= false;
		workZone=false;
		
		}
/** Calculates the fine for the ticket
 * @return Fine
 * 
 */
public double calculateFine() {
	double fine=0;
    /**check if speed is in range of 1 to 10 MPH*/
	int checkSpeed=speed-speedZone;
    if(checkSpeed>=1 && checkSpeed<=10)
    {
        fine=140;
        if(isSchoolZone() && isWorkZone())
            fine=250;
        else if(isSchoolZone())
            fine=200;
    }
    /**check if speed is in range of 11 to 20 MPH*/
    else if(checkSpeed>=11 && checkSpeed<=20)
    {
        fine=195;
        if(isSchoolZone()&& isWorkZone())
            fine=350;
        else if(isSchoolZone())
            fine=300;
    }
    /**check if speed is in range of 21 to 30 MPH*/
    else if(checkSpeed>=21 && checkSpeed<=30)
    {
        fine=450;
    }
    /**check if speed is in range of 31 and 40*/
    else if(checkSpeed>=31 && checkSpeed<=40)
    {
        fine=495;
    }
    /**check if speed is 40 or more*/
    else if(checkSpeed>=41)
    {
        fine=600;
    }  
    return fine;
}
/**
 * Deciding whether ticket is payable or must Appear
 * @return ticketType
 */
private String determineTicketType() {
	int appearSpeed= speed-speedZone;
	if(appearSpeed>=1 && appearSpeed<=30)
    
	return ticketType="PAYABLE";
else
    
	return ticketType="MUST APPEAR";
}
/**
 * Returns name
 * @return name
 */
public String getName() {
	return name;
}
/**Returns speed
 * @return speed
 *
 */
public int getSpeed() {
	return speed;
}
/** Returns the speed limits
 * @return speedZone
 * 
 */
public int getSpeedLimit() {
	return speedZone;
}
/**Returns the ticket number
 * @return ticketNumber
 * 
 */
public int getTicketNum() {
	return ticketNumber;
}
/**Returns the ticket type
 * @return ticketType
 *  
 */
public String getTicketType() {
	return ticketType;
}
/**Returns schoolZone as either true or false vice versa
 * 
 * @return schoolZone
 */
public boolean isSchoolZone() {
	return schoolZone;
}
/**returning workZone
 * 
 * 
 * @return workZone
 */
public boolean isWorkZone() {
	return workZone;
}
/**printNtoice
 * Displaying the notice to the user
 * 
 * @return printNotice
 */

public String printNotice() {
	String notice= "\nDepartment of Motor Vehicles\n"+
"Automated Traffic Enforcement\n\n"+
			"Dear "+getName()+",\n"
			+"\nPlease pay the following speeding fine of $"+calculateFine()+" to the DMV within 10 days of\n"
			+"receiving this notice to avoid a driver's license suspension. You are being fined\n"
			+"for going "+getSpeed()+" MPH in a "+ getSpeedLimit()+" MPH "+determineZone()+" zone.\n"+
			"\n\n"+toString();
	return notice;
}
/**
 * Setting name
 * 
 *@param 
 *
 */
public void setName(String ticketName) {
	name=ticketName;
	
}
/**school
 * setting schoolZone
 * 
 *@param 
 */
public void setSchoolZone(boolean school) {
	schoolZone=school;
}
/**actSpeed
 * setting speed
 * @param
 * 
 */
public void setSpeed(int actSpeed) {
	speed=actSpeed;
}
/**speedLim
 * setting speedZone
 * 
 *@param
 */
public void setSpeedLimit(int speedLim) {
	speedZone=speedLim;
}
/**ticketNum
 * setting ticketNumber
 * 
 * @param
 */
public void setTicketNum(int ticketNum) {
	 ticketNumber=ticketNum;
}
/** work
 * setting workZone
 * 
 * @param
 */
public void setWorkZone(boolean work) {
	workZone=work;
}
/**returning value of zone
 * 
 * @return zone
 * 
 */
public String determineZone() {
	if (workZone==true)
		return zone="work";
	else
		return zone="school";
}
/**
 * Display of ticket type, court date and writer's name
 * @return court
 */
public String toString() {
	String court;
	if(ticketType=="PAYABLE")
		court="Ticket Type : PAYABLE\n"
		+"Ticket Number: "+getTicketNum()+"\n\nReturned checks are subject to a returned check fee of $35.00.\n"+
				"\nSincerely,\nJonathan Merino";
	else
		court="Ticket Type : MUST APPEAR\n"
				+"Ticket Number: "+getTicketNum()+"\nYou must appear at the County Court House on "+generateCourtDate()
						+ "\n\nReturned checks are subject to a returned check fee of $35.00.\n"+
						"\nSincerely,\nJonathan Merino";

return court;
}	
/**returning ticket number
 * 
 * @return ticketNum
 * 
 */
private int generateTicketNum(){
	Random gen = new Random();
    ticketNum = gen.nextInt(899999) + 100000;//100000 to 999999
    return ticketNum;
}
/**Returning court date as string
 * 
 * @return
 * courtDay
 */
private String generateCourtDate() {
	int courtDay=(int)(Math.random()*31+1);
    return String.format("%d October 2019",courtDay);
}

}
