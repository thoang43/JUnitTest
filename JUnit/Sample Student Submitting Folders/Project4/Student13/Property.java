/**
 * This is the class diagram for a Property. Properties are managed
 * by a Management Company.
 * 
 * 
 * CMSC 203
 * 10/26/2019
 *
 */
public class Property {

	////////////////////////////// PROPERTY FIELDS ////////////////////////////// 
	
	private String propertyName;				// The name of the property
	private String city;						// The city the property is in
	private double rentAmount;					// The cost of rent for the property
	private String owner;						// The name of the property's owner
	private int x;								// The x coordinate of the top left corner of the property
	private int y;								// The y coordinate of the top left corner of the property
	private int width;							// The width of the property
	private int depth;							// The depth of the property
	private Plot plot;							// The coordinates of the property's plot of land
	
	/////////////////////////////// CONSTRUCTORS //////////////////////////////// 
	
	/**
	 * No argument constructor that sets propertyName, city,
	 * and owner to blank strings. It sets rentAmount to 0.0 and
	 * it sets x and y to 0. Width and depth are set to 1.
	 */
	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
		plot = new Plot(x, y, width, depth);
	}
	/**
	 * This is a 4-argument constructor that accepts the property name,
	 * city, rent amount, and owner as parameters passed to the method.
	 * @param propName The name of the property.
	 * @param location The city the property is located in.
	 * @param rent The cost of rent for the property.
	 * @param oName The name of the property's owner.
	 */
	public Property(String propName, String location, double rent, String oName) {
		propertyName = propName;
		city = location;
		rentAmount = rent;
		owner = oName;
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
		plot = new Plot(x, y, width, depth);
	}
	/**
	 * This is an 8-argument constructor that accepts the property name,
	 * city, rent amount, owner, x and y coordinates, and width and depth
	 * of the property.
	 * @param propName The name of the property.
	 * @param location The city the property is located in.
	 * @param rent The cost of rent for the property.
	 * @param oName The name of the property's owner.
	 * @param xCoord The x coordinate of the top left corner of the property.
	 * @param yCoord The y coordinate of the top left corner of the property.
	 * @param w The width of the property.
	 * @param d The depth of the property.
	 */
	public Property(String propName, String location, double rent, String oName, 
											int xCoord, int yCoord, int w, int d) {
		propertyName = propName;
		city = location;
		rentAmount = rent;
		owner = oName;
		x = xCoord;
		y = yCoord;
		width = w;
		depth = d;
		plot = new Plot(x, y, width, depth);
	}
	/**
	 * This is a copy constructor that accepts a Property object as its
	 * parameter and copies the values of its fields into the fields
	 * of the object being created.
	 * @param p A Property object to be copied.
	 */
	public Property(Property p) {
		
		propertyName = p.propertyName;
		city = p.city;
		rentAmount = p.rentAmount;
		owner = p.owner;
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
		plot = new Plot(x, y, width, depth);
	}
	
	///////////////////////////////// GETTERS ///////////////////////////////////
	
	/**
	 * Returns the property's name.
	 * @return Returns the property's name.
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * Returns the city the property is located in.
	 * @return Returns the city the property is in.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Returns the cost of rent for the property.
	 * @return Returns the property's rent amount.
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * Returns the name of the property's owner.
	 * @return Returns the name of the owner of the property.
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Creates and returns a plot based on the Property's 
	 * x, y, width, and depth fields.
	 * @return
	 */
	public Plot getPlot() {
		// Return the plot.
		return plot;
	}

	///////////////////////////////// SETTERS ///////////////////////////////////
	
	/**
	 * Sets the property name to the string passed to the method.
	 * @param pN The name of the property.
	 */
	public void setPropertyName(String pN) {
		propertyName = pN;
	}
	/**
	 * Sets the city to the string passed to the method.
	 * @param c The name of the city.
	 */
	public void setCity(String c) {
		city = c;
	}
	/**
	 * Sets the cost of rent to the given double.
	 * @param rent The cost of rent per month.
	 */
	public void setRentAmount(double rent) {
		rentAmount = rent;
	}
	/**
	 * Sets the name of the property owner to the given parameter.
	 * @param o The name of the property owner.
	 */
	public void setOwner(String o) { 
		owner = o;
	}
	
	///////////////////////////// GENERAL METHODS ///////////////////////////////////
	
	/**
	 * Displays information about the property's name, location, owner, and rent.
	 */
	public String toString() {
		
		// Declare a String variable to hold a description of the property.
		String propInfo;
		
		// Format the string to display the property information.
		propInfo = String.format("Property Name: %s\nLocated in "
				+ "%s\nBelonging to: %s\nRent Amount: %.2f", 
				propertyName, city, owner, rentAmount);
		
		// Return the string.
		return propInfo;
	}
	
}
