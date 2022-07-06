//switch case example
public class SwitchCaseTwo
{
	public static void main(String args[])
	{
		String color="RED";
		switch (color.toLowerCase())
		{
		   case "red" :  
             System.out.println("red as a rose");
             
		   case "blue" :  
             System.out.println("blue as the sky");
             break;
		   case "green" :  
             System.out.println("green as the grass");
             break;
		   default : 
             System.out.println("does not equal");
		}
	}
}
