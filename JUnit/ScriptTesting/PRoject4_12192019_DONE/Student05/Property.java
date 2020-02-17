/**
 * This class is designed to property.
 * 
 *
 */
public class Property 
{
	private Plot plot;
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	
	/**
	 * No-arg Constructor, creates a new object using empty strings for the property name ,city and owner.The plot is set to the default Plot
	 */
	public Property () 
	{
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0.0;
		plot = new Plot();
	}
	
	
	/**
	 * Copy Constructor, creates a new object using the information of the Property object passed to it.
	 * @param p - a Property object
	 */
	public Property (Property p)
	{
		propertyName = p.propertyName;
		city = p.city;
		rentAmount = p.rentAmount;
		owner = p.owner;
		plot = p.plot;	
	}
	
	
	/**
	 * Parameterized constructor, sets the property information to the passed parameters. Plot of the property is set to the default plot.
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 */
	public Property (String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();	
	}
	
	
	/**
	 * Parameterized constructor, sets the property information to the passed parameters.
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 * @param x - x coordinate of the upper left corner of the property’s plot
	 * @param y - y coordinate of the upper left corner of the property’s plot
	 * @param width - the plot’s width
	 * @param depth - the plot’s depth
	 */
	public Property(String propertyName, String city, double rentAmount,String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
	}  
	
	/**
	 * @return plot
	 */
	public Plot getPlot() 
	 {
	     return plot;
	 }
	 
	/**
	 * @return propertyName
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/**
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	/**
	 * @return city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * @return rentAmount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	/**
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * @return owner
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/**
	 * @param owner
	 */
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	
	/**
	 * Prints out the name, city, owner and rent amount for a property.
	 */
	public String toString()
	{
		//Property name belonging to rent amount

		return "Property Name: "+this.propertyName+"\n"+

		"Located: "+this.city+"\n"+

		"Belonging to: "+this.owner+"\n"+

		"Rent Amount: "+this.rentAmount;
	}
}




