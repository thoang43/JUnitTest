/**
 * The ManagementCompany class represents a Management Company
 * that manages various properties within its plot of land.
 * 
 * 
 * CMSC 203
 * 10/26/2019
 *
 */
public class ManagementCompany {

	
	/////////////////////// MANAGEMENT COMPANY FIELDS ///////////////////////
	
	private String name;						// Name of the management company
	private String taxID;						// Management company's tax ID
	
	private double mgmFee;						// Management company's fee for managing a property

	private int x;								// X coordinate of top left corner of a property
	private int y;								// Y coordinate of top left corner of a property
	private int width;							// The width of a property
	private int depth;							// The depth of a property
	private final int MAX_PROPERTY = 5;			// The maximum number of properties a management company can manage
	private final int MGMT_WIDTH = 10;			// The width of the management company's plot
	private final int MGMT_DEPTH = 10;			// The depth of the management company's plot

	private Property[] propArr;					// An array of the properties managed by the management company
	private Plot plot;							// The plot belonging to the management company
	
    //////////////////////////// CONSTRUCTORS ///////////////////////////////
	
	/**
	 *  No-argument constructor that assigns default values to
	 *  all fields and initializes the Property array
	 *  as well as the Plot dimensions.
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0;
		x = 0;
		y = 0; 
		width = MGMT_WIDTH;
		depth = MGMT_DEPTH;
		plot = new Plot(x, y, width, depth);
		propArr = new Property[MAX_PROPERTY];
	}
	/**
	 * This constructor accepts values for the company's name, tax ID,
	 * management fee, and the dimensions of the plot of land they manage.
	 * The company's plot of land is initialized using the parameters x, y,
	 * width, and depth. The propArr is initialized with the MAX_PROPERTY
	 * amount of 5.
	 * @param cName The name of the management company.
	 * @param tID The tax ID of the management company.
	 * @param mgmFee The management company's managing fee.
	 * @param x The x coordinate of the top left corner of the company's plot.
	 * @param y The y coordinate of the top left corner of the company's plot.
	 * @param w The width of the company's plot.
	 * @param d The depth of the company's plot.
	 */
	public ManagementCompany(String cName, String tID, double mgmtFee, 
									int xCoord, int yCoord, int w, int d) {
		name = cName;
		taxID = tID;
		mgmFee = mgmtFee;
		x = xCoord;
		y = yCoord;
		width = w;
		depth = d;
		plot = new Plot(x, y, width, depth);
		propArr = new Property[MAX_PROPERTY];
	}
	/**
	 * This constructor accepts values for the company's name, tax ID,
	 * and management fee. All other fields are initialized to default
	 * values of 0 or MGMT_WIDTH/MGMT_DEPTH.
	 * @param cName
	 * @param tID
	 * @param mgmtFee
	 */
	public ManagementCompany(String cName, String tID, double mgmtFee) {
		name = cName;
		taxID = tID;
		mgmFee = mgmtFee;
		x = 0;
		y = 0;
		width = MGMT_WIDTH;
		depth = MGMT_DEPTH;
		plot = new Plot(x, y, width, depth);
		propArr = new Property[MAX_PROPERTY];
	}

	
	////////////////////////////// GETTERS //////////////////////////////////
	
	/**
	 * Returns the name of the management company.
	 * @return Returns the name of the management company.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the taxID of the management company.
	 * @return Returns the taxID of the management company.
	 */
	public String taxID() {
		return taxID;
	}
	/**
	 * Returns the management fee as a percentage.
	 * @return Returns the management fee as a percentage.
	 */
	public double getMgmFee() {
		return mgmFee;
	}
	/**
	 * Returns the x coordinate of the top left corner of the management plot.
	 * @return Returns the x coordinate of the top left corner
	 * 			of the management plot.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Returns the y coordinate of the top left corner of the management plot.
	 * @return Returns the y coordinate of the top left corner
	 * 			of the management plot.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Returns the width of the management plot.
	 * @return Returns the width of the management plot.
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Returns the depth of the management plot.
	 * @return Returns the depth of the management plot.
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * Returns the maximum properties allowed within a single 
	 * management company.
	 * @return Returns the max properties that can be managed by a company.
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	/**
	 * Returns the default value for the management plot's width.
	 * @return Returns the default value for the management plot's width.
	 */
	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}
	/**
	 * Returns the default value for the management plot's depth.
	 * @return Returns the default value for the management plot's depth.
	 */
	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}
	/**
	 * Returns the reference variable for the property array.
	 * @return Returns a reference variable for the property array.
	 */
	public Property[] getArr() { 
		return propArr;
	}
	/**
	 * Returns the plot of the management company.
	 * @return Returns the plot of the management company.
	 */
	public Plot getPlot() {
		return plot;
	}

	
	////////////////////////////// METHODS ////////////////////////////////// 
	
	/** 
	 * This overloaded function creates a copy of the Property
	 * object that is passed to the function, then adds the copy
	 * to the propArr array of the management company.
	 * @param prop A property to be added to the management company's plot.
	 * @return Returns the index value of the propArr array where the property
	 * 			was stored. 
	 * 			Returns -1 if the propArr array is full. 
	 * 			Returns -2 if the property passed to the function has a value of null. 
	 * 			Returns -3 if the property is not within the borders of the management
	 * 			company's plot. 
	 * 			
	 * 			Returns -4 if the property overlaps another property on the 
	 * 			management company's plot.
	 */
	public int addProperty(Property prop) {

		// Create a new Property object and make a copy of the
		// prop parameter passed to the method.
		Property newProperty = new Property(prop);
		
		// Return -2 if the new Property is equal to null.
		if (newProperty == null) {
			return -2;
		}
		
		// If the management company's plot does not encompass
		// the new property, return -3.
		if (!(plot.encompasses(newProperty.getPlot()))) {
			return -3;
		}

		// Loop through each of the properties managed by the management
		// company.
		for (int i = 0; i < propArr.length; i++) {
			// Check to see if the new Property overlaps any of the existing
			// properties. If it does, return -4.
			if (propArr[i] != null) {
				if (newProperty.getPlot().overlaps(propArr[i].getPlot())) {
					return -4;
				}
			}

		}
		
		// Return -1 if the propArr array is already full.
		if ((propArr[propArr.length -1]) != null) {
			return -1;
		}
		
		// Declare a variable to hold the location in the array of the
		// added property.
		int index = 0;
		
		// Loop through each of the plots managed by the management company.
		for (int i = 0; i < propArr.length; i++) {
			
			// Add the new Property to the management company's plot.
			if (propArr[i] == null) {
				index = i;
				break;
			}
		}
		// Set the element in the array equal to the new property.
		propArr[index] = newProperty;
		
		// Return the index of the property.
		return index;

	}
	/**
	 * This overloaded function creates a new Property object with the
	 * parameters passed into the method, then adds the property
	 * to the management company's managed properties.
	 * @param propertyName The name of the property being added to the management's plot.
	 * @param city The location of the property.
	 * @param rent The cost of rent for the property.
	 * @param ownerName The name of the property's owner.
	 * @return Returns the index value of the propArr array where the property
	 * 			was stored. 
	 * 			Returns -1 if the propArr array is full. 
	 * 			Returns -2 if the property passed to the function has a value of null. 
	 * 			Returns -3 if the property is not within the borders of the management
	 * 			company's plot. 
	 * 			
	 * 			Returns -4 if the property overlaps another property on the 
	 * 			management company's plot.
	 */
	public int addProperty(String propertyName, String city, double rent, 
														String ownerName) {
		

		// Create a new Property object and make a copy of the
		// prop parameter passed to the method.
		Property newProperty = new Property(propertyName, city, rent, ownerName);
		
		// Return -2 if the new Property is equal to null.
		if (newProperty == null) {
			return -2;
		}
		
		// If the management company's plot does not encompass
		// the new property, return -3. 
		if (!(plot.encompasses(newProperty.getPlot()))) {
			return -3;
		}

		// Loop through each of the properties managed by the management
		// company.
		for (int i = 0; i < propArr.length; i++) {
			// Check to see if the new Property overlaps any of the existing
			// properties. If it does, return -4.
			if (propArr[i] != null) {
				if (newProperty.getPlot().overlaps(propArr[i].getPlot())) {
					return -4;
				}
			}

		}

		// Return -1 if the propArr array is already full.
		if ((propArr[propArr.length -1]) != null) {
			return -1;
		}
		
		// Declare a variable to hold the location in the array of the
		// added property.
		int index = 0;
		
		// Loop through each of the plots managed by the management company.
		for (int i = 0; i < propArr.length; i++) {
			
			// Add the new Property to the management company's plot.
			if (propArr[i] == null) {
				index = i;
				break;
			}
		}
		// Set the element in the array equal to the new property.
		propArr[index] = newProperty;
		
		// Return the property's index. 
		return index;		
	}
	/**
	 * This overloaded function creates a new Property object with the
	 * parameters passed into the method, then adds the property to the
	 * management company's managed properties.
	 * @param propertyName The name of the property being added to the management's plot.
	 * @param city The location of the property.
	 * @param rent The cost of rent for the property.
	 * @param ownerName The name of the property's owner.
	 * @param x The x coordinate of the top left of the property's plot.
	 * @param y The y coordinate of the top left of the property's plot.
	 * @param width The width of the property.
	 * @param depth The depth of the property.
	 * @return Returns the index value of the propArr array where the property
	 * 			was stored. 
	 * 			Returns -1 if the propArr array is full. 
	 * 			Returns -2 if the property passed to the function has a value of null. 
	 * 			Returns -3 if the property is not within the borders of the management
	 * 			company's plot. 
	 * 			
	 * 			Returns -4 if the property overlaps another property on the 
	 * 			management company's plot.
	 */
	public int addProperty(String propertyName, String city, double rent, 
							String ownerName, int x, int y, int width, int depth) {

		// Create a new Property object and make a copy of the
		// prop parameter passed to the method.
		Property newProperty = new Property(propertyName, city, rent, 
											ownerName, x, y, width, depth);
				
		// Return -2 if the new Property is equal to null.
		if (newProperty == null) {
			return -2;
		}
		
		// If the management company's plot does not encompass
		// the new property, return -3. 
		if (!(plot.encompasses(newProperty.getPlot()))) {
			return -3;
		}

		// Loop through each of the properties managed by the management
		// company.
		for (int i = 0; i < propArr.length; i++) {
			// Check to see if the new Property overlaps any of the existing
			// properties. If it does, return -4.
			if (propArr[i] != null) {
				if (newProperty.getPlot().overlaps(propArr[i].getPlot())) {
					return -4;
				}
			}

		}

		// Return -1 if the propArr array is already full.
		if ((propArr[propArr.length -1]) != null) {
			return -1;
		}
		
		// Declare a variable to hold the location in the array of the
		// added property.
		int index = 0;
		
		// Loop through each of the plots managed by the management company.
		for (int i = 0; i < propArr.length; i++) {
			
			// Add the new Property to the management company's plot.
			if (propArr[i] == null) {
				index = i;
				break;
			}
		}
		// Set the element in the array equal to the new property.
		propArr[index] = newProperty;
		
		// Return the index of the new property.
		return index;		
	}
	/**

	 * This method sums the cost of rent between all managed properties.
	 * @return Returns the total rent collected from all properties
	 * under the management company's umbrella.
	 */
	public double totalRent() {
		
		// Declare and initialize an accumulator.
		double total = 0.000;
		

		// Loop through each of the properties managed by the company.
		for (int i = 0; i < propArr.length; i++) {
			// Check to see if the element array is equal to null
			if (propArr[i] != null) {
					// Add the rent of each property to the total.
					total += propArr[i].getRentAmount();
				}
		}
		// returns the total rent collected from all properties.
		return total;
	}
	/**
	 * This method determines the managed property with the highest
	 * rent under the management company. 
	 * @return A string representation of the property with the 
	 * 			highest rent.
	 */
	public String maxRentPropInfo() {
		
		// Declare a variable to hold the highest rent among
		// all of the managed properties. Set it equal to the
		// first property's rent.
		double maxRent = propArr[0].getRentAmount();
		
		// Declare a variable to hold the index
		// of the max rent. Initialize it to 0.
		int maxRentIndex = 0;
		
		// Declare a string variable to hold a description
		// of the most expensive property.
		String mostExpensive;
		
		// Loop through each of the managed properties.
		for (int i = 1; i < propArr.length; i++) {
			
			// Check to see if the array element is null.
			if (propArr[i] != null) {
				// Check to see if the current property has 
				// a higher rent than the value stored in
				// maxRent.
				if (propArr[i].getRentAmount() > maxRent) {
					maxRent = propArr[i].getRentAmount();
					maxRentIndex = i;
				}

			}

		}
		// Call the toString method to store a description
		// of the property in mostExpensive.
		mostExpensive = propArr[maxRentIndex].toString();
		
		// Return a description of the property with the
		// highest rent.
		return mostExpensive;
	}
	/**
	 * This method returns the index of the property with the 
	 * highest rent under the management company.
	 * @return The index of the property with the highest rent.
	 */
	private int maxPropertyIndex() {
		// Declare a variable to hold the highest rent among
		// all of the managed properties. Set it equal to the
		// first property's rent.
		double maxRent = propArr[0].getRentAmount();
				
		// Declare a variable to hold the index
		// of the max rent. Initialize it to 0.
		int maxRentIndex = 0;
		
		// Loop through each of the managed properties.
		for (int i = 0; i < propArr.length; i++) {
			
			// Check to see if the current property has 
			// a higher rent than the value stored in
			// maxRent.
			if (propArr[i].getRentAmount() > maxRent) {
				maxRent = propArr[i].getRentAmount();
				maxRentIndex = i;
			}
		}
		
		// Return a description of the property with the
		// highest rent.
		return maxRentIndex;
	}
	/**
	 * Returns information about the management company and all of the
	 * properties that it manages.
	 */
	public String toString() {
		
		// Declare a string to hold a description of a property, then initialize it.
		String propInfo = String.format("List of the properties for %s, taxID: %s\n", name, taxID);
		
		// Loop through each property in the array.
		for (int i = 0; i < propArr.length; i++) {
			// Check to see if the element is null.
			if (propArr[i] != null) {
				// Call the property's toString() method and add it to the propInfo string.
				propInfo += propArr[i].toString() + "\n";
			}
		}
		
		// Complete the propInfo string with the total management fee.
		propInfo = propInfo + "total management Fee: " + (mgmFee * 0.01 * totalRent());

		// Return the generated string.
		return propInfo;
	}
	
	

	
}
