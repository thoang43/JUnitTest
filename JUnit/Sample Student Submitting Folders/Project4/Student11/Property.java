/**
 * This class creates a Property object, calls the Plot constructor,
 * and displays the Property's info
 * 
 *
 */
public class Property extends Object{
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	public Plot plot1;
	public int x, y, width, depth;
	/**
	 * No-arg constructor sets default fields and creates Plot object
	 */
	public Property(){
		propertyName = "";
		city = "";
		owner = "";
		plot = new Plot();
	}
	/**
	 * Copy constructor takes Property object and copies it's field values
	 * @param pr Property object
	 */
	public Property(Property pr) {
		//Property prop = new Property(pr);
		propertyName = pr.propertyName;
		city = pr.city;
		rentAmount = pr.rentAmount;
		owner = pr.owner; //is this right?
		this.x = pr.x;// these correct?
		this.y = pr.y;
		this.width = pr.width;
		this.depth = pr.depth;
	}
	/**
	 * Constructor takes parameters and creates Property object with values
	 * passed, creates Plot object
	 * @param pN The property's name
	 * @param c Name of the city
	 * @param rA The rent amount
	 * @param o Owner's name
	 */
	public Property(String pN, String c, double rA, String o) {
		propertyName = pN;
		city = c;
		rentAmount = rA;
		owner = o;
		plot = new Plot(); // add plot variable & set to default
		
	}
	/**
	 * Constructor takes parameters and creates Property object with values
	 * passed, creates Plot object
	 * @param pN The property's name
	 * @param c Name of the city
	 * @param rA The rent amount
	 * @param o Owner's name
	 * @param x X coordinate of plot
	 * @param y Y coordinate of plot
	 * @param width Width of plot
	 * @param depth Depth of plot
	 */
	public Property(String pN, String c, double rA, String o, int x, int y, int width, int depth) {
		propertyName = pN;
		city = c;
		rentAmount = rA;
		owner = o;
		//plot = new Plot(x, y, width, depth);
		this.x = x;// these correct?
		this.y = y;
		this.width = width;
		this.depth = depth;
		plot = new Plot(this.x, this.y, this.width,this.depth);
	}
	/**
	 * Method to display Property's info
	 */
	public String toString() {
		return "\nProperty Name: " + getPropertyName() + "\nLocated in " + getCity() +
				"\nBelonging to: " + getOwner() + "\nRent amount: " + getRentAmount() + "\n";	
	}
	/**
	 * Method to return a Plot object
	 * @return plot
	 */
	public Plot getPlot() {
		return new Plot(getX(), getY(), getWidth(), getDepth()); // supposed to return new plot object?
	}
	/**
	 * Method takes String parameter and sets property name
	 * @param pn Property name
	 */
	public void setPropertyName(String pn) {
		propertyName = pn;
	}
	/**
	 * Method takes String parameter and sets city 
	 * @param c City
	 */
	public void setCity(String c) {
		city = c;
	}
	/**
	 * Method takes double and sets rent amount
	 * @param ra Rent amount
	 */
	public void setRendAmount(double ra) {
		rentAmount = ra;
	}
	/**
	 * Method takes String and sets owner
	 * @param o Owner
	 */
	public void setOwner(String o) {
		owner = o;
	}
	/**
	 * Method returns property name
	 * @return Property name
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * Method returns city
	 * @return City
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Method returns rent amount
	 * @return Rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * Method returns owner
	 * @return Owner
	 */
	public String getOwner() {
		return owner;
	}
	/** Method returns x value
	 * 
	 * @return X
	 */
	public int getX() {
		return x;
	}
	/**
	 * Method returns y value
	 * @return Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Method returns width value
	 * @return Width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Method returns depth value
	 * @return Depth
	 */
	public int getDepth() {
		return depth;
	}
}
