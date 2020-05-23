
/**
 * Represents a Property object
 *
 * 
 */
public class Property extends java.lang.Object
{
    // instance variables - replace the example below with your own
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    /**
     * No-arg Constructor, creates a new object using empty strings for the property name, city, and owner.
     * The plot is set to the default Plot.
     */
    public Property()
    {
        propertyName = "";
        city = "";
        owner = "";
        plot = new Plot();
    }

    /**
     * Parameterized constructor, sets the property information to the passed parameters.
     *
     * @param propertyName property name
     * @param city city where the property is located
     * @param rentAmount rent amount
     * @param owner the owner's name
     */
    public Property(String propertyName, String city, double rentAmount, String owner)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot();
    }

    /**
     * Parameterized constructor, sets the property information to the passed parameters.
     *
     * @param propertyName property name
     * @param city city where the property is located
     * @param rentAmount rent amount
     * @param owner the owner's name
     * @param x x coordinate of the upper left corner of the propert's plot
     * @param y y coordinate of the upper left corner of the property's plot
     * @param width the plot's width
     * @param depth the plot's depth
     */
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot(x, y, width, depth);
    }

    /**
     * Copy constructor, creates a new object using the information of the Property object passed to it
     * @param p a Property object
     */
    public Property(Property p)
    {
        String tempName = p.getPropertyName();
        String tempCity = p.getCity();
        double tempAmount = p.getRentAmount();
        String tempOwner = p.getOwner();
        Plot tempPlot = p.getPlot();
        int tempX = tempPlot.getX();
        int tempY = tempPlot.getY();
        int tempWidth = tempPlot.getWidth();
        int tempDepth = tempPlot.getDepth();
        new Property(tempName, tempCity, tempAmount, tempOwner, tempX, tempY, tempWidth, tempDepth);
    }

    /**
     * returns the plot of ther property
     * @return the plot of the property
     */
    public Plot getPlot()
    {
        return plot;
    }

    /**
     * return the name of the property
     * @return the propertyName
     */
    public String getPropertyName()
    {
        return propertyName;
    }

    /**
     * sets the property name to the passed parameter
     * @param propertyName the propertyName to set
     */
    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }

    /**
     * returns the city where the property is located
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * set the propery's city to the passed parameter
     * @param city the city to be set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * returns the property's rent amount
     * @return the rentAmount
     */
    public double getRentAmount()
    {
        return rentAmount;
    }

    /**
     * sets the property's rent to the passed parameter
     * @param rentAmount the rentAmount to set
     */
    public void setRentAmount(double rentAmount)
    {
        this.rentAmount = rentAmount;
    }

    /**
     * returns the property's owner
     * @return the owner
     */
    public String getOwner()
    {
        return owner;
    }

    /**
     * sets the property's owner name to the passed parameter
     * @param owner the owner to set
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    /**
     * prints out the name, city, owner, and rent amount for a property
     * @override toString in class java.lang.Object
     * @return Returns the string representation of a Property object as the following format:
     * Property Name: Lakewood
     * Located in Rockville
     * Belonging to: Alex Tan
     * Rent Amount: 3000.0
     * Be sure the last item is the rent amount preceded by a space
     */
    public String toString()
    {
        String toReturn
                = "Property Name: "+propertyName+" \n "
                + "Located in "+city+" \n "
                +"Belonging to: "+owner+" \n "
                +"Rent Amount: "+rentAmount;

        return toReturn;
    }
}
