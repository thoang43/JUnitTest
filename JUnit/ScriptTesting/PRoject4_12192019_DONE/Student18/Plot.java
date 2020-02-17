
public class Plot {
	
	private int x, y, width, depth;
	/**
	 * default constructors x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		x=0;
		y=0;
		width=1;
		depth=1;
	}
	/**
	 * Copy Constructor
	 * @param p represents a plot object
	 */
	public Plot(Plot p) {
		this.x= p.x;
		this.y= p.y;
		this.width= p.width;
		this.depth= p.depth; 
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x= x;
		this.y= y;
		this.width=width;
		this.depth= depth;
	}
	/**
	 * 
	 * @param plot
	 * @return true or false
	 */
	public boolean overlaps(Plot plot) {
		if(y<plot.y + plot.depth && y+depth >plot.y && x<plot.x + plot.width && x + width > plot.x)
			return true;
		else {
			return false;
		}
	}
	public boolean encompasses(Plot plot){
		if(y<=plot.y && y+depth >= plot.y + plot.depth && x<=plot.x && x + width >= plot.x + plot.width)
		return true;
		else {
		return false;
		}
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String toString() {
		return "Upper Left: (" + x +"," + y + "); Width: " +width + "Depth:" + depth;
	}
}
