
public class ManagementCompany {

	//Class Variables
	
	private int MAX_PROPERTY = 5;
	private double mgmFee;
	private String companyName;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot companyPlot;
	
	private int index = 0;
	
	//Class constructors
	
	public ManagementCompany(){
		companyName = "";
		taxID = "";
		mgmFee = 0;
		properties = new Property[MAX_PROPERTY];
		companyPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		
	}
	
	ManagementCompany(String name, String taxID, double mgmFee){
		
		companyName = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		properties = new Property[MAX_PROPERTY];
		companyPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
		
		companyName = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		properties = new Property[MAX_PROPERTY];
		companyPlot = new Plot(x, y, width, depth);
	}
	
	//Class Methods
	
	public int getMAX_PROPERTY() {
		
		return MAX_PROPERTY;
		
	}
	
	public String getName() {
		
		return companyName;
	}
	
	
	public Plot getPlot() {
		
		return companyPlot;
		
	}
	
	//Add property methods
	
	public int addProperty(Property property) {
		
		//property is null
		if(property == null) {
			
			return -2;
		}
		
		  
		  //array is full
		 else if(index > 4) {
			  
			  return -1;
			  
		  }
		  
		  //overlaps
		  else if(properties[0] != null && property.getPlot().overlaps(properties[0].getPlot()) || properties[1] != null && property.getPlot().overlaps(properties[1].getPlot())
				  || properties[2] != null && property.getPlot().overlaps(properties[2].getPlot()) || properties[3] != null && property.getPlot().overlaps(properties[3].getPlot())){
					  
			  return -4;	
			  
				  }
		  
		  
		  
		  //encompasses
		
		  else if(companyPlot.encompasses(property.getPlot()) == false) {
			  
			  return -3;
		  }
		
		//adds property	
		  else if(properties[index] == null) {
			  
			  
				 
			  properties[index] = property;
			  
			  index++;
			  
			  int i = index - 1;
			  
			  
			  return i;
			  
		  }  
		
		  else {
			  return 0;
		  } 
		
		
		
				
	}
	
	
	
	public int addProperty(String name, String city, double rent, String owner) {
		
		
		//Creates property object
		  Property p = new Property(name, city, rent, owner);
		  
		//array is full
		  if(index > 4) {
			  
			  return -1;
			  
		  }
		  
		  //overlaps
		  else if(properties[0] != null && p.getPlot().overlaps(properties[0].getPlot()) || properties[1] != null && p.getPlot().overlaps(properties[1].getPlot())
				  || properties[2] != null && p.getPlot().overlaps(properties[2].getPlot()) || properties[3] != null && p.getPlot().overlaps(properties[3].getPlot())){
					  
			  return -4;	
		  
		  }
		  
		  //encompasses
		  else if(companyPlot.encompasses(p.getPlot()) == false) {
			  
			  return -3;
		  }
		  
		//add property
		  else if(properties[index] == null) {
			  
			  properties[index] = p;
			  
			  index++;
			  
			  int i = index - 1;
			  
			  return i;
			  
		  }
		  
		  else {
			  return 0;
		  } 
		  
		  
		
	}
	
	
	
	  public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth){
		
		  //Creates property object
		  Property p = new Property(name, city, rent, owner, x, y, width, depth);
		
		  //array is full
		  if(index > 4) {
			  
			  return -1;
			  
		  }
		  
		  
		  //overlaps
		  else if(properties[0] != null && p.getPlot().overlaps(properties[0].getPlot()) || properties[1] != null && p.getPlot().overlaps(properties[1].getPlot())
				  || properties[2] != null && p.getPlot().overlaps(properties[2].getPlot()) || properties[3] != null && p.getPlot().overlaps(properties[3].getPlot())){
					  
			  return -4;	
		  
		  }
		  
		  
		  //encompasses
		  else if(companyPlot.encompasses(p.getPlot()) == false) {
			  
			  return -3;
		  }
		  
		  //add property
		  else if(properties[index] == null) {
			  
			  properties[index] = p;
			  
			  index++;
			  
			  int i = index - 1;
			  
			  return i;
			  
		  }
		  
		  else {
			  return 0;
		  }
		
	  }
	 
	
	
	public double totalRent(){
		
		double r = 0;
		
		for(int i = 0; i < properties.length; i++){
		
			if(properties[i] != null) {
			
			r += properties[i].getRentAmount();
		
			}
		}
		
		return r;
		
	
	}
	
	
	
	public String maxRentPropInfo() {
		
		double max = 0;
		String maxRent = "";
		
		
		for(int i = 0; i < properties.length; i++){
		
			if(properties[i] != null) {
			
				if(properties[i].getRentAmount() > max){
					
				max = properties[i].getRentAmount();	
					
				maxRent = properties[i].toString();
				}
				
			}
		}
		
		return maxRent;
		
	}
	
	private int maxPropertyIndex() {
		
		double max = 0;
		int index = 0;
		
		for(int i = 0; i < properties.length; i++){
			
			if(properties[i] != null) {
				
				if(properties[i].getRentAmount() > max){
					
					max = properties[i].getRentAmount();
					
					index = i;
				}
			
			
			}
			
		}
		
		return index;
	}
	
	
	//to string
	 public String toString(){
	 
	 String mc = "";
	 
	 for(int i = 0; i < properties.length; i++) {
		 
		 
		if(properties[i] != null) { 
		 
		 mc += "Property Name: " + properties[i].getPropertyName() + "\n" +
				 "Located in " + properties[i].getCity() + "\n" + 
				 "Belonging to: " + properties[i].getOwner() + "\n" + 
				 "Rent Amount: " + properties[i].getRentAmount() + "\n" +
				 "total management Fee: " + mgmFee;
				 System.out.println();
		}
	 }
	 
	 
	 return mc;
		 
	 }
	
	
	
}	
