/*
|   data               |  examples           |  java data type
|----------------------|---------------------|-----------------
| whole numbers        |  4, -5, 19, 1000, 0 |  int
| decimal numbers      |  3.14, -2.1, 0.0    |  double
| series of characters |  "howdy", "0", "#@" |  String
| one character        |  'a', '@', '?'      |  char
| yes/no               |  true  false        |  boolean
****************************************************************
*/
public class DataAndExpressions
{

	public static void main(String[] args) 
	{
		int bigInteger = Integer.MAX_VALUE;
		System.out.println("Max Integer ="+bigInteger);
		
		int smlInteger = Integer.MIN_VALUE;
		System.out.println("Min Integer ="+smlInteger);
      	
         	
		overflow(bigInteger);	
		
		double bigDecimal = Double.MAX_VALUE;
		System.out.println("Max Decimal ="+bigDecimal);
		
		double smlDecimal = Double.MIN_VALUE;
		System.out.println("Min Decimal ="+smlDecimal);
		
		
		expressions();
		casting();
	}
	
	public static void overflow(int num) 
	{
		System.out.println(num+" + 1 ="+(num+1));
	}
	

	public static void expressions() 
	{
		 System.out.println("A look at expression evaulation: ");

	      System.out.print("4 + 7 * 3 = ");
	      System.out.println( 4 + 7 * 3 );

	      System.out.print("(4 + 7) * 3 = ");
	      System.out.println((4 + 7) * 3 );

	      System.out.print("2 * 3 * 2 + 1 * 9 * 3 = ");
	      System.out.println( 2 * 3 * 2 + 1 * 9 * 3 );

	      System.out.print("105 % 10 - 2 = ");
	      System.out.println(105 % 10 - 2 );
         

	      // unusual behavior compared to python
         // Integer division(drops decimals)occurs if both numbers are integers
         System.out.print("1 / 2 = ");
	      System.out.println( 1 / 2 );

	      System.out.print("1.0 / 2 = ");
	      System.out.println( 1.0 / 2 );    

	      System.out.print("4 + 4 + \"hello\" = ");
	      System.out.println( 4 + 4 + "hello" );

	      System.out.print("\"hello\" + 4 + 4 = ");
	      System.out.println( "hello" + 4 + 4 );
	}
	public static void casting() {
		
		System.out.print("(int) 3.75 = ");
		System.out.println((int) 3.75 );
		
		System.out.print("(double)(1 / 2) = ");
	    System.out.println((double)(1 / 2) );

	    System.out.print("(double) 1 / 2 = ");
	    System.out.println((double) 1 / 2 );
	}
}
