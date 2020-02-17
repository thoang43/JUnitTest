public class ManagementCompany {
private int MAX_PROPERTY = 5;
private double mgmFee;
private String name;
private Property[] properties=new Property[MAX_PROPERTY];
private String taxID;
int index = 0;
public ManagementCompany(String name, String taxID, int mgmFee) {
this.name = name;
this.taxID = taxID;
this.mgmFee = mgmFee;
}
public int addProperty(Property p1) {
// checks if index >= MAX_PROPERTY and returns -1
if(index>=MAX_PROPERTY){
return -1;
}
else{
// otherwise, stores object to current index
properties[index] = p1;
index++;
return index-1;
	}
}
public String displayPropertyAtIndex(int index) {
// adds values of properties array at index
String output = properties[index].toString();
return output;
}
public int getMAX_PROPERTY() {
return MAX_PROPERTY;
}
public int maxPropertyRentIndex() {
// maxRent represents maximum rent
double maxRent = 0;
// maxRentIndex represents maximum rent index
int maxRentIndex = 0;
for(int i=0; i<properties.length; i++){
// if maxRent < current property, changes max rent to current rent and maxRentIndex to current index
if(maxRent<properties[i].getRentAmount()){
maxRent = properties[i].getRentAmount();
maxRentIndex = i;
		}
	}
return maxRentIndex;
}
public double totalRent() {
double totalRent = 0;
for(int i=0; i<properties.length; i++){
totalRent += properties[i].getRentAmount();
	}
return totalRent;
}
public String toString() {   
String output="";
for(int i=0; i<properties.length; i++){
output += properties[i].toString()+"\n\n";
}
return ("List of the properties for Mananagemen Company, "
+ "Alliance, taxid, 1235\n-------------------------------------------\n"+output+"-------------"
		+ "------------------------------\ntotal management Fee:"+this.mgmFee);
	}
}