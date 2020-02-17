

/**
 * CMSC 203
 * 10/27/2019
 * This class is designed to manage a company's properties and display the information for them.
 * 
 *
 */

public class ManagementCompany {

    private final int MAX_PROPERTY = 5;
    private double mgmFee;
    private String name;
    private Property[] properties;
    private String taxID;
    private final int MAX_WIDTH = 10;
    private final int MAX_DEPTH = 10;
    private Plot plot;
    private int indexArray;
    

    /**
     * No-arg Constructor creates a ManagementCompany object with default values for ManagementCompany object:
     * name,tax ID set to empty strings
     * management fee to 0
     * management Plot set to x =0 , y=0 , width =MGMT_WIDTH, depth = MGMT_DEPTH
     * array of Properties is initialized here as well.
     */
    public ManagementCompany() {
    	
        name = "";
        taxID = "";
        mgmFee = 0;
        properties = new Property[MAX_PROPERTY];
        indexArray = 0;
        plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
    }

    /**
     * Creates a ManagementCompany object using the passed informations.
     * @param name
     * @param taxID
     * @param mgmFee
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
    	
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        properties = new Property[MAX_PROPERTY];
        indexArray = 0;
        plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
    }

    /**
     * Constructor Creates a ManagementCompany object using the passed informations.
     * @param name
     * @param taxID
     * @param mgmFee
     * @param x
     * @param y
     * @param width
     * @param depth
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
    	
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        properties = new Property[MAX_PROPERTY];
        indexArray = 0;
        plot = new Plot(x, y, width, depth);

    }

    /**
     * adds a Property object to the array of properties.
     * @param property
     * @return returns the index of the property
     */
    public int addProperty(Property property) {
        if (property == null) {
            return -2;
        }

        if (indexArray >= MAX_PROPERTY) {
            return -1;
        }

        if (!this.plot.encompasses(property.getPlot())) {
            return -3;
        }

        if (indexArray > 0) {
            Property p;
            for (int i = 0; i < indexArray; i++) {
                p = properties[i];

                if (property.getPlot().overlaps(p.getPlot())) {
                    return -4;
                }
            }
        }


        if (indexArray < MAX_PROPERTY) {
            properties[indexArray] = property;
            indexArray++;
        }
        return indexArray - 1;
    }

    /**
     * adds a Property object to the array of properties.
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @return returns the index of the property
     */
    public int addProperty(String name, String city, double rent, String owner) {

        Property property = new Property(name, city, rent, owner);

        if (indexArray >= MAX_PROPERTY) {
            return -1;
        }

        //we have to add NOT here because property should encompasses by the management company's plot
        if (!this.plot.encompasses(property.getPlot())) {
            return -3;
        }

        if (indexArray > 0) {
            for (int i = 0; i < indexArray; i++) {
                if (property.getPlot().overlaps(properties[i].getPlot())) {
                    return -4;
                }
            }
        }

        if (indexArray < MAX_PROPERTY) {
            properties[indexArray] = property;
            indexArray++;

        }
        return indexArray - 1;
    }

    /**
     * adds a Property object to the array of properties.
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @param x
     * @param y
     * @param width
     * @param depth
     * @return returns the index of the property
     */
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

        Property property = new Property(name, city, rent, owner, x, y, width, depth);

        if (indexArray >= MAX_PROPERTY) {
            return -1;
        }

        //we have to add NOT here because property should encompasses by the management company's plot
        if (!this.plot.encompasses(property.getPlot())) {
            return -3;
        }
        if (indexArray > 0) {
            for (int i = 0; i < indexArray; i++) {
                if (property.getPlot().overlaps(properties[i].getPlot())) {
                    return -4;
                }
            }
        }
        if (indexArray < MAX_PROPERTY) {
            properties[indexArray] = property;
            indexArray++;
        }
        return indexArray - 1;
    }
    
    /**
     * Return the MAX_PROPERTY constant that represent the size of the array of Properties.
     * @return return the MAX_PROPERTY value
     */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	/**
	 * returns the name of the management company
	 * @return returns management company's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * a reference to the plot of the management company.
	 * @return returns the plot of the management company
	 */
	public Plot getPlot() {
		return plot;
	}
    
	/**
	 * Returns the toString of the property that has the maximum rent of all properties managed by the ManagementCompany 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return returns the property with the maximum amount of rent
	 */
	public String maxRentPropInfo(){

		double temp = properties[0].getRentAmount();
		int index = 0;
		for(int i = 1; i < indexArray; i++){
			if(properties[i].getRentAmount() > temp){
				temp = properties[i].getRentAmount();
				index = i;
			}
		}
		return properties[index].toString();
	}
	
	/**
	 * Calculates the total management fee for all properties
	 * @return returns the total management fee
	 */
	public double totalManagementFee(){
		
		double temp = 0;
		for(int i = 0; i < indexArray; i++){
			temp += (properties[i].getRentAmount()) * mgmFee/100;
		}
		return temp;
	}
	
	/**
	 * Sums up the rent of all the properties
	 * @return returns the total rent of for all properties
	 */
	public double totalRent(){
		
		double temp = 0;
		for(int i = 0; i < indexArray; i++){
			temp += properties[i].getRentAmount();
		}
		return temp;
	}
	
	/**
	 * Displays the information of all the properties stored in the array of Properties
	 */
	public String toString(){
		
		String s = "______________________________________________________\n";
		s+="List for the Properties of Alliance, taxID: " + taxID;
		for(int i = 0; i < indexArray; i++){
			s += "\n";
			s += properties[i].toString();
			
		}
		s += "\n______________________________________________________";
		s += "\ntotal management Fee: " + totalManagementFee();
		return s;
	}
}