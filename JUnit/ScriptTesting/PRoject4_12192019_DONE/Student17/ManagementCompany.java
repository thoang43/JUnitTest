package assignment4;

/**
 * Management Company object definition class
 * 
 *
 */

public class ManagementCompany {

	//FIELDS
	
	private String name; //name of management company
	private String taxID; //tax ID of management company
	private double fee; //fee associated with management company
	private int MAX_PROPERTY = 5;//max number of properties management company can manage
	private Property[] properties; //list of properties a company manages
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot mgmtPlot; //plot specifics of management company location

	
	
	//CONSTRUCTORS
	
	/**
	 * Constructor. Passes in arguments for the name of the management company, tax Id and management Fee,
	 * along with the x, y, width, and depth of the overall plot of the management company 
	 * that will be subdivided into plots for each property.   
	 * Array of Property is initialized here as well.
	 * @param companyName
	 * @param id
	 * @param mgmtFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany( String companyName, String id, double mgmtFee, int x, int y, int width, int depth) {
		name = companyName;
		taxID = id;
		fee = mgmtFee;
		mgmtPlot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * 	Constructor. Passes in arguments for the name of the management company, tax Id and management.
	 *  A default plot will be created with x, y coordinates set to 0 and width and depth set to MGMT_WIDTH and MGMT_DEPTH.
	 *  Array of Property is initialized here as well.
	 * @param companyName
	 * @param id
	 * @param mgmtFee
	 */
	public ManagementCompany(String companyName, String id, double mgmtFee) {
		name = companyName;
		taxID = id;
		fee = mgmtFee;
		mgmtPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	
	
	//METHODS
	 
	/**
	 * add the copy of the Property object to the properties array
	 * @param prop
	 * @return index of the array where the property is added.  
	 * Will return -2 if the property is null, 
	 * -1 if the array is full, 
	 * -3 if the plot for the property is not encompassed by the management company plot, 
	 * or -4 if the plot for the property overlaps any other property’s plot.
	 */
	public int addProperty(Property prop) {
//		If prop is null return -2
//		Else (prop is not null)
//			if prop is not encompassed by mgmt comp plot return -3
//			else (prop is encompassed by mgmt comp plot)
//				for each index in properties array
//					if current index is not empty
//						If prop’s plot overlaps plot of property at current index, Return -4
//					Else index is empty and doesn't overlap any properties in array
//						add prop to array at current index
//						return current index
//		return -1 (no empty indexes)
		if (prop == null) return -2;
		else {
			if (mgmtPlot.encompasses(prop.getPlot()) == false) return -3;
			else {
				int i;
				for (i = 0; i < MAX_PROPERTY; i++) {
					if (properties[i] != null) {
						if (prop.getPlot().overlaps(properties[i].getPlot()) == true) return -4;
					}
					else {
						properties[i] = new Property(prop);
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * add the copy of the Property object to the properties array
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @return index of the array where the property is added.  
	 * Will return -2 if the property is null, 
	 * -1 if the array is full, 
	 * -3 if the plot for the property is not encompassed by the management company plot, 
	 * or -4 if the plot for the property overlaps any other property’s plot.
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
//		Create Property object from arguments
//		Return addProperty(created Property Object)
		Property prop = new Property(propertyName, city, rent, ownerName);
		return addProperty(prop);
	}
	
	
	/**
	 * add the copy of the Property object to the properties array
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return the index of the array where the property is added. 
	 * 	Will return -2 if the property is null, 
	 * -1 if the array is full, 
	 * -3 if the plot for the property is not encompassed by the management company plot,
	 * or -4 if the plot for the property overlaps any other property’s plot.
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
//		Create Property object from arguments
//		Return addProperty(created Property Object)
		Property prop = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		return addProperty(prop);
	}
	
	
	
	/**
	 * accesses each "Property" object stored in the array of Property and returns the total rent of properties.
	 * @param prop
	 * @return the total rent of properties
	 */
	public double totalRent() {
//		int sum = 0
//		For each property in property array
//			Add rent of current property to sum
//		Return sum
		int sum = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				sum += properties[i].getRent();
			}
		}
		return sum;
	}

	/**
	 * returns the String representation of the property within the array of Property that has the highest rent amount.
	 * For simplicity assume that each "Property" object's rent amount is different. 
	 * @param prop
	 * @return the String representation of the property within the array of Property that has the highest rent amount
	 */
	public String maxRentPropInfo() {
//		int high = result of maxPropertyIndex
//		Switch (high)
//		high = 0
//			return toString() of first property
//		high = 1
//			return toString() of second property
//		high = 2
//			return toString() of third property
//		high = 3
//			return toString() of fourth property
//		default (high = 4)
//			return toString() of fifth property
		int high = maxPropertyRentIndex(properties);
		switch (high) {
		case 0:
			return properties[0].toString();
		case 1:
			return properties[1].toString();
		case 2:
			return properties[2].toString();
		case 3:
			return properties[3].toString();
		default: return properties[4].toString();
		}
	}
	 
	
	/**
	 * returns the index of the property within the array of Property that has the highest rent amount. This method will be private
	 * @param prop
	 * @return index of the property within the array of Property that has the highest rent amount
	 */
	private int maxPropertyRentIndex(Property[] prop) {
//		int high = 0 (index of first property in Property array)
//		For each property in Property array
//		If rent of current property is greater than rent of property at index high, then replace high with new index
//		Return high
		int high = 0;
		for (int i = 1; i < MAX_PROPERTY; i++) {
			if (prop[i] != null) {
				if (prop[i].getRent() > prop[high].getRent()) high = i;
			}
		}
		return high;
	}

	
	/**
	 * returns a string with the information of all the properties stored in the array of Properties
	 * and the total management fee for this management company
	 */
	public String toString() {
//		String toString = “”
//		For each property in Property array
//			Concatenate to toString: toString of property at current index
//		Concatenate "Management Fee" + fee
//		Return toString
		String toString = "";
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				toString += properties[i].toString();
			}
		}
		toString += "\nManagement Fee: " + totalRent() * fee/100;
		return toString;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public double getFee() {
		return fee;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public Property getProperty(int index) {
		if (properties[index] != null) return properties[index];
		else return null;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}
	
	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}
	
	public Plot getPlot() {
		return mgmtPlot;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTaxID(String id) {
		taxID = id;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
}
