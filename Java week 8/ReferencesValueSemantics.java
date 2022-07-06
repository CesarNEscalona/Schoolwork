import java.util.Arrays;

public class ReferencesValueSemantics {

	public static void main(String[] args) {
		// Primitive Integers - Passed By Value
		int x = 0;
		System.out.println("Before Change: " + x);
		changePrimitiveInt(x);
		System.out.println("After Change?: " + x);
      
		// you can change x by catching the returned integer value into
		// the same variable
		System.out.println("Before Change: " + x);
		x = changePrimitiveInt(x);
		System.out.println("After Change?: " + x);

		// Arrays passed by reference - You can changed the contents
		// You can declare and initialize an array in one statement
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println("Before Change: " + Arrays.toString(array));
		changeArrayInt(array);
		System.out.println("After Change: " + Arrays.toString(array));

		// You can declare and initialize an array as you pass it to a method
		array = changeArrayInt(new int[] { 20, 21, 22, 23, 24 });
		System.out.println("After Change: " + Arrays.toString(array));

		// Class Objects passed by reference - you can change contents
		Point myPoint = new Point(3, 5);
		System.out.println("Before Change: " + myPoint);
		changeObject(myPoint);
		System.out.println("After Change: " + myPoint);

		// But remember Strings are immutable so although they are objects they cannot
		// be changed when passed
		String myString = "Please change me, if you can";
		System.out.println("Before Change: " + myString);
		changeString(myString);
		System.out.println("After Change: " + myString);

		// you can "change" a string reference by catching the returned string
		System.out.println("Before Change: " + myString);
		myString = changeString(myString);
		System.out.println("After Change?: " + myString);

		// TODO: Declare and initialize an Array to hold 2 points with x=3 y=5 and x=8 and y=9
		Point[] points = { new Point(3,5), new Point(8,9) };
      System.out.println("Before :" + Arrays.toString(points));
      changeObject(points);
		System.out.println("After :" + Arrays.toString(points));
	}

	// Primitive integers are passed by value meaning any changes made
	// to the integer can only be seen if you return the int
	public static int changePrimitiveInt(int x) {
		x = 25;
		return x;
	}

	// Arrays are passed by reference meaning any changes made
	// to the array elements can be seen even if you do not return the array
	public static int[] changeArrayInt(int[] arr) {
		// add 1 to each array element
		for (int i = 0; i < arr.length; i++) {
			arr[i] += 1;
		}
		return arr;
	}

	// Class Objects are passed by reference meaning any changes made
	// to the object of the class can be seen even if you do not return the class
	// object
	public static Point changeObject(Point point) {
		// change x and y to 99
		point.setX(99);
		point.setY(99);
		return point;
	}

	//TODO: Change all points in the points arrays to have x=99 and y=99
	public static Point[] changeObject(Point[] points) {
   
      // What would we do here?
      for (Point p : points)
      {
         p.setX(99);
         p.setY(99);
      }
      for (int index = 0; index < points.length; index++)
      {
         points[index].setX(99);
         points[index].setY(99);
      
      }
		return points;
	}

	// Strings Objects are immutable so you cannot change the passed parameter
	// but you can return a new string that is "changed";
	public static String changeString(String s) {
		s = "You are changed!";
		return s;
	}
}
