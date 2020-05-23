/**
 * 
 *  
 *
 */
public class Plot {
private int x;
private int y;
private int width;
private int depth;
/**Default constructor sets x,y to 0 and width and depth to 1
 * 
 */
	Plot(){
	
	this.x = 0;//Default X
	this.y = 0;//Default y
	this.width=1;//Default width
	this.depth=1;//Default depth
	
}
/**
 * Cpnstructor with 4 parameters and then sets the values from parameters to the fields
 * @param x
 * @param y
 * @param width
 * @param depth
 */
Plot(int x, int y,int width, int depth){
	this.x=x;//Default X
	this.y=y;//Default y
	this.width=width;//Default width
	this.depth=depth;//Default depth
	}

/**Sets x to passed in value
 * 
 * @param x
 */
	public void setX(int x) {
	this.x=x;
		}
	/**sets y to passed in value 
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y=y;
	}
	/**Sets width to passed in value
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width=width;
	}
	/**Sets the depth to the passed in value 
	 * 
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth=depth;
	}
	/**Takes in the plot then test if it overlaps with any other plots 
	 * 
	 * @param plot
	 * @return
	 */
	public boolean overlaps(Plot plot) {
		return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y;
		
	}
	
	
		/**This will first get the management Plot then test if the user's plot is inside of the management plot.  
		 * 
		 * @param plot
		 * @return
		 */
	public boolean encompasses(Plot plot){
		
		return plot.x>= x && plot.x <= x+width && plot.y >= y && plot.y <= (y+depth) &&plot.x + plot.width>= x && (plot.x+plot.width) <= (x+width) && plot.y >= y && plot.y <=  y+depth;

                
    }
/**Displays the coordinates of the plot as a String
 * 
 */
	public String toString(){
		return "\nx= "+ this.x+"\ny= "+this.y+"\nWidth="+this.width+"\nDepth= "+this.depth;
	}
/**
 * 
 * @return returns width 
 */
	public int getWidth() {
		return this.width;
	}
/**
 * 
 * @return returns depth 
 */
	public int getDepth() {
		
		return this.depth;
	}
/**
 * 
 * @return returns x coordinate 
 */
	public int getX() {
		return this.x;
	}
/**
 * 
 * @return returns y coordinate 
 */
	public int getY() {
		
		return this.y;
	}
	
	
	
	
}



