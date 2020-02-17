/**
 * This class represents a plot of land
 * 
 *
 */
public class Plot {

	private int x;  // x coordinate of upper left corner
	private int y;  // y coordinate of upper left corner
	private int depth; //total depth/height
	private int width; // total width
	
	
	/**
	 * Constructor for plot, default settings with x = 0, y = 0, width = 1, depth = 1
	 */
	public Plot() {
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	
	/**
	 * Constructor for plot with 4 args
	 * @param x - x coordinates of the upper left corner
	 * @param y - y coordinates of the upper left corner
	 * @param width - represents the horizontal extent of the plot
	 * @param depth - represents the horizontal extent of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * getter for x coordinate
	 * @return x - x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * setter for x coordinate
	 * @param x - x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * getter for y coordinate
	 * @return y - y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * setter for y coordinate
	 * @param y - y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * getter for width
	 * @return width - horizontal extent
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * setter for width
	 * @param width - horizontal extent
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * getter for depth
	 * @return depth - vertical extent
	 */
	public int getDepth( ) {
		return depth;
	}
	
	/**
	 * setter for depth
	 * @param depth - vertical extent
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Determines if the parameter overlaps any of the boundaries of this plot
	 * @param plot - plot parameter to test against this plot
	 * @return true if this plot overlaps the plot, false others
	 */
	public boolean overlaps(Plot plot) {
		//checks the different corners and see if it overlaps
		return ((x < plot.x + plot.width) && 
				(x + width > plot.x) && 
				(y < plot.y + plot.depth) && 
				(y + depth > plot.y));
	}
	
	/**
	 * Determines if the parameter is encompassed by (is contained by) this plot
	 * @param plot - the parameter to test against this plot
	 * @return true if the this plot contains the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		//checks each of the corners and see if they're within the plot
		return plot.x >= x && plot.x + plot.width <= x + width
		&& plot.y >= y && plot.y + plot.depth <= y + depth;
	}
	/**
	 * returns a string representation of the plot
	 */
	public String toString() {
		String plotString = "";
		
		plotString += ("x: " + x + "\n");
		plotString += ("y: " + y + "\n");
		plotString += ("width: " + width + "\n");
		plotString += ("depth: " + depth + "\n");
		
		return plotString;
	}
}
