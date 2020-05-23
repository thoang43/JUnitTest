/**
 * Class that represents a property
 *
 *
 */

public class Property {
	
	private String propertyName; //name of the property
	private String city; //city that the property is in
	private double rentAmount; //rent of the property
	private String owner; //who owns the property
	private Plot plot; //plot of of the prop
	
	/**
	 * copy constructor
	 * @param the property to be constructed
	 */
	public Property(Property property) {
		this.propertyName = property.propertyName;
		this.city = property.city;
		this.rentAmount = property.rentAmount;
		this.owner = property.owner;
		this.plot = property.plot;
	}
	
	/**
	 * 4 arg constructor
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(0, 0, 1, 1);
	}
	
	/**
	 * 8 arg constructor
	 * @param propertyName - name of the property
	 * @param city - city that is in the property
	 * @param rentAmount - rent at the property
	 * @param owner - who owns the property
	 * @param x - upper left corner x coordinate
	 * @param y - upper left corner y coordinate
	 * @param width - width of the plot
	 * @param depth - depth of the plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {

		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * getter for the plot
	 * @return plot covered by the property
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * setter for the plot
	 * @param plot - plot of the property
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	/**
	 * getter for the property name
	 * @return name of the property
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * setter for the property name
	 * @param propertyName name of the property
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * getter for the city
	 * @return the city name
	 */
	public String getCity( ) {
		return city;
	}
	
	/**
	 * setter for the city
	 * @param city - city that the property is in
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * getter for the rent
	 * @return the amount of rent at the property
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * setter for the rent
	 * @param rentAmount - the amount of rent
	 */
	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	/**
	 * getter for owner
	 * @return owner - the owner of the property
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * setter for owner
	 * @param owner - owner of the property
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * returns a string representation of the property
	 */
	public String toString() {
		String propertyString = "";
		
		propertyString += ("Property Name: " + propertyName + "/n");
		propertyString += ("Located in: " + city + "/n");
		propertyString += ("Belonging to: " + owner + "/n");
		propertyString += ("Rent Amount: " + rentAmount);
		
		return propertyString;
	}
}
