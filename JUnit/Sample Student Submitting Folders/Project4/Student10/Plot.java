
public class Plot {

	//class variables
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	//class constructors
	
	Plot(){
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//class methods
	
	
	 public boolean overlaps(Plot p){
	 
		 return x < p.x + p.width && x + width > p.x && y < p.y + p.depth && y + depth > p.y;
	 
	 }
	
	
	
	 public boolean encompasses(Plot p){
	 
	 
		
		 return x <= p.x && y <= p.y && width >= p.width && depth >= p.depth;
	 
	 }
	
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//needs string
	public String toString() {
		String plot = "x: " + x + "\n" + "y: " + y + "\n" + "width: " + width + "\n" + "depth: " + depth;
		
		return plot;
	}
	
}
