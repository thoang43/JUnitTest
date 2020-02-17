/**
 * The ManagementCompany class takes input, operates on the data structure,
 * returns values, and sets variables.
 * 
 *
 */
public class ManagementCompany {

	//Instance variables
	String 		name;
	String 		taxID;
	double 		mgmFee;
	final int 	MAX_PROPERTY=5;
	Property[] 	listOfProperties;
	final int 	MGMT_WIDTH=10;
	final int 	MGMT_DEPTH=10;
	Plot 		mgmPlot;
	int			x;
	int			y;
	int			width;
	int			depth;
	
	
	//Constructors
	
	/**
	 * No arg constructor - default management company values
	 */
	public ManagementCompany() {
		this.name="";
		this.taxID="";
		this.mgmFee=0;
		this.mgmPlot= new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.listOfProperties = new Property[MAX_PROPERTY];
		this.x=0;
		this.y=0;
		this.width=0;
		this.depth=0;
	}
	
	/**
	 * Set name, tax ID, and management fee values to passed arguments
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFee=mgmFee;
		this.mgmPlot= new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.listOfProperties = new Property[MAX_PROPERTY];
		this.x=0;
		this.y=0;
		this.width=0;
		this.depth=0;
	}
	
	/**
	 * Set name, tax ID, management fee, x coordinate, y coordinate, 
	 * width, and depth values to passed arguments
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFee=mgmFee;
		this.mgmPlot= new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.listOfProperties = new Property[MAX_PROPERTY];
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	
	//Methods
	
	/**
	 * Add property passed as argument to property array or return error if
	 * property overlaps another property, isn't encompassed by the management plot, 
	 * or the property array is full
	 * @param property
	 * @return index of property added to array or error code
	 */
	public int addProperty(Property p) {
		int index=0;
		boolean fullArray=true;
		
		if (p==null) {
			index=-2;
			return index;
		}
		
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]==null) {
				fullArray=false;

			}
		}
		
		if (fullArray==true) {
			index=-1;
			return index;
		}
		
		if(this.mgmPlot.encompasses(p.getPlot())==false){
			index=-3;
			return index;
		}
		
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]!=null) {
				if (this.listOfProperties[i].getPlot().overlaps(p.getPlot())==true) {
					index=-4;
					return index;
				}
			}
		}
		
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]==null) {
				listOfProperties[i]=p;
				index=i;
				return index;
			}
		}

		return index;
		
	}
	
	/**
	 * Add property with name, city, rent amount, and owner name passed as arguments to 
	 * property array or return error if property overlaps another property, isn't encompassed  
	 * by the management plot, or the property array is full
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @return index of property added to array or error code
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		int index;
		Property p = new Property(propertyName, city, rent, ownerName);
		
		index=addProperty(p);
		
		return index;
	}
	
	/**
	 * Add property with name, city, rent amount, owner name, x coordinate, y coordinate, width,  
	 * and depth passed as arguments to property array or return error if property overlaps another   
	 * property, isn't encompassed by the management plot, or the property array is full
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return index of property added to array or error code
	 */
	
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
		int index;
		Property p = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		index=addProperty(p);
		
		return index;
	}
	
	/**
	 * Calculate total rent amount from all properties in array
	 * @return total rent amount
	 */
	public double totalRent() {
		double total=0;
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]!=null) {
				total+=listOfProperties[i].getRentAmount();
			}
		}
		return total;
	}
	
	/**
	 * Return string output of property with highest rent amount
	 * @return string output
	 */
	public String maxRentPropInfo() {
		return listOfProperties[maxPropertyIndex()].toString();
	}
	
	/**
	 * Return index of property with highest rent amount
	 * @return index
	 */
	private int maxPropertyIndex() {
		double maxRentAmount=0;
		int index=0;
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]!=null) {
				if (listOfProperties[i].getRentAmount()>maxRentAmount) {
					maxRentAmount=listOfProperties[i].getRentAmount();
					index=i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Calculate management fee for a property based on set percentage of rent amount
	 * @param rentAmt
	 * @param percent
	 * @return management fee
	 */
	public double calcMgmFee(double rentAmt, double percent) {
		double total;
		total=rentAmt*(percent/100);
		return total;
	}
	
	/**
	 * Calculate total management fee for all properties in array based on
	 * set percentage of rent amount for each property
	 * @return total management fee
	 */
	public double totalMgmFee() {
		double total=0;
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]!=null) {
				total += calcMgmFee(listOfProperties[i].getRentAmount(), mgmFee);
			}
		}
		return total;
	}
	
	/**
	 * Getter for maximum number of properties that can be held in the properties array
	 * @return maximum number of properties in array
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * Getter for name of management company
	 * @return management company name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for management plot
	 * @return management plot
	 */
	public Plot getPlot() {
		return mgmPlot;
	}
	

	/**
	 * String output of management company information (name, tax ID) and
	 * list of all properties under the company (property name, location, owner name, rent amount)
	 * @return string output
	 */
	public String toString() {
		String properties = "List of the properties for " + name + 
							" ,taxID: " + taxID + 
							"\n------------------------------------";
		for (int i=0; i<MAX_PROPERTY; i++) {
			if (listOfProperties[i]!=null) {
			properties+= "\nProperty Name: " + listOfProperties[i].getPropertyName() +  
					     "\nLocated in " + listOfProperties[i].getCity() +
					     "\nBelonging to: " + listOfProperties[i].getOwner() + 
					     "\nRent Amount: " + listOfProperties[i].getRentAmount();
			}
		}
		properties += "\n------------------------------------" +
					  "\ntotal management Fee: " + totalMgmFee();
		return properties;
	}
}
