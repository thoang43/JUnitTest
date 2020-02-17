public class Property {
private String city;
private String owner;
private String propertyName;
private double rentAmount;
public Property () {
city = "";
owner = "";
propertyName = "";
rentAmount = 0.0;
}
public Property (Property p)
{
propertyName = p.propertyName;
city = p.city;
rentAmount = p.rentAmount;
owner = p.owner;
}
public Property(String propertyName, String city, double rentAmount,String owner) {
this.propertyName = propertyName;
this.city = city;
this.rentAmount = rentAmount;
this.owner = owner;
}
public void setLoc(String city) {
this.city = city;
}
public String getPropertyName() {
return propertyName;
}
public String getCity() {
return city;
}
public double getRentAmount() {
return rentAmount;
}
public void setRentAmount(double rentAmount) {
this.rentAmount = rentAmount;
}
public String getOwner() {
return owner;
}
public void setOwner(String owner) {
this.owner = owner;
}
public String toString() {
//Property name belonging to rent amount
return "Property Name: " + this.propertyName + "\n" + "Located: " + this.city + "\n" + "Belonging to: "
		+ this.owner + "\n" + "Rent Amount: " + this.rentAmount;
	}
}