/** 
 * Represents a property object
 * 
 * 
 *
 */
public class Property {
	
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	/** 
	 * Parameterized constructor, sets the property information to the passed parameters.
	 * 
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rent Amount rent amount
	 * @param owner the owner's name 
	 * @param x x coordinate of the upper left corner of the property’s plot
	 * @param y y coordinate of the upper left corner of the property’s plot
	 * @param width the plot’s width
	 * @param depth the plot’s depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Parameterized constructor, sets the property information to the passed parameters.
	 * 
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		this.plot = new Plot();
		
	}

	/**
	 * Copy Constructor, creates a new object using the information of the Property object passed to it.
	 * 
	 * @param p a Property object
	 */
	public Property(Property p) {
	
		propertyName = p.propertyName;
		city = p.city;
		rentAmount = p.rentAmount;
		owner = p.owner;
		plot = p.plot;
	}
	
	/**
	 * return the name of the property
	 * 
	 * @return property name
	 */
	public String getPropertyName() {
		
		return propertyName;
	}
	
	/**
	 * returns the city where the property is located
	 * 
	 * @return the city
	 */
	public String getCity() {
		
		return city;
	}
	
	/**
	 * returns the property's rent amount
	 * 
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		
		return rentAmount;
	}
	
	/**
	 * returns the property's owner
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		
		return owner;
	}
	
	/**
	 * returns the plot of the property
	 * 
	 * @return the propertyName
	 */
	public Plot getPlot() {
		
		return plot;
	}
	
	/**
	 * sets the property name to the passed parameter
	 * 
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		
		this.propertyName = propertyName;
	}
	
	/**
	 * set the property's city to the passed parameter
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		
		this.city = city;
	}
	
	/**
	 * sets the property's rent to the passed parameter.
	 * 
	 * @param rentAmount the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		
		this.rentAmount = rentAmount;
	}
	
	/**
	 * Sets the property's owner name to the passed parameter
	 * 
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		
		this.owner = owner;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property.
	 * 
	 * @return Returns the string representation of a Property object as the following format:
     * Example:
	 * Property Name: Lakewood
	 * Located in Rockville
	 * Belonging to: Alex Tan
	 * Rent Amount: 3000.0
	 * Be sure the last item is the rent amount, preceded by a space. 
	 */
	public String toString() {
		
		String propertyString = "Property Name: " + propertyName +
								"\n Located in " + city +
								"\n Belonging to: " + owner +
								"\n Rent Amount: " + rentAmount;
		
		return propertyString;
	}
}