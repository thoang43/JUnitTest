/**
 * The Plot class holds the coordinates, width, and depth of property
 * plots. This class also holds methods for determining overlap or encompassing.
 * 
 *
 */

public class Plot {

	//Instance variables
	int x;
	int y;
	int depth;
	int width;
	
	//Constructors
	
	/**
	 * No arg constructor - default plot values
	 */
	public Plot() {
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	
	/**
	 * Set plot values to x, y, width, and depth arguments passed
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	
	//Methods
	
	/**
	 * Determines if a plot encompasses the plot argument passed
	 * @param plot
	 * @return true if encompasses, false if not
	 */
	public boolean encompasses(Plot plot) {

		boolean encompass=false;
		if ((plot.x>=x && plot.y>=y) && ((plot.x<=x+width) && (plot.y<=y+depth)) &&		//upper left corner of plot
			(plot.x+plot.width>=x) && ((plot.x+plot.width<=x+width)) && (plot.y>=y) && (plot.y<=y+depth) &&		//upper right corner of plot
			(plot.x>=x) && (plot.x<=x+width) && (plot.y+plot.depth>=y) && (plot.y+plot.depth<=y+depth) &&		//lower left corner of plot
			(plot.x+plot.width)>=x && (plot.x+plot.width)<=(x+width) && (plot.y+plot.depth)>=y && (plot.y+plot.depth)<=y+depth){	//lower right corner of plot
			encompass=true;
		}
		return encompass;
	}
	
	
	/**
	 * Determines if two plots overlap
	 * @param plot
	 * @return true if overlap, false if not
	 */
	public boolean overlaps (Plot plot) {
		boolean overlap=false;
		//upper left corner
		if ((plot.x>x && plot.x<(x+width)) && (plot.y>y && plot.y<(y+depth))) {				
			overlap=true;
		}
		//upper right corner
		else if (((plot.x+plot.width)>x && (plot.x+plot.width)<(x+width)) && ((plot.y)>y && (plot.y<(y+depth)))) {	
			overlap=true;
		}
		//lower left corner
		else if ((plot.y+plot.depth)>y && (plot.y+plot.depth)<(y+depth) && (plot.x>x) && (plot.x<(x+width))) {					
			overlap=true;
		}
		//lower right corner
		else if(((plot.x+plot.width)>x && (plot.x+plot.width)<(x+width) && (plot.y+plot.depth)>y && (plot.y+plot.depth)<(y+depth))) {
			overlap=true;
		}
		//upper left corner
		else if ((x>plot.x && x<(plot.x+plot.width)) && (y>plot.y && y<(plot.y+plot.depth))) {			
			overlap=true;
		}
		//upper right corner
		else if (((x+width)>plot.x && (x+width)<(plot.x+plot.width)) && ((y)>plot.y && (y<(plot.y+plot.depth)))) {	
			overlap=true;
		}
		//lower left corner
		else if ((y+depth)>plot.y && (y+depth)<(plot.y+plot.depth) && (x>plot.x) && (x<(plot.x+plot.width))) {					
			overlap=true;
		}
		//lower right corner
		else if(((x+width)>plot.x && (x+width)<(plot.x+plot.width) && (y+depth)>plot.y && (y+depth)<(plot.y+plot.depth))) {
			overlap=true;
		}
		return overlap;
		
	}
	
	/**
	 * Depth value getter
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Width value getter
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * X coordinate getter
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Y coordinate getter
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Depth value setter
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth=depth;
	}
	
	/**
	 * Width value setter
	 * @param width
	 */
	public void setWidth(int width) {
		this.width=width;
	}
	
	/**
	 * X coordinate setter
	 * @param x
	 */
	public void setX(int x) {
		this.x=x;
	}
	
	/**
	 * Y coordinate setter
	 * @param y
	 */
	public void setY(int y) {
		this.y=y;
	}
	
	/**
	 * Prints out x coordinate, y coordinate, width, and depth of plot
	 * @returns String representation of plot information
	 */
	public String toString() {
		return "X: " + x +
				"\nY: " + y +
				"\nWidth: " + width +
				"\nDepth: " + depth;
	}
}
