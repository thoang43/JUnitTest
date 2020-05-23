import java.awt.*;
import java.awt.geom.*;

/**
 * Represents the Plot class
 *
 * 
 */
public class Plot extends java.lang.Object
{
    // instance variables
    private int x;
    private int y;
    private int width;
    private int depth;


    /**
     * No-arg Constructor
     * creates a default Plot with args x=0, y=0, width=1, depth=1
     */
    public Plot()
    {
        // initialise instance variables
        x=0;
        y=0;
        width=1;
        depth=1;
    }

    /**
     * Parameterized Constructor
     * @param x x coordinates of the upper left corner of the plot location
     * @param y y coordinates of the upper left corner of the plot location
     * @param width represents the horizontal extent of the plot
     * @param depth represents the vertical extent of the plot
     */
    public Plot(int x, int y, int width, int depth)
    {
        //initialize instance variables given custom args
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    /**
     * @return x-coordinate
     */
    public int getX()
    {
        return x;
    }

    /**
     * sets the x coordinate
     * @param x the new value to set to the x coordinate
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * @return y-coordinate
     */
    public int getY()
    {
        return y;
    }

    /**
     * sets the y coordinate
     * @param y the new value to set to the y coordinate
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * @return width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * sets the width
     * @param width the new value to set to the plot width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * @return depth
     */
    public int getDepth()
    {
        return depth;
    }

    /**
     * sets the plot depth
     * @param depth the new value to set to the plot depth
     */
    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    /**
     * Determines if the parameter overlaps any of the boundaries of this plot
     * @param plot the parameter to test against this plot
     * @return true if the two plots overlap, false otherwise
     */
    public boolean overlaps (Plot plot)
    {
        boolean overlap = false;

        int thisX = this.getX();
        int thisY = this.getY();
        int thisWidth = this.getWidth();
        int thisDepth = this.getDepth();
        Rectangle thisPlot = new Rectangle (thisX, thisY, thisWidth, thisDepth);

        int paramX = plot.getX();
        int paramY = plot.getY();
        int paramWidth = plot.getWidth();
        int paramDepth = plot.getDepth();
        Rectangle paramPlot = new Rectangle(paramX, paramY, paramWidth, paramDepth);

        overlap = thisPlot.intersects(paramPlot);

        /*//check param upLeft
        boolean upperLeft = false;
        if (thisPlot.contains(paramX, paramY)) {
            upperLeft = true;
        }
        //check param upRight
        boolean upperRight = false;
        if (thisPlot.contains(paramX+paramWidth, paramY)) {
            upperRight = true;
        }
        //check param lowLeft
        boolean lowerLeft = false;
        if (thisPlot.contains(paramX, paramY+paramDepth)) {
            lowerLeft = true;
        }
        //check param lowRight
        boolean lowerRight = false;
        if (thisPlot.contains(paramX+paramWidth, paramY+paramDepth)) {
            lowerRight = true;
        }

        //one corner must be inside & one corner must be outside
        boolean inside = false;
        if (upperLeft || upperRight || lowerLeft || lowerRight) {
            inside = true;
        }
        boolean outside = false;
        if ( !upperLeft || !upperRight || !lowerLeft || !lowerRight) {
            outside = true;
        }
        if (inside && outside) {
            overlap = true;
        }*/

        return overlap;
    }

    /**
     * Determines if the parameter is encompassed by (is contained by) this plot
     * @param plot The parameter to test against this plot
     * @return true if this plot contains the parameter, false otherwise
     */
    public boolean encompasses(Plot plot)
    {
        boolean encompass = false;

        int thisX = this.getX();
        int thisY = this.getY();
        int thisWidth = this.getWidth();
        int thisDepth = this.getDepth();
        Rectangle thisPlot = new Rectangle (thisX, thisY, thisWidth, thisDepth);

        int paramX = plot.getX();
        int paramY = plot.getY();
        int paramWidth = plot.getWidth();
        int paramDepth = plot.getDepth();
        Rectangle paramPlot = new Rectangle(paramX, paramY, paramWidth, paramDepth);

        encompass = thisPlot.contains(paramPlot);

        return encompass;
    }

    /**
     * Displays the x, y, width, and depth of the plot
     * @overrides toString in class java.lang.Object
     * @return the string representing plot information
     */
    public java.lang.String toString()
    {
        return "X="+x+"\n Y="+y+"\n WIDTH="+width+"\n DEPTH="+depth;
    }

}
