
//nested if example

import java.util.Scanner;

public class NestedIfs
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter an integer :: ");
		int num = kb.nextInt();

		if(num > 50)
		{
		   if(num > 50 && num < 150)
		   {
		   	if(num > 50 && num < 100)
		   	{
		   		System.out.println(num+" > 50 && "+num+" < 100");
		   	} // end if num > 50 && num <100
		   }// end if num>50 && num < 150
		}// end if num>50
		
		
	}
}
