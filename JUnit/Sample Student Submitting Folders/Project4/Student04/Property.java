/**
 * The Property class contains property-level information, such as property name,
 * location, rent amount, etc. This class has getters and setters for these variables.
 * 
 *
 */

public class Property {

	//Instance variables
	private String 	propertyName;
	private String 	city;
	private String 	owner;
	private double	rentAmount;
	private Plot 	plot;
	
	
	//Constructors
	/**
	 * No arg Property constructor
	 */
	public Property() {
		this.propertyName="";
		this.city="";
		this.owner="";
		this.rentAmount=0;
		this.plot = new Plot();
	}

	/**
	 * Property constructor that sets property information to passed parameters
	 * @param property name
	 * @param city
	 * @param rent amount
	 * @param owner name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName=propertyName;
		this.city=city;
		this.owner=owner;
		this.rentAmount=rentAmount;
		this.plot = new Plot();
	}
	
	/**
	 * Property constructor that sets property information to passed parameters
	 * @param property name
	 * @param city
	 * @param rent amount
	 * @param owner name
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName=propertyName;
		this.city=city;
		this.owner=owner;
		this.rentAmount=rentAmount;
		this.plot= new Plot(x, y, width, depth);
	}
	
	/**
	 * Property copy constructor that creates a new object using the information from the
	 * Property object passed as argument
	 * @param property
	 */
	public Property(Property p) {
		p = new Property();
	}
	
	//Methods
	
	/**
	 * City name getter
	 * @return city name
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Owner name getter
	 * @return owner name
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Plot getter
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Property name getter
	 * @return property name
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * Rent amount getter
	 * @return rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * City name setter
	 * @param city
	 */
	public void setCity(String city) {
		this.city=city;
	}
	
	/**
	 * Owner name setter
	 * @param owner
	 */
	public void setOwner (String owner) {
		this.owner=owner;
	}
	
	/**
	 * Property name setter
	 * @param property name
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName=propertyName;
	}
	
	/**
	 * Rent amount setter
	 * @param rent amount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	
	/**
	 *Prints property name, city, owner name, and rent amount for property
	 * @return String representation of property information
	 */
	public String toString() {
		return "Property Name: " + propertyName +
				"\nLocated in " + city +
				"\nBelonging to: " + owner +
				"\nRent Amount: " + rentAmount;
	}
	
}
