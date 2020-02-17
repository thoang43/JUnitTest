/**
 * A management company object will contain the name of the management company, the tax ID,
 * the percentage fee the management company takes from the cost of rents, the MAXIMUM amount of properties it can have,
 * the plot the management company controls along with its WIDTH and DEPTH,
 * and the list of properties a management company might have. Along with the ability to set, retrieve,
 * and change information about the management company, properties can be added to the list the company has, 
 * the total rent of all the properties combined can be found, the information about the property 
 * with the highest rent can be printed, and information about the management company and its properties can be
 * printed as well.
 * 
 */

public class ManagementCompany 
{
	//instance fields
	/**the management company name*/
	private String mgmCompanyName;
	/**the tax ID*/
	private String taxID;
	
	/**the percentage fee*/
	private double mgmFee;
	
	/**the maximum number of properties a management company can have*/
	private static final int MAX_PROPERTY = 5;
	/**the width of the plot the management company controls*/
	private static final int MGMT_WIDTH = 10;
	/**the depth of the plot the management company controls*/
	private static final int MGMT_DEPTH = 10;
	
	/**the plot the management company controls*/
	Plot mgmPlot;
	
	/**the Array of properties a management company controls*/
	Property[] properties;
	
	//constructors
	/**No-arg constructor creates a ManagementCompany with default values: <br>
	 * mgmCompanyName and taxID will be empty Strings <br>
	 * mgmFee will be set to 0.0 <br>
	 * mgmPlot will be set to a Plot with coordinate (0,0), along with a width of MGMT_WIDTH, and depth of MGMT_DEPTH <br>
	 * properties will be a new empty Property array with a length of MAX_PROPERTY
	 */ 
	public ManagementCompany()
	{
		mgmCompanyName = "";
		taxID = "";
		mgmFee = 0.0;
		mgmPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**Constructs a ManagementCompany with the given company name, the tax ID, and the fee percentage,  
	 * a Plot with coordinate (0,0), along with a width of MGMT_WIDTH, and depth of MGMT_DEPTH, and a new empty
	 * Property array with a length of MAX_PROPERTY.
	 * @param theName the name of the company
	 * @param theTaxID the tax ID
	 * @param theMgmFee the management fee percentage
	 */
	public ManagementCompany(String theName, String theTaxID, double theMgmFee)
	{
		mgmCompanyName = theName;
		taxID = theTaxID;
		mgmFee = theMgmFee / 100.0;
		mgmPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**Constructs a ManagementCompany with the given company name, the tax ID, the fee percentage, the
	 * x coordinate of the plot of the management company, y coordinate of the plot of the management company,
	 * the width of the plot, and the depth of the plot, along with a new empty Property array with a length of 
	 * MAX_PROPERTY.
	 * @param theName the name of the company
	 * @param theTaxID the tax ID
	 * @param theMgmFee the management fee percentage
	 * @param xCoords the x coordinate of the plot of the company
	 * @param yCoords the y coordinate of the plot of the company
	 * @param theWidth the width of the plot
	 * @param theDepth the depth of the plot
	 */
	public ManagementCompany(String theName, String theTaxID, double theMgmFee, int xCoords,
							 int yCoords, int theWidth, int theDepth)
	{
		mgmCompanyName = theName;
		taxID = theTaxID;
		mgmFee = theMgmFee / 100.0;
		mgmPlot = new Plot(xCoords, yCoords, theWidth, theDepth);
		properties = new Property[MAX_PROPERTY];
		
	}
	
	//public methods
	/**Attempt to add an existing property to the list of properties the Management Company owns
	 * @param p the property to be added
	 * @return -4 if the given property overlaps with any property owned by the company <br>
	 * 		   -3 if the given property is not encompassed by the management company plot <br>
	 * 		   -2 if the given property is null <br>
	 * 		   -1 if the array of Property objects is full <br>
	 * 		    x the index of the property added in the Property array
	 */
	public int addProperty(Property p)
	{
		//check if p is null
		if(p != null && p.getPlot().getDepth() != 0 && p.getPlot().getWidth() != 0)
		{
			//check if mgmPlot encompasses p
			if(mgmPlot.encompasses(p.getPlot()))
			{
				//check if p overlaps with any existing properties (if any)
				for(int x = 0; x < properties.length; x++)
				{
					if(properties[x] != null)
					{
						if(properties[x].getPlot().overlaps(p.getPlot()))
						{
							return -4;
						}
					}
					else
					{
						//end the loop as there can't be existing properties after the first null
						x = properties.length; 	
					}
				}
				
				//attempt to add the given property into the array,
				for(int x = 0; x < properties.length; x++)
				{
					if(properties[x] == null)
					{
						properties[x] = new Property(p);
						return x;
					}
				}
				return -1;	
			}else
				return -3; 
		}else
			return -2; 
	}
	
	/**Attempt to add a new property to the list of properties the Management Company owns given the name of
	 * the property, the name of the city it's in, the cost of rent, and the property owner's name.
	 * @param thePropName the property name
	 * @param theCity the city name
	 * @param theRentAmount the rent
	 * @param theOwner the owner's name
	 * @return -4 if the resulting property created from given info overlaps with any property owned by the company <br>
	 * 		   -3 if the resulting property is not encompassed by the management company plot <br>
	 * 		   -2 if the resulting property is null <br>
	 * 		   -1 if the array of Property objects is full <br>
	 * 		    x the index of the resulting property added in the Property array
	 */
	public int addProperty(String thePropName, String theCity, double theRentAmount, String theOwner)
	{
		//check if any given information can be considered to be null
		if(thePropName.equals("") != true && theCity.equals("") != true && theOwner.equals("") != true &&
		   theRentAmount >= 0)
		{
			//create the Property object p with given information
			Property p = new Property(thePropName, theCity, theRentAmount, theOwner);
			
			//check if p is encompassed by the management company plot
			if(mgmPlot.encompasses(p.getPlot()))
			{
				//check if p overlaps with any of the existing properties (if any)
				for(int x = 0; x < properties.length; x++)
				{
					if(properties[x] != null)
					{
						if(properties[x].getPlot().overlaps(p.getPlot()))
						{
							return -4;
						}
					}
					else
					{
						//end the loop as there can't be existing properties after the first null
						x = properties.length;
					}
				}
				
				//attempt to add p into the array
				for(int x = 0; x < properties.length; x++)
				{
					if(properties[x] == null)
					{
						properties[x] = p;
						return x;
					}
				}
				return -1;
			}else 
				return -3; 
		}else
			return -2;  
	}
	
	/**Attempt to add a new property to the list of properties the Management Company owns given the name of
	 * the property, the name of the city it's in, the cost of rent, the property owner's name, the x coordinate
	 * of the plot of the property, the y coordinate of the plot of the property, the width of the property plot,
	 * and the depth of the property plot.
	 * @param thePropName the property name
	 * @param theCity the city name
	 * @param theRentAmount the rent
	 * @param theOwner the owner's name
	 * @param xCoords x coordinate of the plot of the property
	 * @param yCoords y coordinate of the plot of the property
	 * @param theWidth the width of the plot
	 * @param theDepth the depth of the plot
	 * @return -4 if the resulting property created from given info overlaps with any property owned by the company <br>
	 * 		   -3 if the resulting property is not encompassed by the management company plot <br>
	 * 		   -2 if the resulting property is null <br>
	 * 		   -1 if the array of Property objects is full <br>
	 * 		    x the index of the resulting property added in the Property array
	 */
	public int addProperty(String thePropName, String theCity, double theRentAmount, String theOwner,
						   int xCoords, int yCoords, int theWidth, int theDepth)
	{
		//check if any given information can be considered to be null
		if(thePropName.equals("") != true && theCity.equals("") != true && theOwner.equals("") != true  &&
		   theRentAmount >= 0 && theWidth != 0 && theDepth != 0)
		{
			//create the Property object p with given information
			Property p = new Property(thePropName, theCity, theRentAmount, theOwner, xCoords, yCoords,
									  theWidth, theDepth);
			
			//check if p is encompassed by the management company plot
			if(mgmPlot.encompasses(p.getPlot()))
			{
				//check if p overlaps with any of the existing properties (if any)
				for(int x = 0; x < properties.length; x++)
				{
					if(properties[x] != null)
					{
						if(properties[x].getPlot().overlaps(p.getPlot()))
						{
							return -4;
						}
					}
					else
					{
						//end the loop as there can't be existing properties after the first null
						x = properties.length;
					}
				}
				
				//attempt to add p into the array
				for(int x = 0; x < properties.length; x++)
				{
					if(properties[x] == null)
					{
						properties[x] = p;
						return x;
					}
				}
				return -1;	
			}else
				return -3; 
		}else
			return -2; 
	}
	
	//public methods
	/**Gets the maximum amount of properties the management company can have
	 * @return MAX_PROPERTY - the max number of properties allowed
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	/**Gets the name of the management company
	 * @return mgmCompanyName - the name
	 */
	public String getName()
	{
		return mgmCompanyName;
	}

	/**Sets the name of the management company
	 * @param theName the name to be set
	 */
	public void setName(String theName)
	{
		mgmCompanyName = theName;
	}
	
	/**Gets the tax ID of the management company
	 * @return taxID - the tax ID
	 */
	public String getTaxID()
	{
		return taxID;
	}
	
	/**Sets the tax ID of the management company
	 * @param theTaxID the tax ID to be set
	 */
	public void setTaxID(String theTaxID)
	{
		taxID = theTaxID;
	}
	
	/**Gets the fee percentage of the management company
	 * @return mgmFee - the fee percentage
	 */
	public double getMgmFee()
	{
		return mgmFee;
	}
	
	/**Sets the fee percentage of the management company
	 * @return theMgmFee the fee percentage
	 */
	public void setMgmFee(double theMgmFee)
	{
		mgmFee = theMgmFee;
	}
	
	/**Gets the plot object of the management company
	 * @return mgmPlot - the Plot 
	 */
	public Plot getPlot()
	{
		return mgmPlot;
	}
	
	/**Sets the plot object of the management company
	 * @return p the Plot object to be set
	 */
	public void setPlot(Plot p)
	{
		mgmPlot = p;
	}
	
	/**Calculate the total rent of all the properties combined
	 * @return total - the total rent
	 */
	public double totalRent()
	{
		double total = 0.0;
		for(int x = 0; x < properties.length; x++)
		{
			if(properties[x] != null)
			{
				total += properties[x].getRent();
			}			
		}
		return total;
	}
	
	/**Display the information of the property that has the highest rent
	 * @return the string representation of the property with the highest rent <br>
	 * 		   String stating no properties exist
	 */
	public String maxRentPropInfo()
	{
		if(maxPropertyIndex() == -1)
		{
			return "No properties in existant.";
		}
		else
		{
			return properties[maxPropertyIndex()].toString();
		}
	}
	
	/**Gives a string representation of a management company object
	 * @return output - the string representation
	 */
	public String toString()
	{
		String output = "List of the properties for " + mgmCompanyName + ", taxID: " + taxID + "\n" +
				        "_____________________________________________________" + "\n";
		//add information of each property to the final output 
		for(int x = 0; x < properties.length; x++)
		{
			if(properties[x] != null)
			{
				output += properties[x].toString() + "\n";
			}
		}
		output += "_____________________________________________________" + "\n\n " +
		"total management Fee: " + (totalRent() * mgmFee);
		return output;
	}

	//private methods
	/**Find the index of the property that has the highest rent in the array of properties
	 * @return -1 if there aren't any properties in the array <br>
	 * 		   indexOfHighestProp - the index of the property with the highest rent
	 */
	private int maxPropertyIndex()
	{
		//if the first object is null, the rest of the array is empty, therefore there is no property with the highest rent
		if(properties[0] == null)
		{
			return -1;
		}
		else
		{
			double highestRentAmount = properties[0].getRent();
			int indexOfHighestProp = 0;
			for(int x = 1; x < properties.length; x++)
			{
				if(properties[x] != null && properties[x].getRent() > highestRentAmount)
				{
					highestRentAmount = properties[x].getRent();
					indexOfHighestProp = x;
				}
			}
			return indexOfHighestProp;
		}
	}
}
