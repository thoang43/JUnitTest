import java.util.Arrays;

public class ManagementCompany {
	
	private final int MAX_PROPERTY =5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MAX_WIDTH =10;
	private final int MAX_DEPTH =10;
	private Plot plot;
	
	
	public ManagementCompany() {
		mgmFeePer = 0;
		String name = "";
		String taxID = "";
		plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
		
	}
	// make a constructor with x, y ,width and depth
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
	
	this.name = name;
	this.taxID= taxID;
	this.mgmFeePer = mgmFee;
	this.plot = new Plot (x, y, width, depth);
	properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID= otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot =  otherCompany.plot;
		properties = new Property[MAX_PROPERTY];
	}
	public int addProperty(Property property) {
		if(property.equals(null))
			return -2;
		if(!plot.encompasses(property.plot)) {
			return -3;
		}
		else {
			for(int n =0; n <properties.length; n ++) {
				if(properties[n] == null) {
					Property temp = null;
					properties[n] = temp;
					return -1;
				}
				else if (properties[n].plot.overlaps(plot)) {
					return -4;
				}
			}
		}
		return -1;
		
	}
	public int addProperty(String name,String city,double rent,String owner) {
		Property properties = new Property(name, city, rent, owner);
		return addProperty(properties);
	}
	public int addProperty(String name,String city,double rent,String owner,int x, int y, int width, int depth) {
		Property properties = new Property(name, city, rent, owner,x,y,width,depth);
		return addProperty(properties);
	}
	/**
	 * @return the mAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	public String displayPropertyAtIndex(int i) {
		String name = "";
		name += properties[i];
		return name;
	}
	public String maxPropertyRent() {
		double rent = 0;
		for (int n = 0; n < properties.length || properties[n].equals(null); n ++) {
			
			if (rent < properties[n].getRentAmount()) 
				rent = properties[n].getRentAmount();
		}
		return properties[maxPropertyRentIndex()].toString();
	}
	public int maxPropertyRentIndex() {
		double rent = 0;
		int indexValue = 0;
		for (int n = 0; n < properties.length || properties[n].equals(null); n ++) {
			
			if (rent < properties[n].getRentAmount()) { 
				rent = properties[n].getRentAmount();
				indexValue = n;
			}
		}
		return indexValue;
	}
		
	public double totalRent() {
		double rentTotal = 0;
		for (int n = 0; n < properties.length || properties[n].equals(null); n ++) {
			rentTotal +=properties[n].getRentAmount();
		}
		return rentTotal;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManagementCompany [MAX_PROPERTY=" + MAX_PROPERTY + ", mgmFeePer=" + mgmFeePer + ", name=" + name
				+ ", properties=" + Arrays.toString(properties) + ", taxID=" + taxID + ", MAX_WIDTH=" + MAX_WIDTH
				+ ", MAX_DEPTH=" + MAX_DEPTH + ", plot=" + plot + "]";
	}


}
