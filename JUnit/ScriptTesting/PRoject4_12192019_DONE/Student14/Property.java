
/**
 * CMSC 203
 * 10/27/2019
 * This class is designed to read in the information of a property specified by a company.
 * 
 *
 */


public class Property {
	
	private String city;
	private String owner;
	private String propertyName;
 	private double rentAmount;
 	private Plot propertyPlot;

 
 	/**
 	 * Creates a new object using empty strings for the property name ,city and owner. 
 	 * The plot is set to the default Plot.
 	 */
 	public Property(){
 		
	 	city = "";
	 	owner = "";
	 	propertyName = "";
	 	rentAmount = 0;
	 	propertyPlot = new Plot(0,0,1,1);
 	}
 	
 	/**
 	 * Copy Constructor, creates a new object using the information of the Property object passed to it.
 	 * @param p
 	 */
 	public Property(Property p){
 		
	 	city = p.city;
	 	owner = p.owner;
	 	propertyName = p.propertyName; 
	 	rentAmount = p.rentAmount; 
	 	propertyPlot = p.propertyPlot;
	 	
 	}
 	
 	/**
 	 * Parameterized constructor, sets the property information to the passed parameters.
 	 * @param propertyName
 	 * @param city
 	 * @param rentAmount
 	 * @param owner
 	 */
 	public Property(String propertyName, String city, double rentAmount, String owner){
 		
 		this.city = city;
 		this.owner = owner;
 		this.propertyName = propertyName;
 		this.rentAmount = rentAmount;
 		propertyPlot = new Plot(0,0,1,1);

 	}
 	
 	/**
 	 * 	Parameterized constructor, sets the property information to the passed parameters.
 	 * @param propertyName
 	 * @param city
 	 * @param rentAmount
 	 * @param owner
 	 * @param x
 	 * @param y
 	 * @param width
 	 * @param depth
 	 */
 	public Property(String propertyName, String city, double rentAmount, String owner,
 			 int x, int y, int width, int depth) {
 		
 		this.city = city;
 		this.owner = owner;
 		this.propertyName = propertyName;
 		this.rentAmount = rentAmount;
 		propertyPlot = new Plot(x, y, width, depth);
 		
 	}
 	/**
	 * Gets the city the property is in.
	 */
 	public String getCity() {
 		
 		return city;
 	}
 	/**
	 * Sets the city the property is in.
	 */
 	public void setCity(String c) {
 		
 		this.city = c;
 	}
 	/**
	 * Gets the owner of the property.
	 */
 	public String getOwner() {
 		
 		return owner;
 	}
 	/**
	 * Sets the owner of the property.
	 */
 	public void setOwner(String o) {
 		
 		this.owner = o;
 	}
 	/**
	 * Gets the property name of the property.
	 */
 	public String getPropertyName() {
 		
 		return propertyName;
 	}
 	/**
	 * Sets the property name of the property.
	 */
 	public void setPropertyName(String n) {
 		
 		this.propertyName = n;
 	}
 	/**
	 * Gets the rent amount of the property.
	 */
 	public double getRentAmount() {
 		
 		return rentAmount;
 	}
 	/**
	 * Sets the rent amount of the property.
	 */
 	public void setRentAmount(double rA) {
 		
 		this.rentAmount = rA;
 	}
 	
 	/**
 	 * Gets the plot of the property
 	 */
 	public Plot getPlot() {
 		
 		return propertyPlot;
 	}
 		
 	@Override
 	/**
	 * Displays the information of the property.
	 * @return returns the property information.
	 */
	public String toString() {
 		String s = "Property Name: " + propertyName+ "\n" + " Located in " + city + 
				"\n" + " Belonging to: " + owner + "\n" + " Rent Amount: " + rentAmount;
		return s;	
	} 
 
}
