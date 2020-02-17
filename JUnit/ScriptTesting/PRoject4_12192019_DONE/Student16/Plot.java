import javafx.geometry.Rectangle2D;

public class Plot{
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot(){
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	public Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public String toString(){
		return x + " " + y + " " + width + " " + depth;
	}

	public boolean overlaps(Plot plot){
		Rectangle2D s = new Rectangle2D(this.x, this.y, this.width, this.depth);
		Rectangle2D r = new Rectangle2D(plot.x, plot.y, plot.width, plot.depth);
		return s.intersects(r);
	}
	
	public boolean encompasses(Plot plot){
		Rectangle2D s = new Rectangle2D(this.x, this.y, this.width, this.depth);
		Rectangle2D r = new Rectangle2D(plot.x, plot.y, plot.width, plot.depth);
		return s.contains(r);
	}
}