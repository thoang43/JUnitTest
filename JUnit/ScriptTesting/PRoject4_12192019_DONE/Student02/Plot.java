
/**
 * 
 * CMSC 203
 * Assignment 4
 */

/**
 * Data Element class – Plot.java
 * The class Plot will contain:
 * 1.	Instance variables (attributes) to represent the x and y coordinates of the upper left corner of the location, and depth and width to represent the vertical and horizontal extents of the plot.
 * 2.	A toString method to represent a Plot object’s x, y, width and depth of the plot
 * 3.	A no-arg constructors that sets the plot coordinates to default values: x=0, y=0, width=1, depth=1
 * 4.	A parameterized constructor that takes values for x, y, width and depth of the plot
 * 5.	A method named overlaps that takes a Plot instance and determines if it is overlapped by the current plot.
 * 6.	A method named encompasses that takes a Plot instance and determines if the current plot contains it.  Note that the determination should be inclusive, in other words, if an edge lies on the edge of the current plot, this is acceptable.
 * */

 
public class Plot 
{
	//1.	Instance variables (attributes) 
	private int x=0; //x coordinates of the upper left corner of the location
	private int y=0; //y coordinates of the upper left corner of the location
	private int depth=1; //depth to represent the vertical and horizontal extents of the plot
	private int width=1; //width to represent the vertical and horizontal extents of the plot
	
	//3.	A no-arg constructors that sets the plot coordinates to default values: x=0, y=0, width=1, depth=1
	public Plot()
	{
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;		
	}
	
	//4.	A parameterized constructor that takes values for x, y, width and depth of the plot
	public Plot(int x, int y, int width, int depth) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//generated accessor method
	public int getX() 
	{
		return x;
	}
	
	//generated mutator method
	public void setX(int x) 
	{
		this.x = x;
	}
	
	//generated accessor method
	public int getY() 
	{
		return y;
	}
	
	//3. no-arg constructor that sets the plot coordinates to default values: y=0
	public void setY(int y) 
	{
		this.y = y;
	}
	
	//generated accessor method
	public int getDepth() 
	{
		return depth;
	}
	
	//3. no-arg constructor that sets the plot coordinates to default values: depth=1
	public void setDepth(int depth) 
	{
		this.depth = depth;
	}
	
	//generated accessor method
	public int getWidth() 
	{
		return width;
	}
	
	//3. no-arg constructor that sets the plot coordinates to default values: width=1
	public void setWidth(int width) 
	{
		this.width = width;
	}
	
    
	/*public boolean overlapsX(Plot plot)
	{ //takes a Plot instance and determines if it is overlapped by the current plot.
		boolean bRet = false;
	       int ovrlapArea = overlapArea( plot);
	        System.out.println("  Plot 1:" + this.toString() + " overlaps["+ovrlapArea+"] Plot 2: " +plot.toString());

	    if (ovrlapArea > 1) 
	    {
	    	bRet = true;
	    }
	    return bRet;
	   }
    */
	
    //6.	A method named encompasses 
	public boolean encompasses(Plot plot)
	{ //takes a Plot instance and determines if the current plot contains it
		boolean bRet = false;
	       // Area of 1st Rectangle
       int area1 = this.width * this.depth;
     
       // Area of 2nd Rectangle
       int area2 = plot.width * plot.depth;

       int ovrlapArea = overlapArea( plot);

        //The intersecting area will equal area2
		if (ovrlapArea == area2) 
	    {
	       bRet = true;
	       System.out.println("  Plot1: " + this.toString() + " encompasses["+ovrlapArea+"] Plot 2: " +plot.toString());

	    }else {
		   System.out.println("  Plot1: " + this.toString() + " NOT encompasses["+ovrlapArea+"] Plot 2: " +plot.toString());

	    }
	    return bRet;
	   }

	private int overlapArea(Plot plot)
	   {
	   
	    Plot p1 = this;
	    Plot p2 = plot;
	    Point l1 = new Point();
	    Point r1 = new Point();
	    Point l2 = new Point();
	    Point r2 = new Point();
	    
	    l1.x = p1.x;
	    l1.y = p1.y;
	    r1.x = p1.x + p1.width;
	    r1.y = p1.y + p1.depth;
	    
	    l2.x = p2.x;
	    l2.y = p2.y;
	    r2.x = p2.x + p2.width;
	    r2.y = p2.y + p2.depth;
	   

	       // Area of 1st Rectangle
	       int area1 = p1.width * p1.depth;
	     
	       // Area of 2nd Rectangle
	       int area2 = p2.width * p2.depth;
	     
	       // Length of intersecting part i.e  
	       // start from max(l1.x, l2.x) of  
	       // x-coordinate and end at min(r1.x,
	       // r2.x) x-coordinate by subtracting  
	       // start from end we get required  
	       // lengths
	       /*
	       int areaI = (Math.min(p1.x+p1.width, p2.x+p2.width) -  
	               Math.max(p1.x, p2.x)) *  
	              (Math.min(p1.y+p1.depth, p2.y+p2.depth) -
	               Math.max(p1.y, p2.y));
	       */
	       int areaI = (Math.min(r1.x, r2.x) -  
	                    Math.max(l1.x, l2.x)) *  
	                   (Math.min(r1.y, r2.y) -
	                    Math.max(l1.y, l2.y));
	       
	       // Returns Total Area of two overlap rectangles
	       //int ovrlapArea = area1 + area2 - areaI;
	       int ovrlapArea =  areaI ;
	    return ovrlapArea;
	   }
	
	private int overlapAreaX(Plot plot)
	   {
	   
	    Plot p1 = this;
	    Plot p2 = plot;

	       // Area of 1st Rectangle
	       int area1 = p1.width * p1.depth;
	     
	       // Area of 2nd Rectangle
	       int area2 = p2.width * p2.depth;
	     
	       // Length of intersecting part i.e  
	       // start from max(l1.x, l2.x) of  
	       // x-coordinate and end at min(r1.x,
	       // r2.x) x-coordinate by subtracting  
	       // start from end we get required  
	       // lengths
	       int areaI = (Math.min(p1.x+p1.width, p2.x+p2.width) -  
	               Math.max(p1.x, p2.x)) *  
	              (Math.min(p1.y+p1.depth, p2.y+p2.depth) -
	               Math.max(p1.y, p2.y));
	       /*
	       int areaI = (Math.min(r1.x, r2.x) -  
	                    Math.max(l1.x, l2.x)) *  
	                   (Math.min(r1.y, r2.y) -
	                    Math.max(l1.y, l2.y));
	       */
	       // Returns Total Area of two overlap rectangles
	       //int ovrlapArea = area1 + area2 - areaI;
	       int ovrlapArea =  areaI ;
	    return ovrlapArea;
	   }
	

/*public boolean overlapsXX(Plot plot)
{
	   
	    Plot p1 = this;
	    Plot p2 = plot;

	       // Area of 1st Rectangle
	       int area1 = p1.width * p1.depth;
	     
	       // Area of 2nd Rectangle
	       int area2 = p2.width * p2.depth;

    if (((p1.y + p1.depth) < p2.y) 
      || (p1.y > (p2.y + p2.depth))) {
        return false;
    }
    if (((p1.x + p1.width) < p2.x) 
      || (p1.x > p2.x +p2.width) ) {
        return false;
    }
    return true;	     
}	
*/
	
static class Point { 

	int x, y; 
} 


//5.	A method named overlaps that takes a Plot instance 
//Returns true if two rectangles (l1, r1) and (l2, r2) overlap 
//static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) 
 boolean overlaps(Plot plot) 
{ 
	   
    Plot p1 = this;
    Plot p2 = plot;
    Point l1 = new Point();
    Point r1 = new Point();
    Point l2 = new Point();
    Point r2 = new Point();
    
    l1.x = p1.x;
    l1.y = p1.y;
    r1.x = p1.x + p1.width;
    r1.y = p1.y + p1.depth;
    
    l2.x = p2.x;
    l2.y = p2.y;
    r2.x = p2.x + p2.width;
    r2.y = p2.y + p2.depth;
   

	// If one rectangle is on left side of other 
	if (l1.x > r2.x || l2.x > r1.x) { 
		return false; 
	} 

	// If one rectangle is above other 
	if (l1.y < r2.y || l2.y < r1.y) { 
		return false; 
	} 

	return true; 
} 
	//2.	A toString method 
    public String toString() 
	{ //to represent a Plot object’s x, y, width and depth of the plot
		return "Plot [x=" + x + ", y=" + y + ", depth=" + depth + ", width=" + width + "]";
	}
	
}
