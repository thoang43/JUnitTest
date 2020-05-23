/**
 * Represents the Plot class
 * 
 * 
 *
 */
public class Plot {
	
	private int width;
	private int depth;
	private int x;
	private int y;
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param x x coordinates of the upper left corner of the plot location
	 * @param y y coordinates of the upper left corner of the plot location
	 * @param width represents the horizontal extent of the plot
	 * @param depth represents the vertical extent of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;	
	}
	
	/**
	 * Returns the Plot's depth
	 * 
	 * @return the depth
	 */
	public int getDepth() {
		
		return depth;
	}
	
	/**
	 * Gets the Plot's width
	 * 
	 * @return the width
	 */
	public int getWidth() {
		
		return width;
	}
	
	/**
	 * Returns the Plot's x coordinate
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		
		return x;
	}
	
	/**
	 * Returns the Plot's y coordinate
	 * @return y coordinate
	 */
	public int getY() {
		
		return y;
	}
	
	/**
	 * Sets the Plot's depth
	 * @param depth depth
	 */
	public void setDepth(int depth) {
		
		this.depth = depth;
	}
	
	/**
	 * Set's the Plot's width
	 * 
	 * @param width width
	 */
	public void setWidth(int width) {
		
		this.width = width;
	}
	
	/**
	 * Sets the Plot's x coordinate
	 * 
	 * @param x x coordinate
	 */
	public void setX(int x) {
		
		this.x = x;
	}
	
	/**
	 * Sets the Plot's y coordinate
	 * @param y y coordinate
	 */
	public void setY(int y) {
		
		this.y = y;
	}
	
	/**
	 * Determines if the parameter is encompassed by (is contained by) this plot
	 * 
	 * @param plot the parameter to test against this plot
	 * 
	 * @return true if this plot contains the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		
		int x2 = plot.getX();
		int y2 = plot.getY();
		int width2 = plot.getWidth();
		int depth2 = plot.getDepth();
		
		if (x <= x2 &&
			y <= y2 &&	
			(x + width) >= (x2 + width2) &&	
			(y + depth) >= (y2 + depth2))
			return true;
		else
			return false;
	}
	
	/**
	 * Determines if the parameter overlaps any of the boundaries of this plot
	 * 
	 * @param plot the parameter to test against this plot
	 * 
	 * @return true if the two plots overlap, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		
		int x2 = plot.getX();
		int y2 = plot.getY();
		int width2 = plot.getWidth();
		int depth2 = plot.getDepth();
		
		if (x >= (x2 + width2) || (x + width) <= x2) 
			return false;
		if (y >= (y2 + depth2) || (y + depth) <= y2)
			return false;
		else
			return true;
	}
	
	/**
	 * Displays the x, y width and depth of the plot
	 * 
	 * @return the string representing plot information
	 */
	public String toString() {
		
		return ("x: " + x +
				"y: " + y +
				"width: " + width +
				"depth: " + depth);
		
	}
	
}

