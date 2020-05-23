public class Property{
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	public Property(){
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.plot = new Plot();
	}
	
	public Property(Property p){
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.owner = p.owner;
		this.plot = p.plot;
	}
	
	public Property(String propertyName, String city, double rentAmount,String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount,String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Plot getPlot() {
		return plot;
	}

	public String toString(){
		return
				"Example: " + "\n" +
				"Property Name: " + propertyName + "\n" +
				"Located in " + city + "\n" +
				"Belonging to: " + owner + "\n" +
				"Rent Amount: " + rentAmount;
	}
}