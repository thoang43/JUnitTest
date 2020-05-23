
import java.util.Random;

//Ticket class
public class Ticket
{

    //Declare private variables
    private int driverspeed;
    private int SpeedLimit;
    private boolean SchlZone;
    private boolean WrkZone;
    private String Name;
    boolean flag=false;
    long TicketNumber;

    //Parameter constructor
    public Ticket(int Dspeed, int SpdLim,
                  boolean sZone, boolean WrkZone, String Nm)
    {
        this.driverspeed = Dspeed;
        this.SpeedLimit = SpdLim;
        this.SchlZone = sZone;
        this.WrkZone = WrkZone;
        this.Name = Nm;
    }
    //three parameter constructor
    public Ticket(int Spd, int SpdLim, String Nm)
    {
        this.driverspeed = Spd;
        this.SpeedLimit = SpdLim;
        this.Name = Nm;
        this.SchlZone = false;
        this.WrkZone = false;
    }
    //getter and setter methods
    public int Speedgetter() {
        return driverspeed;
    }
    public void Speedlimitsetter(int SpdLimit) {
        this.SpeedLimit = SpdLimit;
    }
    public int SpeedLimitGetter() {
        return SpeedLimit;
    }
    public void SpeedSetter(int Spd) {
        this.driverspeed = Spd;
    }
    public boolean SchoolZonetrue() {
        return SchlZone;
    }
    public void SchoolZoneSetter(boolean schoolZone) {
        this.SchlZone = schoolZone;
    }
    public boolean WorkZoneTrue() {
        return WrkZone;
    }
    public void WorkZoneSetter(boolean wrkZone) {
        this.WrkZone = wrkZone;
    }
    public String Namegetter() {
        return Name;
    }
    public void NameSetter(String Nm) {
        this.Name = Nm;
    }

    //Implement method to calculateFine()
    public double calculateFine()
    {
        int SpeedLimitPass=driverspeed- SpeedLimit;
        double TicketAmount=0.0;
        if(SpeedLimitPass>=1 && SpeedLimitPass<=10 )
        {
            TicketAmount+=140;

            if(SchlZone)
            {
                TicketAmount+=200 -140;
            }
            if(WrkZone)
            {
                TicketAmount+=250-140;
            }
            if(WrkZone && SchlZone){

                TicketAmount+=250-310;

            }
        }
        else if(SpeedLimitPass>=11 && SpeedLimitPass<=30 )
        {
            TicketAmount+=195;

            if(SchlZone)
            {
                TicketAmount+=300 -195;
            }
            if(WrkZone)
            {
                TicketAmount+=350-195;
            }
            if(WrkZone && SchlZone){

                TicketAmount+=350-455;

            }
        }
        else if(SpeedLimitPass>=31)
        {
            flag=true;
            if(SpeedLimitPass<=40)
                TicketAmount+=495;
            else
                TicketAmount+=600;
        }
        return TicketAmount;
    }

        //Method for printNotice
    public String printNotice()
    {
        String OutputMsg="";
        System.out.println(SchlZone);
        if(SchlZone)
        {
            OutputMsg+=" You are being fined \nfor going "+driverspeed+
                    " MPH in a "+ SpeedLimit +" MPH school zone";


        if(WrkZone)

            OutputMsg+=" and work zone.\n\n";
        }
        else
            {
            OutputMsg+=" You are being fined \nfor going "+driverspeed+
                    " MPH in a "+ SpeedLimit +" MPH zone.\n\n\n";
        }

        return "\t\t\t- Department of Motor Vehicles -\n"+
                "\t\t\t- Automated Traffic Enforcement -\n\n\n"+
                "Dear " + Name +",\n\n"+
                "Please pay the following speeding fine of $"+calculateFine()+
                    "0 to the DMV within 10 days of\n"+
                   "receiving this notice to avoid a driver’s license suspension."
                   +OutputMsg+
                   "\nTicket Type: "+ DetermineTicketType()+
                   "\nTicket Number: "+generateTicketNum()+
                   "\nReturned checks are subject to a returned check fee of $35.00."+
                   "\n\nSincerely,\nMichael Pontillo";
    }
    //random ticket number generator
    private long generateTicketNum()
    {
        Random ticknumgen = new Random();
        int a = ticknumgen.nextInt(999999) + 100000;
        return a;
    }

    //random court date generator
    private int generateCourtDate()
    {
        Random courtdategen = new Random();
        int a = courtdategen.nextInt(31) + 1;
        return a;
    }

    //Implement method ticketType
    private String DetermineTicketType()
    {
        return (flag==true) ? "Must Appear\nYou must appear at the County Court House on October " +generateCourtDate()+ ", 2018." : "Payable";
    }

    @Override
        //toString method
             public String toString() {
             return "Ticket Number: "+generateTicketNum()+
                "\n Date: October " +generateCourtDate()+ ", 2018\n" +
                " Ticket Type: "+ DetermineTicketType();

    }
}
