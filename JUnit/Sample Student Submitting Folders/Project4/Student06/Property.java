/**
 * 
 *  
 *
 */
public class Property {
	private String name;
	private String cityName;
	private double rent;
	private String propOwner;
	private Plot plot;
	/**Default constructor sets String fields to empty and rent to 0. Also creates new Object of plot 
	 * 
	 */
	public Property() {
		name="";
		cityName="";
		propOwner="";
		rent=0.0;
		
		plot=new Plot();//Calls default plot constructor for default plot
	}
	/**This constructor accepts the inputs from the user and initializes them to the fields 
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount,String owner) {
		name=propertyName;
		cityName=city;
		rent=rentAmount;
		propOwner=owner;
		plot=new Plot();//Calls default plot constructor for default plot
	}
	/**This constructor accepts 8 args and initializes the fields to the args. As well takes in the values of the new plot and sends them to the plot class and Management class to be tested. 
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName,String city,double rentAmount,String owner, int x, int y,int width, int depth) {
		//Setting the varibles to passed in parameters
		name=propertyName;
		cityName=city;
		rent=rentAmount;
		propOwner=owner;
		plot=new Plot(x,y,width,depth);//Sets up a new plot
		
	
	}
	
		
	
	
	/**Copy constructor to be used by the management class as well as setting the fields to the correct values to be returned 
	 * 
	 * @param p
	 */
		public Property(Property p) {
			//Also used by the add property method
		name=p.name;
		cityName=p.cityName;
		rent=p.rent;
		propOwner=p.propOwner;
		plot=p.plot;
		
		}
	
	/**Sets the property name 
	 * 
	 * @param propertyName
	 */
		public void setPropertyName(String propertyName) {
		name=propertyName;
		}
	
	
	/**sets the city name 
	 * 
	 * @param city
	 */
		public void setCity(String city) {
		cityName=city;
		}
	
	/**sets the rent amount 
	 * 
	 * @param rentAmount
	 */
		public void setRentAmount(double rentAmount) {
		rent=rentAmount;
		}
	/**Sets the name of the owner 
	 * 
	 * @param owner
	 */
		public void setOwner(String owner) {
		propOwner=owner;
		
		}
		
		/**
		 * 
		 * @return returns the plot 
		 */
		public Plot getPlot() {
			return plot;
		}
		
		/**
		 * 
		 * @return returns property name
		 */
		public String getPropertyName() {
			return name;
		}
		
		/**
		 * 
		 * @return returns city name 
		 */
		public String getCity() {
			return cityName;
		}
		
		/**
		 * 
		 * @return returns rent amount
		 */
		public double getRentAmount() {
			return rent;
		}
		
		
		/**
		 * 
		 * @return returns owner name 
		 */
		public String getOwner() {
			return propOwner;
		}
		/**toString to display the full information of the property as well to store inside of the array 
		 * 
		 */
		public String toString() {
			String str="";
			
			str+="\nProperty Name: "+getPropertyName();
			str+="\nLocated in "+getCity();
			str+="\nBelonging to: "+getOwner();
			str+="\nRent Amount: "+getRentAmount();
			
			
			
			return str;
		}
	
	
	

}

