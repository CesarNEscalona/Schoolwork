/*    Cesar Escalona
      iT-219
      Assignment: House.Java


*/
import acm.program.*;
import acm.graphics.*;

public class House extends GraphicsProgram {

   //init() is called for us once BEFORE run() is called
   public void init()
   {
     //sets width and height of window in pixels
     setSize(400, 400);
   }

	public void run() {
      //This will add a square that will be the house
		GRect box = new GRect(100,100,200,200);
		this.add(box);
        //This will add a triangle that will be the roof
        GPolygon triangle = new GPolygon();
        triangle.addVertex(100, 100);
        triangle.addVertex(300, 100);
        triangle.addVertex(200, 0);
        this.add(triangle);
	}
    public static void main(String[] args) {
        House h = new House();
        h.start(args);
    }
}