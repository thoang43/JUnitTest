import java.util.Arrays;

public class ManagementCompany
{
	private String name;
	private String taxID;
	private double mgmFee;
	private final int MAX_PROPERTY = 5;
	private Property[] properties;
	private int MAX_WIDTH = 10;
	private int MAX_DEPTH = 10;
	private Plot plot ;
            
	
	 /**
     * A management company parameterized constructor that sets the plot for the company. 
     * @param name
     * @param taxID
     * @param mgmFee
     * @param x
     * @param y
     * @param width
     * @param depth
     */
    public ManagementCompany(String name, String taxID, double mgmFee,int x, int y, int width, int depth) 
    {
    	properties = new Property[MAX_PROPERTY];
    	this.name = name;
    	this.taxID = taxID;
    	this.mgmFee = mgmFee;
    	this.plot = new Plot (x, y, width, depth);             
    }
    
    /**
     * A management company parameterized  constructor with a default company plot.
     * @param name name of the company
     * @param taxID taxID of the property
     * @param mgmFee management fee
     */
    public ManagementCompany(String name, String taxID, double mgmFee) 
    {
    	properties = new Property[MAX_PROPERTY];
    	this.name = name;
    	this.taxID = taxID;
    	this.mgmFee = mgmFee;
    	this.plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
    }
    
    /**
     * A get method that returns the size of properties array. 
     * @return MAX_PROPERTY size of the array. 
     */
    public int getMAX_PROPERTY() 
    {
    	return MAX_PROPERTY;
    }
    
    /** 
     * Adds a already created property to the array 
     * @param property
     * @return
     */
    public int addProperty(Property property) 
    {
    	int i;
    	int count=0;
    	for( i =0; i < count; i++)
    	{
    		if(properties[i].getPlot().overlaps(property.getPlot()))
    			return -4;
    	}
    	
    	if(property!=null)
    	{
    		properties[count]=property;
    		count++;
    		return count;
    	}
    	
    	if(count == MAX_PROPERTY) 
    	{
    	return -1;
    	}
    	if(property== null) 
    	{
    		return -2;
    		}
    	if(this.plot.encompasses(property.getPlot())) 
    	{
            return -3;
            }
       else
       {
    	   properties[count]=property;
    	   count++;
    	   return count;
    	   } 
    	}
    /**
     * A method that adds the property with four arguments and a default plot to the array.
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @return
     **/
    public int addProperty(String name, String city, double rent, String owner)
    {
    	//create a property object.
    	Property property = new Property(name, city, rent, owner, 0, 0, 1,1);
        //adds the property object to properties array. 
        properties[count] = property;
        count++;
        int i;
        for( i =0; i < count; i++) 
        {
        	if(properties[i].getPlot().overlaps(property.getPlot()))
        		return -4;        
        	}
       
        if(count == MAX_PROPERTY) 
        {
        	return -1;
        }
        if(this.plot.encompasses(property.getPlot())) 
        {
        	return -3;
        }
        else 
        {
        	properties[count]=property;
        	count++;
        	return count;
        }
}
    /**
     * An add property that has all the parameters for the property and the plot. 
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @param x
     * @param y
     * @param width
     * @param depth
     * @return
     **/
    public int addProperty(String name, String city,double rent, String owner, int x, int y, int width,int depth) 
    {
    	int i;
        //Creates a property object that calls the constructor of Plot. 
        Property property = new Property(name, city, rent, owner, x, y,width, depth);
        //Adds the property object to the properties array.
        properties[count] = property;
        
        // create a plot
        Plot plot = new Plot(x,y, width, depth);
        
        // Question is this the correct way of checking if the plot overlaps with the other property plots?????
        for( i =0; i < count; i++)
        {
        	if(properties[i].getPlot().overlaps(property.getPlot()))
        		return -4;
                
        }
        if(count == MAX_PROPERTY) 
        {
        	return  -1;
        }
        else if(this.plot.encompasses(property.getPlot()) ) 
        {
        	return  -3;
        }
        else 
        {
        	properties[count]=property;
        	count++;
        	return count;
        }
        }
    
    /**
     * A method that adds up all the amounts of rent. 
     * not finished yet. 
     **/
    public double totalRent() 
    {
    	double totalRent =0.0 ;
        for(int i = 0; i < count; i++) 
        {
        	if(properties[i] != null)
        	{
        		totalRent += properties[i].getRentAmount();
        		}
        }
        return totalRent;
        }
    
    public double maxPropertyRent() 
    {
    	double maxRentAmount = 0.0;
        maxRentAmount = properties[maxPropertyRentIndex()].getRentAmount();
        return maxRentAmount;
        }
    
    public int maxPropertyRentIndex() 
    {
    	int indexOFMaxRent=0;
        for (int i =0; i < count; i++)
        {
        	if(properties[i] != null) 
        	{
        		if(properties[indexOFMaxRent].getRentAmount() < properties[i].getRentAmount()) 
        		{
        			indexOFMaxRent = i;
        			}
        		}
        	}
        return indexOFMaxRent;
        }
    
    public String displayPropertyAtIndex(int i) 
    {
        String str = "";
        if(properties[i] != null) 
        {
        	str= ("Owner: " + properties[i].getOwner() + "City: " + properties[i].getCity() 
                                + "Property Name: " + properties[i].getPropertyName() + "Rent Amount: " + properties[i].getRentAmount()
                                + "Plot: " + properties[i].getPlot());       
        }
        
        return str;
        }
    public String toString() {
        
        String printContent = "";
        System.out.println("List of the properties for Alliance, taxID: " + taxID );
        System.out.println("__________________________________________________");
        
        for(int i = 0; i < count; i++) 
        {
        	if(properties[i] != null)
        		printContent = (" Property Name: " + properties[i].getPropertyName() +"\n" +
                                "  Located in: " + properties[i].getCity() + "\n" + 
                                "  Belonging to: " + properties[i].getOwner() + "\n" + 
                                "  Rent Amount: " + properties[i].getRentAmount());         
        	}
        
        System.out.println("__________________________________________________");
        System.out.println("Total management Fee: " + mgmFee);
        return printContent;
        }
    }

