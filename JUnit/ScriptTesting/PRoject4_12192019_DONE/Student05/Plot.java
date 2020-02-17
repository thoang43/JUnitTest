
/**
 * This class is designed to plot properties.
 * 
 *
 */
public class Plot 
{
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1.
	 */
	public Plot() 
	{
		x=0;
		y=0;
		width=1;
		depth=1;
	}
	
	
	/**
	 * Parameterized Constructor
	 * @param x - x coordinates of the upper left corner of the plot location.
	 * @param y - y coordinates of the upper left corner of the plot location.
	 * @param width - represents the horizontal extent of the plot.
	 * @param depth - represents the vertical extent of the plot.
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;	
	}
	
	
	/**
	 * @return x coordinate
	 */
	public int getX() 
	{
		return x;
	}

	
	/**
	 * @param x
	 */
	public void setX(int x) 
	{
		this.x=x;
	}
	
	
	/**
	 * @return
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * @param y
	 */
	public void setY(int y) 
	{
		this.y=y;
	}
	
	/**
	 * @return width
	 */
	public int getWidth() 
	{
		return width;
	}
	
	
	/**
	 * @param width
	 */
	public void setWidth(int width) 
	{
		this.width=width;	
	}
	
	
	/**
	 * @return depth
	 */
	public int getDepth() 
	{
		return depth;
	}
	
	
	/**
	 * @param depth
	 */
	public void setDepth(int depth) 
	{
		this.depth=depth;
	}
	
	
	/**
	 * Determines if the parameter overlaps any of the boundaries of this plot.
	 * @param plot - the parameter to test against this plot.
	 * @return true if the two plots overlap, false otherwise.
	 */
	public boolean overlaps(Plot plot)
	{
		if ( plot.getY() >(this.getY() + this.getDepth()) 
			      || (plot.getY()+plot.getDepth())<=this.getY() ) 
		{
			        return false;
	    }
			    if (plot.getX() >(this.getX() + this.getWidth())
			      ||  (plot.getX() + plot.getWidth())<=this.getX()) 
			    {
			        return false;
			    }
			return true;	
	}
	
	
	/**
	 * Determines if the parameter is encompassed by (is contained by) this plot.
	 * @param plot - the parameter to test against this plot.
	 * @return true if the this plot contains the parameter, false otherwise.
	 */
	public boolean encompassess(Plot plot) 
	{
		if(plot.getX()>=this.getX()&&
				plot.getY()>=this.getY()&&
				(plot.getX()+plot.getWidth())<=(this.getX()+this.getWidth())&&
				(plot.getY()+plot.getDepth())<=(this.getY()+this.getDepth()))
				{
					return true;
				}
				else 
					return false;
	}
	
	
	/**
	 * Displays the x, y width and depth of the plot.
	 * @return the string representing plot information.
	 */
	public String tostring() 
	{
		return "X: " + x + " Y: " + y +" width: " + width + " depth+ " + depth;
		
	}
}
