/** 
 * A property object contains information about itself, including the property name, the
 *  city it's located in, the owner's name, the rent amount, and the plot of the property,
 *  all of which can be set, retrieved, and changed.
 * 
 * 
 */

public class Property 
{
	//instance fields
	/**the property name*/
	private String propertyName;
	/**the name of the city the property is located in*/
	private String city;
	/**the property owner's name*/
	private String owner;
	
	/**the cost of rent of the property*/
	private double rentAmount;
	
	/**the plot of the property*/
	private Plot plot;
	
	//constructors
	/**No-arg constructor creates a Property with default values: <br>
	 * propertyName, city, and owner will be empty Strings <br>
	 * rentAmount will be set to 0.0 <br>
	 * plot will be set to a default Plot <br>
	 */
	public Property()
	{
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0.0;
		plot = new Plot();
	}
	
	/**Constructs copied Property of a given Property
	 * @param p the Property being copied
	 */
	public Property(Property p)
	{
		propertyName = p.propertyName;
		city = p.city;
		owner = p.owner;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}
	
	/**Constructs a Property with the given property name, the city name, the cost of rent, 
	 * and the owner's name, with the plot being set to its default values.
	 * @param thePropertyName the property name
	 * @param theCity the name of the city
	 * @param theRentAmount the cost of rent
	 * @param theOwner the owner of the property
	 */
	public Property(String thePropertyName, String theCity, double theRentAmount, String theOwner)
	{
		propertyName = thePropertyName;
		city = theCity;
		rentAmount = theRentAmount;
		owner = theOwner;
		plot = new Plot();
	}
	
	/**Constructs a Property with the given property name, the city name, the cost of rent, 
	 * the owner's name, the x coordinate of the plot of the property, the y coordinate of the 
	 * plot of the property, the width of the plot, and the depth of the plot.
	 * @param thePropertyName the property name
	 * @param theCity the name of the city
	 * @param theRentAmount the cost of rent
	 * @param theOwner the owner of the property
	 * @param xCoords the x coordinate of the plot of the property
	 * @param yCoords the y coordinate of the plot of the property
	 * @param theWidth the width of the plot
	 * @param theDepth the depth of the plot
	 */
	public Property(String thePropertyName, String theCity, double theRentAmount, String theOwner,
					int xCoords, int yCoords, int theWidth, int theDepth)
	{
		propertyName = thePropertyName;
		city = theCity;
		rentAmount = theRentAmount;
		owner = theOwner;
		plot = new Plot(xCoords, yCoords, theWidth, theDepth);
	}
	
	//public methods
	/**Gets the name of the property
	 * @return propertyName - the name of the property
	 */
	public String getPropertyName( ){return propertyName;}
	
	/**Sets the name of the property
	 * @param thePropertyName the name of the property to be set
	 */
	public void setPropertyName(String thePropertyName) {propertyName = thePropertyName;}
	
	/**Gets the name of the city the property is located in
	 * @return city- the name of the city
	 */
	public String getCity() {return propertyName;}
	
	/**Sets the name of the city the property is located in
	 * @param theCity the name of the city to be set
	 */
	public void setCity(String theCity) {city = theCity;}
	
	/**Gets the name of the owner of the property
	 * @return owner - the name of the owner
	 */
	public String getOwner() {return owner;}
	
	/**Sets the name of the owner of the property
	 * @param theOwner the name of the owner to be set
	 */
	public void setOwner(String theOwner) {owner = theOwner;}
	
	/**Gets the cost of rent of the property
	 * @return rentAmount - the rent
	 */
	public double getRent() {return rentAmount;}
	
	/**Sets the cost of rent of the property
	 * @param theRentAmount the rent 
	 */
	public void setRent(double theRentAmount) {rentAmount = theRentAmount;}
	
	/**Gets the plot of the property
	 * @return plot - the plot
	 */
	public Plot getPlot() {return plot;}
	
	/**Sets the plot of the property
	 * @param p the plot
	 */
	public void setPlot(Plot p)
	{
		plot.setX(p.getX());
		plot.setY(p.getY());
		plot.setWidth(p.getWidth());
		plot.setDepth(p.getDepth());
	}
	
	/** Gives a string representation of a property object
	 * @return the string representation
	 */
	public String toString()
	{
		return "Property Name: " + propertyName + "\n " +
			   "Located in " + city + "\n " +
			   "Belonging to: " + owner + "\n " + 
			   "Rent Amount: " + rentAmount;
	}
}
 