///switch case example



public class SwitchCaseOne
{
	public static void main(String args[])
	{
		int num = 55;
		switch (num)
		{
		   case 11 :  
             System.out.println("num == 11"); 
             break;
		   case 22 :   
             System.out.println("num == 22");
             break;
		   case 30 :  
             System.out.println("num == 30"); 
             break;
		   case 40 :  
             System.out.println("num == 40"); 
             break;
		   default : 
             System.out.println("does not equal");
             // really no need for a break;
             break;
		}// end of switch
	}
}
