package assignment4;

/**
 * Property object definition class
 * 
 *
 */

public class Property {

	//FIELDS
	private String propertyName; //name of property
	private String city; //city location of property
	private double rent; //rental amount of property
	private String owner; //owner of property
	private Plot plot; //coordinates, width, and depth of property


	//CONSTRUCTORS
	/**
	 * Constructor taking name, city, rent, and owner, and setting plot to default
	 * @param propertyName name of property
	 * @param city city location of property
	 * @param rent rental amount of property
	 * @param owner owner of property
	 */
	public Property(String propertyName, String city, double rent, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rent = rent;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 * 
	 * @param propertyName name of property
	 * @param city city location of property
	 * @param rent rental amount of property
	 * @param owner owner of property
	 * @param x x coordinates of the upper left corner of the plot location
	 * @param y y coordinates of the upper left corner of the plot location
	 * @param width represents the horizontal extent of the plot
	 * @param depth represents the vertical extent of the plot
	 */
	public Property(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rent = rent;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Copy Constructor
	 * @param prop
	 */
	public Property(Property prop) {
		propertyName = prop.getPropertyName();
		city = prop.getCity();
		rent = prop.getRent();
		owner = prop.getOwner();
		plot = new Plot(prop.plot.getX(), prop.plot.getY(), prop.plot.getWidth(), prop.plot.getDepth());
	}
	
	//METHODS
	public String getPropertyName() {
		return propertyName;
	}
	
	
	public String getCity() {
		return city;
	}
	
	
	public double getRent() {
		return rent;
	}
	
	
	public String getOwner() {
		return owner;
	}
	
	
	public Plot getPlot() {
		return plot;
	}
	
	
	public void setPropertyName(String name) {
		propertyName = name;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	
	public String toString() {
		return "Property Name: " + propertyName
				+ "\nLocated in " + city
				+ "\nBelonging to: " + owner
				+ "\nRent Amount: " + rent + "\n";
	}

}
