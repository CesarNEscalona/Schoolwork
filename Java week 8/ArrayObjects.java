import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
/*
 * This program uses the acm graphics package to 
   draw boxes(GRects) and animate them 
 */
public class ArrayObjects extends GraphicsProgram {

	public static final int BOX = 50;

   // TODO Create an array of GRect boxes
   private static GRect[] boxes = { new GRect(10,10,BOX,BOX),
                                    new GRect(10,110,BOX,BOX),
                                    new GRect(10,210,BOX,BOX)
                                  };
                                  
	public void init()
   {
      // set the window size to 800 width, 600 height
		this.setSize(800, 600);
		// TODO: Loop through Array of boxes using traditional for loop
      // and add to window 
      for(int i = 0;	i < boxes.length; i++)
      {
          // set color of box to YELLOW
          boxes[i].setColor(Color.YELLOW);
          // set filled to TRUE
          boxes[i].setFilled(true);
          // add to window
          add(boxes[i]);
      }
	}
   // This method animates the boxes and keeps them on the screen
	public void run()
   {
	   while (true)
      {
         // TODO: loop through the array using enhanced for each loop 
         // and move box horizontally
         for(GRect box : boxes)
         {
            box.move(0,0);
            if (box.getX() > this.getWidth())
            {
               // reset location of the box
               box.setLocation(0,box.getY());
            }
         }
         pause(200);
      }
	}

	public static void main(String[] args)
   {
		new ArrayObjects().start();
	}
}