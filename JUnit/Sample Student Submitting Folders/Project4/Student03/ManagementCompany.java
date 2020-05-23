/**
 * Represents management company object
 * 
 * 
 *
 */
public class ManagementCompany {
	
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	
	
	private Property[] propertyArray = new Property[MAX_PROPERTY];
	
	private String name;
	private String taxID;
	private double mgmFee;
	private Plot plot;
	

	/**
	 * No-arg Constructor creates a ManagementCompany object with default values for ManagementCompany object: 
	 * name,tax ID set to empty strings
	 * management fee to 0
	 * management Plot set to x =0 , y=0 , width =MGMT_WIDTH, depth = MGMT_DEPTH
	 */
	public ManagementCompany() {
		
		name = "";
		taxID = "";
		mgmFee = 0;
		
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed informations. 
	 * Management plot is set to a plot with x,y coordinates set to 0 and width and depth 
	 * set to GMT_WIDTH and MGMT_DEPTH.
	 * 
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 * @param x x coordinate of the management plot
	 * @param y  y coordinate of the management plot
	 * @param width width of the management plot
	 * @param depth depth of the management plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Creates a ManagementCompany object using the passed informations.
	 * Management plot is set to a plot with x,y coordinates set to 0 and width and depth set to GMT_WIDTH and MGMT_DEPTH.
	 * 
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee  management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);	
	}
	
	/**
	 * Return the MAX_PROPERTY constant that represent the size of the array of Properties.
	 * 
	 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
	 */
	public int getMAX_PROPERTY() {
		
		return MAX_PROPERTY;
	}

	/**
	 * returns the name of the management company
	 * 
	 * @return the name of the management company
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * a reference to the plot of the management company.
	 * 
	 * @return the plot of the management company
	 */
	public Plot getPlot() {
		
		return plot;
	}
	
	/**
	 * adds a Property object to the array of properties.
	 * 
	 * @param p a property object
	 * @return -1 if the array is full, -2 if the property is null,-3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.
	 */
	public int addProperty(Property p) {
		
		if (p == null) {
			
			return -2;
		}
		
		return propertyCheck(p);
	}
	
	/**
	 * adds a Property object to the array of properties.
	 * 
	 * @param name name of the property
	 * @param city city of the property
	 * @param rent property's rent amount
	 * @param owner property's owner
	 * @return -1 if the array is full, -2 if the property is null,-3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.


	 */
	public int addProperty(String name, String city, double rent, String owner) {
		
		Property p = new Property(name, city, rent, owner);
		
		return propertyCheck(p);
		
	}
	
	/**
	 * adds a Property object to the array of properties.
	 * 
	 * @param name name of the property
	 * @param city city of the property
	 * @param rent property's rent amount
	 * @param owner property's owner
	 * @param x x coordinate of the property's plot
	 * @param y y coordinate of the property's plot
	 * @param width width of the property's plot
	 * @param depth of the property's plot
	 * @return -1 if the array is full, -2 if the property is null,-3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		
		Property p = new Property(name, city, rent, owner, x, y, width, depth);
		
		return propertyCheck(p);
	}
	
	/**
	 * Accesses each "Property" object stored in the array of 
	 * Property and sums up the properties rent and returns the total amount.
	 * 
	 * @return total rent of the properties
	 */
	public double totalRent() {
		
		double totalRent = 0;
		
		for (int i = 0; i < propertyArray.length; i++) {
			
			if (propertyArray[i] != null) {
				totalRent += propertyArray[i].getRentAmount();
			}
		}
		
		return totalRent;
	}
	
	/**
	 * Returns the toString of the property that has the maximum rent of all properties managed by the ManagementCompany 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * 
	 * @return String that is the toString of the max-rent property
	 */
	public String maxRentPropInfo() {
		
		return propertyArray[maxPropertyIndex()].toString();
	}
	
	/**
	 * Displays the information of all the properties stored in the array of Properties
	 * 
	 * @return information of ALL the properties within this management company by accessing the array of Properties The format is as following example:
	 * list of the properties for Alliance ,taxID: 1235 
	 */
	public String toString() {
		
		String mgmtCoString = "";
		double totalMgmtFee = (this.totalRent() * (this.mgmFee / 100));
		
		
		
		mgmtCoString += "List of the properties for " + name + ", taxID: " + taxID + "\n" +
						"____________________________________________________________________________________________\n";
		
		for (int i = 0; i < propertyArray.length; i++) {
			
			if (propertyArray[i] != null) {
				mgmtCoString += (propertyArray[i].toString() + "\n");
				
			}
			
		}
		mgmtCoString += "____________________________________________________________________________________________\n";
		mgmtCoString += ("\ntotal management Fee: " + totalMgmtFee);
		
		return mgmtCoString;
	}
	
	/**
	 * Returns the index of the propertyArrray element with the highest rent
	 * 
	 * @return propertyArray index
	 */
	private int maxPropertyIndex() {
		
		double maxRent = 0;
		int maxPropertyIndex = 0;
		
		for (int i = 0; i < propertyArray.length; i++)
			if (propertyArray[i] != null) {
					
				if (propertyArray[i].getRentAmount() > maxRent) {
			
					maxRent = propertyArray[i].getRentAmount();
					maxPropertyIndex = i;
				}
			}
		
		return maxPropertyIndex;
	}
	
	/**
	 * Checks to see if the property can be added 
	 * 
	 * @param p property to check
	 * @return If property is added successfully, it's index in propertyArray. If unsuccessful, return a negative integer as described in the addProperty method 
	 */
	private int propertyCheck(Property p) {
		
		if (!(this.plot.encompasses(p.getPlot()))) {
			
			return -3;
		}
		
		for (int i = 0; i < propertyArray.length; i++) {
			
			if (propertyArray[i] == null) {
				
				for (int j = 0; j < i; j++) {
					
					if (p.getPlot().overlaps(propertyArray[j].getPlot())) {
		
						return -4;
					}
				}
				
				propertyArray[i] = p;
				return i;
			}
			
		}
		
		return -1;
	}
	
}