
/**
 * 
 * CMSC 203
 * Assignment 4
 */

/*
 * Data Manager Class – ManagementCompany.java
 * This class should not have any output functionality (e.g., no GUI-related or printing related functionality), but should take input, operate on the data structure, and return values or set variables that may be accessed with getters. 
 * The class ManagementCompany has the following attributes (instance variables):
 * Name of the management company, tax Id, management fee, MAX_PROPERTY (a constant set to 5), an array of size MAX_PROPERTY of type Property, constants MGMT_WIDTH and MGMT_DEPTH, both set to 10 and management’ plot of type Plot.
 * This class will contain the following methods in addition to get and set methods:
 * 1.	Constructor managementCompany – pass in arguments for the name of the management company, tax Id and management Fee, along with the x, y, width, and depth of the overall plot of the management company that will be subdivided into plots for each property.   Array of Property is initialized here as well.
 * 2.	Constructor managementCompany – pass in arguments for the name of the management company, tax Id and management.  A default plot will be created with x, y coordinates set to 0 and width and depth set to MGMT_WIDTH and MGMT_DEPTH. Array of Property is initialized here as well.
 * 3.	Method addProperty (3 versions) – 
 	* a.	Pass in a parameter of type Property object (calls Property copy constructor). It will add the copy of the Property object to the properties array. 
 	* b.	Pass in four parameters of types:
 		* i.	 String propertyName, 
 		* ii.	String city, 
 		* iii.	double rent, and 
 		* iv.	String ownerName. 
 		* Calls Property 4-arg constructor.
 	* c.	Pass in eight parameters of types: 
 		* i.	 String propertyName, 
 		* ii.	String city, 
 		* iii.	double rent,
 		* iv.	String ownerName,
		* v.	int x,*
		* vi.	int y,
		* vii.	int width, and int depth.
	* Calls Property 8-arg constructor.
	* addProperty methods will return the index of the array where the property is added.  If there is a problem adding the property, this method will return -2 if the property is null, -1 if the array is full, -3 if the plot for the property is not encompassed by the management company plot, or -4 if the plot for the property overlaps any other property’s plot.
* 4.	Method totalRent–This method accesses each "Property" object stored in the array of Property and returns the total rent of properties.
* 5.	Method maxRentPropInfo-returns the String representation of the property within the array of Property that has the highest rent amount. For simplicity assume that each "Property" object's rent amount is different. 
* 6.	Method maxPropertyIndex- returns the index of the property within the array of Property that has the highest rent amount. This method will be private. 
* 7.	Method toString - returns a string with the information of all the properties stored in the array of Properties and the total management fee for this management company. Refer to Javadoc for details of the format of the string.
**/

import java.util.Arrays;

public class ManagementCompany {
	private String name;
	private String taxId;
	private double managementFee;
	private static final int MAX_PROPERTY = 5;
	private Property properties[] ; //= new Property[MAX_PROPERTY];
	public static final int MGMT_WIDTH=10;
	public static final int MGMT_DEPTH=10;
	private Plot managementPlot;
	
	private int propCount = 0; //Number of properties added to array

	public ManagementCompany(String name, String taxId, double managementFee, int x, int y, int width, int depth) {
		
		this.name = name;
		this.taxId = taxId;
		this.managementFee = managementFee;
		this.managementPlot = new Plot( x,  y,  width,  depth) ;	
		properties = new Property[MAX_PROPERTY];
		propCount = 0;
		System.out.println("ManagementCompany: " + this.toString());
	}
	
public ManagementCompany(String name, String taxId, double managementFee) {
		
		this.name = name;
		this.taxId = taxId;
		this.managementFee = managementFee;
		this.managementPlot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		propCount = 0;
		System.out.println("ManagementCompany: " + this.toString());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public double getManagementFee() {
		return managementFee;
	}
	public void setManagementFee(double managementFee) {
		this.managementFee = managementFee;
	}

	/**
	 * methods will return the index of the array where the property is added.  
	 * If there is a problem adding the property, this method will return 
	 * -2 if the property is null, 
	 * -1 if the array is full, 
	 * -3 if the plot for the property is not encompassed by the management company plot, or 
	 * -4 if the plot for the property overlaps any other property’s plot.
	 * @param property
	 */
	public int addProperty(Property property) {
		int ret;
		System.out.println("addProperty: " + property.toString());
		if (property == null) 
		{
			ret = -2; //property is null
		}else if (this.managementPlot.encompasses(property.getPlot())) {
			// -3 if the plot for the property is not encompassed by the management company plot
			ret = -3;
	    //}else if (this.managementPlot.overlaps(property.getPlot())) {
		}else if (this.checkPropertyOverlap(property)) {
			// -4 if the plot for the property overlaps any other property’s plot
			ret = -4;
	    }else if (propCount < MAX_PROPERTY) {
		   this.properties[propCount] = new Property(property);
		   ret = propCount;
		   propCount++;
		}else {
			ret = -1; //array is full
		}
		return ret;
	}
	
	public int addProperty(String propertyName, String city, double rentAmount, String owner) {
		
		Property property;
		int ret=-2;
		if (propCount >= MAX_PROPERTY) {
		   ret = -1; //array is full
		}else 
		{
			property = new Property(propertyName, city, rentAmount, owner);
			System.out.println("addProperty:" + property.toString());
			if (property == null) 
			{
				ret = -2; //property is null
				
			}else 
			{
				if (this.managementPlot.encompasses(property.getPlot())) {
				// -3 if the plot for the property is not encompassed by the management company plot
				ret = -3;
			    //}else if (this.managementPlot.overlaps(property.getPlot())) {
				}else if (this.checkPropertyOverlap(property)) {
					// -4 if the plot for the property overlaps any other property’s plot
					ret = -4;
			    }else if (propCount < MAX_PROPERTY) {
				   this.properties[propCount] = property;
				   ret = propCount;
				   propCount++;
			    }
			}
		}
		return ret;		
	}
	
	public int addProperty(String propertyName, String city, double rentAmount, String owner, 
			int x, int y, int width, int depth) {

		Property property;
		int ret=-2;
		if (propCount >= MAX_PROPERTY) {
		   ret = -1; //array is full
		}else {
			property = new Property(propertyName, city, rentAmount, owner, x, y, width, depth);
	        System.out.println("addProperty:" + property.toString());

			if (property == null) 
			{
				ret = -2; //property is null
			}else {
				if (!this.managementPlot.encompasses(property.getPlot())) 
				{
				//}else if (property.getPlot().encompasses(this.getPlot())) {
					// -3 if the plot for the property is not encompassed by the management company plot
					ret = -3;
			    //}else if (this.managementPlot.overlaps(property.getPlot())) {
			    }else if (this.checkPropertyOverlap(property)) 
			    {
					// -4 if the plot for the property overlaps any other property’s plot
					ret = -4;
			    }else if (propCount < MAX_PROPERTY) {
				   this.properties[propCount] = property;
				   ret = propCount;
				   propCount++;

			    }
		    }
		}

		return ret;			
		
	}

	public Plot getPlot() {
		return managementPlot;
	}
	public void setPlot(Plot managementPlot) {
		this.managementPlot = managementPlot;
	}
	
	public boolean checkPropertyOverlap(Property property) {
		boolean ret=false;
		for (int i=0; i<propCount; i++) {
			if (property.getPlot().overlaps(this.properties[i].getPlot())) 
			{
				ret = true; 
				break;
			}
		}
		return ret;
	}

	public double totalRent() {
		double total=0;
		for (int i=0; i<propCount; i++) {
			total += this.properties[i].getRentAmount();
		}
		return total;
	}
	
	private int maxPropertyIndex() {
		int maxRentIndex=0;
		for (int i=0; i<propCount; i++) {
			if (this.properties[i].getRentAmount() > this.properties[maxRentIndex].getRentAmount()) {
				maxRentIndex = i;
			}
		}
		return maxRentIndex;
	}
	
	public String maxRentPropInfo() {
		int maxRentIndex = maxPropertyIndex();
		String ret = this.properties[maxRentIndex].toString();
		return ret;
		
	}
	

	public String toString() {
		return "ManagementCompany [name=" + name + ", taxId=" + taxId + ", managementFee=" + managementFee
				+ ", managementPlot=" + managementPlot + ", properties=" + Arrays.toString(properties) + "]";
	}

	public int getMAX_PROPERTY() {
		// TODO Auto-generated method stub
		return MAX_PROPERTY;
	}
}
