
/**
 * CMSC 203
 * 10/27/2019
 * This class is designed to read in the coordinates and width and depth that a property possesses 
 * on a graph
 * 
 *
 */

public class Plot{
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
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
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Determines if the parameter is encompassed by (is contained by) this plot
	 * @param plot
	 * @return
	 */
	public boolean encompasses(Plot plot) {
		
		if((getX() + getWidth()) > (plot.getX() + plot.getWidth()) && 
				(getY() + getDepth()) > (plot.getY() + plot.getDepth()) &&
					getX() <= plot.getX() && getY() <= plot.getY())
			return true;
		else
			return false;
			
	}
	
	/**
	 * Determines if the parameter overlaps any of the boundaries of this plot
	 * @param plot
	 * @return
	 */
	public boolean overlaps(Plot plot) {

		int[] rec1 = {getX(), getY(), getX() + getWidth(), getY() + getDepth()};  
		int[] rec2 = {plot.getX(), plot.getY(), plot.getX() + plot.getWidth(), plot.getY() + plot.getDepth()};
		if(rec1[0] < rec2[2] && rec1[1] < rec2[3] && rec2[0] < rec1[2] && rec2[1] < rec1[3])
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the x-coordinate of an object
	 * @return returns the x-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of an object
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y-coordinate of an object
	 * @return returns the y-coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate of an object
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the width of an object
	 * @return returns the object's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of an object
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the depth of an object
	 * @return returns the object's depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth of an object
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
}