/**
 * This is a diagram of the Plot class. It contains the coordinates
 * and size of a particular property.
 * 
 * 
 * CMSC 203
 * 10/26/2019
 *
 */
public class Plot {

	//////////////////////////////// PLOT FIELDS ///////////////////////
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/////////////////////////////// CONSTRUCTORS ///////////////////////	
	
	/**
	 * Default constructor that sets x and y to 0,
	 * and width and depth to 1.
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	/**
	 * 4 argument constructor that accepts x and y coordinates,
	 * and the width and depth of the property.
	 * @param xCoord The x coordinate of the top left corner of the property.
	 * @param yCoord The y coordinate of the top left corner of the property.
	 * @param w The width of the property.
	 * @param d The depth of the property.
	 */
	public Plot(int xCoord, int yCoord, int w, int d) {
		x = xCoord;
		y = yCoord;
		width = w;
		depth = d;
	}
	
	///////////////////////////////// GETTERS //////////////////////////
	
	/**
	 * Returns the x coordinate of the plot.
	 * @return Returns the x coordinate of the plot.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Returns the y coordinate of the plot.
	 * @return Returns the y coordinate of the plot.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Returns the width of the property.
	 * @return Returns the width of the property.
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Returns the depth of the property.
	 * @return Returns the depth of the property.
	 */
	public int getDepth() {
		return depth;
	}
	
	///////////////////////////////// SETTERS //////////////////////////
	
	/**
	 * Sets the x coordinate of the plot.
	 * @param xCoord The x coordinate of the top left corner of the plot.
	 */
	public void setX(int xCoord) {
		x = xCoord;
	}
	/**
	 * Sets the y coordinate of the plot.
	 * @param xCoord The y coordinate of the top left corner of the plot.
	 */
	public void setY(int yCoord) {
		y = yCoord;
	}
	/**
	 * Sets the width of the plot.
	 * @param xCoord The width of the plot.
	 */
	public void setWidth(int w) {
		width = w;
	}
	/**
	 * Sets the depth of the plot.
	 * @param xCoord The depth of the plot.
	 */
	public void setDepth(int d) {
		depth = d;
	}
	
	///////////////////////////// GENERAL METHODS //////////////////////
	
	/**
	 * This method checks to see if the plot overlaps the plot passed
	 * to the method.
	 * @param plot The plot to compare the current plot to.
	 * @return Returns true if the calling plot is within the borders
	 * 			of the plot parameter passed to the method. Returns
	 * 			false if it does not fit within the borders of the
	 * 			parameter plot.
	 */
	public boolean overlaps(Plot plot) {
		
		
		// Boolean value for whether or not a plot overlaps another.
		boolean oLap = false;
		
		// Check to see if the bottom right corner of the calling plot
		// is less than the parameter plot's top left corner. Also check to see if the calling
		// plot's top left corner is greater than the parameter plot's bottom right corner.
		if ( (((x + width <= plot.x) || (y + depth <= plot.y))) || 
				(((x) >= (plot.x + plot.width)) || ((y) >= (plot.y + plot.depth))) ) {
			// If true, the plots do not overlap.
			oLap = false;
		}
		else
			// The plots overlap.
			oLap = true;

		return oLap;
	}
	/**
	 * This method checks to see if the calling plot
	 * encompasses the plot passed to the method.
	 * @param plot A plot we are testing to see if it falls within the calling plot.
	 * @return Returns true if the parameter's plot is within the calling plot's 
	 * 			boundaries. Returns false if not.
	 */
	public boolean encompasses( Plot plot) {
		
		// A boolean to represent if the plot encompasses another plot.
		boolean oLap = false;
		
		/* Check to see if the top left corner of the calling plot
		 * is less than the top left corner of the parameter's plot. 
		 * Also check to see if the bottom right corner of the calling
		 * plot is greater than the bottom right corner of the parameter's
		 * plot. 
		 */
		if ( (((x <= plot.x) && (y <= plot.y))) && 
				(((x + width) >= (plot.x + plot.width)) && ((y + depth) >= (plot.y + plot.depth))) ) {
			// If true, the plot encompasses the parameter plot.
			oLap = true;
		}
		else
			// The plot does not encompass the parameter plot.
			oLap = false;
		
		return oLap;
	}
	/**
	 * Creates a string to display the plot information.
	 */
	public String toString() {
		
		// Create a String object to display the plot's information.
		String plotInfo;
		
		// Format the string.
		plotInfo = String.format("X Coordinate: %d\nY Coordinate: %d\n"
				+ "Width: %d\nDepth: %d", x, y, width, depth);
		
		return plotInfo;
	}
	
}
