public class ManagementCompany {
	private String name;
	private String taxID;
	private double mgmFee;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
    private final int MGMT_DEPTH = 10;
    private Property[] properties;
    private Plot mgmtPlot;
        
    public ManagementCompany() {
    	this.name = "";
    	this.taxID = "";
    	this.mgmFee = 0;
    	this.mgmtPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    	this.properties = new Property[MAX_PROPERTY];
    }
    
    public ManagementCompany(String name, String taxID, double mgmFee) {
    	this.name = name;
    	this.taxID = taxID;
    	this.mgmFee = mgmFee;
    	this.mgmtPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    	this.properties = new Property[MAX_PROPERTY];
    }
    
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
    	this.name = name;
    	this.taxID = taxID;
    	this.mgmFee = mgmFee;
    	this.mgmtPlot = new Plot(x, y, width, depth);
    	this.properties = new Property[MAX_PROPERTY];
    }
    
    public Plot getPlot() {
		return mgmtPlot;
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public String getName() {
		return name;
	}

	public int addProperty(Property property) {
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				properties[i] = property;
		        return i;
		    }
			if(properties[properties.length - 1] != null) {
				return  -1;
			}
			if(property == null) {
		    	return  -2;
		    }
			if(!this.mgmtPlot.encompasses(property.getPlot()) ) {
	    		return  -3;
	    	}
			if(properties[i].getPlot().overlaps(property.getPlot())){
	    		return -4;
	    	}
		}	
    	return 99;
    }
    
	public int addProperty(String name, String city, double rent, String owner) {
    	Property property = new Property(name, city, rent, owner);
    	for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				properties[i] = property;
		        return i;
		    }
			if(properties[properties.length - 1] != null) {
				return  -1;
			}
			if(property == null) {
		    	return  -2;
		    }
			if(!this.mgmtPlot.encompasses(property.getPlot()) ) {
	    		return  -3;
	    	}
			if(properties[i].getPlot().overlaps(property.getPlot())){
	    		return -4;
	    	}
		}	
    	return 99;
    }
	
	public int addProperty(String name, String city, double rent,String owner, int x, int y, int width, int depth) {
    	Property property = new Property(name, city, rent, owner, x, y, width, depth);
    	for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) {
				properties[i] = property;
		        return i;
		    }
			if(properties[properties.length - 1] != null) {
				return  -1;
			}
			if(property == null) {
		    	return  -2;
		    }
			if(!this.mgmtPlot.encompasses(property.getPlot()) ) {
	    		return  -3;
	    	}
			if(properties[i].getPlot().overlaps(property.getPlot())){
	    		return -4;
	    	}
		}	
    	return 99;
    }
	
	public String maxRentPropInfo() {
		int indexOfMax = 0;
    	for (int i = 0; i < properties.length; i++) {
    		if(properties[i] != null) {
    			if(properties[indexOfMax].getRentAmount() < properties[i].getRentAmount()) {
    				indexOfMax = i;
    			}
    		}
    	}
		String printInfo = "";
		printInfo =
		"Property Name: " + properties[indexOfMax].getPropertyName() +"\n" +
		"Located in " + properties[indexOfMax].getCity() + "\n" +
		"Belonging to :" + properties[indexOfMax].getOwner() + "\n" +
		"Rent Amount: " + properties[indexOfMax].getRentAmount();
		return printInfo;
	}
    
    double totalRent() {
    	double totalRent = 0;
    	for(int i = 0; i < properties.length; i++) {
    		if(properties[i] != null) {
    			totalRent += properties[i].getRentAmount();
    		}
    	}
    	return totalRent;
    }
    
    public double maxPropertyRent() {
    	double maxRentAmount = 0.0;
    	int indexOfMax = 0;
    	for (int i = 0; i < properties.length; i++) {
    		if(properties[i] != null) {
    			if(properties[indexOfMax].getRentAmount() < properties[i].getRentAmount()) {
    				indexOfMax = i;
    			}
    		}
    	}
    	maxRentAmount = properties[indexOfMax].getRentAmount();
    	return maxRentAmount;
    }

    public String toString() {
    	String printList = "";
    	printList += "List of the properties for " + name + ", " + "taxID: " + taxID +"\n";
    	printList += "______________________________________________________" +"\n";
    	for(int i = 0; i < properties.length; i++) {
    		if(properties[i] != null) {
    			printList +=
    			"Property Name: " + properties[i].getPropertyName() +"\n" +
    			"Located in " + properties[i].getCity() + "\n" +
    			"Belonging to: " + properties[i].getOwner() + "\n" +
    			"Rent Amount: " + properties[i].getRentAmount() +"\n";
    		}
    	}
    	printList += "______________________________________________________" +"\n";
    	printList += "total management Fee: " + (totalRent() * (mgmFee / 100));
    	return printList;
    }
}