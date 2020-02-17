
public class Property {

	private String city, owner, propertyName;
	private double rentAmount;
	Plot plot;
	
	public Property() {
		city= "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	public Property(Property p) {
		this.city= p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount= p.rentAmount;
		this.plot = p.plot;
		
	}
	public Property(String propertyName,String city, double rentAmount,String owner) {
		this.propertyName = propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner= owner;
		
	}
	public Property(String propertyName,String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName= propertyName;
		this.city= city;
		this.rentAmount=rentAmount;
		this.owner= owner;
		this.plot = new Plot(x, y, width, depth);
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * @param rentAmount the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * @param plot the plot to set
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public String toString() {
		return ("Property Name: " +propertyName + "\n"+
				"Located in " + city + "\n" +
				"Belonging to " + owner + "\n" +
				"Rent Amount: " + rentAmount + "\n"
				);
	}
	
}
