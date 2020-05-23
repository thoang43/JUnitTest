/**
 * A plot object will contain information relevant to its location: x coordinates, 
 * y coordinates, the width of the plot, and the depth of the plot, all set on creation,
 * and can be retrieved or changed as well. When created, plots can be compared to each
 * other, and find if they're overlapping and/or encompassing one another.
 * 
 * 
 */

public class Plot 
{
	//instance fields
	/**the x coordinate of the top left corner of the plot*/
	private int x;
	/**the y coordinate of the top left corner of the plot*/
	private int y;
	/**the width of the plot*/
	private int width;
	/**the depth of the plot*/	
	private int depth;
		
	//constructors
	/**No-arg constructor creates a Plot with default values: <br>
	 * x will be set to 0 <br>
	 * y will be set to 0 <br>
	 * width will be set to 1 <br>
	 * depth will be set to 1 
	 */
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**Constructs a Plot with the given x coordinate, y coordinate, the width, and the depth.
	 * @param xCoords the x coordinate of the top left corner of the plot
	 * @param yCoords the y coordinate of the top left corner of the plot
	 * @param theWidth the width of the plot
	 * @param theDepth the depth of the plot
	 */
	public Plot(int xCoords, int yCoords, int theWidth, int theDepth)
	{
		x = xCoords;
		y = yCoords;
		width = theWidth;
		depth = theDepth;
	}
	
	//public methods
	/**Gets the x coordinate of the top left corner of the plot
	 * @return x - the x coordinate
	 */
	public int getX() {return x;}
	
	/**Sets the x coordinate of the top left corner of the plot
	 * @param xCoords the x coordinate to be set
	 */
	public void setX(int xCoords) {x = xCoords;}
	
	/**Gets the y coordinate of the top left corner of the plot
	 * @return y - the y coordinate
	 */
	public int getY() {return y;}
	
	/**Sets the y coordinate of the top left corner of the plot
	 * @param yCoords the y coordinate to be set
	 */
	public void setY(int yCoords) {y = yCoords;}
	
	/**Gets the width of the plot
	 * @return width - the width
	 */
	public int getWidth() {return width;}
	
	/**Sets the width of the plot
	 * @param theWidth the width to be set
	 */
	public void setWidth(int theWidth) {width = theWidth;}
	
	/**Gets the Depth of the plot
	 * @return depth - the depth
	 */
	public int getDepth() {return depth;}
	
	/**Sets the depth of the plot 
	 * @param theDepth the depth to be set
	 */
	public void setDepth(int theDepth) {depth = theDepth;}
	
	/**Finds out if the current plot is overlapping a given plot, and vice versa.
	 * @param plot the plot given that's being compared with the current plot
	 * @return true if the two plots are overlapping <br>
	 * 		   false if not
	 */
	public boolean overlaps(Plot plot)
	{
		//find information regarding the two plots
		//information about the current plot
		int thisXRightBounds = x + width,			//the x coordinate of the right bounds of the current plot
			thisXLeftBounds = x,					//the x coordinate of the left bounds of the current plot
			thisYBottomBounds = y + depth,			//the y coordinate of the bottom bounds of the current plot
			thisYTopBounds = y,						//the y coordinate of the top bounds of the current plot
		//information about the given plot
			plotXRightBounds = plot.x + plot.width, //the x coordinate of the right bounds of the given plot
			plotXLeftBounds = plot.x,				//the x coordinate of the left bounds of the given plot
			plotYBottomBounds = plot.y + plot.depth,//the y coordinate of the bottom bounds of the given plot
			plotYTopBounds = plot.y;				//the y coordinate of the top bounds of the given plot

		//check if the x and y coordinate of both plots are the same
		if(x == plot.x && y == plot.y)
		return true;
		
		//check if the first plot's coordinate is within the second plot, and vice versa
		if((x >= plotXLeftBounds && x < plotXRightBounds && y >= plotYTopBounds && y < plotYBottomBounds) ||
		   (plot.x >= thisXLeftBounds && plot.x < thisXRightBounds && plot.y >= thisYTopBounds && plot.y < thisYBottomBounds))
		return true;
		
		//check if the first plot encompasses the second plot or vice versa
		if(this.encompasses(plot) || plot.encompasses(this))
		return true;
		
		//represents the number of instances of the boundaries of two plots touching/overlapping each other
		int numOfBoundsTouched = 0;
		
		//count how many instances of boundaries are touching/overlapping 
		if(thisXLeftBounds == plotXRightBounds) numOfBoundsTouched++;
		if(thisXRightBounds == plotXLeftBounds) numOfBoundsTouched++;
		if(thisYTopBounds == plotYBottomBounds) numOfBoundsTouched++;
		if(thisYBottomBounds == plotYTopBounds) numOfBoundsTouched++;
		
		//check if any point of the top boundary of the current plot is within the given plot, and vice versa
		for(int p = thisXLeftBounds; p <= thisXRightBounds; p++)
		{
			if(p >= plotXLeftBounds && p < plotXRightBounds)
			{
				if(thisYTopBounds > plotYTopBounds && thisYTopBounds < plotYBottomBounds)
				{
					//if found to be possibly overlapping, determine if it's undeniably overlapping, given the number of boundaries that have touched/overlapped
					if(numOfBoundsTouched > 1 || numOfBoundsTouched == 0)
					{
						return true;
					}
				}
			}
		}
		for(int p = plotXLeftBounds; p <= plotXRightBounds; p++)
		{
			if(p >= thisXLeftBounds && p < thisXRightBounds)
			{
				if(plotYTopBounds > thisYTopBounds && plotYTopBounds < thisYBottomBounds)
				{
					//if found to be possibly overlapping, determine if it's undeniably overlapping, given the number of boundaries that have touched/overlapped
					if(numOfBoundsTouched > 1 || numOfBoundsTouched == 0)
					{
						return true;
					}
				}
			}
		}

		//check if any point of the left boundary of the current plot is within the given plot, and vice versa
		for(int p = thisYTopBounds; p <= thisYBottomBounds; p++)
		{
			if(p >= plotYTopBounds && p < plotYBottomBounds)
			{
				if(thisXLeftBounds > plotXLeftBounds && thisXLeftBounds < plotXRightBounds)
				{
					//if found to be possibly overlapping, determine if it's undeniably overlapping, given the number of boundaries that have touched/overlapped
					if(numOfBoundsTouched > 1 || numOfBoundsTouched == 0)
					{
						return true;
					}
				}
			}
		}
		for(int p = plotYTopBounds; p <= plotYBottomBounds; p++)
		{
			if(p >= thisYTopBounds && p < thisYBottomBounds)
			{
				if(plotXLeftBounds > thisXLeftBounds && plotXLeftBounds < thisXRightBounds)
				{
					//if found to be possibly overlapping, determine if it's undeniably overlapping, given the number of boundaries that have touched/overlapped
					if(numOfBoundsTouched > 1 || numOfBoundsTouched == 0)
					{
						return true;
					}
				}
			}
		}
		
		//nothing was determined to be true, therefore the 2 plots aren't overlapping
		return false;
	}
	
	/**Finds out if the current plot is encompassed by the given plot, and vice versa.
	 * @param plot the plot given that's being compared with the current plot
	 * @return true if one of the plots is overlapping the other<br>
	 * 		   false if not
	 */
	public boolean encompasses(Plot plot)
	{
		//find information regarding the two plots
		//information about the current plot
		int thisXRightBounds = x + width,			//the x coordinate of the right bounds of the current plot
			thisXLeftBounds = x,					//the x coordinate of the left bounds of the current plot
			thisYBottomBounds = y + depth,			//the y coordinate of the bottom bounds of the current plot
			thisYTopBounds = y,						//the y coordinate of the top bounds of the current plot
		//information about the given plot
			plotXRightBounds = plot.x + plot.width, //the x coordinate of the right bounds of the given plot
			plotXLeftBounds = plot.x,				//the x coordinate of the left bounds of the given plot
			plotYBottomBounds = plot.y + plot.depth,//the y coordinate of the bottom bounds of the given plot
			plotYTopBounds = plot.y;				//the y coordinate of the top bounds of the given plot
		
		//if all the boundaries of a plot is within the boundaries of another, a plot is being encompassed, false otherwise
		if(plotYTopBounds >= thisYTopBounds && plotYTopBounds <= thisYBottomBounds)
		{
			if(plotXRightBounds >= thisXLeftBounds && plotXRightBounds <= thisXRightBounds)
			{
				if(plotYBottomBounds >= thisYTopBounds && plotYBottomBounds <= thisYBottomBounds)
				{
					if(plotXLeftBounds >= thisXLeftBounds && plotXLeftBounds <= thisXRightBounds)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/** Gives a string representation of a plot object
	 * @return the string representation
	 */
	public String toString()
	{
		return "X: " + x + "\n" +
			   "Y: " + y + "\n" +
			   "Width: " + width + "\n" +
			   "Depth: " + depth;
	}
}
