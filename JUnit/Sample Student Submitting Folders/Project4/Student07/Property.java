public class Property {

   String name, city, owner;
   double rentAmount;

   /**
   * @param name
   * @param city
   * @param owner
   * @param rentAmount
   */
   public Property(String name, String city, double rentAmount, String owner) {

       this.name = name;
       this.city = city;
       this.owner = owner;
       this.rentAmount = rentAmount;
   }

   /**
   * copy constructor
   *
   * @param p
   */
   public Property(Property property) {

       this.name = property.name;
       this.city = property.city;
       this.owner = property.owner;
       this.rentAmount = property.rentAmount;
   }

   /**
   * @return the name
   */
   public String getName() {
       return name;
   }

   /**
   * @param name
   * the name to set
   */
   public void setName(String name) {
       this.name = name;
   }

   /**
   * @return the city
   */
   public String getCity() {
       return city;
   }

   /**
   * @param city
   * the city to set
   */
   public void setCity(String city) {
       this.city = city;
   }

   /**
   * @return the owner
   */
   public String getOwner() {
       return owner;
   }

   /**
   * @param owner
   * the owner to set
   */
   public void setOwner(String owner) {
       this.owner = owner;
   }

   /**
   * @return the rentAmount
   */
   public double getRentAmount() {
       return rentAmount;
   }

   /**
   * @param rentAmount
   * the rentAmount to set
   */
   public void setRentAmount(double rentAmount) {
       this.rentAmount = rentAmount;
   }

   @Override
   public String toString() {
       return "Property name: " + name + ", city: " + city + ", owner: " + owner
               + ", rentAmount: " + rentAmount;
   }

}