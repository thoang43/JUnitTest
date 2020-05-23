
/**
 * 
 * CMSC 203
 * Assignment 4
 * */

/**
 * Data Element class – Property.java
 * The class Property will contain: 
 * 1.	Instance variables for property name, city, rental amount, owner, and plot.  Refer to JavaDoc (Property.html posted on blackboard) for the data types of each instance variable.
 * 2.	toString method to represent a Property object. Refer to JavaDoc for more details on format of the information.
 * 3.	A copy constructor
 * 4.	A parameterized constructor with parameters for property name, city, rent amount, owner, x and y location of the upper left corner of the property’s plot, the plot’s width and  depth.
 * 5.	A second constructor will only have parameters for name, city, rental amount, and owner, and will set the plot coordinates to the default value. (refer to Plot class default constructor)
 * 6.	getter and setter methods.  
 * */

public class Property 
{
	//1.	Instance variables 
	  private String propertyName; //property name
	  private String city; //city
	  private double rentAmount; //rental amount
	  private String owner; //owner
	  private Plot plot; //plot
	  
   public Property() 
   {
		this.plot = new Plot();
   }
   
   //4.	A parameterized constructor with parameters
   public Property(String propertyName, String city, double rentAmount, String owner, 
		  int x, int y, int width, int depth) 
   { //Parameterized constructor
		this.propertyName = propertyName; //property name
		this.city = city; //city
		this.rentAmount = rentAmount; //rent amount
		this.owner = owner; //owner
		this.plot = new Plot(x,y,width,depth);
		//this.plot.setX(x); //x location
		//this.plot.setY(y); //y location
		//this.plot.setWidth(width); //plot’s width 
		//this.plot.setDepth(depth); //plot’s depth.
   }

   //5.	A second constructor
   public Property(String propertyName, String city, double rentAmount, String owner)  
   { //2nd Parameterized constructor with defaulted Plot
		this.propertyName = propertyName; //name
		this.city = city; //city
		this.rentAmount = rentAmount; //rental amount
		this.owner = owner; //owner
		this.plot = new Plot(); //will set the plot coordinates to the default value
   }
  
   //3.	A copy constructor
   public Property(Property property) 
   { //Copy constructor
		this.propertyName = property.propertyName;
		this.city = property.city;
		this.rentAmount = property.rentAmount;
		this.owner = property.owner;
		this.plot = new Plot(); 
		//this.plot = property.getPlot();
		this.plot.setX(property.getPlot().getX()); //x location
		this.plot.setY(property.getPlot().getY()); //y location		
		this.plot.setWidth(property.getPlot().getWidth()); //plot’s width 
		this.plot.setDepth(property.getPlot().getDepth()); //plot’s depth.
    }
   
   	//getter method
    public String getPropertyName() 
	{
		return propertyName;
	}
	
    //setter method
    public void setPropertyName(String propertyName) 
    {
		this.propertyName = propertyName;
	}
	
	//getter method
	public String getCity() 
	{
		return city;
	}
	
	//setter method
	public void setCity(String city) 
	{
		this.city = city;
	}
	
	//getter method
	public double getRentAmount() 
	{
		return rentAmount;
	}
	
	//setter method
	public void setRentAmount(double rentAmount) 
	{
		this.rentAmount = rentAmount;
	}
	
	//getter method
	public String getOwner() 
	{
		return owner;
	}
	
	//setter method
	public void setOwner(String owner) 
	{
		this.owner = owner;
	}
	
	//getter method
	public Plot getPlot() 
	{
		return plot;
	}
	
	//setter method
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	//2.	toString method to represent a Property object
	public String toString() 
	{
		return "Property [propertyName =" + propertyName + ", city=" + city + ", rentAmount=" + rentAmount + ", owner=" + owner + ", plot="
				+ plot + "]";
	}

}
