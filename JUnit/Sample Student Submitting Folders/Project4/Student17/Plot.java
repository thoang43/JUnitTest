package assignment4;

/**
 * Plot object definition class
 * 
 *
 */

public class Plot {

	//FIELDS
	
	private int x; //x coordinates of the upper left corner of the plot location
	private int y; //y coordinates of the upper left corner of the plot location
	private int width; //width represents the horizontal extent of the plot
	private int depth; //represents the vertical extent of the plot
	

	//CONSRUCTORS
	
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
	 * Constructor taking arguments
	 * @param x  x coordinates of the upper left corner of the plot location
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
	
	
	//METHODS
	
	/**
	 * takes a Plot instance and determines if the current plot contains it.
	 * Inclusive (if an edge lies on the edge of the current plot, this is acceptable)
	 * @param plot plot argument
	 * @return if calling object encompasses argument
	 */
	public boolean encompasses(Plot plot) {
//		if plot argument goes out of range of current plot return false. Cases:
//		1. x coordinate of argument is less than x coordinate of current plot
//		2. y coordinate of argument is less than y coordinate of current plot
//		3. width of argument exceeds width of current plot
//		4. depth of argument exceeds depth of current plot)
//		return true (all test cases fail)
		if (plot == null) return false;
		if (plot.getX() < x) return false;
		if (plot.getY() < y) return false;
		if (plot.getX() + plot.getWidth() > x + width) return false;
		if (plot.getX() + plot.getDepth() > x + depth) return false;
		return true;
	} 
	
	/**
	 * takes a Plot instance and determines if it is overlapped by the current plot.
	 * @param plot plot argument
	 * @return if calling object overlaps argument
	 */
	public boolean overlaps(Plot plot) {
		/*
		 * if current plot encompasses plot argument, return true 
		 * No shared y coordinate, return false:
		 	if y coordinate of argument is less than y coordinate of current plot,
				if y + depth of argument < y coordinate of current plot return false
			else if y coordinate of current plot is less than y coordinate of argument,
		 		if y + depth of current plot < y coordinate of current plot return false
		 * No shared x coordinate, return false:
			if x coordinate of argument is less than x coordinate of current plot,
				if x + width of argument < x coordinate of current plot return false
			else if x coordinate of current plot is less than x coordinate of argument,
		 		if x + width of current plot < x coordinate of current plot return false
	 	 * some shared x and y coordinate so some shared point, return true:
	 	return true*/
		if (plot == null) return false;
		if (encompasses(plot) == true) return true;
		else {
				if (plot.getY() < y) {
					if (plot.getY() + plot.getDepth() <= y) return false;
				}
				else if (y < plot.getY()) {
					if (y + depth <= plot.getY()) return false;
				}
				if (plot.getX() < x) {
					if (plot.getX() + plot.getWidth() <= x) return false;
				}
				else if (x < plot.getX()) {
					if (x + width <= plot.getX()) return false;
				}
				return true;
		}
	}
	
	
	public int getX() {
		return x;
	}
	
	
	public int getY() {
		return y;
	}
	
	
	public int getWidth() {
		return width;
	}
	
	
	public int getDepth() {
		return depth;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Displays the x, y width and depth of the plot
	 */
	public String toString() {
		return "Coordinates: (" + x + ", " + y + ")"
				+ "\nWidth: " + width
				+ "\nDepth: " + depth;
	}

}
