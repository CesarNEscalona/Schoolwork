 
//logical operator example

public class Logical
{
	public static void main(String args[])
	{
		int one = 5; // primitive data type
		int two = 150;
		
      System.out.println("two % one = "+two % one); 
      // logical AND - with Short Circuit Evaluation will stop
      // evaluating the logical AND compound expression if
      // the first condition is false
		if(one != 0 && two % one == 0)
		{
		   System.out.println(two+" is a multiple of "+one);
		}


      // logical OR - short circuit evaluation will stop
      // evaluating the logical OR compound expression if
      // the first condition is true
		if(one < 6 || two == 200)
		{
		   System.out.println("one = " + one + " two = " + two);
		}
   }  
     	
}
