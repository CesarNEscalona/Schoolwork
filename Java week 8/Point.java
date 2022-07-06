
public class Point {
   // how many instance variables? 2 x and y
	private int x;
	private int y;
	
   // how many constructors? 2
   // Zero Parameter - Default
	public Point() {
		this.x=0;
		this.y=0;
	}
   // Parameterized
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
   // getter method
	public int getX() {
		return this.x;
	}
	public void setX(int xValue) {
		x = xValue;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	// Overriding toString() in Object Class
   // Object class is super class of everything
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
