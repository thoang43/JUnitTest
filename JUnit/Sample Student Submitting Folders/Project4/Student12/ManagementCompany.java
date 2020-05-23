
/**
 * Represents management company object
 *
 * 
 */
public class ManagementCompany extends java.lang.Object
{
    // instance variables - replace the example below with your own
    private String name;
    private String taxID;
    private double mgmFee;
    private static final int MAX_PROPERTY=5;
    private Property[] propertyArray;
    private static final int MGMT_WIDTH=10;
    private static final int MGM_DEPTH=10;
    private Plot mgmPlot;

    /**
     * No-arg Constructor
     * creates a ManagementCompany (MgmCmpny) object with default values for MgmCmpny object:
     * name & taxID set to empty strings
     * mgmFee to 0
     * mgmPlot set to x=0, y=0, width = MGMT_WIDTH, depth = MGMT_DEPTH
     * array of Properties initialized above
     */
    public ManagementCompany()
    {
        name = "";
        taxID = "";
        mgmFee = 0;
        mgmPlot = new Plot(0, 0, MGMT_WIDTH, MGM_DEPTH);
        propertyArray = new Property[MAX_PROPERTY];
    }

    /**
     * Creates a ManagementCompany (MgmCmpny) object using the passed informations.
     * Array of Properties initialized above.
     * mgmPlot is set to a plot with x,y coordinates set to 0 and width/depth set to respective constants
     *
     * @param name management company name
     * @param taxID tax I.D.
     * @param mgmFee management fee
     */
    public ManagementCompany(String name, String taxID, double mgmFee)
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        mgmPlot = new Plot(0, 0, MGMT_WIDTH, MGM_DEPTH);
        propertyArray = new Property[MAX_PROPERTY];
    }

    /**
     * Constructor creates a MgmCmpny object using the passed information.
     * Array of properties initialized above.
     * mgmPlot set to a plot with x,y coord set to 0 and width/depth set to respective constants
     *
     * @param name management company name
     * @param taxID tax I.D.
     * @param mgmFee management fee
     * @param x x coordinate of the management plot
     * @param y y coordinate of the management plot
     * @param width width of the management plot
     * @param depth depth of the management plot
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        mgmPlot = new Plot(x, y, width, depth);
        propertyArray = new Property[MAX_PROPERTY];
    }

    /**
     * Returns the MAX_PROPERTY constant that represents the size of the array of Properties
     * @return the MAX_PROPERTY, a constant attribute for this class currently set to 5
     */
    public int getMAX_PROPERTY()
    {
        return MAX_PROPERTY;
    }

    /**
     * a reference to the plot of the management company
     * @return the plot of the management company
     */
    public Plot getPlot()
    {
        return mgmPlot;
    }

    /**
     * returns the name of the management company
     * @return the name of the management company
     */
    public String getName()
    {
        return name;
    }

    /**
     * (4-param version) adds a property object to the array of properties
     *
     * @param name
     * @param city
     * @param rent
     * @param owner
     * @return ONE OF THE FOLLOWING INTEGERS:
     * if the property is added, return the index of said property
     * -1 if the array is full
     * -2 if the property is null
     * -3 if the plot for the property is not encompassed by the mgmCmpny plot
     * or -4 if the plot for the property overlaps any other property's plot.
     * (-5 if this method has an error)
     */
    public int addProperty(String name, String city, double rent, String owner)
    {
        Property toAdd = new Property(name, city, rent, owner);
        if (toAdd == null)
            return -2;

        Plot addPlot = toAdd.getPlot();
        boolean encompass = mgmPlot.encompasses(addPlot);
        if (!encompass)
            return -3;

        boolean overlapMaster = false;
        for (int i = 0; i <propertyArray.length; i++)
        {
            Property iProperty = propertyArray[i];
            if (iProperty != null)
            {
                Plot iPlot = propertyArray[i].getPlot();
                boolean iOverlap = iPlot.overlaps(addPlot);
                if (iOverlap)
                {
                    overlapMaster = true;
                    return -4; 
                }
            }
        }

        int emptyIndex = -1;
        boolean added = false;
        for (int i = 0; i < propertyArray.length; i++)
        {
            if (!added && !overlapMaster)
            {
                if (propertyArray[i] == null)
                {
                    emptyIndex = i;
                    added = true;
                    break;
                }
            }
        }
        if (emptyIndex >= 0 && toAdd!=null && !overlapMaster)
        {
            propertyArray[emptyIndex] = toAdd;
            return emptyIndex;
        }
        else if (emptyIndex == -1)
            return emptyIndex;
        else
            return -5;
    }

    /**
     * (1-param version) adds a Property object to the array of properties
     * @param property a Property object
     * @return ONE OF THE FOLLOWING INTEGERS:
     * if the property is added, return the index of said property
     * -1 if the array is full
     * -2 if the property is null
     * -3 if the plot for the property is not encompassed by the mgmCmpny plot
     * or -4 if the plot for the property overlaps any other property's plot.
     * (-5 if this method has an error)
     */
    public int addProperty(Property property)
    {
        if (property == null)
            return -2;
        
        Plot addPlot = property.getPlot();
        boolean encompass = mgmPlot.encompasses(addPlot);
        if (!encompass)
            return -3;

        boolean overlapMaster = false;
        for (int i = 0; i < propertyArray.length; i++)
        {
            Property iProperty = propertyArray[i];
            if (iProperty != null)
            {
                Plot iPlot = iProperty.getPlot();
                boolean iOverlap = iPlot.overlaps(addPlot);
                if (iOverlap)
                {
                    overlapMaster = true;
                    return -4;
                }
            }
        }

        int emptyIndex = -1;
        boolean added = false;
        for (int i = 0; i < propertyArray.length; i++)
        {
            if (!added && !overlapMaster)
            {
                if (propertyArray[i] == null)
                {
                    emptyIndex = i;
                    added = true;
                    break;
                }
            }
        }
        if (emptyIndex >= 0 && property!=null && !overlapMaster)
        {
            propertyArray[emptyIndex] = property;
            return emptyIndex;
        }
        else if (emptyIndex == -1)
            return emptyIndex;
        else
            return -5;
    }

    /**
     * (8-param version) adds a Property object to the array of properties.
     * @param name name of the property
     * @param city city of the property
     * @param rent property's rent amount
     * @param owner property's owner
     * @param x x coordinate of the property's plot
     * @param y y coordinate of the property's plot
     * @param width width of the property's plot
     * @param depth depth of the property's plot
     * @return ONE OF THE FOLLOWING INTEGERS:
     * if the property is added, return the index of said property
     * -1 if the array is full
     * -2 if the property is null
     * -3 if the plot for the property is not encompassed by the mgmCmpny plot
     * or -4 if the plot for the property overlaps any other property's plot.
     * (-5 if this method has an error)
     */
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
    {
        Property toAdd = new Property(name, city, rent, owner, x, y, width, depth);
        if (toAdd == null)
            return -2;

        Plot addPlot = toAdd.getPlot();
        boolean encompass = mgmPlot.encompasses(addPlot);
        if (!encompass)
            return -3;

        boolean overlapMaster = false;
        for (int i = 0; i < propertyArray.length; i++)
        {
            Property iProperty = propertyArray[i];
            if (iProperty != null)
            {
                Plot iPlot = iProperty.getPlot();
                boolean iOverlap = iPlot.overlaps(addPlot);
                if (iOverlap)
                {
                    overlapMaster = true;
                    return -4;
                }
            }
        }

        int emptyIndex = -1;
        boolean added = false;
        for (int i = 0; i < propertyArray.length; i++)
        {
            if (!added && !overlapMaster)
            {
                if (propertyArray[i] == null)
                {
                    emptyIndex = i;
                    added = true;
                    break;
                }
            }
        }
        if (emptyIndex >= 0 && toAdd!=null && !overlapMaster)
        {
            propertyArray[emptyIndex] = toAdd;
            return emptyIndex;
        }
        
        else if (emptyIndex == -1)
            return emptyIndex;
        
        else
            return -5;
    }

    /**
     * Accesses each Property object stored in the array of Properties and sums up the properties' rent and returns total
     * @return total rent of the properties
     */
    public double totalRent()
    {
        double totalRent = 0;
        for (int i = 0; i < propertyArray.length; i++)
        {
            Property iProperty = propertyArray[i];
            if (iProperty != null)
            {
                double iRent = iProperty.getRentAmount();
                totalRent += iRent;
            }
        }
        return totalRent;
    }

    /**
     * Returns the toString of the property that has the maximum rent of all properties managed by the ManagementCompany
     * NOTE: for simplicity assume that each "Property" object's rent amount is different
     * @return String that is the toString of the max-rent property
     */
    public String maxRentPropInfo()
    {
        double maxRent = 0;
        Property maxProperty = null;
        for (int i = 0; i < propertyArray.length; i++)
        {
            Property iProperty = propertyArray[i];
            if (iProperty != null)
            {
                double iRent = iProperty.getRentAmount();
                if (iRent > maxRent)
                {
                    maxRent = iRent;
                    maxProperty = iProperty;
                }
            }
        }
        String toReturn = maxProperty.toString();
        return toReturn;
    }

    /**
     * Displays the information of all the properties stored in the array of Properties
     * @override toString in class java.lang.Object
     * @return information of ALL the properties within this management company by accessing propertyArray.
     * The format is as following example: \n
     * List of the properties for Alliance, taxID: 12345
     * __________________________________________________
     * Property Name : Belmar
     * Located in Silver Spring
     * Belonging to:John Smith
     * Rent Amount: 1200.0 (72)
     * Property Name : Camden Lakeway
     * Located in Rockville
     * Belonging to:Ann Taylor
     * Rent Amount: 2450.0 (147)
     * Property Name : Hamptons
     * Located in Rockville
     * Belonging to:Rick Steves
     * Rent Amount: 1250.0 (75)
     * __________________________________________________
     * total management Fee: 294.0
     */
    public String toString()
    {
        String propertyStrings = "";
        double totalMgmFee = 0;
        for (int i = 0; i < propertyArray.length; i++)
        {
            Property iProperty = propertyArray[i];
            if (iProperty != null)
            {
                propertyStrings += " \n "+propertyArray[i].toString();
                double rent = iProperty.getRentAmount();
                double rentWithMgmFee = rent * (mgmFee*.01);
                totalMgmFee += rentWithMgmFee;
            }
        }
        String toReturn
        = "List of the properties for "+name+", taxID: "+taxID+"\n"
            +"______________________________________________________"+"\n"
            +propertyStrings+"\n"
            +"______________________________________________________"+"\n"
            +"total management Fee: "+totalMgmFee;

        return toReturn;
    }
}
