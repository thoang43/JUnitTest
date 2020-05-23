
/**
 * This assignment is to management property information.
 * 
 *
 */
public class ManagementCompany
{
		private Plot plot;
		private int MAX_PROPERTY = 5;
		private double mgmFee;
		private String name;
		private Property[] properties;
		private String taxID;
		private int numProperties;
		int i=0;
		private final int MGMT_WIDTH=10;
		private final int MGMT_DEPTH=10;
		
		
		/**
		 * No-Arg Constructor that creates a ManagementCompany object using empty strings and default Plot
		 */
		public ManagementCompany() 
		{
			name = "";
			taxID="";
			mgmFee=0.0;
			plot= new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
			properties = new Property[MAX_PROPERTY];	
		}
		
		
		/**
		 * Constructor Creates a ManagementCompany object using the passed informations. 
		 * "properties" array is initialized here as well.
		 * @param name - management company name
		 * @param taxID - tax id
		 * @param mgmFee - management fee
		 */
		public ManagementCompany(String name, String taxID, int mgmFee)
		{
			this.name=name;
			this.taxID=taxID;
			this.mgmFee=mgmFee;
			plot= new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
			properties = new Property[MAX_PROPERTY];
			
		}
		

		/**
		 * Constructor Creates a ManagementCompany object using the passed informations. Array of Properties is initialized here as well. 
		 * Management plot is set to a plot with x,y coordinates set to 0 and width and depth set to GMT_WIDTH and MGMT_DEPTH.
		 * @param name - management company name
		 * @param taxID - tax id
		 * @param mgmFee - management fee
		 * @param x - x coordinate of the management plot
		 * @param y - y coordinate of the management plot
		 * @param width - width of the management plot
		 * @param depth - depth of the management plot
		 */
		public ManagementCompany(String name, String taxID, int mgmFee, int x, int y, int width, int depth)
		{
			this.name=name;
			this.taxID=taxID;
			this.mgmFee=mgmFee;
			plot=new Plot(x,y,width,depth);
			properties = new Property[MAX_PROPERTY];
		}
		
		
		/**
		 * Return the MAX_PROPERTY constant that represent the size of the "properties" array.
		 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
		 */
		public int getMAX_PROPERTY()
		{
			return MAX_PROPERTY;
		}

		
		/**
		 * a reference to the plot of the management company.
		 * @return plot
		 */
		public Plot getPlot() 
		 {
		     return plot;
		 } 
		 
		 
		/**
		 * returns the name of the management company
		 * @return name
		 */
		public String getName()
		 {
			 return name;
		 }
		 
		
		/**
		 * Creates a property object and adds it to the "properties" array, in a default plot.
		 * @param name - property name
		 * @param city - city location of the property
		 * @param rent - monthly rent
		 * @param owner - owner of the property
		 * @return Returns either -1 if the array is full, -2 if property is null, 
		 * -3 if the plot is not contained by the MgmtCo plot, 
		 * -4 of the plot overlaps any other property, 
		 * or the index in the array where the property was added successfully.
		 */
		public int addProperty(String name,String city,double rent,String owner)
			{

				Property propObj_1=new Property(name,city,rent,owner);
				return this.addProperty(propObj_1);
			}
		 
	
		/**
		 * Creates a property object and adds it to the "properties" array.
		 * @param name - property name
		 * @param city - location of the property
		 * @param rent - monthly rent
		 * @param owner - owner of the property
		 * @param x - x location of upper left corner of property's plot
		 * @param y - y location of upper left corner of property's plot
		 * @param width - width of the property's plot
		 * @param depth - depth of the property's plot
		 * @return Returns either -1 if the array is full, -2 if property is null, 
		 * -3 if the plot is not contained by the MgmtCo plot, 
		 * -4 of the plot overlaps any other property, 
		 * or the index in the array where the property was added successfully.
		 */
		public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) 
			{
				Property propObj_2=new Property(name,city,rent,owner,x,y,width,depth);
				
				return this.addProperty(propObj_2);
			}

	
		/**
		 * Adds the property object to the "properties" array.		
		 * @param property property a property object
		 * @return Returns either -1 if the array is full, -2 if property is null, 
		 * -3 if the plot is not contained by the MgmtCo plot, 
		 * -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
		 */
		public int addProperty(Property property) 
		 {
			//Check if index >= MAX_PROPERTY means array is full, return -1
			 if (property==null)
					return -2;
			 if (!this.plot.encompassess(property.getPlot())) 

			{
					return -3;
				}
				else 
					for(int i=0;i<MAX_PROPERTY;i++) {
						if(properties[i]==null) {
							
							properties[i]=property;
							return i;
						}
						else
						if (properties[i] != null && property.getPlot().overlaps(properties[i].getPlot()) ) {
							return -4;
						}
					}
				return -1;
		 }
		 
		 
		 /**
		  * This method accesses each "Property" object within the array "properties" 
		  * and sums up the property rent and returns the total amount.
		  * @return total rent
		  */
		public double totalRent() 
		 {
			 double total=0.0;
			 
			 for(int i=0; i<properties.length; i++)
			 {		 
				 total += properties[i].getRentAmount();
			 }	 
			 return total; 
		 }
		
		
		/**
	     * This method finds the index of the property with the maximum rent amount. NOTE: For simplicity 
	     * assume that each "Property" object's rent amount is different.
		 * @return properties[largestRentIndex] , the index of the property with the maximum rent amount
		 */
		public String maxRentPropInfo() 
		{
			int largestRentIndex= 0;
			double largestRent = properties[0].getRentAmount();
			 
			 for(int i=1; i<properties.length; i++)
			 {
				 if(largestRent < properties[i].getRentAmount() )
				 {
					 largestRent=properties[i].getRentAmount();
				     largestRentIndex = i;
				 }
			 }
			 
			 return properties[largestRentIndex].toString();
		}

		
		/**
		 * Displays the information of all the properties in the "properties" array.
		 * return s information of ALL the properties within this management company by accessing the "Properties" array.
	  The format is as following example:
	  List of the properties for Alliance, taxID: 1235
	  ______________________________________________________
	    Property Name: Belmar
	      Located in Silver Spring
	      Belonging to: John Smith
	      Rent Amount: 1200.0
	    Property Name: Camden Lakeway
	      Located in Rockville
	      Belonging to: Ann Taylor
	      Rent Amount: 5000.0
	    Property Name: Hamptons
	      Located in Rockville
	      Belonging to: Rick Steves
	      Rent Amount: 1250.0
	    Property Name: Marrory Square
	      Located in Wheaton
	      Belonging to: Abbey McDonald
	      Rent Amount: 1000.0
	     Property Name: Lakewood
	      Located in Rockville
	      Belonging to: Alex Tan
	      Rent Amount: 3000.0
	  ______________________________________________________
	  total management Fee: 6.0
		 */
		public String toString() 
		{   
			String output="";

		//Iterate through all the objects present in properties array and add information of all property in output variable.

		    for(int i=0;i<properties.length;i++)
		    {
		    	output+=properties[i].toString()+"\n\n";
		    	}

		    return ("List of the properties for Mananagemen Company, "

		    + name +", taxid, "+ taxID +  "\n-------------------------------------------\n"+output+"-------------------------------------------\ntotal management Fee:"+this.mgmFee);
		    }
		}

