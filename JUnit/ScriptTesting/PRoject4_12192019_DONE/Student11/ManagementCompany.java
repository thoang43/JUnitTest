import java.util.ArrayList;
/**
 * Class to create a Management Company
 * 
 *
 */
public class ManagementCompany {

	String name, taxID;
	double mgmFee;
	int x, y, width, depth;
	final int MAX_PROPERTY = 5;
	final int MGMT_WIDTH = 10;
	final int MGMT_DEPTH = 10;
	ArrayList<Property> propArr;
	Plot mPlot;
	/**
	 * No-arg constructor to create a default Management Company object
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0.0;
		mPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		propArr = new ArrayList<Property>(MAX_PROPERTY);
	}
	/**
	 * Constructor takes 3 parameters and creates an object with passed values
	 * @param name Name of the management company
	 * @param taxID Tax ID
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		mPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		propArr = new ArrayList<Property>(MAX_PROPERTY);
	}
	/**
	 * Constructor takes 7 parameters and creates an object with passed values
	 * @param name Name of the management company
	 * @param taxID Tax ID
	 * @param mgmFee management fee
	 * @param x Value of X coordinate for the plot
	 * @param y Value of Y coordinate for the plot
	 * @param width Value of the width for the plot
	 * @param depth Value of the depth for the plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		mPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		propArr = new ArrayList<Property>(MAX_PROPERTY);
	}
	/**
	 * Method takes Property object, copies it, and tests many conditions 
	 * in relation to the Company's plot
	 * @param pr Property object passed as parameter 
	 * @return index The index of the property in the array
	 */
	public int addProperty(Property pr) {
		Property prop = new Property(pr);
		propArr.add(prop);
		if(prop == null) {
			propArr.remove(prop);
			return -2;
		}
		else if(propArr.size() > getMAX_PROPERTY()) {
			propArr.remove(prop);
			return -1;
		}
		else if(!getPlot().encompasses(prop.getPlot())) {
			propArr.remove(prop);
			return -3;
		}

		if(propArr.size() > 0) {
			for(int i = 0; i < propArr.size(); i++) {
				if(propArr.get(i).getPlot().overlaps(prop.getPlot())) {
					propArr.remove(prop);
					return -4;
				}
			}
		}
		else if(getPlot().overlaps(prop.getPlot())) {
			propArr.remove(prop);
			return -4;
		}

		return propArr.indexOf(prop);
	}
	/**
	 * Method takes arguments, creates Property object, copies it, and
	 *  tests many conditions in relation to the Company's plot
	 * @param propertyName Name passed from Property object created in Driver
	 * @param city City passed from Property object created in Driver
	 * @param rent Rent amount passed from Property object created in Driver
	 * @param ownerName Owner's name passed from Property object created in Driver
	 * @return index The index of the property in the array
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		Property prop = new Property(propertyName, city, rent, ownerName);
		propArr.add(prop);
		if(prop == null) {
			propArr.remove(prop);
			return -2;
			}
		else if(propArr.size() > getMAX_PROPERTY()) {
			propArr.remove(prop);
			return -1;
		}
		else if(!getPlot().encompasses(prop.getPlot())) {
			propArr.remove(prop);
			return -3;
		}
		if(propArr.size() > 0) {
			for(int i = 0; i < propArr.size(); i++) {
				if(propArr.get(i).getPlot().overlaps(prop.getPlot())) {
					propArr.remove(prop);
					return -4;
				}
			}
		}
		else if(getPlot().overlaps(prop.getPlot())) {
			propArr.remove(prop);
			return -4;
		}
		
		return propArr.indexOf(prop);
			
	}
	/**
	 * Method takes arguments, creates Property object, copies it, and
	 *  tests many conditions in relation to the Company's plot
	 * @param propertyName Name passed from Property object created in Driver
	 * @param city City passed from Property object created in Driver
	 * @param rent Rent amount passed from Property object created in Driver
	 * @param ownerName Owner's name passed from Property object created in Driver
	 * @param x Value of X coordinate for the plot
	 * @param y Value of Y coordinate for the plot
	 * @param width Value of the width for the plot
	 * @param depth Value of the depth for the plot
	 * @return The index of the property in the array
	 */
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
		Property prop = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		propArr.add(prop);
		
		if(prop == null) {
			return -2;
		}
		else if(propArr.size() > getMAX_PROPERTY()) {
			return -1;
		}
		else if(!getPlot().encompasses(prop.getPlot())) {
			return -3;
		}
		if(propArr.size() > 0) {
			for(int i = 0; i < propArr.size(); i++) {
				if(propArr.get(i).getPlot().overlaps(prop.getPlot())) {
					propArr.remove(prop);
					return -4;
				}
			}
		}
		else if(getPlot().overlaps(prop.getPlot())) {
			propArr.remove(prop);
			return -4;
		}

		return propArr.indexOf(prop);
	}
	/**
	 * No-arg method that calculates the total rent of all the properties
	 * @return total rent amount
	 */
	public double totalRent() {
		double totalRent = 0.0;
		for(int i= 0; i < propArr.size(); i++) {
			totalRent += propArr.get(i).getRentAmount();
		}
		return totalRent;
	}
	/**
	 * No-arg method to determine the property with the highest rent
	 * @return String of the property info with the highest rent
	 */
	public String maxRentPropInfo() {
		String maxRentPropInfo = "";
		double highestRentAmt = propArr.get(0).getRentAmount();
		for(int i = 1; i < propArr.size(); i++) {
			if(propArr.get(i).getRentAmount() > highestRentAmt) {
				maxRentPropInfo = propArr.get(i).toString();
			}
		}
		return maxRentPropInfo;
	}
	/**
	 * No-arg method to determine the index of the property with the highest rent
	 * @return index of property with highest rent
	 */
	private int maxPropertyIndex() {
		int index = 0;
		double highestRentAmt = propArr.get(0).getRentAmount();
		for(int i = 1; i < propArr.size(); i++) {
			if(propArr.get(i).getRentAmount() > highestRentAmt) {
				highestRentAmt = propArr.get(i).getRentAmount();
				index++;
			}
		}
		return index;
	}
	/**
	 * No-arg method that calculates total management fee, and displays a list of 
	 * all of the properties and the total management fee
	 * @return String of properties info and total management fee
	 */
	public String toString() {
		double totalMgmtFee = totalRent() * (mgmFee * .01);
		String str = "List of the properties for " + getName() + ", Tax ID: " + taxID +
				"\n__________________________________________________\n"; 
				for(int i = 0; i < propArr.size(); i++) {
					str += propArr.get(i).toString();
				}

		return str + "__________________________________________________\nTotal Management Fee: " + 
			totalMgmtFee;		
	}
	/**
	 * Get method for management company's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Get method for the maximum amount of properties
	 * @return MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * Get method for the management company's plot
	 * @return mPlot
	 */
	public Plot getPlot() {
		return mPlot;
	}
}
