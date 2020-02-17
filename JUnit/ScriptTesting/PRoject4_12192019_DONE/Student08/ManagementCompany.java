/**
 * Class for management company representation 
 * 
 *
 */
public class ManagementCompany {
	
	private String name; //holds the name of the company
	private String taxID; //holds the taxID for the company
	private double mgmFee; //holds the management fee rate
	private final int MAX_PROPERTY = 5; //holds the max property in an arry
	private Property[] p; //array for properties
	private int propertyCount; //counter for properties in array
	private final int MGMT_WIDTH = 10; //standard width
	private final int MGMT_DEPTH = 10; //standard depth
	private Plot plot; //the plot for the company
	
	/**
	 * no arg constructors, default fields
	 */
	public ManagementCompany() {
		this.name ="";
		this.taxID = "";
		this.mgmFee = 0;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		p = new Property[MAX_PROPERTY];
		propertyCount = 0;
	}
	
	/**
	 * 3 arg constructor
	 * @param name - name of the company
	 * @param taxID - taxID of the company
	 * @param mgmFee - percentage of the fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		p = new Property[MAX_PROPERTY];
		propertyCount = 0;
	}
	
	/**
	 * 7 arg constructor
	 * @param name - name of the company
	 * @param taxID - taxID of the company
	 * @param mgmFee - percentage of the fee
	 * @param x - x coordinate of the upper left corner of the company plot
	 * @param y - y coordinate of the upper left corner of the company plot
	 * @param width - horizontal extent of the plot
	 * @param depth - vertical extent of the plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x,y,width,depth);
		p = new Property[MAX_PROPERTY];
		propertyCount = 0;
	}
	/**
	 * setter of the company name
	 * @param name - name of the company
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns the name of the company
	 * @return name - the name of the argument
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the taxID number
	 * @param taxID - sets the tax ID of the company
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	
	/**
	 * returns the taxID number
	 * @return taxID - the taxID of the company
	 */
	public String getTaxID() {
		return taxID;
	}
	
	/**
	 * sets the management fee rate
	 * @param mgmFee - management fee rate
	 */
	public void setMgmFee(double mgmFee) {
		this.mgmFee = mgmFee;
	}
	
	/**
	 * returns the management fee rate
	 * @return mgmFee - management fee rate
	 */
	public double getMgmFee() {
		return mgmFee;
	}
	
	/**
	 * returns the size of the array
	 * @return the array size of the property
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * sets the plot of the company
	 * @param plot - the plot of the company
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	/**
	 * returns the plot of the company
	 * @return plot - the plot of the company
	 */
	public Plot getPlot( ) {
		return plot;
	}
	
	/**
	 * adds a property to the array
	 * @param property - the property to be added
	 * @return index that the property was added to, error numbers otherwise
	 */
	public int addProperty(Property property) {
		Plot paramPlot = property.getPlot();
		Property testProp;
		int i;
		
		//test if null
		if (property == null)
			return -2;
		
		//test if management plot encompasses the added plot
		if (!(this.plot.encompasses(paramPlot)))
				return -3;
		
		//test if added property overlaps any other property
		for (i = 0; i < propertyCount; i++)
		{
			testProp = p[i];
			if (paramPlot.overlaps(testProp.getPlot()))
				return -4;
		}
		
		if (propertyCount < MAX_PROPERTY) //adds it the latest first empty slot in the array
		{
			int index = propertyCount;
			p[propertyCount] = property;
			propertyCount++;
			return (index); 
		}
		return -1;

	}
	/**
	 * 4-arg constructor
	 * @param propertyName - name of the property
	 * @param city - city the property is based in
	 * @param rent - rent of the property
	 * @param ownerName - name of the owner of property
	 * @return index that the property was added to, error numbers otherwise
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		Property property = new Property(propertyName, city, rent, ownerName);
		Plot paramPlot = property.getPlot();
		
		Property testProp;
		int i;
		
		if (!(this.plot.encompasses(paramPlot)))
			return -3;
		
		for (i = 0; i < propertyCount; i++)
		{
			testProp = p[i];
			if (paramPlot.overlaps(testProp.getPlot()))
				return -4;
		}
		
		//adds it the latest first empty slot in the array
		if (propertyCount < MAX_PROPERTY)
		{
			int index = propertyCount;
			p[propertyCount] = property;
			propertyCount++;
			return (index); 
		}
		return -1;
	}
	
	/**
	 *  8 arg constructor
	 * @param propertyName - name of the property
	 * @param city - name of the city 
	 * @param rent - rent of the property
	 * @param ownerName - owner name
	 * @param x - x coordinate of the upper left corner
	 * @param y - y coordinate of the upper right corner
	 * @param width - width of the plot
	 * @param depth - depth of the plot
	 * @return index that the property was added to, error numbers otherwise
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
		Property property = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		
		Plot paramPlot = property.getPlot();
		
		Property testProp;
		int i;
		
		if (!(this.plot.encompasses(paramPlot)))
			return -3;
		
		for (i = 0; i < propertyCount; i++)
		{
			testProp = p[i];
			if (paramPlot.overlaps(testProp.getPlot()))
				return -4;
		}
		
		//adds it the latest first empty slot in the array
		if (propertyCount < MAX_PROPERTY)
		{
			int index = propertyCount;
			p[propertyCount] = property;
			propertyCount++;
			return (index); 
		}
		return -1;
	}
	/**
	 * Adds the rent for all the properties 
	 * @return returns the total of all rents
	 */
	public double totalRent() {
		double total = 0;
		
		//iterates through the array and adds it together
		for (int i = 0; i < propertyCount; i++)
		{
			if (p[i] == null)
				continue;
			total += p[i].getRentAmount();
		}
		
		return total;
	}
	
	/**
	 * Finds max property and returns the info in a string
	 * @return string representation of the highest rent property here
	 */
	public String maxRentPropInfo() {
		Property maxRentProperty = p[maxPropertyIndex()];
		//adds all the different values to the string representation
		String maxRentString = "Property Name: " + maxRentProperty.getPropertyName() +"\n";
		maxRentString += "Located in " + maxRentProperty.getCity() +"\n";
		maxRentString += "Belonging to: " + maxRentProperty.getOwner() +"\n";
		maxRentString += "Rent Amount: " + maxRentProperty.getRentAmount();
		
		return maxRentString;
		
	}
	
	/**
	 * finds the index of the property with the highest rent
	 * @return index integer of the max rent property
	 */
	private int maxPropertyIndex() {
		int maxIndex = -1;
		int i;
		double maxRent = 0;
		
		//iterates through the array finds the the property with the highest rent and returns it
		for (i = 0; i < propertyCount; i++)
		{
			if (maxRent < p[i].getRentAmount() && p[i] != null)
			{
				maxRent = p[i].getRentAmount();
				maxIndex = i;
			}

		}
		
		return maxIndex;
	}
	
	/**
	 * Adds all the fees of each property
	 * @return the total management fee of all the properties
	 */
	private double totalManagementFee()
	{
		double total = 0;
		
		for (int i = 0; i < MAX_PROPERTY; i++)
		{
			if (p[i] == null)
				continue;
			total += (p[i].getRentAmount() * mgmFee);  //multiples by mgmfee and adds to rent amount
		}
		
		return total;
	}
	
	/**
	 * returns string representation of all the properties in the company
	 */
	public String toString() {
		String managementCompanyString = "";
		int i;
		
		//adds all the different properties into one string
		managementCompanyString += ("List of the properties for " + name + ", taxID: " + taxID + "\n");
		managementCompanyString += ("______________________________________________________\n");
		for (i = 0; i < MAX_PROPERTY; i++)
		{
			if (p[i] == null)
				continue;
			
			Property currentProperty = p[i];
			
			managementCompanyString += ("Property Name: " + currentProperty.getPropertyName() + "\n");
			managementCompanyString += ("Located in " + currentProperty.getCity() + "\n" );
			managementCompanyString += ("Belonging to: "  + currentProperty.getOwner() + "\n");
			managementCompanyString += ("Rent Amount: " + currentProperty.getRentAmount() + "\n\n");
			
		}
		
		managementCompanyString += ("______________________________________________________\n");
		managementCompanyString += ("total management Fee: " + totalManagementFee()/100);
		
		return managementCompanyString;
	}
	
	
	
	
}
