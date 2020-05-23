
/**
 *
 * 
 *
 */

public class ManagementCompany {
    private String name;
    private String taxID;
    private double managementFee;
    private final int MAX_PROPERTY=5;
    private final int MGMT_WIDTH=10;
    private final int MGMT_DEPTH=10;
    private Plot managementPlot;
    private Property [] properties;
    private int index=0;

    /** Default Constructor initialize name,taxId to empty strings Management fee to 0 
     *
     */

    ManagementCompany(){
        this.name="";
        this.taxID="";
        this.managementFee=0;
        properties= new Property[MAX_PROPERTY];
        this.managementPlot=new Plot(0,0,MGMT_DEPTH,MGMT_WIDTH);//Setting the managementPlot 
    }



    /**Initialize fields to passes in parameters,Create the management plot as well as the properties object Array set to MAX_PROPERTY
     *
     * @param name
     * @param taxID
     * @param managementFee
     */

    ManagementCompany(String name,String taxID,double managementFee){
        this.name=name;
        this.taxID=taxID;
        this.managementFee=managementFee;
        properties= new Property[MAX_PROPERTY];
       
        this.managementPlot=new Plot(0,0,MGMT_DEPTH,MGMT_WIDTH);//Setting the management plot again

    }



    /**Initialize fields to passes in parameters,Create the user plot with the passed in arguments as well as the properties object Array set to MAX_PROPERTY
     *
     * @param name
     * @param taxID
     * @param managementFee
     * @param x
     * @param y
     * @param width
     * @param depth
     */

    ManagementCompany(String name, String taxID,double managementFee,int x, int y, int width, int depth){
        this.name=name;
        this.taxID=taxID;
        this.managementFee=managementFee;
        properties= new Property[MAX_PROPERTY];
        this.managementPlot= new Plot(x,y,width,depth);//Creating new plot with the passed in parameters
    }



    /**Calling for items from the copy constructor from Property Class.adds a Property object to the array of properties.
     *
     * @param p
     * @return 1 if the array is full, -2 if the property is null,-3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.
     */

    public int addProperty(Property property) {

        for(int i=0;i<index;i++) {
            if(property.getPlot().overlaps(properties[i].getPlot())) { //Checks if the plots overlap 
                return -4;
            }
        }

        if(property==null) {//Checks if property is null
            return -2;
        }

        if(index>=MAX_PROPERTY) {//Sees if the Array is now full and can't take anymore properties
            return -1;
        }


        if(!this.managementPlot.encompasses(property.getPlot())) { //Checks if the property is within the management property
            return -3;
        }

        properties[index]=property;//Adds property to the array at specific index
        return index++;//Returns index then adds one
    }




    /**Accepts 4 parameters. Calls onto the addProperty method passing an object
     *
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @return -1 if the array is full, -2 if the property is null,-3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.
     */

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name,city,rent,owner)); //Returns the correct index and calls onto the 
    }





    /** adds a Property object to the array of properties. Accepts 8 parameters
     *
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @param x
     * @param y
     * @param width
     * @param depth
     * @return -1 if the array is full, -2 if the property is null,-3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.
     */

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name,city,rent,owner,x,y,width,depth));//Creates a new property object that then is 
        //Sent into addProperty(p) using the copy constructor
    }



    /**
     *
     * @return MAX Property
     */

    public int getMAX_PROPERTY() {

        return MAX_PROPERTY;

    }

    /**Returns the name for Company
     *
     * @return the name
     */
    public void setName(String name) {
        this.name=name;
    }
    
    
/**Returns the name of the company
 * 
 * 
 * @return Returns the name of the company 
 */
    public String getName() {

        return this.name;

    }
    
    
/**Sets the company Tax ID number
 * 
 * @param taxID
 */
    public void setID(String taxID) {
        this.taxID=taxID;
    }
    
    
/**Returns the company taxID Number
 * 
 * @return
 */
    public String getID() {
        return this.taxID;
    }

    /**Sets the management fee
     * 
     * @param managementFee
     */
    public void setManagementFee(double managementFee) {

        this.managementFee=managementFee;
    }
/**Returns the management fee divided by 100 to make it a percentage
 * 
 * @return
 */
    public double getManagementFee() {
        return this.managementFee/100;
    }

    /**Calculates the total management fee cost 
     * 
     * @return
     */
    public double calcTotalManageFee() {
        double totalFee=0;

        for(int i=0;i<index;i++) {
            totalFee+= properties[i].getRentAmount()*getManagementFee();//Multiplies every rent amount by the percentage 
        }

        return totalFee;

    }

    /**Returns the plot
     *
     * @return plot
     */

    public Plot getPlot() {

        return this.managementPlot;

    }

    /**
     *
     * @return rentInfo which represents the location of the property with the highest rent in the Lab
     */

    private int maxPropertyIndex() {

        int rentInfo=0;
        for(int i=0;i<index;i++) {
            if(properties[i]!=null) { //Making sure the property isn't null
                if(properties[rentInfo].getRentAmount()<properties[i].getRentAmount()) {
                    rentInfo=i;
                }

            }

        }



        return rentInfo;//Returns the index of the highest rent amount 

    }



    /**Since maxPropertyIndex was private a getter method is used
     *
     * @return value from maxPropertyIndex
     */

    public int getMaxProp() {

        return maxPropertyIndex();

    }

    /**
     *
     * @return String version of the property with the highest rent
     */

    public String maxRentPropInfo() {

        String info="";

        for(int i=0;i<index;i++)

            if(properties[i]!=null) {

                if(getMaxProp()==0) { //Test

                    System.out.print("INCORRECT\n");

                }

                info=properties[getMaxProp()].toString();//Displays the toString at the correct index

            }

        return info;

    }





    /**Returns the string version of the property's info
     *
     */

    public String toString() {
        String outs="";
        for(int i=0;i<index;i++)//Goes through the size of the array
            outs+=properties[i].toString();//Acquires every property toString

        return"List of the properties for "+getName()+", Tax ID: "+getID()+

                "\n_____________________________________\n"+ outs+"\n\n_______________________________\n"+"total management Fee: "
                + calcTotalManageFee();//Displays the calculated fee



    }



    /**Calculates the total rent for all properties
     *
     * @return totalRent
     */

    public double totalRent() {
        double totalRent=0.0;

        for(int i=0;i<index;i++) {
            totalRent=totalRent+properties[i].getRentAmount();//Adds all the properties rent amounts together
            }
        return totalRent;

    }


}